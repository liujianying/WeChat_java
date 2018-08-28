package com.tencent.mm.ui.base;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel.d;

class MMTagPanel$1 implements OnKeyListener {
    final /* synthetic */ MMTagPanel txS;

    MMTagPanel$1(MMTagPanel mMTagPanel) {
        this.txS = mMTagPanel;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && 67 == i) {
            x.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", new Object[]{Integer.valueOf(MMTagPanel.a(this.txS).getSelectionStart()), Integer.valueOf(MMTagPanel.a(this.txS).getSelectionEnd())});
            boolean z = MMTagPanel.a(this.txS).getSelectionStart() == 0 && MMTagPanel.a(this.txS).getSelectionStart() == MMTagPanel.a(this.txS).getSelectionEnd();
            if (z) {
                this.txS.aMU();
                if (!(MMTagPanel.b(this.txS) == null || MMTagPanel.b(this.txS).isEmpty())) {
                    if (!MMTagPanel.c(this.txS) && MMTagPanel.d(this.txS) == null) {
                        MMTagPanel.a(this.txS, (d) MMTagPanel.b(this.txS).getLast());
                        this.txS.a(MMTagPanel.d(this.txS).tye, false, true);
                        MMTagPanel.a(this.txS).setCursorVisible(false);
                    } else if (MMTagPanel.d(this.txS) == null || MMTagPanel.b(this.txS) == null || MMTagPanel.b(this.txS).getLast() == null || bi.oW(MMTagPanel.d(this.txS).tyd) || bi.oW(((d) MMTagPanel.b(this.txS).getLast()).tyd) || MMTagPanel.d(this.txS).tyd.equals(((d) MMTagPanel.b(this.txS).getLast()).tyd)) {
                        String str = ((d) MMTagPanel.b(this.txS).getLast()).tyd;
                        this.txS.removeTag(str);
                        if (MMTagPanel.e(this.txS) != null) {
                            MMTagPanel.e(this.txS).zQ(str);
                        }
                        this.txS.crR();
                    } else {
                        x.i("MicroMsg.MMTagPanel", "change hight");
                        this.txS.crR();
                        MMTagPanel.a(this.txS, (d) MMTagPanel.b(this.txS).getLast());
                        this.txS.a(MMTagPanel.d(this.txS).tye, false, true);
                        MMTagPanel.a(this.txS).setCursorVisible(false);
                    }
                }
            }
        }
        return false;
    }
}
