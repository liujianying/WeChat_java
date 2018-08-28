package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.sdk.platformtools.af;

class MMAppMgr$12 implements OnDismissListener {
    final /* synthetic */ OnClickListener pVb;

    MMAppMgr$12(OnClickListener onClickListener) {
        this.pVb = onClickListener;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        af.Wq("show_wap_adviser");
        if (this.pVb != null) {
            this.pVb.onClick(dialogInterface, 0);
        }
    }
}
