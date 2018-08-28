package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;

class i$2 implements OnClickListener {
    final /* synthetic */ i hFJ;

    i$2(i iVar) {
        this.hFJ = iVar;
    }

    public final void onClick(View view) {
        b.a(this.hFJ.gKS, false);
        am.axm().awU();
        this.hFJ.ayP();
        h.mEJ.h(11324, new Object[]{"CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), ""});
    }
}
