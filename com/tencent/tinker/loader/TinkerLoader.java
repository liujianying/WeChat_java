package com.tencent.tinker.loader;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.ComponentHotplug;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class TinkerLoader extends AbstractTinkerLoader {
    private static final String TAG = "Tinker.TinkerLoader";
    private SharePatchInfo patchInfo;

    public Intent tryLoad(TinkerApplication tinkerApplication) {
        Intent intent = new Intent();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tryLoadPatchFilesInternal(tinkerApplication, intent);
        ShareIntentUtil.a(intent, SystemClock.elapsedRealtime() - elapsedRealtime);
        return intent;
    }

    private void tryLoadPatchFilesInternal(TinkerApplication tinkerApplication, Intent intent) {
        int tinkerFlags = tinkerApplication.getTinkerFlags();
        if (!ShareTinkerInternals.In(tinkerFlags)) {
            ShareIntentUtil.a(intent, -1);
        } else if (ShareTinkerInternals.id(tinkerApplication)) {
            ShareIntentUtil.a(intent, -1);
        } else {
            File hV = SharePatchFileUtil.hV(tinkerApplication);
            if (hV == null) {
                ShareIntentUtil.a(intent, -2);
                return;
            }
            String absolutePath = hV.getAbsolutePath();
            if (hV.exists()) {
                File acT = SharePatchFileUtil.acT(absolutePath);
                if (acT.exists()) {
                    File acU = SharePatchFileUtil.acU(absolutePath);
                    this.patchInfo = SharePatchInfo.n(acT, acU);
                    if (this.patchInfo == null) {
                        ShareIntentUtil.a(intent, -4);
                        return;
                    }
                    String str = this.patchInfo.vvF;
                    String str2 = this.patchInfo.vvG;
                    String str3 = this.patchInfo.vsJ;
                    if (str == null || str2 == null || str3 == null) {
                        ShareIntentUtil.a(intent, -4);
                        return;
                    }
                    intent.putExtra("intent_patch_old_version", str);
                    intent.putExtra("intent_patch_new_version", str2);
                    boolean ic = ShareTinkerInternals.ic(tinkerApplication);
                    Object obj = !str.equals(str2) ? 1 : null;
                    Object obj2 = (str3.equals("changing") && ic) ? 1 : null;
                    str3 = ShareTinkerInternals.bS(tinkerApplication, str3);
                    intent.putExtra("intent_patch_oat_dir", str3);
                    if (obj == null || !ic) {
                        str2 = str;
                    }
                    if (ShareTinkerInternals.oW(str2)) {
                        ShareIntentUtil.a(intent, -5);
                        return;
                    }
                    str = SharePatchFileUtil.acV(str2);
                    if (str == null) {
                        ShareIntentUtil.a(intent, -6);
                        return;
                    }
                    absolutePath = absolutePath + "/" + str;
                    File file = new File(absolutePath);
                    if (file.exists()) {
                        String acW = SharePatchFileUtil.acW(str2);
                        File file2 = acW != null ? new File(file.getAbsolutePath(), acW) : null;
                        if (SharePatchFileUtil.ah(file2)) {
                            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(tinkerApplication);
                            int a = ShareTinkerInternals.a(tinkerApplication, tinkerFlags, file2, shareSecurityCheck);
                            if (a != 0) {
                                intent.putExtra("intent_patch_package_patch_check", a);
                                ShareIntentUtil.a(intent, -8);
                                return;
                            }
                            intent.putExtra("intent_patch_package_config", shareSecurityCheck.cHd());
                            boolean Ij = ShareTinkerInternals.Ij(tinkerFlags);
                            if (Ij && !TinkerDexLoader.a(absolutePath, shareSecurityCheck, str3, intent)) {
                                return;
                            }
                            if (!ShareTinkerInternals.Ik(tinkerFlags) || TinkerSoLoader.a(absolutePath, shareSecurityCheck, intent)) {
                                boolean Il = ShareTinkerInternals.Il(tinkerFlags);
                                if (!Il || TinkerResourceLoader.a(tinkerApplication, absolutePath, shareSecurityCheck, intent)) {
                                    boolean z = ShareTinkerInternals.cHe() && ShareTinkerInternals.acZ(this.patchInfo.vvH) && VERSION.SDK_INT >= 21 && !ShareTinkerInternals.cHg();
                                    intent.putExtra("intent_patch_system_ota", z);
                                    if ((ic && obj != null) || obj2 != null) {
                                        this.patchInfo.vvF = str2;
                                        this.patchInfo.vsJ = str3;
                                        if (!SharePatchInfo.a(acT, this.patchInfo, acU)) {
                                            ShareIntentUtil.a(intent, -19);
                                            return;
                                        } else if (obj2 != null) {
                                            SharePatchFileUtil.co(absolutePath + "/interpet");
                                        }
                                    }
                                    if (checkSafeModeCount(tinkerApplication)) {
                                        if (Ij) {
                                            boolean a2 = TinkerDexLoader.a(tinkerApplication, absolutePath, str3, intent, z);
                                            if (z) {
                                                this.patchInfo.vvH = Build.FINGERPRINT;
                                                this.patchInfo.vsJ = a2 ? "interpet" : "odex";
                                                obj2 = null;
                                                if (SharePatchInfo.a(acT, this.patchInfo, acU)) {
                                                    intent.putExtra("intent_patch_oat_dir", this.patchInfo.vsJ);
                                                } else {
                                                    ShareIntentUtil.a(intent, -19);
                                                    return;
                                                }
                                            }
                                            if (!a2) {
                                                return;
                                            }
                                        }
                                        if (!Il || TinkerResourceLoader.a(tinkerApplication, absolutePath, intent)) {
                                            if (Ij && Il) {
                                                ComponentHotplug.a(tinkerApplication, shareSecurityCheck);
                                            }
                                            if (obj2 != null) {
                                                ShareTinkerInternals.ie(tinkerApplication);
                                            }
                                            ShareIntentUtil.a(intent, 0);
                                            return;
                                        }
                                        return;
                                    }
                                    intent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
                                    ShareIntentUtil.a(intent, -25);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ShareIntentUtil.a(intent, -7);
                        return;
                    }
                    ShareIntentUtil.a(intent, -6);
                    return;
                }
                new StringBuilder("tryLoadPatchFiles:patch info not exist:").append(acT.getAbsolutePath());
                ShareIntentUtil.a(intent, -3);
                return;
            }
            ShareIntentUtil.a(intent, -2);
        }
    }

    private boolean checkSafeModeCount(TinkerApplication tinkerApplication) {
        String str = "tinker_own_config_" + ShareTinkerInternals.aC(tinkerApplication);
        SharedPreferences sharedPreferences = tinkerApplication.getSharedPreferences(str, 0);
        int i = sharedPreferences.getInt("safe_mode_count", 0) + 1;
        new StringBuilder("tinker safe mode preferName:").append(str).append(" count:").append(i);
        if (i >= 3) {
            sharedPreferences.edit().putInt("safe_mode_count", 0).commit();
            return false;
        }
        tinkerApplication.setUseSafeMode(true);
        sharedPreferences.edit().putInt("safe_mode_count", i).commit();
        return true;
    }
}
