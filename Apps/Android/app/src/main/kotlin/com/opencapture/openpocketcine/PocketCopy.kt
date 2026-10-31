package com.opencapture.openpocketcine

import android.content.Context
import android.content.res.Configuration
import com.opencapture.monitorui.CopyCatalog
import com.opencapture.monitorui.CopyLanguage
import java.util.Locale

/** App-owned display copy. Camera names, network names and wire values are never translated. */
private val pocketCatalog = CopyCatalog(
    mapOf(
        "Setting not available" to "此设置不可用",
        "Channel" to "声道",
        "Wind" to "风噪抑制",
        "Direction" to "收音方向",
        "Vocal" to "人声增强",
        "Audio control refused" to "无法更改音频设置",
        "Turn the camera on and keep the phone nearby. Pocket and Nano both appear. Choose the one you want." to "打开相机并将手机放在附近。Pocket 和 Nano 都会显示，请选择要连接的相机。",
        "If the camera shows Approve, tap it on that camera's screen. First-time pairing can wait up to 90 seconds." to "如果相机显示配对确认提示，请在相机屏幕上确认。首次配对最多可能需要 90 秒。",
        "We read the camera's network over Bluetooth, then join its Wi-Fi for you." to "通过蓝牙读取相机网络信息，然后自动加入相机的 Wi-Fi。",
        "Exposure, LUTs and scopes go live as soon as the video link is up." to "视频连接建立后，即可使用曝光控制、LUT 和示波器。",
        "Look for an Approve / pairing prompt" to "留意相机上的确认或配对提示",
        "Tap it on the camera screen" to "在相机屏幕上点击确认",
        "Leave the camera on. It brings up its own Wi-Fi" to "保持相机开启，等待相机启动自身的 Wi-Fi",
        "On 5.8 GHz that can take about a minute; we keep trying" to "5.8 GHz Wi-Fi 可能需要约一分钟启动，应用会持续尝试连接",
        "Open Settings" to "打开设置",
        "Turn Bluetooth on" to "开启蓝牙",
        "Nearby devices" to "附近的设备",
        "Location" to "位置信息",
        "Allow nearby devices" to "允许访问附近的设备",
        "Allow location" to "允许访问位置信息",
        " · unverified" to " · 未验证",
        "Needs approval on the camera" to "请在相机上确认",
        "Camera control speaks DUML over Bluetooth and the camera's Wi-Fi. No DJI SDK is bundled or required." to "通过蓝牙和相机 Wi-Fi，使用 DUML 协议控制相机。无需安装 DJI SDK，应用也未内置该 SDK。",
        "DJI Black" to "DJI 黑色",
        "How you can use OpenPocketCine." to "了解 OpenPocketCine 的使用条款。",
        "Imported looks land here. Auto stays on Built-in or DJI." to "导入的 LUT 显示在此处。“自动”使用内置或 DJI 的 LUT。",
        "No matching look for this color / camera" to "没有适用于当前色彩模式或相机的 LUT",
        "Official DJI Rec.709 cube" to "DJI 官方 Rec.709 LUT",
        "Official DJI looks for this color / camera" to "适用于当前色彩模式或相机的 DJI 官方 LUT",
        "Exposure" to "曝光",
        "WB" to "白平衡",
        "Format" to "格式",
        "Color" to "色彩",
        "Mode" to "拍摄模式",
        "Audio" to "音频",
        "Focus" to "对焦",
        "Camera settings" to "相机设置",
        "Close camera settings" to "关闭相机设置",
        "Reconnect this camera before changing settings." to "请重新连接此相机后再更改设置。",
        "Camera settings are available when its connection is ready." to "相机连接就绪后即可更改设置。",
        "Camera" to "相机",
        "Returning cameras to their Wi-Fi…" to "正在将相机恢复到各自的 Wi-Fi…",
        "Try experimental shared Wi-Fi · Preview unavailable" to "尝试实验性共享 Wi-Fi · 暂无预览",
        "Multiview" to "多机位监看",
        "OK" to "确定",
        "Close anyway" to "仍然关闭",
        "Cancel" to "取消",
        "Shared Wi-Fi" to "共享 Wi-Fi",
        "Could not connect. Try again." to "无法连接，请重试。",
        "Connection needs attention" to "连接异常，请检查",
        "Restoring picture…" to "正在恢复画面…",
        "Waiting for picture…" to "正在等待画面…",
        "SHUTTER" to "快门",
        "FOCUS" to "对焦",
        "Auto" to "自动",
        "WAIT" to "请稍候",
        "HOLD" to "画面保持",
        "STBY" to "待机",
        "Try experimental shared Wi-Fi" to "尝试实验性共享 Wi-Fi",
        "Reconnect" to "重新连接",
        "Remove" to "移除",
        "Remove this tile to enable Record all for your other cameras." to "移除此画面后，即可对其他相机使用全部录制。",
        "Open Live View" to "打开实时监看",
        "Stop recording" to "停止录制",
        "Start recording" to "开始录制",
        "Disable Auto LUT" to "关闭自动 LUT",
        "Enable Auto LUT" to "启用自动 LUT",
        "Remove camera" to "移除相机",
        "Before pairing, turn off DJI Frame Tap and force quit DJI Mimo." to "配对前，请关闭 DJI Frame Tap，并强制退出 DJI Mimo。",
        "White" to "白色",
        "Amber" to "琥珀色",
        "Red" to "红色",
        "Cyan" to "青色",
        "Green" to "绿色",
        "Blue" to "蓝色",
        "Close" to "关闭",
        "Add camera" to "添加相机",
        "Auto LUT" to "自动 LUT",
        "Check the network name and password." to "请检查网络名称和密码。",
        "Could not save camera Wi-Fi cleanup. Try again." to "无法保存相机 Wi-Fi 恢复信息，请重试。",
        "Camera Wi-Fi could not be restored. Keep it powered on and close Multiview to retry." to "无法恢复相机 Wi-Fi。请保持相机开启，关闭多机位监看后重试。",
        "Multiview preview is not available for this camera model yet." to "此相机型号暂不支持多机位预览。",
        "Connecting · approve on camera" to "正在连接 · 请在相机上确认",
        "Waking camera Wi-Fi" to "正在唤醒相机 Wi-Fi",
        "The Nano did not confirm its Wi-Fi wake. Keep it powered on and try again." to "Nano 未确认 Wi-Fi 已唤醒。请保持相机开启后重试。",
        "Could not connect" to "无法连接",
        "Could not connect preview" to "无法连接预览",
        "Could not restore preview. Tap Reconnect to try again." to "无法恢复预览，请点击“重新连接”重试。",
        "Could not find this camera on the shared Wi-Fi. Check that both devices use the same network and that client isolation is off, then tap Reconnect." to "在共享 Wi-Fi 上找不到此相机。请确认两台设备连接同一网络，并关闭客户端隔离，然后点击“重新连接”。",
        "Camera discovery returned an unavailable address. Tap Reconnect to search again." to "搜索到的相机地址不可用，请点击“重新连接”再次搜索。",
        "Connecting normal preview" to "正在连接标准预览",
        "This network connection did not identify the selected camera." to "当前网络连接未能识别所选相机。",
        "Wi-Fi join verified · Preview not supported yet" to "已确认加入 Wi-Fi · 暂不支持预览",
        "Waiting for video" to "正在等待视频",
        "Shared network unavailable. Rejoin it, then reconnect this camera." to "共享网络不可用。请重新加入网络，然后重新连接此相机。",
        "Reconnecting…" to "正在重新连接…",
        "Some cameras could not return to their own Wi-Fi. Keep them powered on and close Multiview again to retry." to "部分相机未能恢复各自的 Wi-Fi。请保持相机开启，再次关闭多机位监看以重试。",
        "Live · Video mode" to "实时画面 · 视频模式",
        "Each camera will join %s. Approve on the camera if asked." to "每台相机都将加入 %s。如相机提示确认，请在相机上操作。",
        "%s preview" to "%s 预览",
        "Close Multiview and return cameras to their own Wi-Fi? Recording continues." to
            "关闭多机位监看并将相机恢复到各自的 Wi-Fi？相机会继续录制。",
        "Close monitoring" to "关闭监看",
    ),
    CopyLanguage.SIMPLIFIED_CHINESE,
)

internal fun pocketUsesChinese(): Boolean = CopyLanguage.preferred() == CopyLanguage.SIMPLIFIED_CHINESE

internal fun pocketText(english: String): String {
    if (!pocketUsesChinese()) return english
    // This is a camera-discovery progress value, not an identifier or a network name.
    if (english.startsWith("Finding camera on Wi-Fi · ") && english.endsWith(" of 2")) {
        val attempt = english.removePrefix("Finding camera on Wi-Fi · ").removeSuffix(" of 2").toIntOrNull()
        if (attempt != null) return "正在 Wi-Fi 上搜索相机 · 第 $attempt 次，共 2 次"
    }
    return pocketCatalog.text(english, CopyLanguage.SIMPLIFIED_CHINESE)
}

internal fun pocketFormat(english: String, vararg arguments: Any?): String =
    String.format(Locale.getDefault(), pocketText(english), *arguments)

/** Dedicated Chinese build: change this app's context and process defaults, never system settings. */
internal fun Context.pocketChineseContext(): Context {
    val language = Locale.forLanguageTag("zh-CN")
    Locale.setDefault(language)
    val localized = Configuration(resources.configuration)
    localized.setLocale(language)
    localized.setLayoutDirection(language)
    return createConfigurationContext(localized)
}
