package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;

class LoginVoiceUI$2 implements OnCancelListener {
    final /* synthetic */ q eQM;
    final /* synthetic */ LoginVoiceUI eSm;

    LoginVoiceUI$2(LoginVoiceUI loginVoiceUI, q qVar) {
        this.eSm = loginVoiceUI;
        this.eQM = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eQM);
        this.eSm.YB();
    }
}
