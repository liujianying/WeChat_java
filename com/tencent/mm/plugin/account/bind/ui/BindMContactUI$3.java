package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class BindMContactUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ BindMContactUI eGA;

    BindMContactUI$3(BindMContactUI bindMContactUI) {
        this.eGA = bindMContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        BindMContactUI.a(this.eGA, BindMContactUI.d(this.eGA).getText().toString().trim() + bi.Fx(BindMContactUI.b(this.eGA).getText().toString()));
        if (!a.Sx(BindMContactUI.e(this.eGA)) || bi.Fx(BindMContactUI.b(this.eGA).getText().toString()).length() <= 0) {
            h.i(this.eGA, j.bind_mcontact_mobile_erro, j.app_tip);
        } else {
            x.i("MicroMsg.BindMContactUI", "do next, send sms to self");
            BindMContactUI.b(this.eGA, BindMContactUI.e(this.eGA));
        }
        return true;
    }
}
