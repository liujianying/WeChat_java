package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.k;

class ShakeMsgListUI$5 implements OnItemLongClickListener {
    final /* synthetic */ k hle;
    final /* synthetic */ ShakeMsgListUI mZP;

    ShakeMsgListUI$5(ShakeMsgListUI shakeMsgListUI, k kVar) {
        this.mZP = shakeMsgListUI;
        this.hle = kVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < ShakeMsgListUI.f(this.mZP).getHeaderViewsCount()) {
            x.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
        } else {
            this.hle.a(view, i, j, this.mZP.mController.tml, ShakeMsgListUI.h(this.mZP));
        }
        return true;
    }
}
