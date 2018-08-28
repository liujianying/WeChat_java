package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.ah.b;

class av$1 extends b {
    av$1() {
    }

    public final boolean aq(int i, boolean z) {
        x.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        return z;
    }
}
