package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.a.d;

class BaseScanUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ BaseScanUI mHS;
    final /* synthetic */ OnClickListener mHW;

    BaseScanUI$10(BaseScanUI baseScanUI, OnClickListener onClickListener) {
        this.mHS = baseScanUI;
        this.mHW = onClickListener;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.mHS.mController.tml, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this);
        dVar.bXO();
        return false;
    }
}
