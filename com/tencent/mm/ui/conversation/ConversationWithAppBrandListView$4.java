package com.tencent.mm.ui.conversation;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;

class ConversationWithAppBrandListView$4 extends k {
    LinearLayoutManager nCW = ((LinearLayoutManager) ConversationWithAppBrandListView.c(this.upB).getLayoutManager());
    final /* synthetic */ ConversationWithAppBrandListView upB;
    int upD = 0;

    ConversationWithAppBrandListView$4(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.upB = conversationWithAppBrandListView;
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
        LinearLayoutManager linearLayoutManager = this.nCW;
        View b = linearLayoutManager.b(0, linearLayoutManager.getChildCount(), true, false);
        int bd = b == null ? -1 : LinearLayoutManager.bd(b);
        if (!(ConversationWithAppBrandListView.e(this.upB) == null || bd / 4 == this.upD || recyclerView.getChildCount() <= 4)) {
            b e = ConversationWithAppBrandListView.e(this.upB);
            e.gPa++;
        }
        this.upD = bd / 4;
    }
}
