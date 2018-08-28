package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.wz;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.i;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class g {
    private static final SimpleDateFormat mvL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static boolean a(Context context, ch chVar, String str, List<bd> list, boolean z, boolean z2) {
        if (list == null || list.isEmpty() || context == null) {
            x.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msgs is null");
            chVar.bJF.bJL = R.l.favorite_fail_argument_error;
            return false;
        }
        bd bdVar;
        for (bd bdVar2 : list) {
            if (bf.l(bdVar2)) {
                switch (bdVar2.getType() & 65535) {
                    case 1:
                        bdVar2.setContent(context.getString(R.l.app_text));
                        break;
                    case 3:
                        bdVar2.setContent(context.getString(R.l.app_pic));
                        bdVar2.setType(1);
                        break;
                    case a$k.AppCompatTheme_dialogPreferredPadding /*43*/:
                        bdVar2.setContent(context.getString(R.l.app_video));
                        bdVar2.setType(1);
                        break;
                    case a$k.AppCompatTheme_actionButtonStyle /*49*/:
                        bdVar2.setContent(context.getString(R.l.app_unknown_msg));
                        bdVar2.setType(1);
                        break;
                    default:
                        break;
                }
            }
        }
        boolean eZ = f.eZ(str);
        if (list.size() != 1 || z2) {
            chVar.bJF.bJH = new wl();
            chVar.bJF.bJI = new wz();
            if (context != null) {
                if (eZ) {
                    if (e.lc(e.bl(((bd) list.get(0)).field_bizChatId))) {
                        chVar.bJF.bJH.Vu(context.getString(R.l.record_chatroom_title));
                    } else {
                        if (e.lf(str) != null) {
                            chVar.bJF.bJH.Vu(context.getString(R.l.favorite_record_chat_title, new Object[]{r1.field_userName, e.ld(r0)}));
                        }
                    }
                } else if (s.fq(str)) {
                    chVar.bJF.bJH.Vu(context.getString(R.l.record_chatroom_title));
                } else {
                    if (q.GH().equals(r.gS(str))) {
                        chVar.bJF.bJH.Vu(context.getString(R.l.favorite_record_chatroom_title, new Object[]{r0}));
                    } else {
                        chVar.bJF.bJH.Vu(context.getString(R.l.favorite_record_chat_title, new Object[]{q.GH(), r.gS(str)}));
                    }
                }
                x.d("MicroMsg.GetFavRecordDataSource", "title %s", new Object[]{chVar.bJF.bJH.title});
            }
            chVar.bJF.bJH.a(SL(str));
            chVar.bJF.type = 14;
            int i = 0;
            boolean z3 = true;
            for (bd bdVar22 : list) {
                if (a(context, chVar, bdVar22, z)) {
                    i = 1;
                } else {
                    z3 = false;
                }
            }
            if (i == 0 || chVar.bJF.bJL <= 0) {
                return z3;
            }
            chVar.bJF.bJL = 0;
            return z3;
        }
        bdVar22 = (bd) list.get(0);
        if (!bdVar22.cky()) {
            return e.a(chVar, bdVar22);
        }
        l wS = ((a) com.tencent.mm.kernel.g.l(a.class)).wS(bdVar22.field_content);
        if (wS.dzs != null && wS.dzs.size() == 1) {
            return e.a(chVar, bdVar22);
        }
        chVar.bJF.bJH = new wl();
        chVar.bJF.bJI = new wz();
        chVar.bJF.bJH.a(SL(str));
        chVar.bJF.type = 14;
        return a(context, chVar, bdVar22, z);
    }

    private static boolean a(Context context, ch chVar, bd bdVar, boolean z) {
        boolean z2 = false;
        if (chVar == null || bdVar == null) {
            x.w("MicroMsg.GetFavRecordDataSource", "fill favorite event fail, event or msg is null");
            if (chVar == null) {
                return false;
            }
            chVar.bJF.bJL = R.l.favorite_fail_argument_error;
            return false;
        }
        bd al = bd.al(bdVar);
        wz wzVar;
        vy vyVar;
        vx vxVar;
        if (al.isText()) {
            vy vyVar2 = new vy();
            vyVar2.c(ac(al));
            vx vxVar2 = new vx();
            vxVar2.UT(ad(al));
            vxVar2.CF(1);
            if (al.cmy()) {
                vxVar2.UC(al.field_content + "\n\n" + al.field_transContent);
            } else {
                vxVar2.UC(al.field_content);
            }
            vxVar2.kY(true);
            vxVar2.kX(true);
            vxVar2.a(vyVar2);
            vxVar2.UW(a(vyVar2.rAJ));
            vxVar2.UX(b(vyVar2.rAJ));
            chVar.bJF.bJH.rBI.add(vxVar2);
            wzVar = chVar.bJF.bJI;
            wzVar.rBY++;
            z2 = true;
        } else if (al.ckz()) {
            boolean z3;
            vyVar = new vy();
            vyVar.c(ac(al));
            vxVar = new vx();
            vxVar.UT(ad(al));
            vxVar.CF(3);
            if (z) {
                vxVar.kY(true);
                vxVar.kX(true);
            } else {
                if (s.hB(al.field_talker)) {
                    String str = al.field_imgPath;
                    au.HU();
                    str = h.b(c.Ge(), "recbiz_", str, ".rec", 2);
                    if (bi.oW(str)) {
                        str = null;
                    } else {
                        new File(str).exists();
                    }
                    vxVar.UP(str);
                } else {
                    vxVar.UP(com.tencent.mm.modelvoice.q.getFullPath(al.field_imgPath));
                }
                vxVar.kY(true);
                b ok = com.tencent.mm.modelvoice.q.ok(al.field_imgPath);
                if (ok == null) {
                    z3 = false;
                    z2 = z3;
                } else {
                    vxVar.UL(e.BC(ok.getFormat()));
                    vxVar.CE((int) new n(al.field_content).time);
                }
            }
            vxVar.a(vyVar);
            vxVar.UW(a(vyVar.rAJ));
            vxVar.UX(b(vyVar.rAJ));
            chVar.bJF.bJH.rBI.add(vxVar);
            wzVar = chVar.bJF.bJI;
            wzVar.rCa++;
            z3 = true;
            z2 = z3;
        } else if (al.aQo()) {
            z2 = b(chVar, al);
        } else if (al.ckA()) {
            com.tencent.mm.ak.e eVar = null;
            if (al.field_msgId > 0) {
                eVar = o.Pf().br((long) ((int) al.field_msgId));
            }
            if ((eVar == null || eVar.dTK <= 0) && al.field_msgSvrId > 0) {
                eVar = o.Pf().bq(al.field_msgSvrId);
            }
            if (eVar == null) {
                x.w("MicroMsg.GetFavRecordDataSource", "getImgDataPath: try get imgInfo fail");
                chVar.bJF.bJL = R.l.favorite_fail_image_not_exists;
            } else {
                vyVar = new vy();
                vyVar.c(ac(al));
                vxVar = new vx();
                vxVar.UT(ad(al));
                vxVar.CF(2);
                vxVar.UP(o.Pf().o(com.tencent.mm.ak.f.c(eVar), "", ""));
                if (eVar.ON()) {
                    com.tencent.mm.ak.e hQ = o.Pf().hQ(eVar.dTU);
                    if (hQ.dHI > hQ.offset) {
                        vxVar.UP(o.Pf().o("SERVERID://" + al.field_msgSvrId, "", ""));
                    }
                }
                vxVar.UQ(o.Pf().E(al.field_imgPath, true));
                vxVar.a(vyVar);
                vxVar.UW(a(vyVar.rAJ));
                vxVar.UX(b(vyVar.rAJ));
                vxVar.fQ(al.field_msgId);
                if (z) {
                    boolean z4;
                    if (eVar.ON() && eVar.dHI == 0) {
                        eVar = o.Pf().hQ(eVar.dTU);
                    }
                    if (al.field_isSend == 1) {
                        z4 = eVar.ON();
                    } else if (eVar.ON()) {
                        z4 = com.tencent.mm.a.e.cn(o.Pf().o(com.tencent.mm.ak.f.a(eVar).dTL, "", ""));
                    } else {
                        z4 = false;
                    }
                    Map z5 = bl.z(eVar.dTV, "msg");
                    if (z5 == null) {
                        x.i("MicroMsg.GetFavRecordDataSource", "parse cdnInfo failed. [%s]", new Object[]{eVar.dTV});
                    } else if (z4) {
                        vxVar.UF((String) z5.get(".msg.img.$cdnbigimgurl"));
                        vxVar.fO((long) bi.getInt((String) z5.get(".msg.img.$length"), 0));
                        vxVar.UG((String) z5.get(".msg.img.$aeskey"));
                    }
                }
                chVar.bJF.bJH.rBI.add(vxVar);
                wzVar = chVar.bJF.bJI;
                wzVar.rBZ++;
                z2 = true;
            }
        } else if (al.cmj()) {
            z2 = a(chVar, al, z);
        } else if (al.cmk()) {
            z2 = a(chVar, al, z);
        } else if (z && al.getType() == 318767153) {
            return a(context, chVar, al, 3);
        } else {
            if (al.cky()) {
                z2 = c(chVar, al);
            } else if (z && (al.cml() || al.cmm())) {
                z2 = a(context, chVar, al, 1);
            } else if (z && al.getType() == 419430449) {
                z2 = a(context, chVar, al, 2);
            } else if (al.cmi()) {
                Object vxVar3;
                au.HU();
                bd.a GR = c.FT().GR(al.field_content);
                vy vyVar3 = new vy();
                vyVar3.c(ac(al));
                if (GR != null && s.gU(GR.pOR)) {
                    vxVar3 = new vx();
                    vxVar3.UT(ad(al));
                    vxVar3.CF(16);
                    vxVar3.UC(al.field_content);
                    vxVar3.kY(true);
                    vxVar3.kX(true);
                    vxVar3.a(vyVar3);
                    vxVar3.UW(a(vyVar3.rAJ));
                    vxVar3.UX(b(vyVar3.rAJ));
                } else if (GR == null || !ab.XR(GR.otZ)) {
                    vxVar3 = a(al, context.getString(R.l.app_friend_card_personal), vyVar3);
                } else {
                    vxVar3 = a(al, TextUtils.isEmpty(((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).g(GR.tbI, "openim_card_type_name", com.tencent.mm.openim.a.b.a.eui)) ? context.getResources().getString(R.l.app_friend_card_personal) : String.format("[%s]", new Object[]{((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).g(GR.tbI, "openim_card_type_name", com.tencent.mm.openim.a.b.a.eui)}), vyVar3);
                }
                chVar.bJF.bJH.rBI.add(vxVar3);
                wzVar = chVar.bJF.bJI;
                wzVar.rCm++;
                z2 = true;
            } else if (!al.aQm()) {
                chVar.bJF.bJL = R.l.favorite_fail_nonsupport;
                if (z) {
                    z2 = a(context, chVar, al, 3);
                }
            } else if (al.cmm()) {
                chVar.bJF.bJL = R.l.favorite_fail_nonsupport;
            } else {
                z2 = b(context, chVar, al, z);
            }
        }
        if (z) {
            return z2;
        }
        com.tencent.mm.plugin.fav.ui.c.a(al, chVar, z2);
        return z2;
    }

    private static boolean a(Context context, ch chVar, bd bdVar, int i) {
        vy vyVar = new vy();
        vyVar.c(ac(bdVar));
        String str = null;
        if (i == 1) {
            str = context.getString(R.l.app_emoji);
        } else if (i == 2) {
            str = context.getString(R.l.app_pay);
        } else if (i == 3) {
            str = context.getString(R.l.app_special);
        }
        chVar.bJF.bJH.rBI.add(a(bdVar, str, vyVar));
        return true;
    }

    private static wr SL(String str) {
        wr wrVar = new wr();
        wrVar.Vw(str);
        wrVar.CO(1);
        wrVar.fU(bi.VF());
        wrVar.Vy("");
        return wrVar;
    }

    private static vz ac(bd bdVar) {
        vz vzVar = new vz();
        if (bdVar == null) {
            return vzVar;
        }
        if (bdVar.field_isSend == 1 || bdVar.field_content.startsWith("<msg>")) {
            vzVar.Vf(q.GF());
            vzVar.Vg(bdVar.field_talker);
            if (s.fq(bdVar.field_talker)) {
                vzVar.Vi(vzVar.bSS);
            }
        } else {
            vzVar.Vf(bdVar.field_talker);
            vzVar.Vg(q.GF());
            if (s.fq(bdVar.field_talker)) {
                vzVar.Vi(bdVar.field_content != null ? bdVar.field_content.substring(0, Math.max(0, bdVar.field_content.indexOf(58))) : "");
                if (!(bi.oW(vzVar.rBh) || bdVar.ckz())) {
                    bdVar.setContent(bdVar.field_content.substring(vzVar.rBh.length() + 1));
                    if (bdVar.field_content.length() > 0 && 10 == bdVar.field_content.charAt(0)) {
                        bdVar.setContent(bdVar.field_content.substring(1));
                    }
                    if (bdVar.cmt()) {
                        bdVar.es(bdVar.field_transContent.substring(vzVar.rBh.length() + 1));
                        if (bdVar.field_transContent.length() > 0 && 10 == bdVar.field_transContent.charAt(0)) {
                            bdVar.es(bdVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        }
        if (f.eZ(bdVar.field_talker)) {
            String str = bdVar.field_bizChatUserId;
            if (str == null) {
                str = com.tencent.mm.model.bd.iF(bdVar.cqb).userId;
            }
            vzVar.Vi(str);
        }
        vzVar.CJ(1);
        vzVar.fR(bdVar.field_createTime);
        vzVar.Vj(bdVar.field_msgSvrId);
        if (bdVar.field_msgSvrId > 0) {
            vzVar.Vh(bdVar.field_msgSvrId);
        }
        return vzVar;
    }

    private static String a(vz vzVar) {
        String str = vzVar.rBh;
        if (bi.oW(str)) {
            str = vzVar.bSS;
        }
        if (e.lb(str)) {
            return e.ld(str);
        }
        return r.gS(str);
    }

    private static String b(vz vzVar) {
        return mvL.format(new Date(vzVar.createTime));
    }

    private static String ad(bd bdVar) {
        if (bdVar.field_isSend != 1) {
            return String.valueOf(bdVar.field_msgSvrId);
        }
        if (s.fq(bdVar.field_talker) || bdVar.field_talker.equals("filehelper")) {
            return String.format("%d", new Object[]{Long.valueOf(bdVar.field_msgSvrId)});
        }
        return String.format("%s#%d", new Object[]{bdVar.field_talker, Long.valueOf(bdVar.field_msgSvrId)});
    }

    private static boolean b(ch chVar, bd bdVar) {
        vy vyVar = new vy();
        vyVar.c(ac(bdVar));
        Map z = bl.z(bdVar.field_content, "msg");
        if (z != null) {
            try {
                we weVar = new we();
                weVar.Vn((String) z.get(".msg.location.$label"));
                weVar.z(Double.parseDouble((String) z.get(".msg.location.$x")));
                weVar.y(Double.parseDouble((String) z.get(".msg.location.$y")));
                weVar.CK(Integer.valueOf((String) z.get(".msg.location.$scale")).intValue());
                weVar.Vo((String) z.get(".msg.location.$poiname"));
                vyVar.a(weVar);
                vx vxVar = new vx();
                vxVar.UT(ad(bdVar));
                vxVar.CF(6);
                vxVar.kY(true);
                vxVar.kX(true);
                vxVar.a(vyVar);
                vxVar.UW(a(vyVar.rAJ));
                vxVar.UX(b(vyVar.rAJ));
                chVar.bJF.bJH.rBI.add(vxVar);
                wz wzVar = chVar.bJF.bJI;
                wzVar.rCd++;
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.GetFavRecordDataSource", "parse failed, %s", new Object[]{e.getStackTrace().toString()});
            }
        }
        chVar.bJF.bJL = R.l.favorite_fail_parse_error;
        return false;
    }

    private static boolean a(ch chVar, bd bdVar, boolean z) {
        vy vyVar = new vy();
        vyVar.c(ac(bdVar));
        vx vxVar = new vx();
        vxVar.UT(ad(bdVar));
        com.tencent.mm.modelvideo.o.Ta();
        vxVar.UP(com.tencent.mm.modelvideo.s.nK(bdVar.field_imgPath));
        com.tencent.mm.modelvideo.o.Ta();
        vxVar.UQ(com.tencent.mm.modelvideo.s.nL(bdVar.field_imgPath));
        vxVar.UL(com.tencent.mm.a.e.cp(vxVar.rzM));
        if (bdVar.cmk()) {
            vxVar.CF(15);
        } else {
            vxVar.CF(4);
        }
        com.tencent.mm.modelvideo.r nW = t.nW(bdVar.field_imgPath);
        x.i("MicroMsg.GetFavRecordDataSource", "video length is %d", new Object[]{Integer.valueOf(nW.dHI)});
        if (nW.dHI > com.tencent.mm.k.b.AB()) {
            chVar.bJF.bJL = R.l.favorite_too_large;
            return false;
        } else if (bdVar.cmk() && t.nY(nW.getFileName())) {
            chVar.bJF.bJL = R.l.favorite_fail;
            return false;
        } else {
            vxVar.CE(nW.enM);
            vxVar.a(vyVar);
            vxVar.UW(a(vyVar.rAJ));
            vxVar.UX(b(vyVar.rAJ));
            vxVar.fQ(bdVar.field_msgId);
            vxVar.fO((long) nW.dHI);
            if (z) {
                Map z2 = bl.z(nW.Tm(), "msg");
                if (z2 != null) {
                    vxVar.UF((String) z2.get(".msg.videomsg.$cdnvideourl"));
                    vxVar.UG((String) z2.get(".msg.videomsg.$aeskey"));
                } else {
                    x.i("MicroMsg.GetFavRecordDataSource", "cdntra parse video recv xml failed");
                }
            }
            chVar.bJF.bJH.rBI.add(vxVar);
            wz wzVar = chVar.bJF.bJI;
            wzVar.rCb++;
            com.tencent.mm.modelvideo.r nW2 = t.nW(bdVar.field_imgPath);
            vxVar.UZ(nW2.bZN);
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
                vxVar.a(waVar);
            }
            return true;
        }
    }

    private static vx a(bd bdVar, com.tencent.mm.y.g.a aVar, int i) {
        vx vxVar = new vx();
        vxVar.UT(ad(bdVar));
        vxVar.UI(aVar.dwN);
        vxVar.UJ(aVar.dwO);
        vxVar.UH(aVar.url);
        vxVar.kX(true);
        File file = new File(bi.aG(o.Pf().E(bdVar.field_imgPath, true), ""));
        if (file.exists()) {
            vxVar.UQ(file.getAbsolutePath());
        } else {
            vxVar.kY(true);
        }
        vxVar.UB(aVar.title);
        vxVar.UC(aVar.description);
        vxVar.CF(i);
        vxVar.Va(aVar.canvasPageXml);
        return vxVar;
    }

    private static vx a(bd bdVar, String str, vy vyVar) {
        vx vxVar = new vx();
        vxVar.UT(ad(bdVar));
        vxVar.CF(1);
        vxVar.UC(str);
        vxVar.kY(true);
        vxVar.kX(true);
        vxVar.a(vyVar);
        vxVar.UW(a(vyVar.rAJ));
        vxVar.UX(b(vyVar.rAJ));
        return vxVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(android.content.Context r8, com.tencent.mm.g.a.ch r9, com.tencent.mm.storage.bd r10, boolean r11) {
        /*
        r2 = 0;
        r3 = 1;
        r4 = new com.tencent.mm.protocal.c.vy;
        r4.<init>();
        r0 = ac(r10);
        r4.c(r0);
        r0 = r10.field_content;
        if (r0 != 0) goto L_0x001a;
    L_0x0012:
        r0 = r9.bJF;
        r1 = com.tencent.mm.R.l.favorite_fail_parse_error;
        r0.bJL = r1;
        r0 = r2;
    L_0x0019:
        return r0;
    L_0x001a:
        r5 = com.tencent.mm.y.g.a.gp(r0);
        if (r5 != 0) goto L_0x0028;
    L_0x0020:
        r0 = r9.bJF;
        r1 = com.tencent.mm.R.l.favorite_fail_parse_error;
        r0.bJL = r1;
        r0 = r2;
        goto L_0x0019;
    L_0x0028:
        r0 = r4.rAJ;
        r1 = r5.appId;
        r0.Vk(r1);
        r0 = r4.rAJ;
        r1 = r5.bZG;
        r0.Vm(r1);
        r0 = r5.appId;
        r0 = com.tencent.mm.pluginsdk.model.app.g.bl(r0, r3);
        if (r0 == 0) goto L_0x005b;
    L_0x003e:
        r0 = r0.aaq();
        if (r0 == 0) goto L_0x005b;
    L_0x0044:
        if (r11 == 0) goto L_0x005b;
    L_0x0046:
        r0 = com.tencent.mm.R.l.app_game;
        r0 = r8.getString(r0);
        r0 = a(r10, r0, r4);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r3;
        goto L_0x0019;
    L_0x005b:
        r0 = r5.type;
        switch(r0) {
            case 1: goto L_0x0077;
            case 2: goto L_0x00bc;
            case 3: goto L_0x013c;
            case 4: goto L_0x016c;
            case 5: goto L_0x01a1;
            case 6: goto L_0x024d;
            case 7: goto L_0x02f7;
            case 8: goto L_0x0060;
            case 9: goto L_0x0060;
            case 10: goto L_0x0324;
            case 11: goto L_0x0060;
            case 12: goto L_0x0060;
            case 13: goto L_0x03e5;
            case 14: goto L_0x0060;
            case 15: goto L_0x0060;
            case 16: goto L_0x05b4;
            case 17: goto L_0x0060;
            case 18: goto L_0x0060;
            case 19: goto L_0x04fe;
            case 20: goto L_0x0387;
            case 21: goto L_0x0060;
            case 22: goto L_0x0060;
            case 23: goto L_0x0060;
            case 24: goto L_0x059c;
            case 25: goto L_0x0060;
            case 26: goto L_0x0060;
            case 27: goto L_0x0060;
            case 28: goto L_0x0060;
            case 29: goto L_0x0060;
            case 30: goto L_0x0060;
            case 31: goto L_0x0060;
            case 32: goto L_0x0060;
            case 33: goto L_0x0448;
            case 34: goto L_0x0060;
            case 35: goto L_0x0060;
            case 36: goto L_0x0448;
            default: goto L_0x0060;
        };
    L_0x0060:
        if (r11 == 0) goto L_0x05cc;
    L_0x0062:
        r0 = com.tencent.mm.R.l.app_special;
        r0 = r8.getString(r0);
        r0 = a(r10, r0, r4);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r3;
        goto L_0x0019;
    L_0x0077:
        r0 = new com.tencent.mm.protocal.c.vx;
        r0.<init>();
        r1 = ad(r10);
        r0.UT(r1);
        r0.CF(r3);
        r1 = r5.title;
        r0.UC(r1);
        r0.kY(r3);
        r0.kX(r3);
        r0.a(r4);
        r1 = r4.rAJ;
        r1 = a(r1);
        r0.UW(r1);
        r1 = r4.rAJ;
        r1 = b(r1);
        r0.UX(r1);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r9.bJF;
        r0 = r0.bJI;
        r1 = r0.rBY;
        r1 = r1 + 1;
        r0.rBY = r1;
        r0 = r3;
        goto L_0x0019;
    L_0x00bc:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.isSDCardAvailable();
        if (r0 != 0) goto L_0x00ce;
    L_0x00c5:
        r0 = r9.bJF;
        r1 = com.tencent.mm.R.l.favorite_fail_sdcard_not_available;
        r0.bJL = r1;
        r0 = r2;
        goto L_0x0019;
    L_0x00ce:
        r0 = com.tencent.mm.pluginsdk.model.app.ao.asF();
        r1 = r5.bGP;
        r0 = r0.SR(r1);
        r1 = new com.tencent.mm.protocal.c.vx;
        r1.<init>();
        r2 = ad(r10);
        r1.UT(r2);
        if (r0 == 0) goto L_0x00eb;
    L_0x00e6:
        r0 = r0.field_fileFullPath;
        r1.UP(r0);
    L_0x00eb:
        r0 = com.tencent.mm.ak.o.Pf();
        r2 = r10.field_imgPath;
        r0 = r0.E(r2, r3);
        r2 = com.tencent.mm.a.e.cn(r0);
        if (r2 == 0) goto L_0x00fe;
    L_0x00fb:
        r1.UQ(r0);
    L_0x00fe:
        r0 = 2;
        r1.CF(r0);
        r0 = r5.title;
        r1.UB(r0);
        r0 = r5.description;
        r1.UC(r0);
        r1.a(r4);
        r0 = r4.rAJ;
        r0 = a(r0);
        r1.UW(r0);
        r0 = r4.rAJ;
        r0 = b(r0);
        r1.UX(r0);
        r4 = r10.field_msgId;
        r1.fQ(r4);
        r0 = r9.bJF;
        r0 = r0.bJH;
        r0 = r0.rBI;
        r0.add(r1);
        r0 = r9.bJF;
        r0 = r0.bJI;
        r1 = r0.rBZ;
        r1 = r1 + 1;
        r0.rBZ = r1;
        r0 = r3;
        goto L_0x0019;
    L_0x013c:
        r0 = 7;
        r0 = a(r10, r5, r0);
        r0.a(r4);
        r1 = r4.rAJ;
        r1 = a(r1);
        r0.UW(r1);
        r1 = r4.rAJ;
        r1 = b(r1);
        r0.UX(r1);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r9.bJF;
        r0 = r0.bJI;
        r1 = r0.rCe;
        r1 = r1 + 1;
        r0.rCe = r1;
        r0 = r3;
        goto L_0x0019;
    L_0x016c:
        r0 = 4;
        r0 = a(r10, r5, r0);
        r0.a(r4);
        r1 = r4.rAJ;
        r1 = a(r1);
        r0.UW(r1);
        r1 = r4.rAJ;
        r1 = b(r1);
        r0.UX(r1);
        r4 = r10.field_msgId;
        r0.fQ(r4);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r9.bJF;
        r0 = r0.bJI;
        r1 = r0.rCb;
        r1 = r1 + 1;
        r0.rCb = r1;
        r0 = r3;
        goto L_0x0019;
    L_0x01a1:
        r0 = r5.url;
        if (r0 == 0) goto L_0x022c;
    L_0x01a5:
        r0 = r5.url;
        r1 = "";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x022c;
    L_0x01b0:
        r0 = r4.rAJ;
        r1 = r5.url;
        r0.Vl(r1);
        r0 = 5;
        r0 = a(r10, r5, r0);
        r0.a(r4);
        r1 = r4.rAJ;
        r1 = a(r1);
        r0.UW(r1);
        r1 = r4.rAJ;
        r1 = b(r1);
        r0.UX(r1);
        r1 = new com.tencent.mm.protocal.c.xa;
        r1.<init>();
        r2 = r5.title;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x01e3;
    L_0x01de:
        r2 = r5.title;
        r1.VJ(r2);
    L_0x01e3:
        r2 = r5.description;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x01f0;
    L_0x01eb:
        r2 = r5.description;
        r1.VK(r2);
    L_0x01f0:
        r2 = r5.thumburl;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x01fd;
    L_0x01f8:
        r2 = r5.thumburl;
        r1.VM(r2);
    L_0x01fd:
        r2 = r5.canvasPageXml;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x020a;
    L_0x0205:
        r2 = r5.canvasPageXml;
        r1.VN(r2);
    L_0x020a:
        r2 = r1.boi();
        if (r2 <= 0) goto L_0x0216;
    L_0x0210:
        r1.CP(r3);
        r4.a(r1);
    L_0x0216:
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r9.bJF;
        r0 = r0.bJI;
        r1 = r0.rCc;
        r1 = r1 + 1;
        r0.rCc = r1;
        r0 = r3;
        goto L_0x0019;
    L_0x022c:
        r0 = r9.bJF;
        r1 = com.tencent.mm.R.l.favorite_fail_empty_url;
        r0.bJL = r1;
        if (r11 == 0) goto L_0x024a;
    L_0x0234:
        r0 = com.tencent.mm.R.l.app_special;
        r0 = r8.getString(r0);
        r0 = a(r10, r0, r4);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r3;
        goto L_0x0019;
    L_0x024a:
        r0 = r2;
        goto L_0x0019;
    L_0x024d:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.isSDCardAvailable();
        if (r0 != 0) goto L_0x025f;
    L_0x0256:
        r0 = r9.bJF;
        r1 = com.tencent.mm.R.l.favorite_fail_sdcard_not_available;
        r0.bJL = r1;
        r0 = r2;
        goto L_0x0019;
    L_0x025f:
        r0 = com.tencent.mm.pluginsdk.model.app.ao.asF();
        r1 = r5.bGP;
        r0 = r0.SR(r1);
        r1 = new com.tencent.mm.protocal.c.vx;
        r1.<init>();
        if (r0 == 0) goto L_0x0275;
    L_0x0270:
        r0 = r0.field_fileFullPath;
        r1.UP(r0);
    L_0x0275:
        r0 = ad(r10);
        r1.UT(r0);
        r0 = 8;
        r1.CF(r0);
        r0 = r5.dwp;
        r1.UL(r0);
        r0 = com.tencent.mm.ak.o.Pf();
        r2 = r10.field_imgPath;
        r0 = r0.E(r2, r3);
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r2 == 0) goto L_0x0299;
    L_0x0296:
        r1.kY(r3);
    L_0x0299:
        r2 = com.tencent.mm.a.e.cn(r0);
        if (r2 == 0) goto L_0x02a2;
    L_0x029f:
        r1.UQ(r0);
    L_0x02a2:
        r0 = r5.title;
        r1.UB(r0);
        r0 = r5.description;
        r1.UC(r0);
        r1.a(r4);
        r0 = r4.rAJ;
        r0 = a(r0);
        r1.UW(r0);
        r0 = r4.rAJ;
        r0 = b(r0);
        r1.UX(r0);
        r6 = r10.field_msgId;
        r1.fQ(r6);
        if (r11 == 0) goto L_0x02e1;
    L_0x02c8:
        r0 = r5.dwD;
        r1.UF(r0);
        r0 = r5.dwK;
        r1.UG(r0);
        r0 = r5.dwu;
        r1.Ve(r0);
        r0 = r5.dwK;
        r1.Vc(r0);
        r0 = r5.dwA;
        r1.Vd(r0);
    L_0x02e1:
        r0 = r9.bJF;
        r0 = r0.bJH;
        r0 = r0.rBI;
        r0.add(r1);
        r0 = r9.bJF;
        r0 = r0.bJI;
        r1 = r0.rCf;
        r1 = r1 + 1;
        r0.rCf = r1;
        r0 = r3;
        goto L_0x0019;
    L_0x02f7:
        r0 = r5.bGP;
        if (r0 == 0) goto L_0x0303;
    L_0x02fb:
        r0 = r5.bGP;
        r0 = r0.length();
        if (r0 != 0) goto L_0x0312;
    L_0x0303:
        r0 = r9.bJF;
        r1 = com.tencent.mm.R.l.favorite_fail_attachment_not_exists;
        r0.bJL = r1;
    L_0x0309:
        r0 = r9.bJF;
        r1 = com.tencent.mm.R.l.favorite_fail_nonsupport;
        r0.bJL = r1;
        r0 = r2;
        goto L_0x0019;
    L_0x0312:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.isSDCardAvailable();
        if (r0 != 0) goto L_0x0309;
    L_0x031b:
        r0 = r9.bJF;
        r1 = com.tencent.mm.R.l.favorite_fail_sdcard_not_available;
        r0.bJL = r1;
        r0 = r2;
        goto L_0x0019;
    L_0x0324:
        r0 = new com.tencent.mm.protocal.c.wk;
        r0.<init>();
        r1 = r5.title;
        r0.Vp(r1);
        r1 = r5.description;
        r0.Vq(r1);
        r1 = r5.dwR;
        r0.CL(r1);
        r1 = r5.dwS;
        r0.Vs(r1);
        r1 = r5.thumburl;
        r0.Vr(r1);
        r4.a(r0);
        r0 = new com.tencent.mm.protocal.c.vx;
        r0.<init>();
        r1 = ad(r10);
        r0.UT(r1);
        r1 = 10;
        r0.CF(r1);
        r0.kY(r3);
        r0.kX(r3);
        r0.a(r4);
        r1 = r4.rAJ;
        r1 = a(r1);
        r0.UW(r1);
        r1 = r4.rAJ;
        r1 = b(r1);
        r0.UX(r1);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r9.bJF;
        r0 = r0.bJI;
        r1 = r0.rCh;
        r1 = r1 + 1;
        r0.rCh = r1;
        r0 = r3;
        goto L_0x0019;
    L_0x0387:
        r0 = new com.tencent.mm.protocal.c.wu;
        r0.<init>();
        r1 = r5.title;
        r0.VF(r1);
        r1 = r5.description;
        r0.VG(r1);
        r1 = r5.dwV;
        r0.VI(r1);
        r1 = r5.thumburl;
        r0.VH(r1);
        r4.a(r0);
        r0 = new com.tencent.mm.protocal.c.vx;
        r0.<init>();
        r1 = ad(r10);
        r0.UT(r1);
        r1 = 14;
        r0.CF(r1);
        r0.kY(r3);
        r0.kX(r3);
        r0.a(r4);
        r1 = r4.rAJ;
        r1 = a(r1);
        r0.UW(r1);
        r1 = r4.rAJ;
        r1 = b(r1);
        r0.UX(r1);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r9.bJF;
        r0 = r0.bJI;
        r1 = r0.rCl;
        r1 = r1 + 1;
        r0.rCl = r1;
        r0 = r3;
        goto L_0x0019;
    L_0x03e5:
        r0 = new com.tencent.mm.protocal.c.wk;
        r0.<init>();
        r1 = r5.title;
        r0.Vp(r1);
        r1 = r5.description;
        r0.Vq(r1);
        r1 = r5.dwX;
        r0.CL(r1);
        r1 = r5.dwY;
        r0.Vs(r1);
        r1 = r5.thumburl;
        r0.Vr(r1);
        r4.a(r0);
        r0 = new com.tencent.mm.protocal.c.vx;
        r0.<init>();
        r1 = ad(r10);
        r0.UT(r1);
        r1 = 11;
        r0.CF(r1);
        r0.kY(r3);
        r0.kX(r3);
        r0.a(r4);
        r1 = r4.rAJ;
        r1 = a(r1);
        r0.UW(r1);
        r1 = r4.rAJ;
        r1 = b(r1);
        r0.UX(r1);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r9.bJF;
        r0 = r0.bJI;
        r1 = r0.rCi;
        r1 = r1 + 1;
        r0.rCi = r1;
        r0 = r3;
        goto L_0x0019;
    L_0x0448:
        r0 = r5.dyU;
        r1 = 3;
        if (r0 != r1) goto L_0x0465;
    L_0x044d:
        if (r11 == 0) goto L_0x0465;
    L_0x044f:
        r0 = com.tencent.mm.R.l.app_not_show;
        r0 = r8.getString(r0);
        r0 = a(r10, r0, r4);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r3;
        goto L_0x0019;
    L_0x0465:
        r0 = new com.tencent.mm.protocal.c.vx;
        r0.<init>();
        r1 = ad(r10);
        r0.UT(r1);
        r1 = r5.title;
        r0.UB(r1);
        r1 = r5.description;
        r0.UC(r1);
        r1 = 19;
        r0.CF(r1);
        r1 = com.tencent.mm.ak.o.Pf();
        r2 = r10.field_imgPath;
        r1 = r1.E(r2, r3);
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r2 == 0) goto L_0x0493;
    L_0x0490:
        r0.kY(r3);
    L_0x0493:
        r2 = com.tencent.mm.a.e.cn(r1);
        if (r2 == 0) goto L_0x049c;
    L_0x0499:
        r0.UQ(r1);
    L_0x049c:
        r1 = new com.tencent.mm.protocal.c.vv;
        r1.<init>();
        r2 = r5.dyS;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x04ad;
    L_0x04a9:
        r2 = r5.dyS;
        r1.username = r2;
    L_0x04ad:
        r2 = r5.dyT;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x04b9;
    L_0x04b5:
        r2 = r5.dyT;
        r1.appId = r2;
    L_0x04b9:
        r2 = r5.dzb;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x04c5;
    L_0x04c1:
        r2 = r5.dzb;
        r1.iconUrl = r2;
    L_0x04c5:
        r2 = r5.dyU;
        r1.type = r2;
        r2 = r5.dyW;
        r1.bPh = r2;
        r2 = r5.dyR;
        r1.bGH = r2;
        r2 = r5.bZH;
        r1.rzd = r2;
        r4.a(r1);
        r0.a(r4);
        r1 = r4.rAJ;
        r1 = a(r1);
        r0.UW(r1);
        r1 = r4.rAJ;
        r1 = b(r1);
        r0.UX(r1);
        r4 = r10.field_msgId;
        r0.fQ(r4);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r3;
        goto L_0x0019;
    L_0x04fe:
        r0 = r5.dwW;
        if (r0 == 0) goto L_0x056d;
    L_0x0502:
        r0 = r5.dwW;
        r1 = "<recordxml>";
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x056d;
    L_0x050d:
        r0 = r3;
    L_0x050e:
        if (r0 != 0) goto L_0x059c;
    L_0x0510:
        r6 = new com.tencent.mm.protocal.c.vx;
        r6.<init>();
        r0 = ad(r10);
        r6.UT(r0);
        r0 = 17;
        r6.CF(r0);
        r6.kY(r3);
        r0 = r5.title;
        r6.UB(r0);
        r0 = r5.dwW;
        r6.Vb(r0);
        r1 = r5.description;
        r0 = new com.tencent.mm.g.a.mw;
        r0.<init>();
        r7 = r0.bXL;
        r7.type = r2;
        r7 = r0.bXL;
        r5 = r5.dwW;
        r7.bXN = r5;
        r5 = com.tencent.mm.sdk.b.a.sFg;
        r5.m(r0);
        r0 = r0.bXM;
        r5 = r0.bXV;
        if (r5 == 0) goto L_0x056f;
    L_0x054a:
        r0 = r5.dzs;
        r7 = r0.iterator();
    L_0x0550:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x056f;
    L_0x0556:
        r0 = r7.next();
        r0 = (com.tencent.mm.protocal.c.vx) r0;
        r0 = r0.rAG;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x0550;
    L_0x0564:
        r0 = r9.bJF;
        r1 = com.tencent.mm.R.l.favorite_fail_nonsupport;
        r0.bJL = r1;
        r0 = r2;
        goto L_0x0019;
    L_0x056d:
        r0 = r2;
        goto L_0x050e;
    L_0x056f:
        if (r5 == 0) goto L_0x05d5;
    L_0x0571:
        r0 = r5.desc;
    L_0x0573:
        r6.UC(r0);
        r6.a(r4);
        r0 = r4.rAJ;
        r0 = a(r0);
        r6.UW(r0);
        r0 = r4.rAJ;
        r0 = b(r0);
        r6.UX(r0);
        r0 = r10.field_msgId;
        r6.fQ(r0);
        r0 = r9.bJF;
        r0 = r0.bJH;
        r0 = r0.rBI;
        r0.add(r6);
        r0 = r3;
        goto L_0x0019;
    L_0x059c:
        if (r11 == 0) goto L_0x05b4;
    L_0x059e:
        r0 = com.tencent.mm.R.l.favorite_wenote_msg;
        r0 = r8.getString(r0);
        r0 = a(r10, r0, r4);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r3;
        goto L_0x0019;
    L_0x05b4:
        if (r11 == 0) goto L_0x0060;
    L_0x05b6:
        r0 = com.tencent.mm.R.l.app_product_card_ticket;
        r0 = r8.getString(r0);
        r0 = a(r10, r0, r4);
        r1 = r9.bJF;
        r1 = r1.bJH;
        r1 = r1.rBI;
        r1.add(r0);
        r0 = r3;
        goto L_0x0019;
    L_0x05cc:
        r0 = r9.bJF;
        r1 = com.tencent.mm.R.l.favorite_fail_nonsupport;
        r0.bJL = r1;
        r0 = r2;
        goto L_0x0019;
    L_0x05d5:
        r0 = r1;
        goto L_0x0573;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.g.b(android.content.Context, com.tencent.mm.g.a.ch, com.tencent.mm.storage.bd, boolean):boolean");
    }

    private static boolean c(ch chVar, bd bdVar) {
        try {
            l wS = ((a) com.tencent.mm.kernel.g.l(a.class)).wS(bdVar.field_content);
            List<m> list = wS.dzs;
            if (list != null) {
                int i = 0;
                for (m mVar : list) {
                    if (!i.gr(mVar.dzD)) {
                        vy vyVar = new vy();
                        vyVar.c(ac(bdVar));
                        vyVar.rAJ.Vm(wS.bZG);
                        vyVar.rAJ.Vl(mVar.url);
                        vx vxVar = new vx();
                        vxVar.UB(mVar.title);
                        vxVar.UC(mVar.dzA);
                        vxVar.UT(ad(bdVar));
                        if (bi.oW(mVar.dzy)) {
                            vxVar.kY(true);
                        } else {
                            vxVar.UQ(q.v(mVar.dzy, bdVar.getType(), i == 0 ? "@T" : "@S"));
                        }
                        vxVar.kX(true);
                        xa xaVar = new xa();
                        if (!bi.oW(mVar.title)) {
                            xaVar.VJ(mVar.title);
                        }
                        if (!bi.oW(mVar.dzA)) {
                            xaVar.VK(mVar.dzA);
                        }
                        if (!bi.oW(mVar.dzy)) {
                            xaVar.VM(mVar.dzy);
                        }
                        if (xaVar.boi() > 0) {
                            xaVar.CP(1);
                            vyVar.a(xaVar);
                        }
                        vxVar.CF(5);
                        vxVar.a(vyVar);
                        vxVar.UW(a(vyVar.rAJ));
                        vxVar.UX(b(vyVar.rAJ));
                        chVar.bJF.bJH.rBI.add(vxVar);
                        wz wzVar = chVar.bJF.bJI;
                        wzVar.rCc++;
                        i++;
                    }
                }
                if (i != 0) {
                    return true;
                }
                chVar.bJF.bJL = R.l.favorite_fail_nonsupport;
                return false;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GetFavRecordDataSource", e, "", new Object[0]);
            x.e("MicroMsg.GetFavRecordDataSource", "retransmit app msg error : %s", new Object[]{e.getLocalizedMessage()});
        }
        chVar.bJF.bJL = R.l.favorite_fail_parse_error;
        return false;
    }
}
