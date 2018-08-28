package com.tencent.mm.plugin.gallery.view;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class MultiGestureImageView$j extends ag {
    WeakReference<MultiGestureImageView> YB;
    boolean ccd;
    final /* synthetic */ MultiGestureImageView jFj;
    private long jFr;

    public MultiGestureImageView$j(MultiGestureImageView multiGestureImageView, WeakReference<MultiGestureImageView> weakReference) {
        this.jFj = multiGestureImageView;
        this.YB = weakReference;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        removeMessages(message.what);
        if (this.YB != null) {
            MultiGestureImageView multiGestureImageView = (MultiGestureImageView) this.YB.get();
            if (multiGestureImageView == null) {
                return;
            }
            if (message.what == 0) {
                if (MultiGestureImageView.a(multiGestureImageView) == 1 || this.ccd) {
                    x.d("MicroMsg.MuitlGestureImageView", "single click over!");
                    if (MultiGestureImageView.b(multiGestureImageView) != null) {
                        multiGestureImageView.getHandler().post(new 1(this, multiGestureImageView));
                    }
                }
                MultiGestureImageView.c(this.jFj);
            } else if (message.what != 1) {
                removeMessages(2);
                if (MultiGestureImageView.f(multiGestureImageView) != null) {
                    multiGestureImageView.getHandler().post(new 2(this, multiGestureImageView));
                }
            } else if (MultiGestureImageView.d(this.jFj) == null || MultiGestureImageView.d(this.jFj).aSc()) {
                MultiGestureImageView.e(multiGestureImageView);
            } else {
                MultiGestureImageView.d(this.jFj).play();
                sendEmptyMessageDelayed(message.what, this.jFr);
            }
        }
    }

    public final void h(int i, long j, long j2) {
        this.jFr = j2;
        sendEmptyMessageDelayed(i, j);
    }
}
