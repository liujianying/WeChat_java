package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.mm.aq.m;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.a.a.a;

class a$3 implements a {
    final /* synthetic */ a urL;

    a$3(a aVar) {
        this.urL = aVar;
    }

    public final void gi(String str, String str2) {
        com.tencent.mm.pluginsdk.h.a.a.ccM();
        au.HU();
        c.FQ().b(new m(2, str));
        x.d("MicroMsg.ADBanner", "jump to " + str2);
        p.a.qyl.a((Context) this.urL.qJS.get(), str2, true);
    }

    public final void QK(String str) {
        com.tencent.mm.pluginsdk.h.a.a.ccM();
        au.HU();
        c.FQ().b(new m(3, str));
    }
}
