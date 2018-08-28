package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ShareImageRedirectUI$2 implements OnClickListener {
    final /* synthetic */ ShareImageRedirectUI uBL;

    ShareImageRedirectUI$2(ShareImageRedirectUI shareImageRedirectUI) {
        this.uBL = shareImageRedirectUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.uBL.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        this.uBL.finish();
    }
}
