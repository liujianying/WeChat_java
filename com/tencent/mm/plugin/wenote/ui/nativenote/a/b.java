package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;

public abstract class b extends k {
    private int qve;

    public abstract void caW();

    public abstract void caX();

    public abstract void caY();

    public final void c(RecyclerView recyclerView, int i, int i2) {
        if ((Math.abs(i2) > this.qve ? 1 : 0) != 0 && recyclerView.canScrollVertically(-1)) {
            if (!recyclerView.canScrollVertically(1)) {
                caY();
            } else if (i2 < 0) {
                caW();
            } else if (i2 > 0) {
                caX();
            }
        }
    }
}
