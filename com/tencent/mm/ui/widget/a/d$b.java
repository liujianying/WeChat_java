package com.tencent.mm.ui.widget.a;

import android.support.v7.widget.RecyclerView.a;
import android.widget.AdapterView.OnItemClickListener;

public class d$b extends a<a> {
    OnItemClickListener PY;
    final /* synthetic */ d uKm;

    public d$b(d dVar) {
        this.uKm = dVar;
    }

    public final int getItemCount() {
        if (d.v(this.uKm)) {
            return (d.a(this.uKm).size() + d.c(this.uKm).size()) + 1;
        }
        return d.a(this.uKm).size() + d.c(this.uKm).size();
    }
}
