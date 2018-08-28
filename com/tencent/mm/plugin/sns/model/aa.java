package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.protocal.c.bqe;
import com.tencent.mm.protocal.c.bqf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Vector;

public final class aa extends l implements k, d {
    private static Vector<String> noW = new Vector();
    private final int bJt;
    private boolean bNu;
    private b diG;
    public e diJ;
    private boolean nnR;
    private long nnS = 0;
    long nnT = 0;
    public int nnV = 0;
    private long noK = 0;
    private boolean noL = false;
    private boolean noM = false;
    private int noX = 0;
    private boolean noY = false;
    private boolean noZ = false;
    private String not = "";
    public long npa;
    String userName;

    public static synchronized boolean Me(String str) {
        boolean z;
        synchronized (aa.class) {
            if (noW.contains(str)) {
                z = false;
            } else {
                noW.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean Mf(String str) {
        synchronized (aa.class) {
            noW.remove(str);
        }
        return true;
    }

    public aa(String str, long j, boolean z, int i) {
        long j2 = 0;
        boolean z2 = false;
        this.userName = str;
        this.nnS = j;
        this.bNu = z;
        if (j == 0) {
            x.i("MicroMsg.NetSceneSnsUserPage", "fp userName " + str);
        } else {
            x.i("MicroMsg.NetSceneSnsUserPage", "np userName " + str);
        }
        this.bJt = z ? 4 : 8;
        a aVar = new a();
        aVar.dIG = new bqe();
        aVar.dIH = new bqf();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
        aVar.dIF = 212;
        aVar.dII = 99;
        aVar.dIJ = 1000000099;
        this.diG = aVar.KT();
        bqe bqe = (bqe) this.diG.dID.dIL;
        bqe.rdS = str;
        bqe.smv = j;
        if (j == 0) {
            z2 = true;
        }
        this.nnR = z2;
        int Mo = af.bye().Mo(str);
        o byo = af.byo();
        if (!this.nnR) {
            j2 = j;
        }
        this.nnT = byo.a(j2, Mo, str, z);
        bqe.snR = this.nnT;
        int a = c.a(this.nnT, j, str);
        bqe.snS = a;
        bqe.rdq = i;
        if (this.nnR) {
            this.not = af.bys().Np(str).field_md5;
            if (this.not == null) {
                this.not = "";
            }
            bqe.smu = this.not;
        }
        this.noK = j;
        x.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + Mo + " maxId:" + i.eF(j) + " minId:" + i.eF(this.nnT) + " lastReqTime:" + a + " snsSource " + i);
    }

    private void bxL() {
        o byo = af.byo();
        String str = this.userName;
        boolean z = this.bNu;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo ").append(o.aU(str, z)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26) and  (snsId != 0  )  limit 4");
        Cursor rawQuery = byo.diF.rawQuery(stringBuilder.toString(), null);
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count <= 3 && count > 0) {
            this.noM = true;
        } else if (count == 0) {
            this.noL = true;
        }
    }

