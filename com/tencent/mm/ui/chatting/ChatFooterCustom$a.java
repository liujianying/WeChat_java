package com.tencent.mm.ui.chatting;

import com.tencent.mm.g.a.ma;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class ChatFooterCustom$a extends c<ma> {
    final /* synthetic */ ChatFooterCustom tHY;

    private ChatFooterCustom$a(ChatFooterCustom chatFooterCustom) {
        this.tHY = chatFooterCustom;
        this.sFo = ma.class.getName().hashCode();
    }

    /* synthetic */ ChatFooterCustom$a(ChatFooterCustom chatFooterCustom, byte b) {
        this(chatFooterCustom);
        this.sFo = ma.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ma maVar = (ma) bVar;
        switch (maVar.bWy.bWA) {
            case 0:
                this.tHY.k(1005, maVar);
                break;
            case 1:
                this.tHY.k(1006, maVar);
                break;
        }
        return false;
    }
}
