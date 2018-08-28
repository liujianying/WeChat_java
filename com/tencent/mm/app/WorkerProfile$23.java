package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.e.i;

class WorkerProfile$23 extends c<ja> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$23(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = ja.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ja jaVar = (ja) bVar;
        if (jaVar.bSG.aAk != 2 && jaVar.bSG.status == 0) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE");
            ad.getContext().sendBroadcast(intent);
        }
        if (au.HX()) {
            if (jaVar.bSG.aAk == 3) {
                at.dBv.T("login_user_name", "");
            } else {
                at atVar = at.dBv;
                au.HU();
                String str = (String) com.tencent.mm.model.c.DT().get(6, null);
                au.HU();
                int intValue = ((Integer) com.tencent.mm.model.c.DT().get(9, null)).intValue();
                au.HU();
                atVar.c(str, intValue, (String) com.tencent.mm.model.c.DT().get(5, null));
            }
        }
        return false;
    }
}
