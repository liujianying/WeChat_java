package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.1;
import com.tencent.mm.ui.base.n.d;

class PreviewHdHeadImg$1$2 implements d {
    final /* synthetic */ 1 mQs;

    PreviewHdHeadImg$1$2(1 1) {
        this.mQs = 1;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                a.ezo.f(this.mQs.mQr);
                return;
            case 2:
                PreviewHdHeadImg.b(this.mQs.mQr);
                return;
            default:
                return;
        }
    }
}
