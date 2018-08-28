package com.tencent.mm.plugin.ipcall.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bi;

class b$9 implements TextWatcher {
    final /* synthetic */ b ktn;

    b$9(b bVar) {
        this.ktn = bVar;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        CharSequence Fx = bi.Fx(charSequence.toString());
        if (Fx.contains(" ")) {
            Fx = Fx.replace(" ", "");
            this.ktn.ksV.setText(bi.L(Fx));
        } else if ((!this.ktn.ktm.equals(Fx) || i3 > 0) && bi.oW(Fx)) {
            this.ktn.ktm = Fx;
            this.ktn.ksV.setText("");
        }
        if (a.Fr(Fx)) {
            String Fp = a.Fp(Fx);
            if (!bi.oW(Fp)) {
                this.ktn.ksU.setText("+" + Fp);
                this.ktn.ksV.setText(a.Fu(Fx));
            }
        } else if (!Fx.equals(this.ktn.ktm)) {
            this.ktn.ktm = Fx;
            this.ktn.ksV.setText(Fx);
            if (bi.oW(this.ktn.ksU.getText().toString())) {
                this.ktn.ksU.setText("+" + a.aYy());
            }
        }
        if (this.ktn.ksS != null) {
            this.ktn.ksS.EY(this.ktn.ksV.getText().toString());
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
