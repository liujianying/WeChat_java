package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.luckymoney.appbrand.a.b;
import com.tencent.mm.plugin.luckymoney.appbrand.a.d;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements a {
    private String appId = null;
    String kLZ = null;
    b kMM = null;
    byte[] kMN;
    ayk kMO;
    public RealnameGuideHelper kMP;
    int state = -1;

    public final /* synthetic */ void a(Object obj, Intent intent) {
        b bVar = (b) obj;
        x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onCreate ");
        this.kMM = bVar;
        if (intent == null) {
            x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onCreate intent == null");
            Q(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{intent is null}}"));
            return;
        }
        this.appId = intent.getStringExtra("appId");
        this.kLZ = intent.getStringExtra("sendId");
        if (bi.oW(this.appId) || bi.oW(this.kLZ)) {
            x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onCreate appId = [%s] sendId = [%s]", new Object[]{this.appId, this.kLZ});
            Q(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{appid or send is nil}}"));
            return;
        }
        new d(this.appId, this.kLZ).b(new 1(this));
    }

    public final void onDestroy() {
        x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDestroy ");
        this.kMM = null;
        this.kMO = null;
        this.kMP = null;
    }

    public final void baF() {
        if (this.kMM == null) {
            x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDetailBtnClick ui == null");
        } else {
            baJ();
        }
    }

    public final void baE() {
        if (this.state != 0) {
            x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onOpenBtnClick return state = %d", new Object[]{Integer.valueOf(this.state)});
        } else if (this.kMM == null) {
            x.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "openLuckyMoney ui == null");
        } else {
            new b(this.appId, this.kLZ, this.kMN).b(new 2(this));
        }
    }

    final void baJ() {
        Intent intent = new Intent();
        intent.putExtra("key_sendid", this.kLZ);
        intent.putExtra("key_appid", this.appId);
        if (this.kMO != null) {
            Bundle bundle = new Bundle();
            try {
                bundle.putByteArray("key_data", this.kMO.toByteArray());
                intent.putExtras(bundle);
                intent.putExtra("key_from", "value_open");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WxaReceiveLuckyMoneyLogic", e, "goLuckyMoneyDetailUI WxaDetailResponse putByteArray error", new Object[0]);
                Q(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{byte detail response fail}}"));
                return;
            }
        }
        intent.putExtra("key_from", "value_query");
        this.kMM.a(com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, intent, new 3(this));
    }

    final void Q(Intent intent) {
        if (this.kMM == null) {
            x.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.fail ui == null");
            return;
        }
        this.kMM.baB();
        this.kMM.b(0, intent);
    }
}
