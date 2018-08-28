package com.tencent.mm.plugin.label;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements e {
    final /* synthetic */ b kAA;

    b$1(b bVar) {
        this.kAA = bVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
        switch (lVar.getType()) {
            case 635:
                if (i == 0 && i2 == 0) {
                    b.g(this.kAA.username, this.kAA.kAx);
                    return;
                }
                this.kAA.aYG();
                x.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
                return;
            case 638:
                if (i == 0 && i2 == 0) {
                    int i3;
                    int i4;
                    if (this.kAA.kAy == null || this.kAA.kAy.isEmpty()) {
                        i3 = 0;
                    } else {
                        i3 = this.kAA.kAy.size();
                    }
                    if (this.kAA.kAx == null || this.kAA.kAx.isEmpty()) {
                        i4 = 0;
                    } else {
                        i4 = this.kAA.kAx.size() - i3;
                    }
                    if (i3 > 0 || i4 > 0) {
                        x.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                        h.mEJ.h(11220, new Object[]{q.GF(), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(0)});
                    }
                }
                this.kAA.aYG();
                return;
            default:
                return;
        }
    }
}
