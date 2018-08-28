package com.tencent.mm.ui.transmit;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.aa.a;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.g;

class MsgRetransmitUI$16 implements a {
    final /* synthetic */ String bAd;
    final /* synthetic */ g.a fZg;
    final /* synthetic */ MsgRetransmitUI uDL;
    final /* synthetic */ g.a uDS;
    final /* synthetic */ byte[] uDT;

    MsgRetransmitUI$16(MsgRetransmitUI msgRetransmitUI, g.a aVar, g.a aVar2, String str, byte[] bArr) {
        this.uDL = msgRetransmitUI;
        this.fZg = aVar;
        this.uDS = aVar2;
        this.bAd = str;
        this.uDT = bArr;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, long j) {
        x.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", new Object[]{str, bi.Xf(str2), bi.Xf(str3), bi.Xf(this.fZg.dwK), bi.Xf(str4), bi.Xf(str5)});
        if (bi.oW(str3)) {
            h.b(this.uDL, this.uDL.getString(R.l.contain_undownload_msg), "", true);
            this.uDL.finish();
            return;
        }
        l.a(this.uDS, this.fZg.appId, this.fZg.appName, this.bAd, "", this.uDT, MsgRetransmitUI.a(this.uDL), str3);
    }
}
