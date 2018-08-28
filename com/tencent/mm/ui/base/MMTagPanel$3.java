package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.sdk.platformtools.x;

class MMTagPanel$3 implements OnFocusChangeListener {
    final /* synthetic */ MMTagPanel txS;

    MMTagPanel$3(MMTagPanel mMTagPanel) {
        this.txS = mMTagPanel;
    }

    public final void onFocusChange(View view, boolean z) {
        x.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", new Object[]{Boolean.valueOf(z)});
        if (z && MMTagPanel.e(this.txS) != null) {
            MMTagPanel.e(this.txS).aGt();
        }
    }
}
