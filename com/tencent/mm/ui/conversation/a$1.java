package com.tencent.mm.ui.conversation;

import com.tencent.mm.g.a.ae;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<ae> {
    final /* synthetic */ a unj;

    a$1(a aVar) {
        this.unj = aVar;
        this.sFo = ae.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ae aeVar = (ae) bVar;
        com.tencent.mm.pluginsdk.ui.b.b bVar2 = aeVar.bHl.bHn;
        if (bVar2 != null && bVar2.getView() != null) {
            x.i("MicroMsg.BannerHelper", "now add banner:%s, hc:%d", new Object[]{bVar2, Integer.valueOf(this.unj.hashCode())});
            if (!aeVar.bHl.bHm) {
                switch (aeVar.bHl.level) {
                    case 1:
                        this.unj.unb.add(bVar2);
                        break;
                    case 2:
                        this.unj.unc.add(bVar2);
                        break;
                    default:
                        this.unj.und.add(bVar2);
                        break;
                }
            }
            this.unj.una.add(bVar2);
        } else {
            x.w("MicroMsg.BannerHelper", "banner is null, event:%s", new Object[]{aeVar});
        }
        return false;
    }
}
