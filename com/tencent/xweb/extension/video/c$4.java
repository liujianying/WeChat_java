package com.tencent.xweb.extension.video;

import android.widget.FrameLayout.LayoutParams;

class c$4 implements Runnable {
    final /* synthetic */ c vCb;
    final /* synthetic */ double vCf;
    final /* synthetic */ double[] vCg;

    c$4(c cVar, double d, double[] dArr) {
        this.vCb = cVar;
        this.vCf = d;
        this.vCg = dArr;
    }

    public final void run() {
        b l = c.l(this.vCb);
        double d = this.vCf;
        double[] dArr = this.vCg;
        double d2 = 0.0d;
        int i = 0;
        while (i < dArr.length) {
            if (dArr.length > i + 1 && (dArr[i] / d) * 100.0d <= ((double) l.tua) && (dArr[i + 1] / d) * 100.0d > ((double) l.tua)) {
                d2 = (dArr[i + 1] / d) * 100.0d;
            }
            i += 2;
        }
        LayoutParams layoutParams = (LayoutParams) l.gaS.getLayoutParams();
        layoutParams.width = (int) ((d2 / 100.0d) * ((double) l.ndj.getWidth()));
        l.gaS.setLayoutParams(layoutParams);
        l.gaS.requestLayout();
    }
}
