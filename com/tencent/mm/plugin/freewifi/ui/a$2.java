package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;

class a$2 implements Runnable {
    final /* synthetic */ a jml;

    a$2(a aVar) {
        this.jml = aVar;
    }

    public final void run() {
        View findViewById = a.b(this.jml).findViewById(R.h.free_wifi_tip_view);
        if (ao.getNetType(ad.getContext()) != 0) {
            findViewById.setVisibility(8);
        } else {
            au.Em().H(new 1(this, findViewById));
        }
    }
}
