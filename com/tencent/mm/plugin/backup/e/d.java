package com.tencent.mm.plugin.backup.e;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.g;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class d implements l {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.protocal.c.ey r12, boolean r13, com.tencent.mm.storage.bd r14, java.lang.String r15, java.util.LinkedList<com.tencent.mm.plugin.backup.h.u> r16, java.util.HashMap<java.lang.Long, com.tencent.mm.plugin.backup.e.h.a> r17, boolean r18, long r19) {
        /*
        r11 = this;
        r0 = r14.field_content;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x014c;
    L_0x0008:
        r0 = 0;
        r8 = r0;
    L_0x000a:
        r0 = r14.field_isSend;
        r1 = 1;
        if (r0 != r1) goto L_0x0029;
    L_0x000f:
        r0 = com.tencent.mm.plugin.backup.g.d.asG();
        r0 = r0.asH();
        r0 = r0.asD();
        r2 = r14.field_msgId;
        r0 = r0.br(r2);
        r2 = r0.dTK;
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x02a5;
    L_0x0029:
        r0 = com.tencent.mm.plugin.backup.g.d.asG();
        r0 = r0.asH();
        r0 = r0.asD();
        r2 = r14.field_msgSvrId;
        r0 = r0.bq(r2);
        r9 = r0;
    L_0x003c:
        r0 = com.tencent.mm.plugin.backup.g.d.asG();
        r0 = r0.asH();
        r0 = r0.asD();
        r1 = r14.field_imgPath;
        r2 = 1;
        r1 = r0.E(r1, r2);
        r0 = com.tencent.mm.a.e.cn(r1);
        if (r0 == 0) goto L_0x0156;
    L_0x0055:
        r0 = new com.tencent.mm.plugin.backup.e.i$a;
        r4 = 1;
        r6 = "_thumb";
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r7 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.i.a(r0);
        r8 = r8 + r0;
        r0 = r14.field_isSend;
        r1 = 1;
        if (r0 != r1) goto L_0x0172;
    L_0x006e:
        r1 = "";
        r0 = com.tencent.mm.plugin.backup.g.d.asG();
        r0 = r0.asH();
        r0 = r0.asD();
        r2 = r9.dTL;
        r3 = "";
        r4 = "";
        r10 = r0.o(r2, r3, r4);
        r0 = r9.ON();
        if (r0 == 0) goto L_0x00fe;
    L_0x008f:
        r0 = com.tencent.mm.plugin.backup.g.d.asG();
        r0 = r0.asH();
        r0 = r0.asD();
        r2 = r9.dTU;
        r9 = r0.hQ(r2);
        if (r9 == 0) goto L_0x0168;
    L_0x00a3:
        r0 = com.tencent.mm.plugin.backup.g.d.asG();
        r0 = r0.asH();
        r0 = r0.asD();
        r1 = r9.dTL;
        r2 = "";
        r3 = "";
        r1 = r0.o(r1, r2, r3);
        r0 = "MicroMsg.BackupItemImg";
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
        if (r0 == 0) goto L_0x0158;
    L_0x00e9:
        r0 = new com.tencent.mm.plugin.backup.e.i$a;
        r4 = 3;
        r6 = "_hd";
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r7 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.i.a(r0);
        r0 = r0 + r8;
        r8 = r0;
    L_0x00fe:
        com.tencent.mm.a.e.cm(r10);
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r10);
        if (r0 != 0) goto L_0x0145;
    L_0x0107:
        r0 = r10.equals(r1);
        if (r0 != 0) goto L_0x0145;
    L_0x010d:
        r0 = "MicroMsg.BackupItemImg";
        r1 = new java.lang.StringBuilder;
        r2 = "bigImgPath ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.a.e.cm(r10);
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = new com.tencent.mm.plugin.backup.e.i$a;
        r4 = 2;
        r7 = 0;
        r1 = r10;
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r6 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.i.a(r0);
        r8 = r8 + r0;
    L_0x0145:
        r0 = a(r9, r14);
        if (r0 != 0) goto L_0x0293;
    L_0x014b:
        return r8;
    L_0x014c:
        r0 = r14.field_content;
        r0 = r0.getBytes();
        r0 = r0.length;
        r8 = r0;
        goto L_0x000a;
    L_0x0156:
        r8 = -1;
        goto L_0x014b;
    L_0x0158:
        r0 = "MicroMsg.BackupItemImg";
        r2 = "packet img.hasHdImg but hdbigImgPath has no file, hdbigImgPath:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r3[r4] = r1;
        com.tencent.mm.sdk.platformtools.x.e(r0, r2, r3);
        goto L_0x00fe;
    L_0x0168:
        r0 = "MicroMsg.BackupItemImg";
        r2 = "packet img.hasHdImg but img is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        goto L_0x00fe;
    L_0x0172:
        r0 = r9.OM();
        if (r0 == 0) goto L_0x0145;
    L_0x0178:
        r0 = com.tencent.mm.plugin.backup.g.d.asG();
        r0 = r0.asH();
        r0 = r0.asD();
        r1 = r9.dTL;
        r2 = "";
        r3 = "";
        r10 = r0.o(r1, r2, r3);
        r1 = "";
        r0 = r9.ON();
        if (r0 == 0) goto L_0x028c;
    L_0x0199:
        r0 = com.tencent.mm.plugin.backup.g.d.asG();
        r0 = r0.asH();
        r0 = r0.asD();
        r2 = r9.dTU;
        r0 = r0.hQ(r2);
        if (r0 == 0) goto L_0x028c;
    L_0x01ad:
        if (r0 == 0) goto L_0x01db;
    L_0x01af:
        r2 = "MicroMsg.BackupItemImg";
        r3 = "packet receive img hdinfo, offset[%d], totalLen[%d], compressType[%d], path:%s";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r0.offset;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = r0.dHI;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 2;
        r6 = r0.dTO;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 3;
        r6 = r0.dTL;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
    L_0x01db:
        if (r0 == 0) goto L_0x023d;
    L_0x01dd:
        r2 = r0.dTO;
        r3 = 1;
        if (r2 != r3) goto L_0x023d;
    L_0x01e2:
        r2 = r0.equals(r9);
        if (r2 != 0) goto L_0x028f;
    L_0x01e8:
        r2 = r0.offset;
        r3 = r0.dHI;
        if (r2 != r3) goto L_0x028f;
    L_0x01ee:
        r1 = com.tencent.mm.plugin.backup.g.d.asG();
        r1 = r1.asH();
        r1 = r1.asD();
        r0 = r0.dTL;
        r2 = "";
        r3 = "";
        r1 = r1.o(r0, r2, r3);
        r0 = "MicroMsg.BackupItemImg";
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
        if (r0 == 0) goto L_0x023d;
    L_0x0226:
        r0 = new com.tencent.mm.plugin.backup.e.i$a;
        r4 = 3;
        r6 = "_hd";
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r7 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.i.a(r0);
        r8 = r8 + r0;
        com.tencent.mm.a.e.cm(r1);
    L_0x023d:
        r0 = com.tencent.mm.a.e.cn(r10);
        if (r0 == 0) goto L_0x0145;
    L_0x0243:
        com.tencent.mm.a.e.cm(r10);
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r10);
        if (r0 != 0) goto L_0x0145;
    L_0x024c:
        r0 = r10.equals(r1);
        if (r0 != 0) goto L_0x0145;
    L_0x0252:
        r0 = "MicroMsg.BackupItemImg";
        r1 = new java.lang.StringBuilder;
        r2 = "bigImgPath ";
        r1.<init>(r2);
        r1 = r1.append(r10);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.a.e.cm(r10);
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = new com.tencent.mm.plugin.backup.e.i$a;
        r4 = 2;
        r7 = 0;
        r1 = r10;
        r2 = r12;
        r3 = r16;
        r5 = r13;
        r6 = r18;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r0 = com.tencent.mm.plugin.backup.e.i.a(r0);
        r8 = r8 + r0;
        goto L_0x0145;
    L_0x028c:
        r0 = 0;
        goto L_0x01ad;
    L_0x028f:
        r0.equals(r9);
        goto L_0x023d;
    L_0x0293:
        r1 = new com.tencent.mm.protocal.c.bhz;
        r1.<init>();
        r1 = r1.VO(r0);
        r12.rcl = r1;
        r0 = r0.length();
        r8 = r8 + r0;
        goto L_0x014b;
    L_0x02a5:
        r9 = r0;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.e.d.a(com.tencent.mm.protocal.c.ey, boolean, com.tencent.mm.storage.bd, java.lang.String, java.util.LinkedList, java.util.HashMap, boolean, long):int");
    }

    private static String a(e eVar, bd bdVar) {
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            if (c.fq(bdVar.field_talker)) {
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
                    j = (long) com.tencent.mm.a.e.cm(com.tencent.mm.plugin.backup.g.d.asG().asH().asD().o(eVar.dTL, "", ""));
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
            x.d("MicroMsg.BackupItemImg", "parseContent xml:%s", new Object[]{stringWriter.getBuffer().toString()});
            return stringWriter.getBuffer().toString();
        } catch (Exception e) {
            x.e("MicroMsg.BackupItemImg", "packetImg xml error: " + e.toString());
            return null;
        }
    }

    public final int a(String str, ey eyVar, bd bdVar) {
        if (eyVar == null || eyVar.rcl == null) {
            x.e("MicroMsg.BackupItemImg", "recover bakitem or bakitem content is null");
            return 0;
        }
        int i;
        String str2;
        e bq;
        long j;
        Object obj;
        String aG;
        byte[] b;
        String str3 = new String(bi.aG(eyVar.rcl.siM, ""));
        x.d("MicroMsg.BackupItemImg", "recover msg" + eyVar.rcq + " " + str3);
        String str4 = "MicroMsg.BackupItemImg";
        String str5 = "recover bakitem:, buf:%d, BufferType:%d, MediaType%s, ids:%s";
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
        x.d(str4, str5, objArr);
        e eVar = null;
        bdVar.setContent(str3);
        g asD = com.tencent.mm.plugin.backup.g.d.asG().asH().asD();
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
        Map z = bl.z(str3, "msg");
        long j2 = 0;
        if (z != null) {
            j2 = bi.getLong((String) z.get(".msg.img.$hdlength"), 0);
            if (j2 > 0) {
                String str6;
                String str7;
                j = j2;
                obj = 1;
                aG = bi.aG(com.tencent.mm.plugin.backup.a.g.a(eyVar, 3), "");
                if (eyVar.rfA == 3 && eyVar.rfy != null) {
                    com.tencent.mm.a.e.b(com.tencent.mm.plugin.backup.a.g.wu(aG), aG, eyVar.rfy.siK.lR);
                }
                str2 = bi.aG(com.tencent.mm.plugin.backup.a.g.a(eyVar, 2), "");
                if (eyVar.rfA == 2 && eyVar.rfy != null) {
                    com.tencent.mm.a.e.b(com.tencent.mm.plugin.backup.a.g.wu(str2), str2, eyVar.rfy.siK.lR);
                }
                x.d("MicroMsg.BackupItemImg", "hdName %s, imgName:%s", new Object[]{aG, str2});
                if (bi.oW(str2)) {
                    str6 = str2;
                } else {
                    x.e("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
                    str6 = aG;
                }
                b = com.tencent.mm.plugin.backup.a.g.b(eyVar, 1);
                if (b != null) {
                    x.i("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
                    str2 = com.tencent.mm.plugin.backup.a.g.wu(str6) + str6;
                    String u = com.tencent.mm.a.g.u((bi.VF() + " ").getBytes());
                    str4 = com.tencent.mm.plugin.backup.a.g.wu(u);
                    str7 = str4 + u;
                    File file = new File(str4);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    int Wn = z.Wn(str7);
                    if (Wn > 0) {
                        if (!z.a(str2, CompressFormat.JPEG, str7, Wn)) {
                            x.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
                            return -1;
                        }
                    } else if (com.tencent.mm.sdk.platformtools.c.a(str2, 120, 120, CompressFormat.JPEG, 90, str7)) {
                        x.d("MicroMsg.BackupItemImg", "insert: thumbName = " + u);
                    } else {
                        x.e("MicroMsg.BackupItemImg", "createThumbNail failed");
                        return -1;
                    }
                    b = com.tencent.mm.a.e.f(str7, 0, -1);
                } else {
                    x.i("MicroMsg.BackupItemImg", "getThumbBuf len:%d", new Object[]{Integer.valueOf(b.length)});
                }
                if (b != null) {
                    x.e("MicroMsg.BackupItemImg", "img buf is null");
                    return -1;
                }
                String o = asD.o(aG, "", "");
                String o2 = asD.o(str6, "", "");
                long j3 = 0;
                if (bq.dTK == 0) {
                    int c;
                    PString pString;
                    PInt pInt;
                    PInt pInt2;
                    int c2 = com.tencent.mm.plugin.backup.a.g.c(eyVar, 2);
                    if (obj != null) {
                        g gVar = asD;
                        str7 = aG;
                        j3 = gVar.a(b, eyVar.rcq, true, str7, com.tencent.mm.plugin.backup.a.g.c(eyVar, 3), str3, new PString(), new PInt(), new PInt());
                        if (!com.tencent.mm.plugin.backup.a.g.b(eyVar, 3, o)) {
                            x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", new Object[]{o});
                            if (((long) c2) == j) {
                                if (com.tencent.mm.plugin.backup.a.g.b(eyVar, 3, o2)) {
                                    x.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", new Object[]{o2});
                                    j = j3;
                                    Object obj2 = null;
                                    if (c2 > 0) {
                                        c = com.tencent.mm.plugin.backup.a.g.c(eyVar, 3);
                                    } else {
                                        c = c2;
                                    }
                                    pString = new PString();
                                    pInt = new PInt();
                                    pInt2 = new PInt();
                                    j2 = asD.a(b, eyVar.rcq, false, str6, c, str3, pString, pInt, pInt2);
                                    if (!(obj2 == null || com.tencent.mm.plugin.backup.a.g.b(eyVar, 2, o2))) {
                                        x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[]{o});
                                    }
                                    if (j2 > 0) {
                                        return -1;
                                    }
                                    bdVar.eq(pString.value);
                                    bdVar.fh(pInt.value);
                                    bdVar.fi(pInt2.value);
                                    if (j > 0) {
                                        e b2 = com.tencent.mm.plugin.backup.g.d.asG().asH().asD().b(Long.valueOf(j2));
                                        b2.hM((int) j);
                                        com.tencent.mm.plugin.backup.g.d.asG().asH().asD().a(Long.valueOf(j2), b2);
                                    }
                                } else {
                                    x.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", new Object[]{o2});
                                }
                            }
                        }
                    }
                    j = j3;
                    int obj22 = 1;
                    if (c2 > 0) {
                        c = c2;
                    } else {
                        c = com.tencent.mm.plugin.backup.a.g.c(eyVar, 3);
                    }
                    pString = new PString();
                    pInt = new PInt();
                    pInt2 = new PInt();
                    j2 = asD.a(b, eyVar.rcq, false, str6, c, str3, pString, pInt, pInt2);
                    x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[]{o});
                    if (j2 > 0) {
                        return -1;
                    }
                    bdVar.eq(pString.value);
                    bdVar.fh(pInt.value);
                    bdVar.fi(pInt2.value);
                    if (j > 0) {
                        e b22 = com.tencent.mm.plugin.backup.g.d.asG().asH().asD().b(Long.valueOf(j2));
                        b22.hM((int) j);
                        com.tencent.mm.plugin.backup.g.d.asG().asH().asD().a(Long.valueOf(j2), b22);
                    }
                } else {
                    str2 = bq.dTN;
                    if (str2 == null || !str2.startsWith("THUMBNAIL_DIRPATH://")) {
                        bdVar.eq("THUMBNAIL://" + bq.dTK);
                    } else {
                        bdVar.eq(str2);
                    }
                }
                c.i(bdVar);
                return 0;
            }
        }
        j = j2;
        obj = null;
        aG = bi.aG(com.tencent.mm.plugin.backup.a.g.a(eyVar, 3), "");
        com.tencent.mm.a.e.b(com.tencent.mm.plugin.backup.a.g.wu(aG), aG, eyVar.rfy.siK.lR);
        str2 = bi.aG(com.tencent.mm.plugin.backup.a.g.a(eyVar, 2), "");
        com.tencent.mm.a.e.b(com.tencent.mm.plugin.backup.a.g.wu(str2), str2, eyVar.rfy.siK.lR);
        x.d("MicroMsg.BackupItemImg", "hdName %s, imgName:%s", new Object[]{aG, str2});
        if (bi.oW(str2)) {
            str6 = str2;
        } else {
            x.e("MicroMsg.BackupItemImg", "imgName is null, imgName = hdName");
            str6 = aG;
        }
        b = com.tencent.mm.plugin.backup.a.g.b(eyVar, 1);
        if (b != null) {
            x.i("MicroMsg.BackupItemImg", "getThumbBuf len:%d", new Object[]{Integer.valueOf(b.length)});
        } else {
            x.i("MicroMsg.BackupItemImg", "getThumbBuf is null and read from mediapath");
            str2 = com.tencent.mm.plugin.backup.a.g.wu(str6) + str6;
            String u2 = com.tencent.mm.a.g.u((bi.VF() + " ").getBytes());
            str4 = com.tencent.mm.plugin.backup.a.g.wu(u2);
            str7 = str4 + u2;
            File file2 = new File(str4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            int Wn2 = z.Wn(str7);
            if (Wn2 > 0) {
                if (!z.a(str2, CompressFormat.JPEG, str7, Wn2)) {
                    x.e("MicroMsg.BackupItemImg", "createLongPictureThumbNail failed");
                    return -1;
                }
            } else if (com.tencent.mm.sdk.platformtools.c.a(str2, 120, 120, CompressFormat.JPEG, 90, str7)) {
                x.d("MicroMsg.BackupItemImg", "insert: thumbName = " + u2);
            } else {
                x.e("MicroMsg.BackupItemImg", "createThumbNail failed");
                return -1;
            }
            b = com.tencent.mm.a.e.f(str7, 0, -1);
        }
        if (b != null) {
            String o3 = asD.o(aG, "", "");
            String o22 = asD.o(str6, "", "");
            long j32 = 0;
            if (bq.dTK == 0) {
                int c3;
                PString pString2;
                PInt pInt3;
                PInt pInt22;
                int c22 = com.tencent.mm.plugin.backup.a.g.c(eyVar, 2);
                if (obj != null) {
                    g gVar2 = asD;
                    str7 = aG;
                    j32 = gVar2.a(b, eyVar.rcq, true, str7, com.tencent.mm.plugin.backup.a.g.c(eyVar, 3), str3, new PString(), new PInt(), new PInt());
                    if (!com.tencent.mm.plugin.backup.a.g.b(eyVar, 3, o3)) {
                        x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE_HD failed:%s", new Object[]{o3});
                        if (((long) c22) == j) {
                            if (com.tencent.mm.plugin.backup.a.g.b(eyVar, 3, o22)) {
                                x.i("MicroMsg.BackupItemImg", "writeItem, try take img for hd img success:%s", new Object[]{o22});
                                j = j32;
                                Object obj222 = null;
                                if (c22 > 0) {
                                    c3 = com.tencent.mm.plugin.backup.a.g.c(eyVar, 3);
                                } else {
                                    c3 = c22;
                                }
                                pString2 = new PString();
                                pInt3 = new PInt();
                                pInt22 = new PInt();
                                j2 = asD.a(b, eyVar.rcq, false, str6, c3, str3, pString2, pInt3, pInt22);
                                if (!(obj222 == null || com.tencent.mm.plugin.backup.a.g.b(eyVar, 2, o22))) {
                                    x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[]{o3});
                                }
                                if (j2 > 0) {
                                    return -1;
                                }
                                bdVar.eq(pString2.value);
                                bdVar.fh(pInt3.value);
                                bdVar.fi(pInt22.value);
                                if (j > 0) {
                                    e b222 = com.tencent.mm.plugin.backup.g.d.asG().asH().asD().b(Long.valueOf(j2));
                                    b222.hM((int) j);
                                    com.tencent.mm.plugin.backup.g.d.asG().asH().asD().a(Long.valueOf(j2), b222);
                                }
                            } else {
                                x.e("MicroMsg.BackupItemImg", "writeItem, try take img for hd img failed:%s", new Object[]{o22});
                            }
                        }
                    }
                }
                j = j32;
                int obj2222 = 1;
                if (c22 > 0) {
                    c3 = c22;
                } else {
                    c3 = com.tencent.mm.plugin.backup.a.g.c(eyVar, 3);
                }
                pString2 = new PString();
                pInt3 = new PInt();
                pInt22 = new PInt();
                j2 = asD.a(b, eyVar.rcq, false, str6, c3, str3, pString2, pInt3, pInt22);
                x.e("MicroMsg.BackupItemImg", "writeItem BACKUPITEM_IMAGE failed:%s", new Object[]{o3});
                if (j2 > 0) {
                    return -1;
                }
                bdVar.eq(pString2.value);
                bdVar.fh(pInt3.value);
                bdVar.fi(pInt22.value);
                if (j > 0) {
                    e b2222 = com.tencent.mm.plugin.backup.g.d.asG().asH().asD().b(Long.valueOf(j2));
                    b2222.hM((int) j);
                    com.tencent.mm.plugin.backup.g.d.asG().asH().asD().a(Long.valueOf(j2), b2222);
                }
            } else {
                str2 = bq.dTN;
                if (str2 == null || !str2.startsWith("THUMBNAIL_DIRPATH://")) {
                    bdVar.eq("THUMBNAIL://" + bq.dTK);
                } else {
                    bdVar.eq(str2);
                }
            }
            c.i(bdVar);
            return 0;
        }
        x.e("MicroMsg.BackupItemImg", "img buf is null");
        return -1;
    }
}
