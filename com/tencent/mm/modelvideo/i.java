package com.tencent.mm.modelvideo;

import com.tencent.mm.g.b.a.f;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i implements a {
    LinkedList<bd> emG = new LinkedList();
    long emH = 0;
    private int emI = 0;
    private int emJ = 0;
    public boolean emK = false;
    public boolean emL = false;
    private boolean emM = false;
    private boolean emN = false;
    f emO = null;
    long emP = 0;

    static /* synthetic */ boolean a(i iVar) {
        long VG = bi.VG();
        x.i("MicroMsg.PreloadVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d] isC2C[%b]", new Object[]{Integer.valueOf(iVar.hashCode()), Integer.valueOf(1), Integer.valueOf(s$l.AppCompatTheme_switchStyle), Long.valueOf(bi.VE() - (((long) ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getInt("PreLoadVideoExpiredTime", 1)) * 86400)), Boolean.valueOf(true)});
        List<r> n = o.Ta().n(s$l.AppCompatTheme_switchStyle, r0);
        if (n == null || n.isEmpty()) {
            return false;
        }
        int i = 0;
        for (r rVar : n) {
            if (rVar != null) {
                o.Ta();
                String nK = s.nK(rVar.getFileName());
                if (!bi.oW(nK)) {
                    File file = new File(nK);
                    if (file.exists()) {
                        long length = file.length();
                        x.i("MicroMsg.PreloadVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", new Object[]{rVar.getFileName(), Long.valueOf(length), Integer.valueOf(rVar.bSX), Long.valueOf(rVar.enK), nK});
                        if (length > 0 && length <= ((long) rVar.bSX)) {
                            file.delete();
                            i++;
                        }
                    }
                }
                int i2 = i;
                rVar.bSX = 0;
                rVar.bWA = 1;
                t.e(rVar);
                i = i2;
            }
        }
        h.mEJ.a(354, 144, (long) i, false);
        x.i("MicroMsg.PreloadVideoService", "%d delete expire file size %d delete count %d costTime[%d]", new Object[]{Integer.valueOf(iVar.hashCode()), Integer.valueOf(n.size()), Integer.valueOf(i), Long.valueOf(bi.bI(VG))});
        return false;
    }

    public final void stopDownload() {
        x.i("MicroMsg.PreloadVideoService", "%d stop download", new Object[]{Integer.valueOf(hashCode())});
        g.Em().H(new 1(this));
    }

    public final void ST() {
        g.Em().H(new Runnable() {
            public final void run() {
                if (!o.Tf().bFg && i.this.emO == null && !i.this.emK && !i.this.emL) {
                    if (i.this.emG.isEmpty()) {
                        Object obj;
                        i iVar = i.this;
                        if (bi.bG(iVar.emP) > 600) {
                            iVar.emP = bi.VE();
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            i.a(i.this);
                            return;
                        }
                        return;
                    }
                    cm cmVar = null;
                    PBool pBool = new PBool();
                    synchronized (i.this.emG) {
                        Iterator it = i.this.emG.iterator();
                        while (it.hasNext()) {
                            Object obj2;
                            cmVar = (bd) it.next();
                            i iVar2 = i.this;
                            if (cmVar == null) {
                                pBool.value = true;
                                obj2 = null;
                            } else {
                                r nW = t.nW(cmVar.field_imgPath);
                                if (nW != null && nW.Tp()) {
                                    x.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", new Object[]{Integer.valueOf(iVar2.hashCode()), nW.getFileName()});
                                    Map z = bl.z(nW.Tm(), "msg");
                                    String str = (String) z.get(".msg.videomsg.$newmd5");
                                    String str2 = (String) z.get(".msg.videomsg.$cdnvideourl");
                                    boolean fq = s.fq(nW.Tj());
                                    iVar2.a(str, fq ? 2 : 1, (long) nW.dHI, nW.Tk(), nW.Tj(), s.fq(nW.Tj()) ? m.gK(nW.Tj()) : 0, str2, "", "");
                                    h.mEJ.a(354, 146, 1, false);
                                    if (fq) {
                                        h.mEJ.a(354, 126, 1, false);
                                    } else {
                                        h.mEJ.a(354, 125, 1, false);
                                    }
                                    pBool.value = true;
                                    obj2 = null;
                                } else if (bi.bH(cmVar.field_createTime) >= 86400000) {
                                    x.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", new Object[]{Integer.valueOf(iVar2.hashCode())});
                                    pBool.value = true;
                                    obj2 = null;
                                } else {
                                    if (iVar2.bU(true)) {
                                        x.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", new Object[]{Integer.valueOf(iVar2.hashCode()), Long.valueOf(iVar2.emH)});
                                    } else {
                                        x.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", new Object[]{Integer.valueOf(iVar2.hashCode()), Long.valueOf(cmVar.field_msgId), cmVar.cqb});
                                        b iF = com.tencent.mm.model.bd.iF(cmVar.cqb);
                                        if (iF == null) {
                                            pBool.value = true;
                                            obj2 = null;
                                        } else if (iF.dCB <= 0) {
                                            pBool.value = true;
                                            obj2 = null;
                                        } else if (!com.tencent.mm.modelcontrol.b.lz(iF.dCD)) {
                                            int i;
                                            if (ao.isWifi(ad.getContext())) {
                                                i = iF.dCC & 1;
                                            } else if (ao.is4G(ad.getContext())) {
                                                i = iF.dCC & 2;
                                            } else if (ao.is3G(ad.getContext())) {
                                                i = iF.dCC & 4;
                                            } else {
                                                pBool.value = false;
                                                obj2 = null;
                                            }
                                            if (i > 0) {
                                                pBool.value = false;
                                                obj2 = 1;
                                            }
                                        }
                                    }
                                    pBool.value = false;
                                    obj2 = null;
                                }
                            }
                            if (pBool.value) {
                                it.remove();
                            }
                            if (obj2 != null) {
                                break;
                            }
                            cmVar = null;
                        }
                    }
                    if (cmVar != null) {
                        i.this.emO = new f(cmVar.field_msgId);
                        x.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", new Object[]{Integer.valueOf(i.this.hashCode()), i.this.emO.SS()});
                        if (i.this.emO.a(i.this) < 0) {
                            x.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", new Object[]{Integer.valueOf(i.this.hashCode())});
                            synchronized (i.this.emG) {
                                Iterator it2 = i.this.emG.iterator();
                                while (it2.hasNext()) {
                                    bd bdVar = (bd) it2.next();
                                    if (bdVar != null && bdVar.field_msgId == i.this.emO.bJC) {
                                        x.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[]{Integer.valueOf(i.this.hashCode()), Long.valueOf(i.this.emO.bJC)});
                                        it2.remove();
                                    }
                                }
                            }
                            i.this.emO = null;
                        }
                    }
                }
            }
        });
    }

    public final void a(final f fVar, boolean z, int i, int i2) {
        if (fVar == null) {
            x.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        if (this.emO != fVar) {
            x.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", new Object[]{Integer.valueOf(hashCode())});
        }
        x.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[]{Integer.valueOf(hashCode()), fVar.SS(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
        g.Em().H(new Runnable() {
            public final void run() {
                long j = fVar.bJC;
                synchronized (i.this.emG) {
                    Iterator it = i.this.emG.iterator();
                    while (it.hasNext()) {
                        bd bdVar = (bd) it.next();
                        if (bdVar != null && bdVar.field_msgId == j) {
                            x.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[]{Integer.valueOf(i.this.hashCode()), Long.valueOf(j)});
                            it.remove();
                        }
                    }
                }
                i.this.bT(true);
                if (i.this.emO != null) {
                    i.this.emO.emp = null;
                }
                i.this.emO = null;
                i.a(i.this);
                i.this.ST();
            }
        });
    }

    public final void bT(boolean z) {
        if (z) {
            this.emI = ((Integer) g.Ei().DT().get(aa.a.sXs, Integer.valueOf(0))).intValue();
            this.emI++;
            g.Ei().DT().a(aa.a.sXs, Integer.valueOf(this.emI));
            return;
        }
        this.emJ = ((Integer) g.Ei().DT().get(aa.a.sXt, Integer.valueOf(0))).intValue();
        this.emJ++;
        g.Ei().DT().a(aa.a.sXt, Integer.valueOf(this.emJ));
    }

    public final boolean bU(boolean z) {
        int i;
        int i2;
        boolean z2;
        int i3 = 100;
        this.emH = ((Long) g.Ei().DT().get(aa.a.sXr, Long.valueOf(-1))).longValue();
        if (bi.bH(this.emH) >= 86400000) {
            this.emH = bi.VF();
            g.Ei().DT().a(aa.a.sXr, Long.valueOf(this.emH));
            g.Ei().DT().a(aa.a.sXs, Integer.valueOf(0));
            g.Ei().DT().a(aa.a.sXt, Integer.valueOf(0));
            this.emN = false;
            this.emM = false;
        }
        this.emI = ((Integer) g.Ei().DT().get(aa.a.sXs, Integer.valueOf(0))).intValue();
        this.emJ = ((Integer) g.Ei().DT().get(aa.a.sXt, Integer.valueOf(0))).intValue();
        if (z) {
            i = this.emI;
            i2 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getInt("C2CMaxPreloadVideo", 100);
        } else {
            i = this.emJ;
            i2 = ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getInt("SnsMaxPreloadVideo", 100);
        }
        if (i2 > 0) {
            i3 = i2;
        }
        if (i >= i3) {
            z2 = true;
        } else {
            z2 = false;
        }
        x.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(this.emI), Integer.valueOf(this.emJ)});
        if (z2) {
            if (z) {
                if (!this.emM) {
                    this.emM = true;
                    h.mEJ.a(354, 127, 1, false);
                }
            } else if (!this.emN) {
                this.emN = true;
                h.mEJ.a(354, 128, 1, false);
            }
        }
        return z2;
    }

    public final void a(String str, int i, long j, String str2, String str3, int i2, String str4, String str5, String str6) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bi.VE()).append(",");
        stringBuffer.append(bi.VE()).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(str).append(",");
        stringBuffer.append(i).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(j).append(",");
        stringBuffer.append(",");
        stringBuffer.append(str2).append(",");
        stringBuffer.append(str3).append(",");
        stringBuffer.append(i2).append(",");
        stringBuffer.append(str4).append(",");
        stringBuffer.append(str5).append(",");
        stringBuffer.append(c.OC(str6));
        x.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", new Object[]{Integer.valueOf(hashCode()), stringBuffer.toString()});
        new f(r2).RD();
    }
}
