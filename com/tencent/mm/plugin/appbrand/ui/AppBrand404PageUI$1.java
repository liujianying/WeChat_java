package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ad;

class AppBrand404PageUI$1 implements Runnable {
    final /* synthetic */ String fKy;
    final /* synthetic */ String gtU = null;

    AppBrand404PageUI$1(String str) {
        this.fKy = str;
    }

    public final void run() {
        ad.getContext().startActivity(new Intent(ad.getContext(), AppBrand404PageUI.class).putExtra("key_wording", this.fKy).putExtra("key_icon_url", this.gtU).addFlags(268435456));
    }
}
