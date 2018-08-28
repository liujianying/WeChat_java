package com.tencent.mm.booter.notification.a;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import com.tencent.mm.booter.notification.a.f.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.k.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e;
import java.io.File;

public final class b {
    public int cZe = 0;

    public final int a(Context context, boolean z, boolean z2, Notification notification, String str) {
        int i;
        String An;
        if (f.Ai()) {
            i = 0;
            if (notification == null) {
                notification = new Notification();
            }
            x.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), g.c(notification.vibrate), notification.sound});
            if (z2) {
                notification.vibrate = bi.eyq;
            }
            if (z) {
                An = f.An();
                if (bq(context)) {
                    i = 0;
                    notification.sound = null;
                    a.yl().eQ(An);
                    x.i("MicroMsg.NotificationDefaults", "initDefaults, wireOn & playSound by ourselves: %s(if null play follow system notification sound)", new Object[]{An});
                } else if (An == null || An == e.f.dgL) {
                    i = 1;
                } else {
                    i = 0;
                    notification.sound = Uri.parse(An);
                }
            }
            x.i("MicroMsg.NotificationDefaults", "end initDefaults, defaults: %d, n.vibrate: %s, n.sound: %s", new Object[]{Integer.valueOf(i), g.c(notification.vibrate), notification.sound});
            this.cZe = i;
            return this.cZe;
        }
        boolean z3;
        int i2;
        boolean z4;
        int i3;
        boolean z5;
        x.i("MicroMsg.NotificationDefaults", "begin initDefaults, isNeedSound: %B, isNeedShake: %B, n.defaults: %d, n.vibrate: %s, n.sound: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(notification.defaults), notification.vibrate, notification.sound});
        i = 0;
        boolean z6 = false;
        boolean z7 = false;
        if (!z) {
            z3 = false;
        } else if (bq(context)) {
            z3 = true;
        } else {
            i = 1;
            z3 = false;
        }
        if (z2) {
            i |= 2;
        }
        An = f.An();
        if (bi.oW(str)) {
            x.d("MicroMsg.NotificationDefaults", "msgContent is null");
        }
        if (An != null && new File(An).exists()) {
            An = e.f.dgL;
        }
        if (q.deW.ddP != 2) {
            if (((i & 2) > 0 ? 1 : null) != null) {
                i2 = i & -3;
                bi.t(context, true);
                z6 = true;
            } else {
                i2 = i;
            }
            if (!fw(i2) || z3) {
                z4 = z6;
            } else {
                i2 &= -2;
                a.yl().eQ(An);
                z7 = true;
                z4 = z6;
            }
        } else {
            z4 = false;
            i2 = i;
        }
        if (z3) {
            i3 = i2 & -2;
            a.yl().eQ(An);
            z5 = true;
        } else if (!fw(i2) || An == null) {
            z5 = z7;
            i3 = i2;
        } else {
            i3 = i2 & -2;
            notification.sound = Uri.parse(An);
            z5 = z7;
        }
        this.cZe = i3;
        x.i("MicroMsg.NotificationDefaults", "end initDefaults, n.defaults: %d, n.vibrate: %s, n.sound: %s, soundUri: %s, headset&Play: %B, DeviceInfo.mCommonInfo.mmnotify is Enable: %B, isMMShake: %B, isMMPlaySound: %B", new Object[]{Integer.valueOf(notification.defaults), g.c(notification.vibrate), notification.sound, An, Boolean.valueOf(z3), Boolean.valueOf(r6), Boolean.valueOf(z4), Boolean.valueOf(z5)});
        return this.cZe;
    }

    private static boolean fw(int i) {
        return (i & 1) > 0;
    }

    private static boolean bq(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        return audioManager == null ? false : audioManager.isWiredHeadsetOn();
    }
}
