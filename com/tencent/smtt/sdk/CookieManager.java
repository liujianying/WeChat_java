package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.q;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CookieManager {
    public static String LOGTAG = "CookieManager";
    private static CookieManager d;
    ArrayList<b> a;
    String b;
    a c = a.MODE_NONE;
    private boolean e = false;
    private boolean f = false;

    public enum a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        if (d == null) {
            synchronized (CookieManager.class) {
                if (d == null) {
                    d = new CookieManager();
                }
            }
        }
        return d;
    }

    public static int getROMCookieDBVersion(Context context) {
        return (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("cookiedb_info", 4) : context.getSharedPreferences("cookiedb_info", 0)).getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(Context context, int i) {
        Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("cookiedb_info", 4) : context.getSharedPreferences("cookiedb_info", 0)).edit();
        edit.putInt("db_version", i);
        edit.commit();
    }

    synchronized void a() {
        this.f = true;
        if (!(this.a == null || this.a.size() == 0)) {
            bv a = bv.a();
            Iterator it;
            b bVar;
            if (a != null && a.b()) {
                it = this.a.iterator();
                while (it.hasNext()) {
                    bVar = (b) it.next();
                    switch (bVar.a) {
                        case 1:
                            setCookie(bVar.b, bVar.c, bVar.d);
                            break;
                        case 2:
                            setCookie(bVar.b, bVar.c);
                            break;
                        default:
                            break;
                    }
                }
            }
            it = this.a.iterator();
            while (it.hasNext()) {
                bVar = (b) it.next();
                switch (bVar.a) {
                    case 1:
                        if (VERSION.SDK_INT < 21) {
                            break;
                        }
                        q.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, new Object[]{bVar.b, bVar.c, bVar.d});
                        break;
                    case 2:
                        android.webkit.CookieManager.getInstance().setCookie(bVar.b, bVar.c);
                        break;
                    default:
                        break;
                }
            }
            this.a.clear();
        }
    }

    protected synchronized void a(Context context, boolean z, boolean z2) {
        if (!(this.c == a.MODE_NONE || context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, "cookie_switch.txt") || this.e)) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = 0;
            TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:" + z + ",useX5:" + z2);
            if (z || QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.a) {
                if (QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.a) {
                    z2 = false;
                }
                boolean canUseFunction = TbsExtensionFunctionManager.getInstance().canUseFunction(context, "usex5.txt");
                TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + canUseFunction + ",useX5:" + z2);
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(context, "usex5.txt", z2);
                if (canUseFunction != z2) {
                    int i;
                    int i2;
                    TbsLogInfo a = TbsLogReport.a(context).a();
                    if (TextUtils.isEmpty(this.b)) {
                        a.setErrorCode(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL);
                        i = 0;
                        i2 = 0;
                    } else if (an.a().m(context) <= 0 || an.a().m(context) >= 36001) {
                        boolean z3;
                        if (canUseFunction) {
                            i2 = x.d(context);
                            if (i2 > 0) {
                                i = getROMCookieDBVersion(context);
                                z3 = i <= 0;
                            }
                            z3 = false;
                            i = 0;
                        } else {
                            i2 = x.d(context);
                            if (i2 > 0) {
                                Object c = an.a().c(context, "cookies_database_version");
                                if (!TextUtils.isEmpty(c)) {
                                    try {
                                        i = Integer.parseInt(c);
                                        z3 = false;
                                    } catch (Exception e) {
                                    }
                                }
                            }
                            z3 = false;
                            i = 0;
                        }
                        if (!z3 && (i2 <= 0 || i <= 0)) {
                            a.setErrorCode(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_HTTP_LOCATION_HEADER_IS_NULL);
                        } else if (i >= i2) {
                            a.setErrorCode(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_WRITE_FILE_FAILED);
                        } else {
                            x.a(context, this.c, this.b, z3, z2);
                            a.setErrorCode(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_PARSER_CONTENT_FAILED);
                            j = System.currentTimeMillis() - currentTimeMillis;
                        }
                    }
                    a.setFailDetail("x5->sys:" + canUseFunction + " from:" + i2 + " to:" + i + ",timeused:" + j);
                    TbsLogReport.a(context).a(EventType.TYPE_COOKIE_DB_SWITCH, a);
                }
            } else {
                bv.a().a(context, null);
            }
        }
    }

    public boolean acceptCookie() {
        bv a = bv.a();
        return (a == null || !a.b()) ? android.webkit.CookieManager.getInstance().acceptCookie() : a.c().d();
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        boolean booleanValue;
        bv a = bv.a();
        Object invokeStaticMethod;
        if (a != null && a.b()) {
            invokeStaticMethod = a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, new Object[]{webView.getView()});
            booleanValue = invokeStaticMethod != null ? ((Boolean) invokeStaticMethod).booleanValue() : true;
        } else if (VERSION.SDK_INT < 21) {
            booleanValue = true;
        } else {
            invokeStaticMethod = q.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new Class[]{WebView.class}, new Object[]{webView.getView()});
            booleanValue = invokeStaticMethod != null ? ((Boolean) invokeStaticMethod).booleanValue() : false;
        }
        return booleanValue;
    }

    public void flush() {
        bv a = bv.a();
        if (a != null && a.b()) {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else if (VERSION.SDK_INT >= 21) {
            q.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        bv a = bv.a();
        if (a != null && a.b()) {
            return a.c().a(str);
        }
        String str2 = null;
        try {
            return android.webkit.CookieManager.getInstance().getCookie(str);
        } catch (Throwable th) {
            return str2;
        }
    }

    public boolean hasCookies() {
        bv a = bv.a();
        return (a == null || !a.b()) ? android.webkit.CookieManager.getInstance().hasCookies() : a.c().h();
    }

    public void removeAllCookie() {
        if (this.a != null) {
            this.a.clear();
        }
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        } else {
            a.c().e();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        if (this.a != null) {
            this.a.clear();
        }
        bv a = bv.a();
        if (a != null && a.b()) {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{ValueCallback.class}, new Object[]{valueCallback});
        } else if (VERSION.SDK_INT >= 21) {
            q.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[]{ValueCallback.class}, new Object[]{valueCallback});
        }
    }

    public void removeExpiredCookie() {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        } else {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookie() {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        } else {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        bv a = bv.a();
        if (a != null && a.b()) {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{ValueCallback.class}, new Object[]{valueCallback});
        } else if (VERSION.SDK_INT >= 21) {
            q.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[]{ValueCallback.class}, new Object[]{valueCallback});
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            try {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z);
            } catch (Throwable th) {
            }
        } else {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        bv a = bv.a();
        if (a != null && a.b()) {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, new Object[]{webView.getView(), Boolean.valueOf(z)});
        } else if (VERSION.SDK_INT >= 21) {
            q.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}, new Object[]{webView.getView(), Boolean.valueOf(z)});
        }
    }

    public synchronized void setCookie(String str, String str2) {
        setCookie(str, str2, false);
    }

    public synchronized void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            if (!bv.a().d()) {
                b bVar = new b(this);
                bVar.a = 1;
                bVar.b = str;
                bVar.c = str2;
                bVar.d = valueCallback;
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                this.a.add(bVar);
            }
            if (this.f && VERSION.SDK_INT >= 21) {
                q.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, new Object[]{str, str2, valueCallback});
            }
        } else {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, ValueCallback.class}, new Object[]{str, str2, valueCallback});
        }
    }

    public synchronized void setCookie(String str, String str2, boolean z) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            if (this.f || z) {
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
            if (!bv.a().d()) {
                b bVar = new b(this);
                bVar.a = 2;
                bVar.b = str;
                bVar.c = str2;
                bVar.d = null;
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                this.a.add(bVar);
            }
        } else {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, new Object[]{str, str2});
        }
    }

    public boolean setCookieCompatialbeMode(Context context, a aVar, String str, boolean z) {
        System.currentTimeMillis();
        if (context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, "cookie_switch.txt")) {
            return false;
        }
        this.c = aVar;
        if (str != null) {
            this.b = str;
        }
        if (!(this.c == a.MODE_NONE || !z || bv.a().d())) {
            bv.a().a(context, null);
        }
        return true;
    }

    public void setCookies(Map<String, String[]> map) {
        bv a = bv.a();
        boolean a2 = (a == null || !a.b()) ? false : a.c().a(map);
        if (!a2) {
            for (String str : map.keySet()) {
                for (String cookie : (String[]) map.get(str)) {
                    setCookie(str, cookie);
                }
            }
        }
    }
}
