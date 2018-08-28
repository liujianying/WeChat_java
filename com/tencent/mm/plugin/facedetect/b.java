package com.tencent.mm.plugin.facedetect;

import com.tencent.mm.plugin.facedetect.model.i;
import com.tencent.mm.plugin.facedetect.model.j;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

public final class b implements a<Void, Void> {
    private static j iLR = new j();
    private static n iLS = new n();
    private static i iLT = new i();
    private static l iLU = new l();
    private com.tencent.mm.vending.g.b eAc = null;

    public final /* synthetic */ Object call(Object obj) {
        x.i("MicroMsg.TaskInitFace", "hy: TaskInitFace init");
        this.eAc = g.cBF();
        safeAddListener(iLR);
        safeAddListener(iLS);
        safeAddListener(iLT);
        e.post(new 1(this), "FaceDetectCopyModelFile");
        return null;
    }

    private static void safeAddListener(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
        } else if (com.tencent.mm.sdk.b.a.sFg.d(cVar)) {
            x.w("MicroMsg.TaskInitFace", "hy: already has listener");
        } else {
            com.tencent.mm.sdk.b.a.sFg.b(cVar);
        }
    }
}
