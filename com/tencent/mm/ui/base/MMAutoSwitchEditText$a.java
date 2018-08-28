package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.b;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.d;

public class MMAutoSwitchEditText$a implements TextWatcher, OnKeyListener {
    private String gEw;
    private EditText im;
    int mIndex = 0;
    MMAutoSwitchEditText$c ttJ;
    b ttK;
    d ttL;
    int ttM = 4;

    public MMAutoSwitchEditText$a(EditText editText) {
        this.im = editText;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        this.gEw = editable.toString();
        Object obj = "";
        if (this.ttL != null) {
            this.ttL.crq();
        }
        int i = 0;
        int i2 = 0;
        while (i < this.gEw.length()) {
            i2++;
            if (i2 > this.ttM) {
                break;
            }
            i++;
            String obj2 = obj2 + this.gEw.charAt(i);
        }
        if (i2 > this.ttM) {
            this.im.setText(obj2);
            this.im.setSelection(obj2.length());
        }
        if (i2 >= this.ttM && this.ttJ != null) {
            this.ttJ.Ek(this.mIndex);
        }
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == 67 && this.im.getText().toString().trim().length() == 0 && this.ttK != null) {
            this.ttK.Ej(this.mIndex);
        }
        return false;
    }
}
