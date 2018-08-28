package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ShareToFacebookRedirectUI$5 implements OnClickListener {
    final /* synthetic */ ShareToFacebookRedirectUI eXf;

    ShareToFacebookRedirectUI$5(ShareToFacebookRedirectUI shareToFacebookRedirectUI) {
        this.eXf = shareToFacebookRedirectUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.eXf.mController.tml, FacebookAuthUI.class);
        intent.putExtra("is_force_unbind", true);
        this.eXf.mController.tml.startActivityForResult(intent, 0);
    }
}
