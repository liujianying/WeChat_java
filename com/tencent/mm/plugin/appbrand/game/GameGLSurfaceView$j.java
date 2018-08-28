package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.i;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

class GameGLSurfaceView$j extends Thread {
    public boolean fcO;
    boolean fzA;
    private boolean fzB;
    public boolean fzC = true;
    private boolean fzD = false;
    public boolean fzE;
    LinkedList<Runnable> fzF = new LinkedList();
    boolean fzG = true;
    private i fzH;
    private WeakReference<GameGLSurfaceView> fzn;
    private boolean fzp;
    public boolean fzq;
    private boolean fzr;
    public boolean fzs;
    boolean fzt;
    public boolean fzu;
    boolean fzv;
    private boolean fzw;
    boolean fzx;
    boolean fzy;
    boolean fzz;
    int mHeight = 0;
    private int mRenderMode = 1;
    int mWidth = 0;

    GameGLSurfaceView$j(WeakReference<GameGLSurfaceView> weakReference) {
        this.fzn = weakReference;
    }

    public final void run() {
        setName("GLThread " + getId());
        x.i("MicroMsg.GLThread", "starting tid=" + getId());
        i.fAb.afX();
        try {
            afM();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GLThread", e, "hy: InterruptedException", new Object[0]);
        } finally {
            GameGLSurfaceView.afI().g(this);
        }
        i.fAb.afY();
        i iVar = i.fAb;
        iVar.fAc.clear();
        iVar.fAd = null;
    }

    private void afK() {
        if (this.fzz) {
            this.fzz = false;
            this.fzA = false;
        }
    }

