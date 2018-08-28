package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.data.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.d.o$a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public final class k implements o$a {
    Activity activity;
    private ae nMm;
    private int scene = 0;

    public k(Activity activity, int i, ae aeVar) {
        this.activity = activity;
        this.scene = i;
        this.nMm = aeVar;
    }

    public final void bQ(Object obj) {
        int i = 1;
        boolean z = false;
        Intent intent = new Intent();
        if (this.activity != null) {
            String str;
            if (obj instanceof a) {
                a aVar = (a) obj;
                x.d("Micro.ClickableCallBack", "onClick : " + aVar.userName + " activity: " + (this.activity == null));
                n Nl = af.byo().Nl(aVar.bNH);
                if (aVar.nkG) {
                    b bAF = Nl.bAF();
                    String bBn = Nl.bBn();
                    if (bAF == null || bAF.nyO != 1 || bi.oW(bAF.nyP)) {
                        this.nMm.bxT().a(Nl, false);
                        if (this.scene != 0) {
                            i = 2;
                        }
                        SnsAdClick snsAdClick = new SnsAdClick(bBn, i, Nl.field_snsId, Nl.bBo(), Nl.bBr(), (byte) 0);
                        snsAdClick.egI = Nl.bAJ().ksA;
                        intent.putExtra("Contact_User", aVar.userName);
                        intent.putExtra("KSnsAdTag", snsAdClick);
                        intent.putExtra("Contact_Scene", 37);
                        com.tencent.mm.plugin.sns.c.a.ezn.d(intent, this.activity);
                        c cVar = new c(Nl.bBn(), 2, aVar.scene, "", Nl.bBr(), Nl.bAK());
                        g.Ek();
                        g.Eh().dpP.a(cVar, 0);
                        return;
                    }
                    String str2 = bAF.nyP;
                    x.i("Micro.ClickableCallBack", "headClickParam url " + str2 + " " + bAF.nyQ);
                    Intent intent2 = new Intent();
                    if (bAF.nyQ == 0) {
                        z = true;
                    }
                    intent2.putExtra("KsnsViewId", bBn);
                    intent2.putExtra("KRightBtn", z);
                    intent2.putExtra("jsapiargs", new Bundle());
                    intent2.putExtra("rawUrl", str2);
                    intent2.putExtra("useJs", true);
                    com.tencent.mm.plugin.sns.c.a.ezn.j(intent2, this.activity);
                    return;
                }
                com.tencent.mm.modelsns.b io;
                str = aVar.userName;
                if (this.scene == 0) {
                    io = com.tencent.mm.modelsns.b.io(719);
                } else {
                    io = com.tencent.mm.modelsns.b.ip(719);
                }
                io.nb(i.g(Nl)).ir(Nl.field_type).bP(Nl.xb(32)).nb(Nl.bBo()).nb(str);
                io.RD();
                if (this.scene == 0) {
                    io = com.tencent.mm.modelsns.b.io(746);
                } else {
                    io = com.tencent.mm.modelsns.b.ip(746);
                }
                io.nb(str).bP(str.endsWith(q.GF()));
                io.b(intent, "intent_key_StatisticsOplog");
                if (this.scene == 0) {
                    this.nMm.bxT().a(Nl, false);
                }
            } else {
                str = (String) obj;
                if (str.contains("@")) {
                    str = str.replace("@", "");
                }
                g.Ek();
                ab Ye = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Ye(str);
                if (Ye != null && Ye.ckW()) {
                    intent.putExtra("Contact_User", str);
                    intent.putExtra("Contact_Scene", 37);
                    com.tencent.mm.plugin.sns.c.a.ezn.d(intent, this.activity);
                    return;
                } else if (this.scene == 0) {
                    n nVar = new n();
                    nVar.field_userName = str;
                    this.nMm.bxT().a(nVar, false);
                }
            }
            intent.putExtra("Contact_User", str);
            com.tencent.mm.plugin.sns.c.a.ezn.d(intent, this.activity);
        }
    }
}
