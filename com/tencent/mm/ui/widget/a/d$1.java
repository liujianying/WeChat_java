package com.tencent.mm.ui.widget.a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.base.m;

class d$1 implements OnItemClickListener {
    final /* synthetic */ d uKm;

    d$1(d dVar) {
        this.uKm = dVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar = (m) d.a(this.uKm).twb.get(i);
        if (mVar == null || !mVar.spC) {
            if (i < d.a(this.uKm).size()) {
                if (d.b(this.uKm) != null) {
                    d.b(this.uKm).onMMMenuItemSelected(d.a(this.uKm).getItem(i), i);
                }
            } else if (d.c(this.uKm).size() > 0 && i < d.a(this.uKm).size() + d.c(this.uKm).size() && d.d(this.uKm) != null) {
                d.d(this.uKm).onMMMenuItemSelected(d.c(this.uKm).getItem(i - d.a(this.uKm).size()), i);
            }
            if (!d.e(this.uKm)) {
                this.uKm.bzW();
            }
            d.f(this.uKm);
            d.a(this.uKm, i);
            d.g(this.uKm).RR.notifyChanged();
        }
    }
}
