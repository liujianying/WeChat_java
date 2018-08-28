package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Intent;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class c$1 implements a<Void, com.tencent.mm.ab.a.a<bfo>> {
    final /* synthetic */ c kMQ;

    c$1(c cVar) {
        this.kMQ = cVar;
    }

    private Void c(com.tencent.mm.ab.a.a<bfo> aVar) {
        if (aVar.errType == 0 && aVar.errCode == 0) {
            x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB succeed, wxahb_status = [%d],receive_status = [%d],sendId = [%s]", new Object[]{Integer.valueOf(((bfo) aVar.dIv).sbd), Integer.valueOf(((bfo) aVar.dIv).kLd), this.kMQ.kLZ});
            if (!(((bfo) aVar.dIv).sbd == 1 || ((bfo) aVar.dIv).sbc == null)) {
                this.kMQ.kMN = ((bfo) aVar.dIv).sbc.toByteArray();
            }
            this.kMQ.state = ((bfo) aVar.dIv).sbd;
            c cVar = this.kMQ;
            bfo bfo = (bfo) aVar.dIv;
            if (cVar.kMM == null) {
                x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB succeed but ui == null");
            } else {
                int i = (bfo.sbm == 1 && bfo.kLe == 0) ? 1 : bfo.kLd == 2 ? 1 : 0;
                if (i != 0) {
                    x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onLuckyMoneyReceived shouldSkipToDetailUI");
                    cVar.baJ();
                } else if (bfo.sbd == 1) {
                    cVar.kMM.a(bfo.sbk, bfo.sbl, bfo.sbd, bfo.sbo, bfo.sbm == 1, bfo.kLe == 1);
                } else if (bfo.sbd == 0) {
                    cVar.kMM.a(bfo.sbk, bfo.sbl, bfo.hyz, bfo.kLf, bfo.sbm == 1, bfo.kLe == 1);
                } else {
                    x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "back.resp.wxahb_status is invalid.resp. wxahb_status = [%d] receive_status = [%d] hb_type = [%d]", new Object[]{Integer.valueOf(bfo.sbd), Integer.valueOf(bfo.kLd), Integer.valueOf(bfo.kLe)});
                }
            }
        } else {
            x.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB failed [%d, %d, %s]", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.Yy});
            this.kMQ.Q(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Receive errType = " + aVar.errType + ",errCode" + aVar.errCode + "}}"));
        }
        return null;
    }
}
