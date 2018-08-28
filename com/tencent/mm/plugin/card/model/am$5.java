package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ab.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.c.kv;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

class am$5 implements a {
    final /* synthetic */ am hxV;

    am$5(am amVar) {
        this.hxV = amVar;
    }

    public final void a(final d.a aVar) {
        final String a = ab.a(aVar.dIN.rcl);
        if (a == null || a.length() == 0) {
            x.e("MicroMsg.SubCoreCard.CardMsgListener", "onReceiveMsg, msgContent is null");
        } else {
            am.a(this.hxV).post(new Runnable() {
                public final void run() {
                    k axm = am.axm();
                    Object obj = a;
                    String str = aVar.dIN.rcq;
                    x.i("MicroMsg.CardMsgManager", "card onReceiveMsg msgId is " + str);
                    if (!TextUtils.isEmpty(obj)) {
                        g gVar;
                        String str2;
                        Map z = bl.z(obj, "sysmsg");
                        if (z == null) {
                            gVar = null;
                        } else {
                            g gVar2 = new g();
                            str2 = (String) z.get(".sysmsg.carditemmsg.card_type");
                            if (TextUtils.isEmpty(str2) || !l.xW(str2)) {
                                gVar2.field_card_type = 0;
                            } else {
                                gVar2.field_card_type = Integer.valueOf(str2).intValue();
                            }
                            gVar2.field_title = (String) z.get(".sysmsg.carditemmsg.title");
                            gVar2.field_description = (String) z.get(".sysmsg.carditemmsg.description");
                            gVar2.field_logo_url = (String) z.get(".sysmsg.carditemmsg.logo_url");
                            gVar2.field_logo_color = (String) z.get(".sysmsg.carditemmsg.logo_color");
                            str2 = (String) z.get(".sysmsg.carditemmsg.time");
                            if (TextUtils.isEmpty(str2) || !l.xW(str2)) {
                                gVar2.field_time = (int) (System.currentTimeMillis() / 1000);
                            } else if (Long.valueOf(str2).longValue() >= 2147483647L) {
                                gVar2.field_time = Integer.MAX_VALUE;
                            } else {
                                gVar2.field_time = Integer.valueOf(str2).intValue();
                            }
                            gVar2.field_card_id = (String) z.get(".sysmsg.carditemmsg.card_id");
                            gVar2.field_card_tp_id = (String) z.get(".sysmsg.carditemmsg.card_tp_id");
                            gVar2.field_msg_id = (String) z.get(".sysmsg.carditemmsg.msg_id");
                            str2 = (String) z.get(".sysmsg.carditemmsg.msg_type");
                            if (TextUtils.isEmpty(str2) || !l.xW(str2)) {
                                gVar2.field_msg_type = 0;
                            } else {
                                gVar2.field_msg_type = Integer.valueOf(str2).intValue();
                            }
                            str2 = (String) z.get(".sysmsg.carditemmsg.jump_type");
                            if (TextUtils.isEmpty(str2) || !l.xW(str2)) {
                                gVar2.field_jump_type = 1;
                            } else {
                                gVar2.field_jump_type = Integer.valueOf(str2).intValue();
                            }
                            gVar2.field_url = (String) z.get(".sysmsg.carditemmsg.url");
                            str2 = (String) z.get(".sysmsg.carditemmsg.button.text");
                            if (!TextUtils.isEmpty(str2)) {
                                kv kvVar = new kv();
                                kvVar.text = str2;
                                kvVar.url = (String) z.get(".sysmsg.carditemmsg.button.url");
                                str2 = (String) z.get(".sysmsg.carditemmsg.button.action_type");
                                if (TextUtils.isEmpty(str2) || !l.xW(str2)) {
                                    kvVar.hwF = 0;
                                } else {
                                    kvVar.hwF = Integer.valueOf(str2).intValue();
                                }
                                gVar2.hwu = kvVar;
                                try {
                                    gVar2.field_buttonData = gVar2.hwu.toByteArray();
                                } catch (Throwable e) {
                                    x.e("MicroMsg.CardMsgInfo", "setCardButton fail, ex = %s", new Object[]{e.getMessage()});
                                    x.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
                                }
                            }
                            str2 = (String) z.get(".sysmsg.carditemmsg.opt_region.text");
                            if (!TextUtils.isEmpty(str2)) {
                                kz kzVar = new kz();
                                kzVar.text = str2;
                                kzVar.url = (String) z.get(".sysmsg.carditemmsg.opt_region.url");
                                str2 = (String) z.get(".sysmsg.carditemmsg.opt_region.type");
                                if (TextUtils.isEmpty(str2) || !l.xW(str2)) {
                                    kzVar.type = 0;
                                } else {
                                    kzVar.type = Integer.valueOf(str2).intValue();
                                }
                                str2 = (String) z.get(".sysmsg.carditemmsg.opt_region.endtime");
                                if (TextUtils.isEmpty(str2) || !l.xW(str2)) {
                                    kzVar.mXw = (int) (System.currentTimeMillis() / 1000);
                                } else if (Long.valueOf(str2).longValue() >= 2147483647L) {
                                    kzVar.mXw = Integer.MAX_VALUE;
                                } else {
                                    kzVar.mXw = Integer.valueOf(str2).intValue();
                                }
                                gVar2.hwv = kzVar;
                                try {
                                    gVar2.field_operData = gVar2.hwv.toByteArray();
                                } catch (Throwable e2) {
                                    x.e("MicroMsg.CardMsgInfo", "setOperationRegion fail, ex = %s", new Object[]{e2.getMessage()});
                                    x.printErrStackTrace("MicroMsg.CardMsgInfo", e2, "", new Object[0]);
                                }
                            }
                            str2 = (String) z.get(".sysmsg.carditemmsg.report_scene");
                            if (TextUtils.isEmpty(str2) || !l.xW(str2)) {
                                gVar2.field_report_scene = 2;
                            } else {
                                gVar2.field_report_scene = Integer.valueOf(str2).intValue();
                            }
                            gVar2.field_read_state = 1;
                            gVar2.field_accept_buttons = k.j(z, ".sysmsg.carditemmsg");
                            gVar2.field_jump_buttons = k.i(z, ".sysmsg.carditemmsg");
                            str2 = (String) z.get(".sysmsg.carditemmsg.get_layout_scene");
                            if (TextUtils.isEmpty(str2) || !l.xW(str2)) {
                                gVar2.hwy = 0;
                            } else {
                                gVar2.hwy = Integer.valueOf(str2).intValue();
                            }
                            gVar2.field_consumed_box_id = (String) z.get(".sysmsg.carditemmsg.consumed_box_id");
                            gVar2.hwo = (String) z.get(".sysmsg.carditemmsg.reddot_wording");
                            gVar2.hwp = (String) z.get(".sysmsg.carditemmsg.reddot_buff");
                            gVar2.hwq = (String) z.get(".sysmsg.carditemmsg.reddot_icon_url");
                            gVar2.hwr = (String) z.get(".sysmsg.carditemmsg.msg_tips.title");
                            gVar2.hws = (String) z.get(".sysmsg.carditemmsg.msg_tips.icon_url");
                            str2 = (String) z.get(".sysmsg.carditemmsg.msg_scene");
                            if (TextUtils.isEmpty(str2) || !l.xW(str2)) {
                                gVar2.hwz = 0;
                            } else {
                                gVar2.hwz = Integer.valueOf(str2).intValue();
                                x.i("MicroMsg.CardMsgManager", "msg_scene is " + str2);
                            }
                            str2 = (String) z.get(".sysmsg.carditemmsg.need_check");
                            x.i("MicroMsg.CardMsgManager", "need_check:" + str2);
                            if (TextUtils.isEmpty(str2)) {
                                gVar2.hwt = false;
                            } else {
                                gVar2.hwt = str2.equals("true");
                            }
                            String str3 = (String) z.get(".sysmsg.carditemmsg.all_unavailable");
                            x.i("MicroMsg.CardMsgManager", "all_Unavailable:" + str2);
                            if (TextUtils.isEmpty(str3)) {
                                gVar2.hwA = false;
                            } else {
                                gVar2.hwA = str3.equals("true");
                            }
                            gVar2.field_unavailable_qr_code_list = k.k(z, ".sysmsg.carditemmsg");
                            gVar = gVar2;
                        }
                        if (gVar == null) {
                            x.e("MicroMsg.CardMsgManager", "card msg == null");
                            return;
                        }
                        if (TextUtils.isEmpty(gVar.field_card_id)) {
                            x.e("MicroMsg.CardMsgManager", "card id == null");
                        }
                        str2 = gVar.field_msg_id;
                        gVar.field_msg_id = str;
                        if (TextUtils.isEmpty(gVar.field_msg_id)) {
                            gVar.field_msg_id = str2;
                        }
                        if (TextUtils.isEmpty(gVar.field_msg_id)) {
                            gVar.field_msg_id = System.currentTimeMillis();
                        }
                        x.i("MicroMsg.CardMsgManager", "msg.field_msg_id : " + gVar.field_msg_id);
                        x.i("MicroMsg.CardMsgManager", "msg for msg_type ==  " + gVar.field_msg_type);
                        if (gVar.hwy != 0) {
                            g.Ei().DT().a(aa.a.sPY, Integer.valueOf(gVar.hwy));
                        }
                        x.i("MicroMsg.CardMsgManager", "reddot_buff is " + gVar.hwp);
                        if (TextUtils.isEmpty(gVar.hwp)) {
                            x.e("MicroMsg.CardMsgManager", "reddot_buff is empty");
                        } else {
                            g.Ei().DT().a(aa.a.sPU, gVar.hwp);
                        }
                        if ((gVar.field_msg_type & 1) != 0) {
                            x.i("MicroMsg.CardMsgManager", "msg_tips_title is " + gVar.hwr);
                            x.i("MicroMsg.CardMsgManager", "msg_tips_icon_url is " + gVar.hws);
                            g.Ei().DT().a(aa.a.sPW, gVar.hwr);
                            g.Ei().DT().a(aa.a.sPX, gVar.hws);
                        }
                        boolean aT = c.Cp().aT(262152, 266256);
                        if (!(aT || (gVar.field_msg_type & 64) == 0)) {
                            c.Cp().u(262152, true);
                            aT = true;
                        }
                        if (aT) {
                            x.i("MicroMsg.CardMsgManager", "has card new msg, return");
                        } else {
                            x.i("MicroMsg.CardMsgManager", "not has new!");
                            obj = null;
                            if ((gVar.field_msg_type & 32) != 0) {
                                c.Cp().v(262152, true);
                                x.i("MicroMsg.CardMsgManager", "has reddot");
                                obj = 1;
                            } else {
                                x.e("MicroMsg.CardMsgManager", "not has reddot!");
                            }
                            Object obj2 = null;
                            if (TextUtils.isEmpty(gVar.hwo)) {
                                x.e("MicroMsg.CardMsgManager", "reddot_wording is empty!");
                            } else {
                                x.i("MicroMsg.CardMsgManager", "reddot_wording is " + gVar.hwo);
                                g.Ei().DT().a(aa.a.sPS, gVar.hwo);
                                c.Cp().a(aa.a.sPM, true);
                                obj2 = 1;
                            }
                            Object obj3 = null;
                            x.i("MicroMsg.CardMsgManager", "reddot_icon_url is " + gVar.hwq);
                            if (TextUtils.isEmpty(gVar.hwq)) {
                                x.e("MicroMsg.CardMsgManager", "reddot_icon_url is empty");
                            } else {
                                g.Ei().DT().a(aa.a.sPV, gVar.hwq);
                                c.Cp().a(aa.a.sPN, true);
                                obj3 = 1;
                            }
                            if (obj == null || obj2 == null || obj3 == null) {
                                if (obj != null && obj2 != null && obj3 == null) {
                                    c.Cp().a(aa.a.sPN, false);
                                    g.Ei().DT().a(aa.a.sPV, "");
                                } else if (obj != null && obj2 == null && obj3 != null) {
                                    c.Cp().a(aa.a.sPM, false);
                                    g.Ei().DT().a(aa.a.sPS, "");
                                } else if (obj == null && obj2 != null && obj3 != null) {
                                    c.Cp().v(262152, false);
                                } else if (obj != null && obj2 == null && obj3 == null) {
                                    c.Cp().a(aa.a.sPN, false);
                                    g.Ei().DT().a(aa.a.sPV, "");
                                    c.Cp().a(aa.a.sPM, false);
                                    g.Ei().DT().a(aa.a.sPS, "");
                                } else if (obj == null && obj2 != null && obj3 == null) {
                                    c.Cp().a(aa.a.sPN, false);
                                    g.Ei().DT().a(aa.a.sPV, "");
                                    c.Cp().v(262152, false);
                                } else if (obj == null && obj2 == null && obj3 != null) {
                                    c.Cp().a(aa.a.sPM, false);
                                    g.Ei().DT().a(aa.a.sPS, "");
                                    c.Cp().v(262152, false);
                                }
                            }
                            if (!(obj == null && obj2 == null && obj3 == null)) {
                                g.Ei().DT().a(aa.a.sQj, gVar.field_card_id);
                                g.Ei().DT().a(aa.a.sQk, Boolean.valueOf(gVar.hwt));
                                x.i("MicroMsg.CardMsgManager", "card_id:" + gVar.field_card_id + "  need_check:" + gVar.hwt);
                            }
                        }
                        if ((gVar.field_msg_type & 1) != 0) {
                            if (axm.xi(gVar.field_msg_id)) {
                                x.e("MicroMsg.CardMsgManager", "msg for id " + gVar.field_msg_id + " is exist!!");
                                axm.xj(gVar.field_msg_id);
                                axm.huM.add(gVar);
                                k.c(gVar);
                            } else {
                                axm.huM.add(gVar);
                                k.c(gVar);
                                if ((gVar.field_msg_type & 128) != 0) {
                                    axm.huN++;
                                }
                            }
                            g.Ei().DT().set(139268, Integer.valueOf(axm.huN));
                            axm.a(gVar);
                        }
                        if ((gVar.field_msg_type & 2) != 0) {
                            am.axh();
                            b.nG(gVar.hwy);
                        }
                        if ((gVar.field_msg_type & 4) != 0) {
                            axm.auM();
                        }
                        if ((gVar.field_msg_type & 8) != 0) {
                            am.axo().p(gVar.field_card_id, gVar.field_card_tp_id, gVar.field_report_scene);
                        }
                        if ((gVar.field_msg_type & 1024) != 0) {
                            gVar.axb();
                            am.axy().b(gVar);
                        }
                        l.azQ();
                    }
                }
            });
        }
    }
}
