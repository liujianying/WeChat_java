package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.mm.booter.notification.a.f.a;

public final class g {
    public int cZA;
    public boolean cZB;
    private int cZC = -1;
    private int cZD = -1;
    public boolean cZE;
    public boolean cZF;
    public b cZr;
    public c cZs;
    public d cZt;
    public h cZu;
    private f cZv;
    public a cZw;
    public int cZx;
    public int cZy;
    public int cZz;
    public Context mContext;

    public g(Context context) {
        this.mContext = context;
        this.cZr = new b();
        this.cZs = new c();
        this.cZt = new d();
        this.cZu = new h();
        this.cZw = new a();
        this.cZv = a.yl();
    }

    public final void eR(String str) {
        this.cZv.eQ(str);
    }

    public static String c(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        String str = "";
        for (long valueOf : jArr) {
            str = str + String.valueOf(valueOf) + ",";
        }
        return !str.isEmpty() ? str.substring(0, str.length() - 1) : str;
    }
}
