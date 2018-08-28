package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.f.d;

class WearMessageLogic$c extends d {
    final /* synthetic */ WearMessageLogic pJv;

    private WearMessageLogic$c(WearMessageLogic wearMessageLogic) {
        this.pJv = wearMessageLogic;
    }

    /* synthetic */ WearMessageLogic$c(WearMessageLogic wearMessageLogic, byte b) {
        this(wearMessageLogic);
    }

    protected final void execute() {
        if (a.bSl().pIM.bSr() != null) {
            a.bSl().pIM.bSr().bSt();
        }
    }

    public final String getName() {
        return "RefreshConnectTask";
    }
}
