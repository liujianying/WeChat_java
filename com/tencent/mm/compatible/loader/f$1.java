package com.tencent.mm.compatible.loader;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class f$1 extends bd<String> {
    final /* synthetic */ f dfO;

    public f$1(f fVar) {
        this.dfO = fVar;
        super(2000, null, (byte) 0);
    }

    private static String zS() {
        while (true) {
            String an = bi.an(ad.getContext(), Process.myPid());
            if (an != null) {
                return an;
            }
            try {
                Thread.sleep(100);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ProfileFactoryImpl", e, "", new Object[0]);
            }
        }
    }
}
