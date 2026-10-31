from pathlib import Path
import hashlib, urllib.request, zipfile, re
root = Path.cwd()
apk = root / "upstream-native.apk"
url = "https://github.com/erik-sutton95/OpenPocketCine/releases/download/sideload-v0.1.5-8/OpenPocketCine-0.1.5-8-sideload.apk"
expected = "57e4ae2b4d130cc92ad0ef4a05b41dc4ff6bd54bb4c911dccacf963d0e57860c"
urllib.request.urlretrieve(url, apk)
assert hashlib.sha256(apk.read_bytes()).hexdigest() == expected, "Upstream APK checksum mismatch"
libs = root / "Apps/Android/app/build/generated/swiftCore/jniLibs/arm64-v8a"
vulkan = root.parent / "OpenCine/Android/vulkan/src/main/jniLibs/arm64-v8a"
libs.mkdir(parents=True, exist_ok=True); vulkan.mkdir(parents=True, exist_ok=True)
with zipfile.ZipFile(apk) as archive:
 for name in archive.namelist():
  if not name.startswith("lib/arm64-v8a/") or not name.endswith(".so"): continue
  filename = Path(name).name
  if filename == "libopc_vulkan.so": (vulkan / filename).write_bytes(archive.read(name))
  elif filename.startswith(("libswift", "libFoundation", "lib_Foundation", "libBlocks", "libdispatch", "libc++", "libOpenPocket")):
   (libs / filename).write_bytes(archive.read(name))
apk.unlink()
p = root.parent / "OpenCine/Android/vulkan/build.gradle.kts"
text = p.read_text()
text = re.sub(r"        externalNativeBuild \{\n            cmake \{ arguments.*?\n        \}\n", "", text, flags=re.S)
text = re.sub(r"    externalNativeBuild \{.*?\n    \}\n", "", text, flags=re.S)
p.write_text(text)
print("Verified official native libraries staged", len(list(libs.glob("*.so"))))
