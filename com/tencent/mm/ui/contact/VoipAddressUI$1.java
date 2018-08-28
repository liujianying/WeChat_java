package com.tencent.mm.ui.contact;

import com.tencent.mm.g.a.su;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class VoipAddressUI$1 extends c<su> {
    final /* synthetic */ VoipAddressUI umm;

    VoipAddressUI$1(VoipAddressUI voipAddressUI) {
        this.umm = voipAddressUI;
        this.sFo = su.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((su) bVar).cdE.bOh) {
            case 7:
                this.umm.finish();
                break;
            case 8:
                this.umm.finish();
                break;
        }
        return false;
    }
}
