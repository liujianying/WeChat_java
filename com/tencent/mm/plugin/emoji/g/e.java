package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.List;
import java.util.Map;

public final class e implements a {
    public final void a(d.a aVar) {
        by byVar = aVar.dIN;
        if (byVar.jQd == 10002) {
            String a = ab.a(byVar.rcl);
            if (bi.oW(a)) {
                x.w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
                return;
            }
            Map z = bl.z(a, "sysmsg");
            if (z != null && z.size() > 0) {
                String str = (String) z.get(".sysmsg.$type");
                if (bi.oW(str) || !str.equalsIgnoreCase("NewRecommendEmotion")) {
                    x.e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :" + str);
                    return;
                }
                List zH = d.zH(a);
                String[] strArr = new String[]{"1", EmojiGroupInfo.tcv, "7"};
                i.aEA().igy.diF.delete("EmojiGroupInfo", "recommand=? and type!=? and status!=?", strArr);
                com.tencent.mm.storage.emotion.a aVar2 = i.aEA().igy;
                x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[insertRecommendEmojiGroupInfo]");
                aVar2.ds(zH);
                return;
            }
            return;
        }
        x.i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(byVar.jQd)});
    }
}
