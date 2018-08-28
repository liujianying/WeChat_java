package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.j;
import com.tencent.mm.plugin.appbrand.game.c;
import com.tencent.mm.plugin.appbrand.game.k;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

@SuppressLint({"ViewConstructor"})
public final class d extends p implements c {
    private boolean Sx = true;
    private b fCG;
    WAGamePageViewContainerLayout fCH;
    public k fCI;
    ImageView fCJ;
    MBCanvasContentHolder fCK;
    boolean fCL = false;
    private u fCM;
    private final ConcurrentLinkedQueue<Runnable> fCN = new ConcurrentLinkedQueue();
    private Bitmap fCO = null;
    private final Object fCP = new Object();
    private String fCQ;
    private String mUrl;

    static /* synthetic */ boolean a(WAGamePageViewContainerLayout.b bVar) {
        return bVar == WAGamePageViewContainerLayout.b.fCV || bVar == WAGamePageViewContainerLayout.b.fCX;
    }

    static /* synthetic */ boolean b(WAGamePageViewContainerLayout.b bVar) {
        return bVar == WAGamePageViewContainerLayout.b.fCW || bVar == WAGamePageViewContainerLayout.b.fCY;
    }

    d(Context context, g gVar) {
        boolean z = false;
        a(context, gVar);
        this.gnC.h(gVar);
        this.fCG = gVar.fcy.fdQ;
        if (ad.cia() != null) {
            z = ad.cia().getBoolean("appbrandgame_open_v8debug", false);
        }
        com.tencent.magicbrush.engine.c.aC(z);
    }

