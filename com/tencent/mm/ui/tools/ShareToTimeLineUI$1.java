package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ShareToTimeLineUI$1 implements OnCancelListener {
    final /* synthetic */ ShareToTimeLineUI uBZ;

    ShareToTimeLineUI$1(ShareToTimeLineUI shareToTimeLineUI) {
        this.uBZ = shareToTimeLineUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.uBZ.finish();
    }
}
