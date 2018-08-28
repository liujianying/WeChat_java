package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ag;

class q$2 extends ag {
    final /* synthetic */ q mLI;

    q$2(q qVar) {
        this.mLI = qVar;
    }

    public final void handleMessage(Message message) {
        if (q.f(this.mLI) != null) {
            this.mLI.mKp.hu(true);
            q.f(this.mLI).setText(R.l.scan_street_view_not_found_tips);
            q.f(this.mLI).setVisibility(0);
        }
    }
}
