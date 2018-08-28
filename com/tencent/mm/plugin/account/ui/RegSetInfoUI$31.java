package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.bi;

class RegSetInfoUI$31 implements TextWatcher {
    final /* synthetic */ RegSetInfoUI eWJ;

    RegSetInfoUI$31(RegSetInfoUI regSetInfoUI) {
        this.eWJ = regSetInfoUI;
    }

    public final void afterTextChanged(Editable editable) {
        if (!RegSetInfoUI.m(this.eWJ).ciq()) {
            RegSetInfoUI.m(this.eWJ).SO();
        }
        String trim = RegSetInfoUI.a(this.eWJ).getText().toString().trim();
        if (bi.oW(trim)) {
            RegSetInfoUI.r(this.eWJ).setText(this.eWJ.getString(j.regsetinfo_tip));
            RegSetInfoUI.s(this.eWJ);
            if (RegSetInfoUI.t(this.eWJ) != null) {
                RegSetInfoUI.t(this.eWJ).dismiss();
                RegSetInfoUI.u(this.eWJ);
            }
            RegSetInfoUI.a(this.eWJ).postDelayed(new Runnable() {
                public final void run() {
                    RegSetInfoUI.a(RegSetInfoUI$31.this.eWJ).clearFocus();
                    RegSetInfoUI.a(RegSetInfoUI$31.this.eWJ).requestFocus();
                }
            }, 50);
        }
        if (!bi.oW(trim) && (RegSetInfoUI.c(this.eWJ) || !trim.equals(RegSetInfoUI.v(this.eWJ)))) {
            RegSetInfoUI.s(this.eWJ);
            RegSetInfoUI.m(this.eWJ).J(500, 500);
        }
        RegSetInfoUI.a(this.eWJ, trim);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
