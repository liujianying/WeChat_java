package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.backup.bakoldlogic.b.i.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;
import java.util.LinkedList;
import java.util.Map;

public final class c implements j {
    private static boolean wx(String str) {
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        return bl.z(str, "msg") != null;
    }

    public final int a(ey eyVar, bd bdVar, LinkedList<u> linkedList) {
        int i;
        if (bi.oW(bdVar.field_content)) {
            i = 0;
        } else {
            i = bdVar.field_content.getBytes().length;
        }
        String trim = an.YJ(bdVar.field_content).taT.trim();
        if (!wx(trim)) {
            trim = bdVar.field_content;
            if (!wx(trim)) {
                trim = a.a(bdVar, eyVar);
                if (bdVar.field_isSend != 1 && d.fq(bdVar.field_talker)) {
                    trim = bdVar.field_talker + " :\n " + trim;
                }
            }
        }
        if (trim == null || !wx(trim)) {
            x.d("MicroMsg.BakOldItemEmoji", "emoji error" + trim);
            return -1;
        }
        bhz bhz = new bhz();
        bhz.VO(bi.aG(trim, ""));
        eyVar.rcl = bhz;
        EmojiInfo Zy = b.atl().atm().asE().Zy(bdVar.field_imgPath);
        if (Zy != null && Zy.cny()) {
            return i;
        }
        int a;
        if (Zy != null) {
            String str;
            if (TextUtils.isEmpty(Zy.field_groupId)) {
                str = b.atl().atm().Gg() + Zy.Xh() + "_thumb";
                if (e.cm(str) < 0) {
                    x.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
                    return -1;
                }
                a = i.a(new a(str, eyVar, linkedList, 4, "_thumb")) + i;
            } else {
                str = b.atl().atm().Gg() + Zy.field_groupId + File.separator + Zy.Xh() + "_cover";
                if (e.cm(str) < 0) {
                    x.e("MicroMsg.BakOldItemEmoji", "thumbPath error");
                    return -1;
                }
                a = i.a(new a(str, eyVar, linkedList, 4, "_thumb")) + i;
            }
            if (TextUtils.isEmpty(Zy.field_groupId) && Zy.cnv()) {
                a += i.a(new a(b.atl().atm().Gg() + Zy.Xh(), eyVar, linkedList, b.atl().atm().asE().Zy(an.YJ(ab.a(eyVar.rcl)).bKg)));
            } else if (Zy.cnx()) {
                a += i.a(new a(b.atl().atm().Gg() + Zy.field_groupId + File.separator + Zy.Xh(), eyVar, linkedList, b.atl().atm().asE().Zy(an.YJ(ab.a(eyVar.rcl)).bKg)));
            }
        } else {
            a = i;
        }
        return a;
    }

    public final int a(String str, ey eyVar, bd bdVar) {
        boolean z = true;
        bdVar.setContent(eyVar.rcl.siM);
        String str2 = eyVar.rcj.siM;
        String str3 = eyVar.rck.siM;
        if (!((String) b.atl().atm().DT().get(2, null)).equals(str2)) {
            str3 = str2;
        }
        str2 = eyVar.rcl.siM;
        Map z2 = bl.z(str2, "msg");
        ap cu = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().cu(str2, str3);
        if (cu == null) {
            x.w("MicroMsg.BakOldItemEmoji", "EmojiMsgInfo is null");
            return -1;
        }
        EmojiInfo zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(cu.bKg);
        if (zi == null) {
            x.w("MicroMsg.BakOldItemEmoji", "EmojiInfo is null");
            return -1;
        }
        String wC;
        if (z2.get(".msg.emoji.$androidmd5") == null) {
            wC = a.wC(cu.bKg);
            if (!bi.oW(wC)) {
                cu.bKg = wC;
                x.d("MicroMsg.BakOldItemEmoji", "convert ip to android md5 %s", new Object[]{wC});
            }
        }
        wC = (String) z2.get(".msg.emoji.$productid");
        if (!TextUtils.isEmpty(wC)) {
            cu.bKk = wC;
        }
        bdVar.setType(47);
        bdVar.eq(cu.bKg);
        str3 = cu.enF;
        if (zi.aaq() || zi.isGif()) {
            z = false;
        }
        bdVar.setContent(an.a(str3, 0, z, cu.bKg, false, ""));
        if (!zi.cnv()) {
            str3 = b.atl().atm().Gg();
            if (TextUtils.isEmpty(wC)) {
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(eyVar, 4, str3 + cu.bKg + "_thumb");
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(eyVar, 5, str3 + cu.bKg);
            } else {
                File file = new File(str3 + wC);
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(eyVar, 4, str3 + wC + File.separator + cu.bKg + "_cover");
                com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(eyVar, 5, str3 + wC + File.separator + cu.bKg);
            }
            EmojiInfo emojiInfo = new EmojiInfo(str3);
            emojiInfo.field_md5 = cu.bKg;
            emojiInfo.field_svrid = cu.id;
            emojiInfo.field_catalog = EmojiInfo.tcB;
            emojiInfo.field_type = cu.taZ;
            emojiInfo.field_size = cu.tba;
            emojiInfo.field_state = EmojiInfo.tcN;
            if (!TextUtils.isEmpty(wC)) {
                emojiInfo.field_groupId = wC;
            }
            if (!bi.oW(cu.tbi)) {
                emojiInfo.field_activityid = cu.tbi;
            }
            b.atl().atm().asE().a(emojiInfo);
        }
        x.d("MicroMsg.BakOldItemEmoji", "id " + d.i(bdVar));
        return 0;
    }
}
