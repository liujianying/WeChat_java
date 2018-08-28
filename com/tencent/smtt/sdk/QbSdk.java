package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.q;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SuppressLint({"NewApi"})
public class QbSdk {
    private static boolean A = true;
    private static TbsListener B = null;
    private static TbsListener C = null;
    private static boolean D = false;
    private static boolean E = false;
    public static final int EXTENSION_INIT_FAILURE = -99999;
    public static String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    static boolean a = false;
    static boolean b = false;
    static boolean c = true;
    static String d;
    static boolean e = false;
    static long f = 0;
    static long g = 0;
    static Object h = new Object();
    static boolean i = true;
    static boolean j = true;
    static boolean k = false;
    static volatile boolean l = a;
    static TbsListener m = new n();
    static Map<String, Object> n = null;
    private static int o = 0;
    private static String p = "";
    private static Class<?> q;
    private static Object r;
    private static boolean s = false;
    public static boolean sIsVersionPrinted = false;
    private static String[] t;
    private static String u = "NULL";
    private static String v = "UNKNOWN";
    private static int w = 0;
    private static int x = 170;
    private static String y = null;
    private static String z = null;

    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    static Bundle a(Context context, Bundle bundle) {
        if (a(context)) {
            Object a = q.a(r, "incrUpdate", new Class[]{Context.class, Bundle.class}, context, bundle);
            if (a != null) {
                return (Bundle) a;
            }
            TbsLogReport.a(context).a(216, "incrUpdate return null!");
            return null;
        }
        TbsLogReport.a(context).a(216, "initForPatch return false!");
        return null;
    }

    static Object a(Context context, String str, Bundle bundle) {
        if (!a(context)) {
            return Integer.valueOf(EXTENSION_INIT_FAILURE);
        }
        Object a = q.a(r, "miscCall", new Class[]{String.class, Bundle.class}, str, bundle);
        return a == null ? null : a;
    }

    static String a() {
        return p;
    }

