package com.tencent.mm.plugin.notification.ui;

import com.tencent.mm.g.a.kf;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification.FailSendMsgNotificationService;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class FailSendMsgNotification$FailSendMsgNotificationService$1 extends c<kf> {
    final /* synthetic */ FailSendMsgNotificationService lIB;

    FailSendMsgNotification$FailSendMsgNotificationService$1(FailSendMsgNotificationService failSendMsgNotificationService) {
        this.lIB = failSendMsgNotificationService;
        this.sFo = kf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((kf) bVar).bUC.type != this.lIB.bkF()) {
            x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, type mismatch, type:%d, getNotificationType:%d", new Object[]{Integer.valueOf(((kf) bVar).bUC.type), Integer.valueOf(this.lIB.bkF())});
        } else {
            x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, stop service and show notificaiton, type:%d", new Object[]{Integer.valueOf(((kf) bVar).bUC.type)});
            this.lIB.stopForeground(true);
            if (this.lIB.lIA != null) {
                this.lIB.lIA.bts = false;
                this.lIB.lIA.show();
            }
            this.lIB.stopSelf();
        }
        return false;
    }
}
