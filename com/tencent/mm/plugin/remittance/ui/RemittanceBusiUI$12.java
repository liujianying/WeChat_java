package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class RemittanceBusiUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$12(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (RemittanceBusiUI.f(this.mBt)) {
            this.mBt.YC();
            this.mBt.showDialog(BaseReportManager.MAX_READ_COUNT);
        } else {
            this.mBt.finish();
        }
        return true;
    }
}
