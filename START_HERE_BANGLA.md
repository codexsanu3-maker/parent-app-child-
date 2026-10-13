# ফোন থেকে APK বানানোর সহজ নিয়ম (বাংলা)

এই ZIP-এর ভেতরে `parent-app`, `child-app`, `settings.gradle.kts`, এবং GitHub Actions workflow—সব একই project root-এ আছে।

## প্রথমবার সেটআপ
1. https://github.com/new খুলে GitHub-এ sign in করুন।
2. Repository name দিন `family-safety-apps`; **Public** বা **Private** যেটা চান বাছুন; Create repository চাপুন।
3. Repository-তে **Add file → Upload files** চাপুন। এই ZIP আগে ফোনে Extract করুন, তারপর Extract করা ফোল্ডারের *ভেতরের সব ফাইল ও ফোল্ডার* upload করুন—পুরো parent folder নয়। `.github` ফোল্ডারসহ সবকিছু upload হয়েছে নিশ্চিত করুন।
4. নিচে **Commit changes** চাপুন। `main` branch-এ push হলে workflow নিজে থেকে build শুরু করবে।

## পরেরবার APK বানানো
Repository → **Actions** → **Build Family Safety APKs** → **Run workflow** → **Run workflow**।

## APK কোথায় পাবেন
Actions-এ শেষ হওয়া green build খুলুন। নিচে **Artifacts** থেকে `family-safety-debug-apks` download করুন, ZIP extract করে Parent ও Child APK আলাদা করে ইনস্টল করুন। Android চাইলে install permission অনুমতি দিন।

## জরুরি কথা
- GitHub-এ প্রথমবার project upload ও account sign-in নিজে করতে হবে; নিরাপত্তার কারণে এই ZIP নিজে থেকে আপনার GitHub account-এ upload করতে পারে না।
- এটি debug APK ও starter project; production-ready monitoring app নয়। Remote sync/backend এবং বাস্তব device test এখনো দরকার। দুই ফোনে ইনস্টল করলেই স্বয়ংক্রিয়ভাবে data sync হবে না।
- শুধু স্পষ্টভাবে জানানো, সম্মতিভিত্তিক পারিবারিক নিরাপত্তার জন্য ব্যবহার করুন। লুকানো microphone/recording বা গোপন নজরদারি নেই।
