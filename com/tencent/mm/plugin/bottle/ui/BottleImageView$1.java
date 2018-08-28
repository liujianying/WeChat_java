package com.tencent.mm.plugin.bottle.ui;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

class BottleImageView$1 extends Animation {
    private float hkh = -1.0f;
    private float hki = -1.0f;
    private float hkj = -1.0f;
    private float hkk = -1.0f;
    private float hkl = 1.0f;
    private float hkm = 0.1f;
    private float hlk;
    private float hll;
    private float hlm;
    private float hln;
    private float hlo;
    private boolean hlp = false;
    private float hlq = 0.0f;
    private float hlr = -850.0f;
    private float hls = 1.0f;
    private float hlt = 0.3f;
    final /* synthetic */ BottleImageView hlu;

    BottleImageView$1(BottleImageView bottleImageView) {
        this.hlu = bottleImageView;
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        if (this.hkh == -1.0f) {
            this.hkh = (float) BottleImageView.c(this.hlu);
            this.hki = (float) BottleImageView.d(this.hlu);
            this.hkj = (float) BottleImageView.e(this.hlu);
            this.hkk = (float) BottleImageView.f(this.hlu);
            this.hlk = this.hkh + ((this.hki - this.hkh) / 5.0f);
            this.hll = this.hkh + (((this.hki - this.hkh) * 3.0f) / 5.0f);
            this.hlm = ((((this.hlk - this.hkh) / (this.hki - this.hkh)) * (this.hkk - this.hkj)) + this.hkj) - ((float) b.b(BottleImageView.g(this.hlu), 67.0f));
            this.hln = ((((this.hll - this.hkh) / (this.hki - this.hkh)) * (this.hkk - this.hkj)) + this.hkj) - ((float) b.b(BottleImageView.g(this.hlu), 53.0f));
        }
        transformation.setAlpha(this.hls + ((this.hlt - this.hls) * f));
        float f2 = this.hkl + ((this.hkm - this.hkl) * f);
        transformation.getMatrix().setScale(f2, f2, (float) (BottleImageView.a(this.hlu) / 2), (float) (BottleImageView.b(this.hlu) / 2));
        transformation.getMatrix().postRotate(this.hlq + ((this.hlr - this.hlq) * f), (float) (BottleImageView.a(this.hlu) / 2), (float) (BottleImageView.b(this.hlu) / 2));
        float f3 = ((this.hki - this.hkh) * f) + this.hkh;
        if (f3 >= this.hlk) {
            f2 = (((f3 - this.hkh) / (this.hlk - this.hkh)) * (this.hlm - this.hkj)) + this.hkj;
        } else if (f3 >= this.hll) {
            if (!this.hlp) {
                this.hlp = true;
                this.hlm = this.hlo;
            }
            f2 = (((f3 - this.hlk) / (this.hll - this.hlk)) * (this.hln - this.hlm)) + this.hlm;
        } else {
            f2 = (((f3 - this.hll) / (this.hki - this.hll)) * (this.hkk - this.hln)) + this.hln;
        }
        this.hlo = f2;
        transformation.getMatrix().postTranslate(f3, f2);
        if (f == 1.0f) {
            this.hkh = -1.0f;
            this.hki = -1.0f;
            this.hkj = -1.0f;
            this.hkk = -1.0f;
            this.hlp = false;
        }
    }
}
