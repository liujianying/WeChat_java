package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.k;

class BottleConversationUI$7 implements OnItemLongClickListener {
    final /* synthetic */ BottleConversationUI hlc;
    final /* synthetic */ k hle;

    BottleConversationUI$7(BottleConversationUI bottleConversationUI, k kVar) {
        this.hlc = bottleConversationUI;
        this.hle = kVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < BottleConversationUI.c(this.hlc).getHeaderViewsCount()) {
            x.w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
        } else {
            this.hle.a(view, i, j, this.hlc, BottleConversationUI.d(this.hlc));
        }
        return true;
    }
}
