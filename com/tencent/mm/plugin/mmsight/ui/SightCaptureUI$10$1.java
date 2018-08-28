package com.tencent.mm.plugin.mmsight.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.10;
import com.tencent.mm.plugin.w.a.d;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$10$1 implements Runnable {
    final /* synthetic */ String lqv;
    final /* synthetic */ 10 lqw;

    SightCaptureUI$10$1(10 10, String str) {
        this.lqw = 10;
        this.lqv = str;
    }

    public final void run() {
        x.i("MicroMsg.SightCaptureUI", "DEBUG showDebugInfo %s", new Object[]{this.lqv});
        k.bey();
        if (k.isDebug()) {
            TextView textView = (TextView) this.lqw.lqr.findViewById(d.video_debug_info);
            textView.setVisibility(0);
            textView.setText(this.lqv);
        }
    }
}
