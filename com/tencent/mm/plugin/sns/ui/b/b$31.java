package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$31 implements OnClickListener {
    final /* synthetic */ b olf;

    b$31(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        int i = 2;
        if (view.getTag() instanceof String) {
            n Nl = af.byo().Nl((String) view.getTag());
            if (Nl == null) {
                return;
            }
            b io;
            if (Nl.xb(32)) {
                x.i("MicroMsg.TimelineClickListener", "click the ad poi button");
                c cVar = new c(Nl.bBn(), 19, this.olf.scene == 0 ? 1 : 2, "", Nl.bBr(), Nl.bAK());
                g.Ek();
                g.Eh().dpP.a(cVar, 0);
                a bAH = Nl.bAH();
                if (bAH == null) {
                    x.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                    return;
                } else if (bi.oW(bAH.nyd)) {
                    x.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
                    return;
                } else {
                    if (this.olf.scene == 0) {
                        io = b.io(724);
                    } else {
                        io = b.ip(724);
                    }
                    io.nb(i.g(Nl)).ir(Nl.field_type).bP(Nl.xb(32)).nb(Nl.bBo()).nb("").nb("").nb("").nb("").nb(bAH.nyc).nb("").nb("");
                    io.RD();
                    x.i("MicroMsg.TimelineClickListener", "open webview url : " + bAH.nyd);
                    Intent intent = new Intent();
                    String bBn = Nl.bBn();
                    int i2 = this.olf.scene == 0 ? 1 : 2;
                    long j = Nl.field_snsId;
                    String bBo = Nl.bBo();
                    if (Nl.field_type == 1) {
                        i = 1;
                    }
                    SnsAdClick snsAdClick = new SnsAdClick(bBn, i2, j, bBo, i);
                    snsAdClick.egI = Nl.bAJ().ksA;
                    if (Nl != null && Nl.xb(32)) {
                        a bAH2 = Nl.bAH();
                        if (bAH2 != null) {
                            intent.putExtra("KsnsViewId", bAH2.fvT);
                        }
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("useJs", true);
                    intent.putExtra("KPublisherId", "sns_" + i.eF(Nl.field_snsId));
                    intent.putExtra("pre_username", Nl.field_userName);
                    intent.putExtra("prePublishId", "sns_" + i.eF(Nl.field_snsId));
                    intent.putExtra("preUsername", Nl.field_userName);
                    intent.putExtra("rawUrl", bAH.nyd);
                    com.tencent.mm.plugin.sns.c.a.ezn.j(intent, this.olf.activity);
                    return;
                }
            }
            arj arj = Nl.bAJ().sqa;
            Intent intent2 = new Intent();
            if (this.olf.scene == 0) {
                io = b.io(724);
            } else {
                io = b.ip(724);
            }
            io.nb(i.g(Nl)).ir(Nl.field_type).bP(Nl.xb(32)).nb(Nl.bBo()).nb(arj.rTG).ir(arj.nOB).nb(arj.rms).nb(arj.rmr).nb(arj.kFa).nb(arj.nOz).nb(arj.eJJ);
            io.RD();
            if (bi.oW(arj.rTG)) {
                intent2.putExtra("map_view_type", 7);
                intent2.putExtra("kwebmap_slat", (double) arj.rms);
                intent2.putExtra("kwebmap_lng", (double) arj.rmr);
                intent2.putExtra("kPoiName", arj.kFa);
                intent2.putExtra("Kwebmap_locaion", arj.nOz);
                d.b(this.olf.activity, "location", ".ui.RedirectUI", intent2);
                return;
            }
            String format;
            if (this.olf.old == 0) {
                format = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[]{arj.rTG});
            } else {
                format = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect", new Object[]{arj.rTG, r1.ksA});
            }
            intent2.putExtra("rawUrl", format);
            com.tencent.mm.plugin.sns.c.a.ezn.j(intent2, this.olf.activity);
        }
    }
}
