package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.xweb.r;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public final class d {
    static a vDZ;

    public interface a {
        void onViewInitFinished(boolean z);
    }

    static {
        r.initInterface();
    }

    public static void a(a aVar) {
        vDZ = aVar;
    }

    public static synchronized void a(Context context, a aVar) {
        synchronized (d.class) {
            if (vDZ != null) {
                vDZ.a(context, aVar);
            } else {
                Log.e("TbsDownloader", "preInit: sImp is null");
            }
        }
    }

    public static void clearAllWebViewCache(Context context, boolean z) {
        if (vDZ != null) {
            vDZ.clearAllWebViewCache(context, z);
        } else {
            Log.e("TbsDownloader", "clearAllWebViewCache: sImp is null");
        }
    }

    public static void reset(Context context) {
        if (vDZ != null) {
            vDZ.reset(context);
        } else {
            Log.e("TbsDownloader", "reset: sImp is null");
        }
    }

    public static boolean getTBSInstalling() {
        if (vDZ != null) {
            return vDZ.getTBSInstalling();
        }
        Log.e("TbsDownloader", "getTBSInstalling: sImp is null");
        return false;
    }

    public static int getTbsVersion(Context context) {
        if (vDZ != null) {
            return vDZ.getTbsVersion(context);
        }
        Log.e("TbsDownloader", "getTbsVersion: sImp is null");
        return 0;
    }

    public static void a(h hVar) {
        if (vDZ != null) {
            vDZ.a(hVar);
        } else {
            Log.e("TbsDownloader", "setTbsListener: sImp is null");
        }
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        if (vDZ != null) {
            return vDZ.startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
        }
        Log.e("TbsDownloader", "startMiniQBToLoadUrl: sImp is null");
        return 0;
    }

    public static boolean a(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        if (vDZ != null) {
            return vDZ.a(context, str, hashMap, valueCallback);
        }
        Log.e("TbsDownloader", "startQbOrMiniQBToLoadUrl: sImp is null");
        return false;
    }

    public static void a(Context context, String str, ValueCallback<Boolean> valueCallback) {
        if (vDZ != null) {
            vDZ.a(context, str, valueCallback);
        } else {
            Log.e("TbsDownloader", "canOpenFile: sImp is null");
        }
    }

    public static boolean isTbsCoreInited() {
        if (vDZ != null) {
            return vDZ.isTbsCoreInited();
        }
        Log.e("TbsDownloader", "isTbsCoreInited: sImp is null");
        return false;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        if (vDZ != null) {
            vDZ.initTbsSettings(map);
        } else {
            Log.e("TbsDownloader", "initTbsSettings: sImp is null");
        }
    }

    public static boolean canOpenWebPlus(Context context) {
        if (vDZ != null) {
            return vDZ.canOpenWebPlus(context);
        }
        Log.e("TbsDownloader", "canOpenWebPlus: sImp is null");
        return false;
    }

    public static void closeFileReader(Context context) {
        if (vDZ != null) {
            vDZ.closeFileReader(context);
        } else {
            Log.e("TbsDownloader", "closeFileReader: sImp is null");
        }
    }

    public static void forceSysWebView() {
        if (vDZ != null) {
            vDZ.forceSysWebView();
        } else {
            Log.e("TbsDownloader", "forceSysWebView: sImp is null");
        }
    }
}
