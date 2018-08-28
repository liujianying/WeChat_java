package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.ui.p.7;

class p$7$2 implements OnClickListener {
    final /* synthetic */ 7 mLu;

    p$7$2(7 7) {
        this.mLu = 7;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mLu.mLr.mLh = false;
        this.mLu.mLr.mLi = false;
        l.mFT.reset();
        l.mFT.vy(l.mFQ);
        if (this.mLu.mLr.mKp != null) {
            this.mLu.mLr.mKp.hu(false);
            this.mLu.mLr.mKp.eu(this.mLu.mLr.mKC);
        }
    }
}
