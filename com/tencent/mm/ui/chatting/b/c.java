package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.a.d$a;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.a.v;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.d$b;
import com.tencent.mm.ac.e;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.k;
import com.tencent.mm.ac.m;
import com.tencent.mm.ac.n;
import com.tencent.mm.ac.z;
import com.tencent.mm.ao.b;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(cwo = com.tencent.mm.ui.chatting.b.b.c.class)
public class c extends a implements n, com.tencent.mm.ui.chatting.b.b.c {
    private d lUs;
    public j lVG;
    private com.tencent.mm.ui.widget.a.c lVP = null;
    public boolean qIZ = false;
    public com.tencent.mm.ac.a.c tDV;
    private d$a tEA = new 11(this);
    protected final ChatFooter.d tGN = new 10(this);
    protected final a tHP = new 9(this);
    private com.tencent.mm.app.plugin.a.a tOc;
    private long tOd = 0;
    public boolean tOe = false;
    private long tOf = -1;
    private RelativeLayout tOg;
    private TextView tOh;
    private m.a.a tOi = new 1(this);
    private boolean tOj = false;
    private e.a tOk = new 12(this);
    private boolean tOl = false;

    public final d cuo() {
        return this.lUs;
    }

    public final com.tencent.mm.ac.a.c cup() {
        return this.tDV;
    }

    public final j cuq() {
        return this.lVG;
    }

    public final boolean cur() {
        return this.qIZ;
    }

    public final boolean cus() {
        return this.tOe;
    }

    public static boolean av(Intent intent) {
        String stringExtra = intent.getStringExtra("Chat_User");
        boolean booleanExtra = intent.getBooleanExtra("key_is_biz_chat", false);
        if (!booleanExtra && stringExtra == null) {
            x.e("MicroMsg.ChattingUI.BizComponent", "talker is null !!!");
            return true;
        } else if (!booleanExtra || intent.getLongExtra("key_biz_chat_id", -1) != -1) {
            return false;
        } else {
            x.e("MicroMsg.ChattingUI.BizComponent", "bizChatId is null !!");
            return true;
        }
    }

    public final boolean cut() {
        if (!this.qIZ) {
            return false;
        }
        if (this.tOe) {
            int bj = com.tencent.mm.ac.a.e.bj(cuC());
            if (!bi.oW(this.tDV.field_chatName)) {
                ((o) this.bAG.O(o.class)).setMMTitle(this.bAG.tTq.getMMResources().getString(R.l.fmt_chatting_title_group, new Object[]{this.tDV.field_chatName, Integer.valueOf(bj)}));
            } else if (bj == 0) {
                this.bAG.tTq.setMMTitle(this.bAG.tTq.getMMResources().getString(R.l.chatting_roominfo_noname));
            } else {
                this.bAG.tTq.setMMTitle(this.bAG.tTq.getMMResources().getString(R.l.fmt_chatting_title_group, new Object[]{this.bAG.tTq.getMMResources().getString(R.l.chatting_roominfo_noname), Integer.valueOf(bj)}));
            }
        } else {
            this.bAG.tTq.setMMTitle(this.lVG.field_userName);
        }
        return true;
    }

    public final a cuu() {
        return this.tHP;
    }

    public final ChatFooter.d cuv() {
        return this.tGN;
    }

    public final String le(String str) {
        j kZ = this.tDV.kZ(str);
        if (kZ != null) {
            return kZ.field_headImageUrl;
        }
        return null;
    }

    public final List<bd> cuw() {
        int i = 100;
        com.tencent.mm.ac.a.a bd = z.Nb().bd(cuC());
        if (bd.field_unReadCount <= 100) {
            i = bd.field_unReadCount;
        }
        au.HU();
        return com.tencent.mm.model.c.FU().h(this.bAG.oLT.field_username, cuC(), i);
    }

    public final boolean cux() {
        return this.tOl;
    }

    public final void cuy() {
        if (com.tencent.mm.l.a.gd(this.bAG.oLT.field_type) && this.bAG.oLT.ckW() && !f.eZ(this.bAG.getTalkerUserName())) {
            g gVar = (g) this.bAG.O(g.class);
            z.Nj().b(this.bAG.getTalkerUserName(), gVar.getCount() > 0 ? gVar.ES(gVar.getCount() - 1) : null);
        }
    }

