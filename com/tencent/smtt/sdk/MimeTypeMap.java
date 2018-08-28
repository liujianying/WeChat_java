package com.tencent.smtt.sdk;

public class MimeTypeMap {
    private static MimeTypeMap a;

    private MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String str) {
        bv a = bv.a();
        return (a == null || !a.b()) ? android.webkit.MimeTypeMap.getFileExtensionFromUrl(str) : a.c().h(str);
    }

    public static synchronized MimeTypeMap getSingleton() {
        MimeTypeMap mimeTypeMap;
        synchronized (MimeTypeMap.class) {
            if (a == null) {
                a = new MimeTypeMap();
            }
            mimeTypeMap = a;
        }
        return mimeTypeMap;
    }

    public String getExtensionFromMimeType(String str) {
        bv a = bv.a();
        return (a == null || !a.b()) ? android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str) : a.c().l(str);
    }

    public String getMimeTypeFromExtension(String str) {
        bv a = bv.a();
        return (a == null || !a.b()) ? android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str) : a.c().j(str);
    }

    public boolean hasExtension(String str) {
        bv a = bv.a();
        return (a == null || !a.b()) ? android.webkit.MimeTypeMap.getSingleton().hasExtension(str) : a.c().k(str);
    }

    public boolean hasMimeType(String str) {
        bv a = bv.a();
        return (a == null || !a.b()) ? android.webkit.MimeTypeMap.getSingleton().hasMimeType(str) : a.c().i(str);
    }
}
