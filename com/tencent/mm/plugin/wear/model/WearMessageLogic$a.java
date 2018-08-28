package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.e.a;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.sdk.platformtools.x;

class WearMessageLogic$a extends d {
    public int mFO;
    public int pJs;
    public int pJt;
    public byte[] pJu;
    final /* synthetic */ WearMessageLogic pJv;

    private WearMessageLogic$a(WearMessageLogic wearMessageLogic) {
        this.pJv = wearMessageLogic;
    }

    /* synthetic */ WearMessageLogic$a(WearMessageLogic wearMessageLogic, byte b) {
        this(wearMessageLogic);
    }

    protected final void execute() {
        x.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[]{toString()});
        a zG = a.bSl().pIK.zG(this.pJt);
        if (zG != null) {
            zG.b(this.pJs, this.mFO, this.pJt, this.pJu);
        }
    }

    public final String getName() {
        return "HttpMessageTask";
    }

    public final String toString() {
        return String.format("connectType=%d funId=%d sessionId=%d", new Object[]{Integer.valueOf(this.pJs), Integer.valueOf(this.pJt), Integer.valueOf(this.mFO)});
    }
}
