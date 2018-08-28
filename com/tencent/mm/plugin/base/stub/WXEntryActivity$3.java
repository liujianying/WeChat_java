package com.tencent.mm.plugin.base.stub;

import android.view.View;
import android.view.View.OnClickListener;

class WXEntryActivity$3 implements OnClickListener {
    final /* synthetic */ WXEntryActivity hef;

    WXEntryActivity$3(WXEntryActivity wXEntryActivity) {
        this.hef = wXEntryActivity;
    }

    public final void onClick(View view) {
        WXEntryActivity.c(this.hef);
        this.hef.finish();
    }
}
