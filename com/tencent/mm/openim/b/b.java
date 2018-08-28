package com.tencent.mm.openim.b;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.afq;
import com.tencent.mm.protocal.c.afr;
import com.tencent.mm.protocal.c.axq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    private final com.tencent.mm.ab.b diG;
    private e diJ;
    private String eup;
    private String euq;
    public axq eur;
    private int ret;

    public b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.dIG = new afq();
        aVar.dIH = new afr();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        aVar.dIF = 881;
        this.diG = aVar.KT();
        this.eup = str;
        this.euq = bi.aG(str2, "");
        x.i("MicroMsg.NetSceneGetOpenIMContact", "get openim username: %s, roomname: %s, ticket:%s", new Object[]{str, this.euq, str3});
        afq afq = (afq) this.diG.dID.dIL;
        afq.eup = str;
        afq.reg = this.euq;
        afq.bLe = str3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 881;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, this.eup});
        if (i2 == 0 && i3 == 0) {
            afr afr = (afr) this.diG.dIE.dIL;
            this.ret = afr.rfn;
            this.eur = afr.rJB;
            x.i("MicroMsg.NetSceneGetOpenIMContact", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[]{r1.field_username, r1.field_nickname, r1.field_conRemark, Integer.valueOf(r1.getSource()), Integer.valueOf(r1.sex), r1.field_openImAppid, r1.cte, Integer.valueOf(r1.ctd), Integer.valueOf(r1.field_type), i.a(this.eur).field_descWordingId});
            ((i) g.l(i.class)).FR().S(r1);
            ((com.tencent.mm.openim.a.b) g.l(com.tencent.mm.openim.a.b.class)).aD(this.eur.hva, this.eur.saS);
            i.b(this.eur);
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
