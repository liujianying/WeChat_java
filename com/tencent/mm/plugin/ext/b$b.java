package com.tencent.mm.plugin.ext;

import com.tencent.mm.g.a.fh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public class b$b extends c<fh> {
    public final /* synthetic */ boolean a(b bVar) {
        fh fhVar = (fh) bVar;
        if (fhVar.bNx == null) {
            x.e("MicroMsg.SubCoreExt", "StepCount revent.data is null");
        } else {
            x.i("MicroMsg.SubCoreExt", " action = " + fhVar.bNx.action);
            if (fhVar.bNx.action == 1) {
                b.aIP();
                x.d("MicroMsg.SubCoreExt", " sendBroadcast");
                return true;
            }
        }
        return false;
    }

    public b$b() {
        super(0);
        this.sFo = fh.class.getName().hashCode();
    }
}
