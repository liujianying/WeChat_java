package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.bj;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class af$29 extends c<bj> {
    final /* synthetic */ af nqT;

    af$29(af afVar) {
        this.nqT = afVar;
        this.sFo = bj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        m bys = af.bys();
        System.currentTimeMillis();
        boolean fV = bys.diF.fV("snsExtInfo3", "update snsExtInfo3 set md5 = '', faults = '';");
        x.i("MicroMsg.SnsExtStorage", "clean Error sql %s ret  %s", new Object[]{"update snsExtInfo3 set md5 = '', faults = '';", Boolean.valueOf(fV)});
        return false;
    }
}
