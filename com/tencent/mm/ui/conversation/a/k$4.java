package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.bc;

class k$4 implements OnClickListener {
    final /* synthetic */ int bpX;
    final /* synthetic */ int tiP;
    final /* synthetic */ k usq;

    k$4(k kVar, int i, int i2) {
        this.usq = kVar;
        this.bpX = i;
        this.tiP = i2;
    }

    public final void onClick(View view) {
        bc.Ig().ba(this.bpX, this.tiP);
        k.v((Context) this.usq.qJS.get(), true);
    }
}
