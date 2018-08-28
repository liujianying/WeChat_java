package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$18 implements OnItemClickListener {
    final /* synthetic */ a tEC;

    BizChatConversationUI$a$18(a aVar) {
        this.tEC = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a.b(this.tEC, ((com.tencent.mm.ac.a.a) a.b(this.tEC).getItem(i)).field_bizChatId);
    }
}
