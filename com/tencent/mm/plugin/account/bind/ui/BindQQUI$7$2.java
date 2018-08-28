package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI.2;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI.7;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

class BindQQUI$7$2 implements d {
    final /* synthetic */ 7 eHo;

    BindQQUI$7$2(7 7) {
        this.eHo = 7;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                BindQQUI bindQQUI = this.eHo.eHn;
                g.DF().a(new y(y.eKP), 0);
                bindQQUI.getString(j.app_tip);
                bindQQUI.tipDialog = h.a(bindQQUI, bindQQUI.getString(j.app_loading), true, new 2(bindQQUI));
                return;
            default:
                return;
        }
    }
}
