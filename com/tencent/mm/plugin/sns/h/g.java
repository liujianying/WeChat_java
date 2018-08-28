package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.modelsns.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Vector;

public abstract class g {
    private Vector<b> nxP = new Vector();

    public final b b(b bVar) {
        this.nxP.add(bVar);
        return bVar;
    }

    public final boolean c(b bVar) {
        boolean z;
        Iterator it = this.nxP.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2.egS == bVar.egS) {
                this.nxP.remove(bVar2);
                z = true;
                break;
            }
        }
        z = false;
        this.nxP.add(bVar);
        return z;
    }

    public final b bR(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Iterator it = this.nxP.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (obj.equals(bVar.egQ)) {
                    this.nxP.remove(bVar);
                    return bVar;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.Ss_log_base_helper", "report by key " + e.getMessage() + " " + obj);
        }
        return null;
    }
}
