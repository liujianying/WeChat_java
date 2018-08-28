package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.pluginsdk.ui.tools.n.1;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

class n$1$1 implements Runnable {
    final /* synthetic */ View gvo;
    final /* synthetic */ 1 qTT;

    n$1$1(1 1, View view) {
        this.qTT = 1;
        this.gvo = view;
    }

    public final void run() {
        int height = (this.gvo.getResources().getDisplayMetrics().heightPixels - this.gvo.getHeight()) >>> 1;
        int height2 = (int) ((((double) height) / 1.618d) - ((double) (this.qTT.qTS.getHeight() >>> 1)));
        if (height2 >= 0) {
            if (n.qTR < 0) {
                n.qTR = b.b(this.gvo.getContext(), 20.0f);
            }
            if ((this.qTT.qTS.getHeight() + height2) + n.qTR > height) {
                height = height2 - (((this.qTT.qTS.getHeight() + height2) + n.qTR) - height);
            } else {
                height = height2;
            }
            LayoutParams layoutParams = (LayoutParams) this.qTT.qTS.getLayoutParams();
            if (height > 0 && height != layoutParams.bottomMargin) {
                x.i("VideoSightHelper", "setting tip marginBottom " + height);
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, height);
                this.qTT.qTS.setLayoutParams(layoutParams);
            }
        }
    }
}
