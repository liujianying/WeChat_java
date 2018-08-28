package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.c;

class d$1 implements AnimatorUpdateListener {
    final /* synthetic */ f gMv;
    final /* synthetic */ f gMw;
    final /* synthetic */ double[] gMx;
    final /* synthetic */ d gMy;

    d$1(d dVar, f fVar, f fVar2, double[] dArr) {
        this.gMy = dVar;
        this.gMv = fVar;
        this.gMw = fVar2;
        this.gMx = dArr;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (!this.gMv.equals(this.gMw)) {
            double parseDouble = Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue()));
            double d = this.gMv.x + (((this.gMw.x - this.gMv.x) * parseDouble) / this.gMx[0]);
            parseDouble = ((parseDouble * (this.gMw.y - this.gMv.y)) / this.gMx[0]) + this.gMv.y;
            h hVar = this.gMy.gMr;
            g gVar = this.gMy.gMu;
            f fVar = new f(d, parseDouble);
            d = 360.0d * ((fVar.x / gVar.gMG) - 0.5d);
            hVar.b(((c) g.l(c.class)).g(90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (fVar.y / gVar.gMG))) * 2.0d) * 3.141592653589793d)) * 2.0d), d));
        }
    }
}
