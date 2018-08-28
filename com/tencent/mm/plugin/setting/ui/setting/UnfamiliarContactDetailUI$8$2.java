package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.8;
import com.tencent.mm.ui.base.n.d;

class UnfamiliarContactDetailUI$8$2 implements d {
    final /* synthetic */ 8 mUX;

    UnfamiliarContactDetailUI$8$2(8 8) {
        this.mUX = 8;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        g.Ek();
        g.Eh().dpP.b(681, UnfamiliarContactDetailUI.h(this.mUX.mUT));
        UnfamiliarContactDetailUI.a(this.mUX.mUT, UnfamiliarContactDetailUI.b(this.mUX.mUT), i);
        UnfamiliarContactDetailUI.b(this.mUX.mUT, false);
        if (UnfamiliarContactDetailUI.e(this.mUX.mUT) != null) {
            UnfamiliarContactDetailUI.e(this.mUX.mUT).RR.notifyChanged();
        }
    }
}
