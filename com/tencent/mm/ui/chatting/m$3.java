package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

class m$3 implements c {
    final /* synthetic */ List tIP;

    m$3(List list) {
        this.tIP = list;
    }

    public final void a(l lVar) {
        lVar.ak(1193046, R.l.menu_item_email, R.g.chat_more_email_btn);
        for (String add : this.tIP) {
            lVar.add(add);
        }
    }
}
