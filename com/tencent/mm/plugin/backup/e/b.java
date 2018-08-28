package com.tencent.mm.plugin.backup.e;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.plugin.backup.g.d;
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
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class b implements l {

    private static class a {
        public static String gVL = "<msg>";
        public static String gVM = "</msg>";

        public static String wC(String str) {
            com.tencent.mm.plugin.backup.e.k.a wD = k.wD(str);
            return wD == null ? null : wD.gWj;
        }

        public static String a(bd bdVar, ey eyVar) {
            EmojiInfo Zy = d.asG().asH().asE().Zy(bdVar.field_imgPath);
            if (Zy == null) {
                return null;
            }
            com.tencent.mm.plugin.backup.e.k.a wE = k.wE(Zy.Xh());
            if (wE == null) {
                wE = new com.tencent.mm.plugin.backup.e.k.a(Zy.Xh(), Zy.Xh(), Zy.Xh(), Zy.Xh());
            }
            Writer stringWriter = new StringWriter();
            try {
                String aG;
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "emoji");
                newSerializer.attribute(null, "fromusername", eyVar.rcj.siM);
                newSerializer.attribute(null, "tousername", eyVar.rck.siM);
                newSerializer.attribute(null, "type", Zy.field_type);
                newSerializer.attribute(null, "idbuffer", Zy.cnC());
                newSerializer.attribute(null, "md5", wE.gWk);
                newSerializer.attribute(null, "len", "1024");
                newSerializer.attribute(null, "androidmd5", wE.gWj);
                newSerializer.attribute(null, "androidlen", "1024");
                newSerializer.attribute(null, "productid", Zy.field_groupId);
                newSerializer.endTag(null, "emoji");
                if (Zy.aaq()) {
                    newSerializer.startTag(null, "gameext");
                    Map z = bl.z(Zy.getContent(), "gameext");
                    String aG2 = bi.aG((String) z.get(".gameext.$type"), "");
                    aG = bi.aG((String) z.get(".gameext.$content"), "");
                    if (aG2.equals("") || aG.equals("")) {
                        stringWriter.close();
                        return "";
                    }
                    newSerializer.attribute(null, "type", aG2);
                    newSerializer.attribute(null, "content", aG);
                    newSerializer.endTag(null, "gameext");
                }
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                aG = stringWriter.getBuffer().toString();
                try {
                    aG = aG.substring(aG.indexOf(gVL), aG.indexOf(gVM) + gVM.length());
                    x.d("MicroMsg.EmojiConvert", "xml " + aG);
                    return aG;
                } catch (Exception e) {
                    return "";
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.EmojiConvert", e2, "", new Object[0]);
                return "";
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.EmojiConvert", e22, "", new Object[0]);
                return "";
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.EmojiConvert", e222, "", new Object[0]);
                return "";
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.EmojiConvert", e2222, "", new Object[0]);
                return "";
            }
        }
    }

    private static boolean wx(String str) {
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        return bl.z(str, "msg") != null;
    }

    public final int a(ey eyVar, boolean z, bd bdVar, String str, LinkedList<u> linkedList, HashMap<Long, com.tencent.mm.plugin.backup.e.h.a> hashMap, boolean z2, long j) {
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
                if (bdVar.field_isSend != 1 && c.fq(bdVar.field_talker)) {
                    trim = bdVar.field_talker + " :\n " + trim;
                }
            }
        }
        if (trim == null || !wx(trim)) {
            x.d("MicroMsg.BackupItemEmoji", "emoji error" + trim);
            return -1;
        }
        bhz bhz = new bhz();
        bhz.VO(bi.aG(trim, ""));
        eyVar.rcl = bhz;
        EmojiInfo Zy = d.asG().asH().asE().Zy(bdVar.field_imgPath);
        if ((Zy != null && Zy.cny()) || Zy == null) {
            return i;
        }
        String str2;
        if (TextUtils.isEmpty(Zy.field_groupId)) {
            str2 = d.asG().asH().Gg() + Zy.Xh() + "_thumb";
            if (e.cm(str2) < 0) {
                x.e("MicroMsg.BackupItemEmoji", "thumbPath error");
                return -1;
            }
            i = i.a(new i$a(str2, eyVar, (LinkedList) linkedList, 4, z, "_thumb", z2)) + i;
        } else {
            str2 = d.asG().asH().Gg() + Zy.field_groupId + File.separator + Zy.Xh() + "_cover";
            if (e.cm(str2) < 0) {
                x.e("MicroMsg.BackupItemEmoji", "thumbPath error");
                return -1;
            }
            i = i.a(new i$a(str2, eyVar, (LinkedList) linkedList, 4, z, "_thumb", z2)) + i;
        }
        if (TextUtils.isEmpty(Zy.field_groupId) && Zy.cnv()) {
            return i + i.a(new i$a(d.asG().asH().Gg() + Zy.Xh(), eyVar, (LinkedList) linkedList, 5, z, z2, null));
        } else if (!Zy.cnx()) {
            return i;
        } else {
            return i + i.a(new i$a(d.asG().asH().Gg() + Zy.field_groupId + File.separator + Zy.Xh(), eyVar, (LinkedList) linkedList, 5, z, z2, null));
        }
    }

    public final int a(String str, ey eyVar, bd bdVar) {
        boolean z = true;
        bdVar.setContent(eyVar.rcl.siM);
        String str2 = eyVar.rcj.siM;
        String str3 = eyVar.rck.siM;
        if (!((String) d.asG().asH().DT().get(2, null)).equals(str2)) {
            str3 = str2;
        }
        str2 = eyVar.rcl.siM;
        Map z2 = bl.z(str2, "msg");
        ap cu = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().cu(str2, str3);
        if (cu == null) {
            x.w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
            return -1;
        }
        EmojiInfo zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(cu.bKg);
        if (zi == null) {
            x.w("MicroMsg.BackupItemEmoji", "EmojiInfo is null");
            return -1;
        }
        String wC;
        if (z2.get(".msg.emoji.$androidmd5") == null) {
            wC = a.wC(cu.bKg);
            if (!bi.oW(wC)) {
                cu.bKg = wC;
                x.d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", new Object[]{wC});
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
            str3 = d.asG().asH().Gg();
            if (TextUtils.isEmpty(wC)) {
                com.tencent.mm.plugin.backup.a.g.b(eyVar, 4, str3 + cu.bKg + "_thumb");
                com.tencent.mm.plugin.backup.a.g.b(eyVar, 5, str3 + cu.bKg);
            } else {
                File file = new File(str3 + wC);
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.tencent.mm.plugin.backup.a.g.b(eyVar, 4, str3 + wC + File.separator + cu.bKg + "_cover");
                com.tencent.mm.plugin.backup.a.g.b(eyVar, 5, str3 + wC + File.separator + cu.bKg);
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
            d.asG().asH().asE().a(emojiInfo);
        }
        x.d("MicroMsg.BackupItemEmoji", "id " + c.i(bdVar));
        return 0;
    }
}
