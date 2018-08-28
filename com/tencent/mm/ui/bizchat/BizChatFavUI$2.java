package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.k;

class BizChatFavUI$2 implements OnItemLongClickListener {
    final /* synthetic */ k hle;
    final /* synthetic */ BizChatFavUI tEG;

    BizChatFavUI$2(BizChatFavUI bizChatFavUI, k kVar) {
        this.tEG = bizChatFavUI;
        this.hle = kVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < BizChatFavUI.e(this.tEG).getHeaderViewsCount()) {
            x.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
        } else {
            this.hle.a(view, i, j, this.tEG, BizChatFavUI.g(this.tEG));
        }
        return true;
    }
}
