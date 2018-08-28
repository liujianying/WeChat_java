package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.c;

class MRecyclerView$1 extends c {
    final /* synthetic */ MRecyclerView gQe;

    MRecyclerView$1(MRecyclerView mRecyclerView) {
        this.gQe = mRecyclerView;
    }

    public final void onChanged() {
        if (MRecyclerView.a(this.gQe) != null) {
            MRecyclerView.a(this.gQe).setVisibility(this.gQe.aqD() ? 0 : 8);
        }
    }
}
