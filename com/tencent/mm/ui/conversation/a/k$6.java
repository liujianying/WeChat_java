package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.report.service.h;

class k$6 implements OnClickListener {
    final /* synthetic */ int bpX;
    final /* synthetic */ int tiP;
    final /* synthetic */ k usq;

    k$6(k kVar, int i, int i2) {
        this.usq = kVar;
        this.bpX = i;
        this.tiP = i2;
    }

    public final void onClick(View view) {
        bc.Ig().ba(this.bpX, this.tiP);
        d.A((Context) this.usq.qJS.get(), "game", ".ui.GameCenterUI");
        h.mEJ.h(11002, new Object[]{Integer.valueOf(9), Integer.valueOf(1)});
    }
}
