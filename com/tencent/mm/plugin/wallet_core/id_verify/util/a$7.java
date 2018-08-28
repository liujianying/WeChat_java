package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class a$7 implements OnClickListener {
    final /* synthetic */ int plc;
    final /* synthetic */ a ple;

    a$7(a aVar, int i) {
        this.ple = aVar;
        this.plc = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e.a(1, bi.VE(), this.plc);
        this.ple.b(1, -1, "cancel", false);
    }
}
