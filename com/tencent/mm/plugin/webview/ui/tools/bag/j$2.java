package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import com.tencent.mm.plugin.webview.ui.tools.bag.a.b;

class j$2 implements b {
    final /* synthetic */ j qcu;

    j$2(j jVar) {
        this.qcu = jVar;
    }

    public final void bWO() {
        j.a(this.qcu, 17);
        Point point = null;
        if (j.b(this.qcu) != null) {
            point = j.b(this.qcu).getLastTouchDownViewPos();
        }
        this.qcu.bWU();
        if (point != null) {
            j.c(this.qcu).qcw = point.x;
            j.c(this.qcu).qcv = point.y;
            j.c(this.qcu).save();
        }
    }
}
