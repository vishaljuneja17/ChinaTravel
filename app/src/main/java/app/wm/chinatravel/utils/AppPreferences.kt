package app.wm.chinatravel.utils

import android.content.Context
import android.content.SharedPreferences
import app.wm.chinatravel.R
import app.wm.chinatravel.modal.UserModel
import com.google.gson.Gson

/**
 * Created by webmazix on 6/18/2018.
 */
class AppPreferences private constructor(){
    private var mInstance: AppPreferences? = null
    private var mPreferences: SharedPreferences? = null
    private var mEditor: SharedPreferences.Editor? = null


    fun getInstance(context: Context): AppPreferences {
        if (mInstance == null) {
            mInstance = AppPreferences()
        }
        if (mPreferences == null) {
            mPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
            mEditor = mPreferences!!.edit()
        }
        return mInstance as AppPreferences
    }

    fun saveInPreference(key: String, value: String) {
        mEditor!!.putString(key, value)
        mEditor!!.commit()
    }

    fun getFromPreference(key: String): String {
        return mPreferences!!.getString(key, "")
    }

    fun saveInPreference(key: String, value: Boolean) {
        mEditor!!.putBoolean(key, value)
        mEditor!!.commit()
    }

    fun getBooleanFromPreference(key: String): Boolean {
        return mPreferences!!.getBoolean(key, false)
    }

    //UserModel Details--------

    fun saveUserDetails(userModel: UserModel) {
        mEditor!!.putString(Keys.KEY_USER_JSON_DETAILS, Gson().toJson(userModel))
        mEditor!!.commit()
    }

    fun getUserDetails(): UserModel? {
        val userJson = mPreferences!!.getString(Keys.KEY_USER_JSON_DETAILS, "")
        var userModel: UserModel? = null
        if (userJson != null && userJson != "") {
            userModel = Gson().fromJson(userJson, UserModel::class.java)
        }
        return userModel
    }

    fun clearUserDetails() {
        mEditor!!.putString(Keys.KEY_USER_JSON_DETAILS, "")
        mEditor!!.commit()
    }

    //----------

    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        mEditor!!.putBoolean(Keys.KEY_IS_FIRST_TIME_LAUNCH, isFirstTime)
        mEditor!!.commit()
    }

    fun isFirstTimeLaunch(): Boolean {
        return mPreferences!!.getBoolean(Keys.KEY_IS_FIRST_TIME_LAUNCH, true)
    }


    fun isAutoLogin(): Boolean {
        val userJson = mPreferences!!.getString(Keys.KEY_USER_JSON_DETAILS, "")
        var userModel: UserModel? = null
        if (userJson != null && userJson != "") {
            userModel = Gson().fromJson(userJson, UserModel::class.java)
            return if (userModel != null) {
                true
            } else {
                false
            }
        } else {
            return false
        }
    }

    companion object {




    }

}
