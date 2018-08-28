package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

class LuckyMoneyF2FQRCodeUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI kOv;

    LuckyMoneyF2FQRCodeUI$3(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.kOv = luckyMoneyF2FQRCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        LuckyMoneyF2FQRCodeUI.a(this.kOv, new d(this.kOv, 1, false));
        LuckyMoneyF2FQRCodeUI.y(this.kOv).ofp = LuckyMoneyF2FQRCodeUI.x(this.kOv);
        LuckyMoneyF2FQRCodeUI.y(this.kOv).ofq = LuckyMoneyF2FQRCodeUI.z(this.kOv);
        LuckyMoneyF2FQRCodeUI.y(this.kOv).bXO();
        return true;
    }
}
