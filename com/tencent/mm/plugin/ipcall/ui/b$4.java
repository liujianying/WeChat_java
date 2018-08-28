package com.tencent.mm.plugin.ipcall.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class b$4 implements OnClickListener {
    final /* synthetic */ b ktn;

    b$4(b bVar) {
        this.ktn = bVar;
    }

    public final void onClick(View view) {
        String obj = this.ktn.ksV.getText().toString();
        if (bi.oW(obj)) {
            obj = this.ktn.ksU.getText().toString();
            if (!bi.oW(obj)) {
                Object substring = obj.substring(0, obj.length() - 1);
                if (bi.oW(substring) || substring.equals("+")) {
                    this.ktn.ksU.setText("+");
                    this.ktn.ktc = "+";
                    this.ktn.kth = true;
                    return;
                }
                this.ktn.ksU.setText(substring);
                this.ktn.ktc = substring;
                return;
            }
            return;
        }
        int selectionStart = this.ktn.ksV.getSelectionStart();
        if (!this.ktn.ktk || selectionStart - 1 < 0) {
            obj = obj.substring(0, obj.length() - 1);
        } else {
            Editable text = this.ktn.ksV.getText();
            text.delete(selectionStart - 1, selectionStart);
            obj = text.toString();
        }
        if (bi.oW(obj)) {
            this.ktn.ktd = "";
            this.ktn.bx("", -1);
        } else {
            String replace = this.ktn.ksU.getText().toString().replace("+", "");
            if (this.ktn.ktk) {
                this.ktn.ktd = b.dr(replace, obj);
                this.ktn.bx(this.ktn.ktd, (this.ktn.ktd.length() - obj.length()) + (selectionStart - 1));
            } else {
                this.ktn.ktd = b.dr(replace, obj);
                this.ktn.bx(this.ktn.ktd, -1);
            }
            this.ktn.aYa();
        }
        this.ktn.kte = "";
        this.ktn.eCM.setText("");
    }
}
