package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.x;

class av$2 extends ah$a {
    av$2() {
    }

    public final boolean aq(int i, boolean z) {
        x.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        if (z) {
            return false;
        }
        return true;
    }
}
