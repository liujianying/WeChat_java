package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.ui.widget.a.c.a.b;

class d$2 implements b {
    final /* synthetic */ g iVw;
    final /* synthetic */ Context val$context;

    d$2(g gVar, Context context) {
        this.iVw = gVar;
        this.val$context = context;
    }

    public final void aMV() {
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", this.iVw.field_favProto.desc);
        d.e(this.val$context, ".ui.transmit.RetransmitPreviewUI", intent);
        com.tencent.mm.ui.base.b.gE(this.val$context);
    }
}
