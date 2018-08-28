package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class MallProductSubmitUI$8 implements OnItemClickListener {
    final /* synthetic */ MallProductSubmitUI lTQ;

    MallProductSubmitUI$8(MallProductSubmitUI mallProductSubmitUI) {
        this.lTQ = mallProductSubmitUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.lTQ.dismissDialog(1);
        MallProductSubmitUI.b(this.lTQ).uw(i);
        MallProductSubmitUI.a(this.lTQ);
    }
}
