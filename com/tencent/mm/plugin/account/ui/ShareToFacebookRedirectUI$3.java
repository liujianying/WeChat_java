package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.account.model.h;
import com.tencent.mm.sdk.platformtools.x;

class ShareToFacebookRedirectUI$3 extends h {
    final /* synthetic */ ShareToFacebookRedirectUI eXf;

    ShareToFacebookRedirectUI$3(ShareToFacebookRedirectUI shareToFacebookRedirectUI) {
        this.eXf = shareToFacebookRedirectUI;
    }

    public final void m(Bundle bundle) {
        super.m(bundle);
    }

    public final void onError(int i, String str) {
        x.e(ShareToFacebookRedirectUI.bO(), "refresh token error. errType:%d, errMsg:%s", new Object[]{Integer.valueOf(i), str});
        super.onError(i, str);
        if (i == 3) {
            ShareToFacebookRedirectUI.a(this.eXf);
        }
    }
}
