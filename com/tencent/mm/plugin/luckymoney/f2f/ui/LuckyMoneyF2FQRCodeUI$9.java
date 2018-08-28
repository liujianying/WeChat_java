package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

class LuckyMoneyF2FQRCodeUI$9 implements d {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI kOv;

    LuckyMoneyF2FQRCodeUI$9(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.kOv = luckyMoneyF2FQRCodeUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                if (LuckyMoneyF2FQRCodeUI.g(this.kOv) > 0) {
                    LuckyMoneyF2FQRCodeUI.h(this.kOv);
                    return;
                } else {
                    h.bA(this.kOv, this.kOv.getString(a$i.lucky_money_f2f_clear_zero_packet_tips));
                    return;
                }
            default:
                return;
        }
    }
}
