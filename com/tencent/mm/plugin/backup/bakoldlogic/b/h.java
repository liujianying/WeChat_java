package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.a.e;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.backup.bakoldlogic.b.i.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.bhy;
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

public final class h implements j {
    byte[] gVS = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 2, (byte) 35, (byte) 33};
    byte[] gVT = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 35, (byte) 33};

    public final int a(ey eyVar, bd bdVar, LinkedList<u> linkedList) {
        int i = 0;
        String wG = d.wG(bdVar.field_imgPath);
        if (!bi.oW(wG)) {
            File file = new File(wG);
            if (file.exists()) {
                int length = (int) file.length();
                int a = i.a(new a(wG, eyVar, linkedList, 9, false, null));
                wG = d(bdVar, length);
                if (wG != null) {
                    eyVar.rcl = new bhz().VO(wG);
                    i = a + wG.length();
                    if (length == 0) {
                        return i;
                    }
                }
            }
        }
        return i;
    }

    public final int a(String str, ey eyVar, bd bdVar) {
        String a;
        String str2 = eyVar.rcl.siM;
        if (d.fq(eyVar.rcj.siM)) {
            int iA = d.iA(str2);
            if (iA != -1 && iA + 2 < str2.length()) {
                str2 = str2.substring(iA + 2);
            }
            x.v("MicroMsg.BakOldItemVoice", "chatroom voicemsg, new content=" + str2);
        }
        Map z = bl.z(str2, "msg");
        if (z != null) {
            try {
                bdVar.setContent(n.b((String) z.get(".msg.voicemsg.$fromusername"), (long) com.tencent.mm.plugin.backup.bakoldlogic.a.a.aR((String) z.get(".msg.voicemsg.$voicelength"), 0), com.tencent.mm.plugin.backup.bakoldlogic.a.a.aR((String) z.get(".msg.voicemsg.$isPlayed"), 1) == 1));
            } catch (Throwable e) {
                x.e("MicroMsg.BakOldItemVoice", "parsing voice msg xml failed");
                x.printErrStackTrace("MicroMsg.BakOldItemVoice", e, "", new Object[0]);
            }
        } else {
            x.e("MicroMsg.BakOldItemVoice", "voicemsg paseXml failed:%s", new Object[]{eyVar.rcl.siM});
            bdVar.setContent(eyVar.rcl.siM);
        }
        str2 = com.tencent.mm.modelvoice.u.ov(eyVar.rcj.siM);
        bdVar.eq(str2);
        d.i(bdVar);
        str2 = d.wG(str2);
        if (eyVar.rfA == 9) {
            byte[] bArr = eyVar.rfy.siK.lR;
            Object obj;
            if (d(this.gVS, bArr)) {
                obj = new byte[(bArr.length - 6)];
                System.arraycopy(bArr, 6, obj, 0, bArr.length - 6);
                eyVar.rfz = bArr.length - 6;
                eyVar.rfy = new bhy().bq(obj);
            } else if (d(this.gVT, bArr)) {
                obj = new byte[(bArr.length - 6)];
                System.arraycopy(bArr, 6, obj, 0, bArr.length - 6);
                eyVar.rfz = bArr.length - 6;
                eyVar.rfy = new bhy().bq(obj);
            }
            if (!(str2 == null || com.tencent.mm.plugin.backup.bakoldlogic.a.a.b(eyVar, 9, str2))) {
                a = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(eyVar, 9);
                if (a != null) {
                    a = com.tencent.mm.plugin.backup.bakoldlogic.a.a.wI(a);
                    x.d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard" + a);
                    j.q(a, str2, false);
                }
            }
            return 0;
        }
        a = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(eyVar, 9);
        if (!bi.oW(a)) {
            a = com.tencent.mm.plugin.backup.bakoldlogic.a.a.wI(a);
            if (e.cn(a)) {
                byte[] f = e.f(a, 0, 9);
                if (d(this.gVS, f)) {
                    f = e.f(a, 6, -1);
                    e.deleteFile(a);
                    e.b(a, f, f.length);
                } else if (d(this.gVT, f)) {
                    f = e.f(a, 6, -1);
                    e.deleteFile(a);
                    e.b(a, f, f.length);
                }
            }
        }
        a = com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(eyVar, 9);
        if (a != null) {
            a = com.tencent.mm.plugin.backup.bakoldlogic.a.a.wI(a);
            x.d("MicroMsg.BakOldItemVoice", "recover Frome Sdcard" + a);
            j.q(a, str2, false);
        }
        return 0;
    }

    private static boolean d(byte[] bArr, byte[] bArr2) {
        if (bi.bC(bArr2)) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static String d(bd bdVar, int i) {
        String str = null;
        if (!bi.oW(bdVar.field_content)) {
            n nVar = new n(bdVar.field_content);
            Writer stringWriter = new StringWriter();
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "voicemsg");
                newSerializer.attribute(null, "length", String.valueOf(i));
                newSerializer.attribute(null, "endflag", "1");
                newSerializer.attribute(null, "cancelflag", "0");
                newSerializer.attribute(null, "voicelength", nVar.time);
                if (!bi.oW(nVar.enF)) {
                    newSerializer.attribute(null, "fromusername", nVar.enF);
                }
                newSerializer.attribute(null, "isPlayed", nVar.enG ? "1" : "0");
                newSerializer.endTag(null, "voicemsg");
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                str = stringWriter.getBuffer().toString();
                if (d.fq(bdVar.field_talker)) {
                    str = nVar.enF + ":\n" + str;
                }
                x.i("MicroMsg.BakOldItemVoice", "parseContent xml:" + str);
            } catch (Exception e) {
                x.e("MicroMsg.BakOldItemVoice", "packetVoice xml error: " + e.toString());
            }
        }
        return str;
    }
}
