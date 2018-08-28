package com.tencent.mm.plugin.topstory.ui.video;

import org.json.JSONObject;

class l$a implements Runnable {
    private String fWF;
    private boolean nIj;
    final /* synthetic */ l oAz;

    private l$a(l lVar) {
        this.oAz = lVar;
    }

    /* synthetic */ l$a(l lVar, byte b) {
        this(lVar);
    }

    public final void run() {
        try {
            l.a(this.oAz, new JSONObject(this.fWF), this.nIj);
        } catch (Exception e) {
        }
    }
}
