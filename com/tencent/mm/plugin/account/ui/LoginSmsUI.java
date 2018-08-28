package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public class LoginSmsUI extends LoginHistoryUI {
    private static String TAG = "LoginSmsUI";

    static /* synthetic */ void a(LoginSmsUI loginSmsUI, String str) {
        if (!bi.oW(str)) {
            a aVar = new a(str, 16, "", 0, "");
            g.DF().a(aVar, 0);
            loginSmsUI.getString(j.app_tip);
            loginSmsUI.eHw = h.a(loginSmsUI, loginSmsUI.getString(j.app_waiting), true, new 4(loginSmsUI, aVar));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.eRq) {
            this.eLS = 3;
            if (!bi.Xd(this.eRg).booleanValue() && bi.Xd(this.eRa).booleanValue()) {
                this.eQN.setText(pK(this.eRa));
            }
            this.eRn.setVisibility(0);
            this.eRn.setInputType(3);
            this.eRn.setSendSmsBtnClickListener(new 1(this));
            this.eRn.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                    if (LoginSmsUI.this.eRn.getText().toString().length() > 0) {
                        LoginSmsUI.this.eQP.setEnabled(true);
                    } else {
                        LoginSmsUI.this.eQP.setEnabled(false);
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            if (this.eRn.getText().toString().length() > 0) {
                this.eQP.setEnabled(true);
            } else {
                this.eQP.setEnabled(false);
            }
            this.eQP.setVisibility(0);
            this.eQP.setOnClickListener(new 3(this));
        }
    }

    protected final void Yz() {
        super.Yz();
        if (isFinishing() || getWindow() == null) {
            x.e(TAG, "LoginHistoryUI is finishing");
        } else if (!bi.oW(this.eRa)) {
            this.eQY.account = this.eRa;
            YC();
            YA();
            a aVar = new a(this.eRa, 17, this.eRn.getText().toString().trim(), 0, "");
            g.DF().a(aVar, 0);
            getString(j.app_tip);
            this.eHw = h.a(this, getString(j.login_logining), true, new 5(this, aVar));
        }
    }

    public void onResume() {
        super.onResume();
        g.DF().a(c.CTRL_INDEX, this);
    }

    protected void onStop() {
        super.onStop();
        g.DF().b(c.CTRL_INDEX, this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.eRn.reset();
    }
}
