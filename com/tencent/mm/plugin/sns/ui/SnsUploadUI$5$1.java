package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI.5;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.a.c.a;

class SnsUploadUI$5$1 implements a {
    final /* synthetic */ 5 ogV;

    SnsUploadUI$5$1(5 5) {
        this.ogV = 5;
    }

    public final void pO(String str) {
        int syncFlag = SnsUploadUI.n(this.ogV.ogU).getSyncFlag();
        g.Ek();
        g.Ei().DT().set(68404, Integer.valueOf(syncFlag));
        SnsUploadUI.a(this.ogV.ogU, SnsUploadUI.a(this.ogV.ogU).getText().toString());
        int pasterLen = SnsUploadUI.a(this.ogV.ogU).getPasterLen();
        int privated = SnsUploadUI.n(this.ogV.ogU).getPrivated();
        int syncFlag2 = SnsUploadUI.n(this.ogV.ogU).getSyncFlag();
        SnsUploadUI.o(this.ogV.ogU);
        if (SnsUploadUI.p(this.ogV.ogU)) {
            this.ogV.ogU.setResult(-1, new Intent());
        }
        if (SnsUploadUI.f(this.ogV.ogU) instanceof ah) {
            ((ah) SnsUploadUI.f(this.ogV.ogU)).nQe = SnsUploadUI.q(this.ogV.ogU).getCurLocation();
        }
        if (SnsUploadUI.f(this.ogV.ogU) instanceof ae) {
            SnsUploadUI.a(this.ogV.ogU).setText("");
        }
        PInt pInt = new PInt();
        SnsUploadUI.f(this.ogV.ogU).a(privated, syncFlag2, SnsUploadUI.n(this.ogV.ogU).getTwitterAccessToken(), SnsUploadUI.r(this.ogV.ogU), SnsUploadUI.s(this.ogV.ogU).getAtList(), SnsUploadUI.q(this.ogV.ogU).getLocation(), pasterLen, SnsUploadUI.t(this.ogV.ogU), SnsUploadUI.u(this.ogV.ogU), pInt, SnsUploadUI.v(this.ogV.ogU), SnsUploadUI.w(this.ogV.ogU), SnsUploadUI.x(this.ogV.ogU));
        h hVar = h.mEJ;
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(SnsUploadUI.y(this.ogV.ogU));
        objArr[1] = Long.valueOf(bi.VE());
        objArr[2] = Integer.valueOf(SnsUploadUI.z(this.ogV.ogU) ? 0 : 1);
        objArr[3] = Integer.valueOf(pInt.value);
        hVar.h(13303, objArr);
        String str2 = "MicroMsg.SnsUploadUI";
        String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
        objArr = new Object[4];
        objArr[0] = Long.valueOf(SnsUploadUI.y(this.ogV.ogU));
        objArr[1] = Long.valueOf(bi.VE());
        objArr[2] = Integer.valueOf(SnsUploadUI.z(this.ogV.ogU) ? 0 : 1);
        objArr[3] = Integer.valueOf(pInt.value);
        x.d(str2, str3, objArr);
        h.mEJ.k(10910, "1");
        if (!bi.oW(SnsUploadUI.A(this.ogV.ogU))) {
            if (SnsUploadUI.t(this.ogV.ogU)) {
                h.mEJ.h(11455, new Object[]{"", SnsUploadUI.A(this.ogV.ogU), Integer.valueOf(-1), Integer.valueOf(-1)});
            } else {
                h.mEJ.h(11455, new Object[]{SnsUploadUI.A(this.ogV.ogU), "", Integer.valueOf(-1), Integer.valueOf(-1)});
            }
        }
        if (SnsUploadUI.B(this.ogV.ogU) != null) {
            SnsUploadUI.B(this.ogV.ogU).in(9);
        }
        if (SnsUploadUI.C(this.ogV.ogU)) {
            Intent intent = new Intent(this.ogV.ogU, SnsTimeLineUI.class);
            intent.putExtra("sns_resume_state", false);
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            intent.addFlags(67108864);
            this.ogV.ogU.startActivity(intent);
        }
        com.tencent.mm.sdk.b.a.sFg.m(new qq());
    }

    public final void YX() {
    }

    public final void YY() {
        com.tencent.mm.ui.base.h.i(this.ogV.ogU, j.sns_upload_post_text_invalid_more, j.sns_upload_post_text_invalid_title);
    }
}
