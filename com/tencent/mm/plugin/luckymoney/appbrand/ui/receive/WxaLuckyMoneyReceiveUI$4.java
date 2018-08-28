package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class WxaLuckyMoneyReceiveUI$4 implements OnCancelListener {
    final /* synthetic */ WxaLuckyMoneyReceiveUI kML;

    WxaLuckyMoneyReceiveUI$4(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        this.kML = wxaLuckyMoneyReceiveUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.kML.baB();
        if (WxaLuckyMoneyReceiveUI.e(this.kML).getVisibility() == 8 || WxaLuckyMoneyReceiveUI.f(this.kML).getVisibility() == 4) {
            x.i("MicroMsg.WxaLuckyMoneyReceiveUI", "user cancel & finish");
            WxaLuckyMoneyReceiveUI.d(this.kML);
            this.kML.finish();
        }
    }
}
