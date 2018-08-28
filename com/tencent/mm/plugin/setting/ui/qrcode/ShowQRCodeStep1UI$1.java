package com.tencent.mm.plugin.setting.ui.qrcode;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShowQRCodeStep1UI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShowQRCodeStep1UI mPK;

    ShowQRCodeStep1UI$1(ShowQRCodeStep1UI showQRCodeStep1UI) {
        this.mPK = showQRCodeStep1UI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mPK.YC();
        this.mPK.finish();
        return true;
    }
}
