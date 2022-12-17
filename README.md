## Wordle Coach App

### About

- Please note that full documentation can be found in the "Documentation" directory of this repository.

The wordle coach app is an Android app designed to help the user learn to play the game 
[Wordle](https://www.nytimes.com/games/wordle/index.html). As the user makes guesses in a Wordle game and receives
feedback on which letters are in the Wordle word of the day and which are not, they enter this information into the
Wordle Coach app. The app then presents suggested words with the highest chance of being the wordle of the day.
Detailed game play instructions can be found by clicking the help button in the bottom right corner of the Wordle Coach
app.

### Getting Started

The app is not available on any app stores and is not available as an APK at this time. To install and run, please 
install an up-to-date version of Android Studio, along with an Android SDK with API version 32 or 33. Once these
components are installed, clone this repository to your machine and open it in Android studio. The project uses Gradle
to manage dependencies and automate the build process. Once the project has loaded (restarting android studio may be
required), ensure that "App" is selected as the run configuration. Click the "Build Project" button to test the build
process.

### Installation
The app is designed to be run on phones and can be installed on a device emulator, or a physical Android device. To 
install on an emulator, open the device manager, select virtual device and click "Create device". The setup wizard will
walk you through selecting and creating a device. To install on physical device via a USB cable, enable USB debugging
on the device, then connect the device to a USB port on your computer. To install on physical device via Wifi, enable
Wi-Fi debugging on the device, then select "Pair devices using Wi-Fi" on the device manager. The pairing wizard will
walk you through pairing the device.

Once the appropriate device is selected, click the run button and the app will build, install, then launch on the device.
Once the app has launched, it has successfully installed on the device. If the device is physical, it can be 
disconnected from the host computer and debugging can de disabled.

### Source Code
The source code for the App is composed of XML and Java. The XML files which define the UI elements can be found in
./app/src/main/res/, with the main screen's layout defined in ./app/src/main/res/layout/. The Java classes which implement
the behavior of the App can be found in ./app/src/main/java/com/example/testactivity/.

The python prototype, written by [James Kirk](https://github.com/Jkirk2), can be found in ./Python_Prototype.