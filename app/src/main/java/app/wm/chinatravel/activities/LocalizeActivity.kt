package apps.wm.flight.transffer.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


open class LocalizeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.layout_actionbar)

        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration

      /*  val savedLanguage = AppPreferences.getInstance(this).getFromPreference(Keys.KEY_LANGUAGE)

        AppSession.userToken = AppPreferences.getInstance(this).getFromPreference(Keys.KEY_TOKEN)
        AppSession.deviceId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)

        if (savedLanguage != null) {
            if (savedLanguage == "en") {
                conf.setLocale(Locale("en"))
                AppSession.locale = "en"
                AppSession.isLocaleEnglish = true
            } else if (savedLanguage == "ar") {
                conf.setLocale(Locale("ar"))
                AppSession.locale = "ar"
                AppSession.isLocaleEnglish = false
            } else {
                conf.setLocale(Locale("en"))
                AppSession.locale = "en"
                AppSession.isLocaleEnglish = true
            }
            res.updateConfiguration(conf, dm)
        }
    }


    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {

        val v = currentFocus

        if (v != null &&
                (ev.action == MotionEvent.ACTION_UP || ev.action == MotionEvent.ACTION_MOVE) &&
                v is EditText &&
                !v.javaClass.name.startsWith("android.webkit.")) {
            val scrcoords = IntArray(2)
            v.getLocationOnScreen(scrcoords)
            val x = ev.rawX + v.left - scrcoords[0]
            val y = ev.rawY + v.top - scrcoords[1]

            if (x < v.left || x > v.right || y < v.top || y > v.bottom)
                AppUtils.getInstance().hideKeyboard(this)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_left)
    }*/
}   }