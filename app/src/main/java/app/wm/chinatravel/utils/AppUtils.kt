

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Typeface
import android.net.ConnectivityManager
import android.provider.Settings
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import app.wm.chinatravel.R
import com.squareup.picasso.Picasso


import java.text.SimpleDateFormat



class AppUtils {

    private var dialog: Dialog? = null

    fun showProgress(activity: Activity): Dialog {

        val overlayDialog = Dialog(activity, android.R.style.Theme_Panel)
        overlayDialog.setContentView(R.layout.dialog_progress)
        overlayDialog.setCanceledOnTouchOutside(false)

        if (!activity.isFinishing) {
            overlayDialog.show()
        }

        return overlayDialog
    }

    fun hideProgress(overlayDialog: Dialog) {
        if (overlayDialog.isShowing) {
            overlayDialog.dismiss()
        }
    }

    fun showToast(activity: Activity?, message: String, isError: Boolean) {
        if (activity != null) {
            val toast = Toast(activity)

            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER.toFloat())
            val textView = TextView(activity)
            textView.setPadding(15, 15, 15, 15)
            textView.setTypeface(textView.typeface, Typeface.BOLD)
            textView.setTextColor(activity.resources.getColor(R.color.colorWhite))
            textView.text = message
            if (isError)
                textView.setBackgroundColor(activity.resources.getColor(R.color.colorRed))
            else
                textView.setBackgroundColor(activity.resources.getColor(R.color.colorAccent))
            textView.layoutParams = params

            toast.view = textView
            toast.duration = Toast.LENGTH_LONG
            toast.show()
        }
    }

    fun isInternetOn(activity: Activity, fragment: Fragment, requestCode: Int): Boolean {

        var flag = false
        // get Connectivity Manager object to check connection
        val connec = activity.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        if (connec.getNetworkInfo(0).state == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(1).state == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(0).state == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).state == android.net.NetworkInfo.State.CONNECTED) {

            flag = true

        } else if (connec.getNetworkInfo(0).state == android.net.NetworkInfo.State.DISCONNECTED || connec.getNetworkInfo(1).state == android.net.NetworkInfo.State.DISCONNECTED) {

            dialogInternet(activity, fragment, requestCode)
            flag = false
        }
        return flag
    }

    private fun dialogInternet(activity: Activity, fragment: Fragment?, requestCode: Int) {
        if (dialog != null && dialog!!.isShowing)
            dialog!!.dismiss()

        val ad = AlertDialog.Builder(activity)
        ad.setTitle(activity.getString(R.string.noConnection))
        ad.setMessage(activity.getString(R.string.turnOnInternet))
        //        ad.setCancelable(false);
        ad.setNegativeButton(activity.getString(R.string.mobileData)) { dialog, which ->
            val i = Intent(Settings.ACTION_DATA_ROAMING_SETTINGS)
            if (fragment == null) {
                activity.startActivityForResult(i, requestCode)
            } else {
                fragment.startActivityForResult(i, requestCode)
            }
        }
        ad.setPositiveButton(activity.getString(R.string.Wifi)) { dialog, which ->
            val i = Intent(Settings.ACTION_WIFI_SETTINGS)
            if (fragment == null) {
                activity.startActivityForResult(i, requestCode)
            } else {
                fragment.startActivityForResult(i, requestCode)
            }
        }
        dialog = ad.show()
    }

    fun hideKeyboard(activity: Activity?) {
        if (activity != null && activity.currentFocus != null && activity.currentFocus!!.windowToken != null) {
            val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            try {
                inputMethodManager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
            } catch (ignored: NullPointerException) {

            }

        }
    }

    companion object {

        var originalDate = SimpleDateFormat("yyyy-MM-dd")
        var originalTime = SimpleDateFormat("hh:mm:ss")
        var targetDate = SimpleDateFormat("MM/dd/yyyy")
        var targetTime = SimpleDateFormat("hh:mm a")
        var targetYear = SimpleDateFormat("MMMM yyyy")

        private var mInstance: AppUtils? = null

        val instance: AppUtils
            get() {
                if (mInstance == null) {
                    mInstance = AppUtils()
                }
                return mInstance!!
            }

        fun loadImageCrop(activity: Activity, url: String?, imageView: ImageView, placeHolder: Int, targetHeight: Int, targetWidth: Int) {
            //        System.out.println("IMAGE URL IS= " + url);
            if (url != null && !url.isEmpty() && !url.equals("null", ignoreCase = true)) {
                Picasso.get().load(url).resize(targetWidth, targetHeight).centerCrop().placeholder(placeHolder).into(imageView)
            } else {
                Picasso.get().load(placeHolder).resize(targetWidth, targetHeight).centerCrop().into(imageView)
            }
        }

        fun loadImageInside(activity: Activity, url: String?, imageView: ImageView, placeHolder: Int, targetHeight: Int, targetWidth: Int) {
            //        System.out.println("IMAGE URL IS= " + url);
            if (url != null && !url.isEmpty() && !url.equals("null", ignoreCase = true)) {
                Picasso.get().load(url).resize(targetWidth, targetHeight).centerInside().placeholder(placeHolder).into(imageView)
            } else {
                Picasso.get().load(placeHolder).resize(targetWidth, targetHeight).centerInside().into(imageView)
            }
        }

        fun setText(textView: TextView, text: String?, defaultText: String) {
            if (text != null && !text.isEmpty() && !text.equals("null", ignoreCase = true)) {
                textView.text = text
            } else {
                textView.text = defaultText
            }
        }
    }

}
