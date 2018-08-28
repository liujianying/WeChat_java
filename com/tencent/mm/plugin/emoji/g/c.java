package com.tencent.mm.plugin.emoji.g;

import android.text.TextUtils;
import com.tencent.mm.ab.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

public final class c implements a {
    public final void a(d.a aVar) {
        by byVar = aVar.dIN;
        if (byVar.jQd == 10002) {
            String a = ab.a(byVar.rcl);
            if (bi.oW(a)) {
                x.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "msg content is null");
                return;
            }
            Map z = bl.z(a, "sysmsg");
            if (z != null && z.size() > 0) {
                a = (String) z.get(".sysmsg.$type");
                if (bi.oW(a) || !a.equalsIgnoreCase("emotionstore")) {
                    x.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not emoji message type :" + a);
                    return;
                }
                try {
                    int i;
                    int i2;
                    String str = (String) z.get(".sysmsg.emotionstore.productid");
                    a = (String) z.get(".sysmsg.emotionstore.newcount");
                    String str2 = (String) z.get(".sysmsg.emotionstore.freecount");
                    String str3 = (String) z.get(".sysmsg.emotionstore.thumburl");
                    if (bi.oW(a)) {
                        i = 0;
                    } else {
                        i = Integer.valueOf(a).intValue();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        i2 = 0;
                    } else {
                        i2 = Integer.valueOf(str2).intValue();
                    }
                    a aVar2 = new a(this, i, i2, str3, str);
                    if (bi.oW(str)) {
                        a(aVar2);
                    } else {
                        x.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "new xml productid is %s. now try to get download flag", new Object[]{str});
                        au.DF().a(new k(str, aVar2), 0);
                    }
                    a = (String) z.get(".sysmsg.personalemotion.newcount");
                    if (!bi.oW(a) && Integer.valueOf(a).intValue() > 0) {
                        au.HU();
                        com.tencent.mm.model.c.DT().a(aa.a.sOX, Boolean.valueOf(true));
                    }
                    a = (String) z.get(".sysmsg.personalemoji.emojicount");
                    if (!bi.oW(a) && Integer.valueOf(a).intValue() > 0) {
                        au.HU();
                        com.tencent.mm.model.c.DT().a(aa.a.sPa, Boolean.valueOf(true));
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "onRecieveMsg:%s", new Object[]{bi.i(e)});
                    return;
                }
            }
            return;
        }
        x.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(byVar.jQd)});
    }

    public static void a(a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "xml is null.");
            return;
        }
        if (aVar.ija > 0) {
            au.HU();
            com.tencent.mm.model.c.DT().set(208899, Boolean.valueOf(true));
            com.tencent.mm.s.c.Cp().u(262147, true);
        }
        if (aVar.ijb > 0) {
            au.HU();
            com.tencent.mm.model.c.DT().set(208913, Boolean.valueOf(true));
            com.tencent.mm.s.c.Cp().u(262149, true);
        }
        if (bi.oW(aVar.thumburl)) {
            au.HU();
            com.tencent.mm.model.c.DT().set(229633, "");
            au.HU();
            com.tencent.mm.model.c.DT().set(229634, "");
            return;
        }
        x.d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", new Object[]{aVar.thumburl});
        au.HU();
        com.tencent.mm.model.c.DT().set(229633, aVar.thumburl);
        au.HU();
        com.tencent.mm.model.c.DT().set(229634, System.currentTimeMillis());
    }
}
