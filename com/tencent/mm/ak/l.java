package com.tencent.mm.ak;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelstat.h;
import com.tencent.mm.modelstat.r;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.protocal.c.bwj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Map;
import junit.framework.Assert;

public final class l extends com.tencent.mm.ab.l implements k {
    public static boolean DEBUG = true;
    private static long dVL;
    private String TAG;
    public bd bGS;
    private float bSx;
    public String bZR;
    private int dTO;
    private long dTS;
    private String dVA;
    private String dVB;
    private boolean dVC;
    private e dVD;
    private int dVE;
    b dVF;
    private String dVG;
    private boolean dVH;
    private float dVI;
    private String dVJ;
    private String dVK;
    private final f dVg;
    public long dVh;
    private h dVj;
    private String dVk;
    private int dVl;
    private int dVo;
    private com.tencent.mm.modelcdntran.i.a dVu;
    private final b diG;
    private e diJ;
    private long dlN;
    private int dlO;
    private e dlP;
    private boolean dlV;
    private int scene;
    private int startOffset;
    private long startTime;

    public interface a {
        void OS();
    }

    private e OT() {
        if (this.dlP == null) {
            this.dlP = o.Pf().b(Long.valueOf(this.dlN));
        }
        return this.dlP;
    }

    private e OU() {
        if (this.dVD == null) {
            this.dVD = o.Pf().b(Long.valueOf(this.dVh));
        }
        return this.dVD;
    }

    public l(String str, String str2, String str3, int i) {
        this(str, str2, str3, i, "", "");
    }

    public l(String str, String str2, String str3, int i, f fVar, int i2, a aVar, int i3) {
        this(3, str, str2, str3, i, fVar, i2, "", "", true, i3);
        this.dVF = new b(this, aVar);
    }

    private l(String str, String str2, String str3, int i, String str4, String str5) {
        this(4, str, str2, str3, i, null, 0, str4, str5, false, -1);
    }

    public l(int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, boolean z, int i4) {
        this(i, str, str2, str3, i2, fVar, i3, str4, str5, z, i4, 0, -1000.0f, -1000.0f);
    }

