package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mm.plugin.mmsight.ui.progressbar.b.1;
import com.tencent.mm.plugin.mmsight.ui.progressbar.b.2;
import com.tencent.mm.sdk.platformtools.ag;

class MMSightProgressBar$1 extends ag {
    final /* synthetic */ MMSightProgressBar lrb;

    MMSightProgressBar$1(MMSightProgressBar mMSightProgressBar, Looper looper) {
        this.lrb = mMSightProgressBar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 233 && MMSightProgressBar.a(this.lrb) && MMSightProgressBar.b(this.lrb).size() > 0 && MMSightProgressBar.b(this.lrb).size() < 5) {
            MMSightProgressBar.a(this.lrb, new b((a) MMSightProgressBar.b(this.lrb).get(MMSightProgressBar.b(this.lrb).size() - 1), new a(MMSightProgressBar.b(this.lrb).size(), MMSightProgressBar.c(this.lrb), MMSightProgressBar.d(this.lrb), MMSightProgressBar.aMr()[MMSightProgressBar.b(this.lrb).size()]), new 1(this)));
            b g = MMSightProgressBar.g(this.lrb);
            g.gGc = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
            g.gGc.addUpdateListener(new 1(g));
            g.gGc.addListener(new 2(g));
            g.gGc.setInterpolator(new AccelerateDecelerateInterpolator());
            g.gGc.setDuration(2000);
            g.gGc.start();
        }
    }
}
