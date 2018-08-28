package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.a.e;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.plugin.backup.g.c;
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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g implements l {
    byte[] gVS = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 2, (byte) 35, (byte) 33};
    byte[] gVT = new byte[]{(byte) 35, (byte) 33, (byte) 65, (byte) 77, (byte) 82, (byte) 10, (byte) 35, (byte) 33};

    public final int a(ey eyVar, boolean z, bd bdVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        String wG = c.wG(bdVar.field_imgPath);
        if (bi.oW(wG)) {
            return 0;
        }
        File file = new File(wG);
        if (!file.exists()) {
            return 0;
        }
        int length = (int) file.length();
        if (z) {
            return length;
        }
        int a = i.a(new i.a(wG, eyVar, linkedList, 9, z2, z2, null));
        wG = d(bdVar, length);
        if (wG == null) {
            return 0;
        }
        eyVar.rcl = new bhz().VO(wG);
        return length == 0 ? a + wG.length() : a + wG.length();
    }

    public final int a(String str, ey eyVar, bd bdVar) {
        String str2 = eyVar.rcl.siM;
        if (c.fq(eyVar.rcj.siM)) {
            int iA = c.iA(str2);
            if (iA != -1 && iA + 2 < str2.length()) {
                str2 = str2.substring(iA + 2);
            }
            x.v("MicroMsg.BackupItemVoice", "recover, voiceContentXml:%s", new Object[]{str2});
        }
        Map z = bl.z(str2, "msg");
        if (z != null) {
            try {
                bdVar.setContent(n.b((String) z.get(".msg.voicemsg.$fromusername"), (long) com.tencent.mm.plugin.backup.a.g.aR((String) z.get(".msg.voicemsg.$voicelength"), 0), com.tencent.mm.plugin.backup.a.g.aR((String) z.get(".msg.voicemsg.$isPlayed"), 1) == 1));
            } catch (Throwable e) {
                x.e("MicroMsg.BackupItemVoice", "parsing voice msg xml failed");
                x.printErrStackTrace("MicroMsg.BackupItemVoice", e, "", new Object[0]);
            }
        } else {
            x.e("MicroMsg.BackupItemVoice", "voicemsg paseXml failed:%s", new Object[]{eyVar.rcl.siM});
            bdVar.setContent(eyVar.rcl.siM);
        }
        str2 = com.tencent.mm.modelvoice.u.ov(eyVar.rcj.siM);
        bdVar.eq(str2);
        c.i(bdVar);
        str2 = c.wG(str2);
        String a = com.tencent.mm.plugin.backup.a.g.a(eyVar, 9);
        if (!bi.oW(a)) {
            a = com.tencent.mm.plugin.backup.a.g.wu(a) + a;
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
        if (!(str2 == null || com.tencent.mm.plugin.backup.a.g.b(eyVar, 9, str2))) {
            a = com.tencent.mm.plugin.backup.a.g.a(eyVar, 9);
            if (a != null) {
                x.d("MicroMsg.BackupItemVoice", "recover from path:%s", new Object[]{com.tencent.mm.plugin.backup.a.g.wu(a) + a});
                j.q(a, str2, false);
            }
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
                if (c.fq(bdVar.field_talker)) {
                    str = nVar.enF + ":\n" + str;
                }
                x.i("MicroMsg.BackupItemVoice", "parseContent xml:%s", new Object[]{str});
            } catch (Exception e) {
                x.e("MicroMsg.BackupItemVoice", "packetVoice xml error: " + e.toString());
            }
        }
        return str;
    }
}
