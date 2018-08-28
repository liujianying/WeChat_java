package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class NearLifeCreatePoiUI$2 implements OnClickListener {
    final /* synthetic */ NearLifeCreatePoiUI lEr;

    NearLifeCreatePoiUI$2(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.lEr = nearLifeCreatePoiUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.lEr.mController.tml, SelectPoiCategoryUI.class);
        this.lEr.startActivityForResult(intent, 2);
    }
}
