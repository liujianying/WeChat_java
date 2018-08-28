package com.tencent.mm.plugin.collect.ui;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.sdk.platformtools.x;

class CollectMainUI$12 implements a {
    final /* synthetic */ CollectMainUI hYN;

    CollectMainUI$12(CollectMainUI collectMainUI) {
        this.hYN = collectMainUI;
    }

    public final void m(String str, Bitmap bitmap) {
        if (str != null && CollectMainUI.a(this.hYN) != null && str.equals(CollectMainUI.a(this.hYN))) {
            x.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[]{CollectMainUI.a(this.hYN), str});
            this.hYN.aCo();
        }
    }
}
