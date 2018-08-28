package com.tencent.mm.plugin.soter.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.d.a.a;
import com.tencent.d.a.a.a.d;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Signature;
import java.security.SignatureException;

class SoterTestUI$8 implements OnClickListener {
    final /* synthetic */ SoterTestUI onW;

    SoterTestUI$8(SoterTestUI soterTestUI) {
        this.onW = soterTestUI;
    }

    public final void onClick(View view) {
        Signature acC = a.acC("sample_auth_key_name");
        if (acC != null) {
            try {
                acC.update("challenge".getBytes());
                acC.sign();
                x.e("MicroMsg.SoterTestUI", "hy: should NOT happen if no exception");
                SoterTestUI.a(this.onW).setText("not passed: signature success without fingerprint authentication");
                return;
            } catch (SignatureException e) {
                x.e("MicroMsg.SoterTestUI", "hy: occurred exception when sign: " + e.toString());
                com.tencent.d.a.a.a hB = com.tencent.d.a.a.a.hB(this.onW);
                if (hB.isHardwareDetected() && hB.hasEnrolledFingerprints()) {
                    hB.a(new d(acC), null, new 1(this, acC));
                    return;
                } else {
                    x.e("MicroMsg.SoterTestUI", "hy: no hardware detected or no fingerprint registered");
                    return;
                }
            }
        }
        x.e("MicroMsg.SoterTestUI", "hy: signature is null. do sign failed");
    }
}
