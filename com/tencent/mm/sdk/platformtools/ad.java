package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

public final class ad {
    private static String byT = "com.tencent.mm";
    private static Context context = null;
    private static volatile Resources mResources = null;
    private static String processName = byT;
    public static boolean sGA = false;
    private static ActivityManager sGB = null;
    private static String sGx = "com.tencent.mm";
    private static String sGy = "com.tencent.mm.ui.LauncherUI";
    private static boolean sGz = false;

    public static void le(boolean z) {
        sGz = z;
    }

    public static boolean chV() {
        return sGz;
    }

    public static String chW() {
        return sGy;
    }

    public static void setContext(Context context) {
        context = context;
        byT = context.getPackageName();
        x.d("MicroMsg.MMApplicationContext", "setup application context for package: " + byT);
    }

    public static Context getContext() {
        return context;
    }

    public static String getPackageName() {
        return byT;
    }

    public static String chX() {
        return sGx;
    }

    public static String chY() {
        return byT + "_preferences";
    }

    public static SharedPreferences chZ() {
        if (context != null) {
            return context.getSharedPreferences(chY(), 0);
        }
        return null;
    }

    public static SharedPreferences cia() {
        if (context != null) {
            return context.getSharedPreferences(byT + "_preferences_tools", 0);
        }
        return null;
    }

    public static String cib() {
        return byT + "_tmp_preferences";
    }

    public static String getProcessName() {
        return processName;
    }

    public static void bZ(String str) {
        processName = str;
    }

    public static boolean cic() {
        Object obj = processName;
        if (obj == null || obj.length() == 0) {
            obj = byT;
        }
        return byT.equals(obj);
    }

    public static boolean cid() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = byT;
        }
        return "com.tencent.mm:push".equalsIgnoreCase(str);
    }

    public static boolean cie() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = byT;
        }
        return "com.tencent.mm:tools".equalsIgnoreCase(str);
    }

    public static boolean cif() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = byT;
        }
        return "com.tencent.mm:exdevice".equalsIgnoreCase(str);
    }

    public static boolean cig() {
        return Wo(byT);
    }

    private static boolean Wo(String str) {
        if (context == null || byT == null) {
            return false;
        }
        if (sGB == null) {
            sGB = (ActivityManager) context.getSystemService("activity");
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : sGB.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + e.toString());
            return false;
        } catch (Error e2) {
            x.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + e2.toString());
            return false;
        }
    }

    public static Resources getResources() {
        return mResources;
    }

    public static void a(Resources resources) {
        mResources = resources;
    }
}
