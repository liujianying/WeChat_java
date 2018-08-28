package com.tencent.liteav.basic.d;

import android.opengl.GLES20;

class d$1 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ float b;
    final /* synthetic */ d c;

    d$1(d dVar, int i, float f) {
        this.c = dVar;
        this.a = i;
        this.b = f;
    }

    public void run() {
        GLES20.glUniform1f(this.a, this.b);
    }
}
