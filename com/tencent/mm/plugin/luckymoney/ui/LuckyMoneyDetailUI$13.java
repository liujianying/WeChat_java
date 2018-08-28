package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;

class LuckyMoneyDetailUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyDetailUI kVo;

    LuckyMoneyDetailUI$13(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        this.kVo = luckyMoneyDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.mEJ.h(11701, new Object[]{Integer.valueOf(LuckyMoneyDetailUI.sl(LuckyMoneyDetailUI.m(this.kVo))), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
        Intent intent = new Intent();
        intent.setClass(this.kVo.mController.tml, LuckyMoneyMyRecordUI.class);
        intent.putExtra("key_type", 2);
        this.kVo.startActivity(intent);
        return true;
    }
}
