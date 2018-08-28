package com.tencent.mm.ui.chatting.gallery;

import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.la;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.d;
import com.tencent.mm.model.m;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s$a$a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.u.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.Map;

public final class i extends a implements com.tencent.mm.model.d.a, com.tencent.mm.modelvideo.s.a {
    public static boolean tWC = false;
    String filename;
    private d gbl;
    private al hEr = new al(new 16(this), true);
    int jfN = 0;
    private long lastCheckTime = 0;
    private b ldj = new b() {
        public final long bdp() {
            x.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", new Object[]{Integer.valueOf(i.this.hashCode())});
            au.HU();
            c.DT().a(com.tencent.mm.storage.aa.a.sVF, Boolean.valueOf(true));
            try {
                if (i.this.nPt && i.this.tWu != null) {
                    return (long) i.this.tWu.elJ;
                }
            } catch (Exception e) {
            }
            return 0;
        }
    };
    private long nPD;
    int nPE;
    private e nPi = new 7(this);
    private boolean nPt;
    long nPx = 0;
    long nPy = 0;
    private al nPz = new al(new 15(this), true);
    private long qEu = 0;
    private com.tencent.mm.plugin.sight.decode.ui.b qEz = new com.tencent.mm.plugin.sight.decode.ui.b() {
        public final void ajO() {
            if (i.this.tTx.cwO() != null) {
                i.this.b(i.this.tTx.cwO());
            }
            i.this.tTx.tTy.tWg.SO();
        }

        public final void kV(int i) {
            String str = null;
            try {
                str = i.this.tTx.cwO().cxz().tXa.getVideoPath();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "", new Object[0]);
                x.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + e.toString());
            }
            x.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", new Object[]{Integer.valueOf(i), Boolean.valueOf(i.this.nPt), str});
            if (bi.oW(str)) {
                bd cwN = i.this.tTx.cwN();
                if (cwN != null && cwN.cmj()) {
                    t.c(cwN.field_imgPath, i * 1000, i.this.nPt);
                }
                i.this.tTx.Fr(i.this.tTx.tTy.getCurrentItem());
            } else {
                boolean ap;
                if (i.this.nPt) {
                    ap = i.this.tWu.ap(i, true);
                } else {
                    i.this.R(i, true);
                    ap = true;
                }
                if (ap) {
                    i.this.bS(false);
                }
            }
            i.this.tTx.tTy.cxf();
        }
    };
    private HashMap<String, a> tVv = new HashMap();
    private int tWA = 0;
    private boolean tWB = false;
    ag tWD = new ag(Looper.getMainLooper(), new 11(this));
    private int tWE = 0;
    private com.tencent.mm.sdk.b.c<la> tWF = new 4(this);
    private boolean tWG = false;
    private int tWH = 0;
    private int[] tWI = new int[]{-1000, -2000, 3400};
    private com.tencent.mm.sdk.b.c tWs;
    final SparseArray<r> tWt = new SparseArray();
    private l tWu = new l(this);
    private boolean tWv = false;
    private boolean tWw = false;
    private boolean tWx = false;
    private int tWy = 0;
    private int tWz = 0;

    public static class a {
        public bd bGS;
        public int pos;

        public a(bd bdVar, int i) {
            this.bGS = bdVar;
            this.pos = i;
        }
    }

    public i(b bVar) {
        super(bVar);
        com.tencent.mm.sdk.b.a aVar = com.tencent.mm.sdk.b.a.sFg;
        com.tencent.mm.ui.chatting.al alVar = new com.tencent.mm.ui.chatting.al(com.tencent.mm.ui.chatting.al.a.tMO, bVar.tTy);
        this.tWs = alVar;
        aVar.b(alVar);
        com.tencent.mm.sdk.b.a.sFg.b(this.tWF);
        this.gbl = new d();
    }

    public final boolean a(j jVar, bd bdVar, int i) {
        super.a(jVar, bdVar, i);
        r bA = bA(bdVar);
        if (bdVar == null) {
            x.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
            return false;
        }
        if (this.tVv != null) {
            this.tVv.put(bdVar.field_imgPath, new a(bdVar, i));
        } else {
            x.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
        }
        if (bA == null) {
            return false;
        }
        o.Ta();
        jVar.cxz().tWY.setImageBitmap(BackwardSupportUtil.b.e(s.nL(bdVar.field_imgPath), 1.0f));
        if (jVar.cxz().tXa.isPlaying()) {
            jVar.cxz().tXa.stop();
        }
        jVar.tXc.setVisibility(8);
        jVar.cxz().tXb.setVisibility(8);
        jVar.cxz().tXi.setVisibility(8);
        jVar.a(false, 0.0f);
        this.tWz = 0;
        this.nPx = bi.VF();
        return true;
    }

    public static r bA(bd bdVar) {
        if (b.bh(bdVar)) {
            return t.nW(bdVar.field_imgPath);
        }
        return null;
    }

    public final void pause(int i) {
        b(Fl(i));
        this.gbl.bv(false);
        this.tTx.tTy.md(true);
    }

    public final void g(bd bdVar, int i) {
        x.i("MicroMsg.Imagegallery.handler.video", "toggle video");
        if (bdVar != null) {
            if (b.bh(bdVar) || b.bi(bdVar)) {
                r bA = bA(bdVar);
                if (bA == null) {
                    return;
                }
                if (this.nPt && this.tWu != null && this.tWu.elI) {
                    x.i("MicroMsg.Imagegallery.handler.video", "%d it loading video data, do not response button click.", new Object[]{Integer.valueOf(hashCode())});
                } else if (this.tTx.tTy.bIB()) {
                    b(Fl(i));
                    this.tTx.tTy.md(true);
                    this.tTx.tTy.tWg.SO();
                    this.gbl.bv(false);
                    x.i("MicroMsg.Imagegallery.handler.video", "toggle pause video.");
                } else {
                    au.HU();
                    if (c.isSDCardAvailable()) {
                        int currentPosition;
                        if (this.nPt) {
                            try {
                                if (this.tTx.cwO().tXa != null) {
                                    currentPosition = this.tTx.cwO().tXa.getCurrentPosition() / 1000;
                                    if (this.tWu != null) {
                                        x.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[]{Integer.valueOf(hashCode())});
                                    } else if (this.tWu.iD(currentPosition)) {
                                        x.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
                                        a(bdVar, bA, i, this.nPt);
                                    } else {
                                        x.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
                                        bS(false);
                                    }
                                }
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "", new Object[0]);
                            }
                            currentPosition = 0;
                            if (this.tWu != null) {
                                x.w("MicroMsg.Imagegallery.handler.video", "%d toggle video but online video helper is null.", new Object[]{Integer.valueOf(hashCode())});
                            } else if (this.tWu.iD(currentPosition)) {
                                x.i("MicroMsg.Imagegallery.handler.video", "toggle play video");
                                a(bdVar, bA, i, this.nPt);
                            } else {
                                x.i("MicroMsg.Imagegallery.handler.video", "toggle start timer.");
                                bS(false);
                            }
                        } else {
                            if (bdVar.field_isSend == 0) {
                                if (bA.status == 113 || bA.status == 198) {
                                    a(bdVar, bA);
                                } else {
                                    if (bA.status == 199) {
                                        a(bdVar, bA, i, false);
                                    }
                                    if (bA.status == 111) {
                                        a(bdVar, bA);
                                    }
                                    if (bA.status == 112) {
                                        a(bdVar, bA);
                                    }
                                    if (bA.status == 121 || bA.status == 122) {
                                        a(bdVar, bA);
                                    }
                                    if (bA.status == 123) {
                                        a(bdVar, bA, i, false);
                                    }
                                }
                            }
                            if (bdVar.field_isSend == 1) {
                                currentPosition = bA.status;
                                if (currentPosition == 111 || currentPosition == 113 || currentPosition == 112 || currentPosition == 121 || currentPosition == 122) {
                                    x.i("MicroMsg.Imagegallery.handler.video", "download video. msg talker[%s], info status[%d]", new Object[]{bdVar.field_talker, Integer.valueOf(currentPosition)});
                                    a(bdVar, bA);
                                } else {
                                    a(bdVar, bA, i, false);
                                }
                            }
                        }
                        if (this.tTx.tTy.tWf) {
                            this.tTx.tTy.cxf();
                        }
                        cxv();
                        return;
                    }
                    com.tencent.mm.ui.base.s.gH(this.tTx.tTy.mController.tml);
                }
            }
        }
    }

    public final void h(bd bdVar, int i) {
        x.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
        r nW = t.nW(bdVar.field_imgPath);
        if (nW != null && !nW.Tp()) {
            b(Fl(i));
            this.tTx.tTy.md(true);
            if (this.nPt) {
                this.tWu.cxB();
                this.tWu.reset();
            }
            a(bdVar, nW);
            if (this.tTx.tTy.gJ(bdVar.field_msgId) == 2) {
                do(bdVar.field_imgPath, 8);
            } else {
                do(bdVar.field_imgPath, 5);
            }
        }
    }

    private void a(bd bdVar, r rVar, int i, boolean z) {
        if (bdVar != null && rVar != null) {
            if (bdVar.cmu()) {
                Toast.makeText(this.tTx.tTy, R.l.video_fail_or_clean, 0).show();
                return;
            }
            String nK;
            String Tl;
            if (rVar.enT == -1) {
                Tl = rVar.Tl();
                if (!com.tencent.mm.a.e.cn(Tl)) {
                    o.Ta();
                    nK = s.nK(bdVar.field_imgPath);
                }
                nK = Tl;
            } else {
                o.Ta();
                Tl = s.nK(bdVar.field_imgPath);
                if (bdVar.field_isSend == 1 && rVar.enW != null && rVar.enW.rUP) {
                    try {
                        String mK = FileOp.mK(Tl);
                        if (!mK.endsWith("/")) {
                            mK = mK + "/";
                        }
                        mK = mK + com.tencent.mm.a.e.cq(Tl) + "_hd.mp4";
                        x.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", new Object[]{mK, Boolean.valueOf(FileOp.cn(mK))});
                        if (!FileOp.cn(mK)) {
                            mK = Tl;
                        }
                        nK = mK;
                    } catch (Exception e) {
                        x.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", new Object[]{e.getMessage()});
                    }
                }
                nK = Tl;
            }
            if (nK == null || !com.tencent.mm.a.e.cn(nK)) {
                Toast.makeText(this.tTx.tTy, R.l.video_fail_or_clean, 0).show();
                return;
            }
            j Fl = Fl(i);
            if (Fl != null) {
                int gK;
                if (com.tencent.mm.model.s.fq(rVar.Tj())) {
                    gK = m.gK(rVar.Tj());
                } else {
                    gK = 0;
                }
                boolean nD = q.nD(nK);
                x.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(this.tTx.tTy.gJ(bdVar.field_msgId)), Boolean.valueOf(this.tWB)});
                if (nD) {
                    h.mEJ.h(12084, new Object[]{Integer.valueOf(rVar.dHI), Integer.valueOf(rVar.enM * 1000), Integer.valueOf(0), Integer.valueOf(3), rVar.Tj(), Integer.valueOf(gK), r.nH(rVar.Tm()), Long.valueOf(rVar.createTime)});
                    if (!com.tencent.mm.pluginsdk.h.b.a.a.c(nK, this.tTx.tTy.mController.tml, nD)) {
                        Toast.makeText(this.tTx.tTy.mController.tml, this.tTx.tTy.getString(R.l.video_play_export_file_error), 0).show();
                    }
                } else if (com.tencent.mm.compatible.e.q.deW.ddT != 1 || !com.tencent.mm.pluginsdk.h.b.a.a.b(rVar.getFileName(), this.tTx.tTy.mController.tml, nD)) {
                    au.HU();
                    if (((Integer) c.DT().get(com.tencent.mm.storage.aa.a.sUA, Integer.valueOf(0))).intValue() == 1 && Fl.tXc != null) {
                        Fl.tXc.setVisibility(0);
                        Fl.tXc.setText(com.tencent.mm.plugin.sight.base.d.Ho(nK));
                    }
                    int i2 = rVar.enM;
                    int i3 = rVar.dHI;
                    String Tj = rVar.Tj();
                    String nH = r.nH(rVar.Tm());
                    long j = rVar.createTime;
                    Fl.nFC = i2;
                    Fl.tXo = i3;
                    Fl.tXp = gK;
                    Fl.bSS = Tj;
                    Fl.fileId = nH;
                    Fl.createTime = j;
                    this.nPt = z;
                    this.tWv = true;
                    this.filename = rVar.getFileName();
                    if (r4 == 3) {
                        Fl.cxz().tXa.setMute(true);
                    } else {
                        Fl.cxz().tXa.setMute(false);
                    }
                    if (Fl.cxz().tXa.getVideoPath() == null || !Fl.cxz().tXa.getVideoPath().equals(nK) || Fl.cxz().tXa.isPlaying() || this.tWB) {
                        this.tWx = false;
                        this.tWB = false;
                        Fl.cxz().tXa.setVideoPath(nK);
                        if (Fl.cxz().tXa instanceof VideoPlayerTextureView) {
                            boolean z2;
                            ((VideoPlayerTextureView) Fl.cxz().tXa).setIOnlineCache(this.ldj);
                            VideoPlayerTextureView videoPlayerTextureView = (VideoPlayerTextureView) Fl.cxz().tXa;
                            if (this.nPt) {
                                au.HU();
                                z2 = c.DT().getBoolean(com.tencent.mm.storage.aa.a.sVF, false);
                            } else {
                                z2 = false;
                            }
                            videoPlayerTextureView.setNeedResetExtractor(z2);
                            ((VideoPlayerTextureView) Fl.cxz().tXa).setIsOnlineVideoType(z);
                        }
                        Fl.a(true, 0.0f);
                    } else {
                        Fl.a(true, 1.0f);
                        Fl.cxz().tXa.start();
                        bCs();
                        if (!z) {
                            aaz(this.filename);
                        }
                        FI(Fl.cxz().tXa.getCurrentPosition() / 1000);
                        bS(false);
                    }
                    this.tWt.put(i, rVar);
                    this.tTx.tTy.md(false);
                    this.tTx.tTy.mController.tml.getWindow().addFlags(128);
                    if (com.tencent.mm.compatible.util.d.fS(18)) {
                        aaz(this.filename);
                    }
                    this.gbl.a(this);
                } else {
                    return;
                }
                Fl.cxz().tXb.setVisibility(8);
            }
        }
    }

    private void a(bd bdVar, r rVar) {
        if (ab.bU(this.tTx.tTy.mController.tml) || tWC) {
            b(bdVar, rVar);
        } else {
            com.tencent.mm.ui.base.h.a(this.tTx.tTy.mController.tml, R.l.video_export_file_warning, R.l.app_tip, new 1(this, bdVar, rVar), null);
        }
    }

    private void b(bd bdVar, r rVar) {
        x.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", new Object[]{Integer.valueOf(hashCode())});
        if (bdVar != null && rVar != null) {
            j cwO = this.tTx.cwO();
            if (cwO != null) {
                Object obj;
                z.w(bdVar);
                int gJ = this.tTx.tTy.gJ(bdVar.field_msgId);
                x.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : " + gJ);
                switch (gJ) {
                    case 0:
                        break;
                    case 1:
                    case 2:
                        if (rVar.To()) {
                            x.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
                            t.oa(bdVar.field_imgPath);
                        } else {
                            x.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
                            do(bdVar.field_imgPath, 10);
                            t.nS(bdVar.field_imgPath);
                        }
                        o.Ta().a(this, Looper.getMainLooper());
                        this.tTx.tTy.cxh();
                        this.tWG = false;
                        cwO.cxz().tWZ.setVisibility(8);
                        cwO.cxz().tXb.setVisibility(0);
                        cwO.cxz().tXb.setProgress(t.f(rVar));
                        if (gJ == 2) {
                            h.mEJ.a(354, 14, 1, false);
                            return;
                        } else {
                            h.mEJ.a(354, 11, 1, false);
                            return;
                        }
                    case 3:
                        x.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(gJ)});
                        break;
                    default:
                        x.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[]{Integer.valueOf(gJ)});
                        return;
                }
                l lVar = this.tWu;
                String str = bdVar.field_imgPath;
                com.tencent.mm.modelcontrol.d.NP();
                if (com.tencent.mm.modelcontrol.d.NU()) {
                    lVar.reset();
                    r nW = t.nW(str);
                    if (nW == null || nW.dHI >= lVar.tXL.tXN) {
                        j jVar;
                        t.W(str, 1);
                        n.SY();
                        o.Tb();
                        if (bi.oW(str)) {
                            jVar = null;
                        } else {
                            r nW2 = t.nW(str);
                            if (nW2 == null) {
                                jVar = null;
                            } else {
                                Map z = bl.z(nW2.Tm(), "msg");
                                if (z == null) {
                                    x.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
                                    jVar = null;
                                } else {
                                    String str2 = (String) z.get(".msg.videomsg.$cdnvideourl");
                                    if (bi.oW(str2)) {
                                        x.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
                                        jVar = null;
                                    } else {
                                        int intValue = Integer.valueOf((String) z.get(".msg.videomsg.$length")).intValue();
                                        String str3 = (String) z.get(".msg.videomsg.$md5");
                                        String str4 = (String) z.get(".msg.videomsg.$aeskey");
                                        String str5 = (String) z.get(".msg.videomsg.$fileparam");
                                        String a = com.tencent.mm.modelcdntran.d.a("downvideo", nW2.createTime, nW2.Tj(), nW2.getFileName());
                                        if (bi.oW(a)) {
                                            x.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", new Object[]{nW2.getFileName()});
                                            jVar = null;
                                        } else {
                                            o.Ta();
                                            String nK = s.nK(str);
                                            j jVar2 = new j();
                                            jVar2.filename = str;
                                            jVar2.dQk = str3;
                                            jVar2.dQl = intValue;
                                            jVar2.dQm = 1;
                                            jVar2.bSS = nW2.Tk();
                                            jVar2.dQn = nW2.Tj();
                                            jVar2.bSU = com.tencent.mm.model.s.fq(nW2.Tj()) ? m.gK(nW2.Tj()) : 0;
                                            jVar2.field_mediaId = a;
                                            jVar2.field_fullpath = nK;
                                            jVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
                                            jVar2.field_totalLen = intValue;
                                            jVar2.field_aesKey = str4;
                                            jVar2.field_fileId = str2;
                                            jVar2.field_priority = com.tencent.mm.modelcdntran.b.dOk;
                                            jVar2.field_wxmsgparam = str5;
                                            jVar2.field_chattype = com.tencent.mm.model.s.fq(nW2.Tj()) ? 1 : 0;
                                            jVar2.dQo = nW2.dQo;
                                            bd I = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().I(nW2.Tj(), nW2.bYu);
                                            com.tencent.mm.model.bd.b iF = com.tencent.mm.model.bd.iF(I.cqb);
                                            jVar2.initialDownloadLength = iF != null ? iF.dCA : 0;
                                            jVar2.initialDownloadOffset = 0;
                                            jVar2.dQq = I.field_createTime;
                                            jVar2.bYu = I.field_msgSvrId;
                                            jVar2.dQr = iF != null ? iF.dCB : 0;
                                            if (jVar2.initialDownloadLength > 0) {
                                                h.mEJ.a(354, 36, 1, false);
                                            }
                                            jVar2.field_autostart = false;
                                            jVar2.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(1, nW2);
                                            jVar = jVar2;
                                        }
                                    }
                                }
                            }
                        }
                        if (jVar == null) {
                            obj = null;
                        } else {
                            lVar.mediaId = jVar.field_mediaId;
                            lVar.fhf = jVar.dQl;
                            lVar.filename = str;
                            lVar.elC = 1;
                            lVar.elF = 0;
                            o.Tb().a(jVar, o.Tf().Tx());
                            lVar.dQj = bi.VF();
                            h.mEJ.a(354, 1, 1, false);
                            x.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", new Object[]{lVar.mediaId, str, Long.valueOf(lVar.dQj)});
                            obj = 1;
                        }
                    } else {
                        x.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", new Object[]{Integer.valueOf(nW.dHI), Integer.valueOf(lVar.tXL.tXN)});
                        t.b(nW, 9);
                        h.mEJ.a(354, 17, 1, false);
                        obj = null;
                    }
                } else {
                    obj = null;
                }
                if (obj != null) {
                    x.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
                    this.nPt = true;
                    o.Ta().a((com.tencent.mm.modelvideo.s.a) this);
                    this.tTx.tTy.cxh();
                    this.tWG = false;
                    cwO.cxz().tWZ.setVisibility(8);
                    cwO.cxz().tXb.setVisibility(8);
                    cwO.cxz().tXi.setVisibility(0);
                    return;
                }
                x.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
                this.nPt = false;
                o.Ta().a(this, Looper.getMainLooper());
                t.nS(bdVar.field_imgPath);
                this.tTx.tTy.cxh();
                this.tWG = false;
                cwO.cxz().tWZ.setVisibility(8);
                cwO.cxz().tXb.setVisibility(0);
                cwO.cxz().tXb.setProgress(t.f(rVar));
            }
        }
    }

    private void do(String str, int i) {
        au.Em().H(new 10(this, str, i));
    }

    private boolean b(a aVar) {
        if (aVar == null) {
            return false;
        }
        o.Ta().a((com.tencent.mm.modelvideo.s.a) this);
        if (this.tTx.tTy.getCurrentItem() == aVar.pos) {
            j Fl = Fl(aVar.pos);
            if (Fl != null) {
                Fl.cxz().tXi.setVisibility(8);
                Fl.cxz().tXb.setVisibility(8);
                Fl.cxz().tWZ.setVisibility(8);
            }
            this.tWG = true;
            this.tTx.tTy.cxg();
            return true;
        }
        this.tTx.Ft(aVar.pos);
        return false;
    }

    public final void cwV() {
        x.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
        this.nPy = bi.VF();
        SparseArray sparseArray = this.tTx.tzb;
        int i = 0;
        boolean z = false;
        while (i < sparseArray.size()) {
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                j jVar = (j) ((View) sparseArray.get(keyAt)).getTag();
                if (jVar.tWX != null && jVar.cxz().tWX.getVisibility() == 0 && (((View) jVar.cxz().tXa).getVisibility() == 0 || !bi.oW(jVar.cxz().tXa.getVideoPath()) || (this.nPt && this.tWu.isStreaming()))) {
                    x.i("MicroMsg.Imagegallery.handler.video", "stop");
                    bCq();
                    if (jVar != null) {
                        bCt();
                        if (this.nPt) {
                            this.tWu.cxB();
                        }
                        if (!this.tWw) {
                            t.c(this.filename, this.tWy - 1000, this.nPt);
                        }
                        jVar.cxz().tXb.setVisibility(8);
                        jVar.cxz().tXi.setVisibility(8);
                        jVar.cxz().tXa.stop();
                        FI(0);
                        jVar.a(false, 0.0f);
                        this.nPt = false;
                        this.tWG = false;
                        this.tWB = false;
                        this.filename = null;
                        this.nPE = 0;
                        this.nPD = 0;
                        this.tWH = 0;
                        this.tWE = 0;
                        this.tWA = 0;
                        this.tWz = 0;
                        this.qEu = 0;
                        this.lastCheckTime = 0;
                    }
                    z = true;
                }
            }
            i++;
            z = z;
        }
        this.gbl.bv(false);
        if (!z && this.nPt) {
            this.tWu.cxB();
            this.nPt = false;
        }
        bCq();
        this.tWt.clear();
    }

    private void b(j jVar) {
        if (jVar != null) {
            bCq();
            x.d("MicroMsg.Imagegallery.handler.video", "pause video.");
            if (jVar.cxz().tXa.isPlaying()) {
                jVar.cxz().tXa.pause();
                bCt();
            }
        }
    }

    protected final void onResume() {
        x.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
        this.tWD.removeMessages(1);
        com.tencent.mm.sdk.b.a.sFg.b(this.tWF);
        if (this.tTx != null && com.tencent.mm.compatible.util.d.fR(21)) {
            j cwO = this.tTx.cwO();
            if (cwO != null && cwO.tXa != null) {
                if (cwO.tXa instanceof VideoPlayerTextureView) {
                    ((VideoPlayerTextureView) cwO.tXa).bdC();
                } else if (cwO.tXa instanceof VideoTextureView) {
                    ((VideoTextureView) cwO.tXa).bdC();
                }
            }
        }
    }

    public final void detach() {
        x.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", new Object[]{Integer.valueOf(hashCode())});
        this.nPy = bi.VF();
        this.tWD.removeMessages(1);
        bCq();
        com.tencent.mm.sdk.b.a.sFg.c(this.tWs);
        com.tencent.mm.sdk.b.a.sFg.c(this.tWF);
        cwV();
        this.tTx.tTy.mController.tml.getWindow().clearFlags(128);
        this.tTx.tTy.cwX().tVM.setIplaySeekCallback(null);
        super.detach();
        this.tVv.clear();
        this.tVv = null;
        o.Ta().a((com.tencent.mm.modelvideo.s.a) this);
        this.tWt.clear();
        l lVar = this.tWu;
        lVar.reset();
        lVar.elE = null;
        lVar.tXK = null;
        lVar.tXL = null;
        if (com.tencent.mm.plugin.u.e.bds()) {
            au.Em().H(new 9(this));
        }
        o.Tf().Tx();
        o.Tf().run();
    }

    public final void cxt() {
        this.tWw = false;
        this.jfN = 0;
        j cwO = this.tTx != null ? this.tTx.cwO() : null;
        if (cwO == null) {
            x.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
            return;
        }
        int ge = bi.ge((long) cwO.cxz().tXa.getDuration());
        int videoTotalTime = this.tTx.tTy.cwX().tVM.getVideoTotalTime();
        x.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(ge), Integer.valueOf(videoTotalTime)});
        if (videoTotalTime <= 0 || Math.abs(videoTotalTime - ge) >= 2) {
            this.tTx.tTy.cwX().tVM.setVideoTotalTime(ge);
        }
        cxv();
        if (ge == 0 || ge >= 1800) {
            x.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(ge), this.filename});
        } else {
            au.Em().H(new 6(this, ge));
        }
        ge = t.w(ge, this.filename);
        x.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", new Object[]{Boolean.valueOf(this.nPt), Integer.valueOf(ge), Boolean.valueOf(this.tWv), Boolean.valueOf(this.tWw)});
        cwO.cxz().tXa.setOneTimeVideoTextureUpdateCallback(this.nPi);
        if (this.tWv) {
            if (this.nPt) {
                l lVar = this.tWu;
                if (ge > 0) {
                    x.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : " + ge);
                    lVar.elG = ge;
                    lVar.elI = true;
                    lVar.elD = 2;
                }
                this.tWu.iC(0);
            } else {
                this.tWu.reset();
                bCs();
                R(ge, true);
            }
            bS(false);
            return;
        }
        if (this.nPt) {
            this.tWu.ap(ge, false);
        } else {
            R(ge, false);
        }
        FI(ge);
        this.tTx.tTy.md(true);
        bCq();
    }

    public final void cxu() {
        int i;
        x.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.nPt);
        bCq();
        bCt();
        if (!(!this.nPt || this.tTx == null || this.tTx.cwO() == null)) {
            f fVar = this.tTx.cwO().cxz().tXa;
            if (fVar != null && fVar.getCurrentPosition() + 2000 < fVar.getDuration()) {
                x.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", new Object[]{Integer.valueOf(fVar.getCurrentPosition()), Integer.valueOf(fVar.getDuration())});
                i = 0;
                if (i == 0) {
                    ah.A(new 12(this));
                }
                try {
                    t.c(this.filename, this.tTx.cwO().tXa.getCurrentPosition(), this.nPt);
                    this.tTx.cwO().tXa.stop();
                    this.tWu.cxC();
                    i = this.tWE + 1;
                    this.tWE = i;
                    if (i <= 3) {
                        a aVar = (a) this.tVv.get(this.filename);
                        if (aVar != null && aVar.bGS != null) {
                            a(aVar.bGS, bA(aVar.bGS), aVar.pos, this.nPt);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e, "notify video completion error[%s]", new Object[]{e.toString()});
                    return;
                }
            }
        }
        i = 1;
        if (i == 0) {
            try {
                t.c(this.filename, this.tTx.cwO().tXa.getCurrentPosition(), this.nPt);
                this.tTx.cwO().tXa.stop();
                this.tWu.cxC();
                i = this.tWE + 1;
                this.tWE = i;
                if (i <= 3) {
                    a aVar2 = (a) this.tVv.get(this.filename);
                    if (aVar2 != null && aVar2.bGS != null) {
                        a(aVar2.bGS, bA(aVar2.bGS), aVar2.pos, this.nPt);
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e2, "notify video completion error[%s]", new Object[]{e2.toString()});
                return;
            }
        }
        ah.A(new 12(this));
    }

    public final void eZ(int i, int i2) {
        String str = "MicroMsg.Imagegallery.handler.video";
        String str2 = "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(this.nPt);
        l lVar = this.tWu;
        boolean z = !bi.oW(lVar.mediaId) && lVar.elC == 1;
        objArr[3] = Boolean.valueOf(z);
        x.e(str, str2, objArr);
        this.tWw = true;
        this.jfN = i2;
        if (this.nPt) {
            if (i == -1) {
                bCq();
                this.tTx.cwO().tXa.stop();
                this.tWu.cxC();
            } else if (i == -2) {
                bCq();
                t.c(this.filename, this.tTx.cwO().tXa.getCurrentPosition(), this.nPt);
                this.tTx.cwO().tXa.stop();
                this.tWu.cxC();
            } else if (i == -3) {
                this.tWw = false;
                this.tWu.cxC();
                return;
            }
            this.tWG = false;
            this.tTx.tTy.md(true);
            this.tTx.cwO().cxz().tXi.setVisibility(0);
            bCt();
            h.mEJ.a(354, 18, 1, false);
            return;
        }
        String str3;
        t.nZ(this.filename);
        bCt();
        if (this.tTx == null || this.tTx.cwO() == null || this.tTx.cwO().tXa == null) {
            str3 = "";
        } else {
            str3 = this.tTx.cwO().tXa.getVideoPath();
            this.tTx.cwO().tXa.stop();
        }
        if (this.tWx) {
            x.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        ah.A(new 13(this, str3));
        h.mEJ.a(354, 25, 1, false);
    }

    private void bCq() {
        x.i("MicroMsg.Imagegallery.handler.video", "clear timer");
        this.nPz.SO();
        this.hEr.SO();
    }

    protected final void bS(boolean z) {
        if (!this.tWw) {
            if (!this.nPt) {
                this.hEr.J(500, 500);
            } else if (z) {
                ah.A(new 14(this));
            } else {
                this.nPz.J(500, 500);
            }
        }
    }

    public final void FH(int i) {
        this.tWt.remove(i);
    }

    public final void a(s$a$a s_a_a) {
        String str = s_a_a.fileName;
        if (!bi.oW(str) && this.tVv != null) {
            a aVar = (a) this.tVv.get(str);
            if (aVar != null) {
                bd bdVar = aVar.bGS;
                if (bdVar != null && bdVar.field_imgPath != null && bdVar.field_imgPath.equals(str)) {
                    r bA = bA(bdVar);
                    if (bA == null) {
                        return;
                    }
                    if (!bdVar.cmu() && bA.status != 198) {
                        int f = t.f(bA);
                        j Fl = Fl(aVar.pos);
                        if (this.tTx.tTy.getCurrentItem() == aVar.pos && Fl != null) {
                            this.tTx.tTy.cxh();
                            this.tWG = false;
                            Fl.cxz().tXb.setVisibility(0);
                            Fl.cxz().tXb.setProgress(f);
                        } else if (Fl == null) {
                            return;
                        }
                        if (f >= Fl.cxz().tXb.getMax()) {
                            x.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", new Object[]{Integer.valueOf(bA.status)});
                            if ((bA.status == 199 || bA.status == 199) && b(aVar)) {
                                this.tTx.tTy.fm(true);
                                switch (this.tTx.tTy.gJ(bdVar.field_msgId)) {
                                    case 0:
                                    case 3:
                                        a(bdVar, bA, this.tTx.tTy.getCurrentItem(), false);
                                        return;
                                    case 1:
                                        x.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
                                        h.mEJ.a(354, 15, 1, false);
                                        this.tTx.bo(bdVar);
                                        this.tTx.tTy.gK(-1);
                                        if (this.nPt) {
                                            t.c(this.filename, this.tTx.cwO().tXa.getCurrentPosition(), this.nPt);
                                            this.tWB = true;
                                        }
                                        this.nPt = false;
                                        return;
                                    case 2:
                                        h.mEJ.a(354, 16, 1, false);
                                        b.a(this.tTx.tTy, bdVar, true);
                                        this.tTx.tTy.gK(-1);
                                        if (this.nPt) {
                                            t.c(this.filename, this.tTx.cwO().tXa.getCurrentPosition(), this.nPt);
                                            this.tWB = true;
                                        }
                                        this.nPt = false;
                                        return;
                                    default:
                                        x.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", new Object[]{Integer.valueOf(this.tTx.tTy.gJ(bdVar.field_msgId))});
                                        return;
                                }
                            }
                        }
                    } else if (b(aVar)) {
                        Toast.makeText(this.tTx.tTy, R.l.video_fail_or_clean, 0).show();
                    }
                }
            }
        }
    }

    private void cxv() {
        try {
            this.tTx.tTy.cwX().tVM.setIplaySeekCallback(this.qEz);
        } catch (Exception e) {
        }
    }

    protected final void aX(String str, boolean z) {
        ah.A(new 5(this, str, z));
    }

    protected final void R(int i, boolean z) {
        j cwO = this.tTx.cwO();
        if (cwO != null) {
            bCs();
            cwO.cxz().tXi.setVisibility(8);
            cwO.cxz().tXa.d((double) (i * 1000), z);
            this.tTx.tTy.md(false);
            bS(false);
        }
    }

    protected final void SN() {
        j cwO = this.tTx.cwO();
        if (cwO != null) {
            x.i("MicroMsg.Imagegallery.handler.video", "start to pause");
            this.tTx.tTy.md(true);
            cwO.cxz().tXi.setVisibility(0);
            cwO.cxz().tXa.pause();
            bCt();
        }
    }

    protected final boolean bCr() {
        j cwO = this.tTx.cwO();
        if (cwO == null) {
            return false;
        }
        boolean z = true;
        if (!cwO.cxz().tXa.isPlaying()) {
            x.i("MicroMsg.Imagegallery.handler.video", "start to play");
            this.tTx.tTy.md(false);
            cwO.cxz().tXi.setVisibility(8);
            z = cwO.cxz().tXa.start();
            bCs();
        }
        if (cwO.cxz().tXi.getVisibility() == 8) {
            return z;
        }
        cwO.cxz().tXi.setVisibility(8);
        return z;
    }

    protected final void FI(int i) {
        this.tTx.tTy.cwX().tVM.seek(Math.max(0, i));
    }

    protected final void aaz(String str) {
        if (!this.tWG && !b((a) this.tVv.get(str))) {
            x.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
        }
    }

    private void bCs() {
        this.nPD = bi.VF();
        x.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", new Object[]{this.filename, Long.valueOf(this.nPD)});
    }

    private void bCt() {
        if (this.nPD > 0) {
            this.nPE = (int) (((long) this.nPE) + ((bi.VF() - this.nPD) / 1000));
        }
        x.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", new Object[]{this.filename, Integer.valueOf(this.nPE)});
        this.nPD = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(com.tencent.mm.ui.chatting.gallery.j r13) {
        /*
        r12 = this;
        r6 = 0;
        r11 = 3;
        r10 = 2;
        r9 = 1;
        r8 = 0;
        r0 = r12.tWy;
        r1 = r13.cxz();
        r1 = r1.tXa;
        r1 = r1.getCurrentPosition();
        r12.tWy = r1;
        r1 = r12.tWy;
        if (r0 == r1) goto L_0x0186;
    L_0x0018:
        r0 = com.tencent.mm.sdk.platformtools.bi.VF();
        r12.lastCheckTime = r0;
        r0 = r13.cxz();
        r0 = r0.tXa;
        r0 = r0.getLastSurfaceUpdateTime();
        r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0096;
    L_0x002c:
        r2 = r12.qEu;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0096;
    L_0x0032:
        r12.qEu = r0;
        r1 = r12.tWz;
        switch(r1) {
            case 2: goto L_0x003d;
            case 3: goto L_0x0090;
            case 4: goto L_0x0093;
            default: goto L_0x0039;
        };
    L_0x0039:
        r12.tWz = r8;
    L_0x003b:
        r8 = r9;
    L_0x003c:
        return r8;
    L_0x003d:
        r0 = 21;
    L_0x003f:
        r2 = "MicroMsg.Imagegallery.handler.video";
        r3 = "%d rpt rptRepairEffect idKey %d errorTime %d filename %s";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = r12.hashCode();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r8] = r5;
        r5 = java.lang.Integer.valueOf(r0);
        r4[r9] = r5;
        r1 = java.lang.Integer.valueOf(r1);
        r4[r10] = r1;
        r1 = r12.filename;
        r4[r11] = r1;
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = (long) r0;
        r6 = 1;
        r1.a(r2, r4, r6, r8);
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 13836; // 0x360c float:1.9388E-41 double:6.836E-320;
        r2 = new java.lang.Object[r11];
        r3 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r4 = com.tencent.mm.sdk.platformtools.bi.VE();
        r3 = java.lang.Long.valueOf(r4);
        r2[r9] = r3;
        r3 = "";
        r2[r10] = r3;
        r0.h(r1, r2);
        goto L_0x0039;
    L_0x0090:
        r0 = 22;
        goto L_0x003f;
    L_0x0093:
        r0 = 23;
        goto L_0x003f;
    L_0x0096:
        r0 = r12.tWz;
        r1 = -1;
        if (r0 == r1) goto L_0x003b;
    L_0x009b:
        r0 = r12.tWz;
        r0 = r0 + 1;
        r12.tWz = r0;
        r0 = "MicroMsg.Imagegallery.handler.video";
        r1 = "media play is playing[%d], but surface is not update!! repair time[%d]";
        r2 = new java.lang.Object[r10];
        r3 = r12.tWz;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r3 = r12.tWA;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r9] = r3;
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);
        r0 = r12.tWA;
        if (r0 < r10) goto L_0x00c5;
    L_0x00c0:
        r0 = r12.tWu;
        r0.cxC();
    L_0x00c5:
        r0 = r12.tWz;
        switch(r0) {
            case 0: goto L_0x003b;
            case 1: goto L_0x003b;
            case 2: goto L_0x011c;
            case 3: goto L_0x013c;
            case 4: goto L_0x0161;
            default: goto L_0x00ca;
        };
    L_0x00ca:
        r0 = "MicroMsg.Imagegallery.handler.video";
        r1 = "rpt surface not update!!";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = "MicroMsg.Imagegallery.handler.video";
        r1 = "%d rpt rptSurfaceNotUpdate %s";
        r2 = new java.lang.Object[r10];
        r3 = r12.hashCode();
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r3 = r12.filename;
        r2[r9] = r3;
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 13836; // 0x360c float:1.9388E-41 double:6.836E-320;
        r2 = new java.lang.Object[r11];
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        r4 = com.tencent.mm.sdk.platformtools.bi.VE();
        r3 = java.lang.Long.valueOf(r4);
        r2[r9] = r3;
        r3 = "";
        r2[r10] = r3;
        r0.h(r1, r2);
        r1 = com.tencent.mm.plugin.report.service.h.mEJ;
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 20;
        r6 = 1;
        r1.a(r2, r4, r6, r8);
        r0 = -1;
        r12.tWz = r0;
        goto L_0x003b;
    L_0x011c:
        r0 = r12.tWy;
        r0 = r0 / 1000;
        r1 = "MicroMsg.Imagegallery.handler.video";
        r2 = "surface not update, it try seek time[%d] to repair.";
        r3 = new java.lang.Object[r9];
        r4 = java.lang.Integer.valueOf(r0);
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.x.w(r1, r2, r3);
        r12.R(r0, r9);
        r0 = r12.tWA;
        r0 = r0 + 1;
        r12.tWA = r0;
        goto L_0x003c;
    L_0x013c:
        r0 = r12.tWy;
        r0 = r0 + -2000;
        r0 = r0 / 1000;
        if (r0 >= 0) goto L_0x0145;
    L_0x0144:
        r0 = r8;
    L_0x0145:
        r1 = "MicroMsg.Imagegallery.handler.video";
        r2 = "surface not update, it try seek time[%d] to repair.";
        r3 = new java.lang.Object[r9];
        r4 = java.lang.Integer.valueOf(r0);
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.x.w(r1, r2, r3);
        r12.R(r0, r9);
        r0 = r12.tWA;
        r0 = r0 + 1;
        r12.tWA = r0;
        goto L_0x003c;
    L_0x0161:
        r0 = r12.tWy;
        r0 = r0 + -4000;
        r0 = r0 / 1000;
        if (r0 >= 0) goto L_0x016a;
    L_0x0169:
        r0 = r8;
    L_0x016a:
        r1 = "MicroMsg.Imagegallery.handler.video";
        r2 = "surface not update, it try seek time[%d] to repair.";
        r3 = new java.lang.Object[r9];
        r4 = java.lang.Integer.valueOf(r0);
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.x.w(r1, r2, r3);
        r12.R(r0, r9);
        r0 = r12.tWA;
        r0 = r0 + 1;
        r12.tWA = r0;
        goto L_0x003c;
    L_0x0186:
        r1 = "MicroMsg.Imagegallery.handler.video";
        r2 = "check time[%d, %d], play time[%d, %d]";
        r3 = 4;
        r3 = new java.lang.Object[r3];
        r4 = r12.lastCheckTime;
        r4 = java.lang.Long.valueOf(r4);
        r3[r8] = r4;
        r4 = com.tencent.mm.sdk.platformtools.bi.VF();
        r4 = java.lang.Long.valueOf(r4);
        r3[r9] = r4;
        r0 = java.lang.Integer.valueOf(r0);
        r3[r10] = r0;
        r0 = r12.tWy;
        r0 = java.lang.Integer.valueOf(r0);
        r3[r11] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        r0 = r12.lastCheckTime;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x003b;
    L_0x01b8:
        r0 = r12.lastCheckTime;
        r0 = com.tencent.mm.sdk.platformtools.bi.bH(r0);
        r2 = 1500; // 0x5dc float:2.102E-42 double:7.41E-321;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x003b;
    L_0x01c4:
        r0 = "MicroMsg.Imagegallery.handler.video";
        r1 = "play time not update! request all video data to play. ";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = r12.tTx;
        r0 = r0.cwO();
        r0 = r0.tXa;
        r0 = r0.getCurrentPosition();
        r12.bCq();
        r1 = r12.filename;
        r2 = r12.nPt;
        com.tencent.mm.modelvideo.t.c(r1, r0, r2);
        r0 = r12.tTx;
        r0 = r0.cwO();
        r0 = r0.tXa;
        r0.stop();
        r0 = r12.tWu;
        r0.cxC();
        r0 = r12.tVv;
        r1 = r12.filename;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.ui.chatting.gallery.i.a) r0;
        if (r0 == 0) goto L_0x003c;
    L_0x01ff:
        r1 = r0.bGS;
        if (r1 == 0) goto L_0x003c;
    L_0x0203:
        r1 = r0.bGS;
        r1 = bA(r1);
        r2 = r0.bGS;
        r0 = r0.pos;
        r3 = r12.nPt;
        r12.a(r2, r1, r0, r3);
        r12.lastCheckTime = r6;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.i.c(com.tencent.mm.ui.chatting.gallery.j):boolean");
    }
}
