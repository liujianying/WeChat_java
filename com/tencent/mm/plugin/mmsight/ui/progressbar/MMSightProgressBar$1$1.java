package com.tencent.mm.plugin.mmsight.ui.progressbar;

import com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar.1;
import com.tencent.mm.plugin.mmsight.ui.progressbar.b.a;
import com.tencent.wcdb.support.Log;

class MMSightProgressBar$1$1 implements a {
    final /* synthetic */ 1 lrc;

    MMSightProgressBar$1$1(1 1) {
        this.lrc = 1;
    }

    public final void a(a aVar) {
        MMSightProgressBar.b(this.lrc.lrb).add(aVar);
        MMSightProgressBar.a(this.lrc.lrb, null);
        if (MMSightProgressBar.b(this.lrc.lrb).size() >= 5) {
            Log.i("MicroMsg.MMSightProgressBar", "progress finish!");
            if (MMSightProgressBar.e(this.lrc.lrb) != null) {
                MMSightProgressBar.e(this.lrc.lrb);
            }
        } else if (MMSightProgressBar.a(this.lrc.lrb)) {
            MMSightProgressBar.f(this.lrc.lrb).sendEmptyMessage(233);
        }
        this.lrc.lrb.invalidate();
    }

    public final void bfv() {
        this.lrc.lrb.invalidate();
    }
}
