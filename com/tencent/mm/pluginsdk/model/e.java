package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.aa.j;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.k.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.wz;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g$a;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class e {
    public static boolean a(ch chVar, Intent intent) {
        if (chVar == null) {
            x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
            return false;
        }
        double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
        int intExtra = intent.getIntExtra("kwebmap_scale", 0);
        String aG = bi.aG(intent.getStringExtra("Kwebmap_locaion"), "");
        String stringExtra = intent.getStringExtra("kPoiName");
        intent.getCharSequenceExtra("kRemark");
        intent.getStringArrayListExtra("kTags");
        we weVar = new we();
        weVar.Vn(aG);
        weVar.z(doubleExtra);
        weVar.y(doubleExtra2);
        weVar.CK(intExtra);
        weVar.Vo(stringExtra);
        wl wlVar = new wl();
        wr wrVar = new wr();
        String GF = q.GF();
        wrVar.Vw(GF);
        wrVar.Vx(GF);
        wrVar.CO(6);
        wrVar.fU(bi.VF());
        wlVar.b(weVar);
        wlVar.a(wrVar);
        chVar.bJF.bJH = wlVar;
        chVar.bJF.type = 6;
        return true;
    }

    public static boolean a(ch chVar, int i, String str, String str2, String str3) {
        if (bi.oW(str)) {
            x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            chVar.bJF.bJL = R.l.favorite_fail_argument_error;
            return false;
        }
        x.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[]{str2, str3, str, Integer.valueOf(i)});
        if (new File(str).length() > ((long) b.AB())) {
            chVar.bJF.bJL = R.l.favorite_too_large;
            return false;
        }
        wl wlVar = new wl();
        wr wrVar = new wr();
        vx vxVar = new vx();
        vxVar.UP(str);
        vxVar.CF(8);
        vxVar.UL(com.tencent.mm.a.e.cp(str));
        vxVar.kY(true);
        vxVar.UB(str2);
        vxVar.UC(str3);
        wrVar.Vw(q.GF());
        wrVar.Vx(q.GF());
        wrVar.CO(i);
        wrVar.fU(bi.VF());
        wlVar.a(wrVar);
        wlVar.rBI.add(vxVar);
        chVar.bJF.title = vxVar.title;
        chVar.bJF.desc = vxVar.title;
        chVar.bJF.bJH = wlVar;
        chVar.bJF.type = 8;
        return true;
    }

    public static boolean b(ch chVar, String str, int i) {
        if (bi.oW(str)) {
            x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            chVar.bJF.bJL = R.l.favorite_fail_argument_error;
            return false;
        }
        x.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple text), %s, sourceType %d", new Object[]{str, Integer.valueOf(i)});
        wl wlVar = new wl();
        wr wrVar = new wr();
        wrVar.Vw(q.GF());
        wrVar.Vx(q.GF());
        wrVar.CO(i);
        wrVar.fU(bi.VF());
        wlVar.a(wrVar);
        chVar.bJF.desc = str;
        chVar.bJF.bJH = wlVar;
        chVar.bJF.type = 1;
        return true;
    }

    public static boolean a(ch chVar, int i, String str) {
        if (chVar == null || bi.oW(str)) {
            x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            if (chVar == null) {
                return false;
            }
            chVar.bJF.bJL = R.l.favorite_fail_argument_error;
            return false;
        }
        x.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[]{str, Integer.valueOf(i)});
        wl wlVar = new wl();
        wr wrVar = new wr();
        vx vxVar = new vx();
        vxVar.CF(2);
        vxVar.UP(str);
        vxVar.UO(g.u((vxVar.toString() + 2 + System.currentTimeMillis()).getBytes()));
        fz fzVar = new fz();
        fzVar.bOL.type = 27;
        fzVar.bOL.bON = vxVar;
        a.sFg.m(fzVar);
        String str2 = fzVar.bOM.bOX;
        c.c(str, 150, 150, CompressFormat.JPEG, 90, str2);
        vxVar.UQ(str2);
        wrVar.Vw(q.GF());
        wrVar.Vx(q.GF());
        wrVar.CO(i);
        wrVar.fU(bi.VF());
        wlVar.a(wrVar);
        wlVar.rBI.add(vxVar);
        chVar.bJF.title = vxVar.title;
        chVar.bJF.bJH = wlVar;
        chVar.bJF.type = 2;
        return true;
    }

    public static boolean a(ch chVar, long j) {
        return a(chVar, ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().dW(j));
    }

    public static boolean a(ch chVar, bd bdVar) {
        boolean z = false;
        boolean z2 = true;
        if (chVar == null || bdVar == null) {
            x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
            if (chVar != null) {
                chVar.bJF.bJL = R.l.favorite_fail_argument_error;
            }
        } else {
            bd al = bd.al(bdVar);
            wl wlVar;
            vx vxVar;
            LinkedList linkedList;
            vx vxVar2;
            String E;
            if (al.isText()) {
                wlVar = new wl();
                wlVar.a(ab(al));
                chVar.bJF.bJH = wlVar;
                chVar.bJF.desc = al.field_content;
                chVar.bJF.type = 1;
                if (com.tencent.mm.ui.tools.g.abd(chVar.bJF.desc) > b.Ax()) {
                    chVar.bJF.bJL = R.l.favorite_text_length_over_limit;
                } else {
                    z = true;
                }
            } else if (al.ckz()) {
                wl wlVar2 = new wl();
                wlVar2.a(ab(al));
                vxVar = new vx();
                a(vxVar, al);
                if (s.hB(al.field_talker)) {
                    String b = h.b(com.tencent.mm.plugin.record.b.Ge(), "recbiz_", al.field_imgPath, ".rec", 2);
                    if (bi.oW(b)) {
                        b = null;
                    } else {
                        new File(b).exists();
                    }
                    vxVar.UP(b);
                } else {
                    vxVar.UP(com.tencent.mm.modelvoice.q.getFullPath(al.field_imgPath));
                }
                vxVar.CF(3);
                vxVar.kY(true);
                com.tencent.mm.modelvoice.b ok = com.tencent.mm.modelvoice.q.ok(al.field_imgPath);
                if (ok != null) {
                    vxVar.UL(BC(ok.getFormat()));
                    vxVar.CE((int) new n(al.field_content).time);
                    linkedList = new LinkedList();
                    linkedList.add(vxVar);
                    wlVar2.ar(linkedList);
                    chVar.bJF.bJH = wlVar2;
                    chVar.bJF.type = 3;
                    z = true;
                }
            } else if (al.aQo()) {
                z = b(chVar, al);
            } else if (al.ckA()) {
                com.tencent.mm.ak.e eVar = null;
                if (al.field_msgId > 0) {
                    eVar = o.Pf().br(al.field_msgId);
                }
                if ((eVar == null || eVar.dTK <= 0) && al.field_msgSvrId > 0) {
                    eVar = o.Pf().bq(al.field_msgSvrId);
                }
                if (eVar == null) {
                    x.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
                    chVar.bJF.bJL = R.l.favorite_fail_image_not_exists;
                } else {
                    wl wlVar3 = new wl();
                    wlVar3.a(ab(al));
                    vxVar2 = new vx();
                    a(vxVar2, al);
                    vxVar2.CF(2);
                    vxVar2.UP(o.Pf().o(f.c(eVar), "", ""));
                    if (eVar.ON()) {
                        eVar = o.Pf().hQ(eVar.dTU);
                        if (eVar.dHI > eVar.offset) {
                            vxVar2.UP(o.Pf().o("SERVERID://" + al.field_msgSvrId, "", ""));
                        }
                    }
                    vxVar2.UQ(o.Pf().E(al.field_imgPath, true));
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(vxVar2);
                    wlVar3.ar(linkedList2);
                    chVar.bJF.bJH = wlVar3;
                    chVar.bJF.type = 2;
                    z = true;
                }
            } else if (al.cmj() || al.cmk()) {
                wlVar = new wl();
                wlVar.a(ab(al));
                vxVar2 = new vx();
                a(vxVar2, al);
                com.tencent.mm.modelvideo.o.Ta();
                vxVar2.UQ(com.tencent.mm.modelvideo.s.nL(al.field_imgPath));
                vxVar2.UL(com.tencent.mm.a.e.cp(vxVar2.rzM));
                r nW = t.nW(al.field_imgPath);
                x.i("MicroMsg.GetFavDataSource", "video length is %d", new Object[]{Integer.valueOf(nW.dHI)});
                if (nW.dHI > b.AB()) {
                    chVar.bJF.bJL = R.l.favorite_too_large;
                } else if (al.cmk() && t.nY(nW.getFileName())) {
                    chVar.bJF.bJL = R.l.favorite_fail;
                } else {
                    if (nW.Tp()) {
                        com.tencent.mm.modelvideo.o.Ta();
                        x.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", new Object[]{com.tencent.mm.modelvideo.s.nK(al.field_imgPath)});
                        vxVar2.UP(E);
                    } else {
                        x.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
                        vxVar2.UP("");
                    }
                    vxVar2.CE(nW.enM);
                    linkedList = new LinkedList();
                    linkedList.add(vxVar2);
                    wlVar.ar(linkedList);
                    chVar.bJF.bJH = wlVar;
                    if (al.cmk()) {
                        chVar.bJF.type = 16;
                        vxVar2.CF(15);
                    } else {
                        chVar.bJF.type = 4;
                        vxVar2.CF(4);
                    }
                    r nW2 = t.nW(al.field_imgPath);
                    vxVar2.UZ(nW2.bZN);
                    bri bri = nW2.enV;
                    if (!(bri == null || bi.oW(bri.dyP))) {
                        wa waVar = new wa();
                        waVar.dyJ = bri.dyJ;
                        waVar.rBq = bri.rBq;
                        waVar.dyM = bri.dyM;
                        waVar.dyN = bri.dyN;
                        waVar.dyL = bri.dyL;
                        waVar.dyO = bri.dyO;
                        waVar.dyP = bri.dyP;
                        waVar.dyQ = bri.dyQ;
                        vxVar2.a(waVar);
                    }
                    z = true;
                }
            } else if (al.cky()) {
                z = c(chVar, al);
            } else if (al.cmi() || !al.aQm() || al.cmm()) {
                chVar.bJF.bJL = R.l.favorite_fail_nonsupport;
            } else {
                wlVar = new wl();
                wlVar.a(ab(al));
                String str = al.field_content;
                if (str != null) {
                    g$a gp = g$a.gp(str);
                    if (gp != null) {
                        chVar.bJF.bJH = wlVar;
                        wr wrVar = wlVar.rBG;
                        wrVar.VC(gp.appId);
                        wrVar.VE(gp.bZG);
                        com.tencent.mm.pluginsdk.model.app.b SR;
                        String E2;
                        vx a;
                        wk wkVar;
                        switch (gp.type) {
                            case 1:
                                chVar.bJF.bJH = wlVar;
                                chVar.bJF.desc = gp.title;
                                chVar.bJF.type = 1;
                                break;
                            case 2:
                                if (!com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
                                    chVar.bJF.bJL = R.l.favorite_fail_sdcard_not_available;
                                    z2 = false;
                                    break;
                                }
                                SR = com.tencent.mm.plugin.ac.a.asF().SR(gp.bGP);
                                vxVar = new vx();
                                a(vxVar, al);
                                if (SR != null) {
                                    vxVar.UP(SR.field_fileFullPath);
                                }
                                E2 = o.Pf().E(al.field_imgPath, true);
                                if (com.tencent.mm.a.e.cn(E2)) {
                                    vxVar.UQ(E2);
                                }
                                vxVar.CF(2);
                                vxVar.UB(gp.title);
                                vxVar.UC(gp.description);
                                wlVar.rBI.add(vxVar);
                                chVar.bJF.type = 2;
                                break;
                            case 3:
                                wlVar.rBI.add(a(al, gp, 7));
                                chVar.bJF.type = 7;
                                break;
                            case 4:
                                a = a(al, gp, 4);
                                wlVar.Vu(a.title);
                                wlVar.Vv(a.desc);
                                wlVar.rBI.add(a);
                                chVar.bJF.type = 4;
                                break;
                            case 5:
                                if (gp.url != null && !gp.url.equals("")) {
                                    wlVar.rBG.VD(gp.url);
                                    a = a(al, gp, 5);
                                    wlVar.rBI.add(a);
                                    wlVar.Vu(a.title);
                                    wlVar.Vv(a.desc);
                                    chVar.bJF.type = 5;
                                    break;
                                }
                                chVar.bJF.bJL = R.l.favorite_fail_empty_url;
                                z2 = false;
                                break;
                            case 6:
                                if (!com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
                                    chVar.bJF.bJL = R.l.favorite_fail_sdcard_not_available;
                                    z2 = false;
                                    break;
                                }
                                SR = com.tencent.mm.plugin.ac.a.asF().SR(gp.bGP);
                                vxVar = new vx();
                                if (SR != null) {
                                    vxVar.UP(SR.field_fileFullPath);
                                }
                                a(vxVar, al);
                                vxVar.CF(8);
                                vxVar.UL(gp.dwp);
                                E2 = o.Pf().E(al.field_imgPath, true);
                                if (bi.oW(E2)) {
                                    vxVar.kY(true);
                                }
                                if (com.tencent.mm.a.e.cn(E2)) {
                                    vxVar.UQ(E2);
                                }
                                vxVar.UB(gp.title);
                                vxVar.UC(gp.description);
                                wlVar.rBI.add(vxVar);
                                chVar.bJF.desc = gp.title;
                                chVar.bJF.type = 8;
                                break;
                            case 7:
                                if (gp.bGP != null && gp.bGP.length() != 0) {
                                    if (!com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
                                        chVar.bJF.bJL = R.l.favorite_fail_sdcard_not_available;
                                        z2 = false;
                                        break;
                                    }
                                }
                                chVar.bJF.bJL = R.l.favorite_fail_attachment_not_exists;
                                chVar.bJF.bJL = R.l.favorite_fail_nonsupport;
                                z2 = false;
                                break;
                            case 10:
                                wkVar = new wk();
                                wkVar.Vp(gp.title);
                                wkVar.Vq(gp.description);
                                wkVar.CL(gp.dwR);
                                wkVar.Vs(gp.dwS);
                                wkVar.Vr(gp.thumburl);
                                chVar.bJF.title = gp.title;
                                chVar.bJF.desc = gp.description;
                                chVar.bJF.type = 10;
                                wlVar.b(wkVar);
                                break;
                            case 13:
                                wkVar = new wk();
                                wkVar.Vp(gp.title);
                                wkVar.Vq(gp.description);
                                wkVar.CL(gp.dwX);
                                wkVar.Vs(gp.dwY);
                                wkVar.Vr(gp.thumburl);
                                chVar.bJF.title = gp.title;
                                chVar.bJF.desc = gp.description;
                                chVar.bJF.type = 11;
                                wlVar.b(wkVar);
                                break;
                            case 19:
                            case 24:
                                chVar.bJF.bJI = new wz();
                                z2 = a(chVar, gp, wlVar, al);
                                break;
                            case 20:
                                wu wuVar = new wu();
                                wuVar.VF(gp.title);
                                wuVar.VG(gp.description);
                                wuVar.VI(gp.dwV);
                                wuVar.VH(gp.thumburl);
                                chVar.bJF.title = gp.title;
                                chVar.bJF.desc = gp.description;
                                chVar.bJF.type = 15;
                                wlVar.b(wuVar);
                                break;
                            case 33:
                            case 36:
                                vv vvVar = new vv();
                                vvVar.username = gp.dyS;
                                vvVar.appId = gp.dyT;
                                vvVar.bPh = gp.dyW;
                                vvVar.iconUrl = gp.dzb;
                                vvVar.bGH = gp.dyR;
                                vvVar.rzd = gp.bZH;
                                vxVar = new vx();
                                a(vxVar, al);
                                vxVar.CF(19);
                                E = o.Pf().E(al.field_imgPath, true);
                                if (bi.oW(E)) {
                                    vxVar.kY(true);
                                }
                                if (com.tencent.mm.a.e.cn(E)) {
                                    vxVar.UQ(E);
                                }
                                vxVar.UB(gp.title);
                                vxVar.UC(gp.description);
                                wlVar.rBI.add(vxVar);
                                chVar.bJF.title = gp.title;
                                chVar.bJF.desc = gp.description;
                                chVar.bJF.type = 19;
                                wlVar.rBa = vvVar;
                                wlVar.rBb = true;
                                break;
                            default:
                                chVar.bJF.bJL = R.l.favorite_fail_nonsupport;
                                z2 = false;
                                break;
                        }
                    }
                    chVar.bJF.bJL = R.l.favorite_fail_parse_error;
                    z2 = false;
                } else {
                    chVar.bJF.bJL = R.l.favorite_fail_parse_error;
                    z2 = false;
                }
                z = z2;
            }
            chVar.bJF.bJv = al.field_content;
            if (z || chVar.bJF.bJL == 0) {
                com.tencent.mm.plugin.fav.ui.c.a(al, chVar, z);
            }
        }
        return z;
    }

    private static wr ab(bd bdVar) {
        wr wrVar = new wr();
        if (bdVar.field_isSend == 1) {
            wrVar.Vw(q.GF());
            wrVar.Vx(bdVar.field_talker);
            if (s.fq(bdVar.field_talker)) {
                wrVar.Vz(wrVar.bSS);
            }
        } else {
            wrVar.Vw(bdVar.field_talker);
            wrVar.Vx(q.GF());
            if (s.fq(bdVar.field_talker)) {
                wrVar.Vz(bdVar.field_content != null ? bdVar.field_content.substring(0, Math.max(0, bdVar.field_content.indexOf(58))) : "");
                if (!(bi.oW(wrVar.rBh) || bdVar.ckz())) {
                    bdVar.setContent(bdVar.field_content.substring(wrVar.rBh.length() + 1));
                    if (bdVar.field_content.length() > 0 && 10 == bdVar.field_content.charAt(0)) {
                        bdVar.setContent(bdVar.field_content.substring(1));
                    }
                    if (bdVar.cmt()) {
                        bdVar.es(bdVar.field_transContent.substring(wrVar.rBh.length() + 1));
                        if (bdVar.field_transContent.length() > 0 && 10 == bdVar.field_transContent.charAt(0)) {
                            bdVar.es(bdVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        }
        wrVar.CO(1);
        wrVar.fU(bdVar.field_createTime);
        wrVar.VA(bdVar.field_msgSvrId);
        if (bdVar.field_msgSvrId > 0) {
            wrVar.Vy(bdVar.field_msgSvrId);
        }
        return wrVar;
    }

    private static boolean b(ch chVar, bd bdVar) {
        wl wlVar = new wl();
        wlVar.a(ab(bdVar));
        Map z = bl.z(bdVar.field_content, "msg");
        if (z != null) {
            try {
                we weVar = new we();
                weVar.Vn((String) z.get(".msg.location.$label"));
                weVar.z(Double.parseDouble((String) z.get(".msg.location.$x")));
                weVar.y(Double.parseDouble((String) z.get(".msg.location.$y")));
                weVar.CK(Integer.valueOf((String) z.get(".msg.location.$scale")).intValue());
                weVar.Vo((String) z.get(".msg.location.$poiname"));
                wlVar.b(weVar);
                chVar.bJF.type = 6;
                chVar.bJF.bJH = wlVar;
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.GetFavDataSource", "parse failed, %s", new Object[]{e.getStackTrace().toString()});
            }
        }
        chVar.bJF.bJL = R.l.favorite_fail_parse_error;
        return false;
    }

    private static void a(vx vxVar, bd bdVar) {
        if (bdVar.field_isSend != 1) {
            vxVar.UT(String.valueOf(bdVar.field_msgSvrId));
        } else if (s.fq(bdVar.field_talker) || bdVar.field_talker.equals("filehelper")) {
            vxVar.UT(String.valueOf(bdVar.field_msgSvrId));
        } else {
            vxVar.UT(bdVar.field_talker + "#" + String.valueOf(bdVar.field_msgSvrId));
        }
    }

    public static String BC(int i) {
        if (i == 1) {
            return "speex";
        }
        if (i == 4) {
            return "silk";
        }
        return "amr";
    }

    private static vx a(bd bdVar, g$a g_a, int i) {
        vx vxVar = new vx();
        a(vxVar, bdVar);
        vxVar.UI(g_a.dwN);
        vxVar.UJ(g_a.dwO);
        vxVar.UH(g_a.url);
        vxVar.kX(true);
        File file = new File(bi.aG(o.Pf().E(bdVar.field_imgPath, true), ""));
        if (file.exists()) {
            vxVar.UQ(file.getAbsolutePath());
        } else {
            vxVar.kY(true);
        }
        vxVar.UB(g_a.title);
        vxVar.UC(g_a.description);
        vxVar.Va(g_a.canvasPageXml);
        vxVar.CF(i);
        vxVar.UZ(g_a.bZN);
        return vxVar;
    }

    private static boolean c(ch chVar, bd bdVar) {
        wl wlVar = new wl();
        wr ab = ab(bdVar);
        wlVar.a(ab);
        try {
            l wS = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.biz.a.a.class)).wS(bdVar.field_content);
            List list = wS.dzs;
            ab.VE(wS.bZG);
            if (list != null && list.size() > chVar.bJF.bJJ) {
                x.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", new Object[]{Integer.valueOf(chVar.bJF.bJJ)});
                m mVar = (m) list.get(chVar.bJF.bJJ);
                if (com.tencent.mm.y.i.gr(mVar.dzD)) {
                    chVar.bJF.bJL = R.l.favorite_fail_nonsupport;
                    return false;
                }
                String Kx;
                ab.VD(mVar.url);
                if (chVar.bJF.bJJ > 0) {
                    ab.Vy("");
                }
                vx vxVar = new vx();
                vxVar.UB(mVar.title);
                vxVar.UC(mVar.dzA);
                a(vxVar, bdVar);
                String str = mVar.dzy;
                if (bi.oW(str)) {
                    j kc = com.tencent.mm.aa.q.KH().kc(bdVar.field_talker);
                    if (kc != null) {
                        Kx = kc.Kx();
                        if (bi.oW(Kx)) {
                            vxVar.UQ(q.v(Kx, bdVar.getType(), chVar.bJF.bJJ > 0 ? "@S" : "@T"));
                            vxVar.kY(false);
                            if (bi.oW(vxVar.rzO) || !FileOp.cn(vxVar.rzO)) {
                                vxVar.UK(Kx);
                                vxVar.kY(true);
                                xa xaVar = new xa();
                                xaVar.VM(Kx);
                                wlVar.b(xaVar);
                            }
                        } else {
                            vxVar.kY(true);
                        }
                        vxVar.kX(true);
                        vxVar.CF(5);
                        wlVar.rBI.add(vxVar);
                        chVar.bJF.bJH = wlVar;
                        chVar.bJF.desc = mVar.title;
                        chVar.bJF.type = 5;
                        return true;
                    }
                }
                Kx = str;
                if (bi.oW(Kx)) {
                    vxVar.kY(true);
                } else {
                    vxVar.UQ(q.v(Kx, bdVar.getType(), chVar.bJF.bJJ > 0 ? "@S" : "@T"));
                    vxVar.kY(false);
                    if (bi.oW(vxVar.rzO) || !FileOp.cn(vxVar.rzO)) {
                        vxVar.UK(Kx);
                        vxVar.kY(true);
                        xa xaVar2 = new xa();
                        xaVar2.VM(Kx);
                        wlVar.b(xaVar2);
                    }
                }
                vxVar.kX(true);
                vxVar.CF(5);
                wlVar.rBI.add(vxVar);
                chVar.bJF.bJH = wlVar;
                chVar.bJF.desc = mVar.title;
                chVar.bJF.type = 5;
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GetFavDataSource", e, "", new Object[0]);
            x.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", new Object[]{e.getLocalizedMessage()});
        }
        chVar.bJF.bJL = R.l.favorite_fail_parse_error;
        return false;
    }

    private static boolean a(ch chVar, g$a g_a, wl wlVar, bd bdVar) {
        mw mwVar = new mw();
        mwVar.bXL.type = 0;
        mwVar.bXL.bXN = g_a.dwW;
        a.sFg.m(mwVar);
        com.tencent.mm.protocal.b.a.c cVar = mwVar.bXM.bXV;
        if (cVar == null) {
            x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
            chVar.bJF.bJL = R.l.favorite_fail_parse_error;
            return false;
        }
        int i = 0;
        wlVar.Vu(cVar.title);
        Iterator it = cVar.dzs.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                vx vxVar;
                vx vxVar2 = (vx) it.next();
                vx p;
                wz wzVar;
                long j;
                mw mwVar2;
                wz wzVar2;
                switch (vxVar2.bjS) {
                    case 1:
                        p = p(vxVar2);
                        p.CF(1);
                        p.UC(vxVar2.desc);
                        wzVar = chVar.bJF.bJI;
                        wzVar.rBY++;
                        vxVar = p;
                        break;
                    case 2:
                        j = bdVar.field_msgId;
                        p = p(vxVar2);
                        p.CF(2);
                        mwVar2 = new mw();
                        mwVar2.bXL.type = 1;
                        mwVar2.bXL.bOz = vxVar2;
                        mwVar2.bXL.bJC = j;
                        a.sFg.m(mwVar2);
                        if (bi.oW(mwVar2.bXM.bXW) && bi.oW(mwVar2.bXM.bOX)) {
                            x.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
                        }
                        p.UP(mwVar2.bXM.bXW);
                        p.UQ(mwVar2.bXM.bOX);
                        p.kY(false);
                        p.kX(false);
                        wzVar = chVar.bJF.bJI;
                        wzVar.rBZ++;
                        vxVar = p;
                        break;
                    case 3:
                        j = bdVar.field_msgId;
                        p = p(vxVar2);
                        p.CF(3);
                        if (!bi.oW(vxVar2.rAq)) {
                            mwVar2 = new mw();
                            mwVar2.bXL.type = 1;
                            mwVar2.bXL.bOz = vxVar2;
                            mwVar2.bXL.bJC = j;
                            a.sFg.m(mwVar2);
                            if (bi.oW(mwVar2.bXM.bXW) && bi.oW(mwVar2.bXM.bOX)) {
                                x.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
                            }
                            p.UP(mwVar2.bXM.bXW);
                            p.CE(vxVar2.duration);
                            p.kY(true);
                            p.kX(false);
                            p.UL(vxVar2.rzD);
                        }
                        wzVar = chVar.bJF.bJI;
                        wzVar.rCa++;
                        vxVar = p;
                        break;
                    case 4:
                    case 15:
                        j = bdVar.field_msgId;
                        p = p(vxVar2);
                        a(p, vxVar2);
                        if (vxVar2.bjS == 15) {
                            p.CF(15);
                        } else {
                            p.CF(4);
                        }
                        mwVar2 = new mw();
                        mwVar2.bXL.type = 1;
                        mwVar2.bXL.bOz = vxVar2;
                        mwVar2.bXL.bJC = j;
                        a.sFg.m(mwVar2);
                        if (bi.oW(mwVar2.bXM.bXW) && bi.oW(mwVar2.bXM.bOX)) {
                            x.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
                        }
                        p.kX(false);
                        p.UP(mwVar2.bXM.bXW);
                        p.kY(false);
                        p.UQ(mwVar2.bXM.bOX);
                        p.CE(vxVar2.duration);
                        wzVar = chVar.bJF.bJI;
                        wzVar.rCb++;
                        vxVar = p;
                        break;
                    case 5:
                        j = bdVar.field_msgId;
                        p = p(vxVar2);
                        a(p, vxVar2);
                        p.CF(5);
                        mwVar2 = new mw();
                        mwVar2.bXL.type = 1;
                        mwVar2.bXL.bOz = vxVar2;
                        mwVar2.bXL.bJC = j;
                        a.sFg.m(mwVar2);
                        if (bi.oW(mwVar2.bXM.bXW) && bi.oW(mwVar2.bXM.bOX)) {
                            x.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
                        }
                        p.UQ(mwVar2.bXM.bOX);
                        p.kY(false);
                        if (!(vxVar2.rAi == null || vxVar2.rAi.rAN == null)) {
                            xa xaVar = new xa();
                            xaVar.VJ(vxVar2.rAi.rAN.title);
                            xaVar.VK(vxVar2.rAi.rAN.desc);
                            xaVar.VM(vxVar2.rAi.rAN.thumbUrl);
                            xaVar.CP(vxVar2.rAi.rAN.rCp);
                            xaVar.VL(vxVar2.rAi.rAN.rCn);
                            p.rAi.a(xaVar);
                        }
                        wzVar = chVar.bJF.bJI;
                        wzVar.rCc++;
                        vxVar = p;
                        break;
                    case 6:
                        p = p(vxVar2);
                        p.CF(6);
                        if (!(vxVar2.rAi == null || vxVar2.rAi.rAL == null)) {
                            we weVar = new we();
                            weVar.Vn(vxVar2.rAi.rAL.label);
                            weVar.z(vxVar2.rAi.rAL.lat);
                            weVar.y(vxVar2.rAi.rAL.lng);
                            weVar.CK(vxVar2.rAi.rAL.bSz);
                            weVar.Vo(vxVar2.rAi.rAL.bWB);
                            p.rAi.a(weVar);
                        }
                        wzVar = chVar.bJF.bJI;
                        wzVar.rCd++;
                        vxVar = p;
                        break;
                    case 7:
                        j = bdVar.field_msgId;
                        p = p(vxVar2);
                        a(p, vxVar2);
                        p.CF(7);
                        mwVar2 = new mw();
                        mwVar2.bXL.type = 1;
                        mwVar2.bXL.bOz = vxVar2;
                        mwVar2.bXL.bJC = j;
                        a.sFg.m(mwVar2);
                        if (bi.oW(mwVar2.bXM.bXW) && bi.oW(mwVar2.bXM.bOX)) {
                            x.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
                        }
                        p.UQ(mwVar2.bXM.bOX);
                        p.kY(false);
                        wzVar = chVar.bJF.bJI;
                        wzVar.rCe++;
                        vxVar = p;
                        break;
                    case 8:
                        j = bdVar.field_msgId;
                        p = p(vxVar2);
                        a(p, vxVar2);
                        p.CF(8);
                        mwVar2 = new mw();
                        mwVar2.bXL.type = 1;
                        mwVar2.bXL.bOz = vxVar2;
                        mwVar2.bXL.bJC = j;
                        a.sFg.m(mwVar2);
                        if (bi.oW(mwVar2.bXM.bXW) && bi.oW(mwVar2.bXM.bOX)) {
                            x.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
                        }
                        p.UP(mwVar2.bXM.bXW);
                        p.UQ(mwVar2.bXM.bOX);
                        p.kX(false);
                        p.UL(vxVar2.rzD);
                        wzVar = chVar.bJF.bJI;
                        wzVar.rCf++;
                        vxVar = p;
                        break;
                    case 10:
                        vxVar2 = c(vxVar2, vxVar2.bjS);
                        wzVar2 = chVar.bJF.bJI;
                        wzVar2.rCh++;
                        vxVar = vxVar2;
                        break;
                    case 11:
                        vxVar2 = c(vxVar2, vxVar2.bjS);
                        wzVar2 = chVar.bJF.bJI;
                        wzVar2.rCi++;
                        vxVar = vxVar2;
                        break;
                    case 12:
                    case 14:
                        p = p(vxVar2);
                        p.CF(14);
                        if (!(vxVar2.rAi == null || vxVar2.rAi.rAR == null)) {
                            wu wuVar = new wu();
                            wuVar.VF(vxVar2.rAi.rAR.title);
                            wuVar.VG(vxVar2.rAi.rAR.desc);
                            wuVar.VI(vxVar2.rAi.rAR.info);
                            wuVar.VH(vxVar2.rAi.rAR.thumbUrl);
                            p.rAi.a(wuVar);
                        }
                        wzVar = chVar.bJF.bJI;
                        wzVar.rCl++;
                        vxVar = p;
                        break;
                    case 16:
                        p = p(vxVar2);
                        p.CF(16);
                        p.UC(vxVar2.desc);
                        wzVar = chVar.bJF.bJI;
                        wzVar.rCm++;
                        vxVar = p;
                        break;
                    case 17:
                        p = p(vxVar2);
                        p.UB(vxVar2.title);
                        p.UC(vxVar2.desc);
                        p.CF(17);
                        p.Vb(vxVar2.rAy);
                        vxVar = p;
                        break;
                    case 19:
                        j = bdVar.field_msgId;
                        p = p(vxVar2);
                        p.UB(vxVar2.title);
                        p.UC(vxVar2.desc);
                        p.CF(19);
                        mwVar2 = new mw();
                        mwVar2.bXL.type = 1;
                        mwVar2.bXL.bOz = vxVar2;
                        mwVar2.bXL.bJC = j;
                        a.sFg.m(mwVar2);
                        if (bi.oW(mwVar2.bXM.bOX)) {
                            x.e("MicroMsg.GetFavDataSource", "cloneAppBrandItem:not record plugin ? get paths error");
                        } else {
                            p.kY(false);
                            p.UQ(mwVar2.bXM.bOX);
                        }
                        if (!(vxVar2.rAi == null || vxVar2.rAi.rBa == null)) {
                            vv vvVar = new vv();
                            vvVar.username = vxVar2.rAi.rBa.username;
                            vvVar.appId = vxVar2.rAi.rBa.appId;
                            vvVar.bPh = vxVar2.rAi.rBa.bPh;
                            vvVar.iconUrl = vxVar2.rAi.rBa.iconUrl;
                            vvVar.type = vxVar2.rAi.rBa.type;
                            vvVar.bGH = vxVar2.rAi.rBa.bGH;
                            vvVar.rzd = vxVar2.rAi.rBa.rzd;
                            p.rAi.a(vvVar);
                        }
                        vxVar = p;
                        break;
                    default:
                        vxVar = null;
                        break;
                }
                if (vxVar != null) {
                    String format;
                    int i3 = i2 + 1;
                    if (bdVar.field_isSend != 1) {
                        format = String.format("%d$%d", new Object[]{Long.valueOf(bdVar.field_msgSvrId), Integer.valueOf(i2)});
                    } else if (s.fq(bdVar.field_talker) || bdVar.field_talker.equals("filehelper")) {
                        format = String.format("%d$%d", new Object[]{Long.valueOf(bdVar.field_msgSvrId), Integer.valueOf(i2)});
                    } else {
                        format = String.format("%s#%d$%d", new Object[]{bdVar.field_talker, Long.valueOf(bdVar.field_msgSvrId), Integer.valueOf(i2)});
                    }
                    vxVar.UT(format);
                    wlVar.rBI.add(vxVar);
                    i = i3;
                } else {
                    i = i2;
                }
            } else {
                if (bi.oW(((vx) cVar.dzs.get(0)).rzD) || !((vx) cVar.dzs.get(0)).rzD.equals(".htm")) {
                    chVar.bJF.type = 14;
                } else {
                    chVar.bJF.type = 18;
                }
                return true;
            }
        }
    }

    private static vx p(vx vxVar) {
        vx vxVar2 = new vx();
        vy vyVar = new vy();
        vz vzVar = new vz();
        vz vzVar2 = vxVar.rAi.rAJ;
        if (vzVar2.rBd) {
            vzVar.Vf(vzVar2.bSS);
        }
        if (vzVar2.rBe) {
            vzVar.Vg(vzVar2.toUser);
        }
        if (vzVar2.rBi) {
            vzVar.Vi(vzVar2.rBh);
        }
        vzVar.CJ(1);
        vzVar.fR(bi.VF());
        vyVar.c(vzVar);
        vxVar2.a(vyVar);
        vxVar2.UW(vxVar.rAk);
        vxVar2.UX(vxVar.rAm);
        vxVar2.kY(true);
        vxVar2.kX(true);
        vxVar2.UY(vxVar.rAq);
        vxVar2.CH(vxVar.rAw);
        vxVar2.UM(vxVar.rzF);
        vxVar2.UN(vxVar.rzH);
        vxVar2.fO(vxVar.rzJ);
        vxVar2.UR(vxVar.rzQ);
        vxVar2.US(vxVar.rzS);
        vxVar2.fP(vxVar.rzU);
        return vxVar2;
    }

    private static void a(vx vxVar, vx vxVar2) {
        vxVar.UI(vxVar2.rzx);
        vxVar.UJ(vxVar2.rzz);
        vxVar.UH(vxVar2.rzv);
        vxVar.UB(vxVar2.title);
        vxVar.UC(vxVar2.desc);
    }

    private static vx c(vx vxVar, int i) {
        vx p = p(vxVar);
        p.CF(i);
        if (!(vxVar.rAi == null || vxVar.rAi.rAP == null)) {
            wk wkVar = new wk();
            wkVar.Vp(vxVar.rAi.rAP.title);
            wkVar.Vq(vxVar.rAi.rAP.desc);
            wkVar.CL(vxVar.rAi.rAP.type);
            wkVar.Vs(vxVar.rAi.rAP.info);
            wkVar.Vr(vxVar.rAi.rAP.thumbUrl);
            p.rAi.a(wkVar);
        }
        return p;
    }
}
