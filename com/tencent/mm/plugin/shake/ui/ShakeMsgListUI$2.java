package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ShakeMsgListUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeMsgListUI mZP;

    ShakeMsgListUI$2(ShakeMsgListUI shakeMsgListUI) {
        this.mZP = shakeMsgListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.mZP.mController.tml, true, this.mZP.getString(R.l.shake_msg_list_clear_confirm), "", this.mZP.getString(R.l.say_hi_clean_all_btn), this.mZP.getString(R.l.app_cancel), new 1(this), new 2(this));
        return true;
    }
}
