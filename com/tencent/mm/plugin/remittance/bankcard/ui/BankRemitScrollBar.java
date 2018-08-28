package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.AlphabetScrollBar;

public class BankRemitScrollBar extends AlphabetScrollBar {
    public BankRemitScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void aAV() {
        super.aAV();
        this.kuW = new String[]{"☆", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
    }
}
