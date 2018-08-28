package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b.a;

class h$1 implements a {
    final /* synthetic */ MMActivity gdk;
    final /* synthetic */ e qbG;
    final /* synthetic */ Point qbH;
    final /* synthetic */ float qbI;

    h$1(e eVar, MMActivity mMActivity, Point point, float f) {
        this.qbG = eVar;
        this.gdk = mMActivity;
        this.qbH = point;
        this.qbI = f;
    }

    public final void kh(boolean z) {
        if (z) {
            ah.A(new 2(this));
            return;
        }
        x.i("MicroMsg.TransformToBagAniHelper", "convertActivityToTranslucent not drawComplete");
        ah.A(new Runnable() {
            public final void run() {
                h$1.this.qbG.bWQ();
            }
        });
    }
}
