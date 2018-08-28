package com.tencent.mm.plugin.voip.widget;

class BaseSmallView$1 implements Runnable {
    final /* synthetic */ BaseSmallView oVJ;

    BaseSmallView$1(BaseSmallView baseSmallView) {
        this.oVJ = baseSmallView;
    }

    public final void run() {
        float currentTimeMillis = (((float) (System.currentTimeMillis() - BaseSmallView.a(this.oVJ))) * 1.0f) / 200.0f;
        if (currentTimeMillis <= 1.0f) {
            this.oVJ.ioW.postDelayed(BaseSmallView.b(this.oVJ), 5);
            BaseSmallView.a(this.oVJ, BaseSmallView.c(this.oVJ).x + ((int) (((((float) BaseSmallView.d(this.oVJ).x) * 1.0f) - ((float) BaseSmallView.c(this.oVJ).x)) * currentTimeMillis)), ((int) (currentTimeMillis * ((((float) BaseSmallView.d(this.oVJ).y) * 1.0f) - ((float) BaseSmallView.c(this.oVJ).y)))) + BaseSmallView.c(this.oVJ).y);
            return;
        }
        BaseSmallView.a(this.oVJ, BaseSmallView.d(this.oVJ).x, BaseSmallView.d(this.oVJ).y);
        this.oVJ.onAnimationEnd();
    }
}
