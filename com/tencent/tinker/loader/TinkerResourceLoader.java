package com.tencent.tinker.loader;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.io.Serializable;

public class TinkerResourceLoader {
    private static ShareResPatchInfo vtv = new ShareResPatchInfo();

    private TinkerResourceLoader() {
    }

    public static boolean a(TinkerApplication tinkerApplication, String str, Intent intent) {
        if (vtv == null || vtv.vvJ == null) {
            return true;
        }
        String str2 = str + "/res/resources.apk";
        File file = new File(str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (tinkerApplication.isTinkerLoadVerifyFlag()) {
            if (SharePatchFileUtil.h(file, vtv.vvJ)) {
                new StringBuilder("verify resource file:").append(file.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - currentTimeMillis);
            } else {
                new StringBuilder("Failed to load resource file, path: ").append(file.getPath()).append(", expect md5: ").append(vtv.vvJ);
                ShareIntentUtil.a(intent, -24);
                return false;
            }
        }
        try {
            TinkerResourcePatcher.bQ(tinkerApplication, str2);
            new StringBuilder("monkeyPatchExistingResources resource file:").append(str2).append(", use time: ").append(System.currentTimeMillis() - currentTimeMillis);
            return true;
        } catch (Throwable th) {
        }
        intent.putExtra("intent_patch_exception", th);
        ShareIntentUtil.a(intent, -23);
        return false;
    }

    public static boolean a(Context context, String str, ShareSecurityCheck shareSecurityCheck, Intent intent) {
        String str2 = (String) shareSecurityCheck.vvS.get("assets/res_meta.txt");
        if (str2 == null) {
            return true;
        }
        ShareResPatchInfo.b(str2, vtv);
        if (vtv.vvJ == null) {
            return true;
        }
        if (ShareResPatchInfo.a(vtv)) {
            str2 = str + "/res/";
            File file = new File(str2);
            if (!file.exists() || !file.isDirectory()) {
                ShareIntentUtil.a(intent, -21);
                return false;
            } else if (SharePatchFileUtil.ah(new File(str2 + "resources.apk"))) {
                try {
                    TinkerResourcePatcher.hR(context);
                    return true;
                } catch (Serializable th) {
                    intent.putExtra("intent_patch_exception", th);
                    ShareIntentUtil.a(intent, -23);
                    return false;
                }
            } else {
                ShareIntentUtil.a(intent, -22);
                return false;
            }
        }
        intent.putExtra("intent_patch_package_patch_check", -8);
        ShareIntentUtil.a(intent, -8);
        return false;
    }
}
