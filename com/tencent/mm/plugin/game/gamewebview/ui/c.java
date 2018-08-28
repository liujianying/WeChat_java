package com.tencent.mm.plugin.game.gamewebview.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.game.gamewebview.ui.d.22;
import com.tencent.mm.plugin.game.wepkg.a;
import com.tencent.mm.plugin.game.widget.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends FrameLayout {
    private b jIG;
    private b jIH;
    b<b> jII;
    private GameWebViewUI jIJ;
    private Intent jIK;
    private long jIL;

    static /* synthetic */ void d(c cVar) {
        cVar.jIH = new b(cVar.jIJ, cVar);
        cVar.addView(cVar.jIH, 0);
    }

    public c(GameWebViewUI gameWebViewUI) {
        super(gameWebViewUI);
        this.jIJ = gameWebViewUI;
        this.jII = new b(new 1(this, gameWebViewUI));
    }

    public final void cleanup() {
        while (!this.jII.isEmpty()) {
            ((b) this.jII.pop()).agD();
        }
        if (this.jIH != null) {
            this.jIH.agD();
        }
    }

    public final void c(Intent intent, boolean z) {
        this.jIK = intent;
        String stringExtra = intent.getStringExtra("rawUrl");
        if (!bi.oW(stringExtra)) {
            b bVar = (b) this.jII.peek();
            if (bVar != null && bVar.getPageView().getRawUrl().equals(stringExtra)) {
                bVar.setFromKeepTop(aSG());
            } else if (!aSG() || this.jIG == null) {
                b bVar2;
                Object obj = (z || !intent.getBooleanExtra("needAnimation", true)) ? null : 1;
                x.d("MicroMsg.GameWebPageContainer", "createPage start : " + System.currentTimeMillis());
                this.jIL = System.currentTimeMillis();
                if (this.jIH != null) {
                    bVar = this.jIH;
                    this.jIH = null;
                    bVar2 = bVar;
                } else {
                    x.d("MicroMsg.GameWebPageContainer", "createPage begin: " + System.currentTimeMillis());
                    bVar = new b(this.jIJ, this);
                    x.d("MicroMsg.GameWebPageContainer", "createPage end: " + System.currentTimeMillis());
                    bVar2 = bVar;
                }
                bVar2.setBundle(this.jIK.getExtras());
                x.d("MicroMsg.GameWebPageContainer", "LoadUrl begin : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.jIL)});
                x.d("MicroMsg.GameWebPage", "loadUrl, url = %s, pageViewId = %d, this = %d", new Object[]{stringExtra, Integer.valueOf(bVar2.jGU.hashCode()), Integer.valueOf(bVar2.hashCode())});
                d dVar = bVar2.jGU;
                if (bi.oW(stringExtra)) {
                    x.e("MicroMsg.GameWebPageView", "rawUrl is null");
                } else {
                    x.d("MicroMsg.GameWebPageView", "loadUrl, rawUrl = %s, this = %d", new Object[]{stringExtra, Integer.valueOf(dVar.hashCode())});
                    h.mEJ.a(611, 1, 1, false);
                    dVar.jIl = stringExtra;
                    dVar.jJl = new a(dVar.jIJ, dVar.jIZ, dVar.jIZ.hashCode());
                    dVar.jJl.kdI = new 22(dVar);
                    dVar.jJl.az(dVar.jIl, false);
                    if (dVar.jJl.DS(dVar.jIl)) {
                        dVar.jJe.setVisibility(0);
                    }
                    dVar.aSL();
                }
                x.d("MicroMsg.GameWebPageContainer", "LoadUrl end : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.jIL)});
                bVar = (b) this.jII.peek();
                this.jII.push(bVar2);
                if (obj != null) {
                    x.d("MicroMsg.GameWebPageContainer", "addView start : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.jIL)});
                    if (bVar2.getParent() == null) {
                        addView(bVar2, 0);
                    }
                    x.d("MicroMsg.GameWebPageContainer", "addView end : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.jIL)});
                    boolean[] zArr = new boolean[]{false};
                    2 2 = new 2(this, zArr, bVar, bVar2);
                    bVar2.getPageView().setPageCallBack(new 3(this, zArr, 2));
                    x.d("MicroMsg.GameWebPageContainer", "post : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.jIL)});
                    postDelayed(2, 300);
                    return;
                }
                addView(bVar2);
                bVar2.agE();
            } else {
                while (!this.jII.isEmpty()) {
                    b((b) this.jII.pop());
                }
                if (this.jIG.getParent() == null) {
                    addView(this.jIG);
                }
                this.jIG.agE();
                this.jII.push(this.jIG);
            }
        }
    }

    public final void fp(boolean z) {
        if (this.jII.size() <= 1) {
            this.jIJ.finish();
            return;
        }
        4 4 = new 4(this, z);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            4.run();
        } else {
            post(4);
        }
    }

    /* renamed from: a */
    final void b(b bVar) {
        if (bVar != null) {
            bVar.fo(false);
            bVar.setVisibility(8);
            removeView(bVar);
            if (bVar != this.jIG) {
                bVar.agD();
                return;
            }
            Animator ofFloat = ObjectAnimator.ofFloat(bVar, "translationX", new float[]{0.0f});
            ofFloat.setDuration(0);
            a(ofFloat, null);
        }
    }

    private void a(Animator animator, Runnable runnable) {
        animator.addListener(new 7(this, runnable));
        animator.start();
    }

    private boolean aSG() {
        return this.jIK.getBooleanExtra("is_from_keep_top", false);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        b bVar = (b) this.jII.peek();
        if (bVar != null) {
            if (bVar.getPageView().onKeyDown(i, keyEvent)) {
                return true;
            }
            if (i == 4 && bVar.getPageView().aST()) {
                return true;
            }
        }
        return false;
    }

    public final void b(b bVar) {
        x.d("MicroMsg.GameWebPageContainer", "keepPageTop");
        if (this.jIG != bVar) {
            if (this.jIG != null && !this.jII.contains(this.jIG)) {
                this.jIG.agD();
            } else if (this.jIG != null) {
                this.jIG.setHasKeepTop(false);
            }
            this.jIG = bVar;
        }
    }

    public final void aSI() {
        x.d("MicroMsg.GameWebPageContainer", "cancelPageTop");
        if (this.jIG != null && !this.jII.contains(this.jIG)) {
            this.jIG.agD();
        } else if (this.jIG != null) {
            this.jIG.setHasKeepTop(false);
        }
        this.jIG = null;
    }
}
