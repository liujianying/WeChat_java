package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.bi;

class k$8 implements OnClickListener {
    final /* synthetic */ int bpX;
    final /* synthetic */ int tiP;
    final /* synthetic */ k usq;

    k$8(k kVar, int i, int i2) {
        this.usq = kVar;
        this.bpX = i;
        this.tiP = i2;
    }

    public final void onClick(View view) {
        boolean z;
        bc.Ig().ba(this.bpX, this.tiP);
        Context context = (Context) this.usq.qJS.get();
        au.HU();
        String str = (String) c.DT().get(68377, null);
        au.HU();
        c.DT().set(68377, "");
        Intent intent = new Intent();
        intent.putExtra("sns_timeline_NeedFirstLoadint", true);
        if (bi.oW(str)) {
            z = true;
        } else {
            z = false;
        }
        if (n.nkz != null && n.nkz.axd() > 0) {
            z = false;
        }
        intent.putExtra("sns_resume_state", z);
        d.b(context, "sns", ".ui.SnsTimeLineUI", intent);
        h.mEJ.h(11002, new Object[]{Integer.valueOf(8), Integer.valueOf(1)});
    }
}
