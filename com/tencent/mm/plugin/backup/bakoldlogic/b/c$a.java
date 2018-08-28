package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.plugin.backup.bakoldlogic.b.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

class c$a {
    public static String gVL = "<msg>";
    public static String gVM = "</msg>";

    public static String wC(String str) {
        a wJ = a.wJ(str);
        return wJ == null ? null : wJ.gWj;
    }

    public static String a(bd bdVar, ey eyVar) {
        EmojiInfo Zy = b.atl().atm().asE().Zy(bdVar.field_imgPath);
        if (Zy == null) {
            return null;
        }
        a wK = a.wK(Zy.Xh());
        if (wK == null) {
            wK = new a(Zy.Xh(), Zy.Xh(), Zy.Xh(), Zy.Xh());
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
            newSerializer.attribute(null, "md5", wK.gWk);
            newSerializer.attribute(null, "len", "1024");
            newSerializer.attribute(null, "androidmd5", wK.gWj);
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
