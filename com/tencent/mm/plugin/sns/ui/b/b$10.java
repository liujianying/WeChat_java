package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.ui.ag;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;

class b$10 implements OnClickListener {
    final /* synthetic */ b olf;

    b$10(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        String str = (String) view.getTag();
        x.d("MicroMsg.TimelineClickListener", "onItemDelClick:" + str);
        bsu bAJ = af.byo().Nl(str).bAJ();
        av avVar = bAJ.nsB;
        if (avVar.raS != null) {
            String cS = a.ezo.cS(avVar.raS.jQb);
            int i = 0;
            if (bAJ.sqc.ruz == 1) {
                i = 2;
            } else if (bAJ.sqc.ruz == 3) {
                i = 5;
            } else if (bAJ.sqc.ruz == 15) {
                i = 38;
            }
            if (e.a(bAJ, this.olf.activity)) {
                a.ezo.a(this.olf.activity, avVar.raS.jQb, cS, bAJ.hbL, i, 11, 9, avVar.raS.raM, bAJ.ksA);
                return;
            }
            gk gkVar;
            switch (avVar.hcE) {
                case 4:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", avVar.jPK);
                    a.ezn.j(intent, this.olf.activity);
                    a.ezo.a(this.olf.activity, avVar.raS.jQb, cS, bAJ.hbL, i, 11, 1, avVar.raS.raM, bAJ.ksA);
                    return;
                case 5:
                    if (avVar.otY == 1) {
                        gkVar = new gk();
                        gkVar.bPB.actionCode = 2;
                        gkVar.bPB.scene = 3;
                        gkVar.bPB.appId = avVar.raS.jQb;
                        gkVar.bPB.context = this.olf.activity;
                        com.tencent.mm.sdk.b.a.sFg.m(gkVar);
                        a.ezo.a(this.olf.activity, avVar.raS.jQb, cS, bAJ.hbL, i, 11, 6, avVar.raS.raM, bAJ.ksA);
                        return;
                    }
                    return;
                case 6:
                    int a = ag.a(this.olf.activity, avVar);
                    if (a == 1) {
                        gkVar = new gk();
                        gkVar.bPB.context = this.olf.activity;
                        gkVar.bPB.actionCode = 2;
                        gkVar.bPB.appId = avVar.raS.jQb;
                        gkVar.bPB.messageAction = avVar.raS.raO;
                        gkVar.bPB.messageExt = avVar.raS.raN;
                        gkVar.bPB.scene = 3;
                        com.tencent.mm.sdk.b.a.sFg.m(gkVar);
                        a.ezo.a(this.olf.activity, avVar.raS.jQb, cS, bAJ.hbL, i, 11, 6, avVar.raS.raM, bAJ.ksA);
                        return;
                    } else if (a == 2) {
                        gkVar = new gk();
                        gkVar.bPB.context = this.olf.activity;
                        gkVar.bPB.actionCode = 1;
                        gkVar.bPB.appId = avVar.raS.jQb;
                        gkVar.bPB.messageAction = avVar.raS.raO;
                        gkVar.bPB.messageExt = avVar.raS.raN;
                        gkVar.bPB.scene = 3;
                        com.tencent.mm.sdk.b.a.sFg.m(gkVar);
                        a.ezo.a(this.olf.activity, avVar.raS.jQb, cS, bAJ.hbL, i, 11, 3, avVar.raS.raM, bAJ.ksA);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
