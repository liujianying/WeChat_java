package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

class ExdeviceProfileUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$12(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.iEx.mController.tml, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = ExdeviceProfileUI.n(this.iEx);
        dVar.bXO();
        return true;
    }
}
