package com.tencent.mm.plugin.luckymoney.sns;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.luckymoney.sns.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class a$1 extends g {
    final /* synthetic */ a kTk;

    a$1(a aVar, MMActivity mMActivity, i iVar) {
        this.kTk = aVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof a)) {
            return false;
        }
        x.i("MicroMsg.ProcessManager", "OpenSnsPayProcess onSceneEnd, errType:" + i + " errCode:" + i2 + " errMsg:" + str);
        if (i == 0 && i2 == 0) {
            h.bA(this.fEY, this.fEY.getString(com.tencent.mm.plugin.wxpay.a.i.lucky_money_open_sns_pay_success));
            a.sg(121);
            a.a(this.kTk).putBoolean("is_open_sns_pay", true);
            this.kTk.a(this.fEY, 0, a.b(this.kTk));
            return true;
        }
        h.bA(this.fEY, this.fEY.getString(com.tencent.mm.plugin.wxpay.a.i.lucky_money_open_sns_pay_failed));
        a.sg(122);
        this.kTk.c(this.fEY, 0);
        return true;
    }

    public final boolean m(Object... objArr) {
        this.uXK.a(new a(1, (String) objArr[0], ""), true, 1);
        return true;
    }
}
