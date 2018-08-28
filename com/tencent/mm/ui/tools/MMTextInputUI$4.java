package com.tencent.mm.ui.tools;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.k;

class MMTextInputUI$4 implements TextWatcher {
    final /* synthetic */ MMTextInputUI uAI;

    MMTextInputUI$4(MMTextInputUI mMTextInputUI) {
        this.uAI = mMTextInputUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        boolean z = false;
        String obj = editable.toString();
        if (!MMTextInputUI.c(this.uAI)) {
            if (obj.trim().length() > 0) {
                this.uAI.enableOptionMenu(true);
            } else {
                this.uAI.enableOptionMenu(false);
            }
        }
        if (MMTextInputUI.d(this.uAI) > 0) {
            MMTextInputUI.a(this.uAI, 0);
            for (int i = 0; i < obj.length(); i++) {
                if (bi.n(obj.charAt(i))) {
                    MMTextInputUI.a(this.uAI, MMTextInputUI.e(this.uAI) + 2);
                } else {
                    MMTextInputUI.a(this.uAI, MMTextInputUI.e(this.uAI) + 1);
                }
            }
            if (MMTextInputUI.e(this.uAI) >= MMTextInputUI.f(this.uAI) && MMTextInputUI.e(this.uAI) <= MMTextInputUI.d(this.uAI)) {
                this.uAI.enableOptionMenu(true);
                MMTextInputUI.g(this.uAI).setVisibility(0);
                MMTextInputUI.g(this.uAI).setTextColor(this.uAI.getResources().getColor(d.text_input_limit_tips));
                MMTextInputUI.g(this.uAI).setText(this.uAI.getString(k.text_input_limit_tips, new Object[]{Integer.valueOf((MMTextInputUI.d(this.uAI) - MMTextInputUI.e(this.uAI)) >> 1)}));
            } else if (MMTextInputUI.e(this.uAI) > MMTextInputUI.d(this.uAI)) {
                this.uAI.enableOptionMenu(false);
                MMTextInputUI.g(this.uAI).setVisibility(0);
                MMTextInputUI.g(this.uAI).setTextColor(this.uAI.getResources().getColor(d.text_input_limit_warn));
                MMTextInputUI.g(this.uAI).setText(this.uAI.getString(k.text_input_out_tips, new Object[]{Integer.valueOf(((MMTextInputUI.e(this.uAI) - MMTextInputUI.d(this.uAI)) >> 1) + 1)}));
            } else {
                MMTextInputUI mMTextInputUI = this.uAI;
                if (MMTextInputUI.c(this.uAI)) {
                    z = true;
                } else if (MMTextInputUI.e(this.uAI) > 0) {
                    z = true;
                }
                mMTextInputUI.enableOptionMenu(z);
                MMTextInputUI.g(this.uAI).setVisibility(8);
            }
        }
    }
}
