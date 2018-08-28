package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class b implements Renderer {
    static float[] fao = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    static float[] fap = new float[]{-1.0f, -0.5f, 1.0f, -0.5f, -1.0f, 0.5f, 1.0f, 0.5f};
    private static final float[] faq = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private int bYE = 0;
    boolean bum = false;
    private int faA;
    private int faB;
    private int faC;
    private int faD;
    private int faE;
    private int faF;
    private FloatBuffer faG;
    private FloatBuffer faH;
    private float[] faI = new float[16];
    boolean faJ = false;
    private float[] faK = fao;
    private boolean faL = false;
    private int far = 0;
    private int fas = 0;
    private byte[] fat = null;
    private int fau = 0;
    private int fav = 0;
    ByteBuffer faw;
    ByteBuffer fax;
    private int fay;
    private int faz;

    public b() {
        Point bdF = d.bdF();
        float f = (((float) bdF.x) / ((float) bdF.y)) / 2.0f;
        fap = new float[]{-1.0f, -f, 1.0f, -f, -1.0f, f, 1.0f, f};
    }

    public final void b(byte[] bArr, int i, int i2, int i3, boolean z) {
        try {
            int i4;
            if (this.fav == i2 && this.fau == i && this.bYE == i3 && this.faL == z) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            if (i4 != 0) {
                x.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(true), this});
            }
            this.fat = bArr;
            this.fau = i;
            this.fav = i2;
            this.bYE = i3;
            this.faL = z;
            if (i4 != 0) {
                this.faw = ByteBuffer.allocateDirect(i2 * i);
                this.fax = ByteBuffer.allocateDirect((i * i2) / 2);
                this.faw.order(ByteOrder.nativeOrder());
                this.fax.order(ByteOrder.nativeOrder());
                if (z) {
                    this.faK = fap;
                } else {
                    this.faK = fao;
                }
                if (this.faK != null) {
                    this.faG.put(this.faK);
                    this.faG.position(0);
                }
            }
            if (this.faw != null && this.fax != null) {
                this.faw.put(bArr, 0, i * i2);
                this.faw.position(0);
                this.fax.put(bArr, i * i2, (i * i2) / 2);
                this.fax.position(0);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        x.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[]{this});
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glDisable(2929);
        this.faA = com.tencent.mm.plugin.api.recordView.b.aQ("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (this.faA == 0) {
            x.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
        }
        this.faC = GLES20.glGetAttribLocation(this.faA, "a_position");
        this.faB = GLES20.glGetAttribLocation(this.faA, "a_texCoord");
        this.faD = GLES20.glGetUniformLocation(this.faA, "y_texture");
        this.faE = GLES20.glGetUniformLocation(this.faA, "uv_texture");
        this.faF = GLES20.glGetUniformLocation(this.faA, "uMatrix");
        this.fay = com.tencent.mm.plugin.api.recordView.b.ZQ();
        this.faz = com.tencent.mm.plugin.api.recordView.b.ZQ();
        this.faG = ByteBuffer.allocateDirect(this.faK.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.faG.put(this.faK);
        this.faG.position(0);
        this.faH = ByteBuffer.allocateDirect(faq.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.faH.put(faq);
        this.faH.position(0);
        x.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[]{Integer.valueOf(this.fay), Integer.valueOf(this.faz), this});
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        x.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this});
        if (i != this.far || i2 != this.fas) {
            x.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i, i2);
            this.far = i;
            this.fas = i2;
        }
    }

    public final void onDrawFrame(GL10 gl10) {
        bi.VG();
        this.bum = true;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (this.faJ) {
            x.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
            this.faJ = false;
            this.bum = false;
            this.fat = null;
            this.fau = -1;
            this.fav = -1;
            return;
        }
        if (!(this.faA == 0 || this.fay == -1 || this.faz == -1 || this.fau <= 0 || this.fav <= 0 || this.fat == null)) {
            GLES20.glUseProgram(this.faA);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.fay);
            GLES20.glTexImage2D(3553, 0, 6409, this.fau, this.fav, 0, 6409, 5121, this.faw);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.faD, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.faz);
            GLES20.glTexImage2D(3553, 0, 6410, this.fau / 2, this.fav / 2, 0, 6410, 5121, this.fax);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.faE, 1);
            Matrix.setIdentityM(this.faI, 0);
            Matrix.setRotateM(this.faI, 0, (float) this.bYE, 0.0f, 0.0f, -1.0f);
            GLES20.glUniformMatrix4fv(this.faF, 1, false, this.faI, 0);
            this.faG.position(0);
            GLES20.glVertexAttribPointer(this.faC, 2, 5126, false, 0, this.faG);
            GLES20.glEnableVertexAttribArray(this.faC);
            this.faH.position(0);
            GLES20.glVertexAttribPointer(this.faB, 2, 5126, false, 0, this.faH);
            GLES20.glEnableVertexAttribArray(this.faB);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.faC);
            GLES20.glDisableVertexAttribArray(this.faB);
            GLES20.glBindTexture(3553, 0);
        }
        this.bum = false;
    }
}
