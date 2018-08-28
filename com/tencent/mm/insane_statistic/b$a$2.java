package com.tencent.mm.insane_statistic;

import com.tencent.mm.g.a.mt;
import com.tencent.mm.insane_statistic.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$a$2 extends c<mt> {
    final /* synthetic */ a dlY;

    b$a$2(a aVar) {
        this.dlY = aVar;
        this.sFo = mt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((mt) bVar).bXJ.filePath.equals(this.dlY.dlS)) {
            if (this.dlY.dlV) {
                x.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717), imgLocalId:%d, scene.hash:%d, %s", new Object[]{Long.valueOf(this.dlY.dlN), Integer.valueOf(this.dlY.hashCode()), this.dlY.dlQ});
                h.mEJ.k(13717, this.dlY.dlQ);
            }
            a.a(this.dlY);
        }
        return false;
    }
}
