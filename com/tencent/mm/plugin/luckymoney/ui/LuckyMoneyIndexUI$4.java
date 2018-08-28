package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a$i;
import java.util.LinkedList;
import java.util.List;

class LuckyMoneyIndexUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyIndexUI kVs;

    LuckyMoneyIndexUI$4(LuckyMoneyIndexUI luckyMoneyIndexUI) {
        this.kVs = luckyMoneyIndexUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.mEJ.h(11701, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(this.kVs.getString(a$i.lucky_money_my_receive));
        linkedList2.add(Integer.valueOf(0));
        linkedList.add(this.kVs.getString(a$i.lucky_money_my_send));
        linkedList2.add(Integer.valueOf(1));
        com.tencent.mm.ui.base.h.a(this.kVs.mController.tml, "", linkedList, linkedList2, "", false, new 1(this));
        return true;
    }
}
