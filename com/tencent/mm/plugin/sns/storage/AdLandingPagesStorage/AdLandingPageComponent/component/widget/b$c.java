package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.a;

class b$c extends k {
    RecyclerView gxh;
    private LinearLayoutManager nCW;
    int nCX = Integer.MAX_VALUE;
    private int nCY = -1;
    private int nCZ = -1;
    private long nDa = 0;
    Runnable nDb = new 1(this);
    final /* synthetic */ b nGR;

    public b$c(b bVar, RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        this.nGR = bVar;
        this.gxh = recyclerView;
        this.nCW = linearLayoutManager;
    }

    private void bzP() {
        this.gxh.getHandler().removeCallbacks(this.nDb);
    }

    public final void e(RecyclerView recyclerView, int i) {
        super.e(recyclerView, i);
        if (i != this.nCX) {
            if (i != 1) {
                bzP();
            }
            switch (i) {
                case 0:
                    this.nGR.bAn();
                    if (this.nCX == 2) {
                        int fi = this.nCW.fi();
                        int fj = this.nCW.fj();
                        if (fj >= this.nCY) {
                            if (fi > this.nCZ) {
                                dx(this.nCZ, fi);
                                break;
                            }
                        }
                        dx(fj, this.nCY);
                        break;
                    }
                    break;
                case 1:
                    bzP();
                    this.gxh.postDelayed(this.nDb, 100);
                    break;
                case 2:
                    this.nCY = this.nCW.fi();
                    this.nCZ = this.nCW.fj();
                    this.nDa = System.currentTimeMillis();
                    break;
            }
        }
        this.nCX = i;
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
    }

    private void dx(int i, int i2) {
        b bVar = this.nGR;
        if (i <= i2) {
            bVar.dw(i, i2);
            while (i <= i2) {
                a aVar = (a) bVar.nCP.get(Integer.valueOf(i));
                if (aVar != null && aVar.nzR) {
                    bVar.nGP.wT(i);
                    aVar.bzO();
                }
                i++;
            }
        }
    }
}
