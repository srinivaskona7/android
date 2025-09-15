Here’s a ready-to-paste README.md for your app:

```markdown
# Hello World Options (Android) — com.srinivaskona

A modern Android app showcasing:
- Language “Hello World” snippets (Shell, Python, Java)
- Trigonometry quick problems with solutions
- Personal greeting
- Dribbble-inspired UI with Material 3, cards, icons, and subtle animations

## Features
- Programming snippets: Shell, Python, Java
- Trigonometry: sin(30°), cos(60°), tan(45°) with explanations
- Greeting: “Hello Srinivas sir”
- Material 3 design, card-based layout, custom vector icons
- Smooth transitions and button animations

## Tech Stack
- Kotlin, Android SDK
- Material Components (Material 3)
- Gradle (KTS)
- Min SDK 24, Target/Compile SDK 36
- Package: `com.srinivaskona`

## Requirements
- Android SDK installed locally
- Java 11 (Gradle config uses Java 11)
- Gradle Wrapper (included)

Set SDK path locally (per repo):
```bash
echo "sdk.dir=$HOME/Library/Android/sdk" > local.properties  # macOS default
# or
echo "sdk.dir=$HOME/Android/Sdk" > local.properties          # alternate
```

## Build Commands

- Clean:
```bash
./gradlew clean
```

- Build Debug APK:
```bash
./gradlew assembleDebug
# Output: app/build/outputs/apk/debug/app-debug.apk
```

- Build Release AAB (for Play Console):
```bash
./gradlew bundleRelease
# Output: app/build/outputs/bundle/release/app-release.aab
```

- Build Debug AAB (rarely needed):
```bash
./gradlew bundleDebug
# Output: app/build/outputs/bundle/debug/app-debug.aab
```

## Run (Install Debug)
With a device/emulator connected:
```bash
./gradlew installDebug
```

## Signing for Release
If you haven’t configured signingConfigs yet:
1. Create a keystore (example):
```bash
keytool -genkeypair -v -keystore my-release-key.jks -alias release -keyalg RSA -keysize 2048 -validity 10000
```
2. In `app/build.gradle.kts`, configure:
```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file("my-release-key.jks")
            storePassword = System.getenv("STORE_PASSWORD")
            keyAlias = "release"
            keyPassword = System.getenv("KEY_PASSWORD")
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }
}
```
3. Set env vars (or use Gradle properties):
```bash
export STORE_PASSWORD=your_store_password
export KEY_PASSWORD=your_key_password
```
4. Build:
```bash
./gradlew bundleRelease
```

## Project Structure (high-level)
```
app/
  src/
    main/
      java/com/srinivaskona/MainActivity.kt
      res/layout/activity_main.xml
      res/values/{strings.xml, colors.xml, themes.xml}
      AndroidManifest.xml
```

## Troubleshooting
- SDK path error: ensure `local.properties` exists with `sdk.dir=...`
- R reference errors: remove stale files under old packages (e.g., `com/example/...`)
- ADB not found: install Platform Tools and add to PATH or use Android Studio Run

## License
MIT (or update to your preferred license)
```

You can tweak names/sections as needed.
