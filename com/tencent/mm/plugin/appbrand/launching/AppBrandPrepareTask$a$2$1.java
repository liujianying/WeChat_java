package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.2;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ad;

class AppBrandPrepareTask$a$2$1 implements Runnable {
    final /* synthetic */ 2 gfd;

    AppBrandPrepareTask$a$2$1(2 2) {
        this.gfd = 2;
    }

    public final void run() {
        Toast.makeText(ad.getContext(), j.app_brand_account_release_error, 0).show();
        try {
            Intent intent = new Intent();
            intent.addFlags(268435456).addFlags(67108864);
            d.e(ad.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
        } catch (Exception e) {
        }
    }
}
