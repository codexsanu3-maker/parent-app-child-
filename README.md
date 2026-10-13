# Family Safety — Dual Android Apps (Advanced Starter)

Two separate Android Studio applications:
- `parent-app`: parent dashboard / device pairing UI
- `child-app`: child companion UI / visible setup status

This is an engineering starter, **not a finished monitoring product**. It has not been built or tested on real devices in this environment. It does not contain a production backend, live cross-device sync, DNS/VPN filtering, location tracking, call control, remote app suspension, or Device Owner provisioning.

## Design principles
- Clear parent/child roles and visible setup state.
- No hidden microphone, camera, call recording, message scraping, or covert surveillance.
- Child device requires a local setup step and appropriate permissions for supported features.
- Remote control requires a secure backend; local Android apps cannot securely communicate over the internet by themselves.
- Collect the minimum data needed; document all sensitive permissions before adding them.

## Toolchain
Android Studio with JDK 17 and Android SDK Platform 36. Each app uses Kotlin, Android Gradle Plugin, and target SDK 36 with min SDK 26. If your installed Android Studio uses a newer compatible toolchain, update Gradle wrapper + AGP + Kotlin plugin as a tested set.

## Open/build
Open this directory in Android Studio. Import the project and run Gradle sync. Run:
- `gradle :parent-app:testDebugUnitTest :child-app:testDebugUnitTest`
- `gradle :parent-app:assembleDebug :child-app:assembleDebug`

The official Gradle wrapper is intentionally not included; generate it through a verified Gradle installation in Android Studio or add a checked official wrapper before CI/release.

## What must be implemented before production
1. Backend API and database with account authentication, child-device pairing codes, revocation, rate limiting, audit trail, secure transport, and key management.
2. App-to-backend sync and offline/error/retry handling.
3. Adult content protection using a maintained policy feed with a visible `VpnService` or family-safe DNS setup, clear disclosure and fail-safe tests. This starter's domain helper is only an example matcher.
4. Parent and child UI for permissions, disclosure, data access, deletion and unlinking.
5. Real-device tests across Android versions and OEMs, lint, dependency scanning, accessibility/UI tests, staged rollout.
6. Google Play policy review, Data safety declarations, privacy policy, target audience/content rating and Play App Signing.

## Call control caveat
Android does not provide a universal third-party API to control all SIM and internet calls. Do not promise remote call termination or two-sided call recording across all devices. Only add specific call features after confirming supported APIs, permissions, device/OEM support and Play policy.
