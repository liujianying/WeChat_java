package com.tencent.smtt.sdk;

import android.content.ContentResolver;

@Deprecated
public class WebIconDatabase {
    private static WebIconDatabase a;

    private WebIconDatabase() {
    }

    private static synchronized WebIconDatabase a() {
        WebIconDatabase webIconDatabase;
        synchronized (WebIconDatabase.class) {
            if (a == null) {
                a = new WebIconDatabase();
            }
            webIconDatabase = a;
        }
        return webIconDatabase;
    }

    public static WebIconDatabase getInstance() {
        return a();
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, a aVar) {
    }

    public void close() {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebIconDatabase.getInstance().close();
        } else {
            a.c().m();
        }
    }

    public void open(String str) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebIconDatabase.getInstance().open(str);
        } else {
            a.c().b(str);
        }
    }

    public void releaseIconForPageUrl(String str) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
        } else {
            a.c().d(str);
        }
    }

    public void removeAllIcons() {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        } else {
            a.c().l();
        }
    }

    public void requestIconForPageUrl(String str, a aVar) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, new bl(this, aVar));
        } else {
            a.c().a(str, new bk(this, aVar));
        }
    }

    public void retainIconForPageUrl(String str) {
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
        } else {
            a.c().c(str);
        }
    }
}
