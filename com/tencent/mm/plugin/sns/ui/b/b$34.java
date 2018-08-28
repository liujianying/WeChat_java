package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.MaskImageButton;

class b$34 implements OnClickListener {
    final /* synthetic */ b olf;

    b$34(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        n nVar;
        boolean z;
        b io;
        int i = 721;
        boolean z2 = false;
        String str = (String) view.getTag();
        x.d("MicroMsg.TimelineClickListener", "onCommentClick:" + str);
        Intent intent = new Intent();
        String str2 = "";
        if (!(view instanceof MaskImageButton) || ((MaskImageButton) view).uAL == null) {
            nVar = null;
            z = false;
        } else {
            n Nl = af.byo().Nl((String) ((MaskImageButton) view).uAL);
            if (Nl.xb(32)) {
                str2 = Nl.bBn();
                com.tencent.mm.plugin.sns.storage.b bAF = Nl.bAF();
                if (bAF == null || bAF.nyO != 1 || bi.oW(bAF.nyP)) {
                    nVar = Nl;
                    z = true;
                } else {
                    str = bAF.nyP;
                    x.i("MicroMsg.TimelineClickListener", "headClickParam url " + str + " " + bAF.nyQ);
                    Intent intent2 = new Intent();
                    if (bAF.nyQ == 0) {
                        z2 = true;
                    }
                    intent2.putExtra("KsnsViewId", str2);
                    intent2.putExtra("KRightBtn", z2);
                    intent2.putExtra("jsapiargs", new Bundle());
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("useJs", true);
                    a.ezn.j(intent2, this.olf.activity);
                    return;
                }
            }
            nVar = Nl;
            z = false;
        }
        if (nVar != null) {
            if (this.olf.scene == 0) {
                io = b.io(nVar.xb(32) ? 722 : 721);
            } else {
                if (nVar.xb(32)) {
                    i = 722;
                }
                io = b.ip(i);
            }
            io.nb(i.g(nVar)).ir(nVar.field_type).bP(nVar.xb(32)).nb(nVar.bBo()).nb(str);
            io.RD();
        }
        if (z) {
            int i2;
            SnsAdClick snsAdClick = new SnsAdClick(str2, this.olf.scene == 0 ? 1 : 2, nVar.field_snsId, nVar.bBo(), nVar.bBr(), (byte) 0);
            snsAdClick.egI = nVar.bAJ().ksA;
            intent.putExtra("Contact_User", str);
            intent.putExtra("KSnsAdTag", snsAdClick);
            a.ezn.d(intent, this.olf.activity);
            if (this.olf.scene == 0) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            c cVar = new c(str2, 1, i2, "", nVar.bBr(), nVar.bAK());
            g.Ek();
            g.Eh().dpP.a(cVar, 0);
            return;
        }
        this.olf.nMm.bxT().a(nVar, true);
        if (this.olf.scene == 0) {
            io = b.io(746);
        } else {
            io = b.ip(746);
        }
        io.nb(str).bP(str.endsWith(q.GF()));
        io.b(intent, "intent_key_StatisticsOplog");
        intent.putExtra("Contact_User", str);
        a.ezn.d(intent, this.olf.activity);
    }
}
