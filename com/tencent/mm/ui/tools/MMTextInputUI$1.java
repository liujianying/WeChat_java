package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MMTextInputUI$1 implements OnClickListener {
    final /* synthetic */ MMTextInputUI uAI;

    MMTextInputUI$1(MMTextInputUI mMTextInputUI) {
        this.uAI = mMTextInputUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.uAI.YC();
        this.uAI.setResult(0);
        this.uAI.finish();
    }
}
