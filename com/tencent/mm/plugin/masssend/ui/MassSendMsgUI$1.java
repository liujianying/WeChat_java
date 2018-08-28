package com.tencent.mm.plugin.masssend.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MassSendMsgUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MassSendMsgUI lbm;

    MassSendMsgUI$1(MassSendMsgUI massSendMsgUI) {
        this.lbm = massSendMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lbm.finish();
        return true;
    }
}
