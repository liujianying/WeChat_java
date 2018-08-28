package com.tencent.mm.plugin.notification.ui;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class FailSendMsgNotification$FailSendMsgNotificationService extends Service {
    protected FailSendMsgNotification lIA = null;
    protected c lIz = new 1(this);

    protected abstract int bkF();

    public void onCreate() {
        super.onCreate();
        x.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
        a.sFg.b(this.lIz);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    @TargetApi(16)
    public int onStartCommand(Intent intent, int i, int i2) {
        x.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
        if (intent == null || intent.getExtras() == null) {
            x.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
        } else {
            String action = intent.getAction();
            if (bi.oW(action)) {
                x.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
            } else {
                int i3 = intent.getExtras().getInt("notification_type", -1);
                x.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", new Object[]{Integer.valueOf(i3)});
                if (f.uh(i3) == null) {
                    x.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                } else {
                    x.d("MicroMsg.FailSendMsgNotification", "action:%s", new Object[]{action});
                    this.lIA = f.uh(i3);
                    if (action.startsWith("com.tencent.failnotification.omit")) {
                        if (this.lIA.lIn != null) {
                            x.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", new Object[]{Integer.valueOf(i3)});
                            this.lIA.lIn.bkq();
                        }
                    } else if (action.startsWith("com.tencent.failnotificaiton.resend")) {
                        if (this.lIA.lIn != null) {
                            boolean z;
                            String str = "MicroMsg.FailSendMsgNotification";
                            String str2 = "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b";
                            Object[] objArr = new Object[3];
                            objArr[0] = Integer.valueOf(i3);
                            objArr[1] = Boolean.valueOf(this.lIA.pQ == null);
                            if (this.lIA.lIk == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            objArr[2] = Boolean.valueOf(z);
                            x.d(str, str2, objArr);
                            if (this.lIA != null) {
                                this.lIA.bts = true;
                            }
                            if (this.lIA.pQ != null && VERSION.SDK_INT >= 16) {
                                this.lIA.pQ.priority = 0;
                            }
                            if (this.lIA.pQ == null) {
                                this.lIA.show();
                            }
                            startForeground(i3, this.lIA.pQ);
                            this.lIA.lIn.bkp();
                            x.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", new Object[]{Integer.valueOf(i3)});
                        }
                    } else if (action.startsWith("com.tencent.failnotification.click")) {
                        if (this.lIA.lIo != null) {
                            x.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", new Object[]{Integer.valueOf(i3)});
                            this.lIA.lIo.bkr();
                        }
                    } else if (action.startsWith("com.tencent.failnotification.dismiss")) {
                        this.lIA.lIw = false;
                        this.lIA.bts = false;
                        if (this.lIA.lIp != null) {
                            x.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
                            this.lIA.lIp.onDismiss();
                        }
                        stopSelf();
                    }
                }
            }
        }
        return 2;
    }

    public void onDestroy() {
        super.onDestroy();
        x.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
        a.sFg.c(this.lIz);
    }
}
