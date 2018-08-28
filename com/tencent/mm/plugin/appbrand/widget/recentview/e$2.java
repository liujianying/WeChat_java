package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.z;
import android.util.DisplayMetrics;

class e$2 extends z {
    final /* synthetic */ e gPJ;

    e$2(e eVar, Context context) {
        this.gPJ = eVar;
        super(context);
    }

    protected final int fm() {
        return -1;
    }

    protected final float a(DisplayMetrics displayMetrics) {
        return 30.0f / ((float) displayMetrics.densityDpi);
    }

    public final PointF bf(int i) {
        return ((LinearLayoutManager) this.gPJ.Sa.getLayoutManager()).bf(i);
    }
}
