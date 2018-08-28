package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.sdk.platformtools.af;

class MMAppMgr$15 implements OnDismissListener {
    MMAppMgr$15() {
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        af.Wq("show_wap_adviser");
    }
}
