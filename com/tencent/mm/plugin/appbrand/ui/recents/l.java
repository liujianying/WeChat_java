package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.z;

final class l extends z {
    private final LinearLayoutManager gAX;
    private final int gAY = 3000;
    private final int gAZ;

    l(Context context, LinearLayoutManager linearLayoutManager) {
        super(context);
        this.gAX = linearLayoutManager;
        this.gAZ = Math.round(((float) context.getResources().getDisplayMetrics().heightPixels) * 0.75f);
    }

    protected final int bi(int i) {
        return super.bi(Math.max(this.gAZ, Math.min(this.gAY, i)));
    }

    public final PointF bf(int i) {
        return this.gAX.bf(i);
    }
}
