package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

class lg$b extends View {
    final /* synthetic */ lg a;

    public lg$b(lg lgVar, Context context) {
        this.a = lgVar;
        super(context);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        lg.a(this.a, canvas, getHeight());
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(Math.min(Math.round(((float) lg.a(this.a)) + (12.0f * lg.b(this.a))), lg.c(this.a) / 2), Math.round(((float) lg.d(this.a)) * lg.b(this.a)));
    }
}
