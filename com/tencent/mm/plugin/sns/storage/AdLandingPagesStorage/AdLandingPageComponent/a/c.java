package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adw;
import com.tencent.mm.protocal.c.adx;
import com.tencent.mm.protocal.c.awq;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    public String bVc;
    private b diG;
    private e diJ;

    public c(String str, String str2, String str3) {
        a aVar = new a();
        aVar.dIG = new adw();
        aVar.dIH = new adx();
        aVar.uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
        aVar.dIF = 1337;
        this.diG = aVar.KT();
        adw adw = (adw) this.diG.dID.dIL;
        adw.jQb = str;
        adw.rIj = str2;
        adw.rIk = str3;
        x.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + str2 + " sharedAppId :" + str);
    }

    public c(String str) {
        a aVar = new a();
        aVar.dIG = new awq();
        aVar.dIH = new awr();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_officialsync";
        aVar.dIF = 2721;
        this.diG = aVar.KT();
        ((awq) this.diG.dID.dIL).rZR = str;
        x.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: syncBuffer:" + str);
    }

    public final int getType() {
        return this.diG.dIF;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str + " sceneType: " + this.diG.dIF);
        if (this.diG.dIF == 1337) {
            this.bVc = ((adx) ((b) qVar).dIE.dIL).rFb;
        } else if (this.diG.dIF == 2721) {
            this.bVc = ((awr) ((b) qVar).dIE.dIL).rZS;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
