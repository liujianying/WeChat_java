package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class b {
    private RecyclerView gxh;
    public Map<Integer, a> nCP = new HashMap();
    private LinearLayoutManager nCQ;
    public b nGP;
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b nGQ;

    public b(RecyclerView recyclerView, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar) {
        this.gxh = recyclerView;
        this.nGQ = bVar;
        if (recyclerView.getLayoutManager() == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            throw new IllegalArgumentException("set LinearLayoutManger to RecyclerView first");
        } else if (recyclerView.getAdapter() == null || !(recyclerView.getAdapter() instanceof b)) {
            throw new IllegalArgumentException("set Adapter which implemented ExposureListener to RecyclerView first");
        } else {
            this.nGP = (b) recyclerView.getAdapter();
            this.nCQ = (LinearLayoutManager) recyclerView.getLayoutManager();
            this.gxh.a(new c(this, recyclerView, (LinearLayoutManager) recyclerView.getLayoutManager()));
        }
    }

    public final void bAn() {
        bzN();
        int fi = this.nCQ.fi();
        int fj = this.nCQ.fj();
        for (Entry entry : this.nCP.entrySet()) {
            if (((Integer) entry.getKey()).intValue() < fi || ((Integer) entry.getKey()).intValue() > fj) {
                if (((a) entry.getValue()).nzR) {
                    this.nGP.wT(((Integer) entry.getKey()).intValue());
                    ((a) entry.getValue()).bzO();
                }
            } else if (((a) entry.getValue()).nzR && !this.nGP.wU(((Integer) entry.getKey()).intValue())) {
                this.nGP.wT(((Integer) entry.getKey()).intValue());
                ((a) entry.getValue()).bzO();
            }
        }
    }

    public final void bzN() {
        if (this.nCQ != null) {
            int fi = this.nCQ.fi();
            int fj = this.nCQ.fj();
            if (fi != fj || fi != -1) {
                dw(fi, fj);
            }
        }
    }

    final void dw(int i, int i2) {
        while (i <= i2) {
            a aVar = (a) this.nCP.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a(this, (byte) 0);
                this.nCP.put(Integer.valueOf(i), aVar);
            }
            if (!aVar.nzR && this.nGP.wU(i)) {
                this.nGP.a(i, this);
                if (!aVar.nzR) {
                    aVar.nzR = true;
                }
            }
            i++;
        }
    }

    public final void bAo() {
        if (this.nCQ != null) {
            int fi = this.nCQ.fi();
            int fj = this.nCQ.fj();
            if (fi != fj || fi != -1) {
                for (int i = fi; i <= fj; i++) {
                    a aVar = (a) this.nCP.get(Integer.valueOf(i));
                    if (aVar != null && aVar.nzR) {
                        this.nGP.wT(i);
                        aVar.bzO();
                    }
                }
            }
        }
    }
}