    private void a(bqf bqf, String str) {
        aj.a(this.userName, this.bJt, bqf.rgH, str);
        if (this.nnS == 0) {
            this.nnS = ((boy) bqf.rgH.getFirst()).rlK;
        } else {
            this.nnS = c.eJ(this.nnS);
        }
        this.nnT = ((boy) bqf.rgH.getLast()).rlK;
        x.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[]{this.userName, Long.valueOf(this.nnS), Long.valueOf(this.nnT), Integer.valueOf(bqf.snV)});
        c.d(this.userName, this.nnS, this.nnT, bqf.snV);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSnsUserPage", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bqf bqf = (bqf) ((b) qVar).dIE.dIL;
        if (qVar.Id().qWB == 207 || qVar.Id().qWB == com.tencent.mm.plugin.appbrand.jsapi.share.b.CTRL_INDEX || qVar.Id().qWB == 0 || qVar.Id().qWB == 2001 || qVar.Id().qWB == 2004 || qVar.Id().qWB == 2003) {
            String str2;
            if (qVar.Id().qWB == 2003) {
                o byo = af.byo();
                str2 = this.userName;
                boolean fV = byo.diF.fV("SnsInfo", "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + bi.oU(str2) + "\"");
                x.d("MicroMsg.SnsInfoStorage", "del snsinfo " + str2 + " res " + fV);
                Boolean.valueOf(fV);
            }
            this.nnV = bqf.smy;
            x.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + bqf.smy + " , objCount:  " + bqf.rXE);
            this.npa = bqf.sof;
            str2 = i.eG(this.nnS);
            if (!this.nnR) {
                x.d("MicroMsg.NetSceneSnsUserPage", "np  " + bqf.rgH.size());
                if (bqf.rgH.isEmpty()) {
                    this.noZ = qVar.Id().qWB == com.tencent.mm.plugin.appbrand.jsapi.share.b.CTRL_INDEX;
                    af.byo().b(this.userName, this.bNu, str2);
                    this.noL = true;
                    this.nnT = this.nnS;
                } else {
                    a(bqf, str2);
                }
                Mf(this.userName);
                this.diJ.a(i2, i3, str, this);
                return;
            } else if (this.not.equals(bqf.smu)) {
                this.nnT = af.byo().a(this.nnR ? 0 : this.noK, this.nnV, this.userName, this.bNu);
                x.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[]{Long.valueOf(this.nnT)});
                bxL();
                Mf(this.userName);
                com.tencent.mm.plugin.sns.storage.l Np = af.bys().Np(this.userName);
                this.diJ.a(Np.field_lastFirstPageRequestErrType, Np.field_lastFirstPageRequestErrCode, str, this);
                return;
            } else {
                String eF;
                String str3;
                x.i("MicroMsg.NetSceneSnsUserPage", "fp  " + bqf.rgH.size());
                if (this.nnR && !this.not.equals(bqf.smu)) {
                    this.noX = bqf.soe;
                    com.tencent.mm.plugin.sns.storage.l Np2 = af.bys().Np(this.userName);
                    Np2.field_icount = this.noX;
                    bqd bqd = bqf.rTk;
                    if (bqd != null) {
                        eF = i.eF(bqd.eJU);
                        String accSnsPath = af.getAccSnsPath();
                        str3 = this.userName + "bg_";
                        String str4 = this.userName + "tbg_";
                        if (Np2.field_bgUrl == null || !Np2.field_bgId.equals(eF)) {
                            Np2.field_older_bgId = Np2.field_bgId;
                            if (FileOp.cn(an.s(accSnsPath, this.userName) + str3)) {
                                FileOp.deleteFile(an.s(accSnsPath, this.userName) + str4);
                                FileOp.i(an.s(accSnsPath, this.userName), str3, str4);
                            }
                            this.noY = true;
                            Np2.bAS();
                            x.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + bqd.eJT);
                        }
                        Np2.field_bgId = eF;
                        Np2.field_bgUrl = bqd.eJT;
                        Np2.field_snsBgId = bqd.eJU;
                    }
                    af.bys().a(Np2);
                }
                af.bys().l(this.userName, bqf.smu, i2, i3);
                if (qVar.Id().qWB == 207 || qVar.Id().qWB == 2001 || qVar.Id().qWB == 2004) {
                    af.bys().eM(this.userName, "");
                    String str5;
                    if (bqf.rgH.isEmpty()) {
                        o byo2 = af.byo();
                        str5 = this.userName;
                        boolean z = this.bNu;
                        byo2.n(z, o.aU(str5, z) + " AND  (snsId != 0  ) ");
                        this.nnT = this.nnS;
                    } else {
                        o byo3 = af.byo();
                        eF = this.userName;
                        boolean z2 = this.bNu;
                        str3 = i.eG(((boy) bqf.rgH.getFirst()).rlK);
                        str5 = o.aU(eF, z2) + " AND  (snsId != 0  ) ";
                        if (o.Nt(str3)) {
                            str5 = str5 + " AND " + byo3.Nw(str3);
                        }
                        byo3.n(z2, str5);
                        af.byo().b(this.userName, this.bNu, i.eG(((boy) bqf.rgH.getLast()).rlK));
                        a(bqf, str2);
                    }
                    bxL();
                    Mf(this.userName);
                    this.diJ.a(i2, i3, str, this);
                    return;
                } else if (bqf.rgH.size() == 0) {
                    x.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
                    this.diJ.a(i2, i3, str, this);
                    return;
                } else {
                    a(bqf, str2);
                    Mf(this.userName);
                    this.diJ.a(i2, i3, str, this);
                    return;
                }
            }
        }
        Mf(this.userName);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 212;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final long bxy() {
        return this.nnT;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final boolean bxu() {
        return this.nnR;
    }

    public final boolean bxv() {
        return this.noL;
    }

    public final boolean bxz() {
        return this.noY;
    }

    public final boolean bxx() {
        return this.noZ;
    }

    public final boolean bxw() {
        return this.noM;
    }

    public final long bxA() {
        return this.npa;
    }
}
