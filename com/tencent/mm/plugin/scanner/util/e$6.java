package com.tencent.mm.plugin.scanner.util;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.g.a.op;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$6 implements Runnable {
    final /* synthetic */ int bzZ;
    final /* synthetic */ int eeg;
    final /* synthetic */ op hUN;
    final /* synthetic */ e mMX;
    final /* synthetic */ String mMZ;

    e$6(e eVar, op opVar, int i, String str, int i2) {
        this.mMX = eVar;
        this.hUN = opVar;
        this.bzZ = i;
        this.mMZ = str;
        this.eeg = i2;
    }

    public final void run() {
        if (!bi.oW(this.hUN.bZy.Yy)) {
            Toast.makeText(this.mMX.getContext(), this.hUN.bZy.Yy, 1).show();
        } else if (bi.oW(this.hUN.bZy.bZA)) {
            x.w("MicroMsg.QBarStringHandler", "resp url is null!");
        } else if (this.hUN.bZy.actionType == 1) {
            h.a(this.mMX.getContext(), this.hUN.bZy.bZA, this.bzZ, this.mMZ, this.eeg);
        } else {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.hUN.bZy.bZA);
            b.ezn.j(intent, this.mMX.getContext());
        }
        if (this.mMX.mMU != null) {
            this.mMX.mMU.o(3, null);
        }
    }
}
