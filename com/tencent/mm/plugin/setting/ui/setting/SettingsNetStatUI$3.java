package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bi;

class SettingsNetStatUI$3 implements OnClickListener {
    final /* synthetic */ SettingsNetStatUI mTe;

    SettingsNetStatUI$3(SettingsNetStatUI settingsNetStatUI) {
        this.mTe = settingsNetStatUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        m Sj = q.Sj();
        int ciY = (int) (bi.ciY() / 86400000);
        av avVar = Sj.ekz;
        synchronized (avVar) {
            avVar.ktS.trimToSize(-1);
            avVar.sIs.clear();
            avVar.bAZ.SO();
            avVar.sIu.SO();
            avVar.bBc = true;
        }
        Sj.dCZ.delete("netstat", null, null);
        k kVar = new k();
        kVar.ejM = ciY;
        kVar.id = -1;
        Sj.b(kVar);
        SettingsNetStatUI.b(this.mTe);
    }
}
