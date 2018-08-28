package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

class BakToPcUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BakToPcUI haT;

    BakToPcUI$1(BakToPcUI bakToPcUI) {
        this.haT = bakToPcUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        a.asN().asO().mO(1);
        BakToPcUI.a(this.haT);
        return true;
    }
}
