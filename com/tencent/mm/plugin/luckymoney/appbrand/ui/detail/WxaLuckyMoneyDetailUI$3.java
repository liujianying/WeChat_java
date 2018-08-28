package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class WxaLuckyMoneyDetailUI$3 implements OnCancelListener {
    final /* synthetic */ WxaLuckyMoneyDetailUI kLX;

    WxaLuckyMoneyDetailUI$3(WxaLuckyMoneyDetailUI wxaLuckyMoneyDetailUI) {
        this.kLX = wxaLuckyMoneyDetailUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.kLX.baB();
        if (WxaLuckyMoneyDetailUI.d(this.kLX).getVisibility() == 8 || WxaLuckyMoneyDetailUI.e(this.kLX).getVisibility() == 4) {
            x.i("MicroMsg.WxaLuckyMoneyDetailUI", "user cancel & finish");
            this.kLX.b(-1, null);
        }
    }
}
