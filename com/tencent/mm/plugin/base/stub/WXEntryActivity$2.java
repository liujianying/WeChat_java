package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WXEntryActivity$2 implements OnCancelListener {
    final /* synthetic */ WXEntryActivity hef;

    WXEntryActivity$2(WXEntryActivity wXEntryActivity) {
        this.hef = wXEntryActivity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        WXEntryActivity.b(this.hef);
        this.hef.finish();
    }
}
