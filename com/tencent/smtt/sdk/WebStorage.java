package com.tencent.smtt.sdk;

import java.util.Map;

public class WebStorage {
    private static WebStorage a;

    private static synchronized WebStorage a() {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            if (a == null) {
                a = new WebStorage();
            }
            webStorage = a;
        }
        return webStorage;
    }

    public static WebStorage getInstance() {
        return a();
    }

    public void deleteAllData() {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebStorage.getInstance().deleteAllData();
        } else {
            a.c().n();
        }
    }

    public void deleteOrigin(String str) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
        } else {
            a.c().e(str);
        }
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
        } else {
            a.c().a(valueCallback);
        }
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
        } else {
            a.c().b(str, valueCallback);
        }
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
        } else {
            a.c().a(str, valueCallback);
        }
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j);
        } else {
            a.c().a(str, j);
        }
    }
}