    private boolean f(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1 && (this.lUs == null || this.lUs.bG(false) == null || this.lUs.bG(false).My() == null || this.lUs.bG(false).My().dLC == null || this.lUs.bG(false).My().dLC.isEmpty())) {
            ((com.tencent.mm.ui.chatting.b.b.m) this.bAG.O(com.tencent.mm.ui.chatting.b.b.m.class)).cvb().cej();
        }
        return false;
    }

    public final String cuz() {
        if (this.qIZ) {
            if (this.tOe) {
                if (this.tDV == null) {
                    return null;
                }
                return this.tDV.field_chatName;
            } else if (this.lVG != null) {
                return this.lVG.field_userName;
            } else {
                return null;
            }
        } else if (this.bAG.oLT != null) {
            return this.bAG.oLT.field_nickname;
        } else {
            return null;
        }
    }

    public final boolean cuA() {
        boolean z = false;
        Intent intent = new Intent();
        boolean z2 = s.fq(this.bAG.getTalkerUserName()) || this.tOe;
        if (z2 && !this.qIZ) {
            intent.putExtra("Chat_User", this.bAG.oLT.field_username);
            intent.putExtra("RoomInfo_Id", this.bAG.getTalkerUserName());
            intent.putExtra("Is_Chatroom", s.fq(this.bAG.getTalkerUserName()));
            intent.putExtra("fromChatting", true);
            com.tencent.mm.bg.d.b(this.bAG.tTq.getContext(), "chatroom", ".ui.ChatroomInfoUI", intent);
            return true;
        } else if (this.qIZ) {
            intent.setClass(this.bAG.tTq.getContext(), BizChatroomInfoUI.class);
            intent.putExtra("Chat_User", this.bAG.oLT.field_username);
            intent.putExtra("key_biz_chat_id", cuC());
            if (this.bAG.tTq.thisActivity() instanceof ChattingUI) {
                intent.putExtra("key_biz_chat_info_from_scene", 1);
            } else {
                intent.putExtra("key_biz_chat_info_from_scene", 2);
            }
            this.bAG.tTq.startActivity(intent);
            return true;
        } else if (!s.hL(this.bAG.getTalkerUserName()) && !ab.XO(this.bAG.getTalkerUserName()) && !ab.XQ(this.bAG.getTalkerUserName()) && !s.hH(this.bAG.getTalkerUserName()) && !ab.gY(this.bAG.getTalkerUserName()) && !this.bAG.oLT.ckW()) {
            return false;
        } else {
            Intent intent2 = new Intent();
            com.tencent.mm.ui.contact.e.l(intent2, this.bAG.getTalkerUserName());
            intent2.putExtra("Kdel_from", 0);
            intent = this.bAG.tTq.getContext().getIntent();
            int intExtra = intent.getIntExtra("key_temp_session_scene", 5);
            if (intExtra == 16 || intExtra == 17 || intent.getBooleanExtra("key_biz_profile_stay_after_follow_op", false)) {
                intent2.putExtra("Kdel_from", 1);
                z = true;
            }
            intent2.putExtra("key_biz_profile_stay_after_follow_op", z);
            if (((com.tencent.mm.ui.chatting.b.b.s) this.bAG.O(com.tencent.mm.ui.chatting.b.b.s.class)).cvJ() && i.aan(this.bAG.getTalkerUserName())) {
                if (intExtra == 16) {
                    intent2.putExtra("Contact_Scene", 92);
                } else if (intExtra == 17) {
                    intent2.putExtra("Contact_Scene", 93);
                } else if (intExtra == 18) {
                    intent2.putExtra("Contact_Scene", 94);
                } else {
                    intent2.putExtra("Contact_Scene", 81);
                }
            }
            if (this.bAG.getTalkerUserName().equals("gh_43f2581f6fd6")) {
                com.tencent.mm.plugin.sport.b.d.kB(2);
                com.tencent.mm.plugin.ab.a.bjk();
                if (com.tencent.mm.ao.c.ig(b.ebo)) {
                    com.tencent.mm.plugin.ab.a.bji();
                    com.tencent.mm.ao.d.ih(b.ebo);
                    intent2.putExtra("key_from_wesport_right_newtips", true);
                }
            }
            com.tencent.mm.bg.d.b(this.bAG.tTq.getContext(), "profile", ".ui.ContactInfoUI", intent2, 213);
            return true;
        }
    }

    public final boolean cuB() {
        if (this.bAG == null) {
            x.e("MicroMsg.ChattingUI.BizComponent", "[writeOpLogAndMarkReadTContact] mChattingContext is null!");
            return false;
        }
        if (this.bAG.oLT.ckW() && this.lUs != null) {
            if (this.qIZ) {
                return z.Nb().bf(cuC());
            }
            if (this.lUs.LZ()) {
                if (!(this.lUs.bG(false) == null || this.lUs.bG(false).MB() == null || bi.oW(this.lUs.Mg()))) {
                    au.HU();
                    ai YE = com.tencent.mm.model.c.FW().YE(this.lUs.Mg());
                    if (YE != null && YE.field_username.equals(this.bAG.getTalkerUserName()) && YE.field_unReadCount > 0) {
                        if (this.bAG.tTq.getIntExtra("chat_from_scene", 0) == 2) {
                            return false;
                        }
                        au.HU();
                        com.tencent.mm.model.c.FW().Ys(this.lUs.Mg());
                    }
                }
            } else if (!(this.lUs.LV() || this.lUs.LX())) {
                if (com.tencent.mm.storage.s.auK()) {
                    r.a aVar;
                    if (z.Nf().axd() > 0) {
                        t Nf = z.Nf();
                        Nf.dCZ.fV("BizTimeLineSingleMsgInfo", "update BizTimeLineSingleMsgInfo set status = 4 where status != 4 and talker = '" + this.bAG.getTalkerUserName() + "' ");
                        aVar = new r.a();
                        aVar.sNY = r.b.sOc;
                        Nf.b(aVar);
                    }
                    if (z.Ne().ckC() > 0) {
                        r Ne = z.Ne();
                        Ne.dCZ.fV("BizTimeLineInfo", "update BizTimeLineInfo set hasShow = 1 where hasShow != 1  and talker = '" + this.bAG.getTalkerUserName() + "' ");
                        aVar = new r.a();
                        aVar.sNY = r.b.sOc;
                        Ne.b(aVar);
                    }
                } else {
                    au.HU();
                    ai clK = com.tencent.mm.model.c.FW().clK();
                    if (clK != null && clK.field_username.equals(this.bAG.getTalkerUserName()) && clK.field_unReadCount > 0) {
                        au.HU();
                        com.tencent.mm.model.c.FW().Ys("officialaccounts");
                    }
                }
            }
        }
        if (s.hE(this.bAG.getTalkerUserName())) {
            return true;
        }
        au.HU();
        return com.tencent.mm.model.c.FW().Ys(this.bAG.getTalkerUserName());
    }

    public final void a(int i, l lVar) {
        if (lVar.getType() == 1357) {
            this.bAG.dismissDialog();
            if (i != 0) {
                Toast.makeText(ad.getContext(), this.bAG.tTq.getMMResources().getString(R.l.room_change_fail), 0).show();
            }
        }
    }

    public final long cuC() {
        return this.tDV == null ? -1 : this.tDV.field_bizChatLocalId;
    }

    public final void cuD() {
        au.Em().h(new 2(this), 500);
    }

    public final String aam(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("http://weixin.qq.com/emoticonstore/")) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            if (com.tencent.mm.l.a.gd(this.bAG.oLT.field_type) && this.bAG.oLT.ckW() && this.lUs != null) {
                d$b bG = this.lUs.bG(false);
                if (!(bG == null || TextUtils.isEmpty(bG.Mx()) || !substring.contains(bG.Mx()))) {
                    return substring;
                }
            }
        }
        return null;
    }

    public final void au(LinkedList<String> linkedList) {
        z.Na().ak(cuC());
        LinkedList linkedList2 = new LinkedList();
        List Nn = this.tDV.Nn();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (Nn != null && Nn.contains(str)) {
                linkedList2.add(str);
            }
        }
        if (linkedList2.size() != 0) {
            h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_alert, new Object[]{av(linkedList2)}), null, this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_remove_it), this.bAG.tTq.getMMResources().getString(R.l.app_cancel), true, new 5(this, linkedList2), new 6(this));
        } else if (linkedList.size() == 1) {
            h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_deleted), null, this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_got_it), new 3(this));
        } else {
            h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_all_left), null, this.bAG.tTq.getMMResources().getString(R.l.room_delete_member_got_it), new 4(this));
        }
    }

    private String av(LinkedList<String> linkedList) {
        if (linkedList.size() <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(this.tDV.gT((String) linkedList.get(0)));
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= linkedList.size()) {
                return stringBuilder.toString();
            }
            stringBuilder.append(this.bAG.tTq.getContext().getString(R.l.chatroom_sys_msg_invite_split)).append(this.tDV.gT((String) linkedList.get(i2)));
            i = i2 + 1;
        }
    }

    private void cuE() {
        if (this.qIZ) {
            z.Ng();
            com.tencent.mm.kernel.g.Eh().dpP.a(new v(this.bAG.getTalkerUserName(), this.tDV.field_bizChatServId, (int) (System.currentTimeMillis() / 1000)), 0);
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        return f(keyEvent);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 12001:
                if (this.tOc != null) {
                    com.tencent.mm.app.plugin.a.a aVar = this.tOc;
                    if (aVar.bAG == null) {
                        x.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
                        return;
                    } else if (i2 == -1) {
                        Toast.makeText(aVar.bAG.tTq.getContext(), R.l.exdevice_open_bt_success, 0).show();
                        dw dwVar = new dw();
                        dwVar.bLH.op = 0;
                        dwVar.bLH.userName = aVar.bAG.getTalkerUserName();
                        dwVar.bLH.context = aVar.bAG.tTq.getContext();
                        com.tencent.mm.sdk.b.a.sFg.m(dwVar);
                        return;
                    } else if (i2 == 0) {
                        Toast.makeText(aVar.bAG.tTq.getContext(), R.l.exdevice_open_bt_failed, 0).show();
                        return;
                    } else {
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final void cpF() {
        boolean z = false;
        this.tOf = this.bAG.tTq.getLongExtra("key_biz_chat_id", -1);
        this.qIZ = this.bAG.tTq.getBooleanExtra("key_is_biz_chat", false).booleanValue();
        if (this.qIZ) {
            this.tDV = z.Na().ak(this.tOf);
            this.tDV = com.tencent.mm.ac.a.e.a(this.tDV, this.tOf);
        }
        if (this.qIZ && com.tencent.mm.ac.a.e.lc(this.tDV.field_bizChatServId)) {
            z = true;
        }
        this.tOe = z;
        if (this.qIZ && !this.tOe) {
            this.lVG = z.Nc().cz(this.tDV.field_bizChatServId);
            this.lVG = com.tencent.mm.ac.a.e.a(this.lVG, this.tDV.field_bizChatServId);
        }
        if (this.tOe) {
            this.tOl = com.tencent.mm.ac.a.e.c(this.tDV);
        }
        this.lUs = f.kH(this.bAG.getTalkerUserName());
    }

    public final void cpG() {
        if (this.bAG.tTq.getIntExtra("biz_click_item_position", 0) > 0) {
            this.tOd = System.currentTimeMillis();
        }
        this.bAG.tTq.getLongExtra("key_biz_chat_id", -1);
        if (this.qIZ) {
            x.d("MicroMsg.ChattingUI.BizComponent", "getBizChatInfo");
            au.Em().h(new 8(this), 500);
        }
        if (this.bAG.oLT != null && this.bAG.oLT.ckW()) {
            z.Nk().km(this.bAG.oLT.field_username);
        }
        this.tOf = this.bAG.tTq.getLongExtra("key_biz_chat_id", -1);
        if (com.tencent.mm.app.plugin.a.a.a(this.lUs) && this.tOc == null) {
            x.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s", new Object[]{cuz()});
            this.tOc = new com.tencent.mm.app.plugin.a.a(this.bAG);
        }
        if (this.bAG.oLT.ckW()) {
            com.tencent.mm.aw.d.chatType = 2;
        }
        if (this.qIZ) {
            z.Na().a(this.tEA, Looper.getMainLooper());
            z.Ni().a(this.tOi);
        }
        if (this.bAG.oLT != null && this.bAG.oLT.ckW()) {
            z.MY().a(this.tOk, Looper.getMainLooper());
        }
    }

    public final void cpH() {
    }

    public final void cpI() {
        boolean z;
        this.tOj = true;
        bf.y("bizflag", ((com.tencent.mm.ui.chatting.b.b.s) this.bAG.O(com.tencent.mm.ui.chatting.b.b.s.class)).cvJ());
        if (this.lUs == null || com.tencent.mm.app.plugin.a.a.a(this.lUs)) {
            x.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, onresume: %s, notify switch view enter chattingui", new Object[]{cuz()});
            if (this.tOc != null) {
                this.tOc.a(1, this.lUs);
            }
        } else {
            this.bAG.tTq.setMMSubTitle(null);
        }
        d dVar = this.lUs;
        if (!(dVar == null || dVar == null)) {
            d$b bG = dVar.bG(false);
            if (bG != null && bG.Mi()) {
                z = true;
                if (z) {
                    au.Em().H(new 13(this));
                }
                if (!com.tencent.mm.l.a.gd(this.bAG.oLT.field_type) && this.bAG.oLT.ckW() && this.lUs != null) {
                    bG = this.lUs.bG(false);
                    if (bG != null && bG.LU()) {
                        z = (com.tencent.mm.modelgeo.c.OC() || com.tencent.mm.modelgeo.c.OD()) ? false : true;
                        if (this.lUs.field_hadAlert == 0 || (this.lUs.LR() && z)) {
                            String string = (this.lUs.field_hadAlert == 0 && z) ? this.bAG.tTq.getMMResources().getString(R.l.chatting_biz_report_location_confirm_nogps, new Object[]{this.bAG.oLT.BL()}) : z ? this.bAG.tTq.getMMResources().getString(R.l.chatting_biz_report_location_need_gps) : this.bAG.tTq.getMMResources().getString(R.l.chatting_biz_report_location_confirm, new Object[]{this.bAG.oLT.BL()});
                            this.lVP = h.a(this.bAG.tTq.getContext(), string, this.bAG.tTq.getMMResources().getString(R.l.app_tip), new 14(this, z), new 15(this));
                        } else {
                            z.Nj().kT(this.bAG.getTalkerUserName());
                        }
                    }
                    if (this.lUs.LS() && !(this.bAG.oLT.ckW() && com.tencent.mm.ac.a.LP())) {
                        am.a.dBr.R(this.bAG.oLT.field_username, "");
                        com.tencent.mm.aa.c.jN(this.bAG.oLT.field_username);
                    }
                    if (this.lUs.field_status == 1) {
                        this.lUs.field_status = 0;
                        z.MY().e(this.lUs);
                    }
                } else if (!(this.bAG.tTq.getBooleanExtra("key_has_add_contact", false).booleanValue() || com.tencent.mm.l.a.gd(this.bAG.oLT.field_type) || !this.bAG.oLT.ckW())) {
                    ah.A(new 16(this));
                }
                cuD();
            }
        }
        z = false;
        if (z) {
            au.Em().H(new 13(this));
        }
        if (!com.tencent.mm.l.a.gd(this.bAG.oLT.field_type)) {
        }
        ah.A(new 16(this));
        cuD();
    }

    public final void cpJ() {
        this.tOj = false;
        if (com.tencent.mm.l.a.gd(this.bAG.oLT.field_type) && this.bAG.oLT.ckW() && this.lUs != null) {
            z.Nj().MR();
            if (this.lVP != null) {
                this.lVP.dismiss();
            }
        }
    }

    public final void cpK() {
        bf.y("bizflag", false);
        if (this.qIZ) {
            cuE();
            z.Nl();
            com.tencent.mm.ac.a.c cVar = this.tDV;
            if (com.tencent.mm.kernel.a.gI(com.tencent.mm.kernel.g.Eg().dpx)) {
                com.tencent.mm.modelsimple.z.a(cVar.field_brandUserName, 8, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{cVar.field_brandUserName, cVar.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                x.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", new Object[]{r1});
            }
        }
        if (au.HX()) {
            if (this.qIZ) {
                z.Na().a(this.tEA);
            }
            if (this.bAG.oLT != null && this.bAG.oLT.ckW()) {
                z.MY().a(this.tOk);
            }
            if (com.tencent.mm.l.a.gd(this.bAG.oLT.field_type) && this.bAG.oLT.ckW() && !f.eZ(this.bAG.getTalkerUserName())) {
                z.Nj();
                k.kS(this.bAG.getTalkerUserName());
            }
            z.Ni().b(this.tOi);
        }
        if (com.tencent.mm.app.plugin.a.a.a(this.lUs) && this.tOc != null) {
            x.i("MicroMsg.ChattingUI.BizComponent", "hardevice brand account, init event : %s, notify exit chattingui", new Object[]{cuz()});
            this.tOc.a(2, this.lUs);
            this.bAG.tTq.setMMSubTitle(null);
        }
        if (com.tencent.mm.l.a.gd(this.bAG.oLT.field_type) && this.bAG.oLT.ckW() && this.tOd != 0 && this.bAG.tTq.getIntExtra("biz_click_item_position", 0) > 0) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(10638, new Object[]{this.bAG.getTalkerUserName(), Integer.valueOf(((int) (System.currentTimeMillis() - this.tOd)) / BaseReportManager.MAX_READ_COUNT), Integer.valueOf(this.bAG.tTq.getIntExtra("biz_click_item_unread_count", 0)), Integer.valueOf(this.bAG.tTq.getIntExtra("biz_click_item_position", 0))});
            this.tOd = 0;
        }
        if (this.tOc != null) {
            com.tencent.mm.app.plugin.a.a aVar = this.tOc;
            x.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
            if (aVar.bAH != null) {
                com.tencent.mm.sdk.b.a.sFg.c(aVar.bAH);
                aVar.bAH = null;
                if (aVar.bAK != null) {
                    aVar.bAK.clear();
                }
            }
            aVar.bAL = false;
            if (aVar.bAI != null) {
                com.tencent.mm.sdk.b.a.sFg.c(aVar.bAI);
                aVar.bAI = null;
            }
            this.tOc = null;
        }
    }
}
