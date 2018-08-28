package com.tencent.mm.plugin.game.gamewebview.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.Window;
import android.webkit.URLUtil;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ak;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class d {
    private static volatile ah dJt;
    private static final Set<Object> fEy = new HashSet();
    private static final Object gBw = new Object();

    public static ah Em() {
        if (dJt == null) {
            synchronized (gBw) {
                if (dJt == null) {
                    dJt = new ah("SubCoreAppBrand#WorkerThread");
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

    public static boolean vN(String str) {
        return !bi.oW(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str));
    }

    public static String ag(Context context, String str) {
        return s.aV(context, str) + " GameWebView";
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

    public static String Da(String str) {
        return f(str, null);
    }

    public static String f(String str, Map<String, ? extends Object> map) {
        Map hashMap = new HashMap();
        hashMap.put("err_msg", str);
        if (map != null) {
            hashMap.putAll(map);
        }
        m(hashMap);
        return new JSONObject(hashMap).toString();
    }

    public static WebViewJSSDKFileItem Db(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.GameWebViewUtil", "get by local id error, local id is null or nil");
            return null;
        } else if (ad.cic()) {
            return e.bUX().Qq(str);
        } else {
            CommonLogicTask commonLogicTask = new CommonLogicTask();
            commonLogicTask.type = 3;
            Bundle bundle = new Bundle();
            bundle.putString("localId", str);
            commonLogicTask.jfZ = bundle;
            GameWebViewMainProcessService.b(commonLogicTask);
            return (WebViewJSSDKFileItem) commonLogicTask.jfZ.getParcelable("item");
        }
    }

    public static String Dc(String str) {
        try {
            Matcher matcher = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                return matcher.group(1);
            }
            return null;
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewUtil", "getFileNameFromContentDisposition error " + e.getMessage());
            return null;
        }
    }

    public static JSONObject ti(String str) {
        if (bi.oW(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewUtil", e.getMessage());
            return null;
        }
    }

    public static boolean aSn() {
        if (ad.cic()) {
            return au.HX();
        }
        CommonLogicTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 6;
        GameWebViewMainProcessService.b(commonLogicTask);
        return commonLogicTask.jfZ.getBoolean("has_set_uin", false);
    }

    public static int am(int i, String str) {
        if (i == 0) {
            if (str == null || str.length() <= 0) {
                i = 0;
            } else {
                i = 1;
            }
        }
        x.i("MicroMsg.GameWebViewUtil", "KGetA8KeyScene = %s", new Object[]{Integer.valueOf(i)});
        return i;
    }

    public static void do(Context context) {
        if (context instanceof Activity) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{16842936, 16842937});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            ((Activity) context).overridePendingTransition(resourceId, resourceId2);
        }
    }

    public static void dp(Context context) {
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(a.tnG, a.tnH);
        }
    }

    public static void b(Context context, int i, String str) {
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            if (VERSION.SDK_INT >= 23 && !h.Ae()) {
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                if ("black".equals(str)) {
                    systemUiVisibility |= 8192;
                } else {
                    systemUiVisibility &= -8193;
                }
                window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            } else if (VERSION.SDK_INT < 21) {
                return;
            } else {
                if ("black".equals(str)) {
                    i = ak.AD(i);
                }
            }
            window.setStatusBarColor(i);
        }
    }
}
