package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.v4.b.a.a;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
final class m extends k {
    private InsetDrawable fR;
    private final Interpolator mInterpolator;

    m(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
        this.mInterpolator = visibilityAwareImageButton.isInEditMode() ? null : AnimationUtils.loadInterpolator(this.fN.getContext(), 17563661);
    }

    final void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.fG = a.g(au());
        a.a(this.fG, colorStateList);
        if (mode != null) {
            a.a(this.fG, mode);
        }
        if (i2 > 0) {
            this.fI = a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.fI, this.fG});
        } else {
            this.fI = null;
            layerDrawable = this.fG;
        }
        this.fH = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.fJ = this.fH;
        this.fO.setBackgroundDrawable(this.fH);
    }

    final void setRippleColor(int i) {
        if (this.fH instanceof RippleDrawable) {
            ((RippleDrawable) this.fH).setColor(ColorStateList.valueOf(i));
        } else {
            super.setRippleColor(i);
        }
    }

    public final void l(float f) {
        this.fN.setElevation(f);
        if (this.fO.ak()) {
            as();
        }
    }

    final void m(float f) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, a(ObjectAnimator.ofFloat(this.fN, "translationZ", new float[]{f})));
        stateListAnimator.addState(fM, a(ObjectAnimator.ofFloat(this.fN, "translationZ", new float[]{f})));
        stateListAnimator.addState(EMPTY_STATE_SET, a(ObjectAnimator.ofFloat(this.fN, "translationZ", new float[]{0.0f})));
        this.fN.setStateListAnimator(stateListAnimator);
        if (this.fO.ak()) {
            as();
        }
    }

    public final float getElevation() {
        return this.fN.getElevation();
    }

    final void ao() {
        as();
    }

    final void e(Rect rect) {
        if (this.fO.ak()) {
            this.fR = new InsetDrawable(this.fH, rect.left, rect.top, rect.right, rect.bottom);
            this.fO.setBackgroundDrawable(this.fR);
            return;
        }
        this.fO.setBackgroundDrawable(this.fH);
    }

    final void c(int[] iArr) {
    }

    final void al() {
    }

    final boolean aq() {
        return false;
    }

    private Animator a(Animator animator) {
        animator.setInterpolator(this.mInterpolator);
        return animator;
    }

    final d at() {
        return new e();
    }

    final void d(Rect rect) {
        if (this.fO.ak()) {
            float radius = this.fO.getRadius();
            float elevation = this.fN.getElevation() + this.fL;
            int ceil = (int) Math.ceil((double) o.d(elevation, radius, false));
            int ceil2 = (int) Math.ceil((double) o.c(elevation, radius, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
