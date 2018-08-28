package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI;

class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$10 implements OnItemLongClickListener {
    final /* synthetic */ AppBrandServiceConversationFmUI umW;

    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$10(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI) {
        this.umW = appBrandServiceConversationFmUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppBrandServiceConversationFmUI.access$402(this.umW, (ai) AppBrandServiceConversationFmUI.access$100(this.umW).getItem(i));
        AppBrandServiceConversationFmUI.access$502(this.umW, AppBrandServiceConversationFmUI.access$400(this.umW).field_username);
        AppBrandServiceConversationFmUI.access$700(this.umW).a(view, i, j, this.umW, this.umW);
        return true;
    }
}
