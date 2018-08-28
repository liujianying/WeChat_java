package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import com.tencent.mm.az.d;
import com.tencent.mm.ui.base.n$d;

class ShakeSayHiListUI$2 implements n$d {
    final /* synthetic */ ShakeSayHiListUI nbq;

    ShakeSayHiListUI$2(ShakeSayHiListUI shakeSayHiListUI) {
        this.nbq = shakeSayHiListUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        d.SH().YP(String.valueOf(ShakeSayHiListUI.g(this.nbq)));
        ShakeSayHiListUI.b(this.nbq).a(null, null);
    }
}
