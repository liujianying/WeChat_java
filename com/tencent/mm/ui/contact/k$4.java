package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.x;

class k$4 implements OnClickListener {
    final /* synthetic */ k ujC;

    k$4(k kVar) {
        this.ujC = kVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
        d.b(k.d(this.ujC), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
    }
}
