package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.sdk.platformtools.x;

class a$4 implements a {
    final /* synthetic */ a qlZ;

    a$4(a aVar) {
        this.qlZ = aVar;
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, l lVar) {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, l lVar) {
        x.i("MicroMsg.MultiTerminalSyncMgr", "download image msgid:%d, [%d,%d]", new Object[]{Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (i3 == 0 && i4 == 0) {
            this.qlZ.fG(j2);
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }
}
