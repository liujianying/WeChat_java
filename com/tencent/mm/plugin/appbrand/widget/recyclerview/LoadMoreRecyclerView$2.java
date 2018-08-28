package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;

class LoadMoreRecyclerView$2 extends c {
    final /* synthetic */ LinearLayoutManager gPY;
    final /* synthetic */ LoadMoreRecyclerView gPZ;

    LoadMoreRecyclerView$2(LoadMoreRecyclerView loadMoreRecyclerView, LinearLayoutManager linearLayoutManager) {
        this.gPZ = loadMoreRecyclerView;
        this.gPY = linearLayoutManager;
    }

    public final void ad(int i, int i2) {
        super.ad(i, i2);
        if (this.gPZ.gPW && this.gPY.fj() == this.gPZ.gQa.getItemCount() - 1 && LoadMoreRecyclerView.a(this.gPZ) != null) {
            a a = LoadMoreRecyclerView.a(this.gPZ);
            RecyclerView.a aVar = this.gPZ.gQa.QU;
            a.anH();
        }
    }
}
