package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

class MMAutoSwitchEditText extends EditText {
    a ttI = new a(this);

    public interface b {
        void Ej(int i);
    }

    public MMAutoSwitchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addTextChangedListener(this.ttI);
        setOnKeyListener(this.ttI);
    }
}
