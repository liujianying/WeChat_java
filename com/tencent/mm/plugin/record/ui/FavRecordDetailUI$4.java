package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class FavRecordDetailUI$4 implements Runnable {
    final /* synthetic */ FavRecordDetailUI msF;
    final /* synthetic */ List msL;

    FavRecordDetailUI$4(FavRecordDetailUI favRecordDetailUI, List list) {
        this.msF = favRecordDetailUI;
        this.msL = list;
    }

    public final void run() {
        if (this.msL != null) {
            x.i("MicroMsg.FavRecordDetailUI", "start calc");
            long j = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (vx vxVar : this.msL) {
                if (!(vxVar == null || FavRecordDetailUI.d(this.msF))) {
                    switch (vxVar.bjS) {
                        case 1:
                            i4++;
                            j = ((long) vxVar.desc.getBytes().length) + j;
                            break;
                        case 2:
                            i3++;
                            break;
                        case 4:
                        case 15:
                            i2++;
                            break;
                        default:
                            i++;
                            break;
                    }
                }
            }
            FavRecordDetailUI.a(this.msF, String.format("%s:%s:%s:%s:%s", new Object[]{Integer.valueOf(i4), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)}));
            x.v("MicroMsg.FavRecordDetailUI", "start calc finish %s", new Object[]{r0});
        }
    }
}
