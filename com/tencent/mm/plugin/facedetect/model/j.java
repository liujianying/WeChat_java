package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.g.a.hl;
import com.tencent.mm.g.a.hl.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends c<hl> {
    public j() {
        this.sFo = hl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        hl hlVar = (hl) bVar;
        if (hlVar == null) {
            x.e("MicroMsg.FaceGetIsSupportListener", "hy: event is null");
            return false;
        }
        f fVar = f.iNu;
        boolean aJM = f.aJM();
        f fVar2 = f.iNu;
        boolean aJN = f.aJN();
        if (!aJM) {
            hlVar.bQM.bQO = 10001;
            hlVar.bQM.bQP = "No front camera";
        } else if (aJN) {
            hlVar.bQM.bQP = "ok";
        } else {
            hlVar.bQM.bQO = 10002;
            hlVar.bQM.bQP = "No necessary model found";
        }
        a aVar = hlVar.bQM;
        f fVar3 = f.iNu;
        aVar.bQQ = f.aJQ();
        aVar = hlVar.bQM;
        if (aJM && aJN) {
            z = true;
        }
        aVar.bQN = z;
        return true;
    }
}
