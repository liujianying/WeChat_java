package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class PreviewHdHeadImg$2 implements OnMenuItemClickListener {
    final /* synthetic */ PreviewHdHeadImg mQr;

    PreviewHdHeadImg$2(PreviewHdHeadImg previewHdHeadImg) {
        this.mQr = previewHdHeadImg;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mQr.finish();
        return true;
    }
}
