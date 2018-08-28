package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShareToFacebookRedirectUI$2 implements OnClickListener {
    final /* synthetic */ ShareToFacebookRedirectUI eXf;

    ShareToFacebookRedirectUI$2(ShareToFacebookRedirectUI shareToFacebookRedirectUI) {
        this.eXf = shareToFacebookRedirectUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.eXf.finish();
    }
}
