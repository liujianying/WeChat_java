package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c.4;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class c$2 implements a<Void, com.tencent.mm.ab.a.a<ayk>> {
    final /* synthetic */ c kMQ;

    c$2(c cVar) {
        this.kMQ = cVar;
    }

    private Void c(com.tencent.mm.ab.a.a<ayk> aVar) {
        if (aVar.errType == 0 && aVar.errCode == 0) {
            x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB success");
            if (((ayk) aVar.dIv).sbd != 0) {
                x.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB error wxahb_status = [%d] errorwording = [%s]", new Object[]{Integer.valueOf(((ayk) aVar.dIv).sbd), ((ayk) aVar.dIv).sbo});
                c cVar = this.kMQ;
                int i = ((ayk) aVar.dIv).sbd;
                switch (i) {
                    case 1:
                        cVar.Q(new Intent().putExtra("result_error_code", 20001).putExtra("result_error_msg", "fail:the red packet is expired"));
                        break;
                    case 2:
                        cVar.Q(new Intent().putExtra("result_error_code", 20002).putExtra("result_error_msg", "fail:the red packet has been received completly"));
                        break;
                    case 3:
                        cVar.Q(new Intent().putExtra("result_error_code", 20003).putExtra("result_error_msg", "fail:risk control"));
                        break;
                    default:
                        cVar.Q(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{unknow open retun errCode:" + i + "}"));
                        break;
                }
            }
            c cVar2 = this.kMQ;
            ayk ayk = (ayk) aVar.dIv;
            if (cVar2.kMM == null) {
                x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.CgiOpenWxaHB end. ui == null");
            } else {
                cVar2.kMO = ayk;
                cVar2.kMM.baG();
                if (cVar2.kMO.ryB != null) {
                    cVar2.kMP = new RealnameGuideHelper();
                    cVar2.kMP.a(String.valueOf(cVar2.kMO.ryB.qYW), cVar2.kMO.ryB.kRt, cVar2.kMO.ryB.kRu, cVar2.kMO.ryB.kRv, cVar2.kMO.ryB.kRw, 1003);
                    RealnameGuideHelper realnameGuideHelper = cVar2.kMP;
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".appbrand.ui.receive.WxaLuckyMoneyReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    if (!realnameGuideHelper.b(cVar2.kMM.baA(), bundle, new 4(cVar2))) {
                        cVar2.Q(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{launch realname fail}}"));
                    }
                } else {
                    cVar2.baJ();
                }
            }
        } else {
            x.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB failed [%d, %d, %s]", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.Yy});
            this.kMQ.Q(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error open errType = " + aVar.errType + ",errCode" + aVar.errCode + "}}"));
        }
        return null;
    }
}
