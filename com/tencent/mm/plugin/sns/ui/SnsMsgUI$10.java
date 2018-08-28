package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SnsMsgUI$10 extends a {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$10(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final void a(long j, long j2, String str, int i) {
        super.a(j, j2, str, i);
        x.d("MicroMsg.SnsMsgUI", "summerhardcoder sync fps scene:%s vs %s, droppedFrames:%s, lastFrameNanos:%d, frameNanos:%d", new Object[]{str, this.nYl.getClass().getSimpleName(), Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)});
        if (i > 0 && !bi.oW(str) && str.endsWith(this.nYl.getClass().getSimpleName())) {
            SnsMsgUI.a(this.nYl, SnsMsgUI.b(this.nYl) + ((long) i));
        }
    }
}
