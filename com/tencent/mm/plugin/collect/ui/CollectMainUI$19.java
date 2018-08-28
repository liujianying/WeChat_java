package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.a.d;

class CollectMainUI$19 implements OnLongClickListener {
    final /* synthetic */ CollectMainUI hYN;

    CollectMainUI$19(CollectMainUI collectMainUI) {
        this.hYN = collectMainUI;
    }

    public final boolean onLongClick(View view) {
        if (CollectMainUI.b(this.hYN) == 0) {
            k kVar = new k(this.hYN.mController.tml);
            kVar.ofp = new 1(this);
            kVar.ofq = new 2(this);
            kVar.bEo();
        } else {
            d dVar = new d(this.hYN.mController.tml, 1, false);
            dVar.ofp = new 3(this);
            dVar.ofq = new 4(this);
            dVar.bXO();
        }
        return true;
    }
}
