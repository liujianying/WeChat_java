package com.tencent.liteav.basic.d;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

class d$2 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ float[] b;
    final /* synthetic */ d c;

    d$2(d dVar, int i, float[] fArr) {
        this.c = dVar;
        this.a = i;
        this.b = fArr;
    }

    public void run() {
        GLES20.glUniform2fv(this.a, 1, FloatBuffer.wrap(this.b));
    }
}
