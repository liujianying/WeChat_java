package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import java.util.Set;

public class GeolocationPermissions {
    private static GeolocationPermissions a;

    private static synchronized GeolocationPermissions a() {
        GeolocationPermissions geolocationPermissions;
        synchronized (GeolocationPermissions.class) {
            if (a == null) {
                a = new GeolocationPermissions();
            }
            geolocationPermissions = a;
        }
        return geolocationPermissions;
    }

    public static GeolocationPermissions getInstance() {
        return a();
    }

    public void allow(String str) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
        } else {
            a.c().g(str);
        }
    }

    public void clear(String str) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
        } else {
            a.c().f(str);
        }
    }

    public void clearAll() {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
        } else {
            a.c().o();
        }
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
        } else {
            a.c().c(str, valueCallback);
        }
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
        } else {
            a.c().b((ValueCallback) valueCallback);
        }
    }
}
