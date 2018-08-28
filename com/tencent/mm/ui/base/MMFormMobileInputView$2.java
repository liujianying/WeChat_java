package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.x;

class MMFormMobileInputView$2 implements TextWatcher {
    private ap eVd = new ap();
    final /* synthetic */ MMFormMobileInputView tux;

    MMFormMobileInputView$2(MMFormMobileInputView mMFormMobileInputView) {
        this.tux = mMFormMobileInputView;
    }

    public final void afterTextChanged(Editable editable) {
        int selectionEnd = MMFormMobileInputView.b(this.tux).getSelectionEnd();
        String obj = MMFormMobileInputView.b(this.tux).getText().toString();
        String substring = MMFormMobileInputView.b(this.tux).getText().toString().substring(0, selectionEnd);
        if (obj != null && !obj.equals(MMFormMobileInputView.c(this.tux))) {
            String obj2 = MMFormMobileInputView.a(this.tux).getText().toString();
            MMFormMobileInputView.a(this.tux, ap.formatNumber(obj2.replace("+", ""), obj));
            MMFormMobileInputView.b(this.tux, ap.formatNumber(obj2.replace("+", ""), substring));
            if (!obj.equals(MMFormMobileInputView.c(this.tux))) {
                MMFormMobileInputView.b(this.tux).setText(MMFormMobileInputView.c(this.tux));
                int length = MMFormMobileInputView.b(this.tux).getText().toString().length();
                if (substring != null) {
                    try {
                        MMFormMobileInputView.b(this.tux, ap.formatNumber(obj2.replace("+", ""), substring));
                        if (obj.length() > 13 && selectionEnd <= length) {
                            MMFormMobileInputView.b(this.tux).setSelection(substring.toString().length());
                            return;
                        } else if (selectionEnd > length || MMFormMobileInputView.d(this.tux).toString().length() > length) {
                            MMFormMobileInputView.b(this.tux).setSelection(length - Math.abs(obj.length() - selectionEnd));
                            return;
                        } else {
                            MMFormMobileInputView.b(this.tux).setSelection(MMFormMobileInputView.d(this.tux).toString().length());
                            return;
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.MMFormMobileInputView", e, "", new Object[0]);
                        return;
                    }
                }
                MMFormMobileInputView.b(this.tux).setSelection(0);
            }
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
