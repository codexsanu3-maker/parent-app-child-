# Privacy and Google Play readiness checklist

- [ ] Public privacy policy accurately describes every permission, SDK, data category, recipient and retention period.
- [ ] In-app disclosure before any sensitive collection/monitoring.
- [ ] Data Safety form matches the shipped build and backend.
- [ ] Child and parent can see pairing state, active protections, permissions, unlink and delete data.
- [ ] No hidden camera/microphone capture, call recording, SMS/message scraping, or undisclosed tracking.
- [ ] If VPNService is used for web filtering, show a clear explanation and visible status, process only necessary data, and review current Play policy.
- [ ] If Device Owner/Device Admin or AccessibilityService is used, verify policy eligibility, user disclosure, setup/removal and exact API restrictions.
- [ ] Backend enforces auth, per-device authorization, rate limits, pairing expiry, revocation, encrypted transport, secure secret storage, audit events and deletion.
- [ ] Build and run unit tests, lint, dependency checks, UI/instrumentation tests and OEM-specific tests.
- [ ] Test offline mode, network loss, permission denial, reboot, app update, battery saver, timezone changes, process death, account logout and device unlink.
- [ ] Use Play App Signing; keep upload key and backend secrets out of source control.
- [ ] Review current Google Play policy and target SDK requirements immediately before submission.
- [ ] Do not promise universal compatibility, zero bugs, or guaranteed approval.
