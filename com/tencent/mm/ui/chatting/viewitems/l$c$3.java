package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import com.tencent.mm.bg.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.viewitems.l.c;

class l$c$3 implements a {
    final /* synthetic */ com.tencent.mm.ui.chatting.c.a tZG;
    final /* synthetic */ c ubx;

    l$c$3(c cVar, com.tencent.mm.ui.chatting.c.a aVar) {
        this.ubx = cVar;
        this.tZG = aVar;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i == 221 && intent != null) {
            String stringExtra = intent.getStringExtra("result_msg");
            if (!bi.oW(stringExtra)) {
                h.b(this.tZG.tTq.getContext(), stringExtra, "", false);
            }
        }
    }
}
