package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$1 implements Runnable {
    final /* synthetic */ b iLV;

    b$1(b bVar) {
        this.iLV = bVar;
    }

    public final void run() {
        String aJY = o.aJY();
        String aJZ = o.aJZ();
        x.i("MicroMsg.TaskInitFace", "alvinluo detectmodel: %s, exist: %b, alignModel: %s, exist: %b", new Object[]{aJY, Boolean.valueOf(a.cn(aJY)), aJZ, Boolean.valueOf(a.cn(aJZ))});
        if (!a.cn(aJY)) {
            x.i("MicroMsg.TaskInitFace", "alvinluo copy detect model file");
            o.p(ad.getContext(), "face_detect" + File.separator + "ufdmtcc.bin", aJY);
        }
        if (!r3) {
            x.i("MicroMsg.TaskInitFace", "alvinluo copy alignment model file");
            o.p(ad.getContext(), "face_detect" + File.separator + "ufat.bin", aJZ);
        }
    }
}
