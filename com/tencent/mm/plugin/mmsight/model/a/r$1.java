package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.mmsight.model.a.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class r$1 implements a {
    final /* synthetic */ r ljJ;

    r$1(r rVar) {
        this.ljJ = rVar;
    }

    public final void output(byte[] bArr) {
        long VG = bi.VG();
        boolean bee = this.ljJ.ljA.bee();
        r rVar = this.ljJ;
        boolean z = bee && this.ljJ.bDs;
        rVar.d(bArr, z);
        j.lin.F(bArr);
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "markStop: %s isEnd %s costTime %d", new Object[]{Boolean.valueOf(this.ljJ.bDs), Boolean.valueOf(bee), Long.valueOf(bi.bI(VG))});
        if (bee && this.ljJ.bDs) {
            this.ljJ.beG();
        }
    }
}
