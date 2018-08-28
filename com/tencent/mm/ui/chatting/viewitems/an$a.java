package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.an.h;

abstract class an$a extends b {
    protected h ufe;

    an$a() {
    }

    protected final h k(a aVar) {
        if (this.ufe == null) {
            this.ufe = new h(aVar);
        }
        return this.ufe;
    }

    public String b(a aVar, bd bdVar) {
        return aVar.getTalkerUserName();
    }

    public boolean bba() {
        return false;
    }
}
