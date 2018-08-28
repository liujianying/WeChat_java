package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;

class BakOperatingUI$6 implements OnClickListener {
    final /* synthetic */ BakOperatingUI haO;

    BakOperatingUI$6(BakOperatingUI bakOperatingUI) {
        this.haO = bakOperatingUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e asO = a.asN().asO();
        asO.gZN.cancel();
        asO.gZO.cancel();
        if (asO.gZR == 1 || asO.gZV == 2) {
            e.mP(4);
        } else if (asO.gZR == 6 || asO.gZV == 4 || asO.gZV == 6) {
            e.mP(7);
        }
        a.asN().asO().gZU = -1;
        c asP = a.asN().asP();
        asP.gZz++;
        BakOperatingUI.b(this.haO);
        BakOperatingUI.g(this.haO);
    }
}
