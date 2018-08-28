package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ShakeSayHiListUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeSayHiListUI nbq;

    ShakeSayHiListUI$3(ShakeSayHiListUI shakeSayHiListUI) {
        this.nbq = shakeSayHiListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.nbq.mController.tml, true, this.nbq.getString(R.l.say_hi_clean_all_title), "", this.nbq.getString(R.l.say_hi_clean_all_btn), this.nbq.getString(R.l.app_cancel), new 1(this), new 2(this));
        return true;
    }
}
