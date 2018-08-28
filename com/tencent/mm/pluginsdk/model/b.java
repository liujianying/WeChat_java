package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.R;
import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.g.a.it;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ba;

public final class b implements d {
    public final com.tencent.mm.ab.d.b b(a aVar) {
        by byVar = aVar.dIN;
        if (byVar == null || byVar.jQd != 47) {
            x.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
        } else {
            String a = ab.a(byVar.rcj);
            String a2 = ab.a(byVar.rck);
            au.HU();
            if (!((String) c.DT().get(2, null)).equals(a)) {
                a2 = a;
            }
            ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(a2, ab.a(byVar.rcl), byVar.rcq, byVar.rco, aVar);
            com.tencent.mm.model.bd.b iF = bd.iF(byVar.rco);
            if (iF != null) {
                x.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", new Object[]{iF.dCp});
                if (iF.dCs != null && iF.scene == 1) {
                    int i;
                    a2 = ab.a(byVar.rcj);
                    au.HU();
                    c.DT().set(73729, Integer.valueOf(1));
                    ba baVar = new ba();
                    baVar.field_content = ad.getContext().getString(R.l.nearby_say_hi_type_emoji);
                    baVar.field_createtime = bi.VE();
                    baVar.field_imgpath = "";
                    baVar.field_sayhicontent = baVar.field_content;
                    baVar.field_sayhiuser = a2;
                    baVar.field_scene = 18;
                    if (byVar.hcd > 3) {
                        i = byVar.hcd;
                    } else {
                        i = 3;
                    }
                    baVar.field_status = i;
                    baVar.field_svrid = byVar.rcq;
                    baVar.field_talker = a2;
                    baVar.field_type = byVar.jQd;
                    baVar.field_isSend = 0;
                    baVar.field_sayhiencryptuser = a2;
                    baVar.field_ticket = iF.dCs;
                    com.tencent.mm.az.d.SG().a(baVar);
                    it itVar = new it();
                    itVar.bSl.bSm = a2;
                    com.tencent.mm.sdk.b.a.sFg.m(itVar);
                }
            }
        }
        return null;
    }

    public final void h(com.tencent.mm.storage.bd bdVar) {
    }
}
