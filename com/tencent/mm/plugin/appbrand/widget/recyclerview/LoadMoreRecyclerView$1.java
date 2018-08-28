package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;

class LoadMoreRecyclerView$1 extends k {
    int gPX = 0;
    final /* synthetic */ LinearLayoutManager gPY;
    final /* synthetic */ LoadMoreRecyclerView gPZ;

    LoadMoreRecyclerView$1(LoadMoreRecyclerView loadMoreRecyclerView, LinearLayoutManager linearLayoutManager) {
        this.gPZ = loadMoreRecyclerView;
        this.gPY = linearLayoutManager;
    }

    public final void e(RecyclerView recyclerView, int i) {
        super.e(recyclerView, i);
        if (i == 0 && this.gPZ.gPW && this.gPX == this.gPZ.gQa.getItemCount() - 1 && LoadMoreRecyclerView.a(this.gPZ) != null) {
            a a = LoadMoreRecyclerView.a(this.gPZ);
            RecyclerView.a aVar = this.gPZ.gQa.QU;
            a.anH();
        }
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
        this.gPX = this.gPY.fj();
    }
}
