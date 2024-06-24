package app.wm.chinatravel.utils

import android.util.Patterns
import java.util.regex.Pattern

/**
 * Created by webmazix on 6/18/2018.
 */
class RegExp {
    var EMPTY_TEXT = "^(?!\\s*$).+"
    var MOBILE_NUMBER = "^\\d{8,10}$"
    var NAME = "^[a-zA-Z ]*$"
    // public static String PASSWORD = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,20})";
    var PASSWORD = "(.{6,20})"

    var EMAIL_ADDRESS = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"

    fun isValidEmail(email: String): Boolean {
        println("Email VAlidation")
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            println("Email Valid")
            return true
        } else {
            println("Email InValid")
            return false
        }
    }

    fun isValidNAME(email: String): Boolean {
        println("Email VAlidation")
        if (Pattern.compile(NAME).matcher(email).matches()) {
            println("Email Valid")
            return true
        } else {
            println("Email InValid")
            return false
        }
    }

    fun isValidPASSWORD(password: String): Boolean {
        println("Password VAlidation")
        if (Pattern.compile(PASSWORD).matcher(password).matches()) {
            println("Password Valid")
            return true
        } else {
            println("Password InValid")
            return false
        }
    }

    fun isValidPhone(phone: String): Boolean {
        println("Phone VAlidation")
        if (Pattern.compile(MOBILE_NUMBER).matcher(phone).matches()) {
            println("Mobile Valid")
            return true
        } else {
            println("Mobile InValid")
            return false
        }
    }

    fun chkEmpty(`object`: String): Boolean {
        if (`object`.trim { it <= ' ' }.isEmpty()) {
            println("Is Empty")
            return true
        } else {
            println("Is UnEmpty")
            return false
        }
    }

    fun chkNull(`object`: Any?): Boolean {
        return if (`object` == null) {
            true
        } else {
            false
        }
    }

}