package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_payu.security_question.model.PayUSecurityQuestion;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@a(3)
public class WalletPayUSecurityQuestionAnswerUI extends WalletBaseUI {
    private Button eWk;
    private WalletPayUSecurityQuestionView pGl;
    private WalletFormView pGm;
    private PayUSecurityQuestion pGn;
    private a pGo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pGo = new a(this);
        this.pGl = (WalletPayUSecurityQuestionView) findViewById(f.payu_sec_ques);
        this.pGm = (WalletFormView) findViewById(f.payu_sec_answer);
        com.tencent.mm.wallet_core.ui.formview.a.g(this.pGm);
        this.eWk = (Button) findViewById(f.payu_next);
        this.pGm.setOnInputValidChangeListener(new 1(this));
        this.eWk.setOnClickListener(new 2(this));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            this.pGn = (PayUSecurityQuestion) this.sy.getParcelable("key_security_question");
            x.d("MicroMsg.WalletPayUSecurityQuestionAnswerUI", "hy: updating view");
            if (this.pGn != null) {
                this.pGl.setQuestionText(this.pGn.desc);
            }
            this.pGm.bqn();
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.payu_ui_security_question_answer;
    }

    protected final boolean bND() {
        return true;
    }
}
