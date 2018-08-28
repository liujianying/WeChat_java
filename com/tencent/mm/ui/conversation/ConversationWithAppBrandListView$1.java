package com.tencent.mm.ui.conversation;

import android.database.DataSetObserver;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.x;

class ConversationWithAppBrandListView$1 extends DataSetObserver {
    final /* synthetic */ ListAdapter upA;
    final /* synthetic */ ConversationWithAppBrandListView upB;
    int upz = -1;

    ConversationWithAppBrandListView$1(ConversationWithAppBrandListView conversationWithAppBrandListView, ListAdapter listAdapter) {
        this.upB = conversationWithAppBrandListView;
        this.upA = listAdapter;
    }

    public final void onChanged() {
        if (this.upz != this.upA.getCount()) {
            String str = "MicroMsg.ConversationWithAppBrandListView";
            String str2 = "[onChanged] isDelete:%s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.upz > this.upA.getCount());
            x.i(str, str2, objArr);
            if (this.upz > this.upA.getCount()) {
                ConversationWithAppBrandListView.a(this.upB, false);
                ConversationWithAppBrandListView.a(this.upB, true);
            } else {
                ConversationWithAppBrandListView.a(this.upB);
            }
        }
        this.upz = this.upA.getCount();
    }
}
