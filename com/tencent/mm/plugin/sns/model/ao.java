package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.qf;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ao {
    boolean emK = false;
    boolean emL = false;
    c nrA = new 3(this);
    long nru = 0;
    private boolean nrv = false;
    int nrw = 0;
    int nrx = 1440;
    c<qf> nry = new 1(this);
    c nrz = new 2(this);

    ao() {
    }

    final boolean byO() {
        String value = g.AT().getValue("SnsImgPreLoadingTimeLimit");
        x.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", new Object[]{value});
        if (bi.oW(value)) {
            return false;
        }
        try {
            String[] split = value.split("-");
            String[] split2 = split[0].split(":");
            this.nrw = bi.WU(split2[1]) + (bi.WU(split2[0]) * 60);
            split = split[1].split(":");
            this.nrx = bi.WU(split[1]) + (bi.WU(split[0]) * 60);
            x.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", new Object[]{Integer.valueOf(this.nrw), Integer.valueOf(this.nrx)});
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