    private void afL() {
        if (this.fzy) {
            this.fzy = false;
            GameGLSurfaceView.afI().notifyAll();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void afM() {
        /*
        r22 = this;
        r4 = new com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView$i;
        r0 = r22;
        r5 = r0.fzn;
        r4.<init>(r5);
        r0 = r22;
        r0.fzH = r4;
        r4 = 0;
        r0 = r22;
        r0.fzy = r4;
        r4 = 0;
        r0 = r22;
        r0.fzz = r4;
        r5 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();
        monitor-enter(r5);
        r4 = 0;
        r0 = r22;
        r0.fzD = r4;	 Catch:{ all -> 0x003b }
        monitor-exit(r5);	 Catch:{ all -> 0x003b }
        r14 = 0;
        r15 = 0;
        r13 = 0;
        r12 = 0;
        r11 = 0;
        r10 = 0;
        r9 = 0;
        r8 = 0;
        r7 = 0;
        r6 = 0;
        r4 = 0;
        r5 = r4;
    L_0x002e:
        r17 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();
        monitor-enter(r17);
    L_0x0033:
        r0 = r22;
        r4 = r0.fzp;	 Catch:{ all -> 0x02d7 }
        if (r4 == 0) goto L_0x003e;
    L_0x0039:
        monitor-exit(r17);	 Catch:{ all -> 0x02d7 }
        return;
    L_0x003b:
        r4 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x003b }
        throw r4;
    L_0x003e:
        r0 = r22;
        r4 = r0.fcO;	 Catch:{ all -> 0x02d7 }
        if (r4 != 0) goto L_0x0069;
    L_0x0044:
        r0 = r22;
        r4 = r0.fzA;	 Catch:{ all -> 0x02d7 }
        if (r4 == 0) goto L_0x0069;
    L_0x004a:
        r0 = r22;
        r4 = r0.fzF;	 Catch:{ all -> 0x02d7 }
        r4 = r4.isEmpty();	 Catch:{ all -> 0x02d7 }
        if (r4 != 0) goto L_0x0069;
    L_0x0054:
        r0 = r22;
        r4 = r0.fzF;	 Catch:{ all -> 0x02d7 }
        r5 = 0;
        r4 = r4.remove(r5);	 Catch:{ all -> 0x02d7 }
        r4 = (java.lang.Runnable) r4;	 Catch:{ all -> 0x02d7 }
        r5 = r4;
    L_0x0060:
        monitor-exit(r17);	 Catch:{ all -> 0x02d7 }
        if (r5 == 0) goto L_0x0432;
    L_0x0063:
        r5.run();
        r4 = 0;
        r5 = r4;
        goto L_0x002e;
    L_0x0069:
        r4 = 0;
        r0 = r22;
        r0 = r0.fcO;	 Catch:{ all -> 0x02d7 }
        r16 = r0;
        r0 = r22;
        r0 = r0.fzs;	 Catch:{ all -> 0x02d7 }
        r18 = r0;
        r0 = r16;
        r1 = r18;
        if (r0 == r1) goto L_0x079d;
    L_0x007c:
        r0 = r22;
        r0 = r0.fzs;	 Catch:{ all -> 0x02d7 }
        r16 = r0;
        r0 = r22;
        r4 = r0.fzs;	 Catch:{ all -> 0x02d7 }
        r0 = r22;
        r0.fcO = r4;	 Catch:{ all -> 0x02d7 }
        if (r16 == 0) goto L_0x02c2;
    L_0x008c:
        r0 = r22;
        r4 = r0.fzn;	 Catch:{ all -> 0x02d7 }
        r4 = r4.get();	 Catch:{ all -> 0x02d7 }
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;	 Catch:{ all -> 0x02d7 }
        if (r4 == 0) goto L_0x009f;
    L_0x0098:
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.g(r4);	 Catch:{ all -> 0x02d7 }
        r4.onPause();	 Catch:{ all -> 0x02d7 }
    L_0x009f:
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();	 Catch:{ all -> 0x02d7 }
        r4.notifyAll();	 Catch:{ all -> 0x02d7 }
        r4 = "MicroMsg.GLThread";
        r18 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02d7 }
        r19 = "mPaused is now ";
        r18.<init>(r19);	 Catch:{ all -> 0x02d7 }
        r0 = r22;
        r0 = r0.fcO;	 Catch:{ all -> 0x02d7 }
        r19 = r0;
        r18 = r18.append(r19);	 Catch:{ all -> 0x02d7 }
        r19 = " tid=";
        r18 = r18.append(r19);	 Catch:{ all -> 0x02d7 }
        r20 = r22.getId();	 Catch:{ all -> 0x02d7 }
        r0 = r18;
        r1 = r20;
        r18 = r0.append(r1);	 Catch:{ all -> 0x02d7 }
        r18 = r18.toString();	 Catch:{ all -> 0x02d7 }
        r0 = r18;
        com.tencent.mm.sdk.platformtools.x.i(r4, r0);	 Catch:{ all -> 0x02d7 }
    L_0x00d7:
        r0 = r22;
        r4 = r0.fzB;	 Catch:{ all -> 0x02d7 }
        if (r4 == 0) goto L_0x0107;
    L_0x00dd:
        r4 = "MicroMsg.GLThread";
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02d7 }
        r18 = "releasing EGL context because asked to tid=";
        r0 = r18;
        r8.<init>(r0);	 Catch:{ all -> 0x02d7 }
        r18 = r22.getId();	 Catch:{ all -> 0x02d7 }
        r0 = r18;
        r8 = r8.append(r0);	 Catch:{ all -> 0x02d7 }
        r8 = r8.toString();	 Catch:{ all -> 0x02d7 }
        com.tencent.mm.sdk.platformtools.x.i(r4, r8);	 Catch:{ all -> 0x02d7 }
        r22.afK();	 Catch:{ all -> 0x02d7 }
        r22.afL();	 Catch:{ all -> 0x02d7 }
        r4 = 0;
        r0 = r22;
        r0.fzB = r4;	 Catch:{ all -> 0x02d7 }
        r8 = 1;
    L_0x0107:
        if (r12 == 0) goto L_0x0111;
    L_0x0109:
        r22.afK();	 Catch:{ all -> 0x02d7 }
        r22.afL();	 Catch:{ all -> 0x02d7 }
        r4 = 0;
        r12 = r4;
    L_0x0111:
        if (r16 == 0) goto L_0x013c;
    L_0x0113:
        r0 = r22;
        r4 = r0.fzz;	 Catch:{ all -> 0x02d7 }
        if (r4 == 0) goto L_0x013c;
    L_0x0119:
        r4 = "MicroMsg.GLThread";
        r18 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02d7 }
        r19 = "releasing EGL surface because paused tid=";
        r18.<init>(r19);	 Catch:{ all -> 0x02d7 }
        r20 = r22.getId();	 Catch:{ all -> 0x02d7 }
        r0 = r18;
        r1 = r20;
        r18 = r0.append(r1);	 Catch:{ all -> 0x02d7 }
        r18 = r18.toString();	 Catch:{ all -> 0x02d7 }
        r0 = r18;
        com.tencent.mm.sdk.platformtools.x.i(r4, r0);	 Catch:{ all -> 0x02d7 }
        r22.afK();	 Catch:{ all -> 0x02d7 }
    L_0x013c:
        if (r16 == 0) goto L_0x017a;
    L_0x013e:
        r0 = r22;
        r4 = r0.fzy;	 Catch:{ all -> 0x02d7 }
        if (r4 == 0) goto L_0x017a;
    L_0x0144:
        r0 = r22;
        r4 = r0.fzn;	 Catch:{ all -> 0x02d7 }
        r4 = r4.get();	 Catch:{ all -> 0x02d7 }
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;	 Catch:{ all -> 0x02d7 }
        if (r4 != 0) goto L_0x02da;
    L_0x0150:
        r4 = 0;
    L_0x0151:
        if (r4 != 0) goto L_0x017a;
    L_0x0153:
        r22.afL();	 Catch:{ all -> 0x02d7 }
        r4 = "MicroMsg.GLThread";
        r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02d7 }
        r18 = "releasing EGL context because paused tid=";
        r0 = r16;
        r1 = r18;
        r0.<init>(r1);	 Catch:{ all -> 0x02d7 }
        r18 = r22.getId();	 Catch:{ all -> 0x02d7 }
        r0 = r16;
        r1 = r18;
        r16 = r0.append(r1);	 Catch:{ all -> 0x02d7 }
        r16 = r16.toString();	 Catch:{ all -> 0x02d7 }
        r0 = r16;
        com.tencent.mm.sdk.platformtools.x.i(r4, r0);	 Catch:{ all -> 0x02d7 }
    L_0x017a:
        r0 = r22;
        r4 = r0.fzv;	 Catch:{ all -> 0x02d7 }
        if (r4 != 0) goto L_0x01c4;
    L_0x0180:
        r0 = r22;
        r4 = r0.fzx;	 Catch:{ all -> 0x02d7 }
        if (r4 != 0) goto L_0x01c4;
    L_0x0186:
        r4 = "MicroMsg.GLThread";
        r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02d7 }
        r18 = "noticed surfaceView surface lost tid=";
        r0 = r16;
        r1 = r18;
        r0.<init>(r1);	 Catch:{ all -> 0x02d7 }
        r18 = r22.getId();	 Catch:{ all -> 0x02d7 }
        r0 = r16;
        r1 = r18;
        r16 = r0.append(r1);	 Catch:{ all -> 0x02d7 }
        r16 = r16.toString();	 Catch:{ all -> 0x02d7 }
        r0 = r16;
        com.tencent.mm.sdk.platformtools.x.i(r4, r0);	 Catch:{ all -> 0x02d7 }
        r0 = r22;
        r4 = r0.fzz;	 Catch:{ all -> 0x02d7 }
        if (r4 == 0) goto L_0x01b3;
    L_0x01b0:
        r22.afK();	 Catch:{ all -> 0x02d7 }
    L_0x01b3:
        r4 = 1;
        r0 = r22;
        r0.fzx = r4;	 Catch:{ all -> 0x02d7 }
        r4 = 0;
        r0 = r22;
        r0.fzw = r4;	 Catch:{ all -> 0x02d7 }
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();	 Catch:{ all -> 0x02d7 }
        r4.notifyAll();	 Catch:{ all -> 0x02d7 }
    L_0x01c4:
        r0 = r22;
        r4 = r0.fzv;	 Catch:{ all -> 0x02d7 }
        if (r4 == 0) goto L_0x0200;
    L_0x01ca:
        r0 = r22;
        r4 = r0.fzx;	 Catch:{ all -> 0x02d7 }
        if (r4 == 0) goto L_0x0200;
    L_0x01d0:
        r4 = "MicroMsg.GLThread";
        r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02d7 }
        r18 = "noticed surfaceView surface acquired tid=";
        r0 = r16;
        r1 = r18;
        r0.<init>(r1);	 Catch:{ all -> 0x02d7 }
        r18 = r22.getId();	 Catch:{ all -> 0x02d7 }
        r0 = r16;
        r1 = r18;
        r16 = r0.append(r1);	 Catch:{ all -> 0x02d7 }
        r16 = r16.toString();	 Catch:{ all -> 0x02d7 }
        r0 = r16;
        com.tencent.mm.sdk.platformtools.x.i(r4, r0);	 Catch:{ all -> 0x02d7 }
        r4 = 0;
        r0 = r22;
        r0.fzx = r4;	 Catch:{ all -> 0x02d7 }
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();	 Catch:{ all -> 0x02d7 }
        r4.notifyAll();	 Catch:{ all -> 0x02d7 }
    L_0x0200:
        if (r9 == 0) goto L_0x0799;
    L_0x0202:
        r4 = "MicroMsg.GLThread";
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02d7 }
        r16 = "sending render notification tid=";
        r0 = r16;
        r9.<init>(r0);	 Catch:{ all -> 0x02d7 }
        r18 = r22.getId();	 Catch:{ all -> 0x02d7 }
        r0 = r18;
        r9 = r9.append(r0);	 Catch:{ all -> 0x02d7 }
        r9 = r9.toString();	 Catch:{ all -> 0x02d7 }
        com.tencent.mm.sdk.platformtools.x.i(r4, r9);	 Catch:{ all -> 0x02d7 }
        r4 = 0;
        r0 = r22;
        r0.fzD = r4;	 Catch:{ all -> 0x02d7 }
        r4 = 0;
        r9 = 1;
        r0 = r22;
        r0.fzE = r9;	 Catch:{ all -> 0x02d7 }
        r9 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();	 Catch:{ all -> 0x02d7 }
        r9.notifyAll();	 Catch:{ all -> 0x02d7 }
        r16 = r4;
    L_0x0234:
        r4 = r22.afO();	 Catch:{ all -> 0x02d7 }
        if (r4 == 0) goto L_0x0796;
    L_0x023a:
        r0 = r22;
        r4 = r0.fzy;	 Catch:{ all -> 0x02d7 }
        if (r4 != 0) goto L_0x03b8;
    L_0x0240:
        r4 = "MicroMsg.GLThread";
        r9 = "not HaveEglContext";
        com.tencent.mm.sdk.platformtools.x.i(r4, r9);	 Catch:{ all -> 0x02d7 }
        if (r8 == 0) goto L_0x02e0;
    L_0x024b:
        r8 = 0;
        r4 = r8;
    L_0x024d:
        r0 = r22;
        r8 = r0.fzy;	 Catch:{ all -> 0x02d7 }
        if (r8 == 0) goto L_0x0792;
    L_0x0253:
        r0 = r22;
        r8 = r0.fzz;	 Catch:{ all -> 0x02d7 }
        if (r8 != 0) goto L_0x0792;
    L_0x0259:
        r8 = "MicroMsg.GLThread";
        r9 = "Have EglContext but no EglSurface";
        com.tencent.mm.sdk.platformtools.x.i(r8, r9);	 Catch:{ all -> 0x02d7 }
        r8 = 1;
        r0 = r22;
        r0.fzz = r8;	 Catch:{ all -> 0x02d7 }
        r15 = 1;
        r13 = 1;
        r11 = 1;
        r8 = r11;
        r9 = r15;
    L_0x026c:
        r0 = r22;
        r11 = r0.fzz;	 Catch:{ all -> 0x02d7 }
        if (r11 == 0) goto L_0x03ef;
    L_0x0272:
        r0 = r22;
        r11 = r0.fzG;	 Catch:{ all -> 0x02d7 }
        if (r11 == 0) goto L_0x02a8;
    L_0x0278:
        r8 = 1;
        r0 = r22;
        r7 = r0.mWidth;	 Catch:{ all -> 0x02d7 }
        r0 = r22;
        r6 = r0.mHeight;	 Catch:{ all -> 0x02d7 }
        r9 = 1;
        r0 = r22;
        r0.fzD = r9;	 Catch:{ all -> 0x02d7 }
        r9 = "MicroMsg.GLThread";
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02d7 }
        r15 = "noticing that we want render notification tid=";
        r11.<init>(r15);	 Catch:{ all -> 0x02d7 }
        r18 = r22.getId();	 Catch:{ all -> 0x02d7 }
        r0 = r18;
        r11 = r11.append(r0);	 Catch:{ all -> 0x02d7 }
        r11 = r11.toString();	 Catch:{ all -> 0x02d7 }
        com.tencent.mm.sdk.platformtools.x.i(r9, r11);	 Catch:{ all -> 0x02d7 }
        r9 = 1;
        r11 = 0;
        r0 = r22;
        r0.fzG = r11;	 Catch:{ all -> 0x02d7 }
    L_0x02a8:
        r11 = r8;
        r15 = r9;
        r8 = 0;
        r0 = r22;
        r0.fzC = r8;	 Catch:{ all -> 0x02d7 }
        r8 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();	 Catch:{ all -> 0x02d7 }
        r8.notifyAll();	 Catch:{ all -> 0x02d7 }
        r0 = r22;
        r8 = r0.fzD;	 Catch:{ all -> 0x02d7 }
        if (r8 == 0) goto L_0x078d;
    L_0x02bc:
        r10 = 1;
        r8 = r4;
        r9 = r16;
        goto L_0x0060;
    L_0x02c2:
        r0 = r22;
        r4 = r0.fzn;	 Catch:{ all -> 0x02d7 }
        r4 = r4.get();	 Catch:{ all -> 0x02d7 }
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;	 Catch:{ all -> 0x02d7 }
        if (r4 == 0) goto L_0x009f;
    L_0x02ce:
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.g(r4);	 Catch:{ all -> 0x02d7 }
        r4.onResume();	 Catch:{ all -> 0x02d7 }
        goto L_0x009f;
    L_0x02d7:
        r4 = move-exception;
        monitor-exit(r17);	 Catch:{ all -> 0x02d7 }
        throw r4;
    L_0x02da:
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.h(r4);	 Catch:{ all -> 0x02d7 }
        goto L_0x0151;
    L_0x02e0:
        r0 = r22;
        r9 = r0.fzH;	 Catch:{ RuntimeException -> 0x0327 }
        r4 = "MicroMsg.GLThread";
        r14 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0327 }
        r18 = "start() tid=";
        r0 = r18;
        r14.<init>(r0);	 Catch:{ RuntimeException -> 0x0327 }
        r18 = java.lang.Thread.currentThread();	 Catch:{ RuntimeException -> 0x0327 }
        r18 = r18.getId();	 Catch:{ RuntimeException -> 0x0327 }
        r0 = r18;
        r14 = r14.append(r0);	 Catch:{ RuntimeException -> 0x0327 }
        r14 = r14.toString();	 Catch:{ RuntimeException -> 0x0327 }
        com.tencent.mm.sdk.platformtools.x.w(r4, r14);	 Catch:{ RuntimeException -> 0x0327 }
        r4 = javax.microedition.khronos.egl.EGLContext.getEGL();	 Catch:{ RuntimeException -> 0x0327 }
        r4 = (javax.microedition.khronos.egl.EGL10) r4;	 Catch:{ RuntimeException -> 0x0327 }
        r9.fbb = r4;	 Catch:{ RuntimeException -> 0x0327 }
        r4 = r9.fbb;	 Catch:{ RuntimeException -> 0x0327 }
        r14 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY;	 Catch:{ RuntimeException -> 0x0327 }
        r4 = r4.eglGetDisplay(r14);	 Catch:{ RuntimeException -> 0x0327 }
        r9.fbc = r4;	 Catch:{ RuntimeException -> 0x0327 }
        r4 = r9.fbc;	 Catch:{ RuntimeException -> 0x0327 }
        r14 = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY;	 Catch:{ RuntimeException -> 0x0327 }
        if (r4 != r14) goto L_0x0330;
    L_0x031e:
        r4 = new java.lang.RuntimeException;	 Catch:{ RuntimeException -> 0x0327 }
        r5 = "eglGetDisplay failed";
        r4.<init>(r5);	 Catch:{ RuntimeException -> 0x0327 }
        throw r4;	 Catch:{ RuntimeException -> 0x0327 }
    L_0x0327:
        r4 = move-exception;
        r5 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();	 Catch:{ all -> 0x02d7 }
        r5.notifyAll();	 Catch:{ all -> 0x02d7 }
        throw r4;	 Catch:{ all -> 0x02d7 }
    L_0x0330:
        r4 = 2;
        r4 = new int[r4];	 Catch:{ RuntimeException -> 0x0327 }
        r14 = r9.fbb;	 Catch:{ RuntimeException -> 0x0327 }
        r0 = r9.fbc;	 Catch:{ RuntimeException -> 0x0327 }
        r18 = r0;
        r0 = r18;
        r4 = r14.eglInitialize(r0, r4);	 Catch:{ RuntimeException -> 0x0327 }
        if (r4 != 0) goto L_0x034a;
    L_0x0341:
        r4 = new java.lang.RuntimeException;	 Catch:{ RuntimeException -> 0x0327 }
        r5 = "eglInitialize failed";
        r4.<init>(r5);	 Catch:{ RuntimeException -> 0x0327 }
        throw r4;	 Catch:{ RuntimeException -> 0x0327 }
    L_0x034a:
        r4 = r9.fzn;	 Catch:{ RuntimeException -> 0x0327 }
        r4 = r4.get();	 Catch:{ RuntimeException -> 0x0327 }
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;	 Catch:{ RuntimeException -> 0x0327 }
        if (r4 != 0) goto L_0x03bb;
    L_0x0354:
        r4 = 0;
        r9.fzo = r4;	 Catch:{ RuntimeException -> 0x0327 }
        r4 = 0;
        r9.fbd = r4;	 Catch:{ RuntimeException -> 0x0327 }
    L_0x035a:
        r4 = r9.fbd;	 Catch:{ RuntimeException -> 0x0327 }
        if (r4 == 0) goto L_0x0364;
    L_0x035e:
        r4 = r9.fbd;	 Catch:{ RuntimeException -> 0x0327 }
        r14 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;	 Catch:{ RuntimeException -> 0x0327 }
        if (r4 != r14) goto L_0x0373;
    L_0x0364:
        r4 = 0;
        r9.fbd = r4;	 Catch:{ RuntimeException -> 0x0327 }
        r4 = "createContext";
        r14 = r9.fbb;	 Catch:{ RuntimeException -> 0x0327 }
        r14 = r14.eglGetError();	 Catch:{ RuntimeException -> 0x0327 }
        com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.i.az(r4, r14);	 Catch:{ RuntimeException -> 0x0327 }
    L_0x0373:
        r4 = "MicroMsg.GLThread";
        r14 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0327 }
        r18 = "createContext ";
        r0 = r18;
        r14.<init>(r0);	 Catch:{ RuntimeException -> 0x0327 }
        r0 = r9.fbd;	 Catch:{ RuntimeException -> 0x0327 }
        r18 = r0;
        r0 = r18;
        r14 = r14.append(r0);	 Catch:{ RuntimeException -> 0x0327 }
        r18 = " tid=";
        r0 = r18;
        r14 = r14.append(r0);	 Catch:{ RuntimeException -> 0x0327 }
        r18 = java.lang.Thread.currentThread();	 Catch:{ RuntimeException -> 0x0327 }
        r18 = r18.getId();	 Catch:{ RuntimeException -> 0x0327 }
        r0 = r18;
        r14 = r14.append(r0);	 Catch:{ RuntimeException -> 0x0327 }
        r14 = r14.toString();	 Catch:{ RuntimeException -> 0x0327 }
        com.tencent.mm.sdk.platformtools.x.w(r4, r14);	 Catch:{ RuntimeException -> 0x0327 }
        r4 = 0;
        r9.fbe = r4;	 Catch:{ RuntimeException -> 0x0327 }
        r4 = 1;
        r0 = r22;
        r0.fzy = r4;	 Catch:{ all -> 0x02d7 }
        r14 = 1;
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();	 Catch:{ all -> 0x02d7 }
        r4.notifyAll();	 Catch:{ all -> 0x02d7 }
    L_0x03b8:
        r4 = r8;
        goto L_0x024d;
    L_0x03bb:
        r14 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.b(r4);	 Catch:{ RuntimeException -> 0x0327 }
        r0 = r9.fbb;	 Catch:{ RuntimeException -> 0x0327 }
        r18 = r0;
        r0 = r9.fbc;	 Catch:{ RuntimeException -> 0x0327 }
        r19 = r0;
        r0 = r18;
        r1 = r19;
        r14 = r14.chooseConfig(r0, r1);	 Catch:{ RuntimeException -> 0x0327 }
        r9.fzo = r14;	 Catch:{ RuntimeException -> 0x0327 }
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.c(r4);	 Catch:{ RuntimeException -> 0x0327 }
        r14 = r9.fbb;	 Catch:{ RuntimeException -> 0x0327 }
        r0 = r9.fbc;	 Catch:{ RuntimeException -> 0x0327 }
        r18 = r0;
        r0 = r9.fzo;	 Catch:{ RuntimeException -> 0x0327 }
        r19 = r0;
        r20 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;	 Catch:{ RuntimeException -> 0x0327 }
        r0 = r18;
        r1 = r19;
        r2 = r20;
        r4 = r4.b(r14, r0, r1, r2);	 Catch:{ RuntimeException -> 0x0327 }
        r9.fbd = r4;	 Catch:{ RuntimeException -> 0x0327 }
        goto L_0x035a;
    L_0x03ef:
        r11 = "MicroMsg.GLThread";
        r15 = "readyToDraw but not haveEglSurface";
        com.tencent.mm.sdk.platformtools.x.e(r11, r15);	 Catch:{ all -> 0x02d7 }
        r11 = r8;
        r15 = r9;
    L_0x03fa:
        r8 = r22.afP();	 Catch:{ all -> 0x02d7 }
        if (r8 == 0) goto L_0x0426;
    L_0x0400:
        r8 = "MicroMsg.GLThread";
        r9 = "readyToPauseAlsoDoDraw mPaused = [%b]";
        r18 = 1;
        r0 = r18;
        r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x02d7 }
        r18 = r0;
        r19 = 0;
        r0 = r22;
        r0 = r0.fcO;	 Catch:{ all -> 0x02d7 }
        r20 = r0;
        r20 = java.lang.Boolean.valueOf(r20);	 Catch:{ all -> 0x02d7 }
        r18[r19] = r20;	 Catch:{ all -> 0x02d7 }
        r0 = r18;
        com.tencent.mm.sdk.platformtools.x.i(r8, r9, r0);	 Catch:{ all -> 0x02d7 }
        r8 = r4;
        r9 = r16;
        goto L_0x0060;
    L_0x0426:
        r8 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();	 Catch:{ all -> 0x02d7 }
        r8.wait();	 Catch:{ all -> 0x02d7 }
        r8 = r4;
        r9 = r16;
        goto L_0x0033;
    L_0x0432:
        if (r15 == 0) goto L_0x051d;
    L_0x0434:
        r4 = "MicroMsg.GLThread";
        r16 = "egl createSurface";
        r0 = r16;
        com.tencent.mm.sdk.platformtools.x.w(r4, r0);
        r0 = r22;
        r0 = r0.fzH;
        r16 = r0;
        r4 = "MicroMsg.GLThread";
        r17 = new java.lang.StringBuilder;
        r18 = "createSurface()  tid=";
        r17.<init>(r18);
        r18 = java.lang.Thread.currentThread();
        r18 = r18.getId();
        r17 = r17.append(r18);
        r17 = r17.toString();
        r0 = r17;
        com.tencent.mm.sdk.platformtools.x.w(r4, r0);
        r0 = r16;
        r4 = r0.fbb;
        if (r4 != 0) goto L_0x0474;
    L_0x046b:
        r4 = new java.lang.RuntimeException;
        r5 = "egl not initialized";
        r4.<init>(r5);
        throw r4;
    L_0x0474:
        r0 = r16;
        r4 = r0.fbc;
        if (r4 != 0) goto L_0x0483;
    L_0x047a:
        r4 = new java.lang.RuntimeException;
        r5 = "eglDisplay not initialized";
        r4.<init>(r5);
        throw r4;
    L_0x0483:
        r0 = r16;
        r4 = r0.fzo;
        if (r4 != 0) goto L_0x0492;
    L_0x0489:
        r4 = new java.lang.RuntimeException;
        r5 = "mEglConfig not initialized";
        r4.<init>(r5);
        throw r4;
    L_0x0492:
        r16.afJ();
        r0 = r16;
        r4 = r0.fzn;
        r4 = r4.get();
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;
        if (r4 == 0) goto L_0x06e8;
    L_0x04a1:
        r17 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.d(r4);
        r0 = r16;
        r0 = r0.fbb;
        r18 = r0;
        r0 = r16;
        r0 = r0.fbc;
        r19 = r0;
        r0 = r16;
        r0 = r0.fzo;
        r20 = r0;
        r4 = r4.getHolder();
        r0 = r17;
        r1 = r18;
        r2 = r19;
        r3 = r20;
        r4 = r0.createWindowSurface(r1, r2, r3, r4);
        r0 = r16;
        r0.fbe = r4;
    L_0x04cb:
        r0 = r16;
        r4 = r0.fbe;
        if (r4 == 0) goto L_0x04db;
    L_0x04d1:
        r0 = r16;
        r4 = r0.fbe;
        r17 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
        r0 = r17;
        if (r4 != r0) goto L_0x06ef;
    L_0x04db:
        r0 = r16;
        r4 = r0.fbb;
        r4 = r4.eglGetError();
        r16 = 12299; // 0x300b float:1.7235E-41 double:6.0765E-320;
        r0 = r16;
        if (r4 != r0) goto L_0x04f4;
    L_0x04e9:
        r4 = "MicroMsg.GLThread";
        r16 = "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.";
        r0 = r16;
        com.tencent.mm.sdk.platformtools.x.e(r4, r0);
    L_0x04f4:
        r4 = 0;
    L_0x04f5:
        if (r4 == 0) goto L_0x0739;
    L_0x04f7:
        r0 = r22;
        r4 = r0.fzn;
        r4 = r4.get();
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;
        if (r4 == 0) goto L_0x050a;
    L_0x0503:
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.g(r4);
        r4.onCreateEglSurface();
    L_0x050a:
        r15 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();
        monitor-enter(r15);
        r4 = 1;
        r0 = r22;
        r0.fzA = r4;	 Catch:{ all -> 0x0736 }
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();	 Catch:{ all -> 0x0736 }
        r4.notifyAll();	 Catch:{ all -> 0x0736 }
        monitor-exit(r15);	 Catch:{ all -> 0x0736 }
        r15 = 0;
    L_0x051d:
        if (r13 == 0) goto L_0x0573;
    L_0x051f:
        r4 = "MicroMsg.GLThread";
        r13 = "createGLInterface";
        com.tencent.mm.sdk.platformtools.x.w(r4, r13);
        r0 = r22;
        r4 = r0.fzH;
        r13 = r4.fbd;
        r13 = r13.getGL();
        r4 = r4.fzn;
        r4 = r4.get();
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;
        if (r4 == 0) goto L_0x0572;
    L_0x053c:
        r16 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.e(r4);
        if (r16 == 0) goto L_0x054a;
    L_0x0542:
        r13 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.e(r4);
        r13 = r13.afR();
    L_0x054a:
        r16 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.f(r4);
        r16 = r16 & 3;
        if (r16 == 0) goto L_0x0572;
    L_0x0552:
        r16 = 0;
        r17 = 0;
        r18 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.f(r4);
        r18 = r18 & 1;
        if (r18 == 0) goto L_0x0560;
    L_0x055e:
        r16 = 1;
    L_0x0560:
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.f(r4);
        r4 = r4 & 2;
        if (r4 == 0) goto L_0x0789;
    L_0x0568:
        r4 = new com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView$m;
        r4.<init>();
    L_0x056d:
        r0 = r16;
        android.opengl.GLDebugHelper.wrap(r13, r0, r4);
    L_0x0572:
        r13 = 0;
    L_0x0573:
        if (r14 == 0) goto L_0x0588;
    L_0x0575:
        r0 = r22;
        r4 = r0.fzn;
        r4 = r4.get();
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;
        if (r4 == 0) goto L_0x0588;
    L_0x0581:
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.i(r4);
        r4.ahm();
    L_0x0588:
        if (r14 == 0) goto L_0x05b1;
    L_0x058a:
        r4 = "MicroMsg.GLThread";
        r14 = "createEglContext";
        com.tencent.mm.sdk.platformtools.x.w(r4, r14);
        r0 = r22;
        r4 = r0.fzn;
        r4 = r4.get();
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;
        if (r4 == 0) goto L_0x05b0;
    L_0x059f:
        r14 = com.tencent.mm.plugin.appbrand.game.i.fAb;
        r14.afZ();
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.g(r4);
        r4.afS();
        r4 = com.tencent.mm.plugin.appbrand.game.i.fAb;
        r4.aga();
    L_0x05b0:
        r14 = 0;
    L_0x05b1:
        if (r11 == 0) goto L_0x05fa;
    L_0x05b3:
        r4 = "MicroMsg.GLThread";
        r11 = new java.lang.StringBuilder;
        r16 = "onSurfaceChanged(";
        r0 = r16;
        r11.<init>(r0);
        r11 = r11.append(r7);
        r16 = ", ";
        r0 = r16;
        r11 = r11.append(r0);
        r11 = r11.append(r6);
        r16 = ")";
        r0 = r16;
        r11 = r11.append(r0);
        r11 = r11.toString();
        com.tencent.mm.sdk.platformtools.x.w(r4, r11);
        r0 = r22;
        r4 = r0.fzn;
        r4 = r4.get();
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;
        if (r4 == 0) goto L_0x05f9;
    L_0x05ed:
        r11 = com.tencent.mm.plugin.appbrand.game.i.fAb;
        r11.agb();
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.g(r4);
        r4.bI(r7, r6);
    L_0x05f9:
        r11 = 0;
    L_0x05fa:
        r0 = r22;
        r4 = r0.fzn;
        r4 = r4.get();
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;
        if (r4 == 0) goto L_0x0620;
    L_0x0606:
        r16 = com.tencent.mm.plugin.appbrand.game.i.fAb;
        r16.age();
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.g(r4);
        r16 = 0;
        r0 = r16;
        r4.cC(r0);
        r4 = com.tencent.mm.plugin.appbrand.game.i.fAb;
        r4.agc();
        r4 = com.tencent.mm.plugin.appbrand.game.i.fAb;
        r4.agd();
    L_0x0620:
        r0 = r22;
        r4 = r0.fzn;
        r4 = r4.get();
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;
        if (r4 == 0) goto L_0x0639;
    L_0x062c:
        r16 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.i(r4);
        r4 = r4.getIsSwapNow();
        r0 = r16;
        r0.cH(r4);
    L_0x0639:
        r16 = 12288; // 0x3000 float:1.7219E-41 double:6.071E-320;
        r17 = 1;
        r0 = r22;
        r4 = r0.fzn;
        r4 = r4.get();
        r4 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r4;
        if (r4 == 0) goto L_0x064d;
    L_0x0649:
        r17 = r4.getIsSwapNow();
    L_0x064d:
        if (r17 == 0) goto L_0x06a5;
    L_0x064f:
        r0 = r22;
        r0 = r0.fzH;
        r17 = r0;
        r16 = 12288; // 0x3000 float:1.7219E-41 double:6.071E-320;
        r0 = r17;
        r0 = r0.fbc;
        r18 = r0;
        if (r18 == 0) goto L_0x06a5;
    L_0x065f:
        r0 = r17;
        r0 = r0.fbc;
        r18 = r0;
        r19 = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY;
        r0 = r18;
        r1 = r19;
        if (r0 == r1) goto L_0x06a5;
    L_0x066d:
        r0 = r17;
        r0 = r0.fbe;
        r18 = r0;
        if (r18 == 0) goto L_0x06a5;
    L_0x0675:
        r0 = r17;
        r0 = r0.fbe;
        r18 = r0;
        r19 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
        r0 = r18;
        r1 = r19;
        if (r0 == r1) goto L_0x06a5;
    L_0x0683:
        r0 = r17;
        r0 = r0.fbb;
        r18 = r0;
        r0 = r17;
        r0 = r0.fbc;
        r19 = r0;
        r0 = r17;
        r0 = r0.fbe;
        r20 = r0;
        r18 = r18.eglSwapBuffers(r19, r20);
        if (r18 != 0) goto L_0x06a5;
    L_0x069b:
        r0 = r17;
        r0 = r0.fbb;
        r16 = r0;
        r16 = r16.eglGetError();
    L_0x06a5:
        if (r4 == 0) goto L_0x06ae;
    L_0x06a7:
        r17 = 1;
        r0 = r17;
        r4.setSwapNow(r0);
    L_0x06ae:
        switch(r16) {
            case 12288: goto L_0x06d5;
            case 12302: goto L_0x0760;
            default: goto L_0x06b1;
        };
    L_0x06b1:
        r17 = "GLThread";
        r18 = "eglSwapBuffers";
        r0 = r17;
        r1 = r18;
        r2 = r16;
        com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.i.n(r0, r1, r2);
        r16 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();
        monitor-enter(r16);
        r17 = 1;
        r0 = r17;
        r1 = r22;
        r1.fzw = r0;	 Catch:{ all -> 0x0783 }
        r17 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();	 Catch:{ all -> 0x0783 }
        r17.notifyAll();	 Catch:{ all -> 0x0783 }
        monitor-exit(r16);	 Catch:{ all -> 0x0783 }
    L_0x06d5:
        if (r4 == 0) goto L_0x06de;
    L_0x06d7:
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.i(r4);
        r4.ahm();
    L_0x06de:
        if (r10 == 0) goto L_0x0786;
    L_0x06e0:
        r4 = 1;
        r10 = 0;
    L_0x06e2:
        r22.afN();
        r9 = r4;
        goto L_0x002e;
    L_0x06e8:
        r4 = 0;
        r0 = r16;
        r0.fbe = r4;
        goto L_0x04cb;
    L_0x06ef:
        r0 = r16;
        r4 = r0.fbb;
        r0 = r16;
        r0 = r0.fbc;
        r17 = r0;
        r0 = r16;
        r0 = r0.fbe;
        r18 = r0;
        r0 = r16;
        r0 = r0.fbe;
        r19 = r0;
        r0 = r16;
        r0 = r0.fbd;
        r20 = r0;
        r0 = r17;
        r1 = r18;
        r2 = r19;
        r3 = r20;
        r4 = r4.eglMakeCurrent(r0, r1, r2, r3);
        if (r4 != 0) goto L_0x0733;
    L_0x0719:
        r4 = "EGLHelper";
        r17 = "eglMakeCurrent";
        r0 = r16;
        r0 = r0.fbb;
        r16 = r0;
        r16 = r16.eglGetError();
        r0 = r17;
        r1 = r16;
        com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.i.n(r4, r0, r1);
        r4 = 0;
        goto L_0x04f5;
    L_0x0733:
        r4 = 1;
        goto L_0x04f5;
    L_0x0736:
        r4 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x0736 }
        throw r4;
    L_0x0739:
        r4 = "MicroMsg.GLThread";
        r16 = "egl createSurface error";
        r0 = r16;
        com.tencent.mm.sdk.platformtools.x.e(r4, r0);
        r16 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();
        monitor-enter(r16);
        r4 = 1;
        r0 = r22;
        r0.fzA = r4;	 Catch:{ all -> 0x075d }
        r4 = 1;
        r0 = r22;
        r0.fzw = r4;	 Catch:{ all -> 0x075d }
        r4 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();	 Catch:{ all -> 0x075d }
        r4.notifyAll();	 Catch:{ all -> 0x075d }
        monitor-exit(r16);	 Catch:{ all -> 0x075d }
        goto L_0x002e;
    L_0x075d:
        r4 = move-exception;
        monitor-exit(r16);	 Catch:{ all -> 0x075d }
        throw r4;
    L_0x0760:
        r12 = "MicroMsg.GLThread";
        r16 = new java.lang.StringBuilder;
        r17 = "egl context lost tid=";
        r16.<init>(r17);
        r18 = r22.getId();
        r0 = r16;
        r1 = r18;
        r16 = r0.append(r1);
        r16 = r16.toString();
        r0 = r16;
        com.tencent.mm.sdk.platformtools.x.i(r12, r0);
        r12 = 1;
        goto L_0x06d5;
    L_0x0783:
        r4 = move-exception;
        monitor-exit(r16);	 Catch:{ all -> 0x0783 }
        throw r4;
    L_0x0786:
        r4 = r9;
        goto L_0x06e2;
    L_0x0789:
        r4 = r17;
        goto L_0x056d;
    L_0x078d:
        r8 = r4;
        r9 = r16;
        goto L_0x0060;
    L_0x0792:
        r8 = r11;
        r9 = r15;
        goto L_0x026c;
    L_0x0796:
        r4 = r8;
        goto L_0x03fa;
    L_0x0799:
        r16 = r9;
        goto L_0x0234;
    L_0x079d:
        r16 = r4;
        goto L_0x00d7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView$j.afM():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void afN() {
        /*
        r8 = this;
        r1 = 0;
        r7 = 0;
        r0 = r1;
    L_0x0003:
        r3 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();
        monitor-enter(r3);
        r2 = r8.afP();	 Catch:{ all -> 0x0022 }
        if (r2 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x0022 }
    L_0x000f:
        return;
    L_0x0010:
        r2 = r8.fzt;	 Catch:{ all -> 0x0022 }
        if (r2 == 0) goto L_0x0025;
    L_0x0014:
        r0 = 0;
        r8.fzt = r0;	 Catch:{ all -> 0x0022 }
        r0 = "MicroMsg.GLThread";
        r1 = "Request leave PAUSE_ALSO_DO_DRAW";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x0022 }
        monitor-exit(r3);	 Catch:{ all -> 0x0022 }
        goto L_0x000f;
    L_0x0022:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0022 }
        throw r0;
    L_0x0025:
        r2 = r8.fzF;	 Catch:{ all -> 0x0022 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0022 }
        if (r2 != 0) goto L_0x007b;
    L_0x002d:
        r0 = r8.fzF;	 Catch:{ all -> 0x0022 }
        r2 = 0;
        r0 = r0.remove(r2);	 Catch:{ all -> 0x0022 }
        r0 = (java.lang.Runnable) r0;	 Catch:{ all -> 0x0022 }
        r2 = r0;
    L_0x0037:
        monitor-exit(r3);	 Catch:{ all -> 0x0022 }
        if (r2 == 0) goto L_0x003f;
    L_0x003a:
        r2.run();
        r0 = r1;
        goto L_0x0003;
    L_0x003f:
        r0 = r8.fzn;
        r0 = r0.get();
        r0 = (com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView) r0;
        if (r0 == 0) goto L_0x006e;
    L_0x0049:
        r3 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.g(r0);	 Catch:{ Exception -> 0x0061 }
        r4 = 1;
        r3.cC(r4);	 Catch:{ Exception -> 0x0061 }
    L_0x0051:
        r3 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.i(r0);
        r3.cH(r7);
        r0 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.i(r0);
        r0.ahm();
        r0 = r2;
        goto L_0x0003;
    L_0x0061:
        r3 = move-exception;
        r4 = "MicroMsg.GLThread";
        r5 = "readyToPauseAlsoDoDraw while() ";
        r6 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r3, r5, r6);
        goto L_0x0051;
    L_0x006e:
        r1 = com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.afI();
        monitor-enter(r1);
        r0 = 1;
        r8.fzp = r0;	 Catch:{ all -> 0x0078 }
        monitor-exit(r1);	 Catch:{ all -> 0x0078 }
        goto L_0x000f;
    L_0x0078:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0078 }
        throw r0;
    L_0x007b:
        r2 = r0;
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView$j.afN():void");
    }

    final boolean afO() {
        return !this.fcO && this.fzv && !this.fzw && this.mWidth > 0 && this.mHeight > 0 && (this.fzC || this.mRenderMode == 1);
    }

    private boolean afP() {
        return this.fcO && this.fzu && this.mWidth > 0 && this.mHeight > 0 && (!this.fzC || this.mRenderMode == 1);
    }

    public final void setRenderMode(int i) {
        if (i < 0 || i > 1) {
            throw new IllegalArgumentException("renderMode");
        }
        synchronized (GameGLSurfaceView.afI()) {
            this.mRenderMode = i;
            GameGLSurfaceView.afI().notifyAll();
        }
    }

    public final int getRenderMode() {
        int i;
        synchronized (GameGLSurfaceView.afI()) {
            i = this.mRenderMode;
        }
        return i;
    }

    public final void afQ() {
        synchronized (GameGLSurfaceView.afI()) {
            x.i("MicroMsg.GLThread", "requestExitAndWaitForDestory tid=" + getId());
            this.fzp = true;
            this.fzr = true;
            this.fzt = true;
            GameGLSurfaceView.afI().notifyAll();
            while (!this.fzq) {
                try {
                    GameGLSurfaceView.afI().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
