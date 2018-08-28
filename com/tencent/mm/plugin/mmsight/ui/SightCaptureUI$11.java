package com.tencent.mm.plugin.mmsight.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.w.a.d;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$11 implements Runnable {
    final /* synthetic */ SightCaptureUI lqr;
    final /* synthetic */ String lqv;

    SightCaptureUI$11(SightCaptureUI sightCaptureUI, String str) {
        this.lqr = sightCaptureUI;
        this.lqv = str;
    }

    public final void run() {
        x.i("MicroMsg.SightCaptureUI", "DEBUG showCameraInfoImpl: %s", new Object[]{this.lqv});
        k.bey();
        if (k.isDebug()) {
            TextView textView = (TextView) this.lqr.findViewById(d.video_debug_info);
            textView.setVisibility(0);
            textView.setText(this.lqv);
        }
    }
}
