package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

class FreeWifiIntroductionUI$2 implements OnClickListener {
    final /* synthetic */ FreeWifiIntroductionUI jnu;

    FreeWifiIntroductionUI$2(FreeWifiIntroductionUI freeWifiIntroductionUI) {
        this.jnu = freeWifiIntroductionUI;
    }

    public final void onClick(View view) {
        au.HU();
        c.DT().set(303104, Integer.valueOf(1));
        Intent intent = this.jnu.getIntent();
        intent.setClass(this.jnu, FreeWifiEntryUI.class);
        this.jnu.startActivity(intent);
        this.jnu.finish();
    }
}
