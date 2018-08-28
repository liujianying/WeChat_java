package com.tencent.mm.plugin.downloader.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class FileDownloadNotificationClickReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.FileDownloadNotificationClickReceiver", "onReceive");
        String bQ = bi.bQ(context);
        x.i("MicroMsg.FileDownloadNotificationClickReceiver", "topActivityName = " + bQ);
        Bundle extras = intent.getExtras();
        if (bi.oV(bQ).equals("com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI")) {
            qw qwVar = new qw();
            qwVar.cbF.bundle = extras;
            a.sFg.m(qwVar);
            return;
        }
        Intent intent2 = new Intent(context, FileDownloadConfirmUI.class);
        intent2.putExtras(extras);
        intent2.setFlags(268435456);
        context.startActivity(intent2);
    }
}
