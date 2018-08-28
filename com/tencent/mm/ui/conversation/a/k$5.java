package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.report.service.h;

class k$5 implements OnClickListener {
    final /* synthetic */ int bpX;
    final /* synthetic */ int tiP;
    final /* synthetic */ k usq;

    k$5(k kVar, int i, int i2) {
        this.usq = kVar;
        this.bpX = i;
        this.tiP = i2;
    }

    public final void onClick(View view) {
        bc.Ig().ba(this.bpX, this.tiP);
        Context context = (Context) this.usq.qJS.get();
        Intent intent = new Intent();
        intent.putExtra("preceding_scence", 17);
        d.b(context, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
        h.mEJ.h(11002, new Object[]{Integer.valueOf(10), Integer.valueOf(1)});
        h.mEJ.h(12065, new Object[]{Integer.valueOf(2)});
    }
}
