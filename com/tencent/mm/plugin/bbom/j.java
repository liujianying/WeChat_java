package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.booter.notification.a.d;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.booter.notification.c;
import com.tencent.mm.booter.notification.e;
import com.tencent.mm.booter.notification.f.a;
import com.tencent.mm.k.f;
import com.tencent.mm.plugin.zero.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;

public final class j implements b {
    public final void a(long j, String str, String str2, String str3, String str4, int i) {
        if (bi.oW(str2)) {
            str2 = ad.getContext().getString(f.fq(str) ? R.l.chatting_roominfo_noname : R.l.intro_title);
        }
        e eVar = a.ya().cYU;
        if (!f.Al()) {
            e.cancel();
        }
        try {
            c cVar = eVar.cYM;
            Context context = ad.getContext();
            boolean yj = com.tencent.mm.booter.notification.a.e.yj();
            boolean yh = com.tencent.mm.booter.notification.a.e.yh();
            x.i("MicroMsg.Notification.AppMsg.Handle", "push:isShake: %B, isSound: %B", new Object[]{Boolean.valueOf(yj), Boolean.valueOf(yh)});
            if (j == 0) {
                return;
            }
            if (bi.oW(str) || bi.oW(str2) || bi.oW(str3)) {
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION] Util.isNullOrNil(userName) || Util.isNullOrNil(nickName) || Util.isNullOrNil(content)");
            } else if (f.AL() && !f.AM()) {
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck");
            } else if (!f.Aj()) {
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]new MsgNotification setting no notification");
            } else if (c.aJ(j)) {
                x.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION]already notify");
            } else {
                com.tencent.mm.booter.notification.queue.b.yb().restore();
                int xW = c.xW() + 1;
                c.a a = c.a(c.xX(), str);
                int i2 = (a == null ? 0 : a.cYz) + 1;
                ArrayList xX = c.xX();
                if (xX == null) {
                    xX = new ArrayList();
                }
                c.a a2 = c.a(xX, str);
                if (a2 == null) {
                    a2 = new c.a((byte) 0);
                    a2.userName = str;
                    a2.cYz = 1;
                    xX.add(a2);
                } else {
                    a2.cYz++;
                }
                c.d(xX);
                c.fs(c.xW() + 1);
                int size = xX.size();
                if (com.tencent.mm.booter.notification.a.e.yg()) {
                    yh = false;
                    yj = false;
                }
                Notification xV = c.xV();
                int eM = com.tencent.mm.booter.notification.queue.b.yb().eM(str);
                cVar.bzK.cZz = xW;
                cVar.bzK.cZy = size;
                cVar.bzK.cZF = yj;
                cVar.bzK.cZE = yh;
                boolean Al = f.Al();
                int cbg = com.tencent.mm.bf.a.cbg();
                g gVar = cVar.bzK;
                gVar.cZr.a(gVar.mContext, yh, yj, xV, null);
                int i3 = gVar.cZr.cZe;
                x.i("MicroMsg.NotificationIntent", "[oneliang] notificationId:%s, userName:%s, msgType:%s, unReadMsgCount:%s, unReadTalkerCount:%s, isMuted:%s, isShowDetails:%s", new Object[]{Integer.valueOf(eM), str, Integer.valueOf(i), Integer.valueOf(xW), Integer.valueOf(size), Boolean.valueOf(false), Boolean.valueOf(Al)});
                Intent intent = new Intent(context, LauncherUI.class);
                intent.putExtra("nofification_type", "new_msg_nofification");
                intent.putExtra("Main_User", str);
                intent.putExtra("MainUI_User_Last_Msg_Type", i);
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                if (Al) {
                    intent.putExtra("talkerCount", 1);
                    intent.putExtra("Intro_Is_Muti_Talker", false);
                } else {
                    if (size <= 1) {
                        intent.putExtra("Intro_Is_Muti_Talker", false);
                    } else {
                        intent.putExtra("Intro_Is_Muti_Talker", true);
                    }
                    intent.putExtra("talkerCount", size);
                }
                intent.putExtra("pushcontent_unread_count", xW);
                NotificationItem notificationItem = new NotificationItem(eM, str, cVar.a(xV, cbg, i3, d.a(context, eM, intent), h.c(context, str2, Al), h.a(context, str3, size, xW, i2, Al), h.d(context, str3, Al), f.Al() ? com.tencent.mm.booter.notification.a.a.b(context, com.tencent.mm.booter.notification.a.a.D(str, str4)) : null, str));
                notificationItem.cYP = j;
                notificationItem.cYQ = i2;
                cVar.a(notificationItem, cVar.bzK);
                com.tencent.mm.booter.notification.d.ft(cVar.bzK.cZz);
                com.tencent.mm.booter.notification.d.w(str, i2);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.Notification.Handle", "push:notify, error");
            x.printErrStackTrace("MicroMsg.Notification.Handle", e, "", new Object[0]);
        }
    }

    public final void atF() {
        a.ya();
        com.tencent.mm.booter.notification.f.n(-1, null);
    }
}
