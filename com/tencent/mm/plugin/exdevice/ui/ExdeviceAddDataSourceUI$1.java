package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceAddDataSourceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceAddDataSourceUI iAm;

    ExdeviceAddDataSourceUI$1(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.iAm = exdeviceAddDataSourceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iAm.finish();
        return true;
    }
}
