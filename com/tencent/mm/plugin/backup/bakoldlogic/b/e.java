package com.tencent.mm.plugin.backup.bakoldlogic.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.ak.g;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class e implements j {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.protocal.c.ey r11, com.tencent.mm.storage.bd r12, java.util.LinkedList<com.tencent.mm.plugin.backup.h.u> r13) {
        /*
        r10 = this;
        r0 = r12.field_content;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x0141;
    L_0x0008:
        r0 = 0;
        r6 = r0;
    L_0x000a:
        r0 = r12.field_isSend;
        r1 = 1;
        if (r0 != r1) goto L_0x0029;
    L_0x000f:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl();
        r0 = r0.atm();
        r0 = r0.asD();
        r2 = r12.field_msgId;
        r0 = r0.br(r2);
        r2 = r0.dTK;
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x02b7;
    L_0x0029:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl();
        r0 = r0.atm();
        r0 = r0.asD();
        r2 = r12.field_msgSvrId;
        r0 = r0.bq(r2);
        r7 = r0;
    L_0x003c:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl();
        r0 = r0.atm();
        r0 = r0.asD();
        r1 = r12.field_imgPath;
        r2 = 1;
        r1 = r0.E(r1, r2);
        r0 = com.tencent.mm.a.e.cn(r1);
        if (r0 == 0) goto L_0x014b;
    L_0x0055:
        r0 = new com.tencent.mm.plugin.backup.bakoldlogic.b.i$a;
        r4 = 1;
        r5 = "_thumb";
        r2 = r11;
        r3 = r13;
        r0.<init>(r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(r0);
        r6 = r6 + r0;
        r0 = r12.field_isSend;
        r1 = 1;
        if (r0 != r1) goto L_0x0169;
    L_0x006a:
        r1 = "";
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl();
        r0 = r0.atm();
        r0 = r0.asD();
        r2 = r7.dTL;
        r3 = "";
        r4 = "";
        r9 = r0.o(r2, r3, r4);
        r0 = r7.ON();
        if (r0 == 0) goto L_0x0167;
    L_0x008b:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl();
        r0 = r0.atm();
        r0 = r0.asD();
        r2 = r7.dTU;
        r7 = r0.hQ(r2);
        if (r7 == 0) goto L_0x015e;
    L_0x009f:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl();
        r0 = r0.atm();
        r0 = r0.asD();
        r1 = r7.dTL;
        r2 = "";
        r3 = "";
        r1 = r0.o(r1, r2, r3);
        r0 = "MicroMsg.BakOldItemImg";
        r2 = new java.lang.StringBuilder;
        r3 = "packet hd bigImgPath ";
        r2.<init>(r3);
        r2 = r2.append(r1);
        r3 = " ";
        r2 = r2.append(r3);
        r3 = com.tencent.mm.a.e.cm(r1);
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r2);
        com.tencent.mm.a.e.cm(r1);
        r0 = com.tencent.mm.a.e.cn(r1);
        if (r0 == 0) goto L_0x014d;
    L_0x00e5:
        r0 = new com.tencent.mm.plugin.backup.bakoldlogic.b.i$a;
        r4 = 3;
        r5 = "_hd";
        r2 = r11;
        r3 = r13;
        r0.<init>(r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(r0);
        r0 = r0 + r6;
        r8 = r0;
    L_0x00f6:
        com.tencent.mm.a.e.cm(r9);
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r9);
        if (r0 != 0) goto L_0x013a;
    L_0x00ff:
        r0 = r9.equals(r1);
        if (r0 != 0) goto L_0x013a;
    L_0x0105:
        r0 = "MicroMsg.BakOldItemImg";
        r1 = new java.lang.StringBuilder;
        r2 = "bigImgPath ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.a.e.cm(r9);
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = new com.tencent.mm.plugin.backup.bakoldlogic.b.i$a;
        r4 = 2;
        r5 = 0;
        r6 = 0;
        r1 = r9;
        r2 = r11;
        r3 = r13;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(r0);
        r8 = r8 + r0;
    L_0x013a:
        r0 = a(r7, r12);
        if (r0 != 0) goto L_0x02a0;
    L_0x0140:
        return r8;
    L_0x0141:
        r0 = r12.field_content;
        r0 = r0.getBytes();
        r0 = r0.length;
        r6 = r0;
        goto L_0x000a;
    L_0x014b:
        r8 = -1;
        goto L_0x0140;
    L_0x014d:
        r0 = "MicroMsg.BakOldItemImg";
        r2 = "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r1;
        com.tencent.mm.sdk.platformtools.x.e(r0, r2, r3);
        r8 = r6;
        goto L_0x00f6;
    L_0x015e:
        r0 = "MicroMsg.BakOldItemImg";
        r2 = "packet img.hasHdImg but img is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
    L_0x0167:
        r8 = r6;
        goto L_0x00f6;
    L_0x0169:
        r0 = r7.OM();
        if (r0 == 0) goto L_0x02b4;
    L_0x016f:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl();
        r0 = r0.atm();
        r0 = r0.asD();
        r1 = r7.dTL;
        r2 = "";
        r3 = "";
        r9 = r0.o(r1, r2, r3);
        r2 = "";
        r0 = r7.ON();
        if (r0 == 0) goto L_0x029d;
    L_0x0190:
        r0 = r7.ON();
        if (r0 == 0) goto L_0x0287;
    L_0x0196:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl();
        r0 = r0.atm();
        r0 = r0.asD();
        r1 = r7.dTU;
        r0 = r0.hQ(r1);
        if (r0 == 0) goto L_0x0287;
    L_0x01aa:
        r3 = "MicroMsg.BakOldItemImg";
        r4 = "packet hdinfo off:%d total:%d path:%s, compressType[%d]";
        r1 = 4;
        r5 = new java.lang.Object[r1];
        r8 = 0;
        if (r0 != 0) goto L_0x028a;
    L_0x01b6:
        r1 = -1;
    L_0x01b7:
        r1 = java.lang.Integer.valueOf(r1);
        r5[r8] = r1;
        r8 = 1;
        if (r0 != 0) goto L_0x028e;
    L_0x01c0:
        r1 = -1;
    L_0x01c1:
        r1 = java.lang.Integer.valueOf(r1);
        r5[r8] = r1;
        r8 = 2;
        if (r0 != 0) goto L_0x0292;
    L_0x01ca:
        r1 = "null";
    L_0x01cd:
        r5[r8] = r1;
        r8 = 3;
        if (r0 != 0) goto L_0x0296;
    L_0x01d2:
        r1 = -1;
    L_0x01d3:
        r1 = java.lang.Integer.valueOf(r1);
        r5[r8] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        if (r0 == 0) goto L_0x029d;
    L_0x01de:
        r1 = r0.dTO;
        r3 = 1;
        if (r1 != r3) goto L_0x029d;
    L_0x01e3:
        r1 = r0.equals(r7);
        if (r1 != 0) goto L_0x029a;
    L_0x01e9:
        r1 = r0.offset;
        r3 = r0.dHI;
        if (r1 != r3) goto L_0x029a;
    L_0x01ef:
        r1 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.atl();
        r1 = r1.atm();
        r1 = r1.asD();
        r0 = r0.dTL;
        r2 = "";
        r3 = "";
        r1 = r1.o(r0, r2, r3);
        r0 = "MicroMsg.BakOldItemImg";
        r2 = "packet hdPath:%s, fileLen[%d]";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r1;
        r4 = 1;
        r5 = com.tencent.mm.a.e.cm(r1);
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.d(r0, r2, r3);
        r0 = com.tencent.mm.a.e.cn(r1);
        if (r0 == 0) goto L_0x02b2;
    L_0x0227:
        r0 = new com.tencent.mm.plugin.backup.bakoldlogic.b.i$a;
        r4 = 3;
        r5 = "_hd";
        r2 = r11;
        r3 = r13;
        r0.<init>(r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(r0);
        r6 = r6 + r0;
        com.tencent.mm.a.e.cm(r1);
        r8 = r6;
    L_0x023b:
        r0 = com.tencent.mm.a.e.cn(r9);
        if (r0 == 0) goto L_0x013a;
    L_0x0241:
        com.tencent.mm.a.e.cm(r9);
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r9);
        if (r0 != 0) goto L_0x013a;
    L_0x024a:
        r0 = r9.equals(r1);
        if (r0 != 0) goto L_0x013a;
    L_0x0250:
        r0 = "MicroMsg.BakOldItemImg";
        r1 = new java.lang.StringBuilder;
        r2 = "bigImgPath ";
        r1.<init>(r2);
        r1 = r1.append(r9);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.a.e.cm(r9);
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = new com.tencent.mm.plugin.backup.bakoldlogic.b.i$a;
        r4 = 2;
        r5 = 0;
        r6 = 0;
        r1 = r9;
        r2 = r11;
        r3 = r13;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.b.i.a(r0);
        r8 = r8 + r0;
        goto L_0x013a;
    L_0x0287:
        r0 = r7;
        goto L_0x01aa;
    L_0x028a:
        r1 = r0.offset;
        goto L_0x01b7;
    L_0x028e:
        r1 = r0.dHI;
        goto L_0x01c1;
    L_0x0292:
        r1 = r0.dTL;
        goto L_0x01cd;
    L_0x0296:
        r1 = r0.dTO;
        goto L_0x01d3;
    L_0x029a:
        r0.equals(r7);
    L_0x029d:
        r1 = r2;
        r8 = r6;
        goto L_0x023b;
    L_0x02a0:
        r1 = new com.tencent.mm.protocal.c.bhz;
        r1.<init>();
        r1 = r1.VO(r0);
        r11.rcl = r1;
        r0 = r0.length();
        r8 = r8 + r0;
        goto L_0x0140;
    L_0x02b2:
        r8 = r6;
        goto L_0x023b;
    L_0x02b4:
        r8 = r6;
        goto L_0x013a;
    L_0x02b7:
        r7 = r0;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.b.e.a(com.tencent.mm.protocal.c.ey, com.tencent.mm.storage.bd, java.util.LinkedList):int");
    }

    private static String a(com.tencent.mm.ak.e eVar, bd bdVar) {
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (d.fq(bdVar.field_talker)) {
                stringWriter.write(com.tencent.mm.model.bd.iB(bdVar.field_content) + ":\n");
            }
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "img");
            Map z = bl.z(eVar.dTV, "msg");
            if (z != null) {
                newSerializer.attribute(null, "aeskey", ((String) z.get(".msg.img.$aeskey")));
                newSerializer.attribute(null, "encryver", ((String) z.get(".msg.img.$encryver")));
                newSerializer.attribute(null, "cdnthumbaeskey", ((String) z.get(".msg.img.$cdnthumbaeskey")));
                newSerializer.attribute(null, "cdnthumburl", ((String) z.get(".msg.img.$cdnthumburl")));
                newSerializer.attribute(null, "cdnthumblength", bi.getLong((String) z.get(".msg.img.$cdnthumblength"), 10240));
                newSerializer.attribute(null, "cdnthumbheight", bi.getInt((String) z.get(".msg.img.$cdnthumbheight"), 0));
                newSerializer.attribute(null, "cdnthumbwidth", bi.getInt((String) z.get(".msg.img.$cdnthumbwidth"), 0));
                newSerializer.attribute(null, "cdnmidheight", bi.getInt((String) z.get(".msg.img.$cdnmidheight"), 0));
                newSerializer.attribute(null, "cdnmidwidth", bi.getInt((String) z.get(".msg.img.$cdnmidwidth"), 0));
                newSerializer.attribute(null, "cdnhdheight", bi.getInt((String) z.get(".msg.img.$cdnhdheight"), 0));
                newSerializer.attribute(null, "cdnhdwidth", bi.getInt((String) z.get(".msg.img.$cdnhdwidth"), 0));
                newSerializer.attribute(null, "cdnmidimgurl", ((String) z.get(".msg.img.$cdnmidimgurl")));
                long j = bi.getLong((String) z.get(".msg.img.$length"), 0);
                String str = "length";
                StringBuilder stringBuilder = new StringBuilder();
                if (j == 0) {
                    j = (long) com.tencent.mm.a.e.cm(b.atl().atm().asD().o(eVar.dTL, "", ""));
                }
                newSerializer.attribute(null, str, stringBuilder.append(j).toString());
                if (bdVar.field_isSend != 1 || eVar.dTO == 1) {
                    newSerializer.attribute(null, "cdnbigimgurl", ((String) z.get(".msg.img.$cdnbigimgurl")));
                    newSerializer.attribute(null, "hdlength", bi.getLong((String) z.get(".msg.img.$hdlength"), 0));
                }
                newSerializer.attribute(null, "md5", ((String) z.get(".msg.img.$md5")));
            }
            newSerializer.endTag(null, "img");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            x.d("MicroMsg.BakOldItemImg", "parseContent xml:%s", new Object[]{stringWriter.getBuffer().toString()});
            return stringWriter.getBuffer().toString();
        } catch (Exception e) {
            x.e("MicroMsg.BakOldItemImg", "packetImg xml error: " + e.toString());
            return null;
        }
    }

    public final int a(String str, ey eyVar, bd bdVar) {
        if (eyVar == null || eyVar.rcl == null) {
            x.e("MicroMsg.BakOldItemImg", "recover bakitem or bakitem content is null");
            return 0;
        }
        int i;
        String str2;
        com.tencent.mm.ak.e bq;
        Object obj;
        String str3;
        String str4;
        String str5 = new String(bi.aG(eyVar.rcl.siM, ""));
        x.d("MicroMsg.BakOldItemImg", "recover msg" + eyVar.rcq + " " + str5);
        String str6 = "MicroMsg.BakOldItemImg";
        String str7 = "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s";
        Object[] objArr = new Object[4];
        if (eyVar.rfy == null) {
            i = 0;
        } else {
            i = eyVar.rfy.siI;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(eyVar.rfA);
        if (eyVar.rfx == null) {
            str2 = "";
        } else {
            str2 = eyVar.rfx.toString();
        }
        objArr[2] = str2;
        if (eyVar.rfw == null) {
            str2 = "";
        } else {
            str2 = eyVar.rfw.toString();
        }
        objArr[3] = str2;
        x.d(str6, str7, objArr);
        com.tencent.mm.ak.e eVar = null;
        bdVar.setContent(str5);
        g asD = b.atl().atm().asD();
        if (bdVar.field_isSend == 1) {
            if (bdVar.field_msgId != 0) {
                eVar = asD.br(bdVar.field_msgId);
            }
            if (eVar == null || eVar.dTK == 0) {
                bq = asD.bq(bdVar.field_msgSvrId);
            } else {
                bq = eVar;
            }
        } else {
            bq = asD.bq(bdVar.field_msgSvrId);
        }
        Map z = bl.z(str5, "msg");
        if (z == null || bi.getLong((String) z.get(".msg.img.$hdlength"), 0) <= 0) {
            obj = null;
        } else {
            obj = 1;
        }
        String aG = bi.aG(a.a(eyVar, 3), "");
        if (eyVar.rfA == 3 && eyVar.rfy != null) {
            com.tencent.mm.a.e.b(a.asK() + "backupMeida/" + a.wv(aG), aG, eyVar.rfy.siK.lR);
        }
        str2 = bi.aG(a.a(eyVar, 2), "");
        if (eyVar.rfA == 2 && eyVar.rfy != null) {
            com.tencent.mm.a.e.b(a.asK() + "backupMeida/" + a.wv(str2), str2, eyVar.rfy.siK.lR);
        }
        x.d("MicroMsg.BakOldItemImg", "hdName %s, imgName:%s", new Object[]{aG, str2});
        if (bi.oW(str2)) {
            x.e("MicroMsg.BakOldItemImg", "imgName is null, imgName = hdName");
            str3 = aG;
        } else {
            str3 = str2;
        }
        byte[] b = a.b(eyVar, 1);
        if (b == null) {
            x.i("MicroMsg.BakOldItemImg", "getThumbBuf is null and read from mediapath");
            str2 = a.wI(str3);
            String u = com.tencent.mm.a.g.u((bi.VF() + " ").getBytes());
            str6 = a.asK() + "backupMeida/" + a.wv(u);
            str4 = str6 + u;
            File file = new File(str6);
            if (!file.exists()) {
                file.mkdirs();
            }
            int Wn = z.Wn(str4);
            if (Wn > 0) {
                if (!z.a(str2, CompressFormat.JPEG, str4, Wn)) {
                    x.e("MicroMsg.BakOldItemImg", "createLongPictureThumbNail failed");
                    return -1;
                }
            } else if (c.a(str2, 120, 120, CompressFormat.JPEG, 90, str4)) {
                x.d("MicroMsg.BakOldItemImg", "insert: thumbName = " + u);
            } else {
                x.e("MicroMsg.BakOldItemImg", "createThumbNail failed");
                return -1;
            }
            b = com.tencent.mm.a.e.f(str4, 0, -1);
        } else {
            x.i("MicroMsg.BakOldItemImg", "getThumbBuf len:%d", new Object[]{Integer.valueOf(b.length)});
        }
        if (b == null) {
            x.e("MicroMsg.BakOldItemImg", "img buf is null");
            return -1;
        }
        String o = asD.o(aG, "", "");
        String o2 = asD.o(str3, "", "");
        long j = 0;
        if (bq.dTK == 0) {
            if (obj != null) {
                g gVar = asD;
                str4 = aG;
                j = gVar.a(b, eyVar.rcq, true, str4, a.c(eyVar, 3), str5, new PString(), new PInt(), new PInt());
                if (!a.b(eyVar, 3, o)) {
                    x.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_HD_IMG failed:%s", new Object[]{o});
                }
            }
            long j2 = j;
            int c = a.c(eyVar, 2);
            if (c <= 0) {
                c = a.c(eyVar, 3);
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            long a = asD.a(b, eyVar.rcq, false, str3, c, str5, pString, pInt, pInt2);
            if (!a.b(eyVar, 2, o2)) {
                x.e("MicroMsg.BakOldItemImg", "writeItem MMBAK_IMG failed:%s", new Object[]{o});
            }
            if (a <= 0) {
                return -1;
            }
            bdVar.eq(pString.value);
            bdVar.fh(pInt.value);
            bdVar.fi(pInt2.value);
            if (j2 > 0) {
                com.tencent.mm.ak.e b2 = b.atl().atm().asD().b(Long.valueOf(a));
                b2.hM((int) j2);
                b.atl().atm().asD().a(Long.valueOf(a), b2);
            }
        } else {
            str2 = bq.dTN;
            if (str2 == null || !str2.startsWith("THUMBNAIL_DIRPATH://")) {
                bdVar.eq("THUMBNAIL://" + bq.dTK);
            } else {
                bdVar.eq(str2);
            }
        }
        d.i(bdVar);
        return 0;
    }
}
