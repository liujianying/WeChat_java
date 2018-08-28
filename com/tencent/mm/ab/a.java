package com.tencent.mm.ab;

import com.tencent.mm.by.f;
import com.tencent.mm.by.g;
import com.tencent.mm.protocal.c.bhp;
import junit.framework.Assert;

public class a<_Resp extends bhp> {
    b<_Resp> dIs = new b(this);
    private f<a<_Resp>> dIt;
    public b diG;

    public synchronized f<a<_Resp>> KM() {
        Assert.assertNotNull("You should set a CommReqResp!", this.diG);
        Assert.assertTrue("RunCgi NetSceneQueue not ready!", v.LO());
        if (this.dIt == null) {
            this.dIt = g.c(new 1(this));
        }
        return this.dIt;
    }

    public void a(int i, int i2, String str, _Resp _resp, l lVar) {
    }
}
