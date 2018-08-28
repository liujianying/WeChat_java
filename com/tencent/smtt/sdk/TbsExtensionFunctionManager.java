package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.q;
import java.io.File;
import java.io.IOException;

public class TbsExtensionFunctionManager {
    public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
    public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
    public static final String DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME = "disable_get_apk_version_switch.txt";
    public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
    public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
    public static final int SWITCH_BYTE_COOKIE = 1;
    public static final int SWITCH_BYTE_DISABLE_GET_APK_VERSION = 2;
    public static final String USEX5_FILE_NAME = "usex5.txt";
    private static TbsExtensionFunctionManager b;
    private boolean a;

    private TbsExtensionFunctionManager() {
    }

    public static TbsExtensionFunctionManager getInstance() {
        if (b == null) {
            synchronized (TbsExtensionFunctionManager.class) {
                if (b == null) {
                    b = new TbsExtensionFunctionManager();
                }
            }
        }
        return b;
    }

    public synchronized boolean canUseFunction(Context context, String str) {
        boolean z;
        File file = new File(context.getFilesDir(), str);
        z = file.exists() && file.isFile();
        return z;
    }

    public synchronized int getRomCookieDBVersion(Context context) {
        int i = -1;
        synchronized (this) {
            SharedPreferences sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences(SP_NAME_FOR_COOKIE, 4) : context.getSharedPreferences(SP_NAME_FOR_COOKIE, 0);
            if (sharedPreferences != null) {
                i = sharedPreferences.getInt(SP_KEY_COOKIE_DB_VERSION, -1);
            }
        }
        return i;
    }

    public synchronized void initTbsBuglyIfNeed(Context context) {
        if (!this.a) {
            if (canUseFunction(context, BUGLY_SWITCH_FILE_NAME)) {
                Object c;
                if (TbsShareManager.isThirdPartyApp(context)) {
                    c = TbsShareManager.c(context);
                } else {
                    File q = an.a().q(context);
                    if (q == null) {
                        TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
                    }
                    if (q.listFiles() == null || q.listFiles().length <= 0) {
                        TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
                    } else {
                        String c2 = q.getAbsolutePath();
                    }
                }
                if (TextUtils.isEmpty(c2)) {
                    TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
                } else {
                    File q2 = an.a().q(context);
                    if (q2 == null) {
                        TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
                    } else {
                        try {
                            String parent = new File(c2, "tbs_bugly_dex.jar").getParent();
                            String[] strArr = new String[]{r4.getAbsolutePath()};
                            String absolutePath = q2.getAbsolutePath();
                            q.a(new DexLoader(parent, context, strArr, absolutePath, null).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", new Class[]{Context.class, String.class, String.class, String.class}, new Object[]{context, c2, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context))});
                            this.a = true;
                            TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
                        } catch (Throwable th) {
                            TbsLog.i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(th));
                        }
                    }
                }
            } else {
                TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
            }
        }
    }

    public synchronized boolean setFunctionEnable(Context context, String str, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (context != null) {
                File file = new File(context.getFilesDir(), str);
                if (z) {
                    if (!file.exists()) {
                        try {
                            if (file.createNewFile()) {
                                z2 = true;
                            }
                        } catch (IOException e) {
                            TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + str);
                        }
                    }
                } else if (file.exists()) {
                    if (file.delete()) {
                        z2 = true;
                    } else {
                        TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + str);
                    }
                }
                z2 = true;
            }
        }
        return z2;
    }
}
