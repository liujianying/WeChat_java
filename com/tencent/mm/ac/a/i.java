package com.tencent.mm.ac.a;

import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;

public final class i {
    public static void e(int i, String str, String str2) {
        if ("EnterpriseChatStatus".equals(str)) {
            String[] split = str2.split(";");
            String str3 = split[0];
            String str4 = split[1];
            bi.getInt(split[2], 0);
            if (i == 7) {
                an(str4, str3);
            } else if (i == 8) {
                an(str4, str3);
            } else if (i == 9) {
                an(str4, str3);
            }
        }
    }

    private static void an(String str, String str2) {
        long li = e.li(str);
        if (li == -1) {
            x.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", new Object[]{str});
            return;
        }
        int i = z.Nb().bd(li).field_newUnReadCount;
        z.Nb().bf(li);
        c ak = z.Na().ak(li);
        ai Yq = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Yq(str2);
        if (Yq == null) {
            x.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", new Object[]{str2});
        } else if (ak.hu(1)) {
            if (Yq.field_unReadMuteCount <= i) {
                Yq.fb(0);
                ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().a(Yq, str2);
                ((a) g.n(a.class)).getNotification().cancelNotification(str2);
                return;
            }
            Yq.fb(Yq.field_unReadMuteCount - i);
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().a(Yq, str2);
        } else if (Yq.field_unReadCount <= i) {
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().Ys(str2);
            ((a) g.n(a.class)).getNotification().cancelNotification(str2);
        } else {
            Yq.fa(0);
            Yq.eV(Yq.field_unReadCount - i);
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().a(Yq, str2);
        }
    }
}
