package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements AnimatorUpdateListener {
    final /* synthetic */ b lry;

    b$1(b bVar) {
        this.lry = bVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.lry.lrh = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        b bVar = this.lry;
        float f = this.lry.lrh;
        bVar.lrv = (float) ((int) (((float) Math.round((float) (MMSightProgressBar.lqU + (MMSightProgressBar.iGr * 2)))) * (f / 100.0f)));
        bVar.lrs = bVar.lrt - ((f / 100.0f) * (bVar.lrt - bVar.lru));
        bVar.lrm = new PointF((float) MMSightProgressBar.iGr, 0.0f);
        bVar.lrn = new PointF(((float) MMSightProgressBar.iGr) + (bVar.lrv / 2.0f), ((float) MMSightProgressBar.iGr) - (bVar.lrs / 2.0f));
        bVar.lro = new PointF(((float) MMSightProgressBar.iGr) + bVar.lrv, 0.0f);
        bVar.lrp = new PointF((float) MMSightProgressBar.iGr, (float) (MMSightProgressBar.iGr * 2));
        bVar.lrq = new PointF(((float) MMSightProgressBar.iGr) + (bVar.lrv / 2.0f), ((float) MMSightProgressBar.iGr) + (bVar.lrs / 2.0f));
        bVar.lrr = new PointF(((float) MMSightProgressBar.iGr) + bVar.lrv, ((float) MMSightProgressBar.iGr) * 2.0f);
        x.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, currentPointDistance: %s, curveCenterDistance: %s", new Object[]{Float.valueOf(bVar.lrv), Float.valueOf(bVar.lrs)});
        x.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, point1: %s, point2: %s, point3: %s, point4: %s, point5: %s, point6: %s", new Object[]{bVar.lrm, bVar.lrn, bVar.lro, bVar.lrp, bVar.lrq, bVar.lrr});
        if (this.lry.lrl != null) {
            this.lry.lrl.bfv();
        }
    }
}
