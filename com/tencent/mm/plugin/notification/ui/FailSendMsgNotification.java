package com.tencent.mm.plugin.notification.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.z.d;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification {
    boolean bts = false;
    public d lIk = null;
    private Intent lIl = null;
    private int lIm = 0;
    public a lIn = null;
    public b lIo = null;
    public c lIp = null;
    public String lIq = null;
    public String lIr = null;
    private PendingIntent lIs = null;
    private PendingIntent lIt = null;
    private PendingIntent lIu = null;
    private PendingIntent lIv = null;
    public boolean lIw = false;
    public boolean lIx = false;
    public boolean lIy = true;
    public Context mContext;
    private boolean mIsInit = false;
    private int mType;
    Notification pQ = null;

    public FailSendMsgNotification(int i) {
        boolean z;
        this.mType = i;
        this.mContext = ad.getContext();
        this.lIk = new d(this.mContext);
        this.lIy = true;
        this.lIr = "";
        try {
            if (this.lIy) {
                bkA();
            }
            bkB();
            this.mIsInit = true;
        } catch (Exception e) {
            x.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", new Object[]{e.getMessage()});
            this.mIsInit = false;
        }
        String str = "MicroMsg.FailSendMsgNotification";
        String str2 = "create FailSendMsgNotification, type:%d, context==null:%b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        if (this.mContext == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        this.lIw = false;
    }

    private void bkA() {
        this.lIk.pL = true;
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.omit_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.omit_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.lIu = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.lIk.a(R.g.notification_message_ignore_icon, this.mContext.getString(R.l.notification_fail_send_msg_omit), this.lIu);
        intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotificaiton.resend_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotificaiton.resend_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        if (VERSION.SDK_INT >= 16) {
            intent.addFlags(268435456);
        }
        this.lIv = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.lIk.a(R.g.notification_message_resend_icon, this.mContext.getString(R.l.notification_fail_send_msg_resend), this.lIv);
    }

    public final void bkB() {
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.click_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.click_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.lIs = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.lIk.pu = this.lIs;
        intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.dismiss_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.dismiss_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.lIt = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.lIk.pQ.deleteIntent = this.lIt;
    }

    public final void IU(String str) {
        this.lIq = str;
        show();
    }

    public final void bkC() {
        x.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", new Object[]{Boolean.valueOf(false)});
        this.bts = false;
    }

    @TargetApi(16)
    public final void show() {
        if (this.mIsInit) {
            this.lIk.d(this.lIr);
            this.lIk.b(this.mContext.getText(R.l.app_name));
            this.lIk.Y(VERSION.SDK_INT < 19 ? R.g.notification_icon : R.g.notification_icon_gray);
            this.lIk.c(this.lIq);
            this.lIk.u(false);
            this.pQ = this.lIk.build();
            if (VERSION.SDK_INT >= 16 && !this.bts) {
                this.pQ.priority = 2;
                x.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
            }
            x.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", new Object[]{Boolean.valueOf(this.bts)});
            au.getNotification().a(this.mType, this.pQ, false);
            this.lIw = true;
            return;
        }
        x.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
    }

    public final void dismiss() {
        au.getNotification().cancel(this.mType);
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
            this.mContext.stopService(intent);
        } else if (this.mType == 2) {
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
            this.mContext.stopService(intent);
        }
        this.bts = false;
        this.lIw = false;
    }

    public final void bkD() {
        this.lIk.j(2, false);
        this.lIx = false;
        show();
        x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    }

    public final void bkE() {
        this.lIy = true;
        this.lIk = new d(this.mContext);
        bkA();
        bkB();
    }
}
