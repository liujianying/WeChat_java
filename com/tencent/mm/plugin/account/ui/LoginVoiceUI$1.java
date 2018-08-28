package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;

class LoginVoiceUI$1 implements OnClickListener {
    final /* synthetic */ LoginVoiceUI eSm;

    LoginVoiceUI$1(LoginVoiceUI loginVoiceUI) {
        this.eSm = loginVoiceUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(11557, new Object[]{Integer.valueOf(2)});
        Intent intent = new Intent();
        intent.putExtra("Kusername", this.eSm.eRg);
        intent.putExtra("kscene_type", 1);
        d.b(this.eSm.mController.tml, "voiceprint", ".ui.VoiceLoginUI", intent, 1024);
    }
}
