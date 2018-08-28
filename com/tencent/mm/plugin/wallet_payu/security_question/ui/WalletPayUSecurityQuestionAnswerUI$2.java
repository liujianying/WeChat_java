package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletPayUSecurityQuestionAnswerUI$2 implements OnClickListener {
    final /* synthetic */ WalletPayUSecurityQuestionAnswerUI pGp;

    WalletPayUSecurityQuestionAnswerUI$2(WalletPayUSecurityQuestionAnswerUI walletPayUSecurityQuestionAnswerUI) {
        this.pGp = walletPayUSecurityQuestionAnswerUI;
    }

    public final void onClick(View view) {
        if (WalletPayUSecurityQuestionAnswerUI.b(this.pGp).ZF()) {
            this.pGp.sy.putString("key_question_answer", WalletPayUSecurityQuestionAnswerUI.b(this.pGp).getText());
            this.pGp.cDL().m(new Object[0]);
        }
    }
}
