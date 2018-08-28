package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class BizTimeLineUI$1 implements OnClickListener {
    final /* synthetic */ BizTimeLineUI hst;

    BizTimeLineUI$1(BizTimeLineUI bizTimeLineUI) {
        this.hst = bizTimeLineUI;
    }

    public final void onClick(View view) {
        this.hst.startActivity(new Intent(this.hst.mController.tml, BizTimeLineNewMsgUI.class));
    }
}
