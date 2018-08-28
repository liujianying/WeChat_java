package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;

class j extends l {
    private int fv;
    private r fw = new r();
    private boolean fx;
    o fy;

    private abstract class a extends Animation {
        private float fC;
        private float fD;

        protected abstract float ap();

        private a() {
        }

        /* synthetic */ a(j jVar, byte b) {
            this();
        }

        public void reset() {
            super.reset();
            this.fC = j.this.fy.gt;
            this.fD = ap() - this.fC;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            o oVar = j.this.fy;
            oVar.o(this.fC + (this.fD * f), oVar.gr);
        }
    }

    private class c extends a {
        private c() {
            super(j.this, (byte) 0);
        }

        /* synthetic */ c(j jVar, byte b) {
            this();
        }

        protected final float ap() {
            return j.this.fK;
        }
    }

    j(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
        this.fv = visibilityAwareImageButton.getResources().getInteger(17694720);
        r rVar = this.fw;
        View aF = rVar.aF();
        if (aF != visibilityAwareImageButton) {
            if (aF != null) {
                View aF2 = rVar.aF();
                int size = rVar.gR.size();
                for (int i = 0; i < size; i++) {
                    if (aF2.getAnimation() == ((android.support.design.widget.r.a) rVar.gR.get(i)).mAnimation) {
                        aF2.clearAnimation();
                    }
                }
                rVar.cB = null;
                rVar.gS = null;
                rVar.gT = null;
            }
            if (visibilityAwareImageButton != null) {
                rVar.cB = new WeakReference(visibilityAwareImageButton);
            }
        }
        this.fw.a(PRESSED_ENABLED_STATE_SET, e(new b(this, (byte) 0)));
        this.fw.a(fM, e(new b(this, (byte) 0)));
        this.fw.a(EMPTY_STATE_SET, e(new c(this, (byte) 0)));
    }

    void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.fG = android.support.v4.b.a.a.g(au());
        android.support.v4.b.a.a.a(this.fG, colorStateList);
        if (mode != null) {
            android.support.v4.b.a.a.a(this.fG, mode);
        }
        this.fH = android.support.v4.b.a.a.g(au());
        android.support.v4.b.a.a.a(this.fH, F(i));
        if (i2 > 0) {
            this.fI = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.fI, this.fG, this.fH};
        } else {
            this.fI = null;
            drawableArr = new Drawable[]{this.fG, this.fH};
        }
        this.fJ = new LayerDrawable(drawableArr);
        this.fy = new o(this.fN.getResources(), this.fJ, this.fO.getRadius(), this.fK, this.fK + this.fL);
        o oVar = this.fy;
        oVar.gy = false;
        oVar.invalidateSelf();
        this.fO.setBackgroundDrawable(this.fy);
    }

    final void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.fG != null) {
            android.support.v4.b.a.a.a(this.fG, colorStateList);
        }
        if (this.fI != null) {
            this.fI.a(colorStateList);
        }
    }

    final void setBackgroundTintMode(Mode mode) {
        if (this.fG != null) {
            android.support.v4.b.a.a.a(this.fG, mode);
        }
    }

    void setRippleColor(int i) {
        if (this.fH != null) {
            android.support.v4.b.a.a.a(this.fH, F(i));
        }
    }

    float getElevation() {
        return this.fK;
    }

    void l(float f) {
        if (this.fy != null) {
            this.fy.o(f, this.fL + f);
            as();
        }
    }

    void m(float f) {
        if (this.fy != null) {
            o oVar = this.fy;
            oVar.o(oVar.gt, this.fK + f);
            as();
        }
    }

    void c(int[] iArr) {
        android.support.design.widget.r.a aVar;
        r rVar = this.fw;
        int size = rVar.gR.size();
        for (int i = 0; i < size; i++) {
            android.support.design.widget.r.a aVar2 = (android.support.design.widget.r.a) rVar.gR.get(i);
            if (StateSet.stateSetMatches(aVar2.gW, iArr)) {
                aVar = aVar2;
                break;
            }
        }
        aVar = null;
        if (aVar != rVar.gS) {
            View aF;
            if (!(rVar.gS == null || rVar.gT == null)) {
                aF = rVar.aF();
                if (aF != null && aF.getAnimation() == rVar.gT) {
                    aF.clearAnimation();
                }
                rVar.gT = null;
            }
            rVar.gS = aVar;
            aF = (View) rVar.cB.get();
            if (aVar != null && aF != null && aF.getVisibility() == 0) {
                rVar.gT = aVar.mAnimation;
                aF = rVar.aF();
                if (aF != null) {
                    aF.startAnimation(rVar.gT);
                }
            }
        }
    }

    void al() {
        r rVar = this.fw;
        if (rVar.gT != null) {
            View aF = rVar.aF();
            if (aF != null && aF.getAnimation() == rVar.gT) {
                aF.clearAnimation();
            }
        }
    }

    void am() {
        if (!this.fx && this.fN.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.fN.getContext(), android.support.design.a.a.design_fab_out);
            loadAnimation.setInterpolator(a.bN);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new 1(this));
            this.fN.startAnimation(loadAnimation);
        }
    }

    void an() {
        if (this.fN.getVisibility() != 0 || this.fx) {
            this.fN.clearAnimation();
            this.fN.i(0, false);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.fN.getContext(), android.support.design.a.a.design_fab_in);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(a.bO);
            loadAnimation.setAnimationListener(new 2(this));
            this.fN.startAnimation(loadAnimation);
        }
    }

    void ao() {
    }

    void d(Rect rect) {
        this.fy.getPadding(rect);
    }

    private Animation e(Animation animation) {
        animation.setInterpolator(a.bM);
        animation.setDuration((long) this.fv);
        return animation;
    }

    private static ColorStateList F(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{fM, i, PRESSED_ENABLED_STATE_SET};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }
}
