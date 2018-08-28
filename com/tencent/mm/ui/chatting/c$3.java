package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.model.app.ak;
import com.tencent.mm.pluginsdk.model.app.y;
import com.tencent.mm.y.g.a;

class c$3 implements OnClickListener {
    final /* synthetic */ a fZg;
    final /* synthetic */ c tGY;
    final /* synthetic */ String tHa;
    final /* synthetic */ int tHb;

    c$3(c cVar, a aVar, String str, int i) {
        this.tGY = cVar;
        this.fZg = aVar;
        this.tHa = str;
        this.tHb = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.a(this.tGY, new y(2, new ak(this.fZg.appId, "0")));
        com.tencent.mm.plugin.game.a.a aSm = com.tencent.mm.plugin.game.a.a.a.aSm();
        if (aSm != null) {
            c.a(this.tGY).tTq.getContext();
            aSm.a(this.tHa, this.fZg.appId, this.fZg.type, this.tHb, this.fZg.mediaTagName, 2);
        }
    }
}
