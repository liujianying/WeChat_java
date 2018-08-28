package com.tencent.mm.plugin.sport.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;

class SportChartView$1 extends SimpleOnGestureListener {
    private long opK;
    final /* synthetic */ SportChartView opL;

    SportChartView$1(SportChartView sportChartView) {
        this.opL = sportChartView;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        SportChartView.a(this.opL, SportChartView.a(this.opL, x));
        SportChartView.a(this.opL);
        SportChartView.b(this.opL);
        x.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", Float.valueOf(x), Float.valueOf(y), Integer.valueOf(SportChartView.c(this.opL)));
        this.opL.invalidate();
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        x.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", Float.valueOf(f));
        if (System.currentTimeMillis() - this.opK < 500 || !SportChartView.d(this.opL)) {
            return false;
        }
        this.opK = System.currentTimeMillis();
        if (f > 0.0f) {
            SportChartView.e(this.opL);
            if (SportChartView.f(this.opL) > SportChartView.g(this.opL)) {
                SportChartView.b(this.opL, SportChartView.g(this.opL));
            }
            SportChartView.h(this.opL);
            this.opL.invalidate();
            return true;
        } else if (f >= 0.0f) {
            return false;
        } else {
            SportChartView.i(this.opL);
            if (SportChartView.f(this.opL) <= 0) {
                SportChartView.b(this.opL, 1);
            }
            SportChartView.h(this.opL);
            this.opL.invalidate();
            return true;
        }
    }
}
