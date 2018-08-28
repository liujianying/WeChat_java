package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ShakeItemListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShakeItemListUI mZA;

    ShakeItemListUI$1(ShakeItemListUI shakeItemListUI) {
        this.mZA = shakeItemListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.mZA, true, this.mZA.getString(R.l.say_hi_clean_all_title), "", this.mZA.getString(R.l.app_clear), this.mZA.getString(R.l.app_cancel), new 1(this), null);
        return true;
    }
}
