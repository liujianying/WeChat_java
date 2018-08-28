package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class ShareToQQUI$4 implements OnDismissListener {
    final /* synthetic */ ShareToQQUI mPF;

    ShareToQQUI$4(ShareToQQUI shareToQQUI) {
        this.mPF = shareToQQUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.mPF.finish();
    }
}
