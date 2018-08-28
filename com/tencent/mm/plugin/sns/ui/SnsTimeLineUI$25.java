package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$25 extends a {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$25(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void a(long j, long j2, String str, int i) {
        super.a(j, j2, str, i);
        x.d("MicroMsg.SnsTimeLineUI", "summerhardcoder sync fps scene:%s vs %s, droppedFrames:%s, lastFrameNanos:%d, frameNanos:%d", new Object[]{str, this.odw.getClass().getSimpleName(), Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)});
        if (i > 0 && !bi.oW(str) && str.endsWith(this.odw.getClass().getSimpleName())) {
            SnsTimeLineUI.b(this.odw, SnsTimeLineUI.A(this.odw) + ((long) i));
        }
    }
}
