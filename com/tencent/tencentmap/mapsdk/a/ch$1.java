package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.util.Date;

class ch$1 implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ String b;
    private /* synthetic */ Context c;
    private /* synthetic */ ch d;

    ch$1(ch chVar, String str, String str2, Context context) {
        this.d = chVar;
        this.a = str;
        this.b = str2;
        this.c = context;
    }

    public final void run() {
        long time;
        Object[] objArr = new Object[2];
        objArr[0] = this.a;
        try {
            time = e.d(this.b).getTime() / 1000;
        } catch (Exception e) {
            time = 0;
        }
        if (time == 0) {
            time = (new Date().getTime() / 1000) + 86400;
        }
        objArr[1] = Long.valueOf(time);
        Context context = this.c;
        this.d.getClass();
        e.a(context, "sid", objArr);
    }
}
