package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ui.widget.b.a;

class BizChatConversationUI$a$17 implements OnItemLongClickListener {
    final /* synthetic */ a mbW;
    final /* synthetic */ BizChatConversationUI.a tEC;

    BizChatConversationUI$a$17(BizChatConversationUI.a aVar, a aVar2) {
        this.tEC = aVar;
        this.mbW = aVar2;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mbW.a(view, i, j, this.tEC, BizChatConversationUI.a.f(this.tEC), BizChatConversationUI.a.g(this.tEC), BizChatConversationUI.a.h(this.tEC));
        return true;
    }
}
