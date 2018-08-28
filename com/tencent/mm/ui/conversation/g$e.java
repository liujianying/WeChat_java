package com.tencent.mm.ui.conversation;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.storage.ab;

class g$e {
    private ab guS;
    private boolean initialized;
    private String talker;
    private Integer uoB;
    final /* synthetic */ g uqa;

    public g$e(g gVar) {
        this.uqa = gVar;
        this.initialized = false;
        this.talker = null;
        this.initialized = false;
        this.guS = null;
        this.uoB = null;
    }

    public final void ep(String str) {
        this.talker = str;
        this.guS = null;
        this.uoB = null;
        this.initialized = false;
        if (!ai.oW(str)) {
            this.initialized = true;
        }
    }

    public final ab cyS() {
        if (this.initialized && this.guS == null && au.HX()) {
            au.HU();
            this.guS = c.FR().Yg(this.talker);
        }
        return this.guS;
    }
}