    static synchronized void a(Context context, String str) {
        synchronized (QbSdk.class) {
            if (!a) {
                a = true;
                v = "forceSysWebViewInner: " + str;
                TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + v);
                TbsCoreLoadStat.getInstance().a(context, 401, new Throwable(v));
            }
        }
    }

    static boolean a(Context context) {
        try {
            if (q != null) {
                return true;
            }
            File q = an.a().q(context);
            if (q == null) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(q, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                TbsLog.i("QbSdk", "new DexLoader #3 dexFile is " + file.getAbsolutePath());
                q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, q.getAbsolutePath(), null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                b(context, file.getParent());
                return true;
            }
            TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
            return false;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    static boolean a(Context context, int i) {
        return a(context, i, 20000);
    }

    static boolean a(Context context, int i, int i2) {
        if (n != null && n.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD) && n.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return true;
        } else if (!c(context)) {
            return true;
        } else {
            Object a = q.a(r, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43610), Integer.valueOf(i2));
            if (a != null) {
                return ((Boolean) a).booleanValue();
            }
            a = q.a(r, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43610));
            return a != null ? ((Boolean) a).booleanValue() : true;
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean a(Context context, boolean z) {
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43610; SDK_VERSION_NAME: 3.6.0.1240");
            sIsVersionPrinted = true;
        }
        if (a && !z) {
            TbsLog.e("QbSdk", "QbSdk init: " + v, false);
            TbsCoreLoadStat.getInstance().a(context, 414, new Throwable(v));
            return false;
        } else if (b) {
            TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().a(context, 402, new Throwable(u));
            return false;
        } else {
            if (!A) {
                d(context);
            }
            try {
                File q = an.a().q(context);
                if (q == null) {
                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                    TbsCoreLoadStat.getInstance().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    return false;
                }
                int a;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    if (o != 0) {
                        a = an.a().a(true, context);
                        if (o != a) {
                            q = null;
                            r = null;
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + a, true);
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + o, true);
                            TbsCoreLoadStat.getInstance().a(context, 303, new Throwable("sTbsVersion: " + o + "; tbsCoreInstalledVer: " + a));
                            return false;
                        }
                    }
                    a = 0;
                    o = a;
                } else if (o == 0 || o == TbsShareManager.d(context)) {
                    o = TbsShareManager.d(context);
                } else {
                    q = null;
                    r = null;
                    TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
                    TbsCoreLoadStat.getInstance().a(context, 302, new Throwable("sTbsVersion: " + o + "; AvailableTbsCoreVersion: " + TbsShareManager.d(context)));
                    return false;
                }
                if (q != null) {
                    return true;
                }
                File file;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    file = new File(an.a().q(context), "tbs_sdk_extension_dex.jar");
                } else if (TbsShareManager.j(context)) {
                    file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                } else {
                    TbsCoreLoadStat.getInstance().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                    return false;
                }
                if (file.exists()) {
                    String hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : q.getAbsolutePath();
                    TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is " + hostCorePathAppDefined);
                    TbsLog.i("QbSdk", "new DexLoader #1 dexFile is " + file.getAbsolutePath());
                    q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    b(context, file.getParent());
                    q.a(r, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, b.a, b.b, b.c, b.d);
                    q.a(r, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                    return true;
                }
                try {
                    TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                    a = an.a().i(context);
                    if (new File(file.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                        if (a > 0) {
                            TbsCoreLoadStat.getInstance().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + a));
                        } else {
                            TbsCoreLoadStat.getInstance().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + a));
                        }
                    } else if (a > 0) {
                        TbsCoreLoadStat.getInstance().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + a));
                    } else {
                        TbsCoreLoadStat.getInstance().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + a));
                    }
                } catch (Throwable th) {
                }
                return false;
            } catch (Throwable th2) {
                TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th2));
                TbsCoreLoadStat.getInstance().a(context, 306, th2);
                return false;
            }
        }
    }

    static boolean a(Context context, boolean z, boolean z2) {
        int i = 1;
        boolean z3 = false;
        if (TbsShareManager.isThirdPartyApp(context) && !TbsShareManager.i(context)) {
            TbsCoreLoadStat.getInstance().a(context, 302);
        } else if (a(context, z)) {
            Object a = q.a(r, "canLoadX5Core", new Class[]{Integer.TYPE}, Integer.valueOf(43610));
            boolean a2;
            if (a == null) {
                a = q.a(r, "canLoadX5", new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
                if (a == null) {
                    TbsCoreLoadStat.getInstance().a(context, 308);
                } else if (!((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail"))) {
                    if (a instanceof Boolean) {
                        o = o.d();
                        a2 = a(context, o.d());
                        if (((Boolean) a).booleanValue() && !a2) {
                            z3 = true;
                        }
                        if (!z3) {
                            TbsLog.e("loaderror", "318");
                            TbsLog.w("loaderror", "isX5Disable:" + a2);
                            TbsLog.w("loaderror", "(Boolean) ret:" + ((Boolean) a));
                        }
                    }
                }
            } else if (!((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail"))) {
                if (a instanceof Bundle) {
                    Bundle bundle = (Bundle) a;
                    if (bundle.isEmpty()) {
                        TbsCoreLoadStat.getInstance().a(context, 331, new Throwable(String.valueOf(a)));
                        TbsLog.e("loaderror", "empty bundle");
                    } else {
                        int i2;
                        try {
                            i2 = bundle.getInt("result_code", -1);
                        } catch (Exception e) {
                            TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + e.toString());
                            i2 = -1;
                        }
                        a2 = i2 == 0;
                        String valueOf;
                        if (TbsShareManager.isThirdPartyApp(context)) {
                            o.a(TbsShareManager.d(context));
                            valueOf = String.valueOf(TbsShareManager.d(context));
                            p = valueOf;
                            if (valueOf.length() == 5) {
                                p = "0" + p;
                            }
                            if (p.length() != 6) {
                                p = "";
                            }
                        } else {
                            try {
                                if (VERSION.SDK_INT >= 12) {
                                    p = bundle.getString("tbs_core_version", "0");
                                } else {
                                    valueOf = bundle.getString("tbs_core_version");
                                    p = valueOf;
                                    if (valueOf == null) {
                                        p = "0";
                                    }
                                }
                            } catch (Exception e2) {
                                p = "0";
                            }
                            try {
                                o = Integer.parseInt(p);
                            } catch (NumberFormatException e3) {
                                o = 0;
                            }
                            o.a(o);
                            if (o == 0) {
                                TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("sTbsVersion is 0"));
                            } else {
                                if ((o <= 0 || o > 25442) && o != 25472) {
                                    i = 0;
                                }
                                if (i != 0) {
                                    TbsLog.e("TbsDownload", "is_obsolete --> delete old core:" + o);
                                    j.b(an.a().q(context));
                                    TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("is_obsolete --> delete old core:" + o));
                                }
                            }
                        }
                        try {
                            t = bundle.getStringArray("tbs_jarfiles");
                            if (t instanceof String[]) {
                                try {
                                    d = bundle.getString("tbs_librarypath");
                                    a = null;
                                    if (i2 != 0) {
                                        try {
                                            a = q.a(r, "getErrorCodeForLogReport", new Class[0], new Object[0]);
                                        } catch (Exception e4) {
                                        }
                                    }
                                    switch (i2) {
                                        case -2:
                                            if (!(a instanceof Integer)) {
                                                TbsCoreLoadStat.getInstance().a(context, 404, new Throwable("detail: " + a));
                                                z3 = a2;
                                                break;
                                            }
                                            TbsCoreLoadStat.getInstance().a(context, ((Integer) a).intValue(), new Throwable("detail: " + a));
                                            z3 = a2;
                                            break;
                                        case -1:
                                            if (!(a instanceof Integer)) {
                                                TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("detail: " + a));
                                                z3 = a2;
                                                break;
                                            }
                                            TbsCoreLoadStat.getInstance().a(context, ((Integer) a).intValue(), new Throwable("detail: " + a));
                                            z3 = a2;
                                            break;
                                        case 0:
                                            z3 = a2;
                                            break;
                                        default:
                                            TbsCoreLoadStat.getInstance().a(context, 415, new Throwable("detail: " + a + "errcode" + i2));
                                            z3 = a2;
                                            break;
                                    }
                                } catch (Exception e5) {
                                }
                            } else {
                                TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("sJarFiles not instanceof String[]: " + t));
                            }
                        } catch (Throwable th) {
                            TbsCoreLoadStat.getInstance().a(context, 329, th);
                        }
                    }
                } else {
                    TbsCoreLoadStat.getInstance().a(context, 330, new Throwable(String.valueOf(a)));
                    TbsLog.e("loaderror", "ret not instance of bundle");
                }
            }
            if (!z3) {
                TbsLog.e("loaderror", "319");
            }
        } else {
            TbsLog.e("QbSdk", "QbSdk.init failure!");
        }
        return z3;
    }

    protected static String b() {
        bv a = bv.a();
        if (a != null && a.b()) {
            Object invokeStaticMethod = a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
            if (invokeStaticMethod != null && (invokeStaticMethod instanceof String)) {
                return (String) invokeStaticMethod;
            }
        }
        return null;
    }

    private static void b(Context context, String str) {
        Constructor constructor = null;
        Object obj = 1;
        Object obj2 = null;
        try {
            constructor = q.getConstructor(new Class[]{Context.class, Context.class, String.class, String.class, String.class});
        } catch (Throwable th) {
            return;
        }
        if (TbsShareManager.isThirdPartyApp(context)) {
            Context e = TbsShareManager.e(context);
            if (e == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                TbsLogReport.a(context.getApplicationContext()).b(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
            } else if (obj != null) {
                r = constructor.newInstance(new Object[]{context, e, TbsShareManager.getHostCorePathAppDefined(), str, null});
            } else if (e == null) {
                r = q.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, e, TbsShareManager.getHostCorePathAppDefined()});
            } else {
                r = q.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, e});
            }
        } else if (obj == null) {
            r = q.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, context});
        } else {
            r = constructor.newInstance(new Object[]{context, context, null, str, null});
        }
    }

    static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (context.getApplicationInfo().packageName.contains("com.tencent.portfolio")) {
                TbsLog.i("QbSdk", "clearPluginConfigFile #1");
                String string = TbsDownloadConfig.getInstance(context).mPreferences.getString("app_versionname", null);
                CharSequence charSequence = context.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
                TbsLog.i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + string + " newAppVersionName is " + charSequence);
                if (!(string == null || string.contains(charSequence))) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("plugin_setting", 0);
                    if (sharedPreferences != null) {
                        Editor edit = sharedPreferences.edit();
                        edit.clear();
                        edit.commit();
                        TbsLog.i("QbSdk", "clearPluginConfigFile done");
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            TbsLog.i("QbSdk", "clearPluginConfigFile error is " + th.getMessage());
            return false;
        }
    }

    private static boolean c(Context context) {
        try {
            if (q != null) {
                return true;
            }
            File q = an.a().q(context);
            if (q == null) {
                TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            }
            File file;
            if (!TbsShareManager.isThirdPartyApp(context)) {
                file = new File(an.a().q(context), "tbs_sdk_extension_dex.jar");
            } else if (TbsShareManager.j(context)) {
                file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
            } else {
                TbsCoreLoadStat.getInstance().a(context, 304);
                return false;
            }
            if (file.exists()) {
                String hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : q.getAbsolutePath();
                TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is " + hostCorePathAppDefined);
                TbsLog.i("QbSdk", "new DexLoader #4 dexFile is " + file.getAbsolutePath());
                q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                b(context, file.getParent());
                q.a(r, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, b.a, b.b, b.c, b.d);
                q.a(r, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                return true;
            }
            TbsCoreLoadStat.getInstance().a(context, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
            return false;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static boolean canLoadVideo(Context context) {
        Object a = q.a(r, "canLoadVideo", new Class[]{Integer.TYPE}, Integer.valueOf(0));
        if (a == null) {
            TbsCoreLoadStat.getInstance().a(context, 314);
        } else if (!((Boolean) a).booleanValue()) {
            TbsCoreLoadStat.getInstance().a(context, 313);
        }
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public static boolean canLoadX5(Context context) {
        return a(context, false, false);
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        try {
            if (context.getApplicationInfo().packageName.contains("com.moji.mjweather") && VERSION.SDK_INT == 19) {
                return true;
            }
            if (q == null) {
                File q = an.a().q(context);
                if (q == null) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    return false;
                }
                File file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    String hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : q.getAbsolutePath();
                    TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is " + hostCorePathAppDefined);
                    TbsLog.i("QbSdk", "new DexLoader #2 dexFile is " + file.getAbsolutePath());
                    q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    if (r == null) {
                        if (TbsShareManager.e(context) == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                            TbsLogReport.a(context.getApplicationContext()).b(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                            return false;
                        }
                        b(context, file.getParent());
                    }
                } else {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    return false;
                }
            }
            Object a = q.a(r, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
            return (a == null || !(a instanceof Boolean)) ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void canOpenFile(Context context, String str, ValueCallback<Boolean> valueCallback) {
        new h(context, str, valueCallback).start();
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        return !a(context, false) ? false : false;
    }

    public static boolean canOpenWebPlus(Context context) {
        boolean z;
        Throwable th;
        Throwable th2;
        BufferedInputStream bufferedInputStream;
        InputStream inputStream = null;
        if (w == 0) {
            w = a.a();
        }
        TbsLog.i("QbSdk", "canOpenWebPlus - totalRAM: " + w);
        if (VERSION.SDK_INT < 7 || w < x || context == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream2;
        try {
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(an.a().q(context), "tbs.conf")));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                String property = properties.getProperty("android_sdk_max_supported");
                String property2 = properties.getProperty("android_sdk_min_supported");
                int parseInt = Integer.parseInt(property);
                int parseInt2 = Integer.parseInt(property2);
                int parseInt3 = Integer.parseInt(VERSION.SDK);
                if (parseInt3 > parseInt || parseInt3 < parseInt2) {
                    TbsLog.i("QbSdk", "canOpenWebPlus - sdkVersion: " + parseInt3);
                    try {
                        bufferedInputStream2.close();
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                parseInt = Integer.parseInt(properties.getProperty("tbs_core_version"));
                try {
                    bufferedInputStream2.close();
                } catch (Exception e2) {
                }
                InputStream fileInputStream;
                try {
                    fileInputStream = new FileInputStream(new File(an.s(context), "tbs_extension.conf"));
                    try {
                        Properties properties2 = new Properties();
                        properties2.load(fileInputStream);
                        int parseInt4 = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                        parseInt2 = Integer.parseInt(properties2.getProperty("app_versioncode_for_switch"));
                        if (parseInt == 88888888 || parseInt4 == 88888888) {
                            z = false;
                        } else if (parseInt > parseInt4) {
                            z = false;
                        } else if (parseInt == parseInt4) {
                            if (parseInt2 > 0) {
                                if (parseInt2 != b.b(context)) {
                                    z = false;
                                }
                            }
                            z = Boolean.parseBoolean(properties2.getProperty("x5_disabled")) && !TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getBoolean("switch_backupcore_enable", false);
                        } else {
                            z = false;
                        }
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e42) {
                        }
                    }
                    throw th;
                }
                if (z) {
                }
            } catch (Throwable th5) {
            }
        } catch (Throwable th6) {
            th2 = th6;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e5) {
                }
            }
            throw th2;
        }
    }

    public static boolean canUseVideoFeatrue(Context context, int i) {
        Object a = q.a(r, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        return (a == null || !(a instanceof Boolean)) ? false : ((Boolean) a).booleanValue();
    }

    public static void clear(Context context) {
    }

    public static void clearAllWebViewCache(Context context, boolean z) {
        Throwable th;
        Object obj;
        Object obj2 = 1;
        TbsLog.i("QbSdk", "clearAllWebViewCache(" + context + ", " + z + ")");
        try {
            if (new WebView(context).getWebViewClientExtension() != null) {
                try {
                    bv a = bv.a();
                    if (a != null && a.b()) {
                        a.c().a(context, z);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    int obj3 = 1;
                    TbsLog.e("QbSdk", "clearAllWebViewCache exception 2 -- " + Log.getStackTraceString(th));
                    obj2 = obj3;
                    if (obj2 == null) {
                        try {
                            WebView webView = new WebView(context);
                            if (VERSION.SDK_INT >= 11) {
                                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                                webView.removeJavascriptInterface("accessibility");
                                webView.removeJavascriptInterface("accessibilityTraversal");
                            }
                            webView.clearCache(true);
                            if (z) {
                                CookieSyncManager.createInstance(context);
                                CookieManager.getInstance().removeAllCookie();
                            }
                            WebViewDatabase.getInstance(context).clearUsernamePassword();
                            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
                            WebViewDatabase.getInstance(context).clearFormData();
                            WebStorage.getInstance().deleteAllData();
                            WebIconDatabase.getInstance().removeAllIcons();
                        } catch (Throwable th3) {
                            TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th3));
                        }
                    }
                    TbsLog.i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
                    return;
                }
            }
            obj2 = null;
        } catch (Throwable th32) {
            th = th32;
            obj3 = null;
        }
        if (obj2 == null) {
            TbsLog.i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
            return;
        }
        try {
            WebView webView2 = new WebView(context);
            if (VERSION.SDK_INT >= 11) {
                webView2.removeJavascriptInterface("searchBoxJavaBridge_");
                webView2.removeJavascriptInterface("accessibility");
                webView2.removeJavascriptInterface("accessibilityTraversal");
            }
            webView2.clearCache(true);
            if (z) {
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            }
            WebViewDatabase.getInstance(context).clearUsernamePassword();
            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            WebViewDatabase.getInstance(context).clearFormData();
            WebStorage.getInstance().deleteAllData();
            WebIconDatabase.getInstance().removeAllIcons();
        } catch (Throwable th322) {
            TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th322));
        }
    }

    public static void closeFileReader(Context context) {
        bv a = bv.a();
        a.a(context, null);
        if (a.b()) {
            a.c().p();
        }
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        if (context == null) {
            return false;
        }
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        if (isMiniQBShortCutExist(context, str, str2)) {
            return false;
        }
        bv a = bv.a();
        if (a == null || !a.b()) {
            return false;
        }
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        DexLoader b = a.c().b();
        TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
        Object invokeStaticMethod = b.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, new Object[]{context, str, str2, bitmap});
        TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + invokeStaticMethod);
        return invokeStaticMethod != null;
    }

    private static void d(Context context) {
        Throwable th;
        int i = -1;
        A = true;
        SharedPreferences sharedPreferences;
        int i2;
        int i3;
        try {
            sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            try {
                int i4;
                int i5 = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
                if (i5 >= 0) {
                    i5++;
                    if (i5 <= 4) {
                        i2 = i5;
                        i4 = i5;
                    } else {
                        return;
                    }
                }
                i2 = -1;
                i4 = i5;
                try {
                    i3 = an.a().i(context);
                    if (i3 > 0) {
                        if (i4 <= 4) {
                            try {
                                sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i4).commit();
                            } catch (Throwable th2) {
                                th = th2;
                                TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
                                i5 = -1;
                                if (i5 > 3) {
                                    try {
                                        i5 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                        Editor edit = sharedPreferences.edit();
                                        if (i5 == i3) {
                                            j.a(an.a().q(context), false);
                                            File a = ai.a(context).a();
                                            if (a != null) {
                                                j.a(a, false);
                                            }
                                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i3 + " is deleted!");
                                        } else {
                                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i3 + "; value:" + i5);
                                        }
                                        edit.putInt("tbs_precheck_disable_version", i5);
                                        edit.commit();
                                    } catch (Throwable th3) {
                                        TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(th3));
                                    }
                                }
                                if (i2 > 0 && i2 <= 3) {
                                    TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                    bv.a().a(context, null);
                                    TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                    i = 0;
                                }
                                try {
                                    i5 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                    if (i5 > 0) {
                                        sharedPreferences.edit().putInt("tbs_preload_x5_counter", i5 - 1).commit();
                                    }
                                } catch (Throwable th32) {
                                    TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(th32));
                                }
                                TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
                                return;
                            }
                        }
                        i5 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i5 >= 0) {
                            i5++;
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i5).commit();
                            if (i5 > 3) {
                                try {
                                    i5 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                    Editor edit2 = sharedPreferences.edit();
                                    if (i5 == i3) {
                                        j.a(an.a().q(context), false);
                                        File a2 = ai.a(context).a();
                                        if (a2 != null) {
                                            j.a(a2, false);
                                        }
                                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i3 + " is deleted!");
                                    } else {
                                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i3 + "; value:" + i5);
                                    }
                                    edit2.putInt("tbs_precheck_disable_version", i5);
                                    edit2.commit();
                                } catch (Throwable th322) {
                                    TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(th322));
                                }
                            }
                            if (i2 > 0 && i2 <= 3) {
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                bv.a().a(context, null);
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                i = 0;
                            }
                            try {
                                i5 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i5 > 0) {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i5 - 1).commit();
                                }
                            } catch (Throwable th3222) {
                                TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(th3222));
                            }
                            TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
                            return;
                        }
                        i5 = -1;
                        if (i5 > 3) {
                            if (i2 > 0 && i2 <= 3) {
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                bv.a().a(context, null);
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                i = 0;
                            }
                            try {
                                i5 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i5 > 0) {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i5 - 1).commit();
                                }
                            } catch (Throwable th32222) {
                                TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(th32222));
                            }
                            TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i);
                            return;
                        }
                        try {
                            i5 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                            Editor edit22 = sharedPreferences.edit();
                            if (i5 == i3) {
                                j.a(an.a().q(context), false);
                                File a22 = ai.a(context).a();
                                if (a22 != null) {
                                    j.a(a22, false);
                                }
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i3 + " is deleted!");
                            } else {
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i3 + "; value:" + i5);
                            }
                            edit22.putInt("tbs_precheck_disable_version", i5);
                            edit22.commit();
                        } catch (Throwable th322222) {
                            TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(th322222));
                        }
                    }
                } catch (Throwable th4) {
                    th322222 = th4;
                    i3 = -1;
                }
            } catch (Throwable th5) {
                th322222 = th5;
                i2 = -1;
                i3 = -1;
            }
        } catch (Throwable th6) {
            th322222 = th6;
            i2 = -1;
            sharedPreferences = null;
            i3 = -1;
        }
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        if (context == null || TbsDownloader.getOverSea(context)) {
            return false;
        }
        bv a = bv.a();
        if (a == null || !a.b()) {
            return false;
        }
        return a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, new Object[]{context, str, str2}) != null;
    }

    public static void disAllowThirdAppDownload() {
        c = false;
    }

    public static void disableAutoCreateX5Webview() {
        j = false;
    }

    public static void fileInfoDetect(Context context, String str, ValueCallback<String> valueCallback) {
        bv a = bv.a();
        if (a != null && a.b()) {
            try {
                a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, ValueCallback.class}, new Object[]{context, str, valueCallback});
            } catch (Throwable th) {
            }
        }
    }

    public static void forceSysWebView() {
        b = true;
        u = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static long getApkFileSize(Context context) {
        return context != null ? TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getLong("tbs_apkfilesize", 0) : 0;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        int i = 0;
        if (t instanceof String[]) {
            int length = t.length;
            String[] strArr = new String[length];
            while (i < length) {
                strArr[i] = str + t[i];
                i++;
            }
            return strArr;
        }
        Object a = q.a(r, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, context, context2, str);
        if (!(a instanceof String[])) {
            a = new String[]{""};
        }
        return (String[]) a;
    }

    public static boolean getDownloadWithoutWifi() {
        return D;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return b;
    }

    public static String getMiniQBVersion(Context context) {
        bv a = bv.a();
        a.a(context, null);
        return (a == null || !a.b()) ? null : a.c().f();
    }

    public static boolean getOnlyDownload() {
        return k;
    }

    public static String getQQBuildNumber() {
        return z;
    }

    public static Map<String, Object> getSettings() {
        return n;
    }

    public static boolean getTBSInstalling() {
        return E;
    }

    public static String getTID() {
        return y;
    }

    public static String getTbsResourcesPath(Context context) {
        return TbsShareManager.g(context);
    }

    public static int getTbsVersion(Context context) {
        if (TbsShareManager.isThirdPartyApp(context)) {
            return TbsShareManager.a(context, false);
        }
        int i = an.a().i(context);
        if (i != 0 || ai.a(context).c() != 3) {
            return i;
        }
        reset(context);
        return i;
    }

    public static int getTbsVersionForCrash(Context context) {
        if (TbsShareManager.isThirdPartyApp(context)) {
            return TbsShareManager.a(context, false);
        }
        int j = an.a().j(context);
        if (j != 0 || ai.a(context).c() != 3) {
            return j;
        }
        reset(context);
        return j;
    }

    public static void initBuglyAsync(boolean z) {
        i = z;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        if (n == null) {
            n = map;
            return;
        }
        try {
            n.putAll(map);
        } catch (Exception e) {
        }
    }

    public static void initX5Environment(Context context, PreInitCallback preInitCallback) {
        if (context != null) {
            b(context);
            C = new l(context, preInitCallback);
            if (TbsShareManager.isThirdPartyApp(context)) {
                an.a().b(context, true);
            }
            TbsDownloader.needDownload(context, false, false, new m(context, preInitCallback));
        }
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        o a = o.a(true);
        a.a(context, false, false, null);
        return (a == null || !a.b()) ? false : a.a().a(context, str, str2, bundle);
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            String substring = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            Object obj = "unknown";
            try {
                obj = context.getApplicationInfo().packageName;
            } catch (Exception e) {
            }
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, obj);
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "14004");
            if (d.a(context, "miniqb://home".equals(substring) ? "qb://navicard/addCard?cardId=168&cardName=168" : substring, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                bv a = bv.a();
                if (a != null && a.b() && a.c().a(context, substring, null, str2, null) == 0) {
                    return true;
                }
                webView.loadUrl(substring);
            }
        } else {
            webView.loadUrl(str);
        }
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        bv a = bv.a();
        if (a == null || !a.b()) {
            return false;
        }
        Object invokeStaticMethod = a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, new Object[]{context, str});
        if (invokeStaticMethod == null) {
            return false;
        }
        return (invokeStaticMethod instanceof Boolean ? (Boolean) invokeStaticMethod : Boolean.valueOf(false)).booleanValue();
    }

    public static boolean isTbsCoreInited() {
        o a = o.a(false);
        return a != null && a.g();
    }

    public static boolean isX5DisabledSync(Context context) {
        int i;
        if (ai.a(context).c() == 2) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 != 0) {
            return false;
        }
        if (!c(context)) {
            return true;
        }
        i2 = an.a().i(context);
        Object a = q.a(r, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), Integer.valueOf(43610));
        return a != null ? ((Boolean) a).booleanValue() : true;
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            preInit(context, null);
        }
    }

    public static synchronized void preInit(Context context, PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            TbsLog.initIfNeed(context);
            TbsLog.i("QbSdk", "preInit -- stack: " + Log.getStackTraceString(new Throwable("#")));
            l = a;
            if (!s) {
                k kVar = new k(context, new j(Looper.getMainLooper(), preInitCallback, context));
                kVar.setName("tbs_preinit");
                kVar.setPriority(10);
                kVar.start();
                s = true;
            }
        }
    }

    public static void reset(Context context) {
        reset(context, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void reset(android.content.Context r5, boolean r6) {
        /*
        r0 = 1;
        r1 = 0;
        r2 = "QbSdk";
        r3 = "QbSdk reset!";
        com.tencent.smtt.utils.TbsLog.e(r2, r3, r0);
        com.tencent.smtt.sdk.TbsDownloader.stopDownload();	 Catch:{ Throwable -> 0x0085 }
        if (r6 == 0) goto L_0x00a1;
    L_0x0010:
        r2 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r5);	 Catch:{ Throwable -> 0x0085 }
        if (r2 != 0) goto L_0x00a1;
    L_0x0016:
        r2 = com.tencent.smtt.sdk.an.a();	 Catch:{ Throwable -> 0x0085 }
        r2 = r2.h(r5);	 Catch:{ Throwable -> 0x0085 }
        r3 = com.tencent.smtt.sdk.an.a();	 Catch:{ Throwable -> 0x0085 }
        r3 = r3.i(r5);	 Catch:{ Throwable -> 0x0085 }
        r4 = 43300; // 0xa924 float:6.0676E-41 double:2.1393E-319;
        if (r2 <= r4) goto L_0x00a1;
    L_0x002b:
        if (r2 == r3) goto L_0x00a1;
    L_0x002d:
        com.tencent.smtt.sdk.TbsDownloader.b(r5);	 Catch:{ Throwable -> 0x0085 }
        r1 = "tbs";
        r2 = 0;
        r1 = r5.getDir(r1, r2);	 Catch:{ Throwable -> 0x0085 }
        r2 = 0;
        r3 = "core_share_decouple";
        com.tencent.smtt.utils.j.a(r1, r2, r3);	 Catch:{ Throwable -> 0x0085 }
        r1 = "QbSdk";
        r2 = "delete downloaded apk success";
        r3 = 1;
        com.tencent.smtt.utils.TbsLog.i(r1, r2, r3);	 Catch:{ Throwable -> 0x0085 }
        r1 = com.tencent.smtt.sdk.an.a;	 Catch:{ Throwable -> 0x0085 }
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x0085 }
        r1.set(r2);	 Catch:{ Throwable -> 0x0085 }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x0085 }
        r2 = r5.getFilesDir();	 Catch:{ Throwable -> 0x0085 }
        r3 = "bugly_switch.txt";
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0085 }
        r2 = r1.exists();	 Catch:{ Throwable -> 0x0085 }
        if (r2 == 0) goto L_0x0068;
    L_0x0065:
        r1.delete();	 Catch:{ Throwable -> 0x0085 }
    L_0x0068:
        if (r0 == 0) goto L_0x0084;
    L_0x006a:
        r0 = com.tencent.smtt.sdk.an.a();	 Catch:{ Throwable -> 0x0085 }
        r0 = r0.p(r5);	 Catch:{ Throwable -> 0x0085 }
        r1 = com.tencent.smtt.sdk.an.a();	 Catch:{ Throwable -> 0x0085 }
        r1 = r1.t(r5);	 Catch:{ Throwable -> 0x0085 }
        com.tencent.smtt.utils.j.b(r0, r1);	 Catch:{ Throwable -> 0x0085 }
        r0 = com.tencent.smtt.sdk.an.a();	 Catch:{ Throwable -> 0x0085 }
        r0.b(r5);	 Catch:{ Throwable -> 0x0085 }
    L_0x0084:
        return;
    L_0x0085:
        r0 = move-exception;
        r1 = "QbSdk";
        r2 = new java.lang.StringBuilder;
        r3 = "QbSdk reset exception:";
        r2.<init>(r3);
        r0 = android.util.Log.getStackTraceString(r0);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.smtt.utils.TbsLog.e(r1, r0);
        goto L_0x0084;
    L_0x00a1:
        r0 = r1;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.reset(android.content.Context, boolean):void");
    }

    public static void resetDecoupleCore(Context context) {
        TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            j.b(an.a().p(context));
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(th));
        }
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            y = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static void setDeviceInfo(String str, String str2, String str3, String str4) {
        b.a = str;
        b.b = str2;
        b.c = str3;
        b.d = str4;
    }

    public static void setDownloadWithoutWifi(boolean z) {
        D = z;
    }

    public static void setOnlyDownload(boolean z) {
        k = z;
    }

    public static void setQQBuildNumber(String str) {
        z = str;
    }

    public static void setTBSInstallingStatus(boolean z) {
        E = z;
    }

    public static void setTbsListener(TbsListener tbsListener) {
        B = tbsListener;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        TbsLog.setTbsLogClient(tbsLogClient);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        TbsCoreLoadStat.getInstance().a(context, 501);
        if (context == null) {
            return -100;
        }
        bv a = bv.a();
        a.a(context, null);
        if (!a.b()) {
            TbsCoreLoadStat.getInstance().a(context, 502);
            return -102;
        } else if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
            return -101;
        } else {
            int a2 = a.c().a(context, str, hashMap, null, valueCallback);
            if (a2 == 0) {
                TbsCoreLoadStat.getInstance().a(context, 503);
                return a2;
            }
            TbsLogReport.a(context).b(504, String.valueOf(a2));
            return a2;
        }
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return d.a(context, str, i2, str2, hashMap, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return d.a(context, str, hashMap);
    }

    public static boolean startQBToLoadurl(Context context, String str, int i, WebView webView) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if (str2 == "com.tencent.mm" || str2 == "com.tencent.mobileqq") {
                    bv a = bv.a();
                    if (a != null && a.b()) {
                        Object invokeStaticMethod = a.c().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
                        if (invokeStaticMethod != null) {
                            IX5WebViewBase iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
                            if (iX5WebViewBase != null) {
                                webView = (WebView) iX5WebViewBase.getView().getParent();
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return d.a(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        if (context == null) {
            return false;
        }
        bv a = bv.a();
        a.a(context, null);
        String str2 = "QbSdk.startMiniQBToLoadUrl";
        if (hashMap != null && "5".equals(hashMap.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && a.b()) {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
        }
        if (d.a(context, str, hashMap, str2, null) == 0) {
            return true;
        }
        if (a.b()) {
            if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
                return false;
            }
            if (a.c().a(context, str, hashMap, null, valueCallback) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void unForceSysWebView() {
        b = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static boolean useSoftWare() {
        if (r == null) {
            return false;
        }
        Object a = q.a(r, "useSoftWare", new Class[0], new Object[0]);
        if (a == null) {
            a = q.a(r, "useSoftWare", new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
        }
        return a == null ? false : ((Boolean) a).booleanValue();
    }
}
