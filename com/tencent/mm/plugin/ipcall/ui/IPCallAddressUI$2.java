package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.ipcall.b;

class IPCallAddressUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallAddressUI kur;

    IPCallAddressUI$2(IPCallAddressUI iPCallAddressUI) {
        this.kur = iPCallAddressUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (IPCallAddressUI.b(this.kur) == 1) {
            b.ezn.q(new Intent(), this.kur);
        } else {
            this.kur.finish();
        }
        return true;
    }
}
