package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class NearbySayHiListUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ NearbySayHiListUI lCB;

    NearbySayHiListUI$5(NearbySayHiListUI nearbySayHiListUI) {
        this.lCB = nearbySayHiListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.lCB.mController.tml, true, this.lCB.getResources().getString(R.l.say_hi_clean_all_title), "", this.lCB.getResources().getString(R.l.say_hi_clean_all_btn), this.lCB.getString(R.l.app_cancel), new 1(this), null);
        return true;
    }
}
