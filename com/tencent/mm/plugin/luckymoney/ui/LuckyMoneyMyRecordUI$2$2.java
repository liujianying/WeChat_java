package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.2;
import com.tencent.mm.ui.base.n.d;

class LuckyMoneyMyRecordUI$2$2 implements d {
    final /* synthetic */ 2 kVM;

    LuckyMoneyMyRecordUI$2$2(2 2) {
        this.kVM = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                if (this.kVM.kVL.mType != 2) {
                    this.kVM.kVL.mType = 2;
                    LuckyMoneyMyRecordUI.b(this.kVM.kVL);
                    this.kVM.kVL.bbx();
                    this.kVM.kVL.bbr();
                    return;
                }
                return;
            case 2:
                if (this.kVM.kVL.mType != 1) {
                    this.kVM.kVL.mType = 1;
                    LuckyMoneyMyRecordUI.b(this.kVM.kVL);
                    this.kVM.kVL.bbx();
                    this.kVM.kVL.bbr();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
