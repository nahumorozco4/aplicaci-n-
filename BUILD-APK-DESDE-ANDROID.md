# Compilar Teyvat Tracker v3 como APK desde el teléfono

Este proyecto incluye un workflow de GitHub Actions que compila el APK en un runner de GitHub, por lo que no necesitas instalar Android Studio, Gradle ni el Android SDK en tu teléfono.

## Opción recomendada: GitHub Actions

1. Crea un repositorio nuevo en GitHub.
2. Sube **todo el contenido** de este proyecto, incluyendo la carpeta `android/` y `.github/workflows/build-apk.yml`.
3. En GitHub abre **Actions** → **Build Teyvat Tracker APK**.
4. Pulsa **Run workflow** si no se inició automáticamente.
5. Espera a que termine el job `build`.
6. Abre la ejecución terminada y busca **Artifacts**.
7. Descarga `Teyvat-Tracker-v3-debug`.
8. Dentro encontrarás `app-debug.apk`; instálalo en Android.

El APK de debug queda firmado para instalación local por el propio sistema de build de Android/Gradle.

## Si GitHub muestra un error

Comprueba que:
- `android/settings.gradle` existe.
- `android/build.gradle` usa AGP 8.6.1.
- `android/app/build.gradle` usa compileSdk/targetSdk 35.
- El workflow está exactamente en `.github/workflows/build-apk.yml`.

El workflow usa JDK 17 y Gradle 8.10.2. AGP 8.6 requiere como mínimo Gradle 8.7 y JDK 17.
