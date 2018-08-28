package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class c extends Thread {
    private d faY;
    private SurfaceTexture fba;
    private EGL10 fbb;
    private EGLDisplay fbc = EGL10.EGL_NO_DISPLAY;
    private EGLContext fbd = EGL10.EGL_NO_CONTEXT;
    private EGLSurface fbe = EGL10.EGL_NO_SURFACE;
    volatile boolean fbf;

    public c(SurfaceTexture surfaceTexture, d dVar) {
        this.fba = surfaceTexture;
        this.faY = dVar;
    }

    public final void run() {
        Object obj;
        x.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
        this.fbb = (EGL10) EGLContext.getEGL();
        this.fbc = this.fbb.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.fbc == EGL10.EGL_NO_DISPLAY) {
            x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", new Object[]{GLUtils.getEGLErrorString(this.fbb.eglGetError())});
            obj = -1;
        } else {
            if (this.fbb.eglInitialize(this.fbc, new int[2])) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (this.fbb.eglChooseConfig(this.fbc, new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                    this.fbd = this.fbb.eglCreateContext(this.fbc, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    this.fbe = this.fbb.eglCreateWindowSurface(this.fbc, eGLConfigArr[0], this.fba, null);
                    if (this.fbe != EGL10.EGL_NO_SURFACE && this.fbd != EGL10.EGL_NO_CONTEXT) {
                        if (!this.fbb.eglMakeCurrent(this.fbc, this.fbe, this.fbe, this.fbd)) {
                            x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", new Object[]{GLUtils.getEGLErrorString(this.fbb.eglGetError())});
                        }
                        obj = null;
                    } else if (this.fbb.eglGetError() == 12299) {
                        x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                        obj = -1;
                    } else {
                        x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", new Object[]{GLUtils.getEGLErrorString(this.fbb.eglGetError())});
                        obj = -1;
                    }
                } else {
                    x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", new Object[]{GLUtils.getEGLErrorString(this.fbb.eglGetError())});
                    obj = -1;
                }
            } else {
                x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", new Object[]{GLUtils.getEGLErrorString(this.fbb.eglGetError())});
                obj = -1;
            }
        }
        if (obj < null) {
            x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
            return;
        }
        d dVar;
        if (this.faY != null) {
            dVar = this.faY;
            synchronized (d.lock) {
                x.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", new Object[]{dVar});
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glDisable(2929);
                dVar.faA = b.aQ("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
                if (dVar.faA == 0) {
                    x.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
                }
                dVar.faC = GLES20.glGetAttribLocation(dVar.faA, "a_position");
                dVar.faB = GLES20.glGetAttribLocation(dVar.faA, "a_texCoord");
                dVar.faD = GLES20.glGetUniformLocation(dVar.faA, "y_texture");
                dVar.faE = GLES20.glGetUniformLocation(dVar.faA, "uv_texture");
                dVar.faF = GLES20.glGetUniformLocation(dVar.faA, "uMatrix");
                dVar.fay = b.ZQ();
                dVar.faz = b.ZQ();
                dVar.faG = ByteBuffer.allocateDirect(dVar.faK.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                dVar.faG.put(dVar.faK);
                dVar.faG.position(0);
                dVar.faH = ByteBuffer.allocateDirect(d.faq.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                dVar.faH.put(d.faq);
                dVar.faH.position(0);
                x.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[]{Integer.valueOf(dVar.fay), Integer.valueOf(dVar.faz), dVar});
            }
            x.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        }
        while (this.fbf) {
            if (this.faY != null) {
                if (!this.faY.fbh) {
                    try {
                        Thread.sleep(10);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.MMSightRecordTextureViewRenderThread", e, "", new Object[0]);
                    }
                }
                d dVar2 = this.faY;
                bi.VG();
                dVar2.bum = true;
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16640);
                synchronized (d.lock) {
                    if (dVar2.faA != -1 && dVar2.fay != -1 && dVar2.faz != -1 && dVar2.fau > 0 && dVar2.fav > 0 && dVar2.fax != null && dVar2.faw != null && dVar2.fax.limit() > 0 && dVar2.faw.limit() > 0 && dVar2.fax.position() == 0 && dVar2.faw.position() == 0) {
                        GLES20.glUseProgram(dVar2.faA);
                        GLES20.glActiveTexture(33984);
                        GLES20.glBindTexture(3553, dVar2.fay);
                        GLES20.glTexImage2D(3553, 0, 6409, dVar2.fau, dVar2.fav, 0, 6409, 5121, dVar2.faw);
                        GLES20.glTexParameterf(3553, 10241, 9729.0f);
                        GLES20.glTexParameterf(3553, 10240, 9729.0f);
                        GLES20.glTexParameterf(3553, 10242, 33071.0f);
                        GLES20.glTexParameterf(3553, 10243, 33071.0f);
                        GLES20.glUniform1i(dVar2.faD, 0);
                        GLES20.glActiveTexture(33985);
                        GLES20.glBindTexture(3553, dVar2.faz);
                        GLES20.glTexImage2D(3553, 0, 6410, dVar2.fau / 2, dVar2.fav / 2, 0, 6410, 5121, dVar2.fax);
                        GLES20.glTexParameterf(3553, 10241, 9729.0f);
                        GLES20.glTexParameterf(3553, 10240, 9729.0f);
                        GLES20.glTexParameterf(3553, 10242, 33071.0f);
                        GLES20.glTexParameterf(3553, 10243, 33071.0f);
                        GLES20.glUniform1i(dVar2.faE, 1);
                        Matrix.setIdentityM(dVar2.faI, 0);
                        Matrix.setRotateM(dVar2.faI, 0, (float) dVar2.bYE, 0.0f, 0.0f, -1.0f);
                        GLES20.glUniformMatrix4fv(dVar2.faF, 1, false, dVar2.faI, 0);
                        dVar2.faG.position(0);
                        GLES20.glVertexAttribPointer(dVar2.faC, 2, 5126, false, 0, dVar2.faG);
                        GLES20.glEnableVertexAttribArray(dVar2.faC);
                        dVar2.faH.position(0);
                        GLES20.glVertexAttribPointer(dVar2.faB, 2, 5126, false, 0, dVar2.faH);
                        GLES20.glEnableVertexAttribArray(dVar2.faB);
                        GLES20.glDrawArrays(5, 0, 4);
                        GLES20.glDisableVertexAttribArray(dVar2.faC);
                        GLES20.glDisableVertexAttribArray(dVar2.faB);
                        GLES20.glBindTexture(3553, 0);
                    }
                }
                dVar2.bum = false;
            }
            if (this.fbb != null) {
                this.fbb.eglSwapBuffers(this.fbc, this.fbe);
            }
        }
        x.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, start destroy gl");
        if (this.faY != null) {
            dVar = this.faY;
            synchronized (d.lock) {
                if (dVar.faA >= 0) {
                    GLES20.glDeleteProgram(dVar.faA);
                    dVar.faA = -1;
                }
                if (dVar.faz >= 0) {
                    GLES20.glDeleteTextures(1, new int[]{dVar.faz}, 0);
                    dVar.faz = -1;
                }
                if (dVar.fay >= 0) {
                    GLES20.glDeleteTextures(1, new int[]{dVar.fay}, 0);
                    dVar.fay = -1;
                }
                dVar.fav = -1;
                dVar.fau = -1;
                dVar.fbg = true;
                dVar.faw = null;
                dVar.fax = null;
            }
        }
        if (!(this.fbb == null || this.fbd == null || this.fbe == null)) {
            this.fbb.eglDestroyContext(this.fbc, this.fbd);
            this.fbb.eglDestroySurface(this.fbc, this.fbe);
            this.fbd = EGL10.EGL_NO_CONTEXT;
            this.fbe = EGL10.EGL_NO_SURFACE;
        }
        if (this.fba != null) {
            this.fba.release();
        }
        x.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
    }
}
