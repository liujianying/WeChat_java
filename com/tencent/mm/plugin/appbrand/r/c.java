package com.tencent.mm.plugin.appbrand.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.i;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class c {
    private static volatile ah dJt;
    private static final Set<Object> fEy = new HashSet();
    private static final Object gBw = new Object();
    private static final char[] gBx = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] gBy = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};

    public static void aov() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        ad.getContext().sendBroadcast(intent);
    }

    public static long aow() {
        return bi.VE();
    }

    public static String getMMString(int i, Object... objArr) {
        return ad.getResources().getString(i, objArr);
    }

    public static <T> T br(T t) {
        if (t != null) {
            fEy.add(t);
        }
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
                    g.abF("SubCoreAppBrand#WorkerThread");
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
                    dJt = new ah("SubCoreAppBrand#WorkerThread");
                    g.a("SubCoreAppBrand#WorkerThread", new h(dJt.lnJ.getLooper(), "SubCoreAppBrand#WorkerThread"));
                }
            }
        }
        return dJt;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ah.A(runnable);
        } else {
            runnable.run();
        }
    }

    public static void m(Map map) {
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                m((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
    }

    public static String vS(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (i2 < gBx.length) {
                String str2 = gBy[i2];
                int i3 = 0;
                while (i3 < str2.length() && i + i3 < length && str2.charAt(i3) == str.charAt(i + i3)) {
                    i3++;
                }
                if (i3 == str2.length()) {
                    break;
                }
                i2++;
            }
            if (i2 != gBx.length) {
                stringBuffer.append(gBx[i2]);
                i = gBy[i2].length() + i;
            } else {
                stringBuffer.append(str.charAt(i));
                i++;
            }
        }
        return stringBuffer.toString();
    }

    public static String vT(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(8232, 10).replace(8233, 10);
    }

    public static String b(ComponentName componentName) {
        String str = "[UNKNOWN]";
        if (componentName == null) {
            return str;
        }
        PackageManager packageManager = ad.getContext().getPackageManager();
        if (packageManager == null) {
            return str;
        }
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            if (activityInfo != null) {
                return activityInfo.taskAffinity;
            }
            return str;
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandUtil", "getActivityTaskAffinity e = %s", new Object[]{e});
            return str;
        }
    }

    public static int c(Context context, float f) {
        return Math.round(context.getResources().getDisplayMetrics().density * f);
    }
}
