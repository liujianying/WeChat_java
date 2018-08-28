package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.k;

class ShakeItemListUI$4 implements OnItemLongClickListener {
    final /* synthetic */ k hle;
    final /* synthetic */ ShakeItemListUI mZA;

    ShakeItemListUI$4(ShakeItemListUI shakeItemListUI, k kVar) {
        this.mZA = shakeItemListUI;
        this.hle = kVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < ShakeItemListUI.c(this.mZA).getHeaderViewsCount()) {
            x.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
        } else {
            this.hle.a(view, i, j, this.mZA, ShakeItemListUI.e(this.mZA));
        }
        return true;
    }
}
