package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.bay;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r;

class b$3 extends ag {
    final /* synthetic */ boolean hlD;
    final /* synthetic */ r hlE = null;
    final /* synthetic */ Context val$context;

    b$3(boolean z, Context context) {
        this.hlD = z;
        this.val$context = context;
    }

    public final void handleMessage(Message message) {
        if (this.hlD) {
            b.hm(true);
        }
        int GQ = q.GQ();
        if (this.hlD) {
            GQ &= -524289;
        } else {
            GQ |= 524288;
        }
        g.Ei().DT().set(34, Integer.valueOf(GQ));
        bay bay = new bay();
        bay.raB = 524288;
        if (this.hlD) {
            GQ = 0;
        } else {
            GQ = 1;
        }
        bay.sdm = GQ;
        ((i) g.l(i.class)).FQ().b(new a(39, bay));
        if (!this.hlD) {
            com.tencent.mm.plugin.readerapp.c.g.a(new 1(this, h.a(this.val$context, this.val$context.getString(com.tencent.mm.plugin.readerapp.a.g.readerapp_delete_news_ing), false, null)));
            b.hm(false);
        }
        if (this.hlE != null) {
            this.hlE.a(null, null);
        }
    }
}
