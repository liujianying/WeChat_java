package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.sdk.platformtools.x;

class BakOperatingUI$7 implements OnClickListener {
    final /* synthetic */ BakOperatingUI haO;

    BakOperatingUI$7(BakOperatingUI bakOperatingUI) {
        this.haO = bakOperatingUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e asO = a.asN().asO();
        if (asO.gZR == 1) {
            asO.gZN.resume();
        } else if (asO.gZR == 6) {
            asO.gZO.resume();
        } else {
            x.e("MicroMsg.BakPcProcessMgr", "cancel in error state, %d", new Object[]{Integer.valueOf(asO.gZR)});
        }
    }
}
