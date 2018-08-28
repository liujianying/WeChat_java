package com.tencent.mm.ui.base;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.base.MMTagPanel.8;

class MMTagPanel$8$2 implements Runnable {
    final /* synthetic */ View gvo;
    final /* synthetic */ 8 txU;

    MMTagPanel$8$2(8 8, View view) {
        this.txU = 8;
        this.gvo = view;
    }

    public final void run() {
        this.txU.txS.txM.zO(((TextView) this.gvo).getText().toString());
    }
}
