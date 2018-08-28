package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.ui.DialPad.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

class b$3 implements a {
    final /* synthetic */ b ktn;

    b$3(b bVar) {
        this.ktn = bVar;
    }

    public final void EU(String str) {
        this.ktn.ktd = this.ktn.ksV.getText().toString();
        if (this.ktn.kth) {
            this.ktn.ktc += str;
            this.ktn.ksU.setText(this.ktn.ktc);
            if (com.tencent.mm.plugin.ipcall.b.a.Fq(this.ktn.ktc.replace("+", "")) || this.ktn.ktc.replace("+", "").length() >= 4) {
                h.mEJ.h(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
                this.ktn.kth = false;
                this.ktn.ktb = com.tencent.mm.plugin.ipcall.b.a.Fn(this.ktn.ktc.replace("+", ""));
                this.ktn.ktd = b.dr(this.ktn.ktc.replace("+", ""), this.ktn.ktd);
                this.ktn.bx(this.ktn.ktd, -1);
                return;
            }
            return;
        }
        String replace = this.ktn.ksU.getText().toString().replace("+", "");
        if (this.ktn.ktk) {
            StringBuffer stringBuffer = new StringBuffer(this.ktn.ktd);
            stringBuffer.insert(this.ktn.ksV.getSelectionStart(), str);
            this.ktn.ktd = stringBuffer.toString();
        } else {
            this.ktn.ktd += str;
        }
        if (this.ktn.ktd.equals("00")) {
            this.ktn.ksU.setText("+");
            this.ktn.kth = true;
            this.ktn.ktc = "+";
            this.ktn.ktd = "";
        }
        if (com.tencent.mm.plugin.ipcall.b.a.Fq(this.ktn.ktc.replace("+", "") + this.ktn.ktd)) {
            this.ktn.ksU.setText("+" + this.ktn.ktc.replace("+", "") + this.ktn.ktd);
            this.ktn.ktb = com.tencent.mm.plugin.ipcall.b.a.Fn(this.ktn.ktc.replace("+", ""));
            this.ktn.kth = false;
            this.ktn.ktc = this.ktn.ktc.replace("+", "") + this.ktn.ktd;
            this.ktn.ktd = "";
        }
        String str2 = this.ktn.ktd;
        this.ktn.ktd = b.dr(replace, this.ktn.ktd);
        if (!this.ktn.ktk) {
            this.ktn.bx(this.ktn.ktd, -1);
        } else if (str2.length() < this.ktn.ktd.length()) {
            this.ktn.bx(this.ktn.ktd, this.ktn.ksV.getSelectionEnd() + 2);
        } else if (str2.length() == this.ktn.ktd.length()) {
            this.ktn.bx(this.ktn.ktd, this.ktn.ksV.getSelectionEnd() + 1);
        } else if (str2.length() > this.ktn.ktd.length()) {
            this.ktn.bx(this.ktn.ktd, (this.ktn.ksV.getSelectionEnd() + 1) - (str2.length() - this.ktn.ktd.length()));
        }
        this.ktn.ktg = System.currentTimeMillis();
        if (this.ktn.ktd.length() > com.tencent.mm.plugin.ipcall.b.a.kzZ && !bi.oW(this.ktn.ktc + this.ktn.ktd)) {
            this.ktn.aYa();
        }
    }

    public final void EV(String str) {
        if (str.equals("0")) {
            this.ktn.ksU.setText("+");
            this.ktn.kth = true;
            this.ktn.ktc = "+";
        }
    }
}
