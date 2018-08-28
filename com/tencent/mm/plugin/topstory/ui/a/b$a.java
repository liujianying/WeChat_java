package com.tencent.mm.plugin.topstory.ui.a;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.z;

class b$a extends z {
    final /* synthetic */ b oCH;

    public b$a(b bVar, Context context) {
        this.oCH = bVar;
        super(context);
    }

    public final PointF bf(int i) {
        return this.oCH.bf(i);
    }

    protected final int fn() {
        return -1;
    }

    protected final int bi(int i) {
        return Math.min(1500, super.bi(i));
    }
}
