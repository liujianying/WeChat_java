package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.storage.ab;

class BottlePersonalInfoUI$3 implements OnClickListener {
    final /* synthetic */ BottlePersonalInfoUI hlw;

    BottlePersonalInfoUI$3(BottlePersonalInfoUI bottlePersonalInfoUI) {
        this.hlw = bottlePersonalInfoUI;
    }

    public final void onClick(View view) {
        new f(this.hlw.mController.tml, ab.XV(q.GF())).cde();
    }
}
