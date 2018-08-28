package com.tencent.mm.plugin.voip_cs.ui;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al.a;

class VoipCSMainUI$18 implements a {
    final /* synthetic */ VoipCSMainUI oYm;

    VoipCSMainUI$18(VoipCSMainUI voipCSMainUI) {
        this.oYm = voipCSMainUI;
    }

    public final boolean vD() {
        Notification notification = new Builder(ad.getContext()).setTicker(this.oYm.tickerText).setContentTitle(this.oYm.title).setContentText(this.oYm.bSc).setContentIntent(PendingIntent.getActivity(ad.getContext(), 44, new Intent(ad.getContext(), VoipCSMainUI.class), 134217728)).setOngoing(true).getNotification();
        notification.icon = com.tencent.mm.bf.a.cbg();
        notification.flags |= 32;
        au.getNotification().a(44, notification, false);
        return true;
    }
}
