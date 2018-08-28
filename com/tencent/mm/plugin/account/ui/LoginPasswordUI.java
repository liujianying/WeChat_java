package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public class LoginPasswordUI extends LoginHistoryUI {
    private static String TAG = "LoginPasswordUI";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.eRq) {
            this.eLS = 2;
            this.eRm.setVisibility(0);
            this.eQP.setVisibility(0);
            this.eQO.setTypeface(Typeface.DEFAULT);
            this.eQO.setTransformationMethod(new PasswordTransformationMethod());
            this.eQO.setOnEditorActionListener(new 1(this));
            this.eQO.setOnKeyListener(new 2(this));
            this.eQO.addTextChangedListener(new 3(this));
            if (this.eQO.getText().toString().length() > 0) {
                this.eQP.setEnabled(true);
            } else {
                this.eQP.setEnabled(false);
            }
            this.eQP.setOnClickListener(new 4(this));
            this.eOW = getIntent().getStringExtra("auth_ticket");
            if (!bi.oW(this.eOW)) {
                this.eQN.setText(bi.oV(f.YF()));
                this.eQO.setText(bi.oV(f.YG()));
                new ag().postDelayed(new 5(this), 500);
            }
        }
    }

    protected final void Yz() {
        super.Yz();
        if (isFinishing() || getWindow() == null) {
            x.e(TAG, "LoginHistoryUI is finishing");
            return;
        }
        this.eQY.eIY = this.eQO.getText().toString();
        if (this.eQY.account.equals("")) {
            h.i(this, a$j.verify_username_null_tip, a$j.login_err_title);
        } else if (this.eQY.eIY.equals("")) {
            h.i(this, a$j.verify_password_null_tip, a$j.login_err_title);
        } else {
            YC();
            YA();
            q qVar = new q(this.eQY.account, this.eQY.eIY, this.eOW, 0);
            g.DF().a(qVar, 0);
            getString(a$j.app_tip);
            this.eHw = h.a((Context) this, getString(a$j.login_logining), true, new 6(this, qVar));
        }
    }
}
