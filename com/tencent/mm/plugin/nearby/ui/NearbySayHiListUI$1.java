package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.a;
import com.tencent.mm.sdk.platformtools.x;

class NearbySayHiListUI$1 implements OnClickListener {
    final /* synthetic */ View lCA;
    final /* synthetic */ NearbySayHiListUI lCB;

    NearbySayHiListUI$1(NearbySayHiListUI nearbySayHiListUI, View view) {
        this.lCB = nearbySayHiListUI;
        this.lCA = view;
    }

    public final void onClick(View view) {
        NearbySayHiListUI.a(this.lCB, NearbySayHiListUI.a(this.lCB) + 8);
        x.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.a(this.lCB));
        a b = NearbySayHiListUI.b(this.lCB);
        int a = NearbySayHiListUI.a(this.lCB);
        b.aYc();
        b.limit = a;
        b.WT();
        if (NearbySayHiListUI.c(this.lCB) <= NearbySayHiListUI.a(this.lCB)) {
            NearbySayHiListUI.d(this.lCB).removeFooterView(this.lCA);
            x.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.a(this.lCB));
        }
    }
}
