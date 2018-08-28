package com.tencent.mm.plugin.setting.ui.qrcode;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShareMicroMsgChoiceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShareMicroMsgChoiceUI mPB;

    ShareMicroMsgChoiceUI$1(ShareMicroMsgChoiceUI shareMicroMsgChoiceUI) {
        this.mPB = shareMicroMsgChoiceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mPB.YC();
        this.mPB.finish();
        return true;
    }
}
