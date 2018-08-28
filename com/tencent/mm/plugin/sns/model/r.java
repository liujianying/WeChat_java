package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f.m;
import com.tencent.mm.plugin.sns.a.b.f;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bny;
import com.tencent.mm.protocal.c.bob;
import com.tencent.mm.protocal.c.bog;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.box;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.bpc;
import com.tencent.mm.protocal.c.bpd;
import com.tencent.mm.protocal.c.bpe;
import com.tencent.mm.protocal.c.bpf;
import com.tencent.mm.protocal.c.bpl;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends l implements k {
    private b diG;
    public e diJ;
    private ag handler;
    public int nkZ;
    private long nod;
    private bon noe;
    private Object nof;
    private int nog;
    public int type;

    public r(long j, int i) {
        this(j, i, null, null);
    }

    public r(long j, int i, Object obj) {
        this(j, i, null, obj);
    }

    public r(long j, int i, bon bon) {
        this(j, i, bon, null);
    }

    private r(long j, int i, bon bon, Object obj) {
        this.type = -1;
        this.nod = 0;
        this.nkZ = -1;
        this.nog = 0;
        this.handler = new ag(Looper.getMainLooper());
        this.noe = bon;
        this.type = i;
        this.nod = j;
        this.nof = obj;
        x.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + i);
        if (bon != null) {
            x.i("MicroMsg.NetSceneSnsObjectOp", bon.smh + " " + bon.smk);
        }
        a aVar = new a();
        aVar.dIG = new bpe();
        aVar.dIH = new bpf();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.dIF = 218;
        aVar.dII = i$l.AppCompatTheme_editTextStyle;
        aVar.dIJ = 1000000104;
        this.diG = aVar.KT();
        bpe bpe = (bpe) this.diG.dID.dIL;
        n fi = af.byo().fi(j);
        if (fi != null) {
            this.nkZ = fi.nJc;
        }
        bpb a = a(j, i, this.noe, obj);
        LinkedList linkedList = new LinkedList();
        linkedList.add(a);
        bpe.snh = linkedList;
        bpe.sng = linkedList.size();
    }

    public r(long j, int i, int i2, String str) {
        this.type = -1;
        this.nod = 0;
        this.nkZ = -1;
        this.nog = 0;
        this.handler = new ag(Looper.getMainLooper());
        this.noe = null;
        this.type = 9;
        this.nod = j;
        x.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + this.type);
        a aVar = new a();
        aVar.dIG = new bpe();
        aVar.dIH = new bpf();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.dIF = 218;
        aVar.dII = i$l.AppCompatTheme_editTextStyle;
        aVar.dIJ = 1000000104;
        this.diG = aVar.KT();
        bpe bpe = (bpe) this.diG.dID.dIL;
        n fi = af.byo().fi(j);
        if (fi != null) {
            this.nkZ = fi.nJc;
        }
        bpb y = y(j, this.type);
        bpd bpd = new bpd();
        bpd.otY = i;
        bpd.sne = i2;
        bpd.snf = ab.oT(str);
        try {
            y.sbD = new bhy().bq(bpd.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(y);
        bpe.snh = linkedList;
        bpe.sng = linkedList.size();
    }

    private static bpb a(long j, int i, bon bon, Object obj) {
        n nVar;
        String str;
        bpb y = y(j, i);
        x.i("MicroMsg.NetSceneSnsObjectOp", "getSnsObjectOp " + i + " " + (obj == null ? "" : obj.toString()));
        String str2 = "";
        if (i == 8 || i == 10 || i == 7 || i == 8 || i == 6) {
            n bAL;
            com.tencent.mm.plugin.sns.storage.e eZ = af.byr().eZ(j);
            if (eZ != null) {
                bAL = eZ.bAL();
            } else {
                bAL = null;
            }
            if (bAL == null || !bAL.xb(32)) {
                nVar = bAL;
            } else {
                com.tencent.mm.plugin.sns.storage.a bAH = bAL.bAH();
                str = bAH == null ? "" : bAH.ntU;
                x.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo " + str);
                str2 = str;
                nVar = bAL;
            }
        } else {
            nVar = null;
        }
        if (i == 6) {
            if (bon == null || (bon.smh == 0 && bon.smk == 0)) {
                return y;
            }
            bog bog = new bog();
            bog.smd = bon.smk;
            bog.slT = ab.oT(bi.aG(str2, ""));
            try {
                y.sbD = new bhy().bq(bog.toByteArray());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
            }
        } else if (i == 7) {
            bny bny = new bny();
            bny.slT = ab.oT(bi.aG(str2, ""));
            try {
                y.sbD = new bhy().bq(bny.toByteArray());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
            }
        } else if (i == 8) {
            int i2 = (obj == null || !(obj instanceof com.tencent.mm.plugin.sns.storage.a.b.a)) ? 0 : 1;
            if (i2 != 0) {
                com.tencent.mm.plugin.sns.storage.a.b.a aVar = (com.tencent.mm.plugin.sns.storage.a.b.a) obj;
                str = bi.aG(str2, "") + ("&" + aVar.nkJ + "|" + aVar.nyC);
            } else {
                str = str2;
            }
            bob bob = new bob();
            bob.slT = ab.oT(bi.aG(str, ""));
            if (nVar != null) {
                bob.rdq = nVar.bBq();
                nVar = af.byo().Nk(nVar.bAK());
                if (nVar != null) {
                    str = f.a(nVar.bAJ());
                } else {
                    x.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[]{str});
                    str = "";
                }
                bob.slV = ab.oT(bi.aG(str, ""));
            }
            if (i2 == 0 || ((com.tencent.mm.plugin.sns.storage.a.b.a) obj).nyB != com.tencent.mm.plugin.sns.storage.a.b.a.nyx) {
                af.byr().delete(j);
                af.byt().fd(j);
                i.fc(j);
                if (i2 != 0) {
                    bob.slW = ((com.tencent.mm.plugin.sns.storage.a.b.a) obj).nyB;
                }
            } else {
                bob.slW = com.tencent.mm.plugin.sns.storage.a.b.a.nyx;
            }
            try {
                y.sbD = new bhy().bq(bob.toByteArray());
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e22, "", new Object[0]);
            }
        } else if (i == 4) {
            if (bon == null || (bon.smh == 0 && bon.smk == 0)) {
                return y;
            }
            bpc bpc = new bpc();
            bpc.smh = bon.smh;
            try {
                y.sbD = new bhy().bq(bpc.toByteArray());
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e222, "", new Object[0]);
            }
        } else if (i == 10) {
            bpl bpl = new bpl();
            if (obj instanceof com.tencent.mm.bk.b) {
                com.tencent.mm.bk.b bVar = (com.tencent.mm.bk.b) obj;
                bpl.snz = ab.O(bVar.lR);
                x.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + bVar.lR.length);
            } else {
                x.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
            try {
                byte[] toByteArray = bpl.toByteArray();
                y.sbD = new bhy().bq(toByteArray);
                x.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + toByteArray.length);
            } catch (Throwable e2222) {
                x.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + e2222.getMessage());
                x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2222, "", new Object[0]);
            }
        } else if (i == 12) {
            if (obj instanceof box) {
                box box = (box) obj;
                try {
                    y.sbD = ab.O(box.toByteArray());
                    x.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + box.smG);
                } catch (Exception e3) {
                    x.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + e3.getMessage());
                }
            } else {
                x.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
            }
        }
        return y;
    }

    private static bpb y(long j, int i) {
        bpb bpb = new bpb();
        bpb.sbD = new bhy();
        bpb.rlK = j;
        bpb.jRb = i;
        return bpb;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 218;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            n fi;
            boy boy;
            Iterator it;
            Object obj;
            switch (this.type) {
                case 1:
                    af.byn().eT(this.nod);
                    af.byo().delete(this.nod);
                    break;
                case 2:
                    fi = af.byo().fi(this.nod);
                    if (fi != null) {
                        fi.field_pravited = 1;
                        fi.bAY();
                        af.byo().b(this.nod, fi);
                        break;
                    }
                    break;
                case 3:
                    fi = af.byo().fi(this.nod);
                    if (fi != null) {
                        fi.field_pravited = 0;
                        fi.field_localPrivate = 0;
                        fi.bBb();
                        af.byo().b(this.nod, fi);
                        break;
                    }
                    break;
                case 4:
                    n fi2 = af.byo().fi(this.nod);
                    if (fi2 != null) {
                        try {
                            boy = (boy) new boy().aG(fi2.field_attrBuf);
                            it = boy.smO.iterator();
                            while (it.hasNext()) {
                                obj = (bon) it.next();
                                if (this.noe != null && obj.smh == this.noe.smh) {
                                    if (obj != null) {
                                        boy.smO.remove(obj);
                                    }
                                    fi2.aK(boy.toByteArray());
                                    af.byo().z(fi2);
                                    af.byt().d(fi2.field_snsId, (long) this.noe.smh, this.noe.hcE);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                boy.smO.remove(obj);
                            }
                            fi2.aK(boy.toByteArray());
                            af.byo().z(fi2);
                            af.byt().d(fi2.field_snsId, (long) this.noe.smh, this.noe.hcE);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 5:
                    af.byn().eV(this.nod);
                    break;
                case 6:
                    com.tencent.mm.plugin.sns.storage.e eZ = af.byr().eZ(this.nod);
                    if (eZ != null) {
                        try {
                            boy = (boy) new boy().aG(eZ.field_attrBuf);
                            it = boy.smO.iterator();
                            while (it.hasNext()) {
                                obj = (bon) it.next();
                                if (this.noe != null && obj.smk == this.noe.smk) {
                                    if (obj != null) {
                                        boy.smO.remove(obj);
                                    }
                                    eZ.aK(boy.toByteArray());
                                    af.byr().a(eZ);
                                    af.byt().d(eZ.field_snsId, this.noe.smk, this.noe.hcE);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                boy.smO.remove(obj);
                            }
                            eZ.aK(boy.toByteArray());
                            af.byr().a(eZ);
                            af.byt().d(eZ.field_snsId, this.noe.smk, this.noe.hcE);
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 7:
                    af.byn().eV(this.nod);
                    break;
                case 8:
                    if (!(this.nof != null && (this.nof instanceof com.tencent.mm.plugin.sns.storage.a.b.a) && ((com.tencent.mm.plugin.sns.storage.a.b.a) this.nof).nyB == com.tencent.mm.plugin.sns.storage.a.b.a.nyx)) {
                        af.byr().delete(this.nod);
                        af.byt().fd(this.nod);
                        i.fc(this.nod);
                        break;
                    }
                case 9:
                    fi = af.byo().fi(this.nod);
                    if (fi != null) {
                        fi.xc(2);
                        af.byo().b(this.nod, fi);
                        break;
                    }
                    break;
                case 11:
                    x.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.nog);
                    if (this.nog == 0) {
                        g.Ek();
                        g.Ei().DT().a(aa.a.sSw, Boolean.valueOf(true));
                    } else if (this.nog == 1) {
                        g.Ek();
                        g.Ei().DT().a(aa.a.sSw, Boolean.valueOf(false));
                    }
                    g.Ek();
                    int intValue = ((Integer) g.Ei().DT().get(aa.a.sSy, Integer.valueOf(0))).intValue();
                    g.Ek();
                    g.Ei().DT().a(aa.a.sSy, Integer.valueOf(intValue + 1));
                    g.Ek();
                    intValue = ((Integer) g.Ei().DT().get(aa.a.sSz, Integer.valueOf(0))).intValue();
                    int i4;
                    if (this.nog == 0) {
                        intValue++;
                        i4 = (intValue * 2) + 198;
                        if (i4 >= 216) {
                            i4 = 216;
                        }
                        if (i4 >= m.CTRL_INDEX) {
                            com.tencent.mm.plugin.sns.lucky.a.b.kB(i4);
                        }
                        x.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + i4 + " " + intValue);
                    } else if (this.nog == 1) {
                        intValue++;
                        i4 = ((intValue * 2) + 198) + 1;
                        if (i4 >= 217) {
                            i4 = 217;
                        }
                        if (i4 >= 201) {
                            com.tencent.mm.plugin.sns.lucky.a.b.kB(i4);
                        }
                        x.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + i4 + " " + intValue);
                    }
                    g.Ek();
                    g.Ei().DT().a(aa.a.sSz, Integer.valueOf(intValue));
                    break;
                case 12:
                    if (this.nof != null && (this.nof instanceof box)) {
                        af.byt().s(this.nod, ((box) this.nof).smG == 1);
                        x.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", new Object[]{Long.valueOf(this.nod), Boolean.valueOf(r0)});
                        break;
                    }
            }
            af.byn().bxP();
            this.diJ.a(i2, i3, str, this);
            return;
        }
        if (i2 == 4 && this.type == 1) {
            switch (this.type) {
                case 1:
                    af.byn().eT(this.nod);
                    break;
                case 5:
                case 7:
                    af.byn().eV(this.nod);
                    break;
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
