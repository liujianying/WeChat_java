package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.tencentmap.mapsdk.a.tc.a;

public /* synthetic */ class sf$1 {
    protected float a = 0.9f;
    protected int b = 0;
    final Handler c = new sj(this);
    private a d = a.a;
    private int e = 256;
    private boolean f = true;
    private boolean g = true;
    private boolean h = false;
    private boolean i = true;
    private int j = 0;
    private int k = 0;
    private sl l;

    protected sf$1(sl slVar) {
        this.l = slVar;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int i = sl.a().getResources().getDisplayMetrics().densityDpi;
        if (i <= 120) {
            this.b = 1;
            this.a = 0.5f;
        } else if (i <= JsApiSetBackgroundAudioState.CTRL_INDEX) {
            this.b = 2;
            this.a = 0.8f;
        } else if (i <= aq.CTRL_BYTE) {
            this.b = 3;
            this.a = 0.87f;
        } else if (i <= 320) {
            this.a = 1.0f;
            this.b = 4;
        } else if (i <= 480) {
            this.a = 1.5f;
            this.b = 5;
        } else {
            this.a = 1.8f;
            this.b = 6;
        }
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void a(boolean z) {
        this.h = z;
        this.c.obtainMessage(1).sendToTarget();
    }

    public float b() {
        return this.a;
    }

    public void b(int i) {
        this.j = i;
        this.l.b(i);
    }

    public void b(boolean z) {
        this.f = z;
    }

    public a c() {
        return this.d;
    }

    public void c(int i) {
        this.k = i;
        this.l.c(i);
    }

    public void c(boolean z) {
        this.g = z;
    }

    public int d() {
        return this.e;
    }

    public void d(boolean z) {
        this.i = z;
    }

    public boolean e() {
        return this.d == a.b;
    }

    public int f() {
        return this.k;
    }

    public boolean g() {
        return this.h;
    }

    public boolean h() {
        return this.f;
    }

    public boolean i() {
        return this.g;
    }

    public int j() {
        return this.j;
    }

    public boolean k() {
        return this.i;
    }
}
