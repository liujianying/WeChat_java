package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;

class EnterpriseConversationUI$a$5 implements OnItemLongClickListener {
    final /* synthetic */ a uqA;

    EnterpriseConversationUI$a$5(a aVar) {
        this.uqA = aVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        a.c(this.uqA, ((ai) a.f(this.uqA).getItem(i)).field_username);
        a.i(this.uqA).a(view, i, j, this.uqA, a.h(this.uqA));
        return true;
    }
}
