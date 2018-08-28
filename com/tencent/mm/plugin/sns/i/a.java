package com.tencent.mm.plugin.sns.i;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public static boolean a(ch chVar, n nVar) {
        if (nVar == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
            chVar.bJF.bJL = j.favorite_fail_argument_error;
            return false;
        }
        wl wlVar = new wl();
        wr wrVar = new wr();
        bsu bAJ = nVar.bAJ();
        ate ate = (ate) bAJ.sqc.ruA.get(0);
        if (nVar.xb(32) && bAJ.sqc.ruz == 15) {
            bAJ.sqh.dyP = nVar.bAH().ntU;
            bAJ.sqh.dyQ = bAJ.ksA;
        }
        String eF = i.eF(nVar.field_snsId);
        eF = String.format("%s#%s", new Object[]{eF, ate.ksA});
        wrVar.Vw(nVar.field_userName);
        wrVar.Vx(q.GF());
        wrVar.CO(2);
        wrVar.fU(bi.VF());
        wrVar.VB(nVar.bAK());
        wrVar.Vy(eF);
        wlVar.a(wrVar);
        vx vxVar = new vx();
        vxVar.UT(eF);
        String s = an.s(af.getAccSnsPath(), ate.ksA);
        String j = i.j(ate);
        String e = i.e(ate);
        if (bi.oW(aq.a(nVar.bBe(), ate))) {
            x.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
            chVar.bJF.bJL = j.favorite_fail_sns_sight;
            return false;
        } else if (FileOp.cn(s + j)) {
            int i;
            int i2;
            if (!FileOp.cn(s + e)) {
                i = 320;
                int i3 = com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq.CTRL_BYTE;
                if (ate.rVH != null && ate.rVH.rWv > 0.0f && ate.rVH.rWu > 0.0f) {
                    i = (int) ate.rVH.rWu;
                    i3 = (int) ate.rVH.rWv;
                }
                Bitmap ad = d.ad(s + j, i, i3);
                if (ad == null) {
                    x.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + FileOp.cn(s + e));
                    chVar.bJF.bJL = j.favorite_fail_sns_sight;
                    return false;
                }
                try {
                    c.a(ad, 60, CompressFormat.JPEG, s + e, true);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", e2, "save bmp error %s", new Object[]{e2.getMessage()});
                    x.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + FileOp.cn(s + e));
                    chVar.bJF.bJL = j.favorite_fail_sns_sight;
                    return false;
                }
            }
            vxVar.UP(s + j);
            vxVar.UQ(s + e);
            vxVar.UB(bi.oW(ate.rVP) ? bAJ.spZ : ate.rVP);
            vxVar.Va(bAJ.ogR);
            if (!bi.oW(bAJ.ogR)) {
                Map z = bl.z(bAJ.ogR, "adxml");
                if (z.size() > 0) {
                    vxVar.UB(bi.aG((String) z.get(".adxml.adCanvasInfo.shareTitle"), ""));
                    vxVar.UC(bi.aG((String) z.get(".adxml.adCanvasInfo.shareDesc"), ""));
                }
            }
            i = 4;
            if (nVar.xb(32)) {
                b bAF = nVar.bAF();
                wa waVar = new wa();
                waVar.dyL = bi.oW(ate.rVP) ? bAJ.spZ : ate.rVP;
                waVar.rBq = ate.oig;
                waVar.dyJ = ate.rVL;
                waVar.dyP = bAJ.sqh.dyP;
                waVar.dyQ = bAJ.sqh.dyQ;
                if (bi.oW(waVar.dyQ)) {
                    waVar.dyQ = bAJ.ksA;
                }
                waVar.dyO = bi.oW(ate.rVO) ? ate.rVE : ate.rVO;
                if (bAF != null && bAF.nyL == 0) {
                    waVar.dyN = bAF.nyN;
                    waVar.dyM = bAF.nyM;
                }
                vxVar.a(waVar);
                i2 = 16;
                i = 15;
            } else {
                i2 = 4;
            }
            vxVar.CF(i);
            com.tencent.mm.plugin.sight.base.a Lo = d.Lo(vxVar.rzM);
            if (Lo != null) {
                vxVar.CE(Lo.bvB());
            } else {
                vxVar.CE(1);
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(vxVar);
            wlVar.ar(linkedList);
            chVar.bJF.bJH = wlVar;
            chVar.bJF.type = i2;
            a(vxVar, nVar);
            x.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            return true;
        } else {
            x.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + FileOp.cn(s + j) + " thumb:" + FileOp.cn(s + e));
            chVar.bJF.bJL = j.favorite_fail_sns_sight;
            return false;
        }
    }

    public static boolean a(ch chVar, String str, String str2) {
        if (chVar == null || !v.NG(str2) || str == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (chVar != null) {
                chVar.bJF.bJL = j.favorite_fail_argument_error;
            }
            return false;
        } else if (af.bxX()) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            chVar.bJF.bJL = j.favorite_fail_system_error;
            return false;
        } else {
            n Nl = h.Nl(str2);
            if (Nl == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                chVar.bJF.bJL = j.favorite_fail_attachment_not_exists;
                return false;
            } else if (Nl.bAJ().sqc != null && Nl.bAJ().sqc.ruz == 26) {
                return b(chVar, str2);
            } else {
                xa xaVar;
                String str3 = "0";
                ate a = aj.a(Nl, 0);
                if (a != null) {
                    str3 = a.ksA;
                }
                String eF = i.eF(Nl.field_snsId);
                str3 = String.format("%s#%s", new Object[]{eF, str3});
                wl wlVar = new wl();
                wr wrVar = new wr();
                x.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", new Object[]{Nl.field_userName});
                wrVar.Vw(Nl.field_userName);
                wrVar.Vx(q.GF());
                wrVar.CO(2);
                wrVar.fU(((long) Nl.field_createTime) * 1000);
                wrVar.VB(Nl.bAK());
                wrVar.Vy(str3);
                wrVar.VD(str);
                vx vxVar = new vx();
                vxVar.UT(str3);
                if (a != null) {
                    str3 = an.s(af.getAccSnsPath(), a.ksA) + i.e(a);
                    if (FileOp.cn(str3)) {
                        vxVar.UQ(str3);
                    } else {
                        vxVar.kY(true);
                        vxVar.UK(a.rVE);
                        xaVar = new xa();
                        xaVar.VM(a.rVE);
                        wlVar.b(xaVar);
                    }
                } else {
                    vxVar.kY(true);
                }
                vxVar.CF(5);
                bsu bAJ = Nl.bAJ();
                vxVar.UB(bAJ.sqc.bHD);
                vxVar.UC(bAJ.sqc.jOS);
                vxVar.Va(bAJ.ogR);
                if (!bi.oW(bAJ.ogR)) {
                    Map z = bl.z(bAJ.ogR, "adxml");
                    if (z.size() > 0) {
                        vxVar.UB(bi.aG((String) z.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        vxVar.UC(bi.aG((String) z.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
                a(vxVar, bAJ);
                vxVar.kX(true);
                wlVar.rBI.add(vxVar);
                xaVar = new xa();
                xaVar.CQ(bAJ.dwt);
                wlVar.b(xaVar);
                wlVar.a(wrVar);
                chVar.bJF.bJH = wlVar;
                chVar.bJF.desc = bAJ.sqc.bHD;
                chVar.bJF.type = 5;
                return true;
            }
        }
    }

    public static boolean a(ch chVar, String str, CharSequence charSequence) {
        if (v.NH(str) || charSequence == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
            chVar.bJF.bJL = j.favorite_fail_argument_error;
            return false;
        } else if (af.bxX()) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            chVar.bJF.bJL = j.favorite_fail_system_error;
            return false;
        } else {
            n Nl = af.byo().Nl(str);
            if (Nl == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                chVar.bJF.bJL = j.favorite_fail_attachment_not_exists;
                return false;
            } else if (0 == Nl.field_snsId) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
                chVar.bJF.bJL = j.favorite_fail;
                return false;
            } else {
                String eF = i.eF(Nl.field_snsId);
                eF = String.format("%s#0", new Object[]{eF});
                wl wlVar = new wl();
                wr wrVar = new wr();
                x.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", new Object[]{Nl.field_userName});
                wrVar.Vw(Nl.field_userName);
                wrVar.Vx(q.GF());
                wrVar.CO(2);
                wrVar.fU(((long) Nl.field_createTime) * 1000);
                wrVar.VB(Nl.bAK());
                wrVar.Vy(eF);
                wlVar.a(wrVar);
                chVar.bJF.bJH = wlVar;
                chVar.bJF.desc = charSequence.toString();
                chVar.bJF.type = 1;
                return true;
            }
        }
    }

    public static boolean a(ch chVar, n nVar, String str) {
        if (chVar == null || bi.oW(str)) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
            if (chVar != null) {
                chVar.bJF.bJL = j.favorite_fail_argument_error;
            }
            return false;
        } else if (nVar == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
            chVar.bJF.bJL = j.favorite_fail_attachment_not_exists;
            return false;
        } else {
            ate a = aj.a(nVar, str);
            if (a == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
                chVar.bJF.bJL = j.favorite_fail_attachment_not_exists;
                return false;
            }
            String eF = i.eF(nVar.field_snsId);
            eF = String.format("%s#%s", new Object[]{eF, str});
            wl wlVar = new wl();
            wr wrVar = new wr();
            vx vxVar = new vx();
            x.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", new Object[]{nVar.field_userName});
            wrVar.Vw(nVar.field_userName);
            wrVar.Vx(q.GF());
            wrVar.CO(2);
            wrVar.fU(((long) nVar.field_createTime) * 1000);
            wrVar.VB(nVar.bAK());
            wrVar.Vy(eF);
            vxVar.UT(eF);
            vxVar.UP(an.s(af.getAccSnsPath(), str) + i.l(a));
            if (nVar.bAJ() != null) {
                vxVar.Va(nVar.bAJ().ogR);
                if (!bi.oW(nVar.bAJ().ogR)) {
                    Map z = bl.z(nVar.bAJ().ogR, "adxml");
                    if (z.size() > 0) {
                        vxVar.UB(bi.aG((String) z.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        vxVar.UC(bi.aG((String) z.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
            }
            a(vxVar, nVar);
            eF = an.s(af.getAccSnsPath(), a.ksA) + i.e(a);
            if (FileOp.cn(vxVar.rzM) || !nVar.field_userName.endsWith(af.bxU())) {
                if (FileOp.cn(eF)) {
                    vxVar.UQ(eF);
                } else {
                    vxVar.kY(true);
                    vxVar.UK(a.rVE);
                    xa xaVar = new xa();
                    xaVar.VM(a.rVE);
                    wlVar.b(xaVar);
                }
                vxVar.CF(2);
                wlVar.rBI.add(vxVar);
                wlVar.a(wrVar);
                chVar.bJF.bJH = wlVar;
                chVar.bJF.type = 2;
                return true;
            }
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
            chVar.bJF.bJL = j.favorite_fail_attachment_not_exists;
            return false;
        }
    }

    public static boolean a(ch chVar, String str, int i) {
        if (v.NH(str) || i < 0) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
            chVar.bJF.bJL = j.favorite_fail_argument_error;
            return false;
        } else if (af.bxX()) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            chVar.bJF.bJL = j.favorite_fail_system_error;
            return false;
        } else {
            n Nl = af.byo().Nl(str);
            if (Nl == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                chVar.bJF.bJL = j.favorite_fail_attachment_not_exists;
                return false;
            }
            ate a = aj.a(Nl, i);
            if (a != null) {
                return a(chVar, Nl, a.ksA);
            }
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, media obj is null");
            chVar.bJF.bJL = j.favorite_fail_attachment_not_exists;
            return false;
        }
    }

    private static void a(vx vxVar, bsu bsu) {
        if (vxVar != null && bsu != null && !bi.oW(bsu.nNV)) {
            vxVar.UZ(bsu.nNV);
        }
    }

    public static void a(vx vxVar, n nVar) {
        if (nVar != null) {
            a(vxVar, nVar.bAJ());
        }
    }

    public static boolean b(ch chVar, String str) {
        int i = 0;
        if (chVar == null || !v.NG(str)) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (chVar == null) {
                return false;
            }
            chVar.bJF.bJL = j.favorite_fail_argument_error;
            return false;
        } else if (af.bxX()) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            chVar.bJF.bJL = j.favorite_fail_system_error;
            return false;
        } else {
            n Nl = h.Nl(str);
            if (Nl == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                chVar.bJF.bJL = j.favorite_fail_attachment_not_exists;
                return false;
            }
            String str2 = "0";
            ate a = aj.a(Nl, 0);
            if (a != null) {
                str2 = a.ksA;
            }
            str2 = String.format("%s#%s", new Object[]{i.eF(Nl.field_snsId), str2});
            wr wrVar = new wr();
            bsu bAJ = Nl.bAJ();
            if (bAJ == null) {
                x.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
                return false;
            }
            x.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", new Object[]{Nl.field_userName});
            wrVar.Vw(Nl.field_userName);
            wrVar.Vx(q.GF());
            wrVar.CO(2);
            wrVar.fU(((long) Nl.field_createTime) * 1000);
            wrVar.VB(Nl.bAK());
            wrVar.Vy(str2);
            fz fzVar = new fz();
            fzVar.bOL.type = 30;
            fzVar.bOL.bOS = 4;
            fzVar.bOL.desc = bAJ.sqc.ruC;
            com.tencent.mm.sdk.b.a.sFg.m(fzVar);
            fzVar.bOL.bJH.a(wrVar);
            chVar.bJF.bJH = fzVar.bOL.bJH;
            if (chVar.bJF.bJH != null) {
                LinkedList linkedList = chVar.bJF.bJH.rBI;
                if (linkedList != null) {
                    while (i < linkedList.size()) {
                        vx vxVar = (vx) linkedList.get(i);
                        if (vxVar != null) {
                            vxVar.kX(true);
                            vxVar.kY(true);
                        }
                        i++;
                    }
                }
            }
            chVar.bJF.desc = bAJ.sqc.bHD;
            chVar.bJF.type = 18;
            return true;
        }
    }
}
