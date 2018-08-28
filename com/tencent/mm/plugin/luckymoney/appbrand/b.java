package com.tencent.mm.plugin.luckymoney.appbrand;

import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI;
import com.tencent.mm.ui.MMActivity;

public final class b implements a {
    public final void a(MMActivity mMActivity, String str, int i, String str2, int i2) {
        mMActivity.startActivityForResult(new Intent(mMActivity, WxaLuckyMoneyPrepareUI.class).putExtra("appId", str).putExtra("defaultWishingWord", str2).putExtra("range", i), i2);
    }

    public final void a(MMActivity mMActivity, String str, String str2, int i) {
        mMActivity.startActivityForResult(new Intent(mMActivity, WxaLuckyMoneyReceiveUI.class).putExtra("appId", str2).putExtra("sendId", str), i);
    }
}
