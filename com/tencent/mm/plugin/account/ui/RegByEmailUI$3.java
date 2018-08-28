package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;

class RegByEmailUI$3 implements OnCancelListener {
    final /* synthetic */ z ePZ;
    final /* synthetic */ RegByEmailUI eUG;

    RegByEmailUI$3(RegByEmailUI regByEmailUI, z zVar) {
        this.eUG = regByEmailUI;
        this.ePZ = zVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.ePZ);
    }
}
