package com.tencent.mm.pluginsdk.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BioHelperUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BioHelperUI qEQ;

    BioHelperUI$1(BioHelperUI bioHelperUI) {
        this.qEQ = bioHelperUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qEQ.finish();
        return true;
    }
}
