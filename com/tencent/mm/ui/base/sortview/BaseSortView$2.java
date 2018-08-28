package com.tencent.mm.ui.base.sortview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class BaseSortView$2 implements OnItemClickListener {
    final /* synthetic */ BaseSortView tDO;

    BaseSortView$2(BaseSortView baseSortView) {
        this.tDO = baseSortView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (BaseSortView.c(this.tDO) != null) {
            BaseSortView.c(this.tDO).onItemClick(adapterView, view, i, j);
        }
    }
}
