package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ProtocolThreeThreeUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ProtocolThreeThreeUI joy;

    ProtocolThreeThreeUI$2(ProtocolThreeThreeUI protocolThreeThreeUI) {
        this.joy = protocolThreeThreeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ProtocolThreeThreeUI.b(this.joy);
        return true;
    }
}
