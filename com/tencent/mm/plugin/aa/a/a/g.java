package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.h;
import com.tencent.mm.protocal.c.i;
import com.tencent.mm.protocal.c.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class g extends l implements k {
    public String chatroomName;
    private e diJ;
    private b eAN;
    private h eAS;
    public i eAT;

    public g(String str, long j, List<j> list, int i, String str2, long j2) {
        a aVar = new a();
        aVar.dIG = new h();
        aVar.dIH = new i();
        aVar.dIF = 1655;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.eAS = (h) this.eAN.dID.dIL;
        this.eAN.dIU = true;
        try {
            this.eAS.title = p.encode(str, "UTF-8");
            this.eAS.qYl = j;
            this.eAS.qYh = new LinkedList();
            this.eAS.qYh.addAll(list);
            this.eAS.scene = i;
            this.eAS.qYd = str2;
            this.eAS.qYi = com.tencent.mm.plugin.wallet_core.model.i.bOL();
            this.eAS.qYj = j2;
            x.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[]{this.eAS.qYi});
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", new Object[]{e.getMessage()});
        }
        this.chatroomName = str2;
        x.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", new Object[]{this.eAS.title, Long.valueOf(this.eAS.qYl), this.eAS.qYh, Integer.valueOf(this.eAS.scene), this.eAS.qYd, Long.valueOf(this.eAS.qYj)});
    }

    public final int getType() {
        return 1655;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.eAT = (i) ((b) qVar).dIE.dIL;
        String str2 = "MicroMsg.NetSceneAALaunchByPerson";
        String str3 = "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.eAT.hUm);
        objArr[1] = this.eAT.hUn;
        objArr[2] = this.eAT.qYc;
        objArr[3] = Boolean.valueOf(this.eAT.qYe == null);
        x.i(str2, str3, objArr);
        x.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[]{this.eAT.qYe});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
