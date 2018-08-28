package com.tencent.mm.model;

import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Map;

public final class bw implements d {
    public final b b(a aVar) {
        by byVar = aVar.dIN;
        if (byVar == null) {
            x.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
        } else {
            try {
                Map z = bl.z("<root>" + byVar.rcl + "</root>", "root");
                int intValue = Integer.valueOf((String) z.get(".root.newcount")).intValue();
                int intValue2 = Integer.valueOf((String) z.get(".root.version")).intValue();
                au.HU();
                com.tencent.mm.storage.x DT = c.DT();
                if (intValue2 == bi.f((Integer) DT.get(12305, null))) {
                    x.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
                } else {
                    DT.set(12304, Integer.valueOf(intValue));
                    DT.set(12305, Integer.valueOf(intValue2));
                }
            } catch (Throwable e) {
                x.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", new Object[]{bi.i(e)});
            }
        }
        return null;
    }

    public final void h(bd bdVar) {
    }
}
