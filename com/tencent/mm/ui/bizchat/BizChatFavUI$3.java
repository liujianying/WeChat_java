package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ac.a.c;

class BizChatFavUI$3 implements OnItemClickListener {
    final /* synthetic */ BizChatFavUI tEG;

    BizChatFavUI$3(BizChatFavUI bizChatFavUI) {
        this.tEG = bizChatFavUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BizChatFavUI.b(this.tEG, ((c) BizChatFavUI.c(this.tEG).getItem(i)).field_bizChatLocalId);
    }
}
