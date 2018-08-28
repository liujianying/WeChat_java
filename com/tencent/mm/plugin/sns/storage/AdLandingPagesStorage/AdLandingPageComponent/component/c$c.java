package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c.a;
import com.tencent.mm.sdk.platformtools.x;

class c$c extends k {
    RecyclerView gxh;
    final /* synthetic */ c nCT;
    private LinearLayoutManager nCW;
    int nCX = Integer.MAX_VALUE;
    private int nCY = -1;
    private int nCZ = -1;
    private long nDa = 0;
    Runnable nDb = new 1(this);

    public c$c(c cVar, RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        this.nCT = cVar;
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
                    c.a(this.nCT);
                    if (this.nCX == 2) {
                        int fi = this.nCW.fi();
                        int fj = this.nCW.fj();
                        if (fj >= this.nCY) {
                            if (fi > this.nCZ) {
                                h(this.nCZ, fi, System.currentTimeMillis() - this.nDa);
                                break;
                            }
                        }
                        h(fj, this.nCY, System.currentTimeMillis() - this.nDa);
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
        x.d("AdLandingCarouselComp", "state " + i);
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
    }

    private void h(int i, int i2, long j) {
        int i3 = 1;
        x.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)});
        c cVar = this.nCT;
        if (i > i2) {
            x.e("AdLandingCarouselComp", "wtf start > end");
            return;
        }
        cVar.dw(i, i2);
        if (i2 != i) {
            i3 = (i2 - i) + 1;
        }
        long j2 = j / ((long) i3);
        while (i <= i2) {
            a aVar = (a) cVar.nCP.get(Integer.valueOf(i));
            if (aVar != null && aVar.isVisible) {
                aVar.isVisible = false;
                aVar.nCS = 0;
                aVar.time += j2;
            }
            i++;
        }
    }
}
