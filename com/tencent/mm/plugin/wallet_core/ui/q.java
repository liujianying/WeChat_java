package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.c.o;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public final class q implements e {
    public boolean bIq = false;
    public b pzb;
    private a pzc;

    public interface b {
        int bce();

        Context getContext();
    }

    public final void onResume() {
        g.Ek();
        g.Eh().dpP.a(2541, this);
        g.Ek();
        g.Eh().dpP.a(2791, this);
    }

    public final void onPause() {
        g.Ek();
        g.Eh().dpP.b(2541, this);
        g.Ek();
        g.Eh().dpP.b(2791, this);
    }

    public final void bcc() {
        o oVar = new o();
        g.Ek();
        g.Eh().dpP.a(oVar, 0);
        this.pzc.bcc();
    }

    public final void cancel() {
        this.pzc.cancel();
    }

    public final void a(a aVar, boolean z) {
        this.pzc = aVar;
        g.Ek();
        x.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", new Object[]{Boolean.valueOf(((Boolean) g.Ei().DT().get(a.sZH, Boolean.valueOf(false))).booleanValue()), Boolean.valueOf(z)});
        if (((Boolean) g.Ei().DT().get(a.sZH, Boolean.valueOf(false))).booleanValue()) {
            aVar.bcd();
        } else if (this.bIq) {
            x.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", new Object[]{Boolean.valueOf(this.bIq)});
            aVar.bcd();
        } else if (z) {
            this.bIq = true;
            f fVar = new f();
            g.Ek();
            g.Eh().dpP.a(fVar, 0);
        } else {
            aVar.bcd();
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof f) {
            if (i == 0 && i2 == 0) {
                f fVar = (f) lVar;
                x.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(ah.aKp()), fVar.pjb, Boolean.valueOf(fVar.pjc)});
                if (ah.aKp() && fVar.pjc) {
                    Intent intent = new Intent();
                    intent.putExtra("agreement_content", fVar.pjb);
                    d.b(this.pzb.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", intent, this.pzb.bce());
                }
            }
        } else if ((lVar instanceof o) && i == 0 && i2 == 0) {
            g.Ek();
            g.Ei().DT().a(a.sZH, Boolean.valueOf(true));
            x.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
        }
    }
}
