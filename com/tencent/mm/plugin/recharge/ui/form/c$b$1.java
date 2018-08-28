package com.tencent.mm.plugin.recharge.ui.form;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.recharge.ui.form.c.b;

class c$b$1 implements TextWatcher {
    private int mpk = 0;
    final /* synthetic */ b mqS;

    public c$b$1(b bVar) {
        this.mqS = bVar;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String charSequence2 = charSequence.toString();
        int selectionStart = this.mqS.mqP.getContentEditText().getSelectionStart();
        CharSequence charSequence3 = "";
        if (charSequence2 != null) {
            StringBuilder stringBuilder = new StringBuilder(charSequence2.replaceAll(" ", ""));
            int length = stringBuilder.length();
            if (length >= 4) {
                stringBuilder.insert(3, ' ');
            }
            if (length >= 8) {
                stringBuilder.insert(8, ' ');
            }
            charSequence3 = stringBuilder.toString();
            length = charSequence3.length();
            if (length > this.mpk) {
                if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                    selectionStart++;
                } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                    selectionStart += i3;
                }
            } else if (length < this.mpk && (selectionStart == 4 || selectionStart == 9)) {
                selectionStart--;
            }
            this.mpk = length;
        }
        if (!charSequence2.equals(charSequence3)) {
            this.mqS.mqP.getContentEditText().setText(charSequence3);
            if (selectionStart < this.mpk) {
                this.mqS.mqP.getContentEditText().setSelection(selectionStart);
            } else {
                this.mqS.mqP.getContentEditText().setSelection(this.mpk);
            }
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
