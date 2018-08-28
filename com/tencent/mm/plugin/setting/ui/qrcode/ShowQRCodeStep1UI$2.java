package com.tencent.mm.plugin.setting.ui.qrcode;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.base.h;

class ShowQRCodeStep1UI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ShowQRCodeStep1UI mPK;

    ShowQRCodeStep1UI$2(ShowQRCodeStep1UI showQRCodeStep1UI) {
        this.mPK = showQRCodeStep1UI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ShowQRCodeStep1UI showQRCodeStep1UI = this.mPK;
        h.a(showQRCodeStep1UI, "", new String[]{showQRCodeStep1UI.getString(i.self_qrcode_change), showQRCodeStep1UI.getString(i.self_qrcode_save)}, "", false, new ShowQRCodeStep1UI$4(showQRCodeStep1UI));
        return true;
    }
}
