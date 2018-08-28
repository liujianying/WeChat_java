package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsSingleTextViewUI$3 extends c<qp> {
    final /* synthetic */ SnsSingleTextViewUI obr;

    SnsSingleTextViewUI$3(SnsSingleTextViewUI snsSingleTextViewUI) {
        this.obr = snsSingleTextViewUI;
        this.sFo = qp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qp qpVar = (qp) bVar;
        if ((qpVar instanceof qp) && SnsSingleTextViewUI.a(this.obr).bAK().equals(qpVar.cbf.id)) {
            ap.cc(qpVar.cbf.id, 8);
            SnsSingleTextViewUI.b(this.obr).setVisibility(8);
            SnsSingleTextViewUI.a(this.obr, false);
        }
        return false;
    }
}
