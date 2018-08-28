package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qo;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsSingleTextViewUI$1 extends c<qo> {
    final /* synthetic */ SnsSingleTextViewUI obr;

    SnsSingleTextViewUI$1(SnsSingleTextViewUI snsSingleTextViewUI) {
        this.obr = snsSingleTextViewUI;
        this.sFo = qo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qo qoVar = (qo) bVar;
        if ((qoVar instanceof qo) && SnsSingleTextViewUI.a(this.obr) != null && SnsSingleTextViewUI.a(this.obr).bAK().equals(qoVar.cbe.id)) {
            ap.cb(SnsSingleTextViewUI.a(this.obr).bAK(), 8);
            SnsSingleTextViewUI.b(this.obr).setVisibility(0);
            SnsSingleTextViewUI.b(this.obr).xD(2);
            SnsSingleTextViewUI.a(this.obr, false);
        }
        return false;
    }
}
