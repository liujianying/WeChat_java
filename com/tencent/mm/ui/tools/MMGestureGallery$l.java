package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class MMGestureGallery$l extends ag {
    private boolean ccd;
    private long jFr;
    WeakReference<MMGestureGallery> tyY;

    public MMGestureGallery$l(WeakReference<MMGestureGallery> weakReference) {
        this.tyY = weakReference;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        removeMessages(message.what);
        if (this.tyY != null) {
            MMGestureGallery mMGestureGallery = (MMGestureGallery) this.tyY.get();
            if (mMGestureGallery == null) {
                return;
            }
            if (message.what == 0) {
                if (MMGestureGallery.o(mMGestureGallery) == 1 || this.ccd) {
                    x.d("MicroMsg.MMGestureGallery", "single click over!");
                    if (MMGestureGallery.h(mMGestureGallery) != null) {
                        MMGestureGallery.c(mMGestureGallery).post(new 1(this, mMGestureGallery));
                    }
                }
                MMGestureGallery.a(mMGestureGallery, 0);
            } else if (message.what != 1) {
                removeMessages(2);
                if (MMGestureGallery.T(mMGestureGallery) != null) {
                    MMGestureGallery.c(mMGestureGallery).post(new 2(this, mMGestureGallery));
                }
            } else if (MMGestureGallery.R(mMGestureGallery) == null || MMGestureGallery.R(mMGestureGallery).aSc()) {
                MMGestureGallery.S(mMGestureGallery);
            } else {
                MMGestureGallery.R(mMGestureGallery).play();
                sendEmptyMessageDelayed(message.what, this.jFr);
            }
        }
    }

    public final void h(int i, long j, long j2) {
        this.jFr = j2;
        sendEmptyMessageDelayed(i, j);
    }

    public final void w(long j, boolean z) {
        this.ccd = z;
        h(0, j, 0);
    }

    public final void release() {
        removeMessages(0);
        removeMessages(1);
        removeMessages(2);
    }
}
