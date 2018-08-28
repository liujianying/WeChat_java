package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.b.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ah;

class FavRecordDetailUI$1 implements a {
    final /* synthetic */ FavRecordDetailUI msF;

    FavRecordDetailUI$1(FavRecordDetailUI favRecordDetailUI) {
        this.msF = favRecordDetailUI;
    }

    public final void a(String str, l lVar) {
        if (lVar != null && lVar.obj != null) {
            long longValue = ((Long) lVar.obj).longValue();
            if (longValue >= 0 && FavRecordDetailUI.a(this.msF) == longValue) {
                g eo = b.eo(FavRecordDetailUI.a(this.msF));
                b bVar = new b();
                bVar.msw = eo;
                if (eo != null && eo.field_favProto != null) {
                    bVar.msv = eo.field_favProto.rBI;
                    ah.A(new 1(this, bVar));
                }
            }
        }
    }
}
