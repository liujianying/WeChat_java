package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public class pn {
    private static pn c;
    private pm a = new pq();
    private boolean b = false;

    public static synchronized pn a() {
        pn pnVar;
        synchronized (pn.class) {
            if (c == null) {
                c = new pn();
            }
            pnVar = c;
        }
        return pnVar;
    }

    private pn() {
    }

    public void a(Context context) {
        if (!this.b && this.a != null) {
            this.a.a(context.getApplicationContext());
            this.b = true;
        }
    }

    public po a(String str) {
        if (this.a == null) {
            return null;
        }
        return this.a.a(str);
    }

    public po a(String str, String str2) {
        if (this.a == null) {
            return null;
        }
        return this.a.a(str, str2);
    }

    public po a(String str, String str2, byte[] bArr) {
        if (this.a == null) {
            return null;
        }
        return this.a.a(str, str2, bArr);
    }
}
