package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.view.View;
import android.view.View.OnClickListener;

class WxaLuckyMoneyReceiveUI$3 implements OnClickListener {
    final /* synthetic */ WxaLuckyMoneyReceiveUI kML;

    WxaLuckyMoneyReceiveUI$3(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        this.kML = wxaLuckyMoneyReceiveUI;
    }

    public final void onClick(View view) {
        WxaLuckyMoneyReceiveUI.d(this.kML);
        this.kML.finish();
    }
}
