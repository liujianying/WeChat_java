package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.widget.a.c.a.b;

class SelectConversationUI$4 implements b {
    final /* synthetic */ SelectConversationUI uEC;
    final /* synthetic */ bd.b uED;
    final /* synthetic */ String uEE;

    SelectConversationUI$4(SelectConversationUI selectConversationUI, bd.b bVar, String str) {
        this.uEC = selectConversationUI;
        this.uED = bVar;
        this.uEE = str;
    }

    public final void aMV() {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 1);
        intent.putExtra("kwebmap_slat", this.uED.kCw);
        intent.putExtra("kwebmap_lng", this.uED.kCx);
        intent.putExtra("Kwebmap_locaion", this.uEE);
        intent.putExtra("kShowshare", false);
        d.b(this.uEC.mController.tml, "location", ".ui.RedirectUI", intent);
    }
}
