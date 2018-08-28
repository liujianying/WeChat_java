package com.tencent.mm.ui.base.sortview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class BaseSortView$4 implements OnItemSelectedListener {
    final /* synthetic */ BaseSortView tDO;

    BaseSortView$4(BaseSortView baseSortView) {
        this.tDO = baseSortView;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (BaseSortView.e(this.tDO) != null) {
            BaseSortView.e(this.tDO).onItemSelected(adapterView, view, i, j);
        }
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
        if (BaseSortView.e(this.tDO) != null) {
            BaseSortView.e(this.tDO).onNothingSelected(adapterView);
        }
    }
}
