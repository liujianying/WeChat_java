package com.tencent.tencentmap.mapsdk.a;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

public class tw$a extends LayoutParams {
    public int a;
    private int b;
    private qw c;
    private int d;
    private int e;

    public tw$a(int i, int i2, qw qwVar, int i3) {
        this(i, i2, qwVar, 0, 0, i3);
    }

    public tw$a(int i, int i2, qw qwVar, int i3, int i4, int i5) {
        super(i, i2);
        this.a = 1;
        this.b = 51;
        this.c = null;
        this.d = 0;
        this.e = 0;
        this.a = 0;
        a(qwVar);
        this.d = i3;
        this.e = i4;
        this.b = i5;
    }

    protected tw$a(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.a = 1;
        this.b = 51;
        this.c = null;
        this.d = 0;
        this.e = 0;
    }

    public qw a() {
        return this.c;
    }

    public void a(qw qwVar) {
        this.c = qwVar;
    }
}
