package com.tencent.c.e.a;

import android.content.Context;
import com.tencent.c.e.a.a.f;

public final class d$a {
    int action;
    Context context;
    int requestType;
    long sHg;
    public long vjA;
    int vjz;

    public /* synthetic */ d$a(Context context, int i, int i2, byte b) {
        this(context, i, i2);
    }

    private d$a(Context context, int i, int i2) {
        this.requestType = 0;
        this.vjz = 0;
        this.action = 0;
        this.vjA = f.vjS * 12;
        this.sHg = 0;
        if (i < 0) {
            throw new IllegalArgumentException("scenes invalid: " + i);
        }
        this.context = context.getApplicationContext();
        this.vjz = i;
        this.action = i2;
    }
}
