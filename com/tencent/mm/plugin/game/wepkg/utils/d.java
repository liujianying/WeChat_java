package com.tencent.mm.plugin.game.wepkg.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.game.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.game.wepkg.model.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class d {
    private static volatile ah dJt;
    private static final Set<Object> fEy = new HashSet();
    private static final Object gBw = new Object();

    public static long aow() {
        return bi.VE();
    }

    public static <T> T br(T t) {
        fEy.add(t);
        return t;
    }

    public static void az(Object obj) {
        if (obj != null) {
            fEy.remove(obj);
        }
    }

    public static void aox() {
        if (dJt != null) {
            synchronized (gBw) {
                if (dJt != null) {
                    dJt.lnJ.quit();
                    dJt = null;
                }
            }
        }
    }

    public static ah Em() {
        if (dJt == null) {
            synchronized (gBw) {
                if (dJt == null) {
                    dJt = new ah("WebviewCache#WorkerThread");
                }
            }
        }
        return dJt;
    }

    public static String Et(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return b.OBJECT_ROOT_DIR_PATH + str + "/";
    }

    public static String dh(String str, String str2) {
        if (bi.oW(str) || bi.oW(str2)) {
            return "";
        }
        return Et(str) + str2;
    }

    public static void a(String str, a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = 1001;
        wepkgCrossProcessTask.kfj = str;
        if (ad.cic()) {
            Em().H(new 1(wepkgCrossProcessTask, aVar));
            return;
        }
        wepkgCrossProcessTask.fFC = new 2(currentTimeMillis, aVar, wepkgCrossProcessTask);
        wepkgCrossProcessTask.ahA();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static String Eu(String str) {
        if (bi.oW(str)) {
            return "";
        }
        try {
            return bi.oV(Uri.parse(str).getQueryParameter("wechat_pkgid"));
        } catch (UnsupportedOperationException e) {
            x.e("MicroMsg.Wepkg.WepkgUtil", e.getMessage());
            return "";
        }
    }

    public static String Ev(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return Uri.parse(str).getHost();
    }

    public static String Ew(String str) {
        if (bi.oW(str) || !URLUtil.isNetworkUrl(str)) {
            return "";
        }
        try {
            String replaceFirst = str.replaceFirst(Uri.parse(str).getScheme() + "://", "");
            try {
                if (replaceFirst.contains("?")) {
                    return replaceFirst.substring(0, replaceFirst.indexOf("?"));
                }
                return replaceFirst;
            } catch (Exception e) {
                return replaceFirst;
            }
        } catch (Exception e2) {
            return str;
        }
    }

    public static boolean Ex(String str) {
        if (bi.oW(Eu(str))) {
            return false;
        }
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null && sharedPreferences.getBoolean("disable_we_pkg", false)) {
            x.i("MicroMsg.Wepkg.WepkgUtil", "disable wepkg");
            a.b("EnterWeb", str, Eu(str), null, 0, 0, a.rd(11));
            return false;
        } else if (!b.kgl) {
            return true;
        } else {
            x.i("MicroMsg.Wepkg.WepkgUtil", "config wepkg disable");
            a.b("EnterWeb", str, Eu(str), null, 0, 0, a.rd(12));
            return false;
        }
    }

    public static String di(String str, String str2) {
        return g.u((str + "_" + str2).getBytes());
    }

    public static boolean Ey(String str) {
        try {
            File file = new File(str);
            if (!(file.exists() && file.isDirectory())) {
                file.mkdirs();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean aVC() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int i = gregorianCalendar.get(11);
        int i2 = gregorianCalendar.get(12);
        if (i >= 12 && i < 14) {
            return true;
        }
        if (i == 14) {
            if (i2 <= 30) {
                return true;
            }
        } else if (i >= 18 && i <= 24) {
            return true;
        }
        return false;
    }

    public static boolean dE(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals("com.tencent.mm") || runningAppProcessInfo.processName.equals("com.tencent.mm:tools"))) {
                return true;
            }
        }
        return false;
    }
}
