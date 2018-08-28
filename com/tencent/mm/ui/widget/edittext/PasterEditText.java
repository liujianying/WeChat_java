package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.widget.EditText;

public class PasterEditText extends EditText {
    private Context context;
    private ClipboardManager nVZ = null;
    private int nWa = 0;

    public PasterEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public PasterEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public int getPasterLen() {
        return this.nWa;
    }

    private void init() {
        this.nVZ = (ClipboardManager) this.context.getSystemService("clipboard");
    }

    public boolean onTextContextMenuItem(int i) {
        if (i != 16908322) {
            return super.onTextContextMenuItem(i);
        }
        if (!(this.nVZ == null || this.nVZ.getText() == null || !(this.nVZ.getText() instanceof String) || this.nVZ.getText() == null || this.nVZ.getText().length() <= 0)) {
            this.nWa += this.nVZ.getText().length();
        }
        return super.onTextContextMenuItem(i);
    }
}
