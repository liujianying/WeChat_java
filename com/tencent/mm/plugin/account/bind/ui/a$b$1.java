package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.bind.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;

class a$b$1 implements OnClickListener {
    final /* synthetic */ a eHZ;
    final /* synthetic */ b eIa;

    a$b$1(b bVar, a aVar) {
        this.eIa = bVar;
        this.eHZ = aVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
        if (a.a(this.eIa.eHY) != null) {
            a.a(this.eIa.eHY).iZ(this.eIa.position);
        }
    }
}
