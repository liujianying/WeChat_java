package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.ui.m.2;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

class m$2$1 implements OnCancelListener {
    final /* synthetic */ q eQM;
    final /* synthetic */ 2 eTJ;

    m$2$1(2 2, q qVar) {
        this.eTJ = 2;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
        g.DF().b(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL, this.eTJ.eTI);
    }
}
