package com.tencent.mm.pluginsdk;

import android.view.View;
import com.tencent.mm.compatible.util.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;

class e$2 implements Runnable {
    final /* synthetic */ MMFragmentActivity qyf;
    final /* synthetic */ View qyg;

    e$2(MMFragmentActivity mMFragmentActivity, View view) {
        this.qyf = mMFragmentActivity;
        this.qyg = view;
    }

    public final void run() {
        this.qyf.getWindow().getDecorView().setSystemUiVisibility(this.qyf.getWindow().getDecorView().getSystemUiVisibility() | 256);
        x.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", new Object[]{Integer.valueOf(a.i(this.qyf))});
        if (this.qyg != null) {
            this.qyg.setPadding(0, r0, 0, 0);
        }
    }
}
