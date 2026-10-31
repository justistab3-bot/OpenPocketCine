package com.opencapture.openpocketcine.pairing

import java.util.Locale

/**
 * This app's own pairing lines, in every language it ships, keyed by the English text.
 *
 * The key is the English string, so an edited line stops matching and the operator reads English.
 */
internal object AppPairingCopy {
    private val simplifiedChinese: Map<String, String> = mapOf(
        "Turn the camera on and keep the phone nearby. Pocket and Nano both appear. Choose the one you want." to
            "打开相机，把手机放在旁边。Pocket 和 Nano 都会出现，选择你要的那台。",
        "Turn off DJI Frame Tap and force quit DJI Mimo on every phone near the camera." to
            "关掉 DJI Frame Tap，并让相机附近每台手机上的 DJI Mimo 强制退出。",
        "Before pairing, turn off DJI Frame Tap and force quit DJI Mimo." to
            "配对前请关掉 DJI Frame Tap，并让 DJI Mimo 强制退出。",
        "Make sure the camera is on and activated, then move closer." to
            "确认相机已开机并已激活，然后靠近一点。",
    )

    private val tables: Map<String, Map<String, String>> = mapOf("zh" to simplifiedChinese)

    /** [english] in the phone's language, or [english] itself when there is no row. */
    fun text(english: String): String {
        val tag = Locale.getDefault().language
        val table = tables[tag] ?: return english
        return table[english] ?: english
    }
}
