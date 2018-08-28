package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SnsUserUI$11 extends a {
    final /* synthetic */ SnsUserUI ohd;

    SnsUserUI$11(SnsUserUI snsUserUI) {
        this.ohd = snsUserUI;
    }

    public final void a(long j, long j2, String str, int i) {
        super.a(j, j2, str, i);
        x.d("MicroMsg.SnsUserUI", "summerhardcoder sync fps scene:%s vs %s, droppedFrames:%s, lastFrameNanos:%d, frameNanos:%d", new Object[]{str, this.ohd.getClass().getSimpleName(), Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)});
        if (i > 0 && !bi.oW(str) && str.endsWith(this.ohd.getClass().getSimpleName())) {
            SnsUserUI.a(this.ohd, SnsUserUI.i(this.ohd) + ((long) i));
        }
    }
}
