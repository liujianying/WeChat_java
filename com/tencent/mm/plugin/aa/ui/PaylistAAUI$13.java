package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.ui.widget.a.d;

class PaylistAAUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ PaylistAAUI eEl;
    final /* synthetic */ v eEp;

    PaylistAAUI$13(PaylistAAUI paylistAAUI, v vVar) {
        this.eEl = paylistAAUI;
        this.eEp = vVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.eEl, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this);
        dVar.bXO();
        return true;
    }
}
