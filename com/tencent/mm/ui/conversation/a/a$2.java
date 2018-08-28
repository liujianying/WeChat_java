package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;

class a$2 implements OnClickListener {
    final /* synthetic */ a urL;

    a$2(a aVar) {
        this.urL = aVar;
    }

    public final void onClick(View view) {
        if (this.urL.urI != null && this.urL.urK != null) {
            c FV = this.urL.urI.FV(this.urL.abQ);
            this.urL.urK.gi(FV.urN.id, FV.urN.url);
        }
    }
}
