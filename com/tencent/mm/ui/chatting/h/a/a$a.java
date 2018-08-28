package com.tencent.mm.ui.chatting.h.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.widget.MMTextView.a;

enum a$a implements a {
    ;

    private a$a(String str) {
    }

    public final void a(CharSequence charSequence, long j) {
        bd dW = ((i) g.l(i.class)).bcY().dW(j);
        if (bi.oW(dW.field_talker)) {
            x.w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", new Object[]{Long.valueOf(j)});
        } else if ((dW.field_flag & 16) == 0) {
            a.b(charSequence, dW);
        } else {
            x.v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", new Object[]{Long.valueOf(j)});
        }
    }
}
