package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.protocal.c.atc;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpi;
import com.tencent.mm.protocal.c.bpj;
import com.tencent.mm.protocal.c.bpk;
import com.tencent.mm.protocal.c.bpn;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.bue;
import com.tencent.mm.protocal.c.ku;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class s extends l implements k {
    private b diG;
    public e diJ;
    int dlT = 0;
    private c dlW = new 2(this);
    private c dlX = new 3(this);
    boolean hNA = false;
    int nkZ;
    private bsu noh;
    private bsu noi;
    long noj = 0;
    private int nok = 0;
    private ua nol;
    int nom;
    String non = "";
    HashMap<String, ate> noo = new HashMap();
    HashMap<String, Integer> nop = new HashMap();
    String noq = "";

    static /* synthetic */ void a(s sVar) {
        if (sVar.nop.isEmpty()) {
            a.sFg.c(sVar.dlW);
            a.sFg.c(sVar.dlX);
            if (sVar.dlT != 0 && !bi.oW(sVar.non)) {
                String str = sVar.noi.sqb == null ? "" : sVar.noi.sqb.ksA;
                int size = sVar.noi.sqc.ruA.size();
                x.i("MicroMsg.NetSceneSnsPost", "report qrCodeImgSns(13627), snsId:%s, size:%d, info:%s, appId:%s", new Object[]{sVar.noi.ksA, Integer.valueOf(size), sVar.non, str});
                o.u(13627, String.format(Locale.US, "%s,%d,%s,%s", new Object[]{sVar.noi.ksA, Integer.valueOf(size), sVar.non, str}));
            }
        }
    }

    public s(String str, int i, int i2, List<String> list, bsu bsu, int i3, String str2, int i4, LinkedList<Long> linkedList, int i5, atf atf, boolean z, LinkedList<bhz> linkedList2, bpi bpi, com.tencent.mm.bk.b bVar, String str3) {
        String str4;
        int i6;
        String str5;
        this.noh = bsu;
        this.nkZ = i3;
        this.nom = i5;
        b.a aVar = new b.a();
        aVar.dIG = new bpj();
        aVar.dIH = new bpk();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnspost";
        aVar.dIF = 209;
        aVar.dII = 97;
        aVar.dIJ = 1000000097;
        this.diG = aVar.KT();
        bpj bpj = (bpj) this.diG.dID.dIL;
        if (!TextUtils.isEmpty(bsu.nsB.raS.raN)) {
            ku kuVar = new ku();
            kuVar.rmR = bsu.nsB.raS.raN;
            bpj.snv = kuVar;
        }
        u.b ib = u.Hx().ib(atf.bJK);
        if (ib != null) {
            this.nol = new ua();
            this.nol.cfH.cfI = ib.getString("prePublishId", "");
            this.nol.cfH.url = ib.getString("url", "");
            this.nol.cfH.cfK = ib.getString("preUsername", "");
            this.nol.cfH.cfL = ib.getString("preChatName", "");
            this.nol.cfH.cfM = ib.getInt("preMsgIndex", 0);
            this.nol.cfH.cfQ = ib.getInt("sendAppMsgScene", 0);
            this.nol.cfH.cfR = ib.getInt("getA8KeyScene", 0);
            this.nol.cfH.cfS = ib.getString("referUrl", null);
            this.nol.cfH.cfT = ib.getString("adExtStr", null);
            this.nol.cfH.cfU = str3;
            str4 = "";
            if (bsu.nNV != null) {
                bqw bqw = new bqw();
                try {
                    bqw.aG(Base64.decode(bsu.nNV, 0));
                    if (bqw.soY != null) {
                        str4 = bqw.soY.jLY;
                    }
                } catch (Exception e) {
                }
            }
            if (bi.oW(str4) && bsu.sqb != null) {
                str4 = bsu.sqb.ksA;
            }
            bpj.snu = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.nol.cfH.cfI, this.nol.cfH.cfK, this.nol.cfH.cfL, Integer.valueOf(t.N(this.nol.cfH.cfK, this.nol.cfH.cfL)), Integer.valueOf(this.nol.cfH.cfR), str4});
        }
        bhy bhy = new bhy();
        bhy.bq(str.getBytes());
        String str6 = "MicroMsg.NetSceneSnsPost";
        String str7 = "len:%d   skb:%d ctx.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(str.length());
        objArr[1] = Integer.valueOf(bhy.siI);
        if (bVar == null) {
            i6 = 0;
        } else {
            i6 = bVar.lR.length;
        }
        objArr[2] = Integer.valueOf(i6);
        x.i(str6, str7, objArr);
        bpj.smH = bhy;
        bpj.snp = i;
        bpj.rWb = i2;
        bpj.rcc = str2;
        this.nok = i;
        if (af.ewO) {
            bpj.smH = new bhy();
            x.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
        }
        LinkedList linkedList3 = new LinkedList();
        if (list != null && list.size() > 0) {
            str4 = "";
            Iterator it = list.iterator();
            while (true) {
                str5 = str4;
                if (!it.hasNext()) {
                    break;
                }
                str4 = (String) it.next();
                bhz bhz = new bhz();
                bhz.VO(str4);
                linkedList3.add(bhz);
                str4 = str5 + "; + " + str4;
            }
            x.d("MicroMsg.NetSceneSnsPost", "post with list : " + str5);
        }
        bpj.smR = linkedList3;
        bpj.smQ = linkedList3.size();
        bpj.snq = i4;
        str5 = "MicroMsg.NetSceneSnsPost";
        str6 = "setObjectSource: %d, clientid:%s fromScene:%s, score:%d";
        Object[] objArr2 = new Object[4];
        objArr2[0] = Integer.valueOf(i5);
        objArr2[1] = str2;
        objArr2[2] = bpj.snu;
        objArr2[3] = Integer.valueOf(atf.rWt != null ? atf.rWt.smt : 0);
        x.i(str5, str6, objArr2);
        if (linkedList2 != null && linkedList2.size() > 0) {
            if (z) {
                bpj.smW = linkedList2;
                bpj.smV = linkedList2.size();
            } else {
                bpj.rWm = linkedList2;
                bpj.smX = linkedList2.size();
            }
        }
        x.d("MicroMsg.NetSceneSnsPost", "setObjectSource " + i5);
        bpj.snr = i5;
        bue bue = new bue();
        if (!bi.oW(atf.token)) {
            bue.srB = atf.token;
            bue.srC = atf.rWk;
            bpj.sdt = bue;
        }
        if (!(linkedList == null || linkedList.isEmpty())) {
            bpj.rYP = linkedList.size();
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                Long l = (Long) it2.next();
                bot bot = new bot();
                bot.smF = l.longValue();
                bpj.rWh.add(bot);
            }
            x.d("MicroMsg.NetSceneSnsPost", "tagid " + linkedList.size() + " " + bpj.rWh.toString());
        }
        bpj.rWn = bpi;
        if (!bi.oW(atf.rWp)) {
            bpj.smZ = new bpn();
        }
        if (bpi != null) {
            x.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[]{bpi.rds, bpi.rdt, bpi.rdu});
        }
        if (bVar != null) {
            bpj.snt = new bhy().b(bVar);
        }
        bpj.sny = atf.rWt;
        n xd = af.byo().xd(this.nkZ);
        if (xd != null && ((xd.field_type == 1 || xd.field_type == 15) && bsu.sqc != null && bsu.sqc.ruA != null && bsu.sqc.ruA.size() > 0 && atf.rWc != null && atf.rWc.size() == bsu.sqc.ruA.size())) {
            str7 = af.getAccSnsPath();
            i6 = 0;
            Iterator it3 = bsu.sqc.ruA.iterator();
            while (true) {
                int i7 = i6;
                if (!it3.hasNext()) {
                    break;
                }
                ate ate = (ate) it3.next();
                if (ate.hcE == 2 || ate.hcE == 6) {
                    atc atc = new atc();
                    atc.jSO = ate.hcE == 2 ? 2 : 1;
                    if (ate.hcE == 6) {
                        com.tencent.mm.plugin.sight.base.a Lo = d.Lo(an.s(str7, ate.ksA) + i.p(ate));
                        if (Lo != null) {
                            atc.rVA = (int) Math.round(((double) Lo.jdD) / 1000.0d);
                        }
                    }
                    try {
                        atc.rdq = ((ath) new ath().aG(af.byd().fj((long) ((ari) atf.rWc.get(i7)).rTF).nJM)).rWF;
                    } catch (Exception e2) {
                    }
                    x.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s", new Object[]{Integer.valueOf(atc.rdq), Integer.valueOf(atc.rVA), Integer.valueOf(atc.jSO)});
                    bpj.snx.add(atc);
                }
                i6 = i7 + 1;
            }
            bpj.snw = bpj.snx.size();
            x.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", new Object[]{Integer.valueOf(bpj.snw)});
        }
        bpj.rTr = new bhy().bq(com.tencent.mm.plugin.normsg.a.b.lFJ.bjE());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSnsPost", "post netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bpk bpk = (bpk) ((b) qVar).dIE.dIL;
        if (i2 == 4) {
            n xd = af.byo().xd(this.nkZ);
            try {
                atf atf = (atf) new atf().aG(xd.field_postBuf);
                atf.rWj = i3;
                atf.rWr = bpk.rWr;
                atf.rWs = false;
                xd.field_postBuf = atf.toByteArray();
            } catch (Exception e) {
            }
            if (xd != null) {
                xd.bBi();
                af.byo().b(this.nkZ, xd);
                af.byn().ws(this.nkZ);
                x.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + xd.bBe());
                qh qhVar = new qh();
                qhVar.caS.caT = (long) this.nkZ;
                a.sFg.m(qhVar);
            }
            if (!(this.noh == null || this.noh.sqc == null || this.noh.sqc.ruz != 21)) {
                com.tencent.mm.plugin.sns.lucky.a.b.kB(8);
                switch (i3) {
                    case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                        com.tencent.mm.plugin.sns.lucky.a.b.kB(19);
                        break;
                    case av.CTRL_INDEX /*201*/:
                        com.tencent.mm.plugin.sns.lucky.a.b.kB(17);
                        break;
                    case 211:
                        com.tencent.mm.plugin.sns.lucky.a.b.kB(18);
                        break;
                    default:
                        com.tencent.mm.plugin.sns.lucky.a.b.kB(20);
                        break;
                }
            }
            this.diJ.a(i2, i3, str, this);
        } else if (i3 != 0) {
            af.byn().ws(this.nkZ);
            if (!(this.noh == null || this.noh.sqc == null || this.noh.sqc.ruz != 21)) {
                com.tencent.mm.plugin.sns.lucky.a.b.kB(8);
                com.tencent.mm.plugin.sns.lucky.a.b.kB(16);
            }
            this.diJ.a(i2, i3, str, this);
        } else if (bpk.slX == null || bpk.slX.smH == null || bpk.slX.smH.siK == null) {
            x.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
            af.byn().ws(this.nkZ);
            n xd2 = af.byo().xd(this.nkZ);
            xd2.bBh();
            af.byo().b(this.nkZ, xd2);
            qi qiVar = new qi();
            qiVar.caU.caT = (long) this.nkZ;
            a.sFg.m(qiVar);
            this.diJ.a(i2, i3, str, this);
        } else {
            String str2;
            String str3;
            String str4 = new String(bpk.slX.smH.siK.toByteArray());
            if (this.nok == 0) {
                x.d("MicroMsg.NetSceneSnsPost", "resp " + str4 + "  ");
            }
            this.noi = com.tencent.mm.modelsns.e.ng(str4);
            if (this.noi.sqh != null) {
                str2 = this.noi.ksA;
                str3 = this.noi.sqh.dyQ;
                String str5 = this.noi.sqh.dyP;
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.r("20CurrPublishId", str2 + ",");
                dVar.r("20SourcePublishId", str3 + ",");
                dVar.r("20SourceAdUxInfo", str5 + ",");
                x.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + dVar.wF());
                h.mEJ.h(13004, new Object[]{dVar});
            }
            n xd3 = af.byo().xd(this.nkZ);
            if (xd3 == null) {
                x.e("MicroMsg.NetSceneSnsPost", "the item has delete");
                xd3 = new n();
            }
            xd3.hK(bpk.slX.lOH);
            xd3.Nj(str4);
            xd3.field_localFlag &= -17;
            xd3.fe(bpk.slX.rlK);
            xd3.fg(bpk.slX.rlK);
            if ((bpk.slX.rXx & 1) > 0) {
                xd3.bBb();
            }
            this.noj = bpk.slX.rlK;
            if (this.nol != null) {
                this.nol.cfH.cfJ = "sns_" + i.eF(this.noj);
                a.sFg.m(this.nol);
            }
            boy boy = bpk.slX;
            boy.smH.bq(new byte[0]);
            try {
                com.tencent.mm.modelsns.b bR;
                qi qiVar2;
                if (boy.smN == 0 && boy.smK == 0 && boy.smQ == 0 && boy.rYP == 0) {
                    x.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
                    xd3.bBh();
                    af.byo().b(this.nkZ, xd3);
                    af.byn().ws(this.nkZ);
                    new ag(Looper.getMainLooper()).post(new 1(this));
                    bR = com.tencent.mm.plugin.sns.h.e.nxO.bR(Integer.valueOf(this.nkZ));
                    bR.RA();
                    bR.RB();
                    bR.nd(this.noi.ksA);
                    bR.ir(this.noi.sqc.ruz);
                    bR.RD();
                    bR = f.nxO.bR(Integer.valueOf(this.nkZ));
                    bR.RA();
                    bR.RB();
                    bR.nd(this.noi.ksA);
                    bR.ir(this.noi.sqc.ruz);
                    bR.RD();
                    qiVar2 = new qi();
                    qiVar2.caU.caT = (long) this.nkZ;
                    a.sFg.m(qiVar2);
                    if (xd3.field_type == 21) {
                        if (xd3.field_pravited != 1) {
                            int i4 = bpk.slX.rXx;
                        }
                        com.tencent.mm.plugin.sns.lucky.a.b.kB(7);
                        r0 = this.noi.ksA;
                        System.currentTimeMillis();
                    }
                    a(this.noh, this.noi);
                    if (this.noi != null) {
                    }
                    Md(this.noi != null ? "" : this.noi.spZ);
                    if (af.byk() != null) {
                        af.byk().bwX();
                    }
                    if (xd3.field_type == 15) {
                        ate ate = (ate) this.noi.sqc.ruA.get(0);
                        if (ate != null) {
                            str2 = an.s(af.getAccSnsPath(), ate.ksA) + i.j(ate);
                            com.tencent.mm.modelvideo.n SY = com.tencent.mm.modelvideo.n.SY();
                            r0 = ate.jPK;
                            long j = boy.rlK;
                            if (!(bi.oW(r0) || bi.oW(str2))) {
                                str3 = r0.hashCode();
                                x.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[]{str3, r0, Long.valueOf(j), str2});
                                com.tencent.mm.modelvideo.n.a aVar = (com.tencent.mm.modelvideo.n.a) SY.ena.get(str3);
                                if (aVar != null) {
                                    aVar.enq = String.valueOf(j);
                                    aVar.enp = str2;
                                    SY.a(aVar.emE, str3);
                                }
                            }
                        }
                    }
                    this.diJ.a(i2, i3, str, this);
                }
                String str6;
                xd3.aK(boy.toByteArray());
                xd3.bBh();
                af.byo().b(this.nkZ, xd3);
                af.byn().ws(this.nkZ);
                if (((this.noh.sqc.ruz == 1 && this.noh.csE == 0 && this.noi.csE == 1) || (this.noh.sqc.ruz == 15 && this.noh.sqj == 0 && this.noi.sqj == 1)) && com.tencent.mm.plugin.sns.storage.i.fb(v.NE(xd3.bAK()))) {
                    new ag(Looper.getMainLooper()).post(new 1(this));
                }
                bR = com.tencent.mm.plugin.sns.h.e.nxO.bR(Integer.valueOf(this.nkZ));
                if (!(bR == null || this.noi == null)) {
                    bR.RA();
                    bR.RB();
                    bR.nd(this.noi.ksA);
                    bR.ir(this.noi.sqc.ruz);
                    bR.RD();
                }
                bR = f.nxO.bR(Integer.valueOf(this.nkZ));
                if (!(bR == null || this.noi == null)) {
                    bR.RA();
                    bR.RB();
                    bR.nd(this.noi.ksA);
                    bR.ir(this.noi.sqc.ruz);
                    bR.RD();
                }
                qiVar2 = new qi();
                qiVar2.caU.caT = (long) this.nkZ;
                a.sFg.m(qiVar2);
                if (xd3.field_type == 21) {
                    if (xd3.field_pravited != 1) {
                        int i42 = bpk.slX.rXx;
                    }
                    com.tencent.mm.plugin.sns.lucky.a.b.kB(7);
                    str6 = this.noi.ksA;
                    System.currentTimeMillis();
                }
                a(this.noh, this.noi);
                Md(this.noi != null ? "" : this.noi.spZ);
                if (af.byk() != null) {
                    af.byk().bwX();
                }
                try {
                    if (xd3.field_type == 15) {
                        ate ate2 = (ate) this.noi.sqc.ruA.get(0);
                        if (ate2 != null) {
                            str2 = an.s(af.getAccSnsPath(), ate2.ksA) + i.j(ate2);
                            com.tencent.mm.modelvideo.n SY2 = com.tencent.mm.modelvideo.n.SY();
                            str6 = ate2.jPK;
                            long j2 = boy.rlK;
                            if (!(bi.oW(str6) || bi.oW(str2))) {
                                str3 = str6.hashCode();
                                x.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[]{str3, str6, Long.valueOf(j2), str2});
                                com.tencent.mm.modelvideo.n.a aVar2 = (com.tencent.mm.modelvideo.n.a) SY2.ena.get(str3);
                                if (aVar2 != null) {
                                    aVar2.enq = String.valueOf(j2);
                                    aVar2.enp = str2;
                                    SY2.a(aVar2.emE, str3);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                }
                this.diJ.a(i2, i3, str, this);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsPost", e3, "", new Object[0]);
            }
        }
    }

    private void Md(String str) {
        this.noq = str;
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100132");
        if (fJ.isValid()) {
            this.dlT = bi.getInt((String) fJ.ckq().get("needUploadData"), 1);
        }
        if ((this.nom == 12 || this.dlT != 0) && this.noi != null && this.noi.sqc != null && this.noi.sqc.ruA != null && this.noi.sqc.ruA.size() > 0) {
            LinkedList linkedList = this.noi.sqc.ruA;
            a.sFg.b(this.dlW);
            a.sFg.b(this.dlX);
            Iterator it = linkedList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ate ate = (ate) it.next();
                if (ate.hcE == 2) {
                    String C = g.C(ate);
                    if (!bi.oW(C)) {
                        this.nop.put(C, Integer.valueOf(i));
                        this.noo.put(C, ate);
                        int i2 = i + 1;
                        ms msVar = new ms();
                        msVar.bXH.filePath = C;
                        a.sFg.m(msVar);
                        i = i2;
                    }
                }
            }
        }
    }

    private static boolean a(bsu bsu, bsu bsu2) {
        if (bsu == null || bsu2 == null || bsu.sqc == null || bsu2.sqc == null) {
            return false;
        }
        String accSnsPath = af.getAccSnsPath();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bsu.sqc.ruA.size() && i2 < bsu2.sqc.ruA.size()) {
                ate ate = (ate) bsu.sqc.ruA.get(i2);
                ate ate2 = (ate) bsu2.sqc.ruA.get(i2);
                String m = i.m(ate);
                String n = i.n(ate);
                String o = i.o(ate);
                String p = i.p(ate);
                String l = i.l(ate2);
                String e = i.e(ate2);
                String f = i.f(ate2);
                String j = i.j(ate2);
                x.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + m + "  - " + l);
                String s = an.s(accSnsPath, ate.ksA);
                String s2 = an.s(accSnsPath, ate2.ksA);
                FileOp.mL(s2);
                FileOp.av(s + m, s2 + l);
                FileOp.av(s + n, s2 + e);
                FileOp.av(s + o, s2 + f);
                if (FileOp.cn(s + p)) {
                    x.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[]{s2 + j});
                    FileOp.av(s + p, s2 + j);
                }
                i = i2 + 1;
            }
        }
        return true;
    }

    public final int getType() {
        return 209;
    }
}
