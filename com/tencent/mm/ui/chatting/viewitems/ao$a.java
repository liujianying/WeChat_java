package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;

abstract class ao$a extends b {
    ao$a() {
    }

    protected final boolean b(a aVar) {
        return false;
    }

    public String b(a aVar, bd bdVar) {
        return aVar.getTalkerUserName();
    }

    public boolean bba() {
        return false;
    }
}
