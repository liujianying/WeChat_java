package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.booter.z;
import com.tencent.mm.storage.ai;

class t$1 implements OnClickListener {
    final /* synthetic */ int eKj;
    final /* synthetic */ ai tQH;
    final /* synthetic */ t tQI;

    t$1(t tVar, ai aiVar, int i) {
        this.tQI = tVar;
        this.tQH = aiVar;
        this.eKj = i;
    }

    public final void onClick(View view) {
        t.a(this.tQI, 2);
        z zVar = z.cXH;
        if (zVar.cXL != null) {
            zVar.cXL.cYd = 2;
        }
        if (this.tQH == null || this.tQH.field_UnDeliverCount <= 0) {
            t.b(this.tQI, this.eKj);
        } else {
            ((com.tencent.mm.ui.chatting.b.b.z) this.tQI.bAG.O(com.tencent.mm.ui.chatting.b.b.z.class)).b(this.tQH, t.a(this.tQI), this.eKj);
        }
    }
}
