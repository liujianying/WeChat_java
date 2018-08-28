package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class ConversationWithAppBrandListView$17 implements OnItemLongClickListener {
    final /* synthetic */ ConversationWithAppBrandListView upB;
    final /* synthetic */ OnItemLongClickListener upI;

    ConversationWithAppBrandListView$17(ConversationWithAppBrandListView conversationWithAppBrandListView, OnItemLongClickListener onItemLongClickListener) {
        this.upB = conversationWithAppBrandListView;
        this.upI = onItemLongClickListener;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if ((i == 0 && ConversationWithAppBrandListView.b(this.upB)) || this.upI == null) {
            return false;
        }
        return this.upI.onItemLongClick(adapterView, view, i, j);
    }
}
