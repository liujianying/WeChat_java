package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.i.b;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

public final class f {
    long bJC;
    public String bKW;
    private b dQi = new 2(this);
    String dQk;
    private a dVu = new 1(this);
    private j elX;
    boolean emi = false;
    String emj;
    private long emk;
    long eml;
    long emm;
    int emn;
    private String emo;
    public a emp;
    private String mediaId;

    public f(long j) {
        this.bJC = j;
        this.emi = true;
    }

    public f(j jVar, String str) {
        this.elX = jVar;
        this.bKW = str;
        this.emi = false;
    }

    public final String SS() {
        return this.emi ? this.bJC : this.bKW;
    }

    public final void stop() {
        x.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", Integer.valueOf(hashCode()), this.mediaId);
        if (!bi.oW(this.mediaId)) {
            keep_SceneResult keep_sceneresult = new keep_SceneResult();
            c ND = g.ND();
            String str = this.mediaId;
            int i = 0;
            if (((i) ND.dOW.remove(str)) != null) {
                g.NE();
                i = com.tencent.mm.modelcdntran.b.a(str, keep_sceneresult);
                h.mEJ.h(10769, Integer.valueOf(d.dPq), Integer.valueOf(r0.field_fileType), Long.valueOf(bi.VF() - r0.field_startTime));
            }
            ND.dOV.remove(str);
            ND.dOX.remove(str);
            x.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, r0, Integer.valueOf(i));
            this.eml = bi.VE();
            this.emm = (long) b(this.emj, keep_sceneresult.field_recvedBytes, false);
            nz(keep_sceneresult.getRptIpList());
        }
        this.emp = null;
    }

    public final int a(a aVar) {
        this.emp = aVar;
        try {
            String str;
            String str2;
            j jVar;
            Object obj;
            x.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", Integer.valueOf(hashCode()), Long.valueOf(this.bJC));
            j jVar2;
            if (this.emi) {
                cm dW = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW(this.bJC);
                bd.b iF = bd.iF(dW.cqb);
                if (iF == null || iF.dCB <= 0) {
                    x.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", Integer.valueOf(hashCode()));
                    jVar2 = null;
                } else {
                    String str3 = dW.field_imgPath;
                    r nW = t.nW(str3);
                    if (nW == null) {
                        jVar2 = null;
                    } else {
                        Map z = bl.z(nW.Tm(), "msg");
                        if (z == null) {
                            x.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
                            jVar2 = null;
                        } else {
                            str = (String) z.get(".msg.videomsg.$cdnvideourl");
                            if (bi.oW(str)) {
                                x.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
                                jVar2 = null;
                            } else {
                                int intValue = Integer.valueOf((String) z.get(".msg.videomsg.$length")).intValue();
                                String str4 = (String) z.get(".msg.videomsg.$md5");
                                str2 = (String) z.get(".msg.videomsg.$newmd5");
                                String str5 = (String) z.get(".msg.videomsg.$aeskey");
                                String str6 = (String) z.get(".msg.videomsg.$fileparam");
                                String a = d.a("downvideo", nW.createTime, nW.Tj(), nW.getFileName());
                                if (bi.oW(a)) {
                                    x.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", nW.getFileName());
                                    jVar2 = null;
                                } else {
                                    o.Ta();
                                    String nK = s.nK(str3);
                                    j jVar3 = new j();
                                    jVar3.filename = str3;
                                    jVar3.dQk = str4;
                                    jVar3.dQl = intValue;
                                    jVar3.dQm = 2;
                                    jVar3.bSS = nW.Tk();
                                    jVar3.dQn = nW.Tj();
                                    jVar3.bSU = s.fq(nW.Tj()) ? m.gK(nW.Tj()) : 0;
                                    jVar3.field_mediaId = a;
                                    jVar3.field_fullpath = nK;
                                    jVar3.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
                                    jVar3.field_totalLen = intValue;
                                    jVar3.field_aesKey = str5;
                                    jVar3.field_fileId = str;
                                    jVar3.field_priority = com.tencent.mm.modelcdntran.b.dOk;
                                    jVar3.field_wxmsgparam = str6;
                                    jVar3.field_chattype = s.fq(nW.Tj()) ? 1 : 0;
                                    jVar3.field_autostart = false;
                                    jVar3.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(2, nW);
                                    jVar3.field_preloadRatio = iF.dCB;
                                    jVar3.bxC = str2;
                                    jVar2 = jVar3;
                                }
                            }
                        }
                    }
                }
                if (jVar2 != null) {
                    this.emn = s.fq(jVar2.dQn) ? 2 : 1;
                    h.mEJ.a(354, 140, 1, false);
                    if (this.emn == 1) {
                        h.mEJ.a(354, 121, 1, false);
                    } else {
                        h.mEJ.a(354, 122, 1, false);
                    }
                }
                if (this.elX == null) {
                    this.elX = jVar2;
                    jVar = jVar2;
                } else {
                    jVar = jVar2;
                }
            } else {
                this.emn = 3;
                jVar2 = this.elX;
                h.mEJ.a(354, 141, 1, false);
                jVar = jVar2;
            }
            if (jVar == null) {
                x.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", Integer.valueOf(hashCode()));
                obj = null;
            } else {
                if (((Integer) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue() == 2) {
                    x.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
                } else if (!jVar.NJ()) {
                    str2 = jVar.dQk;
                    int i = jVar.dQl;
                    str = ((com.tencent.mm.plugin.t.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.t.a.a.class)).FY().de(str2, i);
                    int cm = i - e.cm(str);
                    if (!bi.oW(str) && cm >= 0 && cm <= 16) {
                        x.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", Integer.valueOf(i), str2, str);
                        com.tencent.mm.sdk.platformtools.j.fN(str, jVar.field_fullpath);
                        f(jVar.filename, i, str2);
                        obj = 1;
                        if (obj == null) {
                            x.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", Integer.valueOf(hashCode()));
                            obj = null;
                        } else {
                            jVar.dQi = this.dQi;
                            jVar.dPV = this.dVu;
                            jVar.dQg = 2;
                            this.dQk = jVar.dQk;
                            this.mediaId = jVar.field_mediaId;
                            this.emj = jVar.filename;
                            this.emk = bi.VE();
                            this.emo = jVar.bxC;
                            x.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", Integer.valueOf(hashCode()), jVar);
                            g.ND().b(jVar, -1);
                            obj = 1;
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    jVar.dQi = this.dQi;
                    jVar.dPV = this.dVu;
                    jVar.dQg = 2;
                    this.dQk = jVar.dQk;
                    this.mediaId = jVar.field_mediaId;
                    this.emj = jVar.filename;
                    this.emk = bi.VE();
                    this.emo = jVar.bxC;
                    x.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", Integer.valueOf(hashCode()), jVar);
                    g.ND().b(jVar, -1);
                    obj = 1;
                } else {
                    x.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", Integer.valueOf(hashCode()));
                    obj = null;
                }
            }
            if (obj != null) {
                return 0;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", e, "", new Object[0]);
        }
        this.emp = null;
        return -1;
    }

    static int b(String str, int i, boolean z) {
        r nW = t.nW(str);
        if (nW == null) {
            return i;
        }
        int i2;
        int i3 = nW.bSX;
        if (z) {
            nW.bSX = i;
        } else {
            nW.bSX = i3 + i;
        }
        x.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", str, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(nW.bSX), Boolean.valueOf(z));
        nW.enK = bi.VE();
        nW.bWA = 1025;
        t.e(nW);
        if (z) {
            i2 = i - i3;
        } else {
            i2 = i;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    final void f(String str, int i, String str2) {
        x.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i), str2);
        if (t.nW(str) != null) {
            t.U(str, i);
            if (!bi.oW(str2)) {
                o.Ta();
                String nK = s.nK(str);
                if (bi.oW(str2) || i <= 0 || bi.oW(nK) || !e.cn(nK)) {
                    x.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i), str2, nK);
                    return;
                }
                ((com.tencent.mm.plugin.t.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.t.a.a.class)).FY().y(str2, i, nK);
            }
        }
    }

    final void nz(String str) {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.emk).append(",");
        stringBuffer.append(this.eml).append(",");
        stringBuffer.append(this.emm).append(",");
        stringBuffer.append(this.emo).append(",");
        stringBuffer.append(this.emn).append(",");
        try {
            i = (int) ((this.emm / 1024) / (this.eml - this.emk));
        } catch (Exception e) {
            i = 0;
        }
        stringBuffer.append(i).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(str).append(",");
        stringBuffer.append(this.elX.bSS).append(",");
        stringBuffer.append(this.elX.dQn).append(",");
        stringBuffer.append(this.elX.bSU).append(",");
        stringBuffer.append(this.elX.field_fileId).append(",");
        stringBuffer.append(this.elX.url).append(",");
        stringBuffer.append(com.tencent.mm.plugin.video.c.OC(this.elX.bSZ));
        x.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", Integer.valueOf(hashCode()), stringBuffer.toString());
        new com.tencent.mm.g.b.a.f(r0).RD();
    }
}
