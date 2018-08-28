package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.mm.plugin.appbrand.game.e.b;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class GameGLSurfaceView extends SurfaceView implements Callback2 {
    private static final k fyT = new k((byte) 0);
    private final WeakReference<GameGLSurfaceView> fyU = new WeakReference(this);
    public j fyV;
    private n fyW;
    private e fyX;
    private f fyY;
    private h fyZ;
    private l fza;
    private boolean fzb = false;
    private int fzc;
    private int fzd;
    private boolean fze;
    private final b fzf = new b();
    private boolean mDetached;

    public interface f {
        EGLContext b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public GameGLSurfaceView(Context context) {
        super(context);
        init();
    }

    public GameGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected void finalize() {
        try {
            if (this.fyV != null) {
                this.fyV.afQ();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public void setFps(int i) {
        b bVar = this.fzf;
        if (i >= 10 && i <= 60) {
            bVar.fDk = b.kv(i);
        }
    }

    private void init() {
        i.fAb.fAd = this;
        getHolder().addCallback(this);
    }

    public void setGLWrapper(l lVar) {
        this.fza = lVar;
    }

    public void setDebugFlags(int i) {
        this.fzc = i;
    }

    public int getDebugFlags() {
        return this.fzc;
    }

    public void setSwapNow(boolean z) {
        this.fzb = z;
    }

    public boolean getIsSwapNow() {
        return this.fzb;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.fze = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.fze;
    }

    public void setRenderer(b bVar) {
        afH();
        if (this.fyX == null) {
            this.fyX = new o(this);
        }
        if (this.fyY == null) {
            this.fyY = new c(this, (byte) 0);
        }
        if (this.fyZ == null) {
            this.fyZ = new d((byte) 0);
        }
        this.fyW = bVar;
        this.fyV = new j(this.fyU);
        this.fyV.start();
    }

    public void setEGLContextFactory(f fVar) {
        afH();
        this.fyY = fVar;
    }

    public void setEGLWindowSurfaceFactory(h hVar) {
        afH();
        this.fyZ = hVar;
    }

    public void setEGLConfigChooser(e eVar) {
        afH();
        this.fyX = eVar;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new o(this));
    }

    public void setEGLContextClientVersion(int i) {
        afH();
        this.fzd = i;
    }

    public void setRenderMode(int i) {
        this.fyV.setRenderMode(i);
    }

    public int getRenderMode() {
        return this.fyV.getRenderMode();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        j jVar = this.fyV;
        synchronized (fyT) {
            x.i("MicroMsg.GLThread", "surfaceCreated tid=" + jVar.getId());
            jVar.fzv = true;
            jVar.fzA = false;
            jVar.fzt = true;
            fyT.notifyAll();
            while (jVar.fzx && !jVar.fzA && !jVar.fzq) {
                try {
                    fyT.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        j jVar = this.fyV;
        synchronized (fyT) {
            x.i("MicroMsg.GLThread", "surfaceDestroyed tid=" + jVar.getId());
            jVar.fzv = false;
            jVar.fzt = true;
            fyT.notifyAll();
            while (!jVar.fzx && !jVar.fzq) {
                try {
                    fyT.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void surfaceChanged(android.view.SurfaceHolder r9, int r10, int r11, int r12) {
        /*
        r8 = this;
        r2 = 0;
        r1 = 1;
        r3 = r8.fyV;
        r4 = fyT;
        monitor-enter(r4);
        r0 = r3.mWidth;	 Catch:{ all -> 0x0029 }
        if (r0 != r11) goto L_0x0011;
    L_0x000b:
        r0 = r3.mHeight;	 Catch:{ all -> 0x0029 }
        if (r0 != r12) goto L_0x0011;
    L_0x000f:
        monitor-exit(r4);	 Catch:{ all -> 0x0029 }
    L_0x0010:
        return;
    L_0x0011:
        r3.mWidth = r11;	 Catch:{ all -> 0x0029 }
        r3.mHeight = r12;	 Catch:{ all -> 0x0029 }
        r0 = 1;
        r3.fzG = r0;	 Catch:{ all -> 0x0029 }
        r0 = 1;
        r3.fzC = r0;	 Catch:{ all -> 0x0029 }
        r0 = 0;
        r3.fzE = r0;	 Catch:{ all -> 0x0029 }
        r0 = 1;
        r3.fzt = r0;	 Catch:{ all -> 0x0029 }
        r0 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0029 }
        if (r0 != r3) goto L_0x002c;
    L_0x0027:
        monitor-exit(r4);	 Catch:{ all -> 0x0029 }
        goto L_0x0010;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = fyT;	 Catch:{ all -> 0x0029 }
        r0.notifyAll();	 Catch:{ all -> 0x0029 }
    L_0x0031:
        r0 = r3.fzq;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x0079;
    L_0x0035:
        r0 = r3.fcO;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x0079;
    L_0x0039:
        r0 = r3.fzE;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x0079;
    L_0x003d:
        r0 = r3.fzy;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0077;
    L_0x0041:
        r0 = r3.fzz;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0077;
    L_0x0045:
        r0 = r3.afO();	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0077;
    L_0x004b:
        r0 = r1;
    L_0x004c:
        if (r0 == 0) goto L_0x0079;
    L_0x004e:
        r0 = "MicroMsg.GLThread";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0029 }
        r6 = "onWindowResize waiting for render complete from tid=";
        r5.<init>(r6);	 Catch:{ all -> 0x0029 }
        r6 = r3.getId();	 Catch:{ all -> 0x0029 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x0029 }
        r5 = r5.toString();	 Catch:{ all -> 0x0029 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r5);	 Catch:{ all -> 0x0029 }
        r0 = fyT;	 Catch:{ InterruptedException -> 0x006e }
        r0.wait();	 Catch:{ InterruptedException -> 0x006e }
        goto L_0x0031;
    L_0x006e:
        r0 = move-exception;
        r0 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0029 }
        r0.interrupt();	 Catch:{ all -> 0x0029 }
        goto L_0x0031;
    L_0x0077:
        r0 = r2;
        goto L_0x004c;
    L_0x0079:
        monitor-exit(r4);	 Catch:{ all -> 0x0029 }
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.surfaceChanged(android.view.SurfaceHolder, int, int, int):void");
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        if (this.fyV != null) {
            j jVar = this.fyV;
            synchronized (fyT) {
                jVar.fzC = true;
                fyT.notifyAll();
            }
        }
    }

    public final void queueEvent(Runnable runnable) {
        j jVar = this.fyV;
        if (runnable == null) {
            throw new IllegalArgumentException("r must not be null");
        }
        synchronized (fyT) {
            jVar.fzF.add(runnable);
            fyT.notifyAll();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.i("MicroMsg.GameGLSurfaceView", "onAttachedToWindow reattach =" + this.mDetached);
        if (this.mDetached && this.fyW != null) {
            int renderMode;
            if (this.fyV != null) {
                renderMode = this.fyV.getRenderMode();
            } else {
                renderMode = 1;
            }
            this.fyV = new j(this.fyU);
            if (renderMode != 1) {
                this.fyV.setRenderMode(renderMode);
            }
            this.fyV.start();
        }
        this.mDetached = false;
    }

    protected void onDetachedFromWindow() {
        x.i("MicroMsg.GameGLSurfaceView", "onDetachedFromWindow");
        if (this.fyV != null) {
            this.fyV.afQ();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    private void afH() {
        if (this.fyV != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }
}
