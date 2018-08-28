package android.support.design.widget;

import android.support.v4.view.z;

class k extends j {
    private boolean fx;

    k(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
    }

    boolean aq() {
        return true;
    }

    final void ar() {
        float rotation = this.fN.getRotation();
        if (this.fy != null) {
            o oVar = this.fy;
            float f = -rotation;
            if (oVar.cY != f) {
                oVar.cY = f;
                oVar.invalidateSelf();
            }
        }
        if (this.fI != null) {
            d dVar = this.fI;
            rotation = -rotation;
            if (rotation != dVar.cY) {
                dVar.cY = rotation;
                dVar.invalidateSelf();
            }
        }
    }

    final void am() {
        if (!this.fx && this.fN.getVisibility() == 0) {
            if (!z.ai(this.fN) || this.fN.isInEditMode()) {
                this.fN.i(8, false);
                return;
            }
            this.fN.animate().cancel();
            this.fN.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(a.bN).setListener(new 1(this));
        }
    }

    final void an() {
        if (!this.fx && this.fN.getVisibility() == 0) {
            return;
        }
        if (!z.ai(this.fN) || this.fN.isInEditMode()) {
            this.fN.i(0, false);
            this.fN.setAlpha(1.0f);
            this.fN.setScaleY(1.0f);
            this.fN.setScaleX(1.0f);
            return;
        }
        this.fN.animate().cancel();
        if (this.fN.getVisibility() != 0) {
            this.fN.setAlpha(0.0f);
            this.fN.setScaleY(0.0f);
            this.fN.setScaleX(0.0f);
        }
        this.fN.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(a.bO).setListener(new 2(this));
    }
}
