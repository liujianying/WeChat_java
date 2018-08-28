package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.bhh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.c.a;

class d$1 implements a<Void, com.tencent.mm.ab.a.a<bhh>> {
    final /* synthetic */ d kMC;

    d$1(d dVar) {
        this.kMC = dVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ab.a.a aVar = (com.tencent.mm.ab.a.a) obj;
        if (aVar.errType == 0 && aVar.errCode == 0) {
            this.kMC.kMz = (bhh) aVar.dIv;
            if (this.kMC.kMz == null) {
                this.kMC.Q(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Request resp is nil}}"));
            } else if (this.kMC.kMz.sbd != 0 || this.kMC.kMz.kRq.equalsIgnoreCase("")) {
                x.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "CgiRequestWxaHB fail.  sendid = [%s] reqkey = [%s] wxahb_status = [%d]", new Object[]{this.kMC.kMz.sbb, this.kMC.kMz.kRq, Integer.valueOf(this.kMC.kMz.sbd)});
                this.kMC.Q(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Request errStatus = " + this.kMC.kMz.sbd + ",errMsg" + this.kMC.kMz.sbo + "}}"));
                return null;
            } else {
                x.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "CgiRequestWxaHB succeed sendid = [%s] reqkey = [%s]", new Object[]{((bhh) aVar.dIv).sbb, ((bhh) aVar.dIv).kRq});
                d dVar = this.kMC;
                String str = this.kMC.kMz.kRq;
                if (dVar.kMy == null) {
                    x.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "doWalletPay() called with: ui == null");
                } else {
                    MMActivity baA = dVar.kMy.baA();
                    baA.geJ = dVar;
                    PayInfo payInfo = new PayInfo();
                    payInfo.bOd = str;
                    payInfo.bVY = 37;
                    payInfo.bVU = 50;
                    h.a(baA, payInfo, dVar.kMB);
                }
                return null;
            }
        }
        x.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "CgiRequestWxaHB fail. [%d, %d, %s]", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.Yy});
        this.kMC.Q(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Request errType = " + aVar.errType + ",errCode" + aVar.errCode + "}}"));
        return null;
    }
}
