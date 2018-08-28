package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class ShakeMsgListUI$6 implements d {
    final /* synthetic */ ShakeMsgListUI mZP;

    ShakeMsgListUI$6(ShakeMsgListUI shakeMsgListUI) {
        this.mZP = shakeMsgListUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        g a = ShakeMsgListUI.a(this.mZP);
        x.i("MicroMsg.ShakeMessageStorage", "delBySvrId = " + a.diF.delete(a.getTableName(), "svrid = '" + String.valueOf(ShakeMsgListUI.i(this.mZP)) + "'", null));
        ShakeMsgListUI.b(this.mZP).a(null, null);
    }
}
