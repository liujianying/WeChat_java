package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.x;

class ac$1 implements Runnable {
    final /* synthetic */ ac gJf;

    ac$1(ac acVar) {
        this.gJf = acVar;
    }

    public final void run() {
        this.gJf.gJc = true;
        x.v(this.gJf.TAG, "[apptouch] pendingCheckForTap run, pointerDown TRUE");
        this.gJf.gIY.postDelayed(this.gJf.gJe, (long) ViewConfiguration.getLongPressTimeout());
    }
}
