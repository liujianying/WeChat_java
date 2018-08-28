package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Intent;
import com.tencent.mm.ab.a.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.f;
import com.tencent.mm.protocal.c.bee;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class d$1 extends f<a<bee>> {
    final /* synthetic */ int dPF;
    final /* synthetic */ d kMc;

    d$1(d dVar, int i) {
        this.kMc = dVar;
        this.dPF = i;
    }

    public final /* synthetic */ void bC(Object obj) {
        a aVar = (a) obj;
        this.kMc.acT = false;
        if (this.kMc.kLY == null) {
            x.e("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB got its response. but ui is destroyed.");
        } else if (aVar.errType != 0 || aVar.errCode != 0) {
            x.e("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB failed [%d, %d, %s]", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.Yy});
            d.a(this.kMc, aVar.Yy, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error query errType = " + aVar.errType + ",errCode" + aVar.errCode + "}}"));
        } else if (((bee) aVar.dIv).sbd != 0) {
            x.e("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB error wxahb_status = [%d] errorwording = [%s]", new Object[]{Integer.valueOf(((bee) aVar.dIv).sbd), ((bee) aVar.dIv).sbo});
            d.a(this.kMc, ((bee) aVar.dIv).sbo, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error query red packet fail errStatus = " + ((bee) aVar.dIv).sbd + ",errMsg" + ((bee) aVar.dIv).sbo + "}}"));
        } else {
            x.i("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB succeed. hasmore = [%b] rcvd_user_list.size() = [%d], currentlist.size = [%d]", new Object[]{Integer.valueOf(((bee) aVar.dIv).sbn), Integer.valueOf(((bee) aVar.dIv).sbi.size()), Integer.valueOf(this.kMc.kMb.size())});
            this.kMc.kMa = ((bee) aVar.dIv).sbn;
            this.kMc.kMb.addAll(((bee) aVar.dIv).sbi);
            this.kMc.kLY.baB();
            if (this.dPF == 0) {
                this.kMc.kLY.a((bee) aVar.dIv);
                return;
            }
            b bVar = this.kMc.kLY;
            LinkedList linkedList = ((bee) aVar.dIv).sbi;
            bVar.bu(this.kMc.kMb);
        }
    }
}
