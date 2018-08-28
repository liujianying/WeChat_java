package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.k;

class NearbySayHiListUI$10 implements OnItemLongClickListener {
    final /* synthetic */ k hle;
    final /* synthetic */ NearbySayHiListUI lCB;

    NearbySayHiListUI$10(NearbySayHiListUI nearbySayHiListUI, k kVar) {
        this.lCB = nearbySayHiListUI;
        this.hle = kVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < NearbySayHiListUI.d(this.lCB).getHeaderViewsCount()) {
            x.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
        } else {
            this.hle.a(view, i, j, this.lCB, NearbySayHiListUI.g(this.lCB));
        }
        return true;
    }
}
