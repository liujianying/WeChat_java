package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.ui.base.h;

class RegByMobileVoiceVerifyUI$3 implements OnClickListener {
    final /* synthetic */ RegByMobileVoiceVerifyUI eVO;

    RegByMobileVoiceVerifyUI$3(RegByMobileVoiceVerifyUI regByMobileVoiceVerifyUI) {
        this.eVO = regByMobileVoiceVerifyUI;
    }

    public final void onClick(View view) {
        if (RegByMobileVoiceVerifyUI.b(this.eVO) == 0 || RegByMobileVoiceVerifyUI.b(this.eVO) == 2 || RegByMobileVoiceVerifyUI.b(this.eVO) == 3) {
            RegByMobileVoiceVerifyUI.a(this.eVO, new a(RegByMobileVoiceVerifyUI.c(this.eVO), RegByMobileVoiceVerifyUI.d(this.eVO), "", 1, RegByMobileVoiceVerifyUI.a(this.eVO)));
            g.DF().a(RegByMobileVoiceVerifyUI.e(this.eVO), 0);
            h.a(this.eVO, a$j.bind_mcontact_voice_verify_select_tips, a$j.app_tip, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    RegByMobileVoiceVerifyUI$3.this.eVO.finish();
                }
            });
        } else if (RegByMobileVoiceVerifyUI.b(this.eVO) == 4 || RegByMobileVoiceVerifyUI.b(this.eVO) == 1) {
            RegByMobileVoiceVerifyUI.a(this.eVO, new x(RegByMobileVoiceVerifyUI.c(this.eVO), 1, "", 1, RegByMobileVoiceVerifyUI.a(this.eVO)));
            g.DF().a(RegByMobileVoiceVerifyUI.f(this.eVO), 0);
            h.a(this.eVO, a$j.bind_mcontact_voice_verify_select_tips, a$j.app_tip, new 2(this));
        }
    }
}
