package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public class q$c extends b implements m {
    private a tKy;
    private String uca;

    public final boolean bba() {
        return true;
    }

    public final boolean aq(int i, boolean z) {
        if (z && (i == 42 || i == 66)) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new r(layoutInflater, R.i.chatting_item_to_card);
        view.setTag(new q.a().q(view, false));
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        char c;
        char c2;
        boolean gU;
        int c22 = 1;
        this.tKy = aVar2;
        q.a aVar3 = (q.a) aVar;
        au.HU();
        bd.a GR = c.FT().GR(bdVar.field_content);
        if (GR.otZ == null || GR.otZ.length() <= 0) {
            x.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
        }
        this.uca = GR.otZ;
        x.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", new Object[]{Boolean.valueOf(s.hf(this.uca)), this.uca});
        q.a.P(aVar3.hrH, aVar3.uau);
        if (s.gU(GR.pOR)) {
            aVar3.ubY.setText(R.l.chatting_biz_card);
            aVar3.ubZ.setVisibility(8);
            if (d.fR(16)) {
                aVar3.ubX.setBackground(null);
            } else {
                aVar3.ubX.setBackgroundDrawable(null);
            }
            s(aVar3.ubX, this.uca);
        } else {
            aVar3.ubY.setText(R.l.chatting_personal_card);
            aVar3.ubX.setBackgroundResource(R.g.default_avatar);
            r(aVar3.ubX, this.uca);
        }
        aVar3.eTm.setText(j.a(aVar2.tTq.getContext(), GR.nickname, aVar3.eTm.getTextSize()));
        CharSequence charSequence = GR.cCR;
        if (!ai.oW(this.uca)) {
            au.HU();
            ab Yg = c.FR().Yg(this.uca);
            if (Yg != null && com.tencent.mm.l.a.gd(Yg.field_type)) {
                ab.ckV();
                c = 0;
                if (c == 0 || !ai.oW(charSequence)) {
                    c22 = c;
                } else {
                    charSequence = this.uca;
                    if (!(ai.oW(charSequence) || ab.XT(charSequence) || s.hd(charSequence))) {
                        c22 = 0;
                    }
                }
                gU = s.gU(GR.pOR);
                if (c22 != 0 || gU) {
                    charSequence = "";
                }
                if (ai.oW(charSequence)) {
                    aVar3.ubZ.setVisibility(0);
                    aVar3.ubZ.setText(charSequence);
                } else {
                    aVar3.ubZ.setVisibility(8);
                }
                q.a(aVar2, this.uca, GR, aVar3);
                aVar3.hrH.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
                aVar3.hrH.setOnClickListener(d(aVar2));
                aVar3.hrH.setOnLongClickListener(c(aVar2));
                aVar3.hrH.setOnTouchListener(((g) aVar2.O(g.class)).ctw());
                if (cxN()) {
                    if (aVar3.mgA != null) {
                        aVar3.mgA.setVisibility(8);
                    }
                    if (bdVar.field_status == 2 && a((g) aVar2.O(g.class), bdVar.field_msgId)) {
                        if (aVar3.uai != null) {
                            aVar3.uai.setVisibility(0);
                        }
                    } else if (aVar3.uai != null) {
                        aVar3.uai.setVisibility(8);
                    }
                } else if (aVar3.mgA != null) {
                    aVar3.mgA.setVisibility(0);
                    if (bdVar.field_status >= 2) {
                        aVar3.mgA.setVisibility(8);
                    }
                }
                a(i, aVar3, bdVar, aVar2.cwp(), aVar2.cwr(), aVar2, this);
            }
        }
        c = 1;
        if (c == 0) {
        }
        c22 = c;
        gU = s.gU(GR.pOR);
        charSequence = "";
        if (ai.oW(charSequence)) {
            aVar3.ubZ.setVisibility(8);
        } else {
            aVar3.ubZ.setVisibility(0);
            aVar3.ubZ.setText(charSequence);
        }
        q.a(aVar2, this.uca, GR, aVar3);
        aVar3.hrH.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
        aVar3.hrH.setOnClickListener(d(aVar2));
        aVar3.hrH.setOnLongClickListener(c(aVar2));
        aVar3.hrH.setOnTouchListener(((g) aVar2.O(g.class)).ctw());
        if (cxN()) {
            if (aVar3.mgA != null) {
                aVar3.mgA.setVisibility(8);
            }
            if (bdVar.field_status == 2 && a((g) aVar2.O(g.class), bdVar.field_msgId)) {
                if (aVar3.uai != null) {
                    aVar3.uai.setVisibility(0);
                }
            } else if (aVar3.uai != null) {
                aVar3.uai.setVisibility(8);
            }
        } else if (aVar3.mgA != null) {
            aVar3.mgA.setVisibility(0);
            if (bdVar.field_status >= 2) {
                aVar3.mgA.setVisibility(8);
            }
        }
        a(i, aVar3, bdVar, aVar2.cwp(), aVar2.cwr(), aVar2, this);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        au.HU();
        bd.a GR = c.FT().GR(bdVar.field_content);
        if (GR.otZ == null || GR.otZ.length() <= 0) {
            x.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
        }
        this.uca = GR.otZ;
        if (s.gU(GR.pOR)) {
            contextMenu.add(i, 118, 0, view.getContext().getString(R.l.retransmit));
        }
        if (!bdVar.cky() && ((bdVar.field_status == 2 || bdVar.cGF == 1) && bdVar.cmi() && a(bdVar, this.tKy) && aaA(bdVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
        }
        if (!this.tKy.cws()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        switch (menuItem.getItemId()) {
            case 118:
                Intent intent = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 8);
                intent.putExtra("Retr_Msg_Id", bdVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        au auVar = (au) view.getTag();
        q.a(aVar, auVar.userName, bdVar.field_content, auVar.tGg, bdVar.field_isSend == 0);
        return true;
    }

    public final void a(a aVar, bd bdVar) {
        bdVar.cmw();
        au.HU();
        c.FT().a(bdVar.field_msgId, bdVar);
        ((com.tencent.mm.ui.chatting.b.b.d) aVar.O(com.tencent.mm.ui.chatting.b.b.d.class)).aS(bdVar);
    }
}
