package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.g.a.nh;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class m$3 extends c<nh> {
    final /* synthetic */ m mXg;

    m$3(m mVar) {
        this.mXg = mVar;
        this.sFo = nh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((nh) bVar) instanceof nh) {
            h.mEJ.h(10221, new Object[]{Integer.valueOf(r6.bYm.scene)});
        } else {
            x.e("MicroMsg.SubCoreShake", "mismatch event listener for ReportClickFindFriendShakeEvent");
        }
        return false;
    }
}