    protected final void initView() {
        x.i("AppBrandGame.WAGamePageView", "new Rendder GameView");
        initActionBar();
        this.fCH = new WAGamePageViewContainerLayout(this.mContext);
        agN();
        View frameLayout = new FrameLayout(this.mContext);
        this.fCH.addView(frameLayout, new LayoutParams(-1, -1));
        this.fCM = new a(frameLayout);
        this.fCM.setFullscreenImpl(alO());
        float f = this.mContext.getResources().getDisplayMetrics().density;
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.rightMargin = a.ae(this.mContext, e.app_brand_game_mode_icon_margin_right);
        layoutParams.topMargin = a.ae(this.mContext, e.app_brand_game_mode_icon_margin_top);
        this.fCH.addView(this.gnn.getActionView(), layoutParams);
        D(l.gjB, false);
        if (this.fdO.fcu.fqL) {
            com.tencent.mm.plugin.appbrand.game.c.d ags = com.tencent.mm.plugin.appbrand.game.c.d.ags();
            WAGamePageViewContainerLayout wAGamePageViewContainerLayout = this.fCH;
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("You can only init GameInspector in main thread.");
            } else if (ags.mState == 0) {
                ags.mContext = wAGamePageViewContainerLayout.getContext();
                ags.fBo = new com.tencent.mm.plugin.appbrand.game.c.c(ags.mContext);
                ags.fBo.setBackground(ags.mContext.getResources().getDrawable(f.app_brand_game_action_icon_round_rect_background));
                ags.fBp = new com.tencent.mm.plugin.appbrand.game.c.b(ags.mContext);
                wAGamePageViewContainerLayout.setClipChildren(false);
                float f2 = ags.mContext.getResources().getDisplayMetrics().density;
                if (ags.fBp != null) {
                    wAGamePageViewContainerLayout.addView(ags.fBp, new LayoutParams(-1, -1));
                    ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
                    layoutParams2.gravity = 8388693;
                    layoutParams2.bottomMargin = (int) (25.0f * f2);
                    int i = (int) (f2 * 15.0f);
                    layoutParams2.rightMargin = i;
                    layoutParams2.leftMargin = i;
                    wAGamePageViewContainerLayout.addView(ags.fBp.fBe, layoutParams2);
                }
                if (ags.fBo != null) {
                    wAGamePageViewContainerLayout.addView(ags.fBo, new LayoutParams(-2, -2));
                }
                ags.mState = 1;
            }
        }
        this.fCJ = new ImageView(this.mContext);
        this.fCH.addView(this.fCJ, new LayoutParams(-1, -1));
    }

    final void agN() {
        if (ah.isMainThread()) {
            this.fCI = new k(this.mContext, this.fdO, new 2(this), new 3(this));
            this.fCH.addView(this.fCI, 0, new LayoutParams(-1, -1));
            return;
        }
        ah.A(new 1(this));
    }

    public final void j(String str, String str2, int i) {
        x.d("AppBrandGame.WAGamePageView", "dispatch event %s, data %s, src %d", new Object[]{str, str2, Integer.valueOf(i)});
    }

    public final b aaI() {
        return this.fCG;
    }

    public final View getContentView() {
        return this.fCH;
    }

    public final void sX(String str) {
        this.gnC.vq(str);
        this.mUrl = str;
        this.fCQ = com.tencent.mm.plugin.appbrand.q.l.vP(str);
        x.i("AppBrandGame.WAGamePageView", "loadURL url : " + str);
    }

    public final void e(Runnable runnable) {
        p(runnable);
    }

    final void p(Runnable runnable) {
        if (this.fCI != null) {
            if (this.fCN.size() > 0) {
                synchronized (this.fCN) {
                    if (this.fCN.size() > 0) {
                        x.v("AppBrandGame.WAGamePageView", "hy: try to render %d", new Object[]{Integer.valueOf(this.fCN.size())});
                        Iterator it = this.fCN.iterator();
                        while (it.hasNext()) {
                            Runnable runnable2 = (Runnable) it.next();
                            if (runnable2 != null) {
                                this.fCI.queueEvent(runnable2);
                            }
                        }
                        this.fCN.clear();
                    }
                }
            }
            if (runnable != null) {
                this.fCI.queueEvent(runnable);
                return;
            }
            return;
        }
        synchronized (this.fCN) {
            x.v("AppBrandGame.WAGamePageView", "hy: add to task first");
            if (runnable != null) {
                this.fCN.add(runnable);
            }
        }
    }

    public final void a(String str, String str2, int[] iArr) {
        this.fdO.fcy.j(str, str2, hashCode());
    }

    public final boolean isRunning() {
        return this.Sx;
    }

    public final void show() {
        this.fCH.setVisibility(0);
    }

    public final void hide() {
        this.fCH.setVisibility(4);
    }

    protected final void agO() {
        this.gnC.amF();
    }

    protected final void agP() {
        x.i("AppBrandGame.WAGamePageView", "hy: on perform foreground");
        this.gnC.agL();
        agS();
        k kVar = this.fCI;
        x.i("MicroMsg.GameGLSurfaceView", "onResume");
        j jVar = kVar.fyV;
        synchronized (GameGLSurfaceView.afI()) {
            x.i("MicroMsg.GLThread", "onResume tid=" + jVar.getId());
            jVar.fzs = false;
            jVar.fzu = false;
            jVar.fzC = true;
            jVar.fzE = false;
            GameGLSurfaceView.afI().notifyAll();
            while (!jVar.fzq && jVar.fcO && !jVar.fzE) {
                x.i("MicroMsg.GLThread", "onResume waiting for !mPaused.");
                try {
                    GameGLSurfaceView.afI().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        this.gnE.agE();
        ahd();
    }

    protected final void agQ() {
        x.i("AppBrandGame.WAGamePageView", "hy: on perform background");
        this.gnC.agK();
        k kVar = this.fCI;
        x.i("MicroMsg.GameGLSurfaceView", "onPauseAlsoDraw");
        j jVar = kVar.fyV;
        synchronized (GameGLSurfaceView.afI()) {
            x.i("MicroMsg.GLThread", "onPauseAlsoDoDraw tid=" + jVar.getId());
            jVar.fzu = true;
            jVar.fzs = true;
            GameGLSurfaceView.afI().notifyAll();
            while (!jVar.fzq && !jVar.fcO) {
                x.i("MicroMsg.GLThread", "onPause waiting for mPaused.");
                try {
                    GameGLSurfaceView.afI().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        if (this.gnp != null) {
            this.gnp.dismiss();
        }
    }

    protected final void agR() {
        this.Sx = false;
        this.gnC.onDestroy();
        agS();
        k kVar = this.fCI;
        x.i("MicroMsg.GameGLSurfaceView", "onDestroy");
        kVar.fyV.afQ();
        com.tencent.mm.plugin.appbrand.game.c.d.release();
    }

    private void agS() {
        synchronized (this.fCP) {
            if (!(this.fCO == null || this.fCO.isRecycled())) {
                x.i("AppBrandGame.WAGamePageView", "hy: recycling captured screen");
                this.fCO.recycle();
                this.fCO = null;
            }
        }
    }

    protected final void agT() {
    }

    public final u agU() {
        return this.fCM;
    }

    public final boolean agV() {
        return false;
    }

    public final void sY(String str) {
    }

    public final void kp(int i) {
    }

    public final void sZ(String str) {
    }

    public final String agW() {
        return null;
    }

    public final void ta(String str) {
    }

    public final void kq(int i) {
    }

    public final void cD(boolean z) {
    }

    protected final void agX() {
    }

    public final void agY() {
    }

    public final void agZ() {
    }

    public final void cE(boolean z) {
    }

    public final void bm(String str, String str2) {
    }

    public final void cF(boolean z) {
    }

    public final void tb(String str) {
        if (this.mContext instanceof Activity) {
            Window window = ((Activity) this.mContext).getWindow();
            if (window != null) {
                com.tencent.mm.plugin.appbrand.ui.j.a(window, "black".equals(str));
            }
        }
    }

    public final void kr(int i) {
    }

    public final FrameLayout aha() {
        return this.fCH;
    }

    public final View ahb() {
        AppBrandActionHeaderLayout appBrandActionHeaderLayout = new AppBrandActionHeaderLayout(this.mContext);
        appBrandActionHeaderLayout.setAppId(this.mAppId);
        appBrandActionHeaderLayout.setActionHeaderStyle(this.gnz);
        x.w("AppBrandGame.WAGamePageView", "getActionSheetHeader orientation:%d,mActionSheetTitleStrId:%d", new Object[]{Integer.valueOf(((MMActivity) this.mContext).getRequestedOrientation()), Integer.valueOf(this.gnA)});
        if (((MMActivity) this.mContext).getRequestedOrientation() == 6) {
            if (this.gnA > 0) {
                appBrandActionHeaderLayout.setStatusId(this.gnA);
            }
            String str = this.fdO.fct.iconUrl;
            String str2 = this.fdO.fct.bKC;
            appBrandActionHeaderLayout.glR.setVisibility(0);
            appBrandActionHeaderLayout.glS.setVisibility(8);
            appBrandActionHeaderLayout.glT.setImageDrawable(com.tencent.mm.modelappbrand.b.a.JZ());
            com.tencent.mm.modelappbrand.b.b.Ka().a(appBrandActionHeaderLayout.glT.getImageView(), str, null, com.tencent.mm.modelappbrand.b.f.dGr);
            appBrandActionHeaderLayout.glT.setTextViewText(str2);
            return appBrandActionHeaderLayout;
        } else if (this.gnA <= 0) {
            return null;
        } else {
            appBrandActionHeaderLayout.setStatusId(this.gnA);
            return appBrandActionHeaderLayout;
        }
    }

    public final void ks(int i) {
        this.gnA = i;
    }

    public final String getURL() {
        return this.fCQ;
    }

    public final String ahc() {
        return this.mUrl;
    }

    public final <T> T a(int i, Bundle bundle, Object... objArr) {
        boolean z = false;
        switch (i) {
            case 1:
                x.i("AppBrandGame.WAGamePageView", "hy: got message beforeShare");
                if (bundle == null) {
                    x.e("AppBrandGame.WAGamePageView", "hy: got message beforeShare data is null");
                    break;
                }
                MBCanvasContentHolder kt = com.tencent.mm.plugin.appbrand.game.e.a.fDd.kt(bundle.getInt("canvasId", -1));
                x.i("AppBrandGame.WAGamePageView", "hy: got message beforeShare end");
                if (!(kt == null || kt.content == null)) {
                    synchronized (this.fCP) {
                        this.fCO = kt.content;
                    }
                }
            case 2:
                if (bundle != null) {
                    z = bundle.getBoolean("needPortraitSnapshot", false);
                }
                if (!(this.fCK == null || this.fCK.content == null)) {
                    this.fCK.content.recycle();
                    this.fCK.content = null;
                }
                if (this.fCJ == null) {
                    this.fCJ = new ImageView(this.mContext);
                }
                com.tencent.mm.plugin.appbrand.config.d.b bVar = com.tencent.mm.plugin.appbrand.config.d.b.fpw;
                com.tencent.mm.plugin.appbrand.config.d.b(this.fdO.fcq);
                if (bVar != com.tencent.mm.plugin.appbrand.config.d.cu(this.mContext)) {
                    if (!z) {
                        x.i("AppBrandGame.WAGamePageView", "hy: vertical game. not need screenshot");
                        break;
                    }
                    this.fCK = com.tencent.mm.plugin.appbrand.game.e.a.fDd.ahj();
                    if (this.fCK != null && this.fCK.content != null) {
                        ah.A(new 5(this));
                        this.fCL = true;
                        x.i("AppBrandGame.WAGamePageView", "hy: vertical game. isRedpackge isPortrait screenshot");
                        break;
                    }
                    x.e("AppBrandGame.WAGamePageView", "hy: screenshot is null");
                    break;
                }
                this.fCK = com.tencent.mm.plugin.appbrand.game.e.a.fDd.ahj();
                this.fCH.setOnConfigurationChangedListener(new 4(this));
                break;
                break;
            case 3:
                x.i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap");
                if (bundle == null) {
                    x.e("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap data is null");
                    return null;
                }
                int i2 = bundle.getInt("canvasId", -1);
                boolean z2 = bundle.getBoolean("sync", true);
                if (i2 == -1) {
                    x.e("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap canvasId is illegal");
                    return null;
                }
                T ku;
                x.i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap canvasId:%d,sync:%b", new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)});
                if (z2) {
                    com.tencent.mm.plugin.appbrand.game.e.a aVar = com.tencent.mm.plugin.appbrand.game.e.a.fDd;
                    ku = com.tencent.mm.plugin.appbrand.game.e.a.ku(i2);
                } else {
                    ku = com.tencent.mm.plugin.appbrand.game.e.a.fDd.kt(i2);
                }
                x.i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap end");
                return ku;
            default:
                x.w("AppBrandGame.WAGamePageView", "hy: not support this command!! %d", new Object[]{Integer.valueOf(i)});
                break;
        }
        return super.a(i, bundle, objArr);
    }

    final void ahd() {
        if (this.fCL) {
            this.fCL = false;
            this.fCJ.setVisibility(8);
            if (this.fCK != null && this.fCK.content != null) {
                this.fCK.content.recycle();
                this.fCK.content = null;
            }
        }
    }

    public final Bitmap ahe() {
        x.i("AppBrandGame.WAGamePageView", "hy: jsapi enter wait");
        return null;
    }

    public final boolean ahf() {
        return com.tencent.mm.plugin.appbrand.config.d.cu(this.mContext) == com.tencent.mm.plugin.appbrand.config.d.b.fpw;
    }

    public final boolean isFullScreen() {
        return ((com.tencent.mm.plugin.appbrand.game.page.a.a) this.gnE).fDb == com.tencent.mm.plugin.appbrand.page.a.c.a.gpp;
    }

    protected final com.tencent.mm.plugin.appbrand.page.a.c ahg() {
        return new com.tencent.mm.plugin.appbrand.game.page.a.a(this);
    }
}
