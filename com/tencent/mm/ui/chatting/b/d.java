package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.aa.c;
import com.tencent.mm.aq.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.pluginsdk.ui.applet.g$a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.y;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import java.util.List;

@a(cwo = com.tencent.mm.ui.chatting.b.b.d.class)
public class d extends a implements com.tencent.mm.ui.chatting.b.b.d {
    private boolean f(int i, int i2, Intent intent) {
        String stringExtra;
        String gT;
        String stringExtra2;
        switch (i) {
            case 223:
                if (i2 == -1 && intent != null) {
                    stringExtra = intent.getStringExtra("be_send_card_name");
                    if (this.bAG.cwr() && ab.XR(stringExtra)) {
                        try {
                            h.a(this.bAG.tTq.getActivity(), this.bAG.tTq.getActivity().getString(R.l.share_openim_card_waring), "", null);
                        } catch (Throwable th) {
                        }
                        return true;
                    }
                    String string;
                    gT = r.gT(stringExtra);
                    stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    g$a g_a = new g$a(this.bAG.tTq.getContext());
                    c.a(stringExtra, true, -1);
                    au.HU();
                    ab Ye = com.tencent.mm.model.c.FR().Ye(stringExtra);
                    if (s.gU(Ye.field_verifyFlag)) {
                        string = this.bAG.tTq.getResources().getString(R.l.app_friend_card_biz);
                    } else if (ab.XR(stringExtra)) {
                        string = SelectConversationUI.d(ad.getContext(), Ye);
                    } else {
                        string = this.bAG.tTq.getResources().getString(R.l.app_friend_card_personal);
                    }
                    g_a.bZ(stringExtra2).TH(new StringBuffer(string).append(gT).toString()).g(Boolean.valueOf(true)).BX(R.l.app_send).a(new 1(this, stringExtra, stringExtra2, booleanExtra)).eIW.show();
                }
                return true;
            case 224:
                if (i2 == -1 && intent != null) {
                    stringExtra = intent.getStringExtra("be_send_card_name");
                    gT = intent.getStringExtra("received_card_name");
                    stringExtra2 = intent.getStringExtra("custom_send_text");
                    boolean booleanExtra2 = intent.getBooleanExtra("Is_Chatroom", false);
                    Intent intent2 = new Intent(this.bAG.tTq.getContext(), ChattingUI.class);
                    intent2.putExtra("Chat_User", gT);
                    intent2.putExtra("send_card_username", stringExtra);
                    intent2.putExtra("send_card_edittext", stringExtra2);
                    intent2.putExtra("Is_Chatroom", booleanExtra2);
                    this.bAG.tTq.startActivity(intent2);
                }
                return true;
            default:
                return false;
        }
    }

    public final boolean aS(bd bdVar) {
        if (!bdVar.cmi()) {
            return false;
        }
        if (!this.bAG.getTalkerUserName().equals("medianote")) {
            au.HU();
            com.tencent.mm.model.c.FQ().b(new e(bdVar.field_talker, bdVar.field_msgSvrId));
        }
        ak.aN(bdVar);
        this.bAG.lT(true);
        return true;
    }

    public final void cuG() {
        Intent intent = new Intent(this.bAG.tTq.getContext(), SelectContactUI.class);
        if (ab.XR(this.bAG.getTalkerUserName())) {
            intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.s(new int[]{com.tencent.mm.ui.contact.s.ukI, 1}));
        } else {
            intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.s(new int[]{com.tencent.mm.ui.contact.s.ukI, 2048}));
        }
        intent.putExtra("list_type", 4);
        intent.putExtra("received_card_name", this.bAG.getTalkerUserName());
        intent.putExtra("block_contact", this.bAG.getTalkerUserName());
        intent.putExtra("Add_SendCard", true);
        intent.putExtra("titile", this.bAG.tTq.getMMResources().getString(R.l.address_title_select_contact));
        this.bAG.tTq.startActivityForResult(intent, 223);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        f(i, i2, intent);
    }

    public final void cpF() {
        Intent intent = this.bAG.tTq.getContext().getIntent();
        String stringExtra = intent.getStringExtra("Chat_User");
        String stringExtra2 = intent.getStringExtra("send_card_username");
        if (!bi.oW(stringExtra2)) {
            boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
            String stringExtra3 = intent.getStringExtra("send_card_edittext");
            if (booleanExtra) {
                int i;
                String aG = bi.aG(stringExtra, "");
                String aaP = y.aaP(stringExtra2);
                if (ab.XR(stringExtra2)) {
                    i = 66;
                } else {
                    i = 42;
                }
                au.DF().a(new i(aG, aaP, i), 0);
            } else {
                List F = bi.F(bi.aG(stringExtra, "").split(","));
                String aaP2 = y.aaP(stringExtra2);
                for (int i2 = 0; i2 < F.size(); i2++) {
                    au.DF().a(new i((String) F.get(i2), aaP2, ab.XR(stringExtra2) ? 66 : 42), 0);
                }
            }
            if (stringExtra3 != null) {
                g.bcT().dF(stringExtra3, stringExtra);
            }
        }
    }
}
