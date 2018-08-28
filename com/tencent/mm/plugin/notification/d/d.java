package com.tencent.mm.plugin.notification.d;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;

public final class d extends a<bd> {
    private c lHK = new c<ox>() {
        {
            this.sFo = ox.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ah.A(new 1(this, (ox) bVar));
            return false;
        }
    };
    private c lHL = new c<oz>() {
        {
            this.sFo = oz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ah.A(new 1(this, (oz) bVar));
            return false;
        }
    };

    static /* synthetic */ boolean IT(String str) {
        return !(ab.XO(str) || ab.XQ(str)) || ab.gY(str);
    }

    protected final /* bridge */ /* synthetic */ long bL(Object obj) {
        return ((bd) obj).field_msgId;
    }

    public final void bkt() {
        com.tencent.mm.sdk.b.a.sFg.b(this.lHK);
    }

    public final void bku() {
        com.tencent.mm.sdk.b.a.sFg.b(this.lHL);
    }

    public final void eh(long j) {
        au.HU();
        ah.A(new 3(this, j, com.tencent.mm.model.c.FT().dW(j)));
    }

    public final void bkv() {
        com.tencent.mm.sdk.b.a.sFg.c(this.lHK);
    }

    public final void bkw() {
        com.tencent.mm.sdk.b.a.sFg.c(this.lHL);
    }

    protected final void bko() {
        x.d("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", new Object[]{Integer.valueOf(this.lHt.lHE.size())});
        if (this.lHt.lHE.size() > 1) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            if (VERSION.SDK_INT < 16) {
                intent.putExtra("resend_fail_messages", true);
            }
            intent.putExtra("From_fail_notify", true);
            x.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
            com.tencent.mm.bg.d.e(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
        } else if (this.lHt.lHE.size() == 1) {
            long j = this.lHt.get(0);
            au.HU();
            String str = com.tencent.mm.model.c.FT().dW(j).field_talker;
            Intent intent2 = new Intent();
            intent2.putExtra("Main_User", str);
            intent2.putExtra("From_fail_notify", true);
            intent2.addFlags(67108864);
            intent2.addFlags(536870912);
            if (VERSION.SDK_INT < 16) {
                intent2.putExtra("resend_fail_messages", true);
            }
            com.tencent.mm.bg.d.e(this.mContext, "com.tencent.mm.ui.LauncherUI", intent2);
        }
    }

    protected final int getType() {
        return 1;
    }

    protected final void I(ArrayList<Long> arrayList) {
        au.HU();
        com.tencent.mm.model.c.FT().E(arrayList);
    }

    protected final String ue(int i) {
        return this.mContext.getString(R.l.notificaiton_notify_fail_msg, new Object[]{Integer.valueOf(i)});
    }

    protected final String dc(int i, int i2) {
        return this.mContext.getString(R.l.notification_resending_msg, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    protected final String T(int i, int i2, int i3) {
        return this.mContext.getString(R.l.notification_resending_msg_with_fail, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
    }

    protected final String dd(int i, int i2) {
        if (i2 <= 0) {
            return this.mContext.getString(R.l.notification_resend_finish_msg_without_fail, new Object[]{Integer.valueOf(i)});
        }
        return this.mContext.getString(R.l.notification_resend_finish_msg, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final boolean ei(long j) {
        au.HU();
        x.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", new Object[]{Long.valueOf(j), Long.valueOf(com.tencent.mm.model.c.FT().dW(j).field_msgId)});
        if (com.tencent.mm.model.c.FT().dW(j).field_msgId != 0) {
            return true;
        }
        return false;
    }
}
