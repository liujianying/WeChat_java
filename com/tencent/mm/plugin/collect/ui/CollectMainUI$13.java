package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

class CollectMainUI$13 implements OnClickListener {
    final /* synthetic */ List eRE;
    final /* synthetic */ CollectMainUI hYN;

    CollectMainUI$13(CollectMainUI collectMainUI, List list) {
        this.hYN = collectMainUI;
        this.eRE = list;
    }

    public final void onClick(View view) {
        d dVar = new d(this.hYN.mController.tml, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this);
        dVar.bXO();
    }
}
