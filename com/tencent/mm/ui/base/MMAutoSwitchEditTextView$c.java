package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.b;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.d;
import java.util.Iterator;

class MMAutoSwitchEditTextView$c implements b, MMAutoSwitchEditText$c, d {
    final /* synthetic */ MMAutoSwitchEditTextView ttT;

    private MMAutoSwitchEditTextView$c(MMAutoSwitchEditTextView mMAutoSwitchEditTextView) {
        this.ttT = mMAutoSwitchEditTextView;
    }

    /* synthetic */ MMAutoSwitchEditTextView$c(MMAutoSwitchEditTextView mMAutoSwitchEditTextView, byte b) {
        this(mMAutoSwitchEditTextView);
    }

    public final void Ek(int i) {
        MMAutoSwitchEditText mMAutoSwitchEditText;
        String str = "";
        Iterator it = MMAutoSwitchEditTextView.a(this.ttT).iterator();
        while (it.hasNext()) {
            String str2;
            mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
            if (bi.oW(mMAutoSwitchEditText.getText().toString().trim())) {
                str2 = str;
            } else {
                str2 = str + mMAutoSwitchEditText.getText().toString().trim();
            }
            str = str2;
        }
        if (bi.oW(str) || str.length() != MMAutoSwitchEditTextView.b(this.ttT) * MMAutoSwitchEditTextView.c(this.ttT)) {
            if (MMAutoSwitchEditTextView.e(this.ttT) != null) {
                MMAutoSwitchEditTextView.e(this.ttT).Yu();
            }
            if (MMAutoSwitchEditTextView.a(this.ttT) != null && i < MMAutoSwitchEditTextView.a(this.ttT).size() - 1) {
                mMAutoSwitchEditText = (MMAutoSwitchEditText) MMAutoSwitchEditTextView.a(this.ttT).get(i + 1);
                if (mMAutoSwitchEditText != null) {
                    mMAutoSwitchEditText.requestFocus();
                }
            }
        } else if (MMAutoSwitchEditTextView.d(this.ttT) != null) {
            MMAutoSwitchEditTextView.d(this.ttT).pJ(str);
        }
    }

    public final void Ej(int i) {
        if (MMAutoSwitchEditTextView.a(this.ttT) != null && i < MMAutoSwitchEditTextView.a(this.ttT).size() && i != 0) {
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) MMAutoSwitchEditTextView.a(this.ttT).get(i - 1);
            if (mMAutoSwitchEditText != null) {
                mMAutoSwitchEditText.requestFocus();
            }
        }
    }

    public final void crq() {
        String str = "";
        Iterator it = MMAutoSwitchEditTextView.a(this.ttT).iterator();
        while (it.hasNext()) {
            String str2;
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
            if (bi.oW(mMAutoSwitchEditText.getText().toString().trim())) {
                str2 = str;
            } else {
                str2 = str + mMAutoSwitchEditText.getText().toString().trim();
            }
            str = str2;
        }
        if (MMAutoSwitchEditTextView.e(this.ttT) != null) {
            MMAutoSwitchEditTextView.e(this.ttT).Yu();
        }
    }
}
