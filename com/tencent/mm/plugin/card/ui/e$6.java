package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class e$6 implements a {
    final /* synthetic */ String dhF;
    final /* synthetic */ e hCy;
    final /* synthetic */ int ms;

    e$6(e eVar, int i, String str) {
        this.hCy = eVar;
        this.ms = i;
        this.dhF = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            this.hCy.hCq = str;
            e eVar;
            if (this.ms == 0) {
                if (this.hCy.hCu != null) {
                    this.hCy.hCu.xH(this.dhF);
                }
                h.mEJ.h(11582, new Object[]{"OperGift", Integer.valueOf(1), Integer.valueOf(this.hCy.htQ.awm().huV), this.hCy.htQ.awr(), this.hCy.htQ.awq(), this.hCy.hCp});
                com.tencent.mm.ui.base.h.bA(this.hCy.hBT, this.hCy.hBT.getResources().getString(g.card_has_gift_tips));
            } else if (this.ms == 1) {
                eVar = this.hCy;
                eVar.htQ.awo().sli = eVar.getString(g.card_share_to) + eVar.hCo.getTitle();
                l.a(eVar.htQ, eVar.hCp, eVar.hCv.hBF, 2);
                l.ck(eVar.hCq, eVar.hCp);
                com.tencent.mm.ui.base.h.bA(this.hCy.hBT, this.hCy.hBT.getResources().getString(g.card_has_gift_tips));
            } else if (this.ms == 4) {
                eVar = this.hCy;
                if (TextUtils.isEmpty(eVar.htQ.aws())) {
                    eVar.htQ.xa(q.GF());
                }
                eVar.htQ.awo().sli = eVar.getString(g.card_recommend_to) + eVar.hCo.getTitle();
                l.a(eVar.htQ, eVar.hCp, eVar.hCv.hBF, 23);
                l.ck(eVar.hCq, eVar.hCp);
                h.mEJ.h(11582, new Object[]{"OpeRecommendCard", Integer.valueOf(this.hCy.hCv.hop), Integer.valueOf(this.hCy.htQ.awm().huV), this.hCy.htQ.awr(), this.hCy.htQ.awq(), this.hCy.hCp});
                com.tencent.mm.ui.base.h.bA(this.hCy.hBT, this.hCy.hBT.getResources().getString(g.card_has_gift_tips));
            }
        }
    }
}
