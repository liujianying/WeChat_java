package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pluginsdk.model.j;

class SendAppMessageWrapperUI$8 implements OnCancelListener {
    final /* synthetic */ j tTg;
    final /* synthetic */ SendAppMessageWrapperUI uEK;

    SendAppMessageWrapperUI$8(SendAppMessageWrapperUI sendAppMessageWrapperUI, j jVar) {
        this.uEK = sendAppMessageWrapperUI;
        this.tTg = jVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.tTg.cbu();
        this.uEK.setResult(-1);
        this.uEK.finish();
    }
}
