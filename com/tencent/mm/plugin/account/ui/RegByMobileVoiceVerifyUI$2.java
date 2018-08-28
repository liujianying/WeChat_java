package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class RegByMobileVoiceVerifyUI$2 implements OnClickListener {
    final /* synthetic */ RegByMobileVoiceVerifyUI eVO;

    RegByMobileVoiceVerifyUI$2(RegByMobileVoiceVerifyUI regByMobileVoiceVerifyUI) {
        this.eVO = regByMobileVoiceVerifyUI;
    }

    public final void onClick(View view) {
        this.eVO.startActivityForResult(new Intent(this.eVO, RegByMobileVoiceVerifySelectUI.class).putExtra("voice_verify_code", RegByMobileVoiceVerifyUI.a(this.eVO)), 10000);
    }
}
