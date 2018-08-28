package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.mm.modelappbrand.g;

class SendAppMessageWrapperUI$2 implements OnDismissListener {
    final /* synthetic */ String fwt;
    final /* synthetic */ SendAppMessageWrapperUI uEK;
    final /* synthetic */ View val$view;

    SendAppMessageWrapperUI$2(SendAppMessageWrapperUI sendAppMessageWrapperUI, String str, View view) {
        this.uEK = sendAppMessageWrapperUI;
        this.fwt = str;
        this.val$view = view;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ((g) com.tencent.mm.kernel.g.l(g.class)).a(this.fwt, this.val$view);
    }
}
