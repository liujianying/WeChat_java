package com.tencent.mm.plugin.recharge.ui;

import android.text.Editable;
import android.text.TextWatcher;

class MallEditText$1 implements TextWatcher {
    final /* synthetic */ MallEditText mpl;

    MallEditText$1(MallEditText mallEditText) {
        this.mpl = mallEditText;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String charSequence2 = charSequence.toString();
        int selectionStart = MallEditText.a(this.mpl).getSelectionStart();
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
            if (length > MallEditText.b(this.mpl)) {
                if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                    selectionStart++;
                } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                    selectionStart += i3;
                }
            } else if (length < MallEditText.b(this.mpl) && (selectionStart == 4 || selectionStart == 9)) {
                selectionStart--;
            }
            MallEditText.a(this.mpl, length);
        }
        if (charSequence2.equals(charSequence3)) {
            MallEditText.c(this.mpl);
            return;
        }
        MallEditText.a(this.mpl).setText(charSequence3);
        if (selectionStart < MallEditText.b(this.mpl)) {
            MallEditText.a(this.mpl).setSelection(selectionStart);
        } else {
            MallEditText.a(this.mpl).setSelection(MallEditText.b(this.mpl));
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
