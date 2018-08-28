package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.chatroom.d.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a(cwo = com.tencent.mm.ui.chatting.b.b.e.class)
public class e extends a implements com.tencent.mm.ab.e, b, com.tencent.mm.ui.chatting.b.b.e {
    private com.tencent.mm.pluginsdk.c.b tOA = new com.tencent.mm.pluginsdk.c.b() {
        public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
            e.this.bAG.dismissDialog();
            if (bVar instanceof jx) {
                if (i == 0 && i2 == 0) {
                    if (i == 0 && i2 == 0) {
                        h.bA(e.this.bAG.tTq.getContext(), e.this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_remove_it_done));
                    }
                } else if (i2 == -2024) {
                    com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(e.this.bAG.tTq.getContext(), null, null);
                    } else {
                        h.a(e.this.bAG.tTq.getContext(), e.this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_deleted), null, e.this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_got_it), false, new 1(this));
                    }
                } else {
                    h.a(e.this.bAG.tTq.getContext(), e.this.bAG.tTq.getMMResources().getString(R.l.room_delete_tips_network_err), null, e.this.bAG.tTq.getMMResources().getString(R.l.app_ok), false, new 2(this));
                }
            } else if (!(bVar instanceof kc)) {
            } else {
                if (i != 0 || i2 != 0) {
                    h.a(e.this.bAG.tTq.getContext(), e.this.bAG.tTq.getMMResources().getString(R.l.room_delete_tips_network_err), null, e.this.bAG.tTq.getMMResources().getString(R.l.app_ok), false, new 3(this));
                } else if (i == 0 && i2 == 0) {
                    h.bA(e.this.bAG.tTq.getContext(), e.this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_cancel_qrcode_done));
                }
            }
        }
    };
    private boolean tOB = false;
    protected boolean tOv = false;
    protected Map<String, String> tOw = new HashMap();
    private c tOx = new c<ao>() {
        {
            this.sFo = ao.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ao aoVar = (ao) bVar;
            if ((aoVar instanceof ao) && e.this.bAG.getTalkerUserName() != null && !bi.oW(aoVar.bHW.username) && aoVar.bHW.username.equals(e.this.bAG.getTalkerUserName())) {
                e.this.cuJ();
            }
            return false;
        }
    };
    private final j.a tOy = new 4(this);
    private c tOz = new c<rs>() {
        {
            this.sFo = rs.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rs rsVar = (rs) bVar;
            if ((!(rsVar instanceof rs) || e.this.bAG.getTalkerUserName().equals(rsVar.ccD.userName)) && e.this.bAG.getTalkerUserName().toLowerCase().endsWith("@chatroom")) {
                h.b(e.this.bAG.tTq.getContext(), e.this.bAG.tTq.getMMResources().getString(R.l.track_room_kicked_tip), null, true);
            }
            return false;
        }
    };
    private boolean toR = false;

    public final String gT(String str) {
        com.tencent.mm.ui.chatting.b.b.c cVar = (com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class);
        String gU = r.gU(str);
        if (!cVar.cur() && !bi.oW(gU)) {
            return gU;
        }
        if (this.tOw.containsKey(str)) {
            gU = (String) this.tOw.get(str);
            if (!bi.oW(gU)) {
                return gU;
            }
        }
        if (cVar.cur()) {
            return cVar.cup().gT(str);
        }
        return r.gT(str);
    }

    public final boolean cuH() {
        return this.tOv;
    }

    public final boolean cuI() {
        return this.toR || ((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cux();
    }

    public final void aw(LinkedList<String> linkedList) {
        au.HU();
        u ih = com.tencent.mm.model.c.Ga().ih(this.bAG.getTalkerUserName());
        if (ih == null) {
            h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.room_delete_quit), null, this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_got_it), new 6(this));
            return;
        }
        String str;
        this.bAG.getTalkerUserName();
        List linkedList2 = new LinkedList();
        List Nn = ih.Nn();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (Nn != null && Nn.contains(str)) {
                linkedList2.add(str);
            }
        }
        if (linkedList2.size() == 0) {
            if (linkedList.size() == 1) {
                h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_deleted), null, this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_got_it), new 7(this));
            } else {
                h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_all_left), null, this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_got_it), new 8(this));
            }
        } else if (linkedList.size() == 1) {
            Resources mMResources = this.bAG.tTq.getMMResources();
            int i = R.l.room_delete_member_alert;
            Object[] objArr = new Object[1];
            str = (String) linkedList.get(0);
            if (((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cus() || s.fq(this.bAG.getTalkerUserName())) {
                au.HU();
                ab Yg = com.tencent.mm.model.c.FR().Yg(str);
                if (!(Yg == null || ((int) Yg.dhP) == 0)) {
                    if (bi.oW(Yg.field_conRemark)) {
                        au.HU();
                        ih = com.tencent.mm.model.c.Ga().ih(this.bAG.getTalkerUserName());
                        str = ih == null ? null : ih.gT(Yg.field_username);
                    } else {
                        str = Yg.field_conRemark;
                    }
                    if (bi.oW(str)) {
                        str = Yg.field_conRemark;
                    }
                    if (bi.oW(str)) {
                        str = Yg.BK();
                    }
                }
            } else {
                str = null;
            }
            objArr[0] = str;
            h.a(this.bAG.tTq.getContext(), mMResources.getString(i, objArr), null, this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_remove_it), this.bAG.tTq.getMMResources().getString(R.l.app_cancel), true, new 9(this, linkedList2), new 10(this));
        } else {
            Intent intent = new Intent();
            intent.putExtra("members", bi.c(linkedList2, ","));
            intent.putExtra("RoomInfo_Id", this.bAG.getTalkerUserName());
            intent.putExtra("scene", 1);
            d.b(this.bAG.tTq.getContext(), "chatroom", ".ui.DelChatroomMemberUI", intent);
        }
    }

    public final void a(List<String> list, String str, bd bdVar) {
        k kVar = new k(s.fq(this.bAG.getTalkerUserName()) ? this.bAG.getTalkerUserName() : "", list, str, bdVar);
        au.DF().a(kVar, 0);
        com.tencent.mm.ui.chatting.c.a aVar = this.bAG;
        Context context = this.bAG.tTq.getContext();
        this.bAG.tTq.getMMResources().getString(R.l.app_tip);
        aVar.d(context, this.bAG.tTq.getMMResources().getString(R.l.room_invite_member), new 11(this, kVar));
    }

    private void csI() {
        com.tencent.mm.ui.chatting.b.b.c cVar = (com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class);
        if (s.fq(this.bAG.getTalkerUserName())) {
            this.tOv = m.gA(this.bAG.getTalkerUserName());
            if (this.tOv) {
                m.c(this.bAG.getTalkerUserName(), this.tOw);
            } else {
                this.tOw.clear();
            }
            x.d("MicroMsg.ChattingUI.ChatroomComponent", "chatroom display  " + (this.tOv ? "show " : "not show"));
        } else if (cVar.cus()) {
            this.tOv = true;
        } else {
            this.tOv = false;
            this.tOw.clear();
        }
    }

    private void cuJ() {
        if (this.bAG.oLT == null) {
            x.e("MicroMsg.ChattingUI.ChatroomComponent", "getChatroomMemberDetail() talker == null");
        } else if (s.fq(this.bAG.getTalkerUserName())) {
            x.d("MicroMsg.ChattingUI.ChatroomComponent", "cpan[changeTalker]");
            new ag().postDelayed(new 2(this), 1000);
        }
    }

    public final void cpF() {
        if (s.fq(this.bAG.getTalkerUserName())) {
            this.toR = m.gC(this.bAG.getTalkerUserName());
        }
    }

    public final void cpG() {
        this.tOB = true;
        csI();
    }

    public final void cpH() {
        if (!s.hO(this.bAG.getTalkerUserName()) && s.fq(this.bAG.getTalkerUserName())) {
            au.HU();
            ai Yq = com.tencent.mm.model.c.FW().Yq(this.bAG.getTalkerUserName());
            if (Yq == null || (Yq.field_showTips & 2) > 0) {
                x.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : already tips");
            } else {
                au.HU();
                u ih = com.tencent.mm.model.c.Ga().ih(this.bAG.getTalkerUserName());
                if (ih == null || ih.Nn().size() < 20) {
                    x.d("MicroMsg.ChattingUI.ChatroomComponent", "jacks ont need auto display name because : member nums too few");
                } else if (!(ih == null || ih.ckP())) {
                    m.a(this.bAG.getTalkerUserName(), ih, true);
                    Yq.field_showTips = 2;
                    Yq.ctz = true;
                    au.HU();
                    com.tencent.mm.model.c.FW().a(Yq, this.bAG.getTalkerUserName());
                    x.i("MicroMsg.ChattingUI.ChatroomComponent", "Jacks Show auto Display name tips");
                    l.a(this.bAG.getTalkerUserName(), null, this.bAG.tTq.getMMResources().getString(R.l.chatting_show_display_name_tips), false, "", 0);
                }
            }
        }
        au.DF().a(610, this);
        au.DF().a(551, this);
        au.HU();
        com.tencent.mm.model.c.FR().a(this);
        au.HU();
        com.tencent.mm.model.c.Ga().c(this.tOy);
        com.tencent.mm.pluginsdk.c.b.a(jx.class.getName(), this.tOA);
        com.tencent.mm.pluginsdk.c.b.a(kc.class.getName(), this.tOA);
        com.tencent.mm.sdk.b.a.sFg.b(this.tOx);
        com.tencent.mm.sdk.b.a.sFg.b(this.tOz);
        if (s.fq(this.bAG.getTalkerUserName()) && m.gD(this.bAG.getTalkerUserName())) {
            x.d("MicroMsg.ChattingUI.ChatroomComponent", "chattingui find chatroom contact need update %s", new Object[]{this.bAG.getTalkerUserName()});
            am.a.dBr.R(this.bAG.getTalkerUserName(), "");
        }
        if (!(com.tencent.mm.ay.d.eli == null || this.bAG.getTalkerUserName().equals(com.tencent.mm.ay.d.eli.SD()))) {
            x.i("MicroMsg.ChattingUI.ChatroomComponent", "chatting oncreate end track %s", new Object[]{com.tencent.mm.ay.d.eli.SD()});
            er erVar = new er();
            erVar.bMv.username = this.bAG.getTalkerUserName();
            com.tencent.mm.sdk.b.a.sFg.m(erVar);
        }
        cuJ();
    }

    public final void cpI() {
        if (!this.tOB) {
            csI();
        }
        this.tOB = false;
    }

    public final void cpJ() {
    }

    public final void cpK() {
        au.DF().b(610, this);
        au.HU();
        com.tencent.mm.model.c.FR().b(this);
        au.DF().b(551, this);
        com.tencent.mm.pluginsdk.c.b.b(jx.class.getName(), this.tOA);
        com.tencent.mm.pluginsdk.c.b.b(kc.class.getName(), this.tOA);
        if (au.HX()) {
            au.HU();
            com.tencent.mm.model.c.Ga().d(this.tOy);
            com.tencent.mm.sdk.b.a.sFg.c(this.tOx);
            com.tencent.mm.sdk.b.a.sFg.c(this.tOz);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + lVar.getType());
        this.bAG.dismissDialog();
        if (!this.bAG.eaR) {
            x.i("MicroMsg.ChattingUI.ChatroomComponent", "onSceneEnd fragment not foreground, return");
        } else if (bi.ci(this.bAG.tTq.getContext())) {
            Context context = this.bAG.tTq.getContext();
            boolean z = w.a.a(context, i, i2, str, 7) ? true : w.a(context, i, i2, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str);
            if (!z) {
                if (i == 0 && i2 == 0) {
                    switch (lVar.getType()) {
                        case 551:
                            x.i("MicroMsg.ChattingUI.ChatroomComponent", "cpan[refresh top btn]");
                            this.toR = m.gC(this.bAG.getTalkerUserName());
                            ((o) this.bAG.O(o.class)).cvp();
                            return;
                        case 610:
                            bd bdVar = ((k) lVar).bXQ;
                            if (bdVar != null) {
                                bdVar.cmB();
                                au.HU();
                                com.tencent.mm.model.c.FT().b(bdVar.field_msgSvrId, bdVar);
                                Toast.makeText(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.invite_room_mem_ok_toast), 0).show();
                                com.tencent.mm.plugin.report.service.h.mEJ.a(219, 24, (long) ((k) lVar).hLg, true);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } else if (lVar.getType() == 610) {
                    x.d("MicroMsg.ChattingUI.ChatroomComponent", "scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[]{Integer.valueOf(610), Integer.valueOf(i2), Integer.valueOf(i), bi.oV(str)});
                    h.b(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.invite_room_mem_err), this.bAG.tTq.getMMResources().getString(R.l.app_tip), true);
                }
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (this.bAG == null) {
            x.e("MicroMsg.ChattingUI.ChatroomComponent", "[onNotifyChange] mChattingContext is null!");
        } else if (((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cus()) {
            this.toR = com.tencent.mm.ac.a.e.c(((com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cup());
        } else {
            this.toR = m.gC(this.bAG.getTalkerUserName());
        }
    }
}
