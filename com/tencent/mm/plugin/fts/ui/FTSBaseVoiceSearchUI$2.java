package com.tencent.mm.plugin.fts.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FTSBaseVoiceSearchUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FTSBaseVoiceSearchUI jwp;

    FTSBaseVoiceSearchUI$2(FTSBaseVoiceSearchUI fTSBaseVoiceSearchUI) {
        this.jwp = fTSBaseVoiceSearchUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jwp.finish();
        return true;
    }
}
