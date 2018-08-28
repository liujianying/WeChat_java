package com.tencent.mm.ui.base;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import java.lang.ref.WeakReference;

public class MMViewPager$k extends ag {
    long jFr;
    WeakReference<MMViewPager> tyY;

    public MMViewPager$k(WeakReference<MMViewPager> weakReference) {
        this.tyY = weakReference;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        removeMessages(message.what);
        if (this.tyY != null) {
            MMViewPager mMViewPager = (MMViewPager) this.tyY.get();
            if (mMViewPager != null && message.what == 1) {
                if (MMViewPager.x(mMViewPager) == null || MMViewPager.x(mMViewPager).aSc()) {
                    MMViewPager.y(mMViewPager);
                    return;
                }
                MMViewPager.x(mMViewPager).play();
                sendEmptyMessageDelayed(message.what, this.jFr);
            }
        }
    }
}
