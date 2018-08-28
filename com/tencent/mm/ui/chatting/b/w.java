package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.database.Cursor;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.az.d;
import com.tencent.mm.model.au;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.chatting.b.b.q;
import java.util.Arrays;

@a(cwo = q.class)
public class w extends a implements q {
    String bSm = null;
    private String hev = null;
    boolean qLA = false;
    private boolean tQK = false;
    private Runnable tQL = new 1(this);
    private Runnable tQM = new Runnable() {
        public final void run() {
            if (w.this.bAG != null) {
                m mVar = (m) w.this.bAG.O(m.class);
                mVar.cvb().setLbsMode(false);
                mVar.cvb().qLG = false;
                mVar.cvb().cek();
                ChatFooter cvb = mVar.cvb();
                if (cvb.qLq != null) {
                    cvb.qLq.setVisibility(0);
                }
                ChatFooter cvb2 = mVar.cvb();
                if (cvb2.qLn != null) {
                    cvb2.qLn.setVisibility(0);
                }
            }
        }
    };
    private c tQN = new 3(this);

    public final boolean cvD() {
        return this.qLA;
    }

    public final boolean cvE() {
        if (!this.qLA) {
            return false;
        }
        ba YS = d.SG().YS(this.bSm);
        if (!(this.hev == null && YS == null)) {
            ((o) this.bAG.O(o.class)).cvs();
        }
        return true;
    }

    public final void a(Button button, LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (this.hev == null) {
            ba YS = d.SG().YS(this.bSm);
            if (YS != null) {
                ((TextView) linearLayout.findViewById(R.h.add_friend_text)).setText(YS.field_sayhicontent);
                ((Button) linearLayout.findViewById(R.h.chatting_addcontact_btn)).setText(R.l.chatting_lbs_mode_addcontact_accept_btn);
                return;
            }
            linearLayout2.setVisibility(8);
        } else if (this.tQK) {
            ((TextView) linearLayout.findViewById(R.h.add_friend_text)).setText(R.l.chatting_lbs_mode_addcontact_send);
            button.setVisibility(8);
        } else {
            ((TextView) linearLayout.findViewById(R.h.add_friend_text)).setText(R.l.chatting_lbs_mode_addcontact_tips);
            ((Button) linearLayout.findViewById(R.h.chatting_addcontact_btn)).setText(R.l.chatting_lbs_mode_addcontact_btn);
        }
    }

    public final void Fc(int i) {
        if (this.hev != null) {
            String format = String.format(this.bAG.tTq.getMMResources().getString(R.l.banner_lbs_mode_add_friends), new Object[]{bi.oV(com.tencent.mm.model.q.GH())});
            au.DF().a(new com.tencent.mm.pluginsdk.model.m(2, Arrays.asList(new String[]{this.bSm}), Arrays.asList(new Integer[]{Integer.valueOf(18)}), format, ""), 0);
            this.tQK = true;
        } else {
            ba YS = d.SG().YS(this.bSm);
            au.DF().a(new com.tencent.mm.pluginsdk.model.m(this.bSm, YS.field_ticket, i, (byte) 0), 0);
            YS.field_flag = 2;
            d.SG().c(YS, new String[0]);
        }
        ((o) this.bAG.O(o.class)).cvs();
    }

    public final void aw(Intent intent) {
        intent.putExtra("Contact_IsLBSFriend", true);
        intent.putExtra("Contact_IsLbsChattingProfile", true);
        intent.putExtra("Contact_Scene", 18);
    }

    public final String aao(String str) {
        if (!this.qLA) {
            return str;
        }
        x.i("MicroMsg.ChattingUI.LbsComponent", "[oneliang]encrypt:" + this.bSm + ",raw:" + this.bAG.getTalkerUserName());
        return bi.oW(this.bSm) ? this.bAG.getTalkerUserName() : this.bSm;
    }

    public final void g(i iVar) {
        ba baVar = null;
        if (this.qLA) {
            String str = this.hev;
            bb SG = d.SG();
            String str2 = this.bSm;
            String str3 = "SELECT * FROM " + SG.getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0 ORDER BY createtime desc LIMIT 1";
            Cursor b = SG.diF.b(str3, new String[]{str2}, 2);
            if (b != null) {
                if (b.moveToFirst()) {
                    baVar = new ba();
                    baVar.d(b);
                    b.close();
                } else {
                    b.close();
                }
            }
            if (!(baVar == null || bi.oW(baVar.field_ticket))) {
                str = baVar.field_ticket;
            }
            if (bi.oW(str)) {
                baVar = d.SG().YS(this.bSm);
                if (!(baVar == null || bi.oW(baVar.field_ticket))) {
                    str = baVar.field_ticket;
                }
            }
            if (str != null) {
                iVar.dZD = new com.tencent.mm.plugin.bbom.i(str);
            }
        }
    }

    public final void cpF() {
        this.qLA = this.bAG.tTq.getBooleanExtra("lbs_mode", false).booleanValue();
        this.bSm = bi.oW(this.bAG.oLT.field_encryptUsername) ? this.bAG.getTalkerUserName() : this.bAG.oLT.field_encryptUsername;
        this.hev = this.bAG.tTq.getStringExtra("lbs_ticket");
    }

    public final void cpG() {
        if (this.qLA) {
            m mVar = (m) this.bAG.O(m.class);
            mVar.cvb().setLbsMode(true);
            ChatFooter cvb = mVar.cvb();
            if (cvb.qLq != null) {
                cvb.qLq.setVisibility(8);
            }
            ChatFooter cvb2 = mVar.cvb();
            if (cvb2.qLn != null) {
                cvb2.qLn.setVisibility(8);
            }
        }
    }

    public final void cpH() {
        com.tencent.mm.sdk.b.a.sFg.b(this.tQN);
    }

    public final void cpI() {
    }

    public final void cpJ() {
        ah.M(this.tQL);
        ah.M(this.tQM);
    }

    public final void cpK() {
        com.tencent.mm.sdk.b.a.sFg.c(this.tQN);
    }
}
