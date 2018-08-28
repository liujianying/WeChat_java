package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

class BakFinishUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BakFinishUI haF;

    BakFinishUI$1(BakFinishUI bakFinishUI) {
        this.haF = bakFinishUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        a.asN().asO().gZU = -1;
        BakFinishUI.a(this.haF);
        return true;
    }
}
