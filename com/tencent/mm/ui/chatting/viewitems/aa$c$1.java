package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import com.tencent.mm.bg.d.a;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.aa.c;

class aa$c$1 implements a {
    final /* synthetic */ c udq;

    aa$c$1(c cVar) {
        this.udq = cVar;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 2002:
                if (intent == null) {
                    x.e("MicroMsg.LocationClickListener", "[onActivityResult] null == data, requestCode:%s resultCode:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                } else if (intent.getBooleanExtra("kfavorite", false)) {
                    ch chVar = new ch();
                    e.a(chVar, intent);
                    chVar.bJF.nd = c.a(this.udq).tTq;
                    chVar.bJF.bJM = 42;
                    com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
