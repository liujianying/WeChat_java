package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;

class CardNewMsgUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ CardNewMsgUI hFN;

    CardNewMsgUI$6(CardNewMsgUI cardNewMsgUI) {
        this.hFN = cardNewMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.mEJ.h(11582, new Object[]{"CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", ""});
        CardNewMsgUI.h(this.hFN);
        return true;
    }
}
