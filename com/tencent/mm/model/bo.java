package com.tencent.mm.model;

import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import junit.framework.Assert;

public final class bo implements d {
    public final b b(a aVar) {
        boolean z = true;
        by byVar = aVar.dIN;
        Assert.assertTrue(byVar != null);
        if (byVar.rcl == null) {
            z = false;
        }
        Assert.assertTrue(z);
        String str = (String) bl.z(ab.a(byVar.rcl), "tips").get(".tips.tip.url");
        x.v("MicroMsg.SoftwareMsgExtension", "url:" + str);
        au.HU();
        c.DT().set(12308, str);
        return null;
    }

    public final void h(bd bdVar) {
    }
}
