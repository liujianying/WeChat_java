package com.tencent.mm.plugin.nearlife.ui;

import android.view.View;
import android.view.View.OnClickListener;

class BaseLifeUI$1 implements OnClickListener {
    final /* synthetic */ BaseLifeUI lDH;

    BaseLifeUI$1(BaseLifeUI baseLifeUI) {
        this.lDH = baseLifeUI;
    }

    public final void onClick(View view) {
        BaseLifeUI.a(this.lDH);
    }
}
