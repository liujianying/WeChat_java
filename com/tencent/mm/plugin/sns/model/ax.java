package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpi;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.protocal.c.brh;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.cfn;
import com.tencent.mm.protocal.c.ct;
import com.tencent.mm.protocal.c.dc;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class ax {
    private static final Pattern eXS = Pattern.compile("(\n){3,}");
    public int afv;
    private String cXR;
    public aso caX;
    int nkX;
    int nkY;
    boy nsA = null;
    av nsB;
    public brh nsC;
    public cfn nsD;
    private boolean nsE;
    List<h> nss;
    String nst;
    String nsu;
    LinkedList<bqg> nsv;
    LinkedList<Long> nsw;
    public bsu nsx = e.RF();
    public atf nsy = new atf();
    n nsz = new n();

    public ax(int i) {
        av avVar = new av();
        avVar.raS = new at();
        avVar.raU = new ct();
        avVar.raV = new de();
        this.nsB = avVar;
        this.nsC = new brh();
        this.caX = new aso();
        this.nsD = null;
        this.cXR = "";
        this.nsE = false;
        this.cXR = af.bxU();
        this.afv = i;
        this.nsx.sqc.ruz = i;
        x.d("MicroMsg.UploadPackHelper", "contentType " + i);
        this.nsx.rVG = 0;
        this.nsx.hbL = this.cXR;
        this.nsy.rcc = g.u((af.bxU() + bi.VG() + System.currentTimeMillis()).getBytes());
        this.nsy.rWa = 0;
        this.nsy.rWb = 0;
        this.nsy.rVG = 0;
        this.nsy.rWe = 0;
        this.nsy.dHg = 0;
        this.nsy.rWg = 0;
        this.nsy.rWi = 0;
        boy boy = new boy();
        boy.rlK = 0;
        boy.lOH = 0;
        boy.smI = 0;
        boy.rdS = af.bxU();
        boy.smL = new LinkedList();
        boy.smJ = 0;
        boy.smK = 0;
        boy.smR = new LinkedList();
        boy.smP = 0;
        boy.smQ = 0;
        boy.smO = new LinkedList();
        boy.smM = 0;
        boy.smN = 0;
        boy.rXx = 1;
        boy.smI = 0;
        boy.smS = 0;
        boy.smH = new bhy().bq(new byte[0]);
        this.nsA = boy;
        n nVar = this.nsz;
        nVar.field_localFlag |= 16;
        this.nsz.hK((int) (System.currentTimeMillis() / 1000));
        this.nsz.field_type = i;
        this.nsz.field_userName = this.cXR;
        this.nsz.field_pravited = 0;
        this.nsz.field_stringSeq = "0000099999999999999999999";
        this.nsz.wZ(2);
        this.nsz.bBb();
        if (i == 1 || i == 2) {
            this.nsz.wZ(4);
        }
        if (i == 7) {
            this.nsz.xc(2);
        }
        this.nsw = new LinkedList();
        this.nsy.rWh = this.nsw;
        Iterator it = this.nsw.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            bot bot = new bot();
            bot.smF = longValue;
            this.nsA.rcM.add(bot);
        }
        this.nsA.rYP = this.nsw.size();
    }

    private static String Mx(String str) {
        String str2;
        if (str == null) {
            try {
                str2 = "";
            } catch (Exception e) {
                str2 = str;
                x.e("MicroMsg.UploadPackHelper", "filter desc error ");
                return str2;
            }
        }
        str2 = str;
        try {
            return eXS.matcher(str2.trim().replace("\r\n", "\n")).replaceAll("\n\n");
        } catch (Exception e2) {
        }
    }

    public final ax My(String str) {
        this.nst = Mx(str);
        this.nsx.spZ = this.nst;
        return this;
    }

    public final ax eB(String str, String str2) {
        this.nsy.token = str;
        this.nsy.rWk = str2;
        return this;
    }

    public final ax wC(int i) {
        this.nsx.sqe = 1;
        this.nsx.sqf = i;
        return this;
    }

    public final ax Mz(String str) {
        this.nsx.sqg = str;
        this.nsB.raS.raM = str;
        return this;
    }

    public final ax MA(String str) {
        this.nsx.ogR = str;
        return this;
    }

    public final ax aa(String str, String str2, String str3) {
        at atVar = this.nsB.raS;
        if (bi.oW(str)) {
            str = "";
        }
        atVar.jQb = str;
        atVar = this.nsB.raS;
        if (bi.oW(str2)) {
            str2 = "";
        }
        atVar.raN = str2;
        atVar = this.nsB.raS;
        if (bi.oW(str3)) {
            str3 = "";
        }
        atVar.raO = str3;
        return this;
    }

    public final ax MB(String str) {
        this.nsu = str;
        this.nsx.sqc.jOS = str;
        return this;
    }

    public final ax MC(String str) {
        this.nsx.sqc.jPK = str;
        return this;
    }

    public final ax MD(String str) {
        this.nsx.sqc.bHD = str;
        return this;
    }

    public final void wD(int i) {
        x.d("MicroMsg.UploadPackHelper", "set post form " + i);
        this.nsy.rWg = i;
    }

    public final ax a(arj arj) {
        if (arj != null) {
            this.nsx.sqa = arj;
        }
        return this;
    }

    public final ax wE(int i) {
        this.nkY = i;
        this.nsy.rVG = i;
        this.nsx.rVG = i;
        if (i > 0) {
            this.nsz.field_pravited = i;
            this.nsz.bAY();
            this.nsz.xc(2);
            this.nsz.bBc();
        }
        return this;
    }

    public final ax wF(int i) {
        this.nkX = i;
        this.nsy.rWb = i;
        return this;
    }

    public final ax ag(LinkedList<bqg> linkedList) {
        this.nsv = linkedList;
        this.nsy.rWd = linkedList;
        Iterator it = this.nsv.iterator();
        while (it.hasNext()) {
            bqg bqg = (bqg) it.next();
            bon bon = new bon();
            bon.rdS = bqg.hbL;
            this.nsA.smR.add(bon);
        }
        this.nsA.smP = this.nsv.size();
        this.nsA.smQ = this.nsv.size();
        return this;
    }

    public final ax wG(int i) {
        this.nsy.rWi = i;
        return this;
    }

    public final ax ME(String str) {
        dc dcVar = this.nsx.sqb;
        if (dcVar == null) {
            dcVar = new dc();
        }
        dcVar.ksA = str;
        this.nsx.sqb = dcVar;
        return this;
    }

    public final ax MF(String str) {
        dc dcVar = this.nsx.sqb;
        if (dcVar == null) {
            dcVar = new dc();
        }
        dcVar.jSv = str;
        this.nsx.sqb = dcVar;
        return this;
    }

    public final ax MG(String str) {
        this.nsx.qIb = bi.oV(str);
        return this;
    }

    public final ax MH(String str) {
        this.nsx.qIc = bi.oV(str);
        return this;
    }

    public final ax ci(List<String> list) {
        if (list == null || list.size() == 0) {
            this.nsA.rXx = 1;
        } else {
            LinkedList linkedList = new LinkedList();
            for (String str : list) {
                bhz bhz = new bhz();
                bhz.VO(str);
                linkedList.add(bhz);
            }
            this.nsy.rWm = linkedList;
            if (this.nsA.rXx == 3) {
                this.nsA.smW = linkedList;
                this.nsA.smV = linkedList.size();
            } else if (this.nsA.rXx == 5) {
                this.nsA.rWm = linkedList;
                this.nsA.smX = linkedList.size();
            }
        }
        return this;
    }

    public final ax wH(int i) {
        if (i == 1) {
            this.nsA.rXx = 3;
        } else if (i == 0) {
            this.nsA.rXx = 5;
        }
        this.nsy.rWl = i;
        return this;
    }

    private static ate s(String str, byte[] bArr) {
        if (bi.bC(bArr)) {
            x.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.Ac() + " attachBuf is null");
            return null;
        }
        String str2 = af.getAccSnsTmpPath() + g.u((" " + System.currentTimeMillis()).getBytes());
        FileOp.mL(af.getAccSnsTmpPath());
        x.d("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.Ac() + " buildUploadAttachInfo file:" + str2);
        if (FileOp.b(str2, bArr, bArr.length) >= 0) {
            return eC(str, str2);
        }
        x.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.Ac() + " writeFile error file:" + str2);
        return null;
    }

    public static ate c(String str, String str2, String str3, String str4, String str5, String str6) {
        ate RG = e.RG();
        RG.ksA = str;
        x.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s,cdnUrl %s,cdnThumbUrl %s", new Object[]{Integer.valueOf(6), str2, str4, str5, str6});
        RG.hcE = 6;
        if (FileOp.mI(str2) <= 0) {
            return null;
        }
        atg atg;
        h hVar = new h(str2, 6);
        hVar.nlc = str4;
        hVar = af.byd().a(hVar, str2, str3, str5, str6);
        if (hVar.height <= 0 || hVar.width <= 0 || hVar.fileSize <= 0) {
            atg = null;
        } else {
            atg = new atg();
            atg.rWv = (float) hVar.height;
            atg.rWu = (float) hVar.width;
            atg.rWw = (float) hVar.fileSize;
        }
        RG.ksA = "Locall_path" + hVar.nkZ;
        RG.rVH = atg;
        RG.nkZ = hVar.nkZ;
        return RG;
    }

    private static ate eC(String str, String str2) {
        atg atg = null;
        ate RG = e.RG();
        RG.ksA = str;
        x.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
        RG.hcE = 2;
        if (FileOp.mI(str2) <= 0) {
            return null;
        }
        String str3 = af.getAccSnsTmpPath() + g.u((str2 + System.currentTimeMillis()).getBytes());
        FileOp.y(str2, str3);
        h hVar = new h(str3, 2);
        List linkedList = new LinkedList();
        linkedList.add(hVar);
        linkedList = af.byd().cn(linkedList);
        if (linkedList == null || linkedList.size() == 0) {
            return null;
        }
        h hVar2 = (h) linkedList.get(0);
        if (hVar2.height > 0 && hVar2.width > 0 && hVar2.fileSize > 0) {
            atg = new atg();
            atg.rWv = (float) hVar2.height;
            atg.rWu = (float) hVar2.width;
            atg.rWw = (float) hVar2.fileSize;
        }
        RG.ksA = "Locall_path" + hVar2.nkZ;
        RG.rVH = atg;
        RG.nkZ = hVar2.nkZ;
        return RG;
    }

    public static ate ab(String str, String str2, String str3) {
        ate RG = e.RG();
        RG.ksA = str;
        x.d("MicroMsg.UploadPackHelper", "mediaOBj type 2");
        RG.hcE = 2;
        RG.jPK = str2;
        RG.rVD = 0;
        RG.rVE = str3;
        RG.rVF = 0;
        RG.rVK = 1;
        return RG;
    }

    public final boolean o(String str, String str2, String str3, String str4) {
        String str5 = af.getAccSnsTmpPath() + g.u(str.getBytes());
        MI(str5);
        FileOp.y(str, str5);
        String str6 = af.getAccSnsTmpPath() + g.u(str2.getBytes());
        FileOp.y(str2, str6);
        ate c = c("", str5, str6, str4, "", "");
        if (c == null) {
            x.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            return false;
        }
        c.jOS = str3;
        if (bi.oW(c.bHD)) {
            c.bHD = str3;
        }
        this.nsx.sqc.ruA.add(c);
        ari ari = new ari();
        ari.rTF = c.nkZ;
        this.nsy.rWc.add(ari);
        return true;
    }

    public static void MI(String str) {
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }

    public final boolean eD(String str, String str2) {
        String str3 = af.getAccSnsTmpPath() + g.u(str.getBytes());
        MI(str3);
        FileOp.y(str, str3);
        ate eC = eC("", str3);
        if (eC == null) {
            x.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            return false;
        }
        eC.jOS = str2;
        if (bi.oW(eC.bHD)) {
            eC.bHD = str2;
        }
        this.nsx.sqc.ruA.add(eC);
        ari ari = new ari();
        ari.rTF = eC.nkZ;
        this.nsy.rWc.add(ari);
        return true;
    }

    @Deprecated
    public final boolean b(String str, String str2, String str3, int i, String str4) {
        ate ab = ab("", str, str2);
        if (ab == null) {
            x.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
            return false;
        }
        ab.jOS = str3;
        if (i > 0) {
            ab.bID = i;
        }
        if (!bi.oW(str4)) {
            ab.nME = str4;
        }
        this.nsx.sqc.ruA.add(ab);
        return true;
    }

    public final boolean b(byte[] bArr, String str, String str2) {
        return a(bArr, str, str2, -1, "");
    }

    public final boolean a(byte[] bArr, String str, String str2, int i, String str3) {
        ate s = s("", bArr);
        if (s == null) {
            x.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
            return false;
        }
        s.jOS = str;
        if (i > 0) {
            s.bID = i;
        }
        if (!bi.oW(str3)) {
            s.nME = str3;
        }
        if (!bi.oW(str2)) {
            s.bHD = str2;
        }
        if (!bi.oW(str)) {
            s.jOS = str;
        }
        this.nsx.sqc.ruA.add(s);
        ari ari = new ari();
        ari.rTF = s.nkZ;
        this.nsy.rWc.add(ari);
        return true;
    }

    public final boolean a(byte[] bArr, String str, String str2, String str3, int i, String str4, String str5) {
        ate s = s("", bArr);
        if (s == null || (bi.oW(str2) && bi.oW(str3))) {
            x.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
            return false;
        }
        if (!bi.oW(str)) {
            this.nsx.sqc.jPK = str;
        }
        if (!bi.oW(str3)) {
            s.jPK = str3;
            s.rVD = 0;
        } else if (!bi.oW(str2)) {
            s.jPK = str2;
            s.rVD = 0;
        }
        if (!bi.oW(str2)) {
            s.rVI = str2;
            s.rVJ = 0;
        }
        s.hcE = i;
        s.bHD = bi.aG(str4, "");
        s.jOS = bi.aG(str5, "");
        this.nsx.sqc.ruA.add(s);
        ari ari = new ari();
        ari.rTF = s.nkZ;
        this.nsy.rWc.add(ari);
        return true;
    }

    public final void cj(List<h> list) {
        this.nss = list;
        List<h> cn = af.byd().cn(this.nss);
        LinkedList linkedList = new LinkedList();
        if (cn != null) {
            for (h hVar : cn) {
                ari ari = new ari();
                ari.rTF = hVar.nkZ;
                linkedList.add(ari);
            }
            this.nsy.rWc = linkedList;
            for (h hVar2 : cn) {
                atg atg = new atg();
                atg.rWv = 0.0f;
                atg.rWu = 0.0f;
                atg.rWw = 0.0f;
                if (hVar2.height > 0 && hVar2.width > 0 && hVar2.fileSize > 0) {
                    atg.rWv = (float) hVar2.height;
                    atg.rWu = (float) hVar2.width;
                    atg.rWw = (float) hVar2.fileSize;
                }
                this.nsx.sqc.ruA.add(e.a("Locall_path" + hVar2.nkZ, hVar2.type, "", "", 0, 0, this.nkY, "", atg));
            }
        }
    }

    public final void f(String str, String str2, String str3, int i, int i2) {
        bpi bpi = new bpi();
        bpi.rds = str;
        bpi.rdt = str2;
        bpi.rdu = str3;
        bpi.nRo = i;
        bpi.nRp = i2;
        this.nsy.rWn = bpi;
    }

    public final void setSessionId(String str) {
        this.nsy.bJK = str;
    }

    public final int commit() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.nsy.rWf = System.currentTimeMillis();
            this.nsy.dHg = 0;
            this.nsz.aK(this.nsA.toByteArray());
            this.nsz.field_postBuf = this.nsy.toByteArray();
            x.d("MicroMsg.UploadPackHelper", "snsObj " + this.nsA.toString());
            x.d("MicroMsg.UploadPackHelper", "postinfo " + this.nsy.toString());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UploadPackHelper", e, "", new Object[0]);
        }
        x.d("MicroMsg.UploadPackHelper", "timelineObj " + this.nsx.toString());
        if (this.nsx.sqc.ruA != null) {
            x.d("MicroMsg.UploadPackHelper", "timelineObj MeidaCount %d ", new Object[]{Integer.valueOf(this.nsx.sqc.ruA.size())});
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.nsx.sqc.ruA.size()) {
                    break;
                }
                if (((ate) this.nsx.sqc.ruA.get(i2)) != null) {
                    x.d("MicroMsg.UploadPackHelper", "timelineObj media %d %s", new Object[]{Integer.valueOf(((ate) this.nsx.sqc.ruA.get(i2)).nkZ), bi.aG(((ate) this.nsx.sqc.ruA.get(i2)).jPK, "")});
                }
                i = i2 + 1;
            }
        }
        if (this.nsB != null) {
            this.nsx.nsB = this.nsB;
        }
        if (this.nsD != null) {
            this.nsx.nsD = this.nsD;
        }
        this.nsz.c(this.nsx);
        int y = af.byo().y(this.nsz);
        Iterator it = this.nsy.rWc.iterator();
        int i3 = 0;
        String str = null;
        while (it.hasNext()) {
            ari ari = (ari) it.next();
            r fj = af.byd().fj((long) ari.rTF);
            try {
                ath ath = (ath) new ath().aG(fj.nJM);
                if (this.nsx.sqb != null) {
                    ath.bPS = this.nsx.sqb.ksA;
                }
                if (this.caX != null) {
                    this.caX.rUQ = 0;
                }
                ath.rWE = this.caX;
                ath.afv = this.nsx.sqc.ruz;
                if (ath.afv == 1 || ath.afv == 15) {
                    int i4;
                    ath ath2;
                    if (!bi.oW(ath.bPS)) {
                        i4 = 5;
                        ath2 = ath;
                    } else if (ath.rWE != null && ath.afv == 15) {
                        if (ath.rWE.rUP) {
                            i4 = 1;
                        } else {
                            i4 = 2;
                        }
                        ath.rWF = i4;
                    } else if (((h) this.nss.get(i3)).nld) {
                        i4 = 1;
                        ath2 = ath;
                    } else {
                        i4 = 2;
                        ath2 = ath;
                    }
                    ath2.rWF = i4;
                }
                fj.nJM = ath.toByteArray();
                af.byd().a(ari.rTF, fj);
                i3++;
                str = ath.bKg;
            } catch (Exception e2) {
                x.e("MicroMsg.UploadPackHelper", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            }
        }
        x.i("MicroMsg.UploadPackHelper", "commit sns info ret %d, typeFlag %d sightMd5 %s", new Object[]{Integer.valueOf(y), Integer.valueOf(this.nsz.field_type), str});
        if (y > 0 && this.nsz.field_type == 15) {
            aq.eA(v.ah("sns_table_", (long) y), str);
        }
        x.d("MicroMsg.UploadPackHelper", "pack commit result " + y + " cost " + (System.currentTimeMillis() - currentTimeMillis));
        return y;
    }
}
