package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ConversationWithAppBrandListView$16 implements OnItemClickListener {
    final /* synthetic */ ConversationWithAppBrandListView upB;
    final /* synthetic */ OnItemClickListener upH;

    ConversationWithAppBrandListView$16(ConversationWithAppBrandListView conversationWithAppBrandListView, OnItemClickListener onItemClickListener) {
        this.upB = conversationWithAppBrandListView;
        this.upH = onItemClickListener;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.upH != null) {
            this.upH.onItemClick(adapterView, view, i, j);
        }
        if (ConversationWithAppBrandListView.b(this.upB) && this.upB.getFirstVisiblePosition() == 0) {
            this.upB.B(500, 8);
        }
    }
}
