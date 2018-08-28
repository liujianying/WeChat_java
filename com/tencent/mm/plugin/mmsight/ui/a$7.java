package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.mm.plugin.mmsight.segment.c$a;
import com.tencent.mm.plugin.mmsight.ui.a.10;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class a$7 implements c$a {
    final /* synthetic */ a lpk;

    a$7(a aVar) {
        this.lpk = aVar;
    }

    public final void gw(boolean z) {
        if (z) {
            x.e("MicroMsg.MMSightVideoEditor", "Not Supported init SegmentSeekBar failed.");
            ah.A(new 1(this));
        } else if (this.lpk.loS != null) {
            this.lpk.loU = this.lpk.loS.getDurationMs();
            x.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared success %d", new Object[]{Integer.valueOf(this.lpk.loU)});
            try {
                if (this.lpk.lkZ != null) {
                    this.lpk.loV = Math.round(((float) this.lpk.loU) * this.lpk.loS.beM());
                    this.lpk.loW = Math.round(((float) this.lpk.loU) * this.lpk.loS.beN());
                    if (this.lpk.loW <= 0) {
                        if (this.lpk.loU <= (this.lpk.lfT.duration * BaseReportManager.MAX_READ_COUNT) + 500) {
                            this.lpk.loW = this.lpk.loU;
                        } else {
                            this.lpk.loW = this.lpk.lfT.duration * BaseReportManager.MAX_READ_COUNT;
                        }
                    }
                    x.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared, start: %s, end: %s, duration: %s", new Object[]{Integer.valueOf(this.lpk.loV), Integer.valueOf(this.lpk.loW), Integer.valueOf(this.lpk.loU)});
                }
                a aVar = this.lpk;
                aVar.loX = new al(Looper.getMainLooper(), new 10(aVar), true);
                aVar.loX.J(20, 20);
            } catch (Exception e) {
            }
        }
    }
}
