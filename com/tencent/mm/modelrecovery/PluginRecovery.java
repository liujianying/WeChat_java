package com.tencent.mm.modelrecovery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.g.a.my;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.recovery.RecoveryContext;
import com.tencent.recovery.RecoveryLogic;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;

public class PluginRecovery extends f implements c {
    private com.tencent.mm.sdk.b.c<my> edh = new com.tencent.mm.sdk.b.c<my>() {
        {
            this.sFo = my.class.getName().hashCode();
        }

        private static boolean a(my myVar) {
            Context context;
            Builder builder;
            switch (myVar.bYa.action) {
                case 1:
                    context = ad.getContext();
                    builder = new Builder();
                    builder.vhz = WXRecoveryHandleService.class.getName();
                    builder.vhA = WXRecoveryUploadService.class.getName();
                    builder.clientVersion = d.CLIENT_VERSION;
                    builder.vhv = String.format("file:///sdcard/test-recovery.conf", new Object[0]);
                    builder.fMk = WXUtil.hp(context);
                    RecoveryLogic.a(context, builder.cEZ(), new RecoveryContext());
                    break;
                case 2:
                    a.Qr();
                    break;
                case 3:
                    context = ad.getContext();
                    builder = new Builder();
                    builder.vhz = WXRecoveryHandleService.class.getName();
                    builder.vhA = WXRecoveryUploadService.class.getName();
                    builder.clientVersion = d.CLIENT_VERSION;
                    builder.vhv = "http://dldir1.qq.com/weixin/android/recovery-0x26032011.conf";
                    builder.fMk = WXUtil.hp(context);
                    RecoveryLogic.a(context, builder.cEZ(), new RecoveryContext());
                    break;
            }
            return false;
        }
    };
    private RecoveryLogImpl edi = new 5(this);
    private BroadcastReceiver rj = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            if ("com.tecent.recovery.intent.action.LOG".equals(intent.getAction())) {
                PluginRecovery.this.postLog();
            } else if ("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD".equals(intent.getAction())) {
                PluginRecovery.this.postReport();
            }
        }
    };

    public void configure(g gVar) {
        RecoveryLog.a(this.edi);
        if (gVar.gn(":sandbox")) {
            long currentTimeMillis = System.currentTimeMillis();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tecent.recovery.intent.action.LOG");
            intentFilter.addAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
            ad.getContext().registerReceiver(this.rj, intentFilter);
            File file = new File(WXConstantsRecovery.vhL);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, "version.info");
            if (file2.exists()) {
                file2.delete();
            }
            try {
                FileOp.l(file2.getAbsolutePath(), Integer.toHexString(com.tencent.mm.protocal.d.qVN).getBytes());
            } catch (Exception e) {
            }
            x.i("MicroMsg.Recovery.PluginRecovery", "add recovery intent filter and save client verison file %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }

    public void execute(g gVar) {
    }

    public void onAccountInitialized(e.c cVar) {
        this.edh.cht();
    }

    public void onAccountRelease() {
        this.edh.dead();
    }

    private void postLog() {
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.Recovery.PluginRecovery", "postLog");
                a.Qr();
            }
        }, "RecoveryWriteLogThread");
    }

    private void postReport() {
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.Recovery.PluginRecovery", "postReport");
                b.Qs();
            }
        }, "RecoveryReportStatusThread");
    }
}
