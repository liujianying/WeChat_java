package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;

class k$6 implements OnClickListener {
    final /* synthetic */ k ujC;

    k$6(k kVar) {
        this.ujC = kVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
        au.HU();
        c.DT().set(143618, Integer.valueOf(0));
        d.b(k.d(this.ujC), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
    }
}
