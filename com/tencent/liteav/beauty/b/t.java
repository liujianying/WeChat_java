package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.d;

public class t extends s {
    protected float u;

    public boolean b() {
        if (super.b() && GLES20.glGetError() == 0) {
            return true;
        }
        return false;
    }

    protected void r() {
        float q = q();
        d dVar = (d) this.r.get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(dVar.o(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(dVar.o(), "texelHeightOffset");
        dVar.a(glGetUniformLocation, q / ((float) this.e));
        dVar.a(glGetUniformLocation2, 0.0f);
        q = p();
        dVar = (d) this.r.get(1);
        glGetUniformLocation = GLES20.glGetUniformLocation(dVar.o(), "texelWidthOffset");
        glGetUniformLocation2 = GLES20.glGetUniformLocation(dVar.o(), "texelHeightOffset");
        dVar.a(glGetUniformLocation, 0.0f);
        dVar.a(glGetUniformLocation2, q / ((float) this.f));
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        r();
    }

    public float p() {
        return this.u;
    }

    public float q() {
        return this.u;
    }
}
