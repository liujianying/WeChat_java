package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ShakeTvHistoryListUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeTvHistoryListUI nbu;

    ShakeTvHistoryListUI$2(ShakeTvHistoryListUI shakeTvHistoryListUI) {
        this.nbu = shakeTvHistoryListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.nbu.mController.tml, true, this.nbu.getString(R.l.shake_tv_history_list_clear_confirm), "", this.nbu.getString(R.l.say_hi_clean_all_btn), this.nbu.getString(R.l.app_cancel), new 1(this), new 2(this));
        return true;
    }
}
