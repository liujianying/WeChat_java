package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j$a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;

class SnsSightPlayerUI$8 implements OnClickListener {
    final /* synthetic */ SnsSightPlayerUI obb;

    SnsSightPlayerUI$8(SnsSightPlayerUI snsSightPlayerUI) {
        this.obb = snsSightPlayerUI;
    }

    public final void onClick(View view) {
        b io;
        if (SnsSightPlayerUI.a(this.obb).xb(32)) {
            j.a(j.b.njT, j$a.EnterCompleteVideo, SnsSightPlayerUI.a(this.obb));
        }
        Intent intent = new Intent();
        String s = an.s(af.getAccSnsPath(), SnsSightPlayerUI.b(this.obb).ksA);
        String k = i.k(SnsSightPlayerUI.b(this.obb));
        intent.setClass(this.obb, VideoAdPlayerUI.class);
        intent.putExtra("KFullVideoPath", s + k);
        intent.putExtra("KThumbPath", SnsSightPlayerUI.c(this.obb));
        intent.putExtra("IsAd", true);
        intent.putExtra("KStremVideoUrl", SnsSightPlayerUI.b(this.obb).rVL);
        intent.putExtra("KThumUrl", bi.oW(SnsSightPlayerUI.b(this.obb).rVO) ? SnsSightPlayerUI.b(this.obb).rVE : SnsSightPlayerUI.b(this.obb).rVO);
        intent.putExtra("KMediaId", SnsSightPlayerUI.b(this.obb).ksA);
        intent.putExtra("KUrl", SnsSightPlayerUI.b(this.obb).jPK);
        intent.putExtra("KViewId", SnsSightPlayerUI.a(this.obb).bBn());
        bsu bAJ = SnsSightPlayerUI.a(this.obb).bAJ();
        String str = "KSta_StremVideoAduxInfo";
        if (SnsSightPlayerUI.a(this.obb).bAH() == null) {
            s = "";
        } else {
            s = SnsSightPlayerUI.a(this.obb).bAH().ntU;
        }
        intent.putExtra(str, s);
        intent.putExtra("KSta_StremVideoPublishId", bAJ.ksA);
        intent.putExtra("KSta_SourceType", 1);
        intent.putExtra("KSta_Scene", j.b.njT.value);
        intent.putExtra("KSta_FromUserName", bAJ.hbL);
        intent.putExtra("KSta_SnSId", bAJ.ksA);
        intent.putExtra("KSta_SnsStatExtStr", bAJ.nNV);
        intent.putExtra("KMediaVideoTime", SnsSightPlayerUI.b(this.obb).oig);
        if (bi.oW(SnsSightPlayerUI.b(this.obb).rVP)) {
            s = bAJ.spZ;
        } else {
            s = SnsSightPlayerUI.b(this.obb).rVP;
        }
        intent.putExtra("KMediaTitle", s);
        com.tencent.mm.plugin.sns.storage.b bAF = SnsSightPlayerUI.a(this.obb).bAF();
        if (bAF != null && bAF.nyL == 0) {
            intent.putExtra("StreamWording", bAF.nyM);
            intent.putExtra("StremWebUrl", bAF.nyN);
        }
        n Nl = af.byo().Nl(SnsSightPlayerUI.d(this.obb));
        if (SnsSightPlayerUI.e(this.obb) == 0) {
            io = b.io(747);
        } else {
            io = b.ip(747);
        }
        io.nb(i.g(Nl)).ir(Nl.field_type).bP(true).nb(Nl.bBo()).ir(SnsSightPlayerUI.b(this.obb).oig);
        io.RD();
        if (SnsSightPlayerUI.e(this.obb) == 0) {
            io = b.io(748);
        } else {
            io = b.ip(748);
        }
        io.nb(i.g(Nl)).ir(Nl.field_type).bP(true).nb(Nl.bBo()).ir(SnsSightPlayerUI.b(this.obb).oig);
        io.b(intent, "intent_key_StatisticsOplog");
        this.obb.startActivity(intent);
        c cVar = new c(SnsSightPlayerUI.a(this.obb).bBn(), 14, 5, "", 2, SnsSightPlayerUI.a(this.obb).bAK());
        g.Ek();
        g.Eh().dpP.a(cVar, 0);
        if (SnsSightPlayerUI.e(this.obb) == 0) {
            pp ppVar = new pp();
            ppVar.caw.bTv = true;
            a.sFg.m(ppVar);
        }
    }
}
