package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;

class k$7 implements OnClickListener {
    final /* synthetic */ int bpX;
    final /* synthetic */ int tiP;
    final /* synthetic */ k usq;

    k$7(k kVar, int i, int i2) {
        this.usq = kVar;
        this.bpX = i;
        this.tiP = i2;
    }

    public final void onClick(View view) {
        int i;
        bc.Ig().ba(this.bpX, this.tiP);
        Context context = (Context) this.usq.qJS.get();
        if ((q.GQ() & 65536) == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            d.A(context, "masssend", ".ui.MassSendHistoryUI");
        } else {
            d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
        }
        h.mEJ.h(11002, new Object[]{Integer.valueOf(11), Integer.valueOf(1)});
    }
}
