package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.model.au;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.protocal.c.amx;
import com.tencent.mm.protocal.c.amz;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.protocal.c.anb;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;
import java.io.File;
import java.util.Random;

class e$26 extends c<ec> {
    final /* synthetic */ e iup;

    e$26(e eVar) {
        this.iup = eVar;
        this.sFo = ec.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ec ecVar = (ec) bVar;
        e eVar = this.iup;
        ecVar = ecVar;
        if (bi.oW(ecVar.bLS.bKv) || bi.oW(ecVar.bLS.byN)) {
            ecVar.bLT.bLW = false;
        } else {
            String str;
            Boolean valueOf;
            int i;
            ec.b bVar2 = ecVar.bLT;
            g gVar = eVar.ium;
            String str2 = ecVar.bLS.bKv;
            String str3 = ecVar.bLS.byN;
            String str4 = ecVar.bLS.bLU;
            long j = ecVar.bLS.bJC;
            String str5 = ecVar.bLS.bKW;
            boolean z = ecVar.bLS.bLV;
            gVar.cYP = j;
            gVar.iuv = false;
            gVar.iuw = z;
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "deviceType: %s, deviceId: %s", new Object[]{str2, str3});
            int i2 = 0;
            if (str4 == null || !str4.contains("wechat_to_device") || gVar.iuK.get(str3) == null) {
                if (str4 != null && str4.contains("internet_to_device")) {
                    i2 = 1;
                    if (!z && (g.cD(j).booleanValue() || g.cC(j).booleanValue() || g.cF(j).booleanValue() || g.cE(j).booleanValue())) {
                        str4 = "MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice";
                        str5 = "mDeviceMsgForUseCdn %s deviceId %s deviceType %s";
                        Object[] objArr = new Object[3];
                        objArr[0] = Boolean.valueOf(gVar.iuG == null);
                        objArr[1] = str3;
                        objArr[2] = str2;
                        x.d(str4, str5, objArr);
                        if (gVar.iuG != null) {
                            au.DF().a(new n(gVar.iuG, str2, str3, 1), 0);
                        } else {
                            gVar.iuF.put(str3, str2);
                            if (!gVar.iuE) {
                                Object obj;
                                str4 = "";
                                str = "";
                                gVar.iuD = true;
                                au.HU();
                                bd dW = com.tencent.mm.model.c.FT().dW(j);
                                Object[] objArr2;
                                i iVar;
                                if (g.cD(j).booleanValue()) {
                                    e q = o.Pf().q(dW);
                                    str4 = o.Pf().o(q.dTL, "", "");
                                    str = o.Pf().o(q.dTN, "", "");
                                    gVar.dlN = q.dTK;
                                    if (bi.oW(gVar.dVk)) {
                                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[]{Long.valueOf(dW.field_createTime), dW.field_talker, Long.valueOf(dW.field_msgId), Long.valueOf(gVar.dlN), Integer.valueOf(0)});
                                        gVar.dVk = d.a("upimg", dW.field_createTime, dW.field_talker, dW.field_msgId + "_" + gVar.dlN + "_0");
                                    }
                                    g.ND();
                                    if (!com.tencent.mm.modelcdntran.c.hz(1) && bi.oW(q.dTV)) {
                                        objArr2 = new Object[2];
                                        g.ND();
                                        objArr2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hz(1));
                                        objArr2[1] = q.dTV;
                                        x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%s", objArr2);
                                        obj = null;
                                    }
                                    if (g.cD(j).booleanValue() || g.cE(j).booleanValue()) {
                                        gVar.iuH = new Random().nextLong();
                                        str4 = g.y(str4, gVar.iuH);
                                        str = g.y(str, gVar.iuH);
                                    }
                                    iVar = new i();
                                    iVar.dPV = gVar.dVu;
                                    iVar.field_mediaId = gVar.dVk;
                                    iVar.field_fullpath = str4;
                                    iVar.field_thumbpath = str;
                                    iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOt;
                                    iVar.field_talker = dW.field_talker;
                                    iVar.field_priority = com.tencent.mm.modelcdntran.b.dOj;
                                    iVar.field_needStorage = false;
                                    iVar.field_isStreamMedia = false;
                                    iVar.field_appType = 202;
                                    iVar.field_bzScene = 2;
                                    if (!g.cC(j).booleanValue()) {
                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOt;
                                        iVar.field_appType = 202;
                                    } else if (g.cF(j).booleanValue()) {
                                        iVar.field_appType = 102;
                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOp;
                                        iVar.field_bzScene = 1;
                                    }
                                    if (g.ND().c(iVar)) {
                                        obj = 1;
                                    } else {
                                        h.mEJ.a(111, 205, 1, false);
                                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", new Object[]{gVar.dVk});
                                        gVar.dVk = "";
                                        obj = null;
                                    }
                                } else if (g.cC(j).booleanValue() || g.cE(j).booleanValue()) {
                                    com.tencent.mm.pluginsdk.model.app.b SR = ao.asF().SR(a.gp(dW.field_content).bGP);
                                    if (SR != null) {
                                        str4 = SR.field_fileFullPath;
                                        g.ND();
                                        if (com.tencent.mm.modelcdntran.c.hz(4) || SR.field_isUseCdn == 1) {
                                            if (!bi.oW(dW.field_imgPath)) {
                                                str = o.Pf().lN(dW.field_imgPath);
                                            }
                                            int cm = com.tencent.mm.a.e.cm(str);
                                            int cm2 = com.tencent.mm.a.e.cm(SR.field_fileFullPath);
                                            if (cm >= com.tencent.mm.modelcdntran.b.dOG) {
                                                x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[]{str, Integer.valueOf(cm)});
                                                obj = null;
                                            } else {
                                                gVar.dVk = d.a("upattach", SR.field_createTime, dW.field_talker, "0");
                                                if (bi.oW(gVar.dVk)) {
                                                    x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn compressType:%d", new Object[]{Integer.valueOf(0)});
                                                    obj = null;
                                                } else {
                                                    x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra checkUseCdn id:%d file[%s][%d] thumb[%s][%d]", new Object[]{Long.valueOf(SR.field_msgInfoId), SR.field_fileFullPath, Integer.valueOf(cm2), str, Integer.valueOf(cm)});
                                                    gVar.iuH = new Random().nextLong();
                                                    str4 = g.y(str4, gVar.iuH);
                                                    str = g.y(str, gVar.iuH);
                                                    iVar = new i();
                                                    iVar.dPV = gVar.dVu;
                                                    iVar.field_mediaId = gVar.dVk;
                                                    iVar.field_fullpath = str4;
                                                    iVar.field_thumbpath = str;
                                                    iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOt;
                                                    iVar.field_talker = dW.field_talker;
                                                    iVar.field_priority = com.tencent.mm.modelcdntran.b.dOj;
                                                    iVar.field_needStorage = false;
                                                    iVar.field_isStreamMedia = false;
                                                    iVar.field_appType = 202;
                                                    iVar.field_bzScene = 2;
                                                    if (!g.cC(j).booleanValue()) {
                                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOt;
                                                        iVar.field_appType = 202;
                                                    } else if (g.cF(j).booleanValue()) {
                                                        iVar.field_appType = 102;
                                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOp;
                                                        iVar.field_bzScene = 1;
                                                    }
                                                    if (g.ND().c(iVar)) {
                                                        obj = 1;
                                                    } else {
                                                        h.mEJ.a(111, 205, 1, false);
                                                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", new Object[]{gVar.dVk});
                                                        gVar.dVk = "";
                                                        obj = null;
                                                    }
                                                }
                                            }
                                        } else {
                                            objArr2 = new Object[2];
                                            g.ND();
                                            objArr2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hz(4));
                                            objArr2[1] = Integer.valueOf(SR.field_isUseCdn);
                                            x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", objArr2);
                                            obj = null;
                                        }
                                    } else {
                                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                                        obj = null;
                                    }
                                } else {
                                    if (g.cF(j).booleanValue()) {
                                        r nI = com.tencent.mm.modelvideo.o.Ta().nI(dW.field_imgPath);
                                        if (nI == null) {
                                            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Get info Failed file:" + dW.field_imgPath);
                                            obj = null;
                                        } else {
                                            g.ND();
                                            if (com.tencent.mm.modelcdntran.c.hz(2) || nI.enR == 1) {
                                                gVar.dVk = d.a("upvideo", nI.createTime, nI.Tj(), nI.getFileName());
                                                if (bi.oW(gVar.dVk)) {
                                                    x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra genClientId failed not use cdn file:%s", new Object[]{nI.getFileName()});
                                                    obj = null;
                                                } else {
                                                    com.tencent.mm.modelvideo.o.Ta();
                                                    str = s.nL(dW.field_imgPath);
                                                    com.tencent.mm.modelvideo.o.Ta();
                                                    str4 = s.nK(dW.field_imgPath);
                                                }
                                            } else {
                                                r5 = new Object[2];
                                                g.ND();
                                                r5[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hz(2));
                                                r5[1] = Integer.valueOf(nI.enR);
                                                x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra not use cdn flag:%b getCdnInfo:%d", r5);
                                                obj = null;
                                            }
                                        }
                                    }
                                    gVar.iuH = new Random().nextLong();
                                    str4 = g.y(str4, gVar.iuH);
                                    str = g.y(str, gVar.iuH);
                                    iVar = new i();
                                    iVar.dPV = gVar.dVu;
                                    iVar.field_mediaId = gVar.dVk;
                                    iVar.field_fullpath = str4;
                                    iVar.field_thumbpath = str;
                                    iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOt;
                                    iVar.field_talker = dW.field_talker;
                                    iVar.field_priority = com.tencent.mm.modelcdntran.b.dOj;
                                    iVar.field_needStorage = false;
                                    iVar.field_isStreamMedia = false;
                                    iVar.field_appType = 202;
                                    iVar.field_bzScene = 2;
                                    if (!g.cC(j).booleanValue()) {
                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOt;
                                        iVar.field_appType = 202;
                                    } else if (g.cF(j).booleanValue()) {
                                        iVar.field_appType = 102;
                                        iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOp;
                                        iVar.field_bzScene = 1;
                                    }
                                    if (g.ND().c(iVar)) {
                                        h.mEJ.a(111, 205, 1, false);
                                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra addSendTask failed. clientid:%s", new Object[]{gVar.dVk});
                                        gVar.dVk = "";
                                        obj = null;
                                    } else {
                                        obj = 1;
                                    }
                                }
                                if (obj == null) {
                                    g.cx(str3, gVar.iuB);
                                    gVar.iuE = false;
                                } else {
                                    gVar.iuE = true;
                                }
                            }
                        }
                        valueOf = Boolean.valueOf(true);
                        bVar2.bLW = valueOf.booleanValue();
                    }
                }
                i = i2;
            } else {
                i = 0;
            }
            amw amw = new amw();
            ate ate;
            if (!z) {
                gVar.a(amw, gVar.cYP);
            } else if (gVar.aGT().sqc.ruz != 1 || i != 0 || gVar.iuy != null) {
                if (str5 != null) {
                    bsu aGT = gVar.aGT();
                    switch (aGT.sqc.ruz) {
                        case 1:
                            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns photo!");
                            int i3 = -1;
                            String str6 = null;
                            String str7 = null;
                            str = null;
                            String str8 = gVar.iuy;
                            if (str8 != null && str8.length() > 0) {
                                File file = new File(str8);
                                str7 = file.getName();
                                i3 = (int) file.length();
                                str = str7.substring(str7.lastIndexOf(".") + 1, str7.length());
                                str6 = com.tencent.mm.a.g.m(file);
                                x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "dataSnsInit filePath %s, fileSize %s, fileMd5 %s", new Object[]{str8, Integer.valueOf(i3), str6});
                            }
                            amx amx = new amx();
                            amx.rxo = str;
                            amx.jPe = str7;
                            amx.hcy = i3;
                            amx.rwk = str6;
                            if (i == 1) {
                                ate = (ate) aGT.sqc.ruA.get(gVar.iuz);
                                if (ate == null) {
                                    x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                                    break;
                                }
                                amx.jPK = ate.jPK;
                                amx.rPJ = ate.rVV;
                                if (!bi.oW(amx.rPJ)) {
                                    amx.jPK += "?idx=" + ate.rVU + "&token=" + ate.rVT;
                                }
                            }
                            amw.rPF = amx;
                            amw.rPC = 3;
                            break;
                        case 3:
                            ate = (ate) aGT.sqc.ruA.get(0);
                            if (ate != null) {
                                gVar.iuv = true;
                                ana ana = new ana();
                                ana.jPK = ate.jPK;
                                ana.bHD = ate.bHD;
                                ana.rPM = ate.jOS;
                                amw.rPH = ana;
                                amw.rPC = 5;
                                break;
                            }
                            x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObUrl is null");
                            break;
                        case 4:
                            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns music!");
                            ate = (ate) aGT.sqc.ruA.get(0);
                            if (ate != null) {
                                gVar.iuv = true;
                                amz amz = new amz();
                                amz.bHD = ate.bHD;
                                amz.rPM = ate.jOS;
                                amz.jPK = aGT.sqc.jPK;
                                amz.rst = ate.jPK;
                                amz.rPO = ate.rVI;
                                amz.jSv = aGT.sqb.jSv;
                                amw.rPD = amz;
                                amw.rPC = 1;
                                break;
                            }
                            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObj is null");
                            break;
                        case 15:
                            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "is sns sight!");
                            ate = (ate) aGT.sqc.ruA.get(0);
                            if (ate != null) {
                                gVar.iuv = true;
                                anb anb = new anb();
                                anb.jPK = ate.jPK;
                                x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "videoMsg.url = %s", new Object[]{anb.jPK});
                                amw.rPI = anb;
                                amw.rPC = 6;
                                break;
                            }
                            x.w("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjSight is null");
                            break;
                    }
                }
            } else {
                gVar.iuS = amw;
                gVar.iuT = str2;
                gVar.iuU = str3;
                gVar.iuV = 0;
                ate = (ate) gVar.aGT().sqc.ruA.get(gVar.iuz);
                if (ate == null) {
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mediaObjImage is null");
                    g.cx(str3, gVar.iuB);
                } else {
                    gVar.bSW = ate.jPK;
                    com.tencent.mm.sdk.f.e.post(gVar.iuR, "ExdeviceDownloadImage");
                }
                valueOf = Boolean.valueOf(true);
                bVar2.bLW = valueOf.booleanValue();
            }
            au.DF().a(new n(amw, str2, str3, i), 0);
            valueOf = Boolean.valueOf(true);
            bVar2.bLW = valueOf.booleanValue();
        }
        return true;
    }
}
