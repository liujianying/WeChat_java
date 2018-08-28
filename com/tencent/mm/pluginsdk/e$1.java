package com.tencent.mm.pluginsdk;

import com.tencent.mm.compatible.util.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class e$1 implements Runnable {
    final /* synthetic */ MMActivity gdk;

    e$1(MMActivity mMActivity) {
        this.gdk = mMActivity;
    }

    public final void run() {
        this.gdk.getWindow().getDecorView().setSystemUiVisibility(this.gdk.getWindow().getDecorView().getSystemUiVisibility() | 256);
        x.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to bodyView, height: %d, %d", new Object[]{Integer.valueOf(a.i(this.gdk)), Integer.valueOf(com.tencent.mm.bp.a.fromDPToPix(this.gdk, 2))});
        this.gdk.mController.tlX.setPadding(0, r0 - com.tencent.mm.bp.a.fromDPToPix(this.gdk, 2), 0, 0);
    }
}
