package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.sdk.platformtools.x;

class MMTagPanel$6 implements OnClickListener {
    final /* synthetic */ MMTagPanel txS;

    MMTagPanel$6(MMTagPanel mMTagPanel) {
        this.txS = mMTagPanel;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", new Object[]{Boolean.valueOf(MMTagPanel.f(this.txS))});
        if (MMTagPanel.f(this.txS)) {
            this.txS.crR();
            MMTagPanel.a(this.txS).requestFocus();
            MMTagPanel.a(this.txS).setSelection(MMTagPanel.a(this.txS).getText().length());
            ((InputMethodManager) this.txS.getContext().getSystemService("input_method")).showSoftInput(MMTagPanel.a(this.txS), 0);
            x.d("MicroMsg.MMTagPanel", "on content click");
            if (MMTagPanel.e(this.txS) != null) {
                MMTagPanel.e(this.txS).aGt();
            }
        }
    }
}
