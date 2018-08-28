package com.tencent.mm.plugin.mmsight.segment;

import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.segment.MMSightEditUI.2;
import com.tencent.mm.plugin.w.a.f;

class MMSightEditUI$2$1 implements Runnable {
    final /* synthetic */ 2 llh;

    MMSightEditUI$2$1(2 2) {
        this.llh = 2;
    }

    public final void run() {
        Toast.makeText(this.llh.llg, f.mmsight_clip_failed, 1).show();
    }
}
