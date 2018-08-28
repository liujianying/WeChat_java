package com.tencent.mm.plugin.setting.ui.qrcode;

import android.os.Bundle;
import com.tencent.mm.plugin.account.model.h;

class ShareToQQUI$5 extends h {
    final /* synthetic */ ShareToQQUI mPF;

    ShareToQQUI$5(ShareToQQUI shareToQQUI) {
        this.mPF = shareToQQUI;
    }

    public final void m(Bundle bundle) {
        super.m(bundle);
    }

    public final void onError(int i, String str) {
        super.onError(i, str);
        if (i == 3) {
            ShareToQQUI.d(this.mPF);
        }
    }
}
