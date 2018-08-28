package com.tencent.mm.plugin.z;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.protocal.c.bke;
import com.tencent.mm.protocal.c.bkf;
import com.tencent.mm.protocal.c.df;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g;

public final class d extends l implements k {
    private String aeskey;
    private String cXR;
    private b diG;
    private e diJ;
    private String fileId;
    private int lsF;

    public d(String str, String str2, int i, String str3) {
        this.fileId = str;
        this.aeskey = str2;
        this.lsF = i;
        this.cXR = str3;
        a aVar = new a();
        aVar.dIG = new bke();
        aVar.dIH = new bkf();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar.dIF = 222;
        aVar.dII = s$l.AppCompatTheme_ratingBarStyleIndicator;
        aVar.dIJ = 1000000107;
        this.diG = aVar.KT();
        x.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene fileId[%s], fileLen[%d], selfName[%s], stack[%s]", new Object[]{str, Integer.valueOf(i), str3, bi.cjd()});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        g.a aVar = new g.a();
        aVar.title = "PCSYNC";
        aVar.description = "ANDROID_PCSYNC";
        aVar.type = 35;
        aVar.url = this.fileId;
        aVar.dwK = this.aeskey;
        aVar.dwo = this.lsF;
        aVar.dwL = this.aeskey;
        aVar.showType = 0;
        bke bke = (bke) this.diG.dID.dIL;
        df dfVar = new df();
        dfVar.jTv = this.cXR;
        dfVar.rdn = aVar.sdkVer;
        dfVar.hcE = 35;
        dfVar.jTu = this.cXR;
        dfVar.jSA = g.a.a(aVar, null, null, 0, 0);
        dfVar.lOH = (int) bi.VE();
        bke.sjS = dfVar;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 222;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }
}
