package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qn;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class SnsSingleTextViewUI$2 extends c<qn> {
    final /* synthetic */ SnsSingleTextViewUI obr;

    SnsSingleTextViewUI$2(SnsSingleTextViewUI snsSingleTextViewUI) {
        this.obr = snsSingleTextViewUI;
        super(0);
        this.sFo = qn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qn qnVar = (qn) bVar;
        if ((qnVar instanceof qn) && SnsSingleTextViewUI.a(this.obr) != null && SnsSingleTextViewUI.a(this.obr).bAK().equals(qnVar.cbc.id)) {
            ap.cb(SnsSingleTextViewUI.a(this.obr).bAK(), 8);
            String str = qnVar.cbc.result;
            String str2 = qnVar.cbc.cbd;
            if (bi.oW(str)) {
                SnsSingleTextViewUI.b(this.obr).setVisibility(8);
                ap.cc(SnsSingleTextViewUI.a(this.obr).bAK(), 8);
            } else {
                SnsSingleTextViewUI.b(this.obr).setVisibility(0);
                SnsSingleTextViewUI.b(this.obr).a(null, 1, str, str2, true);
                SnsSingleTextViewUI.a(this.obr, true);
            }
        }
        return false;
    }
}
