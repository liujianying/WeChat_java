package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.qf;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Date;

class ao$1 extends c<qf> {
    final /* synthetic */ ao nrB;

    ao$1(ao aoVar) {
        this.nrB = aoVar;
        this.sFo = qf.class.getName().hashCode();
    }

    private boolean byP() {
        int minutes;
        int i = 1200;
        ao aoVar = this.nrB;
        try {
            if (aoVar.byO()) {
                Date date = new Date();
                minutes = date.getMinutes() + (date.getHours() * 60);
                if (minutes >= aoVar.nrw && minutes <= aoVar.nrx) {
                    x.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", new Object[]{Integer.valueOf(minutes), Integer.valueOf(aoVar.nrw), Integer.valueOf(aoVar.nrx)});
                    return false;
                }
            }
        } catch (Exception e) {
        }
        int i2 = g.AT().getInt("SnsImgPreLoadingSmallImage", 1);
        int i3 = g.AT().getInt("SnsImgPreLoadingBigImage", 1);
        int i4 = g.AT().getInt("SnsPreLoadingVideo", 1);
        minutes = g.AT().getInt("SnsImgPreLoadingInterval", 1200);
        x.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minutes)});
        if (i2 > 0 || i3 > 0 || i4 > 0) {
            if (minutes > 0) {
                i = minutes;
            }
            if (aoVar.emK || aoVar.emL || bi.bG(aoVar.nru) < ((long) i)) {
                x.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", new Object[]{Boolean.valueOf(aoVar.emK), Boolean.valueOf(aoVar.emL)});
            } else if (y.Mb("@__weixintimtline")) {
                com.tencent.mm.kernel.g.Ek();
                if (!com.tencent.mm.kernel.g.Eh().dpP.a(new t(), 0)) {
                    x.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                    y.Mc("@__weixintimtline");
                }
                aoVar.nru = bi.VE();
            } else {
                x.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
            }
        }
        return false;
    }
}
