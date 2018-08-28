package com.tencent.mm.modelcdntran;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.b.b;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements e, b, m.b {
    private int dOQ = -1;
    ag dOR = new 1(this, Looper.getMainLooper());
    com.tencent.mm.sdk.b.c<jb> dOS = new 2(this);
    n dOT = new 3(this);
    Queue<String> dOU = new LinkedList();
    public Map<String, i> dOV = new HashMap();
    public Map<String, i> dOW = new ConcurrentHashMap();
    public Map<String, Integer> dOX = new HashMap();
    private String dOY = "";
    private long dOZ = 0;
    public HashSet<String> dPa = new HashSet();

    public final void a(int i, m mVar, Object obj) {
        if (g.Eg().Dx()) {
            int p = bi.p(obj, 0);
            x.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(p), mVar});
            if (mVar != g.Ei().DT() || p <= 0) {
                x.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(p), mVar});
            } else if (p == 144385) {
                g.NA().NF();
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 379) {
            x.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
            if (g.Eg().Dx()) {
                g.Em().H(new 4(this));
            }
        }
    }

    public static boolean hz(int i) {
        g.Eg();
        if (!a.Dw()) {
            return true;
        }
        x.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b", new Object[]{Integer.valueOf(bi.a((Integer) g.Ei().DT().get(144385, null), 0)), Integer.valueOf(i), Integer.valueOf(bi.a((Integer) g.Ei().DT().get(144385, null), 0) & i), Boolean.valueOf(af.exg)});
        if (af.exg) {
            return true;
        }
        return (r0 & i) > 0;
    }

    public c() {
        g.Eh().a(this.dOT);
        if (g.Eg().Dx()) {
            g.Ei().DT().a(this);
        }
        g.DF().a(379, this);
        com.tencent.mm.sdk.b.a.sFg.b(this.dOS);
        x.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", new Object[]{Integer.valueOf(hashCode()), bi.cjd()});
    }

    public final void hA(int i) {
        this.dOQ = i;
    }

    public final boolean b(i iVar, int i) {
        if (iVar == null) {
            x.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
            return false;
        } else if (bi.oW(iVar.field_mediaId)) {
            x.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
            return false;
        } else {
            if (iVar.field_fileId == null) {
                iVar.field_fileId = "";
            }
            if (iVar.field_aesKey == null) {
                iVar.field_aesKey = "";
            }
            iVar.ceW = false;
            g.Em().H(new 5(this, i, iVar));
            return true;
        }
    }

    public final boolean c(i iVar) {
        if (bi.oW(iVar.field_mediaId)) {
            x.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
            return false;
        }
        if (iVar.field_fileId == null) {
            iVar.field_fileId = "";
        }
        if (iVar.field_aesKey == null) {
            iVar.field_aesKey = "";
        }
        iVar.ceW = true;
        g.Em().H(new 6(this, iVar));
        return true;
    }

    public final boolean lw(String str) {
        if (((i) this.dOW.remove(str)) != null) {
            g.NE();
            b.lo(str);
            h.mEJ.h(10769, new Object[]{Integer.valueOf(d.dPr), Integer.valueOf(r0.field_fileType), Long.valueOf(bi.VF() - r0.field_startTime)});
        }
        this.dOV.remove(str);
        x.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", new Object[]{str, r0, Integer.valueOf(0)});
        return true;
    }

    public final boolean lx(String str) {
        i iVar = (i) this.dOW.remove(str);
        if (iVar != null) {
            if (iVar.field_fileType == b.dOw || iVar.field_fileType == b.dOy) {
                g.NE();
                b.lt(str);
            } else if (iVar.dQc) {
                g.NE();
                b.lu(str);
            } else {
                g.NE();
                b.lp(str);
            }
            h.mEJ.h(10769, new Object[]{Integer.valueOf(d.dPq), Integer.valueOf(iVar.field_fileType), Long.valueOf(bi.VF() - iVar.field_startTime)});
        }
        this.dOV.remove(str);
        this.dOX.remove(str);
        x.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[]{str, iVar, Integer.valueOf(0)});
        return true;
    }

    public final void bH(boolean z) {
        if (!z && g.NE().Nx()) {
            g.Eg();
            if (a.Dw()) {
                x.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
                g.NA().NF();
                return;
            }
        }
        Ny();
        x.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", new Object[]{Integer.valueOf(this.dOU.size())});
        while (!this.dOU.isEmpty()) {
            i iVar = (i) this.dOV.remove((String) this.dOU.poll());
            if (iVar == null) {
                x.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
                return;
            }
            x.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", new Object[]{iVar.field_mediaId, Boolean.valueOf(iVar.field_autostart), Integer.valueOf(iVar.field_chattype)});
            iVar.field_startTime = bi.VF();
            String str;
            int i;
            i iVar2;
            int b;
            String str2;
            Object[] objArr;
            if (iVar.ceW) {
                String str3;
                String str4 = "MicroMsg.CdnTransportService";
                str = "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]";
                Object[] objArr2 = new Object[8];
                if (iVar.field_fullpath == null) {
                    i = -1;
                } else {
                    i = iVar.field_fullpath.length();
                }
                objArr2[0] = Integer.valueOf(i);
                if (iVar.field_thumbpath == null) {
                    i = -1;
                } else {
                    i = iVar.field_thumbpath.length();
                }
                objArr2[1] = Integer.valueOf(i);
                objArr2[2] = bi.Xf(iVar.field_svr_signature);
                objArr2[3] = bi.Xf(iVar.field_aesKey);
                objArr2[4] = Integer.valueOf(iVar.field_fileType);
                objArr2[5] = iVar.field_mediaId;
                objArr2[6] = Boolean.valueOf(iVar.field_onlycheckexist);
                objArr2[7] = Integer.valueOf(iVar.field_largesvideo);
                x.i(str4, str, objArr2);
                if (iVar.field_fullpath == null) {
                    iVar.field_fullpath = "";
                }
                if (iVar.field_thumbpath == null) {
                    iVar.field_thumbpath = "";
                }
                iVar2 = (i) this.dOW.put(iVar.field_mediaId, iVar);
                i iVar3 = (i) this.dOW.get(iVar.field_mediaId);
                if (iVar3 == null) {
                    h.mEJ.a(594, 5, 1, true);
                }
                g.NE();
                b = b.b(iVar);
                str4 = "MicroMsg.CdnTransportService";
                str2 = "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]";
                objArr = new Object[5];
                objArr[0] = iVar.field_mediaId;
                objArr[1] = Integer.valueOf(b);
                objArr[2] = iVar2 == null ? null : iVar2.field_mediaId;
                if (iVar3 == null) {
                    str3 = null;
                } else {
                    str3 = iVar3.field_mediaId;
                }
                objArr[3] = str3;
                objArr[4] = Integer.valueOf(hashCode());
                x.i(str4, str2, objArr);
                if (b != 0) {
                    iVar2 = (i) this.dOW.remove(iVar.field_mediaId);
                    x.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", new Object[]{Integer.valueOf(b), iVar.field_mediaId, iVar2});
                    if (iVar.dPV != null) {
                        iVar.dPV.a(iVar.field_mediaId, b, null, null, iVar.field_onlycheckexist);
                    }
                }
            } else {
                i = -1;
                int i2;
                if (iVar.field_fileType == 19) {
                    g.NE();
                    b = b.a(iVar.field_mediaId, iVar.dPW, iVar.field_fullpath, iVar.field_fileType, iVar.field_aesKey, iVar.field_authKey);
                } else if (iVar.field_fileType == b.dOw || iVar.field_fileType == b.dOy) {
                    if (!(iVar.field_fullpath == null || iVar.field_fullpath.isEmpty())) {
                        g.NE();
                        i = b.a(iVar.field_mediaId, iVar.dPW, iVar.field_fullpath, iVar.field_fileType, iVar.dPX, iVar.dPY, iVar.dPZ, iVar.dQa);
                    }
                    str = "MicroMsg.CdnTransportService";
                    str2 = "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]";
                    objArr = new Object[4];
                    if (iVar.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = iVar.field_fullpath.length();
                    }
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = iVar.field_mediaId;
                    objArr[2] = iVar.dPW;
                    objArr[3] = Integer.valueOf(iVar.field_fileType);
                    x.i(str, str2, objArr);
                    b = i;
                } else if (iVar.dQc) {
                    if (!(iVar.field_fullpath == null || iVar.field_fullpath.isEmpty())) {
                        g.NE();
                        i = b.a(iVar.field_mediaId, iVar.field_fullpath, iVar.dPW, iVar.dQd, iVar.dQe, iVar.allow_mobile_net_download, iVar.dPX, iVar.dPY, iVar.is_resume_task, iVar.dQb, iVar.dPZ);
                    }
                    str = "MicroMsg.CdnTransportService";
                    str2 = "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]";
                    objArr = new Object[4];
                    if (iVar.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = iVar.field_fullpath.length();
                    }
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = iVar.field_mediaId;
                    objArr[2] = iVar.dPW;
                    objArr[3] = iVar.dQd;
                    x.i(str, str2, objArr);
                    b = i;
                } else {
                    if (!iVar.dQf) {
                        str = "MicroMsg.CdnTransportService";
                        str2 = "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                        objArr = new Object[7];
                        if (iVar.field_fullpath == null) {
                            i2 = -1;
                        } else {
                            i2 = iVar.field_fullpath.length();
                        }
                        objArr[0] = Integer.valueOf(i2);
                        if (iVar.field_thumbpath == null) {
                            i2 = -1;
                        } else {
                            i2 = iVar.field_thumbpath.length();
                        }
                        objArr[1] = Integer.valueOf(i2);
                        objArr[2] = iVar.field_svr_signature;
                        objArr[3] = iVar.field_aesKey;
                        objArr[4] = Integer.valueOf(iVar.field_fileType);
                        objArr[5] = iVar.field_mediaId;
                        objArr[6] = Boolean.valueOf(iVar.field_onlycheckexist);
                        x.i(str, str2, objArr);
                        if (iVar.dQg != 2) {
                            g.NE();
                            b = CdnLogic.startC2CDownload(b.a(iVar));
                        } else if (iVar instanceof j) {
                            j jVar = (j) iVar;
                            if (jVar.NI()) {
                                g.NE();
                                b = b.a(iVar, 2);
                            } else if (jVar.NG()) {
                                g.NE();
                                b = b.a(jVar.field_mediaId, jVar.url, jVar.referer, jVar.field_fullpath, jVar.dQm, jVar.dPQ, jVar.initialDownloadOffset, jVar.initialDownloadLength, jVar.isColdSnsData, jVar.signalQuality, jVar.snsScene, jVar.field_preloadRatio);
                            } else {
                                if (jVar.NH()) {
                                    g.NE();
                                    i = b.a(jVar.field_mediaId, jVar.url, jVar.referer, jVar.field_fullpath, jVar.dQm, jVar.field_preloadRatio, jVar.concurrentCount);
                                }
                                b = i;
                            }
                        }
                    } else if (iVar instanceof h) {
                        h hVar = (h) iVar;
                        g.NE();
                        b = b.a(hVar.field_mediaId, hVar.url, hVar.referer, hVar.dPP, hVar.dPQ, hVar.dPR, hVar.dPS, hVar.dPT, hVar.isColdSnsData, hVar.signalQuality, hVar.snsScene, hVar.snsCipherKey, hVar.csS, hVar.dPU, hVar.fileType);
                    }
                    b = -1;
                }
                if (b != 0) {
                    x.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", new Object[]{Integer.valueOf(b), iVar.field_mediaId});
                    if (iVar.dPV != null) {
                        iVar.dPV.a(iVar.field_mediaId, b, null, null, iVar.field_onlycheckexist);
                    }
                } else {
                    iVar2 = (i) this.dOW.put(iVar.field_mediaId, iVar);
                    i iVar4 = (i) this.dOW.get(iVar.field_mediaId);
                    if (iVar4 == null) {
                        h.mEJ.a(594, 6, 1, true);
                    }
                    str2 = "MicroMsg.CdnTransportService";
                    String str5 = "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]";
                    Object[] objArr3 = new Object[5];
                    objArr3[0] = iVar.field_mediaId;
                    objArr3[1] = Integer.valueOf(b);
                    objArr3[2] = iVar2 == null ? null : iVar2.field_mediaId;
                    objArr3[3] = iVar4 == null ? null : iVar4.field_mediaId;
                    objArr3[4] = Integer.valueOf(hashCode());
                    x.i(str2, str5, objArr3);
                }
            }
        }
    }

    public final void Ny() {
        g.Eg();
        if (a.Dw()) {
            com.tencent.mm.modelcdntran.b.c cVar = new com.tencent.mm.modelcdntran.b.c(g.NE());
            String value = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("EnableCDNUploadImg");
            String value2 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("EnableCDNVerifyConnect");
            String value3 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("EnableCDNVideoRedirectOC");
            String value4 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("EnableStreamUploadVideo");
            String value5 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("C2COverloadDelaySeconds");
            String value6 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("SNSOverloadDelaySeconds");
            String value7 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("EnableSnsStreamDownload");
            String value8 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("EnableSnsImageDownload");
            String value9 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("ApprovedVideoPrivateProtocolHosts");
            try {
                if (!bi.oW(value)) {
                    cVar.field_UseStreamCDN = Integer.valueOf(value).intValue();
                }
                if (!bi.oW(value2)) {
                    cVar.field_EnableCDNVerifyConnect = Integer.valueOf(value2).intValue();
                }
                if (!bi.oW(value3)) {
                    cVar.field_EnableCDNVideoRedirectOC = Integer.valueOf(value3).intValue();
                }
                if (!bi.oW(value4)) {
                    cVar.field_EnableStreamUploadVideo = Integer.valueOf(value4).intValue();
                }
                if (!bi.oW(value5)) {
                    cVar.field_C2COverloadDelaySeconds = Integer.valueOf(value5).intValue();
                }
                if (!bi.oW(value6)) {
                    cVar.field_SNSOverloadDelaySeconds = Integer.valueOf(value6).intValue();
                }
                if (!bi.oW(value7)) {
                    cVar.field_EnableSnsStreamDownload = Integer.valueOf(value7).intValue();
                }
                if (!bi.oW(value8)) {
                    cVar.field_EnableSnsImageDownload = Integer.valueOf(value8).intValue();
                }
                if (!bi.oW(value9)) {
                    cVar.field_ApprovedVideoHosts = value9;
                }
                g.ND();
                cVar.field_EnableSafeCDN = hz(256) ? 1 : 0;
                if (cVar.field_UseStreamCDN != 0) {
                    value = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("ProgJPEGUploadSizeLimitWifi");
                    value2 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("ProgJPEGUploadSizeLimit3G");
                    value3 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("ProgJPEGDownloadSizeLimit");
                    value4 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("ProgJPEGOnlyRecvPTL");
                    value5 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("EnableJPEGDyncmicETL");
                    if (!bi.oW(value)) {
                        cVar.field_WifiEtl = Integer.valueOf(value).intValue();
                    }
                    if (!bi.oW(value2)) {
                        cVar.field_noWifiEtl = Integer.valueOf(value2).intValue();
                    }
                    if (!bi.oW(value3)) {
                        cVar.field_Ptl = Integer.valueOf(value3).intValue();
                    }
                    if (!bi.oW(value4)) {
                        cVar.field_onlyrecvPtl = Integer.valueOf(value4).intValue() != 0;
                    }
                    if (!bi.oW(value5)) {
                        cVar.field_UseDynamicETL = Integer.valueOf(value5).intValue();
                    }
                }
                x.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", new Object[]{cVar});
                if (this.dOQ != -1) {
                    x.w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", new Object[]{Integer.valueOf(this.dOQ)});
                    cVar.field_EnableSnsImageDownload = this.dOQ;
                }
                g.NE();
                b.a(cVar);
            } catch (NumberFormatException e) {
                x.e("MicroMsg.CdnTransportService", e.toString());
            }
            if (af.exF) {
                int i;
                x.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
                cVar.field_UseStreamCDN = af.exB ? 1 : 0;
                if (cVar.field_UseStreamCDN != 0) {
                    cVar.field_onlysendETL = af.exC;
                    cVar.field_onlyrecvPtl = af.exD;
                    if (!bi.oW(af.exy)) {
                        cVar.field_WifiEtl = Integer.valueOf(af.exy).intValue();
                    }
                    if (!bi.oW(af.exz)) {
                        cVar.field_noWifiEtl = Integer.valueOf(af.exz).intValue();
                    }
                    if (!bi.oW(af.exA)) {
                        cVar.field_Ptl = Integer.valueOf(af.exA).intValue();
                    }
                }
                cVar.field_EnableCDNVerifyConnect = af.exG ? 1 : 0;
                if (af.exH) {
                    i = 1;
                } else {
                    i = 0;
                }
                cVar.field_EnableCDNVideoRedirectOC = i;
                x.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", new Object[]{cVar});
                g.NE();
                b.a(cVar);
            }
        }
    }

    public final int a(String str, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult) {
        if (bi.oW(str)) {
            x.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
            return -1;
        } else if (keep_progressinfo == null && keep_sceneresult == null) {
            x.e("MicroMsg.CdnTransportService", "cdn callback info all null");
            return -2;
        } else {
            if (keep_progressinfo != null) {
                x.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", new Object[]{Integer.valueOf(keep_progressinfo.field_toltalLength), Integer.valueOf(keep_progressinfo.field_finishedLength), Boolean.valueOf(keep_progressinfo.field_mtlnotify)});
            }
            this.dOZ = bi.VF();
            this.dOY = str;
            g.Em().H(new 7(this, str, keep_progressinfo, keep_sceneresult));
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (bi.oW(str)) {
            x.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
            return;
        }
        i iVar = (i) this.dOW.get(str);
        if (iVar == null) {
            x.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", new Object[]{str});
        } else if (iVar.dPV != null) {
            iVar.dPV.a(str, byteArrayOutputStream);
        } else {
            x.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
        }
    }

    public final byte[] i(String str, byte[] bArr) {
        if (bi.oW(str)) {
            x.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
            return null;
        }
        i iVar = (i) this.dOW.get(str);
        if (iVar == null) {
            x.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", new Object[]{str});
            return null;
        } else if (iVar.dPV != null) {
            return iVar.dPV.i(str, bArr);
        } else {
            x.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
            return null;
        }
    }

    public final void b(String str, keep_SceneResult keep_sceneresult) {
        if (!bi.oW(str)) {
            g.Em().H(new 8(this, str, keep_sceneresult));
        }
    }
}
