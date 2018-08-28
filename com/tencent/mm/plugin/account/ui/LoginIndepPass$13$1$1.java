package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.ui.LoginIndepPass.13.1;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

class LoginIndepPass$13$1$1 implements OnCancelListener {
    final /* synthetic */ a eRM;
    final /* synthetic */ 1 eRN;

    LoginIndepPass$13$1$1(1 1, a aVar) {
        this.eRN = 1;
        this.eRM = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eRM);
        g.DF().b(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL, this.eRN.eRL.eRJ);
    }
}
