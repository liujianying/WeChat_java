package com.tencent.mm.ui.transmit;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RetransmitPreviewUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RetransmitPreviewUI uEe;

    RetransmitPreviewUI$1(RetransmitPreviewUI retransmitPreviewUI) {
        this.uEe = retransmitPreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.uEe.finish();
        return true;
    }
}
