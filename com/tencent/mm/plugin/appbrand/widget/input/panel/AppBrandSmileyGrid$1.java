package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AppBrandSmileyGrid$1 implements OnItemClickListener {
    final /* synthetic */ AppBrandSmileyGrid gKQ;

    AppBrandSmileyGrid$1(AppBrandSmileyGrid appBrandSmileyGrid) {
        this.gKQ = appBrandSmileyGrid;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == AppBrandSmileyGrid.a(this.gKQ).getCount() - 1) {
            if (AppBrandSmileyGrid.b(this.gKQ).gKY != null) {
                AppBrandSmileyGrid.b(this.gKQ).gKY.apK();
            }
        } else if ((AppBrandSmileyGrid.c(this.gKQ) * (AppBrandSmileyGrid.d(this.gKQ) - 1)) + i < AppBrandSmileyGrid.e(this.gKQ)) {
            int c = (AppBrandSmileyGrid.c(this.gKQ) * (AppBrandSmileyGrid.d(this.gKQ) - 1)) + i;
            if (AppBrandSmileyGrid.b(this.gKQ).gKY != null) {
                AppBrandSmileyGrid.b(this.gKQ).gKY.append(AppBrandSmileyGrid.b(this.gKQ).apU().mi(c));
            }
        }
    }
}
