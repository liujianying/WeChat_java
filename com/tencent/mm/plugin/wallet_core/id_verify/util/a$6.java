package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class a$6 implements OnClickListener {
    final /* synthetic */ int plc;
    final /* synthetic */ a ple;

    a$6(a aVar, int i) {
        this.ple = aVar;
        this.plc = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e.a(2, bi.VE(), this.plc);
        if (this.ple.pkZ != null && this.ple.pkZ.get() != null) {
            g.Ek();
            g.Eh().dpP.a(385, this.ple);
            ((com.tencent.mm.wallet_core.d.e) this.ple.pkZ.get()).a(new a(this.ple.fdx), true);
        }
    }
}
