package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.j;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.protocal.c.ass;
import com.tencent.mm.protocal.c.avs;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bup;
import com.tencent.mm.protocal.c.ccn;
import com.tencent.mm.protocal.c.cge;
import com.tencent.mm.protocal.c.ec;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.protocal.c.eo;
import com.tencent.mm.protocal.c.fi;
import com.tencent.mm.protocal.c.iy;
import com.tencent.mm.protocal.c.iz;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.protocal.i.b;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class av extends j implements c {
    private static a dBP = null;
    private final int dBM;
    private final f dBN;
    private final g dBO;

    public interface a {
        void a(f fVar, g gVar);
    }

    public av(int i) {
        boolean z = i == HardCoderJNI.SCENE_ALBUM_SCROLL || i == HardCoderJNI.SCENE_SNS_SCROLL;
        Assert.assertTrue(z);
        this.dBM = i;
        if (i == HardCoderJNI.SCENE_ALBUM_SCROLL) {
            this.dBN = new com.tencent.mm.protocal.i.a();
            this.dBO = new b();
            return;
        }
        this.dBN = new d();
        this.dBO = new e();
    }

    private q hc(int i) {
        x.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", Integer.valueOf(i), Integer.valueOf(hashCode()), bi.cjd());
        f fVar = (f) KV();
        g gVar = this.dBO;
        SharedPreferences Ib = aw.Ib();
        x.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(Ib.getInt("key_auth_update_version", 0)), Integer.valueOf(com.tencent.mm.protocal.d.qVN));
        if (Ib.getInt("key_auth_update_version", 0) < com.tencent.mm.protocal.d.qVN) {
            fVar.qWw = this.dBM == HardCoderJNI.SCENE_ALBUM_SCROLL ? 12 : 16;
            com.tencent.mm.plugin.report.f.mDy.a(148, this.dBM == HardCoderJNI.SCENE_ALBUM_SCROLL ? 14 : 13, 1, false);
        } else {
            fVar.qWw = this.dBM == HardCoderJNI.SCENE_ALBUM_SCROLL ? 2 : 1;
        }
        fi fiVar = new fi();
        fiVar.rgn = i;
        fiVar.rez = new bhy().bq(new byte[0]);
        fiVar.rey = new bhy().bq(new byte[0]);
        ccn ccn = new ccn();
        fiVar.rgl = ccn;
        ccn.rhW = "";
        ccn.rhV = "";
        ccn.syo = "";
        cge cge = new cge();
        fiVar.rgm = cge;
        cge.rKZ = "";
        cge.rKY = "";
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            String oVar;
            byte[] bArr;
            com.tencent.mm.kernel.g.Ek();
            String oV = bi.oV((String) com.tencent.mm.kernel.g.Ei().DT().get(2, null));
            com.tencent.mm.kernel.g.Ek();
            o oVar2 = new o(bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(9, null), 0));
            if (bi.oW(oV)) {
                oVar = oVar2.toString();
            } else {
                oVar = oV;
            }
            com.tencent.mm.kernel.g.Ek();
            byte[] a = com.tencent.mm.kernel.g.Eg().Dp().a(oVar2.longValue(), "", this.dBM == HardCoderJNI.SCENE_SNS_SCROLL);
            String str = "MicroMsg.MMReqRespAuth";
            String str2 = "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]";
            Object[] objArr = new Object[4];
            objArr[0] = oVar;
            objArr[1] = oVar2;
            objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
            objArr[3] = a == null ? "null" : bi.Xf(bi.bB(a));
            x.i(str, str2, objArr);
            bhy bhy = new bhy();
            if (bi.bC(a)) {
                bArr = new byte[0];
            } else {
                bArr = a;
            }
            fiVar.rgk = bhy.bq(bArr);
            if (this.dBM == HardCoderJNI.SCENE_ALBUM_SCROLL) {
                com.tencent.mm.protocal.i.a aVar = (com.tencent.mm.protocal.i.a) fVar;
                b bVar = (b) gVar;
                el elVar = new el();
                eo eoVar = new eo();
                aVar.qWi.reW = eoVar;
                aVar.qWi.reX = elVar;
                bArr = bi.WP(Ib.getString("_auth_key", ""));
                em emVar = new em();
                if (bi.bC(bArr)) {
                    com.tencent.mm.plugin.report.f.mDy.a(148, 16, 1, false);
                    elVar.res = new bhy().bq(new byte[0]);
                } else {
                    elVar.res = new bhy().bq(bArr);
                    try {
                        emVar.aG(bArr);
                    } catch (Throwable e) {
                        com.tencent.mm.plugin.report.f.mDy.a(148, 15, 1, false);
                        x.printErrStackTrace("MicroMsg.MMReqRespAuth", e, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
                    }
                }
                if (emVar.reU != null) {
                    eoVar.reY = emVar.reU;
                } else {
                    com.tencent.mm.plugin.report.f.mDy.a(148, 17, 1, false);
                    eoVar.reY = new bhy().bq(new byte[0]);
                    x.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
                }
                elVar.reP = fiVar;
                aVar.username = oVar;
                bVar.erW = oVar;
                return this;
            }
            d dVar = (d) fVar;
            ass ass = new ass();
            asq asq = new asq();
            dVar.qWk.rUY = ass;
            dVar.qWk.rUZ = asq;
            asq.rUX = 2;
            asq.reP = fiVar;
            ass.hbL = oVar;
            com.tencent.mm.kernel.g.Ek();
            oV = bi.oV((String) com.tencent.mm.kernel.g.Ei().DT().get(3, null));
            com.tencent.mm.kernel.g.Ek();
            ass.rhI = bi.oV((String) com.tencent.mm.kernel.g.Ei().DT().get(19, null));
            ass.rhU = oV;
            return this;
        }
        x.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        return null;
    }

    public final int Ia() {
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eg();
            return com.tencent.mm.kernel.a.Df();
        }
        x.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", bi.cjd());
        return 0;
    }

    public final q aZ(int i, int i2) {
        return new av(i).hc(i2);
    }

    public static void a(a aVar) {
        dBP = aVar;
    }

    public final void a(f fVar, g gVar, int i, int i2, String str) {
        if (com.tencent.mm.kernel.g.Eg().Dx()) {
            bup bup = gVar.qWn;
            if (bup == null || bup.srN == null) {
                x.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", Integer.valueOf(gVar.qWB));
            } else {
                int i3 = gVar.qWn.srN.reI;
                x.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", Integer.valueOf(i3));
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Ei().dqk.set(47, Integer.valueOf(i3));
                com.tencent.mm.network.e eVar = com.tencent.mm.kernel.g.Eh().dpP.dJs;
                if (eVar != null) {
                    eVar.bF((i3 & 1) == 0);
                }
            }
            x.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                if (dBP != null) {
                    dBP.a(fVar, gVar);
                    return;
                }
                return;
            } else if (i == 4 && i2 == -301) {
                com.tencent.mm.plugin.report.f.mDy.a(148, 18, 1, false);
                x.d("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
                if (bup == null || bup.srP == null) {
                    x.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
                    return;
                } else {
                    a(true, gVar.qWn.srP.rhK, gVar.qWn.srP.rhL, gVar.qWn.srP.rhJ);
                    return;
                }
            } else {
                return;
            }
        }
        x.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
    }

    public static void a(boolean z, iz izVar, avs avs, amt amt) {
        String str = "MicroMsg.MMReqRespAuth";
        String str2 = "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(izVar == null ? -1 : izVar.rkm);
        objArr[2] = Integer.valueOf(izVar == null ? -1 : izVar.rkn);
        objArr[3] = Integer.valueOf(amt == null ? -1 : amt.hbF);
        objArr[4] = Integer.valueOf(avs == null ? -1 : avs.rYK);
        objArr[5] = Integer.valueOf(avs == null ? -1 : avs.rYL);
        objArr[6] = Integer.valueOf(avs == null ? -1 : avs.rYM);
        objArr[7] = avs == null ? "null" : avs.rYI;
        objArr[8] = avs == null ? "null" : avs.rYJ;
        x.i(str, str2, objArr);
        if (amt == null || amt.hbG == null || amt.hbG.size() <= 0) {
            x.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", bi.cjd());
        } else if (amt == null || amt.hbG == null || amt.hbG.size() <= 0) {
            x.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", bi.cjd());
        } else {
            iy iyVar;
            com.tencent.mm.protocal.n.a fJ;
            List linkedList = new LinkedList();
            linkedList.clear();
            if (izVar != null) {
                Iterator it = izVar.rkq.iterator();
                while (it.hasNext()) {
                    iyVar = (iy) it.next();
                    str = "";
                    if (iyVar.rkl != null) {
                        str = iyVar.rkl.cfV();
                    }
                    linkedList.add(new n(iyVar.type, iyVar.rkk.cfV(), iyVar.port, str));
                    x.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", Integer.valueOf(iyVar.type), Integer.valueOf(iyVar.port), iyVar.rkk.cfV());
                }
            }
            str2 = n.cV(linkedList);
            List linkedList2 = new LinkedList();
            if (izVar != null) {
                Iterator it2 = izVar.rkp.iterator();
                while (it2.hasNext()) {
                    iyVar = (iy) it2.next();
                    str = "";
                    if (iyVar.rkl != null) {
                        str = iyVar.rkl.cfV();
                    }
                    linkedList2.add(new n(iyVar.type, iyVar.rkk.cfV(), iyVar.port, str));
                    x.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", Integer.valueOf(iyVar.type), Integer.valueOf(iyVar.port), iyVar.rkk.cfV());
                }
            }
            String cV = n.cV(linkedList2);
            x.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", cV, str2);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Ei().dqk.set(2, str2);
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 0);
            sharedPreferences.edit().putString("builtin_short_ips", str2).commit();
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Ei().dqk.set(3, cV);
            if (avs != null) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Ei().dqk.set(6, avs.rYI);
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Ei().dqk.set(7, avs.rYJ);
                if (avs.rYM != 0) {
                    int i;
                    com.tencent.mm.kernel.g.Ek();
                    w wVar = com.tencent.mm.kernel.g.Ei().dqk;
                    if (avs.rYM > 60) {
                        i = 60;
                    } else {
                        i = avs.rYM;
                    }
                    wVar.set(35, Integer.valueOf(i));
                }
                com.tencent.mm.network.ad.m((long) avs.rYK, (long) avs.rYN);
                fJ = n.fJ(avs.rYI, avs.rYJ);
            } else {
                fJ = null;
            }
            String str3 = "";
            String str4 = "";
            String[] strArr = new String[amt.hbG.size()];
            String[] strArr2 = new String[amt.hbG.size()];
            int[] iArr = new int[amt.hbG.size()];
            x.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", Integer.valueOf(amt.hbF));
            Iterator it3 = amt.hbG.iterator();
            int i2 = 0;
            while (it3.hasNext()) {
                ams ams = (ams) it3.next();
                x.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", ams.rPz, ams.rPA);
                strArr[i2] = ams.rPz;
                strArr2[i2] = ams.rPA;
                iArr[i2] = ams.rPB;
                i2++;
                if (!(bi.oW(ams.rPz) || bi.oW(ams.rPA))) {
                    if (ams.rPz.equals("short.weixin.qq.com")) {
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Ei().dqk.set(24, ams.rPA);
                        str4 = ams.rPA;
                    } else if (ams.rPz.equals("long.weixin.qq.com")) {
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Ei().dqk.set(25, ams.rPA);
                        str3 = ams.rPA;
                    } else if (ams.rPz.equals("support.weixin.qq.com") && !bi.oW(ams.rPA)) {
                        sharedPreferences.edit().putString("support.weixin.qq.com", ams.rPA).commit();
                    }
                }
            }
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.network.e eVar = com.tencent.mm.kernel.g.Eh().dpP.dJs;
            if (strArr.length > 0 && eVar != null) {
                eVar.setHostInfo(strArr, strArr2, iArr);
            }
            if (!bi.oW(str3)) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Ei().dqk.set(25, str3);
            }
            if (!bi.oW(str4)) {
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Ei().dqk.set(24, str4);
            }
            if (eVar != null && fJ != null) {
                eVar.a(z, str2, cV, fJ.qWI, fJ.qWJ, fJ.qWK, fJ.qWL, str4, str3);
            }
        }
    }

    public static SharedPreferences Ib() {
        return aw.Ib();
    }

    protected final k.d Ic() {
        return this.dBN;
    }

    public final k.e Id() {
        return this.dBO;
    }

    public final int getType() {
        return this.dBN.If();
    }

    public final String getUri() {
        return this.dBN.getUri();
    }

    public static int b(q qVar) {
        g gVar = (g) qVar.Id();
        x.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", Integer.valueOf(((f) qVar.KV()).If()), Integer.valueOf(qVar.hashCode()), Integer.valueOf(gVar.djx), bi.cjd());
        if (gVar.djx != 0) {
            x.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(gVar.djx));
            return gVar.djx;
        }
        bup bup = gVar.qWn;
        int i = bup.srM;
        if ((i & 1) != 0) {
            ec ecVar = bup.srN;
            x.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", Integer.valueOf(ecVar.reH), Integer.valueOf(ecVar.reG));
            sx sxVar = ecVar.req;
            byte[] a = ab.a(ecVar.rer);
            String str = "MicroMsg.MMReqRespAuth";
            String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(sxVar.reV.siI);
            objArr[1] = Integer.valueOf(sxVar.rwf);
            objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
            objArr[3] = bi.Xf(bi.bB(a));
            x.d(str, str2, objArr);
            byte[] a2 = ab.a(sxVar.reV);
            byte[] bArr = r0.qWm;
            if (bi.bC(a2)) {
                com.tencent.mm.plugin.report.f.mDy.a(148, 24, 1, false);
                x.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
                a2 = null;
            } else {
                str2 = "MicroMsg.MMReqRespAuth";
                String str3 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                Object[] objArr2 = new Object[4];
                objArr2[0] = Integer.valueOf(a2.length);
                objArr2[1] = bi.Xf(bi.bB(a2));
                objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                objArr2[3] = bi.Xf(bi.bB(bArr));
                x.d(str2, str3, objArr2);
                PByteArray pByteArray = new PByteArray();
                int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(sxVar.rwf, a2, bArr, pByteArray, 0);
                a2 = pByteArray.value;
                str = "MicroMsg.MMReqRespAuth";
                str2 = "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(computerKeyWithAllStr);
                objArr[1] = Integer.valueOf(a2 == null ? -1 : a2.length);
                objArr[2] = bi.Xf(bi.bB(a2));
                x.i(str, str2, objArr);
            }
            gVar.qWo = a2 != null ? a2 : new byte[0];
            if ((r12 & 4) != 0) {
                x.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
                if (bi.bC(a2)) {
                    com.tencent.mm.plugin.report.f.mDy.a(148, 26, 1, false);
                    x.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
                    gVar.bl(new byte[0]);
                    gVar.djx = 2;
                } else {
                    a2 = MMProtocalJni.aesDecrypt(a, a2);
                    String str4 = "MicroMsg.MMReqRespAuth";
                    str = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                    Object[] objArr3 = new Object[4];
                    objArr3[0] = Integer.valueOf(a == null ? -1 : a.length);
                    objArr3[1] = bi.Xf(bi.bB(a));
                    objArr3[2] = Integer.valueOf(a2 == null ? -1 : a2.length);
                    objArr3[3] = bi.Xf(bi.bB(a2));
                    x.d(str4, str, objArr3);
                    if (bi.bC(a2)) {
                        com.tencent.mm.plugin.report.f.mDy.a(148, 25, 1, false);
                        x.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
                        gVar.bl(new byte[0]);
                        gVar.djx = 2;
                    } else {
                        x.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", bi.Xf(bi.bB(a2)));
                        gVar.bl(a2);
                        gVar.djx = 1;
                    }
                }
            } else {
                com.tencent.mm.plugin.report.f.mDy.a(148, 27, 1, false);
                x.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
                gVar.bl(a);
                gVar.djx = 1;
            }
        } else {
            x.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed");
            gVar.bl(new byte[0]);
            gVar.djx = 2;
        }
        if ((i & 2) != 0) {
            gVar.erW = bup.srO.hbL;
        } else {
            x.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
        }
        return gVar.djx;
    }
}
