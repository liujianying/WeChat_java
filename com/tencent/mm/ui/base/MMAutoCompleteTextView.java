package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.w.a.f;

public class MMAutoCompleteTextView extends AutoCompleteTextView {
    final Drawable qFN = getResources().getDrawable(f.list_clear);
    private a ttD;

    private class a implements TextWatcher {
        private String ttF;

        public a(String str) {
            this.ttF = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.toString().endsWith(this.ttF)) {
                MMAutoCompleteTextView.this.showDropDown();
            }
        }
    }

    public MMAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qFN.setBounds(0, 0, this.qFN.getIntrinsicWidth(), this.qFN.getIntrinsicHeight());
        cdi();
        setOnTouchListener(new 1(this));
        addTextChangedListener(new 2(this));
        setOnFocusChangeListener(new 3(this));
    }

    private void cdi() {
        if (getText().toString().equals("") || !isFocused()) {
            cdk();
        } else {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.qFN, getCompoundDrawables()[3]);
        }
    }

    private void cdk() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }

    public void setSpilter(String str) {
        if (!bi.oW(str)) {
            this.ttD = new a(str);
            addTextChangedListener(this.ttD);
        }
    }
}
