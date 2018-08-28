package com.tencent.mm.ui.chatting;

import com.tencent.mm.g.a.mb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class ChatFooterCustom$b extends c<mb> {
    final /* synthetic */ ChatFooterCustom tHY;

    private ChatFooterCustom$b(ChatFooterCustom chatFooterCustom) {
        this.tHY = chatFooterCustom;
        this.sFo = mb.class.getName().hashCode();
    }

    /* synthetic */ ChatFooterCustom$b(ChatFooterCustom chatFooterCustom, byte b) {
        this(chatFooterCustom);
        this.sFo = mb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mb mbVar = (mb) bVar;
        switch (mbVar.bWC.bWA) {
            case 0:
                this.tHY.k(1004, mbVar);
                break;
            case 1:
                this.tHY.k(1003, mbVar);
                break;
        }
        return false;
    }
}
