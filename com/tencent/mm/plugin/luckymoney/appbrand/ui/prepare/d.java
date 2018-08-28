package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.appbrand.a.e;
import com.tencent.mm.protocal.c.bhg;
import com.tencent.mm.protocal.c.bhh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

public final class d implements a, a {
    private String appId = null;
    boolean kMA;
    final int kMB = (hashCode() & 65535);
    c kMy;
    bhh kMz;

    public final /* synthetic */ void a(Object obj, Intent intent) {
        c cVar = (c) obj;
        x.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onCreate ");
        this.appId = intent.getStringExtra("appId");
        this.kMy = cVar;
    }

    public final void onDestroy() {
        x.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onDestroy ");
        this.kMy = null;
    }

    public final void b(int i, int i2, String str, int i3) {
        x.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareRandomLuckyMoney() called with: moneyTotalAmount = [" + i + "], packageAmount = [" + i2 + "], wishing = [" + str + "], scope = [" + i3 + "]");
        if (this.kMy != null) {
            bhg bhg = new bhg();
            bhg.bPS = this.appId;
            bhg.kLe = 1;
            bhg.qYf = i2;
            bhg.sbh = (long) i;
            bhg.kLf = str;
            bhg.sie = i3;
            a(bhg);
        }
    }

    public final void c(int i, int i2, String str, int i3) {
        x.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareFixLuckyMoney() called with: packageMoneyAmount = [" + i + "], packageAmount = [" + i2 + "], wishing = [" + str + "], scope = [" + i3 + "]");
        if (this.kMy != null) {
            bhg bhg = new bhg();
            bhg.bPS = this.appId;
            bhg.kLe = 0;
            bhg.qYf = i2;
            bhg.sid = i;
            bhg.kLf = str;
            bhg.sie = i3;
            a(bhg);
        }
    }

    private void a(bhg bhg) {
        x.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl ");
        if (this.kMA) {
            x.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl isRequesting");
            return;
        }
        this.kMA = true;
        new e(bhg).b(new 1(this));
    }

    final void Q(Intent intent) {
        this.kMA = false;
        if (this.kMy != null) {
            this.kMy.b(0, intent);
        }
    }

    public final void b(int i, int i2, Intent intent) {
        x.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() called with: requestCode = [" + i + "], resultCode = [" + i2 + "], data = [" + intent + "]");
        if (i != this.kMB) {
            return;
        }
        if (i2 == -1) {
            this.kMy.a(b.class, new Intent(), new 2(this));
            return;
        }
        x.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() REQUEST_CODE_WALLET called cancel ");
        Q(new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:pay fail"));
    }
}
