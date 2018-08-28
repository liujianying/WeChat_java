package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

final class d {
    static float[] fao = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    static final float[] faq = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    static final Object lock = new Object();
    int bYE;
    boolean bum;
    int faA;
    int faB;
    int faC;
    int faD;
    int faE;
    int faF;
    FloatBuffer faG;
    FloatBuffer faH;
    float[] faI;
    float[] faK;
    private int far;
    private int fas;
    int fau;
    int fav;
    ByteBuffer faw;
    ByteBuffer fax;
    int fay;
    int faz;
    volatile boolean fbg;
    volatile boolean fbh;

    public d() {
        this.far = 0;
        this.fas = 0;
        this.bum = false;
        this.fau = 0;
        this.fav = 0;
        this.bYE = 0;
        this.fay = -1;
        this.faz = -1;
        this.faA = -1;
        this.faI = new float[16];
        this.faK = fao;
        this.fbg = false;
        this.fbh = false;
        this.fbg = false;
    }

    public final void bz(int i, int i2) {
        x.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this});
        if (i != this.far || i2 != this.fas) {
            x.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i, i2);
            this.far = i;
            this.fas = i2;
        }
    }
}
