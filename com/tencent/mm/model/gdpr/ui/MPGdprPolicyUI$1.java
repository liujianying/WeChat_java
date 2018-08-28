package com.tencent.mm.model.gdpr.ui;

import android.os.Bundle;
import com.tencent.mm.ab.a;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.e;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.blz;
import com.tencent.mm.sdk.platformtools.bi;

class MPGdprPolicyUI$1 implements e {
    final /* synthetic */ MPGdprPolicyUI dEr;

    MPGdprPolicyUI$1(MPGdprPolicyUI mPGdprPolicyUI) {
        this.dEr = mPGdprPolicyUI;
    }

    public final boolean Jn() {
        this.dEr.runOnUiThread(new 1(this));
        return true;
    }

    public final void Jo() {
        this.dEr.runOnUiThread(new 2(this));
    }

    public final void Jp() {
        this.dEr.runOnUiThread(new 3(this));
    }

    public final boolean c(int i, Bundle bundle) {
        if (i == 200) {
            boolean z = bundle.getBoolean("OnMPGdprPolicyAgreement_KIsAgree", false);
            MPGdprPolicyUI.a(this.dEr, z);
            MPGdprPolicyUI.b(this.dEr);
            if (!(!z || bi.oW(MPGdprPolicyUI.c(this.dEr)) || MPGdprPolicyUI.d(this.dEr).dEf == 0)) {
                a aVar = new a();
                bly bly = new bly();
                bly.bPS = MPGdprPolicyUI.c(this.dEr);
                bly.scene = MPGdprPolicyUI.d(this.dEr).dEf;
                b.a aVar2 = new b.a();
                aVar2.dIG = bly;
                aVar2.dIH = new blz();
                aVar2.dIF = 2734;
                aVar2.uri = "/cgi-bin/mmbiz-bin/wxabusiness/setgdrpauth";
                aVar.diG = aVar2.KT();
                aVar.KM();
            }
        }
        return false;
    }
}
