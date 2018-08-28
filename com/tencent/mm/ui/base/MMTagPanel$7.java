package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MMTagPanel.c;
import com.tencent.mm.ui.tools.g;

class MMTagPanel$7 implements OnTouchListener {
    final /* synthetic */ MMTagPanel txS;
    final /* synthetic */ c txT;

    MMTagPanel$7(MMTagPanel mMTagPanel, c cVar) {
        this.txS = mMTagPanel;
        this.txT = cVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (MMTagPanel.g(this.txS)) {
            String editText = this.txS.getEditText();
            if (!bi.oW(editText)) {
                if (this.txT != null && g.abd(editText) > this.txT.txZ) {
                    int abe = this.txT.txZ - g.abe(editText);
                    if (abe <= editText.length()) {
                        editText = editText.substring(0, abe);
                    }
                }
                this.txS.bu(editText, true);
                if (MMTagPanel.e(this.txS) != null) {
                    MMTagPanel.e(this.txS).zS(editText);
                }
                this.txS.crN();
            }
        }
        return false;
    }
}
