package com.opencapture.openpocketcine

import com.opencapture.opencine.cameracontrols.MonitorLegalDocument
import com.opencapture.opencine.cameracontrols.MonitorLegalDocuments
import com.opencapture.opencine.cameracontrols.MonitorPlatformLegalNotices
import com.opencapture.opencine.cameracontrols.MonitorSettingsCopy

private val PRIVACY_BODY =
    if (pocketUsesChinese()) """
OpenPocketCine 通过蓝牙和相机自身的 Wi-Fi 与你的 Osmo Pocket 通信。应用无需账号。自动错误报告为可选功能，默认关闭。

OpenCapture 是数据控制者。如需咨询隐私问题或请求删除数据，请联系 support@openpocketcine.app。

${MonitorSettingsCopy.reliabilityReportsPrivacy}

主动反馈问题
点击“发送报告”后，“反馈问题”会通过 Sentry 将你填写的描述和可选的回复邮箱发送给 OpenCapture。仅在你选择时才附带技术详情，发送前可以查看。你可以选择最多三张照片或截图，并在发送前查看或移除。所选图片会调整尺寸并重新编码，不包含原始文件名或位置元数据。请仅分享你有权发送的图片；应用不会自动附带图片。单次反馈不会开启自动报告。尚未发送的报告仅保存在本机私有存储中，7 天后过期（应用下次运行时移除）；报告会等到你离开相机 Wi-Fi 后再发送，你也可以在发送前移除。请勿在消息中包含密码或其他敏感信息。

保存在本机的数据
• 已保存的相机名称和上次使用的 SSID。相机 Wi-Fi 密码仅保存在本机的 Android Keystore 中。
• 操作偏好，例如屏幕常亮设置和上次使用的 LUT。
• 你选择导入的 .cube 文件。

不会离开本地连接的数据
• 实时 HEVC 视频、DUML 遥测和配对通信仅通过本地连接传输。我们不运营云端服务。

第三方
• Google 可能依据其自身政策处理权限提示和操作系统诊断信息。Play 测试版可能依据 Google 条款向开发者发送崩溃报告。
• 保存片段或使用系统分享面板由你主动发起，之后由 Android 或你选择的应用处理该文件。
• AF-C 人脸框由本机根据实时预览计算，人脸几何数据不会上传。
• 源代码位于 github.com/erik-sutton95/OpenPocketCine。

Android 可能要求位置权限，以便应用加入相机 Wi-Fi 或扫描蓝牙低功耗设备。OpenPocketCine 不会将此权限用于地图、广告或位置历史记录。

完整隐私政策：https://openpocketcine.app/privacy/
    """.trimIndent() else
    """
OpenPocketCine talks to your Osmo Pocket over Bluetooth and the camera's own Wi-Fi. The app has no account. Automatic error reports are optional and off by default.

OpenCapture is the data controller. Privacy or deletion requests: support@openpocketcine.app.

${MonitorSettingsCopy.reliabilityReportsPrivacy}

Reporting a problem yourself
Report a problem sends your description and any optional reply email to OpenCapture through Sentry when you tap Send report. Technical details are included only if you choose them and can be reviewed first. You can choose up to three photos or screenshots and review or remove them before sending. Selected images are resized and re-encoded without original filenames or location metadata. Only share images you have permission to send; no images are attached automatically. This one-off submission does not enable automatic reports. Unsent reports stay privately on this phone, expire after 7 days (removed when the app next runs), wait until you leave camera Wi-Fi, and can be removed before delivery. Do not include passwords or other sensitive information in your message.

What stays on this phone
• Saved camera names and last SSID. The camera Wi-Fi password is stored in the Android Keystore on this phone only.
• Operator preferences such as Keep Screen Awake and the last LUT look.
• Imported .cube files you choose to open.

What never leaves the phone
• Live HEVC, DUML telemetry, and pairing traffic stay on the local link. We do not operate a cloud.

Third parties
• Google may process permission prompts and OS diagnostics under its own policies. Play betas may send crash reports to the developer under Google terms.
• Saving a clip or using the share sheet is something you start. Android or the app you pick then handles that file.
• AF-C face boxes are computed on this phone from the live preview. Face geometry is not uploaded.
• The source is at github.com/erik-sutton95/OpenPocketCine.

Android may ask for location so the app can join the camera Wi-Fi or scan BLE. OpenPocketCine does not use that permission for maps, ads, or a location history.

The full privacy policy is https://openpocketcine.app/privacy/
    """.trimIndent()

/**
 * Pocket's legal set: privacy ships with the app and the terms are the web page. Licenses and
 * NOTICE are the repository's LICENSE, THIRD-PARTY-NOTICES.md and NOTICE, staged as resources at
 * build time, with the platform notices; a build missing one shows the unavailable page.
 */
internal val PocketLegalDocuments = MonitorLegalDocuments(
    wordmark = "OPENPOCKETCINE",
    privacy = MonitorLegalDocument.Text(PRIVACY_BODY),
    terms = MonitorLegalDocument.Link(OpenPocketCineLinks.TERMS),
    licenses = MonitorLegalDocument.bundledText(listOf(
        MonitorLegalDocument.resource("openpocketcine/legal/LICENSE"),
        MonitorLegalDocument.resource("openpocketcine/legal/THIRD-PARTY-NOTICES.md"),
        MonitorPlatformLegalNotices.text,
    )),
    notice = MonitorLegalDocument.bundledText(listOf(MonitorLegalDocument.resource("openpocketcine/legal/NOTICE"))),
)
