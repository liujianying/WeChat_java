package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.modelvideo.p;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.backup.bakoldlogic.b.i.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g implements j {
    public final int a(ey eyVar, bd bdVar, LinkedList<u> linkedList) {
        Object obj;
        b.atl().atm().Ta();
        String nK = s.nK(bdVar.field_imgPath);
        r wF = d.wF(bdVar.field_imgPath);
        if (wF == null || wF.status == 199) {
            obj = 1;
        } else {
            obj = null;
        }
        File file = new File(nK);
        int i;
        if (obj == null || !file.exists()) {
            i = 0;
        } else {
            i = (int) file.length();
        }
        int i2 = 0;
        b.atl().atm().Ta();
        String nL = s.nL(bdVar.field_imgPath);
        File file2 = new File(nL);
        if (file2.exists()) {
            i2 = (int) file2.length();
        }
        int i3 = 0;
        if (i2 != 0) {
            if (bdVar.getType() == 62) {
                i3 = i.a(new a(nL, eyVar, linkedList, 13, "_thumb")) + 0;
            } else {
                i3 = i.a(new a(nL, eyVar, linkedList, 11, "_thumb")) + 0;
            }
        }
        if (obj == null || i == 0) {
            i2 = i3;
        } else if (bdVar.getType() == 62) {
            i2 = i.a(new a(nK, eyVar, linkedList, 12, false, null)) + i3;
        } else {
            i2 = i.a(new a(nK, eyVar, linkedList, 10, false, null)) + i3;
        }
        nL = a(eyVar, bdVar);
        if (nL == null) {
            return i2;
        }
        eyVar.rcl = new bhz().VO(nL);
        return i2 + nL.length();
    }

    public final int a(String str, ey eyVar, bd bdVar) {
        r rVar = new r();
        rVar.bWJ = eyVar.rcj.siM;
        rVar.createTime = bdVar.field_createTime;
        rVar.bYu = eyVar.rcq;
        String str2 = eyVar.rcl.siM;
        x.d("MicroMsg.BakOldItemVideo", "parseVideoMsgXML content:" + str2);
        Map z = bl.z(str2, "msg");
        if (z != null) {
            try {
                rVar.dHI = com.tencent.mm.plugin.backup.bakoldlogic.a.a.aR((String) z.get(".msg.videomsg.$length"), 0);
                rVar.enM = com.tencent.mm.plugin.backup.bakoldlogic.a.a.aR((String) z.get(".msg.videomsg.$playlength"), 0);
                rVar.enF = (String) z.get(".msg.videomsg.$fromusername");
                int aR = com.tencent.mm.plugin.backup.bakoldlogic.a.a.aR((String) z.get(".msg.videomsg.$type"), 0);
                x.d("MicroMsg.BakOldItemVideo", "video msg exportType :" + aR);
                if (aR == 44) {
                    aR = 1;
                } else {
                    aR = 0;
                }
                rVar.enQ = aR;
            } catch (Throwable e) {
                x.e("MicroMsg.BakOldItemVideo", "parsing voice msg xml failed");
                x.printErrStackTrace("MicroMsg.BakOldItemVideo", e, "", new Object[0]);
            }
        } else {
            x.e("MicroMsg.BakOldItemVideo", "videomsg paseXml failed:%s", new Object[]{eyVar.rcl.siM});
            bdVar.setContent(eyVar.rcl.siM);
        }
        if (com.tencent.mm.plugin.backup.bakoldlogic.a.a.d(eyVar, 10) || com.tencent.mm.plugin.backup.bakoldlogic.a.a.d(eyVar, 12)) {
            rVar.status = 199;
        } else {
            rVar.status = s$l.AppCompatTheme_switchStyle;
        }
        String nJ = s.nJ(rVar.Tk());
        bdVar.eq(nJ);
        rVar.fileName = nJ;
        if (bdVar.getType() != 62) {
            bdVar.setType(43);
        }
        bdVar.setContent(p.b(rVar.Tk(), rVar.enL, false));
        rVar.enN = (int) d.i(bdVar);
        rVar.enK = bi.VE();
        rVar.enO = 0;
        x.d("MicroMsg.BakOldItemVideo", "Insert fileName[" + rVar.getFileName() + "] size:" + rVar.dHI + " svrid:" + rVar.bYu + " timelen:" + rVar.enM + " user:" + rVar.Tj() + " human:" + rVar.Tk());
        b.atl().atm().Ta().a(rVar);
        b.atl().atm().Ta();
        str2 = s.nL(nJ);
        if (bdVar.getType() == 62) {
            com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(eyVar, 13, str2);
            str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(eyVar, 12);
        } else {
            com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(eyVar, 11, str2);
            str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(eyVar, 10);
        }
        if (str2 != null) {
            str2 = com.tencent.mm.plugin.backup.bakoldlogic.a.a.wI(str2);
            b.atl().atm().Ta();
            j.q(str2, s.nK(nJ), false);
        }
        return 0;
    }

    private static String a(ey eyVar, bd bdVar) {
        r wF = d.wF(bdVar.field_imgPath);
        if (wF == null) {
            return null;
        }
        int i;
        if (bdVar.getType() == 62) {
            i = 62;
        } else {
            i = 43;
        }
        eyVar.hcE = i;
        if (bi.oW(bdVar.field_content)) {
            return null;
        }
        String Tk;
        if (d.fq(bdVar.field_talker)) {
            Tk = wF.Tk();
        } else {
            Tk = eyVar.rcj.siM;
        }
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "videomsg");
            Map z = bl.z(wF.Tm(), "msg");
            if (z != null) {
                newSerializer.attribute(null, "aeskey", ((String) z.get(".msg.videomsg.$aeskey")));
                newSerializer.attribute(null, "cdnthumbaeskey", ((String) z.get(".msg.videomsg.$cdnthumbaeskey")));
                newSerializer.attribute(null, "cdnvideourl", ((String) z.get(".msg.videomsg.$cdnvideourl")));
                newSerializer.attribute(null, "cdnthumburl", ((String) z.get(".msg.videomsg.$cdnthumburl")));
                newSerializer.attribute(null, "cdnthumblength", ((String) z.get(".msg.videomsg.$cdnthumblength")));
            }
            newSerializer.attribute(null, "playlength", wF.enM);
            newSerializer.attribute(null, "length", wF.dHI);
            newSerializer.attribute(null, "type", String.valueOf(i));
            if (!bi.oW(Tk)) {
                newSerializer.attribute(null, "fromusername", Tk);
            }
            newSerializer.attribute(null, "md5", wF.cas);
            newSerializer.endTag(null, "videomsg");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            x.d("MicroMsg.BakOldItemVideo", "parseContent xml:" + stringBuffer);
            return stringBuffer;
        } catch (Exception e) {
            x.e("MicroMsg.BakOldItemVideo", "packetVoice xml error: " + e.toString());
            return null;
        }
    }
}
