package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class CardNewMsgUI$3 implements OnItemLongClickListener {
    final /* synthetic */ CardNewMsgUI hFN;

    CardNewMsgUI$3(CardNewMsgUI cardNewMsgUI) {
        this.hFN = cardNewMsgUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        CardNewMsgUI.b(this.hFN, i);
        return true;
    }
}
