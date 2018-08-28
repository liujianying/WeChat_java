package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

class AAQueryListUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ AAQueryListUI eCd;

    AAQueryListUI$4(AAQueryListUI aAQueryListUI) {
        this.eCd = aAQueryListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.eCd, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this);
        dVar.bXO();
        return true;
    }
}
