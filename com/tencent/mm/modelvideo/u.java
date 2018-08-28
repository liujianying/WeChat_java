package com.tencent.mm.modelvideo;

import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class u implements d {
    public final b b(a aVar) {
        by byVar = aVar.dIN;
        if (byVar == null) {
            x.e("MicroMsg.VideoMsgExtension", "onPreAddMessage cmdAM is null , give up.");
            return null;
        }
        String str;
        String str2 = (String) g.Ei().DT().get(2, "");
        String a = ab.a(byVar.rck);
        String a2 = ab.a(byVar.rcj);
        boolean z = ((i) g.l(i.class)).FZ().has(a2) || str2.equals(a2);
        x.d("MicroMsg.VideoMsgExtension", "video msg fromuser %s, toUser %s, userName %s, isSender %b", new Object[]{a2, a, str2, Boolean.valueOf(z)});
        f bcY = ((i) g.l(i.class)).bcY();
        if (str2.equals(a2)) {
            str = a;
        } else {
            str = a2;
        }
        bd I = bcY.I(str, byVar.rcq);
        x.i("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo svrid:%d localid:%d, flag:%d, msgseq:%d, addMsgInfo[%s]", new Object[]{Long.valueOf(byVar.rcq), Long.valueOf(I.field_msgId), Integer.valueOf(I.field_flag), Long.valueOf(I.field_msgSeq), aVar});
        if (I.field_msgId != 0 && I.field_createTime + 604800000 < com.tencent.mm.model.bd.o(a2, (long) byVar.lOH)) {
            x.w("MicroMsg.VideoMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", new Object[]{Long.valueOf(byVar.rcq), Long.valueOf(I.field_msgId)});
            com.tencent.mm.model.bd.aU(I.field_msgId);
            I.setMsgId(0);
        }
        if (I.field_msgId != 0) {
            x.d("MicroMsg.VideoMsgExtension", "Msgid:%d duplicate give up ", new Object[]{Long.valueOf(byVar.rcq)});
            return null;
        }
        String a3 = ab.a(byVar.rcl);
        r rVar = new r();
        if (z) {
            a2 = a;
        }
        rVar.bWJ = a2;
        rVar.createTime = (long) byVar.lOH;
        rVar.bYu = byVar.rcq;
        rVar.enS = byVar.rcl.siM;
        x.i("MicroMsg.VideoMsgExtension", "parseVideoMsgXml [%s] msg Source[%s]", new Object[]{a3, byVar.rco});
        Map z2 = bl.z(a3, "msg");
        if (z2 == null) {
            h.mEJ.a(111, 216, 1, false);
            return null;
        }
        bd bdVar = new bd();
        bdVar.dt(byVar.rco);
        bdVar.ev(com.tencent.mm.model.bd.iG(byVar.rco));
        try {
            rVar.dHI = bi.getInt((String) z2.get(".msg.videomsg.$length"), 0);
            rVar.enM = bi.getInt((String) z2.get(".msg.videomsg.$playlength"), 0);
            x.i("MicroMsg.VideoMsgExtension", "video msg total len %d, video len %d", new Object[]{Integer.valueOf(rVar.dHI), Integer.valueOf(rVar.enM)});
            rVar.enF = (String) z2.get(".msg.videomsg.$fromusername");
            if (str2.equals(rVar.Tk())) {
                rVar.enF = a;
            }
            rVar.bZN = (String) z2.get(".msg.statextstr");
            str2 = (String) z2.get(".msg.videomsg.$cdnthumbaeskey");
            String str3 = (String) z2.get(".msg.videomsg.$cdnthumburl");
            int i = bi.getInt((String) z2.get(".msg.videomsg.$cdnthumblength"), 0);
            str = (String) z2.get(".msg.videomsg.$tpvideourl");
            final String str4 = (String) z2.get(".msg.videomsg.$tpthumburl");
            String str5 = (String) z2.get(".msg.videomsg.$tpauthkey");
            String str6 = (String) z2.get(".msg.videomsg.$tpthumbaeskey");
            final int i2 = bi.getInt((String) z2.get(".msg.videomsg.$tpthumblength"), 0);
            int i3 = bi.getInt((String) z2.get(".msg.videomsg.$type"), 0);
            x.d("MicroMsg.VideoMsgExtension", "video msg exportType :" + i3);
            rVar.enQ = i3 == 44 ? 1 : 0;
            if (62 == byVar.jQd) {
                rVar.enT = 3;
            } else if (i3 > 0) {
                rVar.enT = 2;
            } else {
                rVar.enT = 1;
            }
            String aG = bi.aG((String) z2.get(".msg.streamvideo.streamvideourl"), "");
            int i4 = bi.getInt((String) z2.get(".msg.streamvideo.streamvideototaltime"), 0);
            String aG2 = bi.aG((String) z2.get(".msg.streamvideo.streamvideotitle"), "");
            String aG3 = bi.aG((String) z2.get(".msg.streamvideo.streamvideowording"), "");
            String aG4 = bi.aG((String) z2.get(".msg.streamvideo.streamvideoweburl"), "");
            String aG5 = bi.aG((String) z2.get(".msg.streamvideo.streamvideoaduxinfo"), "");
            a = bi.aG((String) z2.get(".msg.streamvideo.streamvideopublishid"), "");
            if (rVar.enV == null) {
                rVar.enV = new bri();
            }
            rVar.enV.dyL = aG2;
            rVar.enV.rBq = i4;
            rVar.enV.dyJ = aG;
            rVar.enV.dyM = aG3;
            rVar.enV.dyN = aG4;
            rVar.enV.dyP = aG5;
            rVar.enV.dyQ = a;
            if (rVar.Tk().equals((String) g.Ei().DT().get(2, ""))) {
                return null;
            }
            a = (String) z2.get(".msg.commenturl");
            Map z3 = bl.z(a3, "msgoperation");
            if (z3 != null) {
                bdVar.ew((String) z3.get(".msgoperation.expinfo.expidstr"));
                bdVar.fk(bi.getInt((String) z3.get(".msgoperation.sightmsg.downloadcontroltype"), 0));
                x.i("MicroMsg.VideoMsgExtension", "[chatting_exp] expidstr:%s, downloadcontroltype:%d", new Object[]{bdVar.cGK, Integer.valueOf(bdVar.cGL)});
            }
            a3 = s.nJ(rVar.Tk());
            rVar.fileName = a3;
            bdVar.ax(rVar.bYu);
            bdVar.eq(rVar.getFileName());
            bdVar.ay(com.tencent.mm.model.bd.o(rVar.Tj(), rVar.createTime));
            bdVar.ep(rVar.Tj());
            bdVar.setStatus(byVar.hcd);
            bdVar.eX(z ? 1 : 0);
            if (byVar.jQd == 62) {
                bdVar.setType(62);
            } else {
                bdVar.setType(43);
            }
            bdVar.setContent(p.b(rVar.Tk(), 0, false));
            bdVar.eu(a);
            bdVar.dt(byVar.rco);
            com.tencent.mm.model.bd.a(bdVar, aVar);
            long i5 = com.tencent.mm.model.bd.i(bdVar);
            if (i5 <= 0) {
                h.mEJ.a(111, 215, 1, false);
                x.e("MicroMsg.VideoMsgExtension", "onPreAddMessage insert msg failed local:%d svrid:%d", new Object[]{Long.valueOf(i5), Long.valueOf(rVar.bYu)});
                return null;
            }
            rVar.enN = (int) i5;
            rVar.enK = bi.VE();
            rVar.enO = 0;
            rVar.status = 111;
            x.d("MicroMsg.VideoMsgExtension", "Insert fileName[" + rVar.getFileName() + "] size:" + rVar.dHI + " svrid:" + rVar.bYu + " timelen:" + rVar.enM + " user:" + rVar.Tj() + " human:" + rVar.Tk());
            if (o.Ta().a(rVar)) {
                o.Ta();
                final String nL = s.nL(a3);
                byte[] a4 = ab.a(byVar.rcn);
                x.i("MicroMsg.VideoMsgExtension", "imgBuf  :%d", new Object[]{Integer.valueOf(bi.bD(a4))});
                if (af.exs) {
                    x.w("MicroMsg.VideoMsgExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a4 = null;
                }
                long j;
                long VF;
                String str7;
                if (!bi.bC(a4)) {
                    s.a(nL, 0, a4);
                } else if (bi.oW(str)) {
                    j = rVar.bYu;
                    x.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[]{Long.valueOf(j), rVar.Tj(), str3, nL});
                    VF = bi.VF();
                    str7 = nL + ".tmp";
                    com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
                    iVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downvideothumb", rVar.createTime, rVar.Tj(), String.valueOf(j));
                    iVar.field_fullpath = str7;
                    iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                    iVar.field_totalLen = i;
                    iVar.field_aesKey = str2;
                    iVar.field_fileId = str3;
                    iVar.field_priority = com.tencent.mm.modelcdntran.b.dOl;
                    iVar.field_chattype = s.fq(rVar.Tj()) ? 1 : 0;
                    x.d("MicroMsg.VideoMsgExtension", "get thumb by cdn [video] chatType[%d] user[%s] ", new Object[]{Integer.valueOf(iVar.field_chattype), rVar.Tj()});
                    iVar.dPV = new 2(this, j, rVar, nL, str3, i, str7, VF);
                    com.tencent.mm.modelcdntran.g.ND().b(iVar, -1);
                } else {
                    j = rVar.bYu;
                    x.i("MicroMsg.VideoMsgExtension", "getThumbByCdn msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[]{Long.valueOf(j), rVar.Tj(), str4, nL});
                    VF = bi.VF();
                    str7 = nL + ".tmp";
                    com.tencent.mm.modelcdntran.i iVar2 = new com.tencent.mm.modelcdntran.i();
                    iVar2.field_mediaId = com.tencent.mm.modelcdntran.d.a("downvideothumb", rVar.createTime, rVar.Tj(), String.valueOf(j));
                    iVar2.field_fullpath = str7;
                    iVar2.field_fileType = 19;
                    iVar2.field_aesKey = str6;
                    iVar2.field_authKey = str5;
                    iVar2.dPW = str4;
                    final r rVar2 = rVar;
                    iVar2.dPV = new com.tencent.mm.modelcdntran.i.a() {
                        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                            return u.a(i, keep_sceneresult, j, rVar2, nL, str4, i2, str7, VF);
                        }

                        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                        }

                        public final byte[] i(String str, byte[] bArr) {
                            return new byte[0];
                        }
                    };
                    com.tencent.mm.modelcdntran.g.ND().b(iVar2, -1);
                }
                if (bdVar.cmk()) {
                    Object obj;
                    c.NM();
                    if (bdVar.cGL == 1) {
                        obj = 1;
                    } else if (bdVar.cGL == 2) {
                        obj = null;
                    } else if (c.p(bdVar)) {
                        str2 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("C2CSightNotAutoDownloadTimeRange");
                        x.i("MicroMsg.BusyTimeControlLogic", "C2CSightNotAutoDownloadTimeRange value: " + str2);
                        if (com.tencent.mm.modelcontrol.b.lz(str2)) {
                            x.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C short video.");
                            obj = null;
                        } else {
                            str = bdVar.field_talker;
                            x.d("MicroMsg.SubCoreAutoDownload", "isC2CSightAutoDownload msg talker: " + str);
                            int i6 = bi.getInt(((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("SIGHTSessionAutoLoadNetwork"), 1);
                            com.tencent.mm.storage.ab Yg;
                            if (i6 == 3) {
                                x.i("MicroMsg.SubCoreAutoDownload", "setting is not download sight automate, %d, %d", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId)});
                                obj = null;
                            } else if (ao.isWifi(ad.getContext())) {
                                x.i("MicroMsg.SubCoreAutoDownload", "match wifi, do auto download short video [msgid-%d-%d] [%s]", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId), bdVar.field_imgPath});
                                Yg = ((i) g.l(i.class)).FR().Yg(str);
                                if (Yg == null || ((int) Yg.dhP) <= 0 || !((str.endsWith("@chatroom") && Yg.csI == 0) || Yg.BD())) {
                                    obj = 1;
                                } else {
                                    x.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C short video.");
                                    obj = null;
                                }
                            } else if (ao.is2G(ad.getContext())) {
                                x.i("MicroMsg.SubCoreAutoDownload", "match edge, do not auto download short video [msgid-%d-%d] [%s]", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId), bdVar.field_imgPath});
                                obj = null;
                            } else {
                                Yg = ((i) g.l(i.class)).FR().Yg(bdVar.field_talker);
                                if (s.fq(bdVar.field_talker)) {
                                    if (Yg.csI == 0) {
                                        x.i("MicroMsg.SubCoreAutoDownload", "match muted chatroom and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId), bdVar.field_imgPath});
                                        obj = null;
                                    } else if ((ao.is3G(ad.getContext()) || ao.is4G(ad.getContext())) && i6 == 1) {
                                        x.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted chatroom, do auto download short video [msgid-%d-%d] [%s]", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId), bdVar.field_imgPath});
                                        obj = 1;
                                    } else {
                                        x.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step A");
                                        obj = null;
                                    }
                                } else if (Yg.BD()) {
                                    x.i("MicroMsg.SubCoreAutoDownload", "match muted and not wifi, do not auto download short video [msgid-%d-%d] [%s]", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId), bdVar.field_imgPath});
                                    obj = null;
                                } else if ((ao.is3G(ad.getContext()) || ao.is4G(ad.getContext())) && i6 == 1) {
                                    x.i("MicroMsg.SubCoreAutoDownload", "match 3G/4G and unmuted, do auto download short video [msgid-%d-%d] [%s]", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId), bdVar.field_imgPath});
                                    obj = 1;
                                } else {
                                    x.i("MicroMsg.SubCoreAutoDownload", "unknown auto download short video step B");
                                    obj = null;
                                }
                            }
                        }
                    } else {
                        x.i("MicroMsg.SubCoreAutoDownload", "this message need control, do not auto download C2C short video.");
                        obj = null;
                    }
                    if (obj != null) {
                        t.nS(bdVar.field_imgPath);
                        com.tencent.mm.modelcdntran.g.ND().dPa.add("video_" + bdVar.field_msgId);
                    }
                }
                int i7 = 1;
                int i8 = 0;
                if (s.fq(rVar.Tj())) {
                    i8 = m.gK(rVar.Tj());
                    if (s.hT(rVar.Tj()) || !s.hS(rVar.Tj())) {
                        i7 = 2;
                    } else {
                        i7 = 3;
                    }
                }
                h.mEJ.h(14388, new Object[]{Long.valueOf(bdVar.field_msgSvrId), Integer.valueOf(i7), "", Integer.valueOf(i8)});
                i Tc = o.Tc();
                synchronized (Tc.emG) {
                    Tc.emG.offerFirst(bdVar);
                }
                Tc.ST();
                return new b(bdVar, true);
            }
            x.d("MicroMsg.VideoMsgExtension", "Insert Error fileName:" + rVar.getFileName());
            return null;
        } catch (Throwable e) {
            h.mEJ.a(111, 216, 1, false);
            x.e("MicroMsg.VideoMsgExtension", "parsing voice msg xml failed");
            x.e("MicroMsg.VideoMsgExtension", "exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final void h(bd bdVar) {
        int i = 1;
        if (bdVar != null) {
            String str = bdVar.field_imgPath;
            if (!bi.oW(str)) {
                s Ta = o.Ta();
                if (Ta.dCZ.delete("videoinfo2", "filename= ?", new String[]{str}) > 0) {
                    Ta.dHn.ci(new s$a$a(str, s.a.b.eog, s.a.c.eoj, 1, -1));
                    Ta.dHn.doNotify();
                } else {
                    i = 0;
                }
                if (i != 0) {
                    try {
                        o.Ta();
                        new File(s.nL(str)).delete();
                        o.Ta();
                        new File(s.nK(str)).delete();
                    } catch (Exception e) {
                        x.e("MicroMsg.VideoLogic", "ERR: Delete file Failed" + com.tencent.mm.compatible.util.g.Ac() + " file:" + str + " msg:" + e.getMessage());
                    }
                }
            }
        }
    }

    public static int a(int i, keep_SceneResult keep_sceneresult, long j, r rVar, String str, String str2, int i2, String str3, long j2) {
        if (i != 0) {
            x.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. startRet:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[]{Integer.valueOf(i), Long.valueOf(j), rVar.Tj(), str2, str});
            h.mEJ.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(j2), Long.valueOf(bi.VF()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bL(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(i2), ""});
            return i;
        } else if (keep_sceneresult == null) {
            return 0;
        } else {
            if (keep_sceneresult.field_retCode != 0) {
                x.e("MicroMsg.VideoMsgExtension", "getThumbByCdn failed. sceneResult.field_retCode:%d msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), Long.valueOf(j), rVar.Tj(), str2, str});
            } else {
                new File(str3).renameTo(new File(str));
                x.i("MicroMsg.VideoMsgExtension", "getThumbByCdn succ. msgSvrId:%d user:%s thumbUrl:%s thumbPath:%s", new Object[]{Long.valueOf(j), rVar.Tj(), str2, str});
                if (rVar.enT == 3) {
                    h.mEJ.a(198, 6, (long) i2, false);
                    h.mEJ.a(198, 7, 1, false);
                    h.mEJ.a(198, s.fq(rVar.Tj()) ? 9 : 8, 1, false);
                } else {
                    h.mEJ.a(198, 11, (long) i2, false);
                    h.mEJ.a(198, 12, 1, false);
                    h.mEJ.a(198, s.fq(rVar.Tj()) ? 14 : 13, 1, false);
                }
            }
            h hVar = h.mEJ;
            Object[] objArr = new Object[16];
            objArr[0] = Integer.valueOf(keep_sceneresult == null ? -1 : keep_sceneresult.field_retCode);
            objArr[1] = Integer.valueOf(2);
            objArr[2] = Long.valueOf(j2);
            objArr[3] = Long.valueOf(bi.VF());
            objArr[4] = Integer.valueOf(com.tencent.mm.modelcdntran.d.bL(ad.getContext()));
            objArr[5] = Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE);
            objArr[6] = Integer.valueOf(i2);
            objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
            objArr[8] = "";
            objArr[9] = "";
            objArr[10] = "";
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = "";
            objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
            hVar.h(10421, objArr);
            if (!(keep_sceneresult == null || keep_sceneresult.field_retCode == 0)) {
                hVar = h.mEJ;
                objArr = new Object[16];
                objArr[0] = Integer.valueOf(keep_sceneresult == null ? -1 : keep_sceneresult.field_retCode);
                objArr[1] = Integer.valueOf(2);
                objArr[2] = Long.valueOf(j2);
                objArr[3] = Long.valueOf(bi.VF());
                objArr[4] = Integer.valueOf(com.tencent.mm.modelcdntran.d.bL(ad.getContext()));
                objArr[5] = Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE);
                objArr[6] = Integer.valueOf(i2);
                objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
                objArr[8] = "";
                objArr[9] = "";
                objArr[10] = "";
                objArr[11] = "";
                objArr[12] = "";
                objArr[13] = "";
                objArr[14] = "";
                objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
                hVar.h(13937, objArr);
            }
            s Ta = o.Ta();
            String fileName = rVar.getFileName();
            s.a.c cVar = s.a.c.eoj;
            if (!bi.oW(fileName)) {
                r nI = Ta.nI(fileName);
                if (nI != null) {
                    Ta.dHn.ci(new s$a$a(nI.getFileName(), s.a.b.eoh, cVar, nI.enT, nI.emf));
                    Ta.dHn.doNotify();
                }
            }
            return 0;
        }
    }
}
