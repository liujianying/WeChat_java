package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.exdevice.a;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.aly;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.bji;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.protocal.c.brc;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ab extends c<gw> implements e {
    private ProgressDialog eHw;
    gw ivS;

    public ab() {
        this.sFo = gw.class.getName().hashCode();
    }

    private boolean a(gw gwVar) {
        if (gwVar instanceof gw) {
            this.ivS = gwVar;
            String str = this.ivS.bQd.result;
            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[]{Integer.valueOf(this.ivS.bQd.actionCode), str});
            if (!bi.oW(str)) {
                switch (this.ivS.bQd.actionCode) {
                    case 15:
                        if (this.ivS.bQd.context != null && (this.ivS.bQd.context instanceof Activity)) {
                            au.DF().a(540, this);
                            u uVar = new u(str);
                            au.DF().a(uVar, 0);
                            Context context = this.ivS.bQd.context;
                            this.ivS.bQd.context.getString(R.l.app_tip);
                            this.eHw = h.b(context, this.ivS.bQd.context.getString(R.l.scan_loading_tip), new 1(this, uVar));
                            break;
                        }
                }
            }
        }
        x.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
        if (lVar == null) {
            aHc();
        } else if (i == 0 && i2 == 0) {
            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[]{Integer.valueOf(lVar.getType())});
            if (lVar.getType() == 540) {
                au.DF().b(540, this);
                u uVar = (u) lVar;
                bji bji = (uVar.diG == null || uVar.diG.dIE.dIL == null) ? null : (bji) uVar.diG.dIE.dIL;
                if (bji == null) {
                    x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
                    aHc();
                    return;
                }
                String str2;
                ArrayList arrayList;
                int i3;
                alx alx = bji.rhk;
                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[]{alx.hbO, alx.reT});
                aly aly = bji.rhl;
                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[]{aly.reA, aly.rOv, Integer.valueOf(aly.rOy), aly.rOw, Integer.valueOf(aly.rOx), aly.rgL});
                String str3 = "";
                String str4 = "";
                LinkedList linkedList = new LinkedList();
                if (bji.sjw != null) {
                    if (bji.sjw.rcJ != null) {
                        str3 = bji.sjw.rcJ;
                    }
                    if (bji.sjw.title != null) {
                        str4 = bji.sjw.title;
                    }
                    if (bji.sjw.rcK != null) {
                        linkedList = bji.sjw.rcK;
                        str2 = str3;
                        arrayList = new ArrayList();
                        if (linkedList != null && linkedList.size() > 0) {
                            i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= linkedList.size()) {
                                    break;
                                }
                                brc brc = (brc) linkedList.get(i4);
                                if (brc.type.contains("text")) {
                                    arrayList.add(brc.content);
                                }
                                i3 = i4 + 1;
                            }
                        }
                        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[]{bji.rgQ});
                        if (bji.sjv != 1) {
                            Intent intent = new Intent();
                            intent.putExtra("device_scan_mode", "SCAN_CATALOG");
                            Object obj = (aly.rOw.contains("3") || aly.rOw.contains("1")) ? 1 : null;
                            boolean contains = aly.rOw.contains("4");
                            if (obj == null || !contains) {
                                if (obj != null) {
                                    intent.putExtra("device_scan_conn_proto", "blue");
                                } else if (contains) {
                                    intent.putExtra("device_scan_conn_proto", "wifi");
                                }
                                intent.putExtra("device_id", alx.hbO);
                                intent.putExtra("device_type", alx.reT);
                                intent.putExtra("device_title", aly.rOC);
                                intent.putExtra("device_desc", aly.rOD);
                                intent.putExtra("device_icon_url", aly.jPG);
                                intent.putExtra("device_category_id", aly.rOE);
                                intent.putExtra("device_brand_name", aly.rOv);
                                intent.putExtra("bind_ticket", bji.rgQ);
                                intent.putExtra("device_ble_simple_proto", aly.cCW);
                                intent.putExtra("device_airkiss_key", str2);
                                intent.putExtra("device_airkiss_title", str4);
                                intent.putStringArrayListExtra("device_airkiss_steps", arrayList);
                                d.b(this.ivS.bQd.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", intent);
                                atI();
                                return;
                            }
                            x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
                        }
                        aue aue = bji.rgR;
                        if (aue == null) {
                            x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
                            aHc();
                            return;
                        }
                        atI();
                        if (aue == null) {
                            x.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
                        } else {
                            str2 = com.tencent.mm.platformtools.ab.a(aue.rvi);
                            String oV = bi.oV(aue.rXj);
                            if (bi.oW(str2) && bi.oW(oV)) {
                                x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[]{str2, oV});
                            } else {
                                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[]{str2});
                                au.HU();
                                com.tencent.mm.storage.ab Yg = com.tencent.mm.model.c.FR().Yg(str2);
                                if (Yg == null || !str2.equals(Yg.field_encryptUsername)) {
                                    com.tencent.mm.storage.ab abVar = new com.tencent.mm.storage.ab(str2);
                                    abVar.du(aue.eJM);
                                    abVar.setType(aue.ruj & aue.ruk);
                                    if (!bi.oW(oV)) {
                                        abVar.dD(oV);
                                    } else if (Yg != null && ((int) Yg.dhP) > 0) {
                                        abVar.dD(Yg.field_encryptUsername);
                                    }
                                    abVar.dhP = Yg == null ? 0 : (long) ((int) Yg.dhP);
                                    abVar.dx(com.tencent.mm.platformtools.ab.a(aue.rQz));
                                    abVar.dy(com.tencent.mm.platformtools.ab.a(aue.ruT));
                                    abVar.dz(com.tencent.mm.platformtools.ab.a(aue.ruU));
                                    abVar.eJ(aue.eJH);
                                    abVar.eM(aue.rup);
                                    abVar.dw(com.tencent.mm.platformtools.ab.a(aue.rXd));
                                    abVar.eN(aue.rut);
                                    abVar.eO(aue.eJL);
                                    abVar.dS(RegionCodeDecoder.aq(aue.eJQ, aue.eJI, aue.eJJ));
                                    abVar.dM(aue.eJK);
                                    abVar.eF(aue.rTe);
                                    abVar.dR(aue.rTf);
                                    abVar.setSource(aue.rdq);
                                    abVar.eE(aue.rTi);
                                    abVar.dA(aue.rTh);
                                    if (s.hU(aue.rTg)) {
                                        abVar.dQ(aue.rTg);
                                    }
                                    abVar.eQ((int) bi.VE());
                                    abVar.dv(com.tencent.mm.platformtools.ab.a(aue.rWH));
                                    abVar.dB(com.tencent.mm.platformtools.ab.a(aue.rWJ));
                                    abVar.dC(com.tencent.mm.platformtools.ab.a(aue.rWI));
                                    abVar.dT(aue.rej);
                                    abVar.dU(aue.rXt);
                                    if (!(Yg == null || bi.oV(Yg.csU).equals(bi.oV(aue.rXt)))) {
                                        com.tencent.mm.at.c.Qt();
                                        com.tencent.mm.at.c.mA(str2);
                                    }
                                    au.HU();
                                    com.tencent.mm.model.c.FR().Yl(str2);
                                    if (bi.oW(abVar.field_username)) {
                                        x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
                                    } else {
                                        str3 = abVar.field_username;
                                        q.KH().a(com.tencent.mm.aa.c.a(str3, aue));
                                        bqd bqd = aue.rTk;
                                        if (!(abVar.field_username.endsWith("@chatroom") || bqd == null)) {
                                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + bqd.eJS + " " + aue.rvi);
                                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + bqd.eJT);
                                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + bqd.eJU);
                                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + bqd.sod);
                                            if (n.nky != null) {
                                                n.nky.a(abVar.field_username, bqd);
                                            }
                                        }
                                        str4 = com.tencent.mm.model.q.GF();
                                        if (!(str4 == null || str4.equals(str3))) {
                                            com.tencent.mm.ac.d kA = z.MY().kA(str3);
                                            kA.field_username = str3;
                                            kA.field_brandList = aue.eJR;
                                            qt qtVar = aue.rTl;
                                            if (qtVar != null) {
                                                kA.field_brandFlag = qtVar.eJV;
                                                kA.field_brandInfo = qtVar.eJX;
                                                kA.field_brandIconURL = qtVar.eJY;
                                                kA.field_extInfo = qtVar.eJW;
                                                kA.field_attrSyncVersion = null;
                                                kA.field_incrementUpdateTime = 0;
                                            }
                                            if (!z.MY().e(kA)) {
                                                z.MY().d(kA);
                                            }
                                            abVar.eR(kA.field_type);
                                        }
                                    }
                                    abVar.eH(aue.rXs);
                                    if (!(aue.rXo == null || aue.rXo.rcy == null)) {
                                        abVar.dV(aue.rXo.rcy.rhn);
                                        abVar.dW(aue.rXo.rcy.rho);
                                        abVar.dX(aue.rXo.rcy.rhp);
                                    }
                                    if (s.hO(str2)) {
                                        abVar.Bk();
                                    }
                                    if (abVar.ckW()) {
                                        abVar.Bn();
                                    }
                                    if (bi.oW(oV)) {
                                        au.HU();
                                        com.tencent.mm.model.c.FR().S(abVar);
                                    } else {
                                        au.HU();
                                        com.tencent.mm.model.c.FR().b(oV, abVar);
                                    }
                                    if (!(Yg == null || (Yg.field_type & 2048) == (abVar.field_type & 2048))) {
                                        if ((abVar.field_type & 2048) != 0) {
                                            au.HU();
                                            com.tencent.mm.model.c.FW().Yv(abVar.field_username);
                                        } else {
                                            au.HU();
                                            com.tencent.mm.model.c.FW().Yw(abVar.field_username);
                                        }
                                    }
                                } else {
                                    x.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
                                }
                            }
                        }
                        str3 = com.tencent.mm.platformtools.ab.a(aue.rvi);
                        if (this.ivS == null || this.ivS.bQd == null || this.ivS.bQd.context == null) {
                            x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
                            return;
                        }
                        au.HU();
                        com.tencent.mm.storage.ab Yg2 = com.tencent.mm.model.c.FR().Yg(str3);
                        if (Yg2 != null) {
                            if (aly.cCV != 0) {
                                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
                                Context context = this.ivS.bQd.context;
                                Intent intent2 = new Intent(context, ExdeviceDeviceProfileUI.class);
                                if (!(context instanceof Activity)) {
                                    intent2.addFlags(268435456);
                                }
                                intent2.putExtra("device_id", alx.hbO);
                                intent2.putExtra("device_type", alx.reT);
                                intent2.putExtra("device_mac", aly.rgL);
                                intent2.putExtra("device_brand_name", aly.rOv);
                                intent2.putExtra("device_alias", aly.eJM);
                                intent2.putExtra("device_desc", aly.rOD);
                                intent2.putExtra("device_title", aly.rOC);
                                intent2.putExtra("device_icon_url", aly.jPG);
                                intent2.putExtra("device_jump_url", aly.jOU);
                                intent2.putExtra("bind_ticket", bji.rgQ);
                                intent2.putExtra("device_has_bound", ad.aHe().cA(Yg2.field_username, alx.hbO) != null);
                                context.startActivity(intent2);
                                return;
                            }
                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
                            Intent intent3 = new Intent();
                            intent3.putExtra("Contact_User", str3);
                            intent3.putExtra("KIsHardDevice", true);
                            intent3.putExtra("KHardDeviceBindTicket", bji.rgQ);
                            intent3.putExtra("device_id", alx.hbO);
                            intent3.putExtra("device_type", alx.reT);
                            a.isu.d(intent3, this.ivS.bQd.context);
                            return;
                        }
                        return;
                    }
                }
                str2 = str3;
                arrayList = new ArrayList();
                i3 = 0;
                while (true) {
                    int i42 = i3;
                    if (i42 >= linkedList.size()) {
                        break;
                    }
                    brc brc2 = (brc) linkedList.get(i42);
                    if (brc2.type.contains("text")) {
                        arrayList.add(brc2.content);
                    }
                    i3 = i42 + 1;
                }
                x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[]{bji.rgQ});
                if (bji.sjv != 1) {
                    aue aue2 = bji.rgR;
                    if (aue2 == null) {
                        x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
                        aHc();
                        return;
                    }
                    atI();
                    if (aue2 == null) {
                        x.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
                    } else {
                        str2 = com.tencent.mm.platformtools.ab.a(aue2.rvi);
                        String oV2 = bi.oV(aue2.rXj);
                        if (bi.oW(str2) && bi.oW(oV2)) {
                            x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[]{str2, oV2});
                        } else {
                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[]{str2});
                            au.HU();
                            com.tencent.mm.storage.ab Yg3 = com.tencent.mm.model.c.FR().Yg(str2);
                            if (Yg3 == null || !str2.equals(Yg3.field_encryptUsername)) {
                                com.tencent.mm.storage.ab abVar2 = new com.tencent.mm.storage.ab(str2);
                                abVar2.du(aue2.eJM);
                                abVar2.setType(aue2.ruj & aue2.ruk);
                                if (!bi.oW(oV2)) {
                                    abVar2.dD(oV2);
                                } else if (Yg3 != null && ((int) Yg3.dhP) > 0) {
                                    abVar2.dD(Yg3.field_encryptUsername);
                                }
                                abVar2.dhP = Yg3 == null ? 0 : (long) ((int) Yg3.dhP);
                                abVar2.dx(com.tencent.mm.platformtools.ab.a(aue2.rQz));
                                abVar2.dy(com.tencent.mm.platformtools.ab.a(aue2.ruT));
                                abVar2.dz(com.tencent.mm.platformtools.ab.a(aue2.ruU));
                                abVar2.eJ(aue2.eJH);
                                abVar2.eM(aue2.rup);
                                abVar2.dw(com.tencent.mm.platformtools.ab.a(aue2.rXd));
                                abVar2.eN(aue2.rut);
                                abVar2.eO(aue2.eJL);
                                abVar2.dS(RegionCodeDecoder.aq(aue2.eJQ, aue2.eJI, aue2.eJJ));
                                abVar2.dM(aue2.eJK);
                                abVar2.eF(aue2.rTe);
                                abVar2.dR(aue2.rTf);
                                abVar2.setSource(aue2.rdq);
                                abVar2.eE(aue2.rTi);
                                abVar2.dA(aue2.rTh);
                                if (s.hU(aue2.rTg)) {
                                    abVar2.dQ(aue2.rTg);
                                }
                                abVar2.eQ((int) bi.VE());
                                abVar2.dv(com.tencent.mm.platformtools.ab.a(aue2.rWH));
                                abVar2.dB(com.tencent.mm.platformtools.ab.a(aue2.rWJ));
                                abVar2.dC(com.tencent.mm.platformtools.ab.a(aue2.rWI));
                                abVar2.dT(aue2.rej);
                                abVar2.dU(aue2.rXt);
                                if (!(Yg3 == null || bi.oV(Yg3.csU).equals(bi.oV(aue2.rXt)))) {
                                    com.tencent.mm.at.c.Qt();
                                    com.tencent.mm.at.c.mA(str2);
                                }
                                au.HU();
                                com.tencent.mm.model.c.FR().Yl(str2);
                                if (bi.oW(abVar2.field_username)) {
                                    x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
                                } else {
                                    str3 = abVar2.field_username;
                                    q.KH().a(com.tencent.mm.aa.c.a(str3, aue2));
                                    bqd bqd2 = aue2.rTk;
                                    if (!(abVar2.field_username.endsWith("@chatroom") || bqd2 == null)) {
                                        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + bqd2.eJS + " " + aue2.rvi);
                                        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + bqd2.eJT);
                                        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + bqd2.eJU);
                                        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + bqd2.sod);
                                        if (n.nky != null) {
                                            n.nky.a(abVar2.field_username, bqd2);
                                        }
                                    }
                                    str4 = com.tencent.mm.model.q.GF();
                                    if (!(str4 == null || str4.equals(str3))) {
                                        com.tencent.mm.ac.d kA2 = z.MY().kA(str3);
                                        kA2.field_username = str3;
                                        kA2.field_brandList = aue2.eJR;
                                        qt qtVar2 = aue2.rTl;
                                        if (qtVar2 != null) {
                                            kA2.field_brandFlag = qtVar2.eJV;
                                            kA2.field_brandInfo = qtVar2.eJX;
                                            kA2.field_brandIconURL = qtVar2.eJY;
                                            kA2.field_extInfo = qtVar2.eJW;
                                            kA2.field_attrSyncVersion = null;
                                            kA2.field_incrementUpdateTime = 0;
                                        }
                                        if (!z.MY().e(kA2)) {
                                            z.MY().d(kA2);
                                        }
                                        abVar2.eR(kA2.field_type);
                                    }
                                }
                                abVar2.eH(aue2.rXs);
                                if (!(aue2.rXo == null || aue2.rXo.rcy == null)) {
                                    abVar2.dV(aue2.rXo.rcy.rhn);
                                    abVar2.dW(aue2.rXo.rcy.rho);
                                    abVar2.dX(aue2.rXo.rcy.rhp);
                                }
                                if (s.hO(str2)) {
                                    abVar2.Bk();
                                }
                                if (abVar2.ckW()) {
                                    abVar2.Bn();
                                }
                                if (bi.oW(oV2)) {
                                    au.HU();
                                    com.tencent.mm.model.c.FR().S(abVar2);
                                } else {
                                    au.HU();
                                    com.tencent.mm.model.c.FR().b(oV2, abVar2);
                                }
                                if (!(Yg3 == null || (Yg3.field_type & 2048) == (abVar2.field_type & 2048))) {
                                    if ((abVar2.field_type & 2048) != 0) {
                                        au.HU();
                                        com.tencent.mm.model.c.FW().Yv(abVar2.field_username);
                                    } else {
                                        au.HU();
                                        com.tencent.mm.model.c.FW().Yw(abVar2.field_username);
                                    }
                                }
                            } else {
                                x.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
                            }
                        }
                    }
                    str3 = com.tencent.mm.platformtools.ab.a(aue2.rvi);
                    if (this.ivS == null || this.ivS.bQd == null || this.ivS.bQd.context == null) {
                        x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
                        return;
                    }
                    au.HU();
                    com.tencent.mm.storage.ab Yg22 = com.tencent.mm.model.c.FR().Yg(str3);
                    if (Yg22 != null) {
                        if (aly.cCV != 0) {
                            x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
                            Context context2 = this.ivS.bQd.context;
                            Intent intent22 = new Intent(context2, ExdeviceDeviceProfileUI.class);
                            if (!(context2 instanceof Activity)) {
                                intent22.addFlags(268435456);
                            }
                            intent22.putExtra("device_id", alx.hbO);
                            intent22.putExtra("device_type", alx.reT);
                            intent22.putExtra("device_mac", aly.rgL);
                            intent22.putExtra("device_brand_name", aly.rOv);
                            intent22.putExtra("device_alias", aly.eJM);
                            intent22.putExtra("device_desc", aly.rOD);
                            intent22.putExtra("device_title", aly.rOC);
                            intent22.putExtra("device_icon_url", aly.jPG);
                            intent22.putExtra("device_jump_url", aly.jOU);
                            intent22.putExtra("bind_ticket", bji.rgQ);
                            intent22.putExtra("device_has_bound", ad.aHe().cA(Yg22.field_username, alx.hbO) != null);
                            context2.startActivity(intent22);
                            return;
                        }
                        x.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
                        Intent intent32 = new Intent();
                        intent32.putExtra("Contact_User", str3);
                        intent32.putExtra("KIsHardDevice", true);
                        intent32.putExtra("KHardDeviceBindTicket", bji.rgQ);
                        intent32.putExtra("device_id", alx.hbO);
                        intent32.putExtra("device_type", alx.reT);
                        a.isu.d(intent32, this.ivS.bQd.context);
                        return;
                    }
                    return;
                }
                Intent intent4 = new Intent();
                intent4.putExtra("device_scan_mode", "SCAN_CATALOG");
                Object obj2 = (aly.rOw.contains("3") || aly.rOw.contains("1")) ? 1 : null;
                boolean contains2 = aly.rOw.contains("4");
                if (obj2 == null || !contains2) {
                    if (obj2 != null) {
                        intent4.putExtra("device_scan_conn_proto", "blue");
                    } else if (contains2) {
                        intent4.putExtra("device_scan_conn_proto", "wifi");
                    }
                    intent4.putExtra("device_id", alx.hbO);
                    intent4.putExtra("device_type", alx.reT);
                    intent4.putExtra("device_title", aly.rOC);
                    intent4.putExtra("device_desc", aly.rOD);
                    intent4.putExtra("device_icon_url", aly.jPG);
                    intent4.putExtra("device_category_id", aly.rOE);
                    intent4.putExtra("device_brand_name", aly.rOv);
                    intent4.putExtra("bind_ticket", bji.rgQ);
                    intent4.putExtra("device_ble_simple_proto", aly.cCW);
                    intent4.putExtra("device_airkiss_key", str2);
                    intent4.putExtra("device_airkiss_title", str4);
                    intent4.putStringArrayListExtra("device_airkiss_steps", arrayList);
                    d.b(this.ivS.bQd.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", intent4);
                    atI();
                    return;
                }
                x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
            }
        } else {
            x.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[]{Integer.valueOf(lVar.getType())});
            aHc();
        }
    }

    private void aHc() {
        if (this.ivS != null && this.ivS.bJX != null) {
            this.ivS.bQe.ret = 1;
            this.ivS.bJX.run();
        }
    }

    private void atI() {
        if (this.ivS != null && this.ivS.bJX != null) {
            this.ivS.bQe.ret = 2;
            this.ivS.bJX.run();
        }
    }
}
