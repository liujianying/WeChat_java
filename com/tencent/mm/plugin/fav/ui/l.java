package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.support.design.a$i;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.fz.b;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.protocal.c.wo;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.xf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class l extends c<fz> {
    public l() {
        this.sFo = fz.class.getName().hashCode();
    }

    private static boolean c(fz fzVar) {
        g dy;
        String[] a;
        List arrayList;
        g dy2;
        vx vxVar;
        int i;
        b bVar;
        switch (fzVar.bOL.type) {
            case 2:
                if (fzVar.bOL.bON != null) {
                    com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.b(fzVar.bOL.bON));
                    if (bVar2.exists()) {
                        fzVar.bOM.path = bVar2.cBX().toString();
                    }
                    bVar2 = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(fzVar.bOL.bON));
                    if (bVar2.exists()) {
                        fzVar.bOM.bOX = bVar2.cBX().toString();
                        break;
                    }
                }
                break;
            case 4:
                dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
                if (!(dy == null || dy.field_tagProto.rBX == null)) {
                    fzVar.bOM.auX = new ArrayList();
                    fzVar.bOM.auX.addAll(dy.field_tagProto.rBX);
                    break;
                }
            case 6:
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().c(fzVar.bOL.bOP);
                fzVar.bOM.ret = 0;
                break;
            case 7:
                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().d(fzVar.bOL.bOP);
                fzVar.bOM.ret = 0;
                break;
            case 8:
                fzVar.bOM.bOZ = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().aLz();
                fzVar.bOM.ret = 0;
                break;
            case 9:
                dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
                fzVar.bOM.bOY = com.tencent.mm.plugin.fav.a.b.a(dy.field_type, dy.field_favProto, dy.field_tagProto);
                fzVar.bOM.ret = 0;
                break;
            case 10:
                ((y) com.tencent.mm.kernel.g.l(y.class)).a(fzVar.bOL.context, ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA), fzVar.bOL.bOW);
                fzVar.bOM.ret = 0;
                break;
            case 11:
                a = com.tencent.mm.plugin.fav.a.b.a(((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA), fzVar.bOL.handler);
                fzVar.bOM.bOX = a[0];
                fzVar.bOM.thumbUrl = a[1];
                fzVar.bOM.ret = 0;
                break;
            case 12:
                com.tencent.mm.plugin.fav.a.b.a(fzVar.bOL.bJA, fzVar.bOL.bOQ);
                break;
            case 13:
                dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
                com.tencent.mm.plugin.fav.a.b.q(dy);
                if (dy == null && fzVar.bOL.bJH != null) {
                    dy = com.tencent.mm.plugin.fav.a.b.a(fzVar.bOL.bJH);
                }
                h.a(fzVar.bOL.context, fzVar.bOL.toUser, fzVar.bOL.bOR, dy, fzVar.bOL.bOQ);
                break;
            case 14:
                if (!com.tencent.mm.plugin.fav.a.b.f(fzVar.bOL.bON)) {
                    fzVar.bOM.ret = 0;
                    break;
                }
                fzVar.bOM.ret = 1;
                break;
            case 15:
                com.tencent.mm.plugin.fav.a.b.l(((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA));
                break;
            case 16:
                com.tencent.mm.plugin.fav.a.b.m(((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA));
                break;
            case 17:
                fzVar.bOM.ret = com.tencent.mm.plugin.fav.a.b.Be(fzVar.bOL.bON.rzD);
                break;
            case 18:
                arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(7));
                List<g> a2 = com.tencent.mm.plugin.fav.a.b.a(null, null, arrayList, null, null, null);
                List arrayList2 = new ArrayList();
                for (g dy3 : a2) {
                    wr wrVar = dy3.field_favProto.rBG;
                    vx c;
                    if (dy3.field_type == 7) {
                        c = com.tencent.mm.plugin.fav.a.b.c(dy3);
                        arrayList2.add(((com.tencent.mm.an.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.an.a.b.class)).a(6, null, c.title, c.desc, c.rzv, c.rzz, c.rzx, c.jdM, com.tencent.mm.plugin.fav.a.b.aKV(), k(c), "", wrVar.appId));
                    } else if (dy3.field_type == 14 && dy3.field_favProto.rBI != null) {
                        Iterator it = dy3.field_favProto.rBI.iterator();
                        while (it.hasNext()) {
                            c = (vx) it.next();
                            if (c.bjS == 7) {
                                arrayList2.add(((com.tencent.mm.an.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.an.a.b.class)).a(6, null, c.title, c.desc, c.rzv, c.rzz, c.rzx, c.jdM, com.tencent.mm.plugin.fav.a.b.aKV(), k(c), "", wrVar.appId));
                            }
                        }
                    }
                }
                fzVar.bOM.bPa = arrayList2;
                break;
            case 19:
                if (fzVar.bOL.bJA != -1) {
                    if (fzVar.bOL.bOS != -1) {
                        if (fzVar.bOL.bOS == -3 && fzVar.bOL.bJA > 0) {
                            dy2 = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
                            if (dy2 != null) {
                                dy2.field_itemStatus = fzVar.bOL.bOO.getIntExtra("fav_note_item_status", dy2.field_itemStatus);
                                dy2.field_updateTime = fzVar.bOL.bOO.getLongExtra("fav_note_item_updatetime", dy2.field_updateTime);
                                dy2.Bh(fzVar.bOL.bOO.getStringExtra("fav_note_xml"));
                                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(dy2, new String[]{"localId"});
                                break;
                            }
                        }
                        if (fzVar.bOL.bOS == -2 && fzVar.bOL.bJA > 0) {
                            dy2 = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
                            if (!(dy2 == null || dy2.field_itemStatus != 10 || bi.oW(dy2.field_xml))) {
                                dy2.Bh(dy2.field_xml);
                                if (dy2.field_favProto != null && dy2.field_favProto.rBI.size() > 1) {
                                    vxVar = (vx) dy2.field_favProto.rBI.get(0);
                                    if (!(bi.oW(vxVar.rzo) || bi.oW(vxVar.rzq))) {
                                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(dy2, new String[]{"localId"});
                                        break;
                                    }
                                }
                            }
                        }
                        Intent intent = new Intent();
                        if (fzVar.bOL.bJA > 0 && !bi.oW(fzVar.bOL.desc) && fzVar.bOL.bOS > 0) {
                            dy3 = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
                            if (dy3 != null) {
                                intent.putExtra("fav_note_xml", g.s(dy3));
                                intent.putExtra("fav_note_item_updatetime", dy3.field_updateTime);
                            }
                        }
                        g a3 = g.a(fzVar.bOL.bJH.rBI, fzVar.bOL.bJA);
                        if (!bi.oW(fzVar.bOL.desc)) {
                            if (fzVar.bOL.bOS > 0) {
                                intent.putExtra("fav_note_item_status", a3.field_itemStatus);
                                fzVar.bOL.bOO = intent;
                                a3.field_favProto.CN(a3.field_favProto.version + 1);
                            }
                            a3.field_itemStatus = 1;
                            com.tencent.mm.plugin.fav.a.b.q(a3);
                            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(a3, new String[]{"localId"});
                            if (fzVar.bOL.desc.equals("fav_add_new_note")) {
                                if (a3.field_favProto.version != 0) {
                                    a3.field_favProto.CN(a3.field_favProto.version + 1);
                                } else {
                                    a3.field_favProto.CN(a3.field_favProto.version + 2);
                                }
                                ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(a3, new String[]{"localId"});
                                g.a(fzVar.bOL.title, fzVar.bOL.bJH.rBI, fzVar.bOL.bJA);
                                break;
                            }
                        }
                        if (a3.field_favProto.version != 0) {
                            a3.field_favProto.CN(a3.field_favProto.version + 1);
                        } else {
                            a3.field_favProto.CN(a3.field_favProto.version + 2);
                        }
                        a3.field_itemStatus = 1;
                        com.tencent.mm.plugin.fav.a.b.q(a3);
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(a3, new String[]{"localId"});
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getCheckCdnService().run();
                        break;
                    }
                    dy3 = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
                    if (!(dy3 == null || dy3.field_favProto == null || dy3.field_favProto.rBI.size() <= 1)) {
                        fzVar.bOM.bPd = bi.oW(((vx) dy3.field_favProto.rBI.get(0)).rzo);
                        break;
                    }
                }
                g.a(fzVar.bOL.title, fzVar.bOL.bJH.rBI, -1);
                break;
                break;
            case 20:
                ao.aLW().aLX();
                ao aLW = ao.aLW();
                String str = fzVar.bOL.title;
                int i2 = fzVar.bOL.bOS;
                i = fzVar.bOL.bOT;
                aLW.path = bi.aG(str, "");
                aLW.bOS = i2;
                aLW.duration = i;
                break;
            case 21:
                fzVar.bOM.path = i.v(fzVar.bOL.context, fzVar.bOL.bOT).toString();
                break;
            case 22:
                ao.aLW();
                ao.aLY().destroy();
                break;
            case 23:
                ao.aLW();
                ao.aLY().aLs();
                break;
            case 24:
                bVar = fzVar.bOM;
                ao.aLW();
                bVar.bPb = ao.aLY().O(fzVar.bOL.path, fzVar.bOL.bOS, fzVar.bOL.bOT);
                break;
            case 25:
                ao.aLW();
                ao.aLY().stopPlay();
                break;
            case 26:
                bVar = fzVar.bOM;
                ao.aLW();
                bVar.path = ao.aLY().path;
                bVar = fzVar.bOM;
                ao.aLW();
                bVar.bPb = ao.aLY().aLq();
                bVar = fzVar.bOM;
                ao.aLW();
                bVar.bPc = ao.aLY().aLr();
                bVar = fzVar.bOM;
                ao.aLW();
                bVar.bPd = ao.aLY().wc();
                bVar = fzVar.bOM;
                ao.aLW();
                bVar.bPe = ao.aLY().wb();
                break;
            case a$i.AppCompatTheme_actionModeStyle /*27*/:
                if (fzVar.bOL.bON != null) {
                    fzVar.bOM.path = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.b(fzVar.bOL.bON)).cBX().toString();
                    fzVar.bOM.bOX = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(fzVar.bOL.bON)).cBX().toString();
                    break;
                }
                break;
            case a$i.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                dy3 = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
                if (dy3 != null) {
                    if (!bi.oW(fzVar.bOL.path)) {
                        com.tencent.mm.plugin.fav.a.b.a(dy3, fzVar.bOL.bON);
                        break;
                    }
                    com.tencent.mm.plugin.fav.a.b.a(dy3, fzVar.bOL.bON, true);
                    break;
                }
                com.tencent.mm.plugin.fav.a.b.b(fzVar.bOL.bON, fzVar.bOL.bOS);
                com.tencent.mm.plugin.fav.a.b.a(fzVar.bOL.bON, fzVar.bOL.bOS);
                break;
            case 30:
                com.tencent.mm.plugin.fav.a.b.b(fzVar);
                break;
            case a$i.AppCompatTheme_actionModeCloseDrawable /*31*/:
                al alVar = (al) fzVar.bOL.bKq;
                fzVar.bOM.path = alVar.iXf;
                if (!(alVar.dJd == null || alVar.dJd.Id() == null || alVar.dJd.Id().qWB != -435)) {
                    dy2 = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dz((long) alVar.iXb);
                    if (!(dy2 == null || dy2.field_favProto == null || dy2.field_favProto.rBI == null)) {
                        dy2.field_favProto.CN(dy2.field_favProto.version + 2);
                        dy2.field_itemStatus = 1;
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(dy2, new String[]{"localId"});
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getCheckCdnService().run();
                        break;
                    }
                }
            case a$i.AppCompatTheme_actionModeCutDrawable /*32*/:
                dy3 = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
                if (dy3 == null && fzVar.bOL.bJH != null) {
                    dy3 = com.tencent.mm.plugin.fav.a.b.a(fzVar.bOL.bJH);
                }
                fzVar.bOM.ret = new k().t(dy3) ? 1 : 0;
                fzVar.bOM.bPd = k.u(dy3);
                fzVar.bOM.path = "";
                if (dy3 == null) {
                    fzVar.bOM.bPd = true;
                    fzVar.bOM.path = null;
                    break;
                }
                break;
            case a$i.AppCompatTheme_actionModeCopyDrawable /*33*/:
                dy2 = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
                if (dy2 != null) {
                    dy2.field_favProto.ar(fzVar.bOL.bJH.rBI);
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().b(dy2, new String[]{"localId"});
                    break;
                }
                break;
            case a$i.AppCompatTheme_actionModePasteDrawable /*34*/:
                dy3 = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(fzVar.bOL.bJA);
                if (dy3 != null && dy3.field_type == 18) {
                    fzVar.bOL.bJH = dy3.field_favProto;
                    break;
                }
            case a$i.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                com.tencent.mm.plugin.fav.a.b.aKQ();
                break;
            case a$i.AppCompatTheme_actionModeShareDrawable /*36*/:
                fzVar.bOM.ret = com.tencent.mm.plugin.fav.a.b.aKZ() ? 1 : 0;
                break;
            case a$i.AppCompatTheme_actionModeFindDrawable /*37*/:
                com.tencent.mm.plugin.fav.a.b.g(fzVar.bOL.context, fzVar.bOL.desc, fzVar.bOL.title, fzVar.bOL.path);
                break;
            case a$i.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                x.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", new Object[]{fzVar.bOL.bOU});
                if (!bi.oW(fzVar.bOL.bOU)) {
                    a = fzVar.bOL.bOU.split(";");
                    List<String> linkedList = new LinkedList();
                    linkedList.addAll(Arrays.asList(a));
                    if (linkedList.size() > 0) {
                        arrayList = new ArrayList();
                        for (String valueOf : linkedList) {
                            try {
                                i = Integer.valueOf(valueOf).intValue();
                                if (i > 0) {
                                    dy3 = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dz((long) i);
                                    wd wdVar = new wd();
                                    wdVar.rbY = i;
                                    if (!(dy3 == null || bi.oW(dy3.field_xml))) {
                                        wdVar.rcf = dy3.field_xml;
                                    }
                                    arrayList.add(wdVar);
                                }
                            } catch (Exception e) {
                            }
                        }
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).checkFavItem(arrayList);
                        x.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                        break;
                    }
                }
                break;
            case a$i.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                try {
                    x.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", new Object[]{fzVar.bOL.bOU, fzVar.bOL.bOV});
                    int i3 = bi.getInt(fzVar.bOL.bOU, -1);
                    Collection F = bi.F(fzVar.bOL.bOV.split(";"));
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(F);
                    g dz = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dz((long) i3);
                    if (dz != null) {
                        wo woVar = new wo();
                        woVar.rbY = i3;
                        Object obj = null;
                        for (vx vxVar2 : dz.field_favProto.rBI) {
                            xf xfVar;
                            if (hashSet.remove(vxVar2.jdM + "#0")) {
                                if (bi.oW(vxVar2.rzq)) {
                                    com.tencent.mm.modelcdntran.g.NE();
                                    vxVar2.UG(com.tencent.mm.modelcdntran.b.Nw());
                                    h.pH(2);
                                }
                                if (d.cn(com.tencent.mm.plugin.fav.a.b.b(vxVar2))) {
                                    vxVar2.CI(1);
                                    com.tencent.mm.plugin.fav.a.b.a(vxVar2, dz, 0, false);
                                    h.pH(3);
                                    obj = 1;
                                } else {
                                    h.pH(5);
                                    xfVar = new xf();
                                    xfVar.rro = vxVar2.jdM;
                                    xfVar.rru = 0;
                                    xfVar.hcd = 4;
                                    woVar.rBL.add(xfVar);
                                }
                            }
                            if (hashSet.remove(vxVar2.jdM + "#1")) {
                                if (bi.oW(vxVar2.rzq)) {
                                    com.tencent.mm.modelcdntran.g.NE();
                                    vxVar2.UG(com.tencent.mm.modelcdntran.b.Nw());
                                    h.pH(2);
                                }
                                if (d.cn(com.tencent.mm.plugin.fav.a.b.c(vxVar2))) {
                                    vxVar2.CI(-1);
                                    com.tencent.mm.plugin.fav.a.b.a(vxVar2, dz, 0);
                                    h.pH(3);
                                    obj = 1;
                                } else {
                                    h.pH(5);
                                    xfVar = new xf();
                                    xfVar.rro = vxVar2.jdM;
                                    xfVar.rru = 1;
                                    xfVar.hcd = 4;
                                    woVar.rBL.add(xfVar);
                                }
                            }
                        }
                        if (hashSet.size() > 0) {
                            x.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", new Object[]{hashSet.toString()});
                            h.pI(hashSet.size());
                            Iterator it2 = hashSet.iterator();
                            while (it2.hasNext()) {
                                try {
                                    a = ((String) it2.next()).split("#");
                                    xf xfVar2 = new xf();
                                    xfVar2.rro = a[0];
                                    xfVar2.rru = Integer.valueOf(a[1]).intValue();
                                    xfVar2.hcd = 3;
                                    woVar.rBL.add(xfVar2);
                                } catch (Exception e2) {
                                }
                            }
                        }
                        if (woVar.rBL.size() > 0) {
                            ((ae) com.tencent.mm.kernel.g.n(ae.class)).checkFavItem(woVar);
                        }
                        if (obj == null) {
                            h.pH(7);
                            x.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                            break;
                        }
                        if (dz.field_type == 18) {
                            dz.field_favProto.CN(dz.field_favProto.version + 1);
                        }
                        dz.field_itemStatus = 15;
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(dz, new String[]{"localId"});
                        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().run();
                        h.pH(6);
                        break;
                    }
                    x.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", new Object[]{Integer.valueOf(i3)});
                    h.pH(8);
                    break;
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", e3, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                    break;
                }
        }
        return false;
    }

    private static String k(vx vxVar) {
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.c(vxVar));
        if (bVar.exists()) {
            return bVar.cBX().toString();
        }
        if (vxVar.bJv == null) {
            return "";
        }
        bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fav.a.b.aKO() + com.tencent.mm.a.g.u(vxVar.bJv.getBytes()));
        return bVar.exists() ? bVar.cBX().toString() : "";
    }
}
