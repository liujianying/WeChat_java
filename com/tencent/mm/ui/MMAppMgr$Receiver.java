package com.tencent.mm.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Process;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.booter.o;
import com.tencent.mm.model.au;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.pluginsdk.model.app.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class MMAppMgr$Receiver extends BroadcastReceiver {
    private MMAppMgr appMgr;

    public MMAppMgr$Receiver(MMAppMgr mMAppMgr) {
        this.appMgr = mMAppMgr;
    }

    private static boolean au(Intent intent) {
        if (intent.getBooleanExtra("process_is_mm", false) && intent.getIntExtra("process_id", 0) != Process.myPid()) {
            return false;
        }
        return true;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && !au.HM() && !au.HO()) {
            String action = intent.getAction();
            if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(action)) {
                if (au(intent)) {
                    MMAppMgr.a(this.appMgr, intent, true);
                    this.appMgr.e(intent, true);
                    return;
                }
                x.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", new Object[]{Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid())});
            } else if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(action)) {
                if (au(intent)) {
                    o.xP();
                    MMAppMgr.a(this.appMgr, intent, false);
                    this.appMgr.e(intent, false);
                    if (MMAppMgr.tni != null && MMAppMgr.tni.length() > 800) {
                        new ag(Looper.getMainLooper()).post(new 1(this));
                        return;
                    }
                    return;
                }
                x.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", new Object[]{Integer.valueOf(intent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid())});
            } else if ("com.tencent.mm.ui.ACTION_ABTEST".equals(action)) {
                action = intent.getStringExtra("content");
                if (bi.oW(action)) {
                    x.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
                } else {
                    if (MMAppMgr.tni == null) {
                        MMAppMgr.tni = new StringBuffer(800);
                    }
                    MMAppMgr.tni.append(action);
                    x.i("MicroMsg.MMAppMgr", "cpan content: %s", new Object[]{action});
                }
                if (MMAppMgr.tni != null && MMAppMgr.tni.length() > 800) {
                    new ag(Looper.getMainLooper()).post(new 2(this));
                }
            } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE")) {
                int intExtra;
                if (intent.getBooleanExtra("intent_extra_is_silence_stat", false)) {
                    intExtra = intent.getIntExtra("intent_extra_opcode", 0);
                    x.d("MicroMsg.MMAppMgr", "silence_update_stat = " + intExtra);
                    if (au.HX()) {
                        if (intExtra == 2) {
                            int intExtra2 = intent.getIntExtra("intent_extra_install_dialog_times", 0);
                            h.mEJ.h(11147, new Object[]{Integer.valueOf(intExtra), Integer.valueOf(intExtra2)});
                        } else {
                            h.mEJ.h(11147, new Object[]{Integer.valueOf(intExtra)});
                        }
                        if (intExtra == 4 && i.ccf() == 4) {
                            a cbF = a.cbF();
                            if (cbF != null) {
                                cbF.cbH();
                            }
                        }
                    }
                } else {
                    x.d("MicroMsg.MMAppMgr", "incremental_update = " + intent.getIntExtra("intent_extra_opcode", 0));
                    if (au.HX()) {
                        h.mEJ.h(10328, new Object[]{Integer.valueOf(intExtra)});
                    }
                }
                long longExtra = intent.getLongExtra("intent_extra_flow_stat_upstream", 0);
                long longExtra2 = intent.getLongExtra("intent_extra_flow_stat_downstream", 0);
                boolean booleanExtra = intent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
                if (!au.HX()) {
                    return;
                }
                if (longExtra != 0 || longExtra2 != 0) {
                    x.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", new Object[]{Long.valueOf(longExtra), Long.valueOf(longExtra2), Boolean.valueOf(booleanExtra)});
                    if (booleanExtra) {
                        n.z((int) longExtra2, (int) longExtra, 0);
                    } else {
                        n.A((int) longExtra2, (int) longExtra, 0);
                    }
                }
            } else if (intent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP")) {
                MMAppMgr.h(context, true);
            } else if (intent.getAction().equals("MINIQB_OPEN_RET")) {
                com.tencent.mm.pluginsdk.ui.tools.a.an(intent);
            } else {
                x.e("MicroMsg.MMAppMgr", "unknown broadcast action");
            }
        }
    }
}
