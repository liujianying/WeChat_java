package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ShareImgUI$6 implements OnCancelListener {
    final /* synthetic */ ShareImgUI uBN;

    ShareImgUI$6(ShareImgUI shareImgUI) {
        this.uBN = shareImgUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.uBN.finish();
    }
}
