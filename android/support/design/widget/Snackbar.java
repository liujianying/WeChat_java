package android.support.design.widget;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.q.a;
import android.support.v4.view.z;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public final class Snackbar {
    private static final Handler gA = new Handler(Looper.getMainLooper(), new 1());
    final ViewGroup gB;
    final SnackbarLayout gC;
    private final AccessibilityManager gD;
    final a gE;

    static /* synthetic */ void a(Snackbar snackbar) {
        q aE = q.aE();
        a aVar = snackbar.gE;
        synchronized (aE.mLock) {
            if (aE.d(aVar)) {
                aE.a(aE.gN);
            } else if (aE.e(aVar)) {
                aE.a(aE.gO);
            }
        }
    }

    /* renamed from: ax */
    final void f() {
        if (VERSION.SDK_INT >= 14) {
            z.c(this.gC, (float) this.gC.getHeight());
            z.U(this.gC).v(0.0f).c(a.bM).h(250).a(new 6(this)).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.gC.getContext(), android.support.design.a.a.design_snackbar_in);
        loadAnimation.setInterpolator(a.bM);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new 7(this));
        this.gC.startAnimation(loadAnimation);
    }

    /* renamed from: ay */
    final void g() {
        q aE = q.aE();
        a aVar = this.gE;
        synchronized (aE.mLock) {
            if (aE.d(aVar)) {
                aE.b(aE.gN);
            }
        }
    }

    /* renamed from: az */
    final void c() {
        q aE = q.aE();
        a aVar = this.gE;
        synchronized (aE.mLock) {
            if (aE.d(aVar)) {
                aE.gN = null;
                if (!(aE.gO == null || aE.gO == null)) {
                    aE.gN = aE.gO;
                    aE.gO = null;
                    if (((a) aE.gN.gQ.get()) == null) {
                        aE.gN = null;
                    }
                }
            }
        }
        ViewParent parent = this.gC.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.gC);
        }
    }

    /* renamed from: aA */
    final boolean e() {
        return !this.gD.isEnabled();
    }
}
