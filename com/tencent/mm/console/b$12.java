package com.tencent.mm.console;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.f.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.e.i;

class b$12 implements OnClickListener {
    final /* synthetic */ Context dhl;
    final /* synthetic */ String dhp;
    final /* synthetic */ Activity mr;

    b$12(String str, Context context, Activity activity) {
        this.dhp = str;
        this.dhl = context;
        this.mr = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        w wVar = new w(aa.duN + "SdcardInfo.cfg");
        wVar.set(1, this.dhp);
        x.i("MicroMsg.CommandProcessor", "switchsdcard reset to sdcard root: " + wVar.get(1));
        af.Wq("welcome_page_show");
        k.j(this.dhl, true);
        y yVar = new y();
        yVar.bHg.bHh = false;
        a.sFg.m(yVar);
        WorkerProfile.vt().bzN.vo();
        au.getNotification().xR();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        ad.getContext().sendBroadcast(intent);
        if (e.qBn != null) {
            e.qBn.bc(this.mr);
        }
        this.mr.finish();
    }
}
