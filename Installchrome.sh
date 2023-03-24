name: Selenium Java CI
on: [push]
jobs:
  build:
    runs-on: ubuntu-latest # Using linux machine
    steps:
    - uses: actions/checkout@v2 # Checkout the code
    - name: Set up JDK 1.8
      uses: actions/setup-java@v1 # Setup JAVA
      with:
        java-version: 1.8
    - name: Install Google Chrome # Using shell script to install Google Chrome
      run: |
       chmod +x ./InstallChrome.sh
        ./InstallChrome.sh
    - name: Grant execute permission for gradlew
      run: chmod +x gradlew # give permission to Gradle to run the commands
    - name: Build with Gradle
      continue-on-error: true
      id: sanityTest
      run: ./gradlew test --info # Run our tests using Gradle
    - name: Send email report
      if: steps.sanityTest.outcome != 'success'
      uses: dawidd6/action-send-mail@v2
      with:
        server_address: smtp.gmail.com
        server_port: 465
        username: ${{secrets.EMAIL_USERNAME}}
        password: ${{secrets.EMAIL_PASSWORD}}
        subject: Automated Test Report
        body: |
          Hi,
          Please find attached the automated test report.
        from: Github Actions
        to: tasnim@techeureka.com
        content_type: text/html
          # Optional converting Markdown to HTML (set content_type to text/html too):
        convert_markdown: true
