package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;

class b$1 extends k {
    final /* synthetic */ b nHy;

    b$1(b bVar) {
        this.nHy = bVar;
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
        if (b.a(this.nHy).nHI != null && b.a(this.nHy).nHI.getVisibility() == 0) {
            b.a(this.nHy).nHI.scrollBy(i, i2);
        }
    }

    public final void e(RecyclerView recyclerView, int i) {
        super.e(recyclerView, i);
        b.a(this.nHy, i);
        if (i == 0) {
            if (b.b(this.nHy)) {
                this.nHy.bAw();
            }
        } else if (i == 1) {
            this.nHy.bAv();
            ad.ef(this.nHy.getContext());
        }
    }
}
