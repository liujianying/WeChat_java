package com.tencent.mm.modelcdntran;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.g.a.la;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.bd;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class f implements e, a {
    Queue<String> dOU = new LinkedList();
    Map<String, j> dOV = new HashMap();
    Map<String, j> dOW = new HashMap();
    Map<String, j> dPA = new HashMap();
    Map<String, keep_SceneResult> dPB = new HashMap();

    public f() {
        g.DF().a(379, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 379) {
            x.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (g.Eg().Dx()) {
                g.Em().H(new 1(this));
            }
        }
    }

    public final boolean a(j jVar, boolean z) {
        if (jVar == null) {
            x.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
            return false;
        } else if (bi.oW(jVar.field_mediaId)) {
            x.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
            return false;
        } else {
            x.i("MicroMsg.OnlineVideoService", "add download task : " + jVar.field_mediaId + " delay : " + z);
            if (jVar.field_fileId == null) {
                jVar.field_fileId = "";
            }
            if (jVar.field_aesKey == null) {
                jVar.field_aesKey = "";
            }
            jVar.ceW = false;
            if (k(jVar.field_mediaId, null) || z) {
                g.Em().H(new 2(this, jVar));
            } else {
                g.Em().H(new 3(this, jVar));
            }
            return true;
        }
    }

    public final boolean k(String str, Object[] objArr) {
        boolean z = false;
        if (!bi.oW(str)) {
            if (this.dOW.containsKey(str)) {
                z = true;
            } else {
                g.ND().lx(str);
            }
            g.Em().H(new 4(this, str, objArr));
        }
        x.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + str + " remove : " + z);
        return z;
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        if (((j) this.dOW.get(str)) == null) {
            x.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", new Object[]{str});
            return false;
        }
        g.NE();
        x.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(b.isVideoDataAvailable(str, i, i2))});
        return b.isVideoDataAvailable(str, i, i2);
    }

    public static int g(String str, int i, int i2) {
        g.NE();
        x.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(b.g(str, i, i2))});
        return b.g(str, i, i2);
    }

    public final void bH(boolean z) {
        if (g.Eg().Dx()) {
            if (!z && g.NE().Nx()) {
                g.Eg();
                if (com.tencent.mm.kernel.a.Dw()) {
                    x.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
                    g.ND().bH(z);
                    return;
                }
            }
            g.ND().Ny();
            while (!this.dOU.isEmpty()) {
                String str = (String) this.dOU.poll();
                i iVar = (j) this.dOV.remove(str);
                if (iVar != null) {
                    iVar.field_startTime = bi.VF();
                    if (!iVar.ceW) {
                        Object obj;
                        if (((Integer) g.Ei().DT().get(aa.a.sUi, Integer.valueOf(-1))).intValue() == 2) {
                            x.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
                        } else if (!iVar.NJ()) {
                            String str2 = iVar.dQk;
                            int i = iVar.dQl;
                            String de = ((com.tencent.mm.plugin.t.a.a) g.l(com.tencent.mm.plugin.t.a.a.class)).FY().de(str2, i);
                            int cm = i - com.tencent.mm.a.e.cm(de);
                            if (!bi.oW(de) && cm >= 0 && cm <= 16) {
                                x.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", new Object[]{Integer.valueOf(i), str2, de});
                                j.fN(de, iVar.field_fullpath);
                                r nW = t.nW(iVar.filename);
                                a(nW, i, str2);
                                bd dW = ((i) g.l(i.class)).bcY().dW((long) nW.enN);
                                ((i) g.l(i.class)).bcY().a(new c(dW.field_talker, "update", dW));
                                obj = 1;
                                if (obj == null) {
                                    la laVar = new la();
                                    laVar.bVm.bOh = 6;
                                    laVar.bVm.mediaId = str;
                                    com.tencent.mm.sdk.b.a.sFg.m(laVar);
                                } else {
                                    int a;
                                    if (iVar.NI()) {
                                        g.NE();
                                        a = b.a(iVar, iVar.dQm);
                                    } else if (iVar.NG()) {
                                        g.NE();
                                        a = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.dQm, iVar.dPQ, iVar.initialDownloadOffset, iVar.initialDownloadLength, iVar.isColdSnsData, iVar.signalQuality, iVar.snsScene, iVar.field_preloadRatio);
                                    } else if (iVar.NH()) {
                                        g.NE();
                                        a = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.dQm, iVar.field_preloadRatio, iVar.concurrentCount);
                                    } else {
                                        g.NE();
                                        a = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.dQm, iVar.dPQ, iVar.initialDownloadOffset, iVar.initialDownloadLength, iVar.field_preloadRatio);
                                    }
                                    x.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[]{iVar, Integer.valueOf(a)});
                                    if (a != 0) {
                                        x.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + a + " media id: " + iVar.field_mediaId);
                                        boolean NI = iVar.NI();
                                        int i2 = iVar.dQm;
                                        if (NI) {
                                            h.mEJ.a(354, 3, 1, false);
                                            if (i2 == 1) {
                                                if (a == -21006) {
                                                    h.mEJ.a(354, 100, 1, false);
                                                } else if (a == -20003) {
                                                    h.mEJ.a(354, 101, 1, false);
                                                } else {
                                                    h.mEJ.a(354, 102, 1, false);
                                                }
                                            } else if (a == -21006) {
                                                h.mEJ.a(354, 106, 1, false);
                                            } else if (a == -20003) {
                                                h.mEJ.a(354, 107, 1, false);
                                            } else {
                                                h.mEJ.a(354, 108, 1, false);
                                            }
                                            h.mEJ.h(13836, new Object[]{Integer.valueOf(100), Long.valueOf(bi.VE()), ""});
                                        } else {
                                            h.mEJ.a(354, 210, 1, false);
                                            if (i2 == 1) {
                                                h.mEJ.a(354, 211, 1, false);
                                            } else {
                                                h.mEJ.a(354, 212, 1, false);
                                            }
                                            h.mEJ.h(13836, new Object[]{Integer.valueOf(200), Long.valueOf(bi.VE()), ""});
                                        }
                                    } else {
                                        iVar.dQj = bi.VF();
                                        if (iVar.NI()) {
                                            r nW2 = t.nW(iVar.filename);
                                            if (nW2 != null) {
                                                int i3 = nW2.status;
                                                if (!(i3 == 120 || i3 == 122 || i3 == 121)) {
                                                    nW2.status = 120;
                                                    nW2.bWA = ab.CTRL_BYTE;
                                                    o.Ta().b(nW2);
                                                }
                                            }
                                        }
                                        this.dOW.put(iVar.field_mediaId, iVar);
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            int a2;
                            if (iVar.NI()) {
                                g.NE();
                                a2 = b.a(iVar, iVar.dQm);
                            } else if (iVar.NG()) {
                                g.NE();
                                a2 = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.dQm, iVar.dPQ, iVar.initialDownloadOffset, iVar.initialDownloadLength, iVar.isColdSnsData, iVar.signalQuality, iVar.snsScene, iVar.field_preloadRatio);
                            } else if (iVar.NH()) {
                                g.NE();
                                a2 = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.dQm, iVar.field_preloadRatio, iVar.concurrentCount);
                            } else {
                                g.NE();
                                a2 = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.dQm, iVar.dPQ, iVar.initialDownloadOffset, iVar.initialDownloadLength, iVar.field_preloadRatio);
                            }
                            x.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", new Object[]{iVar, Integer.valueOf(a2)});
                            if (a2 != 0) {
                                x.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + a2 + " media id: " + iVar.field_mediaId);
                                boolean NI2 = iVar.NI();
                                int i22 = iVar.dQm;
                                if (NI2) {
                                    h.mEJ.a(354, 3, 1, false);
                                    if (i22 == 1) {
                                        if (a2 == -21006) {
                                            h.mEJ.a(354, 100, 1, false);
                                        } else if (a2 == -20003) {
                                            h.mEJ.a(354, 101, 1, false);
                                        } else {
                                            h.mEJ.a(354, 102, 1, false);
                                        }
                                    } else if (a2 == -21006) {
                                        h.mEJ.a(354, 106, 1, false);
                                    } else if (a2 == -20003) {
                                        h.mEJ.a(354, 107, 1, false);
                                    } else {
                                        h.mEJ.a(354, 108, 1, false);
                                    }
                                    h.mEJ.h(13836, new Object[]{Integer.valueOf(100), Long.valueOf(bi.VE()), ""});
                                } else {
                                    h.mEJ.a(354, 210, 1, false);
                                    if (i22 == 1) {
                                        h.mEJ.a(354, 211, 1, false);
                                    } else {
                                        h.mEJ.a(354, 212, 1, false);
                                    }
                                    h.mEJ.h(13836, new Object[]{Integer.valueOf(200), Long.valueOf(bi.VE()), ""});
                                }
                            } else {
                                iVar.dQj = bi.VF();
                                if (iVar.NI()) {
                                    r nW22 = t.nW(iVar.filename);
                                    if (nW22 != null) {
                                        int i32 = nW22.status;
                                        if (!(i32 == 120 || i32 == 122 || i32 == 121)) {
                                            nW22.status = 120;
                                            nW22.bWA = ab.CTRL_BYTE;
                                            o.Ta().b(nW22);
                                        }
                                    }
                                }
                                this.dOW.put(iVar.field_mediaId, iVar);
                            }
                        } else {
                            la laVar2 = new la();
                            laVar2.bVm.bOh = 6;
                            laVar2.bVm.mediaId = str;
                            com.tencent.mm.sdk.b.a.sFg.m(laVar2);
                        }
                    }
                }
            }
        }
    }

    public final void onMoovReady(String str, int i, int i2) {
        x.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", new Object[]{str});
        if (!bi.oW(str)) {
            g.Em().H(new 5(this, str, i, i2));
        }
    }

    public final void onDataAvailable(String str, int i, int i2) {
        x.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!bi.oW(str)) {
            g.Em().H(new 6(this, str, i, i2));
        }
    }

    public final void onDownloadToEnd(String str, int i, int i2) {
        x.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!bi.oW(str)) {
            g.Em().H(new 7(this, str, i, i2));
        }
    }

    public final int a(String str, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult) {
        if (bi.oW(str)) {
            x.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
            return -1;
        } else if (keep_progressinfo == null && keep_sceneresult == null) {
            x.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
            return -2;
        } else {
            g.Em().H(new 8(this, str, keep_progressinfo, keep_sceneresult));
            if (this.dOW.get(str) != null) {
                return 1;
            }
            return 0;
        }
    }

    static void a(r rVar, int i, String str) {
        x.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", new Object[]{Integer.valueOf(i)});
        if (rVar != null) {
            t.U(rVar.getFileName(), i);
            String fileName = rVar.getFileName();
            if (!bi.oW(str)) {
                o.Ta();
                String nK = s.nK(fileName);
                if (bi.oW(str) || i <= 0 || bi.oW(nK)) {
                    x.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", new Object[]{Integer.valueOf(i), str, nK});
                    return;
                }
                ((com.tencent.mm.plugin.t.a.a) g.l(com.tencent.mm.plugin.t.a.a.class)).FY().y(str, i, nK);
            }
        }
    }

    public static j a(av avVar, String str, String str2, String str3, int i) {
        if (avVar == null) {
            x.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
            return null;
        } else if (bi.oW(str)) {
            x.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
            return null;
        } else {
            r nW = t.nW(str3);
            if (nW == null) {
                x.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", new Object[]{str3});
                return null;
            }
            String a = d.a("snsvideo", (long) avVar.time, "sns", str);
            if (bi.oW(a)) {
                x.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", new Object[]{str});
                return null;
            }
            j jVar = new j();
            jVar.filename = str3;
            jVar.field_fullpath = str2;
            jVar.field_mediaId = a;
            jVar.dQh = 2;
            jVar.dQm = i;
            jVar.dQo = nW.dQo;
            String str4 = "";
            if (avVar == null) {
                a = "";
            } else if (avVar.equals(av.tbn)) {
                a = "album_friend";
            } else if (avVar.equals(av.tbo)) {
                a = "album_self";
            } else if (avVar.equals(av.tbp)) {
                a = "album_stranger";
            } else if (avVar.equals(av.tbq)) {
                a = "profile_friend";
            } else if (avVar.equals(av.tbr)) {
                a = "profile_stranger";
            } else if (avVar.equals(av.tbs)) {
                a = "comment";
            } else if (avVar.equals(av.tbm)) {
                a = "timeline";
            } else if (avVar.equals(av.tbv)) {
                a = "snssight";
            } else {
                a = str4;
            }
            String str5 = "http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s";
            r3 = new Object[5];
            g.Ek();
            g.Eg();
            r3[1] = com.tencent.mm.a.o.getString(com.tencent.mm.kernel.a.Df());
            r3[2] = Integer.valueOf(ao.getNetTypeForStat(ad.getContext()));
            r3[3] = Integer.valueOf(ao.getStrength(ad.getContext()));
            r3[4] = !bi.oW(a) ? "&scene=" + a : "";
            jVar.referer = String.format(str5, r3);
            jVar.url = str;
            long j = (long) ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getInt("SnsSightMainStandbyIpSwitchTime", 0);
            x.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", new Object[]{((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getValue("SnsSightDomainList"), Long.valueOf(j), Integer.valueOf(avVar.time)});
            if (j <= 0) {
                j = 259200;
            }
            boolean a2 = a(avVar, jVar.url, j, r5);
            try {
                jVar.host = new URL(jVar.url).getHost();
                List arrayList = new ArrayList();
                b.a(a2, arrayList, jVar.host);
                jVar.dPQ = new String[arrayList.size()];
                arrayList.toArray(jVar.dPQ);
                jVar.isColdSnsData = bi.bG((long) avVar.time) > j;
                jVar.signalQuality = ao.getStrength(ad.getContext());
                jVar.snsScene = a;
                return jVar;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.OnlineVideoService", e, "check can sns online video error taskInfo %s", new Object[]{jVar});
                return null;
            }
        }
    }

    private static boolean a(av avVar, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (avVar == null || str2 == null || str2.indexOf(url.getHost()) == -1 || avVar.time == 0 || bi.bG((long) avVar.time) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoService", "error for check dcip %s", new Object[]{e.getMessage()});
            return false;
        }
    }

    public static void a(Object[] objArr, keep_SceneResult keep_sceneresult, j jVar, boolean z) {
        if (jVar == null || keep_sceneresult == null) {
            x.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
        } else if (jVar.NG() || jVar.NI()) {
            r nW;
            String str;
            int intValue;
            int intValue2;
            int intValue3;
            int intValue4;
            int intValue5;
            int intValue6;
            int intValue7;
            int i;
            int i2;
            int i3;
            String str2 = keep_sceneresult.field_clientIP;
            x.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", new Object[]{Integer.valueOf(keep_sceneresult.field_videoFormat), str2, Integer.valueOf(keep_sceneresult.field_isCrossNet ? 1 : 0)});
            if (keep_sceneresult.field_videoFormat == 2) {
                nW = t.nW(jVar.filename);
                if (nW != null) {
                    nW.videoFormat = 2;
                    nW.bWA = 2;
                    boolean b = o.Ta().b(nW);
                    x.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", new Object[]{Boolean.valueOf(b), str, Integer.valueOf(2)});
                }
            }
            if (bi.oW(str2)) {
                h.mEJ.a(354, 45, 1, false);
            } else {
                h.mEJ.a(354, 46, 1, false);
            }
            if (keep_sceneresult.field_isCrossNet) {
                h.mEJ.a(354, 47, 1, false);
            } else {
                h.mEJ.a(354, 48, 1, false);
            }
            boolean NI = jVar.NI();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            pInt2.value = 0;
            pInt.value = 0;
            t.a(jVar.field_fullpath, pInt, pInt2);
            int i4 = pInt.value * 1000;
            int i5 = pInt2.value;
            if (objArr != null) {
                intValue = ((Integer) objArr[0]).intValue() * 1000;
                intValue2 = ((Integer) objArr[1]).intValue();
                intValue3 = ((Integer) objArr[2]).intValue();
                intValue4 = ((Integer) objArr[3]).intValue();
                intValue5 = ((Integer) objArr[4]).intValue();
                intValue6 = ((Integer) objArr[5]).intValue();
                intValue7 = ((Integer) objArr[6]).intValue();
                i = intValue6;
                i2 = intValue2;
            } else {
                intValue7 = 0;
                i = 0;
                intValue5 = 0;
                intValue4 = 0;
                intValue3 = 0;
                i2 = 0;
                intValue = 0;
            }
            intValue6 = jVar.dQo;
            if (intValue6 <= 0) {
                if (NI) {
                    intValue6 = 10;
                } else {
                    intValue6 = 31;
                }
            }
            int fI = ao.fI(ad.getContext());
            String rptIpList = keep_sceneresult.getRptIpList();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            String str3 = jVar.filename;
            int i6 = jVar.dQr;
            int i7 = 0;
            r nW2 = t.nW(str3);
            if (nW2 != null) {
                i7 = nW2.bSX;
                i3 = nW2.dHI;
            } else {
                i3 = 0;
            }
            if (i6 <= 0) {
                intValue2 = 1;
            } else {
                intValue2 = i7 < ((int) ((((float) i6) / 100.0f) * ((float) i3))) ? 2 : 3;
                x.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", new Object[]{Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf((int) ((((float) i6) / 100.0f) * ((float) i3))), Integer.valueOf(i7)});
            }
            pInt3.value = i7;
            pInt4.value = intValue2;
            x.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", new Object[]{Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value)});
            StringBuffer stringBuffer = new StringBuffer();
            if (NI) {
                stringBuffer.append(jVar.field_fileId).append(",").append(jVar.field_aesKey).append(",");
            } else {
                stringBuffer.append(jVar.url).append(",").append(jVar.dQp).append(",");
            }
            stringBuffer.append(keep_sceneresult.field_fileLength).append(",").append(i4).append(",");
            stringBuffer.append(keep_sceneresult.field_recvedBytes).append(",");
            stringBuffer.append(intValue + ",").append(i2 + ",").append(intValue3 + ",");
            stringBuffer.append(intValue4 + ",").append(intValue5 + ",");
            stringBuffer.append(fI).append(",");
            stringBuffer.append(intValue6).append(",");
            stringBuffer.append(keep_sceneresult.field_startTime).append(",");
            stringBuffer.append(keep_sceneresult.field_endTime).append(",");
            if (NI) {
                stringBuffer.append(jVar.dQn != null ? com.tencent.mm.a.g.u(jVar.dQn.getBytes()) : Integer.valueOf(0)).append(",");
                stringBuffer.append(com.tencent.mm.model.s.fq(jVar.dQn) ? 1 : 0).append(",");
            } else {
                stringBuffer.append(0).append(",");
                stringBuffer.append(keep_sceneresult.field_httpStatusCode).append(",");
            }
            stringBuffer.append(keep_sceneresult.field_retCode).append(",");
            stringBuffer.append(keep_sceneresult.field_enQueueTime).append(",");
            stringBuffer.append(keep_sceneresult.field_firstRequestCost).append(",");
            stringBuffer.append(keep_sceneresult.field_firstRequestSize).append(",");
            stringBuffer.append(keep_sceneresult.field_firstRequestDownloadSize).append(",");
            stringBuffer.append(keep_sceneresult.field_firstRequestCompleted ? 1 : 0).append(",");
            stringBuffer.append(keep_sceneresult.field_averageSpeed).append(",");
            stringBuffer.append(keep_sceneresult.field_averageConnectCost).append(",");
            stringBuffer.append(keep_sceneresult.field_firstConnectCost).append(",");
            stringBuffer.append(keep_sceneresult.field_netConnectTimes).append(",");
            stringBuffer.append(keep_sceneresult.field_moovRequestTimes).append(",");
            stringBuffer.append(keep_sceneresult.field_moovCost).append(",");
            stringBuffer.append(keep_sceneresult.field_moovSize).append(",");
            stringBuffer.append(keep_sceneresult.field_moovCompleted ? 1 : 0).append(",");
            stringBuffer.append(keep_sceneresult.field_moovFailReason).append(",");
            stringBuffer.append(i).append(",");
            stringBuffer.append(intValue7).append(",");
            if (NI) {
                stringBuffer.append(i5).append(",");
            } else {
                stringBuffer.append(i5).append(",");
                stringBuffer.append(jVar.dQn != null ? com.tencent.mm.a.g.u(jVar.dQn.getBytes()) : Integer.valueOf(0)).append(",");
            }
            stringBuffer.append(rptIpList).append(",");
            if (NI) {
                stringBuffer.append(jVar.dQq).append(",");
                stringBuffer.append(jVar.bYu).append(",");
                stringBuffer.append(jVar.initialDownloadLength).append(",");
                stringBuffer.append(keep_sceneresult.field_videoFormat).append(",");
            } else {
                stringBuffer.append(com.tencent.mm.plugin.video.c.OC(jVar.bSZ)).append(",");
            }
            stringBuffer.append(str2).append(",");
            stringBuffer.append(r11).append(",");
            stringBuffer.append(jVar.dQs).append(",");
            stringBuffer.append(pInt3.value).append(",");
            stringBuffer.append(pInt4.value);
            intValue7 = NI ? 13570 : 13790;
            String stringBuffer2 = stringBuffer.toString();
            x.i("MicroMsg.OnlineVideoService", "report online video %d:%s", new Object[]{Integer.valueOf(intValue7), stringBuffer2});
            if (NI) {
                new com.tencent.mm.g.b.a.e(stringBuffer2).RD();
            } else {
                new com.tencent.mm.g.b.a.h(stringBuffer2).RD();
            }
            if (z) {
                str = jVar.bSS;
                stringBuffer2 = jVar.dQn;
                i = jVar.bSU;
                String str4 = keep_sceneresult.field_fileId;
                long j = keep_sceneresult.field_startTime;
                long j2 = keep_sceneresult.field_endTime;
                String str5 = jVar.field_fullpath;
                String[] strArr = keep_sceneresult.field_usedSvrIps;
                str3 = jVar.url;
                i7 = pInt3.value;
                int i8 = pInt4.value;
                String str6 = jVar.bSZ;
                jk jkVar = new jk();
                jkVar.bSR.bSS = str;
                jkVar.bSR.bST = stringBuffer2;
                jkVar.bSR.bSU = i;
                jkVar.bSR.fileId = str4;
                jkVar.bSR.netType = fI;
                jkVar.bSR.startTime = j;
                jkVar.bSR.endTime = j2;
                jkVar.bSR.path = str5;
                jkVar.bSR.bSV = strArr;
                jkVar.bSR.bSW = str3;
                jkVar.bSR.bSX = i7;
                jkVar.bSR.bSY = i8;
                jkVar.bSR.bSZ = str6;
                com.tencent.mm.sdk.b.a.sFg.m(jkVar);
            }
            if (NI) {
                if (keep_sceneresult.field_videoFormat == 2) {
                    h.mEJ.a(354, 132, 1, false);
                } else {
                    h.mEJ.a(354, 133, 1, false);
                }
                nW = t.nW(jVar.filename);
                if (nW != null) {
                    bd dW = ((i) g.l(i.class)).bcY().dW((long) nW.enN);
                    ((i) g.l(i.class)).bcY().a(new c(dW.field_talker, "update", dW));
                }
            }
        }
    }
}
