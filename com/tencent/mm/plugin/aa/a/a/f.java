package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f extends l implements k {
    public String chatroomName;
    private e diJ;
    private b eAN;
    private com.tencent.mm.protocal.c.f eAQ;
    public g eAR;

    public f(long j, String str, List<String> list, int i, long j2, String str2) {
        a aVar = new a();
        aVar.dIG = new com.tencent.mm.protocal.c.f();
        aVar.dIH = new g();
        aVar.dIF = 1624;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.chatroomName = str2;
        this.eAN = aVar.KT();
        this.eAQ = (com.tencent.mm.protocal.c.f) this.eAN.dID.dIL;
        this.eAN.dIU = true;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.eAQ.qYf = list.size();
                    this.eAQ.qYg = j;
                    this.eAQ.title = URLEncoder.encode(str, "UTF-8");
                    this.eAQ.qYh = new LinkedList();
                    this.eAQ.qYh.addAll(list);
                    this.eAQ.scene = i;
                    this.eAQ.qYd = str2;
                    this.eAQ.qYi = i.bOL();
                    this.eAQ.qYj = j2;
                    x.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[]{this.eAQ.qYi});
                }
            } catch (Exception e) {
                x.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[]{e.getMessage()});
            }
        }
        x.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", new Object[]{Integer.valueOf(this.eAQ.qYf), Long.valueOf(this.eAQ.qYg), this.eAQ.title, this.eAQ.qYh, Integer.valueOf(this.eAQ.scene), this.eAQ.qYd, Long.valueOf(this.eAQ.qYj)});
    }

    public f(long j, String str, int i, int i2, long j2, String str2) {
        a aVar = new a();
        aVar.dIG = new com.tencent.mm.protocal.c.f();
        aVar.dIH = new g();
        aVar.dIF = 1624;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.eAQ = (com.tencent.mm.protocal.c.f) this.eAN.dID.dIL;
        this.chatroomName = str2;
        try {
            this.eAQ.qYf = i;
            this.eAQ.qYg = j;
            this.eAQ.title = URLEncoder.encode(str, "UTF-8");
            this.eAQ.qYh = new LinkedList();
            this.eAQ.scene = i2;
            this.eAQ.qYd = str2;
            this.eAQ.qYi = i.bOL();
            x.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[]{this.eAQ.qYi});
            this.eAQ.qYj = j2;
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[]{e.getMessage()});
        }
        x.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", new Object[]{Integer.valueOf(this.eAQ.qYf), Long.valueOf(this.eAQ.qYg), this.eAQ.title, this.eAQ.qYh, Integer.valueOf(this.eAQ.scene), this.eAQ.qYd, Long.valueOf(this.eAQ.qYj)});
    }

    public final int getType() {
        return 1624;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.eAR = (g) ((b) qVar).dIE.dIL;
        String str2 = "MicroMsg.NetSceneAALaunchByMoney";
        String str3 = "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.eAR.hUm);
        objArr[1] = this.eAR.hUn;
        objArr[2] = Boolean.valueOf(this.eAR.qYe == null);
        objArr[3] = this.eAR.qYc;
        x.i(str2, str3, objArr);
        x.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[]{this.eAR.qYe});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
