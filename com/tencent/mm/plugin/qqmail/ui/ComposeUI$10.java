package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ComposeUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ ComposeUI mfs;

    ComposeUI$10(ComposeUI composeUI) {
        this.mfs = composeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if ((ComposeUI.a(this.mfs, false) && ComposeUI.a(this.mfs) == 5) || ComposeUI.a(this.mfs) == 6) {
            h.a(this.mfs.mController.tml, this.mfs.getString(R.l.plugin_qqmail_composeui_leave_alert), "", this.mfs.getString(R.l.plugin_qqmail_composeui_quit_delete), this.mfs.getString(R.l.app_cancel), new 1(this), null);
        } else {
            this.mfs.setResult(0);
            this.mfs.finish();
        }
        return true;
    }
}
