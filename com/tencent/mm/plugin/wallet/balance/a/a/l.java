package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.awx;
import com.tencent.mm.sdk.platformtools.x;

public final class l {
    private static l oYZ;
    public awx oZa;

    public static l bMQ() {
        if (oYZ == null) {
            oYZ = new l();
        }
        return oYZ;
    }

    public final void a(awx awx) {
        x.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s, real_time_balbance %s", new Object[]{Integer.valueOf(awx.balance), Integer.valueOf(awx.rZW), Integer.valueOf(awx.rZV), Integer.valueOf(awx.rZX)});
        this.oZa = awx;
    }
}
