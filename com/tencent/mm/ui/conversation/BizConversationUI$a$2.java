package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$2 implements OnItemLongClickListener {
    final /* synthetic */ a unz;

    BizConversationUI$a$2(a aVar) {
        this.unz = aVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        a.a(this.unz, (ai) a.e(this.unz).getItem(i));
        a.a(this.unz, a.f(this.unz).field_username);
        a.j(this.unz).a(view, i, j, this.unz, a.g(this.unz), a.h(this.unz), a.i(this.unz));
        return true;
    }
}
