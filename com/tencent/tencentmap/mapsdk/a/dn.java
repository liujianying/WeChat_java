package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public abstract class dn {
    protected final int a;
    protected final int b;
    protected Context c;
    protected String d;

    public abstract cn a();

    public abstract void b(boolean z);

    public dn(Context context, int i, int i2) {
        this.c = context;
        this.a = i2;
        this.b = i;
    }

    public final int c() {
        return this.a;
    }

    public final synchronized String d() {
        return this.d;
    }

    public final String e() {
        try {
            if (this.b == 0) {
                return cf.a(this.c).e().b();
            }
            return cf.a(this.c).e().b(this.b).b();
        } catch (Throwable th) {
            ct.c("imposiable comStrategy error:%s", new Object[]{th.toString()});
            ct.a(th);
            return null;
        }
    }

    public static cn a(int i, byte[] bArr) {
        try {
            return e.a(i, c.m(), bArr, 2, 3);
        } catch (Throwable th) {
            ct.c("imposiable comStrategy error:%s", new Object[]{th.toString()});
            ct.a(th);
            return null;
        }
    }

    public void b() {
        ct.c("encode failed, clear db data", new Object[0]);
    }
}
