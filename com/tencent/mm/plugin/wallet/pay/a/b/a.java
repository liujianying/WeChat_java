package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.km;
import com.tencent.mm.protocal.c.kn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.m;

public class a extends m {
    private b diG;
    private e diJ;

    public a(String str, int i, int i2) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        km kmVar = new km();
        kmVar.reo = str;
        kmVar.rmJ = i;
        kmVar.rmK = i2;
        aVar.dIG = kmVar;
        aVar.dIH = new kn();
        aVar.uri = getUri();
        aVar.dIF = If();
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        x.i("MicroMsg.NetSceneCancelPay", "request uri: %s, reqKey: %s, payScene: %d, payChannel:%d", new Object[]{getUri(), str, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneCancelPay", "response uri: %s, errType: %d, errCode: %d, errMsg: %s", new Object[]{getUri(), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            try {
                kn knVar = (kn) ((b) qVar).dIE.dIL;
                x.i("MicroMsg.NetSceneCancelPay", "NetSceneCancelPay BaseResponse.Ret is %d, BaseResponse.ErrMsg is %s", new Object[]{Integer.valueOf(knVar.six.rfn), knVar.six.rgv});
            } catch (Exception e) {
                x.i("MicroMsg.NetSceneCancelPay", e.getMessage());
            }
        }
        if (this.diJ != null) {
            this.diJ.a(i, i2, str, this);
        }
    }

    public final int getType() {
        return If();
    }

    public int If() {
        return 2823;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/ts_cancelpay";
    }
}
