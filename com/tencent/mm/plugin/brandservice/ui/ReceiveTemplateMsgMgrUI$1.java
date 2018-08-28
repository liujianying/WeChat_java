package com.tencent.mm.plugin.brandservice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ReceiveTemplateMsgMgrUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ReceiveTemplateMsgMgrUI hpP;

    ReceiveTemplateMsgMgrUI$1(ReceiveTemplateMsgMgrUI receiveTemplateMsgMgrUI) {
        this.hpP = receiveTemplateMsgMgrUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hpP.finish();
        return true;
    }
}
