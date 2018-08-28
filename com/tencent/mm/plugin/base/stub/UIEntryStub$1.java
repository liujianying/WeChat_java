package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.x;

class UIEntryStub$1 implements a {
    final /* synthetic */ UIEntryStub hdI;

    UIEntryStub$1(UIEntryStub uIEntryStub) {
        this.hdI = uIEntryStub;
    }

    public final void a(e eVar) {
        if (eVar == null) {
            this.hdI.finish();
            return;
        }
        x.i("MicroMsg.UIEntryStub", "onResume mHasHandled: %b", new Object[]{Boolean.valueOf(UIEntryStub.a(this.hdI))});
        if (!UIEntryStub.a(this.hdI)) {
            UIEntryStub.b(this.hdI);
            UIEntryStub.a(this.hdI, UIEntryStub.c(this.hdI).getExtras());
        }
    }
}
