package com.tencent.mm.ui.chatting;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

class am$3 implements c {
    final /* synthetic */ List tMT;

    am$3(List list) {
        this.tMT = list;
    }

    public final void a(l lVar) {
        for (String add : this.tMT) {
            lVar.add(add);
        }
    }
}