    public l(int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, boolean z, int i4, int i5, float f, float f2) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.dVA = "";
        this.dVB = "";
        this.dVC = true;
        this.dVE = 16384;
        this.dTO = 0;
        this.bGS = null;
        this.dVj = null;
        this.dVk = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.dVl = 0;
        this.dVF = new b(this, null);
        this.dVu = new 4(this);
        this.dlV = false;
        x.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", new Object[]{Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2), fVar, Integer.valueOf(i3), str4, str5, Boolean.valueOf(z), Integer.valueOf(i4), Boolean.valueOf(true), bi.cjd(), Integer.valueOf(i5), Float.valueOf(f), Float.valueOf(f2)});
        this.dVH = z;
        this.dVo = i4;
        this.dVg = fVar;
        this.dTO = i2;
        this.scene = i5;
        this.bSx = f2;
        this.dVI = f;
        this.dlO = i;
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.dVG = str4;
        pString.value = str5;
        this.dVh = o.Pf().a(str3, i2, i, i3, pString, pInt, pInt2);
        this.dlN = this.dVh;
        x.i(this.TAG, "FROM A UI :" + str2 + " " + this.dVh);
        if (this.dVh < 0 || !i.hS((int) this.dVh)) {
            x.e(this.TAG, "insert to img storage failed id:" + this.dVh);
            this.dTS = -1;
            this.diG = null;
            return;
        }
        e OT;
        Assert.assertTrue(this.dVh >= 0);
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bwi();
        aVar.dIH = new bwj();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.dIF = s$l.AppCompatTheme_spinnerStyle;
        aVar.dII = 9;
        aVar.dIJ = 1000000009;
        this.diG = aVar.KT();
        this.bZR = str2;
        this.bGS = new bd();
        this.bGS.setType(s.hR(str2));
        this.bGS.ep(str2);
        this.bGS.eX(1);
        this.bGS.setStatus(1);
        this.bGS.eq(pString.value);
        this.bGS.fh(pInt.value);
        this.bGS.fi(pInt2.value);
        this.bGS.ay(com.tencent.mm.model.bd.iD(this.bGS.field_talker));
        this.bGS.setContent(str4);
        com.tencent.mm.j.a.a.yw().c(this.bGS);
        this.dTS = ((i) g.l(i.class)).bcY().T(this.bGS);
        Assert.assertTrue(this.dTS >= 0);
        x.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.dTS);
        e OU = OU();
        OU.bo((long) ((int) this.dTS));
        o.Pf().a(Long.valueOf(this.dVh), OU);
        if (i2 == 1) {
            this.dlN = (long) OU.dTU;
            OT = OT();
        } else {
            OT = OU;
        }
        OT.hL(com.tencent.mm.a.e.cm(o.Pf().o(OT.dTL, "", "")));
        o.Pf().a(Long.valueOf(this.dlN), OT);
        x.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.dlN + " img len = " + OT.dHI);
        bwi bwi = (bwi) this.diG.dID.dIL;
        bwi.rcj = new bhz().VO(str);
        bwi.rck = new bhz().VO(str2);
        bwi.rdW = OT.offset;
        bwi.rdV = OT.dHI;
        bwi.jQd = this.bGS.getType();
        bwi.rJr = i2;
        bwi.rth = ab.bU(ad.getContext()) ? 1 : 2;
        bwi.soa = OT.source;
        bwi.rmB = OT.dTP;
        bwi.ssJ = pInt2.value;
        bwi.ssK = pInt.value;
        a lL = f.lL(str4);
        if (!(lL == null || bi.oW(lL.appId))) {
            bwi.jQb = lL.appId;
            bwi.raM = lL.mediaTagName;
            bwi.raO = lL.messageAction;
            bwi.raN = lL.messageExt;
        }
        x.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", new Object[]{Integer.valueOf(bwi.ssJ), Integer.valueOf(bwi.ssK)});
        if (bwi.rmB == 0) {
            bwi.rmB = i == 4 ? 2 : 1;
        }
        x.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[]{Integer.valueOf(OT.source), Integer.valueOf(bwi.rmB)});
        if (OT.offset == 0) {
            this.dVj = new h(s$l.AppCompatTheme_spinnerStyle, true, (long) OT.dHI);
        }
        long currentTimeMillis = System.currentTimeMillis();
        hV(i2);
        x.d(this.TAG, "hy: create HDThumb using %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (fVar != null) {
            ah.A(new 2(this, fVar, OT.offset, OT.dHI));
        }
    }

    public l(long j, String str, String str2, String str3, int i, f fVar, int i2, String str4, String str5, int i3) {
        e OT;
        String str6;
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.dVA = "";
        this.dVB = "";
        this.dVC = true;
        this.dVE = 16384;
        this.dTO = 0;
        this.bGS = null;
        this.dVj = null;
        this.dVk = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.dVl = 0;
        this.dVF = new b(this, null);
        this.dVu = new 4(this);
        this.dlV = false;
        x.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", new Object[]{Long.valueOf(j), Integer.valueOf(3), str, str2, str3, Integer.valueOf(i), fVar, Integer.valueOf(i2), str4, str5, Boolean.valueOf(true), Integer.valueOf(i3), Boolean.valueOf(true), bi.cjd()});
        this.dVH = true;
        this.dVo = i3;
        this.dVg = fVar;
        this.dTO = i;
        this.dlO = 3;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.dVG = str4;
        this.dVh = j;
        this.dlN = this.dVh;
        e OU = OU();
        this.bGS = ((i) g.l(i.class)).bcY().dW(OU.dTS);
        this.dTS = this.bGS.field_msgId;
        pInt2.value = this.bGS.cGD;
        pInt.value = this.bGS.cGC;
        if (i == 1) {
            this.dlN = (long) OU.dTU;
            this.dlP = null;
            OT = OT();
        } else {
            OT = OU;
        }
        if (this.bGS.field_talker.equals(str2)) {
            str6 = str2;
        } else {
            x.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", new Object[]{str2, this.bGS.field_talker});
            com.tencent.mm.plugin.report.service.h.mEJ.a(594, 4, 1, true);
            str6 = this.bGS.field_talker;
        }
        x.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.bGS.field_msgId);
        x.d(this.TAG, "FROM A UI :" + str2 + "   msg:" + str6 + this.dVh);
        if (this.dVh < 0 || !i.hS((int) this.dVh)) {
            x.e(this.TAG, "insert to img storage failed id:" + this.dVh);
            this.dTS = -1;
            this.diG = null;
            return;
        }
        Assert.assertTrue(this.dVh >= 0);
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bwi();
        aVar.dIH = new bwj();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.dIF = s$l.AppCompatTheme_spinnerStyle;
        aVar.dII = 9;
        aVar.dIJ = 1000000009;
        this.diG = aVar.KT();
        x.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.dlN + " img len = " + OT.dHI);
        bwi bwi = (bwi) this.diG.dID.dIL;
        bwi.rcj = new bhz().VO(str);
        bwi.rck = new bhz().VO(str6);
        bwi.rdW = OT.offset;
        bwi.rdV = OT.dHI;
        bwi.jQd = this.bGS.getType();
        bwi.rJr = i;
        bwi.rth = ab.bU(ad.getContext()) ? 1 : 2;
        bwi.soa = OT.source;
        bwi.rmB = OT.dTP;
        bwi.ssJ = pInt2.value;
        bwi.ssK = pInt.value;
        x.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", new Object[]{Integer.valueOf(bwi.ssJ), Integer.valueOf(bwi.ssK)});
        if (bwi.rmB == 0) {
            bwi.rmB = 1;
        }
        x.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[]{Integer.valueOf(OT.source), Integer.valueOf(bwi.rmB)});
        if (OT.offset == 0) {
            this.dVj = new h(s$l.AppCompatTheme_spinnerStyle, true, (long) OT.dHI);
        }
        if (fVar != null) {
            ah.A(new 3(this, fVar, OT.offset, OT.dHI));
        }
    }

    public final void hV(int i) {
        int i2 = 0;
        if (this.bGS == null) {
            x.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", new Object[]{Long.valueOf(this.dTS), Integer.valueOf(i)});
        } else if (!this.dVH) {
            o.Pf().a(this.bGS.field_imgPath, com.tencent.mm.bp.a.getDensity(ad.getContext()), true);
        } else if (this.bGS.cGG == 0) {
            boolean z;
            g Pf = o.Pf();
            bd bdVar = this.bGS;
            int i3 = this.dVo;
            String s = g.s(bdVar);
            if (bi.oW(s)) {
                z = false;
            } else {
                z = Pf.a(s, bdVar.field_imgPath, i3, i, 0, 0);
            }
            bd bdVar2 = this.bGS;
            if (z) {
                i2 = 1;
            }
            bdVar2.cGG = i2;
            bdVar2.cpN = true;
            ((i) g.l(i.class)).bcY().a(this.dTS, this.bGS);
        }
    }

    public l(int i, int i2) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.dVA = "";
        this.dVB = "";
        this.dVC = true;
        this.dVE = 16384;
        this.dTO = 0;
        this.bGS = null;
        this.dVj = null;
        this.dVk = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.dVl = 0;
        this.dVF = new b(this, null);
        this.dVu = new 4(this);
        this.dlV = false;
        x.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), bi.cjd()});
        this.dVh = (long) i;
        this.dlN = (long) i;
        this.dTO = i2;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bwi();
        aVar.dIH = new bwj();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.dIF = s$l.AppCompatTheme_spinnerStyle;
        aVar.dII = 9;
        aVar.dIJ = 1000000009;
        this.diG = aVar.KT();
        this.dVg = null;
        x.d(this.TAG, "FROM B SERVICE:" + this.dVh);
        if (i.hS((int) this.dVh)) {
            e b;
            e b2 = o.Pf().b(Long.valueOf(this.dVh));
            this.dTS = b2.dTS;
            if (i2 == 1) {
                this.dlN = (long) b2.dTU;
                b = o.Pf().b(Long.valueOf(this.dlN));
            } else {
                b = b2;
            }
            b2 = o.Pf().hR((int) b.dTK);
            if (b2 != null) {
                this.dTS = b2.dTS;
            }
            this.bGS = ((i) g.l(i.class)).bcY().dW(this.dTS);
            if (this.bGS != null && this.bGS.field_msgId != this.dTS) {
                x.w(this.TAG, "init get msg by id failed:%d", new Object[]{Long.valueOf(this.dTS)});
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 206, 1, false);
                this.bGS = null;
                return;
            } else if (this.bGS != null) {
                bwi bwi = (bwi) this.diG.dID.dIL;
                bwi.rcj = new bhz().VO(q.GF());
                bwi.rck = new bhz().VO(this.bGS.field_talker);
                bwi.rdW = b.offset;
                bwi.rdV = b.dHI;
                bwi.jQd = this.bGS.getType();
                bwi.rJr = i2;
                bwi.rth = ab.bU(ad.getContext()) ? 1 : 2;
                bwi.soa = b.source;
                bwi.rmB = b.dTP;
                bwi.rmB = b.dTP;
                bwi.ssJ = this.bGS.cGD;
                bwi.ssK = this.bGS.cGC;
                a lL = f.lL(this.bGS.field_content);
                if (!(lL == null || bi.oW(lL.appId))) {
                    bwi.jQb = lL.appId;
                    bwi.raM = lL.mediaTagName;
                    bwi.raO = lL.messageAction;
                    bwi.raN = lL.messageExt;
                    this.dVG = this.bGS.field_content;
                }
                x.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", new Object[]{Integer.valueOf(bwi.ssJ), Integer.valueOf(bwi.ssK)});
                x.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[]{Integer.valueOf(b.source), Integer.valueOf(bwi.rmB)});
                if (b.offset == 0) {
                    this.dVj = new h(s$l.AppCompatTheme_spinnerStyle, true, (long) b.dHI);
                    return;
                }
                return;
            } else {
                return;
            }
        }
        this.dVh = -1;
    }

    public l(int i, int i2, byte b) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.dVA = "";
        this.dVB = "";
        this.dVC = true;
        this.dVE = 16384;
        this.dTO = 0;
        this.bGS = null;
        this.dVj = null;
        this.dVk = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.dVl = 0;
        this.dVF = new b(this, null);
        this.dVu = new 4(this);
        this.dlV = false;
        x.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), null, bi.cjd()});
        this.dVh = (long) i;
        this.dlN = (long) i;
        this.dTO = i2;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new bwi();
        aVar.dIH = new bwj();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.dIF = s$l.AppCompatTheme_spinnerStyle;
        aVar.dII = 9;
        aVar.dIJ = 1000000009;
        this.diG = aVar.KT();
        this.dVg = null;
        x.d(this.TAG, "FROM C SERVICE:" + this.dVh);
        if (i.hS((int) this.dVh)) {
            e b2;
            e b3 = o.Pf().b(Long.valueOf(this.dVh));
            this.dTS = b3.dTS;
            b3.setStatus(0);
            b3.ax(0);
            b3.setOffset(0);
            o.Pf().a((int) this.dlN, b3);
            if (i2 == 1) {
                this.dlN = (long) b3.dTU;
                b2 = o.Pf().b(Long.valueOf(this.dlN));
            } else {
                b2 = b3;
            }
            this.bGS = ((i) g.l(i.class)).bcY().dW(this.dTS);
            if (this.bGS != null) {
                this.bGS.setStatus(1);
                String str = b2.dTN;
                if (str == null || !str.startsWith("THUMBNAIL_DIRPATH://")) {
                    this.bGS.eq("THUMBNAIL://" + b2.dTK);
                } else {
                    this.bGS.eq(str);
                }
                ((i) g.l(i.class)).bcY().a(this.dTS, this.bGS);
                bwi bwi = (bwi) this.diG.dID.dIL;
                bwi.rcj = new bhz().VO(q.GF());
                bwi.rck = new bhz().VO(this.bGS.field_talker);
                bwi.rdW = b2.offset;
                bwi.rdV = b2.dHI;
                bwi.jQd = this.bGS.getType();
                bwi.rJr = i2;
                bwi.rth = ab.bU(ad.getContext()) ? 1 : 2;
                bwi.soa = b2.source;
                bwi.rmB = b2.dTP;
                bwi.ssJ = this.bGS.cGD;
                bwi.ssK = this.bGS.cGC;
                x.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", new Object[]{Integer.valueOf(bwi.ssJ), Integer.valueOf(bwi.ssK)});
                x.d(this.TAG, "dkimgsource: %d, forwardtype:%d", new Object[]{Integer.valueOf(b2.source), Integer.valueOf(bwi.rmB)});
                if (b2.offset == 0) {
                    this.dVj = new h(s$l.AppCompatTheme_spinnerStyle, true, (long) b2.dHI);
                    return;
                }
                return;
            }
            return;
        }
        this.dVh = -1;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return com.tencent.mm.ab.l.b.dJm;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        g.Ek();
        g.Em().h(new Runnable() {
            public final void run() {
                ((i) g.l(i.class)).bcY().GA("SendImgSpeeder");
            }
        }, 100);
        if (this.dlN < 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(111, 204, 1, false);
            x.e(this.TAG, "doScene invalid imgLocalId:" + this.dlN);
            return hW(-1);
        } else if (this.bGS == null) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(111, 203, 1, false);
            x.e(this.TAG, "doScene msg is null imgid:%d", new Object[]{Long.valueOf(this.dlN)});
            i.hU((int) this.dVh);
            return hW(-2);
        } else {
            String Ir;
            this.diJ = eVar2;
            c(eVar);
            bwi bwi = (bwi) this.diG.dID.dIL;
            e OT = OT();
            e hR = o.Pf().hR((int) OT.dTK);
            if (hR != null) {
                if (hR.status == -1) {
                    com.tencent.mm.plugin.report.service.h.mEJ.a(111, 202, 1, false);
                    x.e(this.TAG, "doScene hd img info is null or error.");
                    return hW(-3);
                }
            } else if (OT == null || OT.status == -1) {
                x.e(this.TAG, "doScene img info is null or error.");
                return hW(-4);
            }
            if (com.tencent.mm.j.a.a.yw().eZ(this.bGS.field_talker)) {
                bwi.rco = com.tencent.mm.j.a.a.yw().d(this.bGS);
            } else {
                Ir = bf.Ir();
                if (!(Ir == null || Ir.equals(this.bGS.cqb)) || (Ir == null && !bi.oW(this.bGS.cqb))) {
                    this.bGS.dt(Ir);
                    ((i) g.l(i.class)).bcY().a(this.bGS.field_msgId, this.bGS);
                }
                bwi.rco = this.bGS.cqb;
            }
            String o = o.Pf().o(OT.dTL, "", "");
            String o2 = o.Pf().o(OT.dTN, "", "");
            Ir = "";
            if (!bi.oW(OT.dTM)) {
                Ir = o.Pf().o(OT.dTM, "", "");
            }
            if (com.tencent.mm.a.e.cm(o) <= 0 || com.tencent.mm.a.e.cm(o2) <= 0) {
                x.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", new Object[]{Long.valueOf(this.dlN), Integer.valueOf(com.tencent.mm.a.e.cm(o)), Integer.valueOf(com.tencent.mm.a.e.cm(o2)), o, o2});
                return hW(-5);
            }
            Object obj;
            if (bwi.ssC == null || bi.oW(bwi.ssC.siM)) {
                if (bi.oW(this.dVk)) {
                    x.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", new Object[]{Long.valueOf(this.bGS.field_createTime), this.bGS.field_talker, Long.valueOf(this.bGS.field_msgId), Long.valueOf(this.dlN), Integer.valueOf(this.dTO)});
                    this.dVk = d.a("upimg", this.bGS.field_createTime, this.bGS.field_talker, this.bGS.field_msgId + "_" + this.dlN + "_" + this.dTO);
                }
                bwi.ssC = new bhz().VO(this.dVk);
                bd bdVar = this.bGS;
                bdVar.cGI = this.dVk;
                bdVar.cpN = true;
            }
            if (this.startTime == 0) {
                this.startTime = bi.VF();
                this.startOffset = OT.offset;
                this.dVl = this.dTO == 1 ? com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE : com.tencent.mm.modelcdntran.b.MediaType_IMAGE;
            }
            x.i(this.TAG, "before checkUseCdn %s, %s, imgBitPath:%s", new Object[]{o, o2, OT.dTL});
            if (s.hP(this.bGS.field_talker)) {
                x.w(this.TAG, "cdntra not use cdn user:%s", new Object[]{this.bGS.field_talker});
                obj = null;
            } else {
                com.tencent.mm.modelcdntran.g.ND();
                if (!c.hz(1) && bi.oW(OT.dTV)) {
                    r7 = new Object[2];
                    com.tencent.mm.modelcdntran.g.ND();
                    r7[0] = Boolean.valueOf(c.hz(1));
                    r7[1] = OT.dTV;
                    x.w(this.TAG, "cdntra not use cdn flag:%b getCdnInfo:%s", r7);
                    obj = null;
                } else if (bi.oW(this.dVk)) {
                    x.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", new Object[]{Long.valueOf(this.dlN)});
                    obj = null;
                } else {
                    com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
                    iVar.dPV = this.dVu;
                    iVar.field_mediaId = this.dVk;
                    iVar.field_fullpath = o;
                    iVar.field_thumbpath = o2;
                    iVar.field_fileType = this.dVl;
                    iVar.field_talker = this.bGS.field_talker;
                    iVar.field_chattype = s.fq(this.bGS.field_talker) ? 1 : 0;
                    iVar.field_priority = com.tencent.mm.modelcdntran.b.dOk;
                    iVar.field_needStorage = false;
                    iVar.field_isStreamMedia = false;
                    iVar.field_sendmsg_viacdn = true;
                    iVar.field_enable_hitcheck = this.dVC;
                    iVar.field_midimgpath = Ir;
                    iVar.field_force_aeskeycdn = false;
                    iVar.field_trysafecdn = true;
                    if (iVar.field_fileType == com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE && bi.oW(iVar.field_midimgpath)) {
                        com.tencent.mm.modelcdntran.g.ND();
                        if (c.hz(256)) {
                            x.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
                            iVar.field_force_aeskeycdn = true;
                            iVar.field_trysafecdn = false;
                        }
                    }
                    Map z = bl.z(this.dVG, "msg");
                    if (z != null) {
                        if (this.dTO != 1) {
                            iVar.field_fileId = (String) z.get(".msg.img.$cdnmidimgurl");
                            iVar.field_midFileLength = bi.getInt((String) z.get(".msg.img.$length"), 0);
                            iVar.field_totalLen = 0;
                        } else {
                            iVar.field_fileId = (String) z.get(".msg.img.$cdnbigimgurl");
                            iVar.field_midFileLength = bi.getInt((String) z.get(".msg.img.$length"), 0);
                            iVar.field_totalLen = 0;
                        }
                        iVar.field_aesKey = (String) z.get(".msg.img.$aeskey");
                    } else {
                        x.i(this.TAG, "parse cdnInfo failed. [%s]", new Object[]{OT.dTV});
                    }
                    if (bi.oW(iVar.field_aesKey)) {
                        com.tencent.mm.modelcdntran.g.NE();
                        iVar.field_aesKey = com.tencent.mm.modelcdntran.b.Nw();
                        x.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", new Object[]{iVar.field_aesKey});
                    }
                    x.i(this.TAG, "dkupimg src:%d fileid:%s", new Object[]{Integer.valueOf(OT.source), iVar.field_fileId});
                    this.dVA = iVar.field_fileId;
                    this.dVB = iVar.field_aesKey;
                    x.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", new Object[]{Boolean.valueOf(iVar.field_enable_hitcheck), Integer.valueOf(iVar.field_fileType), iVar.field_midimgpath, iVar.field_fullpath, iVar.field_aesKey, iVar.field_fileId, Boolean.valueOf(iVar.field_enable_hitcheck), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn)});
                    this.dVK = null;
                    if (com.tencent.mm.modelcdntran.g.ND().c(iVar)) {
                        if (bi.oV(OT.dTV).length() <= 0) {
                            OT.lK("CDNINFO_SEND");
                            OT.bWA = 4096;
                        }
                        obj = 1;
                    } else {
                        com.tencent.mm.plugin.report.service.h.mEJ.a(111, 205, 1, false);
                        x.e(this.TAG, "cdntra addSendTask failed. clientid:%s", new Object[]{this.dVk});
                        this.dVk = "";
                        obj = null;
                    }
                }
            }
            if (obj != null) {
                x.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", new Object[]{bwi.ssC.siM});
                return 0;
            }
            x.i(this.TAG, "after checkUseCdn, it use cgi to upload image.");
            int i = OT.dTT;
            if (i >= Cc()) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 201, 1, false);
                x.e(this.TAG, "doScene limit net time:" + i);
                i.hU((int) this.dVh);
                return hW(-6);
            }
            OT.hJ(i + 1);
            OT.bWA = 512;
            o.Pf().a(Long.valueOf(this.dlN), OT);
            int i2 = OT.dHI - OT.offset;
            if (i2 > this.dVE) {
                i2 = this.dVE;
            }
            if (com.tencent.mm.a.e.cm(o) > 10485760) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 200, 1, false);
                x.e(this.TAG, "doScene, file size is too large");
                return hW(-7);
            }
            byte[] e = com.tencent.mm.a.e.e(o, OT.offset, i2);
            if (e == null || e.length <= 0) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 199, 1, false);
                x.e(this.TAG, "doScene, file read buf error.");
                return hW(-8);
            }
            bwi.rdX = e.length;
            bwi.rdW = OT.offset;
            bwi.rtW = new bhy().bq(e);
            if (this.dVj != null) {
                this.dVj.Sa();
            }
            int a = a(eVar, this.diG, this);
            if (a >= 0) {
                return a;
            }
            x.e(this.TAG, "doScene netId error");
            i.hU((int) this.dVh);
            return hW(-9);
        }
    }

    private int hW(int i) {
        x.e(this.TAG, "do Scene error code : " + i + " hashcode : " + hashCode());
        if (this.dVF != null) {
            this.dVF.OS();
        }
        return -1;
    }

    public final int getType() {
        return s$l.AppCompatTheme_spinnerStyle;
    }

    protected final int Cc() {
        if (this.dTO == 0) {
            return 100;
        }
        return 1350;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        bwj bwj = (bwj) ((b) qVar).dIE.dIL;
        x.i(this.TAG, "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.dVk);
        if (i2 == 3 && i3 == -1 && !bi.oW(this.dVk)) {
            x.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[]{this.dVk});
        } else if (i2 == 0 && i3 == 0) {
            this.dVE = bwj.rdX;
            if (this.dVE > 16384) {
                this.dVE = 16384;
            }
            e OT = OT();
            x.v(this.TAG, "onGYNetEnd localId:" + this.dlN + "  totalLen:" + OT.dHI + " offSet:" + OT.offset);
            if (bwj.rdW < 0 || (bwj.rdW > OT.dHI && OT.dHI > 0)) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(111, 197, 1, false);
                x.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + bwj.rdW + " img totalLen = " + OT.dHI);
                i.hU((int) this.dVh);
                i.hT((int) this.dVh);
                com.tencent.mm.plugin.report.service.h.mEJ.h(10420, new Object[]{Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.dVl), Integer.valueOf(0)});
                this.diJ.a(4, -2, "", this);
                if (this.dVF != null) {
                    this.dVF.OS();
                }
            } else if (bwj.rdW < OT.offset || (f.b(OT) && this.dVE <= 0)) {
                x.e(this.TAG, "onGYNetEnd invalid data startPos = " + bwj.rdW + " totalLen = " + OT.dHI + " off:" + OT.offset);
                i.hU((int) this.dVh);
                i.hT((int) this.dVh);
                this.diJ.a(4, -1, "", this);
                if (this.dVF != null) {
                    this.dVF.OS();
                }
            } else {
                x.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + bwj.rdW);
                if (a(OT, bwj.rdW, bwj.rcq, bwj.lOH, null) && a(this.dIX, this.diJ) < 0) {
                    i.hT((int) this.dVh);
                    this.diJ.a(3, -1, "", this);
                    if (this.dVF != null) {
                        this.dVF.OS();
                    }
                }
            }
        } else {
            x.e(this.TAG, "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
            com.tencent.mm.plugin.report.service.h.mEJ.a(111, 198, 1, false);
            i.hU((int) this.dVh);
            i.hT((int) this.dVh);
            com.tencent.mm.plugin.report.service.h.mEJ.h(10420, new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.dVl), Integer.valueOf(0)});
            this.diJ.a(i2, i3, str, this);
            if (this.dVF != null) {
                this.dVF.OS();
            }
        }
    }

    public final void OV() {
        x.i(this.TAG, "send img from system");
        this.dlV = true;
    }

    private boolean a(e eVar, int i, long j, int i2, keep_SceneResult keep_sceneresult) {
        x.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", new Object[]{this.dVk, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)});
        x.d(this.TAG, "dkmsgid  set svrmsgid %d -> %d", new Object[]{Long.valueOf(j), Integer.valueOf(af.exn)});
        if (10007 == af.exm && af.exn != 0) {
            j = (long) af.exn;
            af.exn = 0;
        }
        final long j2 = eVar.dTK;
        final int i3 = eVar.dHI;
        if (this.dVg != null) {
            final int i4 = i;
            ah.A(new Runnable() {
                public final void run() {
                    n OW = n.OW();
                    long j = j2;
                    long j2 = (long) i3;
                    long j3 = (long) i4;
                    n.d dVar = OW.dVT.containsKey(Long.valueOf(j)) ? (n.d) OW.dVT.get(Long.valueOf(j)) : new n.d();
                    dVar.mb = j3;
                    dVar.bSQ = j2;
                    OW.dVT.put(Long.valueOf(j), dVar);
                    l.this.dVg.a(i4, i3, l.this);
                }
            });
        }
        eVar.setOffset(i);
        eVar.ax(j);
        if (f.b(eVar) && this.dVh != this.dlN) {
            e b = o.Pf().b(Long.valueOf(this.dVh));
            b.ax(j);
            b.hL(eVar.dHI);
            b.setOffset(eVar.dHI);
            o.Pf().a(Long.valueOf(this.dVh), b);
        }
        if (!f.b(eVar)) {
            return true;
        }
        if (bi.oW(this.dVk)) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(10420, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(this.dVl), Integer.valueOf(eVar.dHI - this.startOffset)});
        }
        this.bGS.setStatus(2);
        this.bGS.ax(j);
        ((i) g.l(i.class)).bcY().a(this.dTS, this.bGS);
        if (r.eld != null) {
            r.eld.f(this.bGS);
        }
        i.hT((int) this.dVh);
        if (this.dVj != null) {
            this.dVj.bz(0);
        }
        this.diJ.a(0, 0, "", this);
        if (r.dWN != null) {
            r.dWN.a(this.dlN, this.bGS, this.diG, this.dlO, this.dlV, keep_sceneresult);
        }
        if (this.dVF != null) {
            this.dVF.OS();
        }
        return false;
    }

    public static void bs(long j) {
        dVL = j;
    }

    public static String lO(String str) {
        try {
            if (bi.oW(str)) {
                return str;
            }
            String[] split = str.split(",");
            if (split == null || split.length <= 19) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            long j = dVL;
            dVL = -1;
            split[19] = stringBuilder.append(j).toString();
            return bi.c(bi.F(split), ",");
        } catch (Exception e) {
            return str;
        }
    }
}
