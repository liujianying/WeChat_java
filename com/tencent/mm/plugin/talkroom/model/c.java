package com.tencent.mm.plugin.talkroom.model;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.ax.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.talkroom.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements d {
    public String kFP = "";
    public boolean kGt = false;
    ag mHandler = new ag(Looper.getMainLooper());
    public boolean owe = false;
    private Notification owf;
    private String owg;

    private static boolean bGX() {
        if (!bi.oW(b.bGT().owU)) {
            return true;
        }
        x.w("MicroMsg.TalkRoomDisplayMgr", "yy checkServer null");
        x.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        bGZ();
        return false;
    }

    public final void St() {
        this.kGt = false;
    }

    public final void i(String str, int i, int i2) {
        this.kGt = false;
    }

    public final void Su() {
    }

    public final void iA(int i) {
    }

    public final void nr(String str) {
        this.kFP = str;
    }

    public final void ay(String str, String str2) {
        if (!this.owe) {
            bGY();
        }
    }

    public final void b(int i, int i2, String str) {
    }

    public final void Sv() {
        x.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        bGZ();
    }

    public final void Sw() {
    }

    public final void Sx() {
    }

    public final void Sy() {
    }

    public final void Op(String str) {
        if (bGX()) {
            x.v("MicroMsg.TalkRoomDisplayMgr", "yy showNotify: " + str);
            this.owg = str;
            this.owf = new Builder(ad.getContext()).setTicker(str).setWhen(0).getNotification();
            this.owf.icon = R.g.talk_room_notify_ic;
            this.owf.flags = 32;
            bGY();
        }
    }

    private void bGY() {
        if (!bGX()) {
            return;
        }
        if (this.owf == null) {
            x.e("MicroMsg.TalkRoomDisplayMgr", "yy updateNotify error no notification");
            return;
        }
        CharSequence string;
        CharSequence aJ = h.aJ(ad.getContext(), b.bGT().owU);
        if (b.bGT().oxi) {
            string = ad.getContext().getString(R.l.talk_room_pausing);
        } else {
            string = ad.getContext().getString(R.l.talk_room_member_count, new Object[]{Integer.valueOf(b.bGT().aZp().size())});
        }
        Intent vp = a.ezo.vp();
        vp.putExtra("enter_chat_usrname", b.bGT().owU);
        this.owf = new Builder(ad.getContext()).setTicker(this.owg).setWhen(0).setContentTitle(aJ).setContentText(string).setContentIntent(PendingIntent.getActivity(ad.getContext(), 100, vp, 268435456)).getNotification();
        this.owf.icon = R.g.talk_room_notify_ic;
        this.owf.flags = 32;
        au.getNotification().a(100, this.owf, false);
    }

    public static void bGZ() {
        x.v("MicroMsg.TalkRoomDisplayMgr", "yy cancelNotify");
        au.getNotification().cancel(100);
    }
}
