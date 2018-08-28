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
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

public class q$b extends b {
    private a tKy;
    private String uca;
    private String ucb;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || (i != 42 && i != 66)) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from_card);
        rVar.setTag(new q.a().q(rVar, true));
        return rVar;
    }

    protected final boolean b(a aVar) {
        return aVar.cwr();
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        String iC;
        char c;
        CharSequence charSequence;
        this.tKy = aVar2;
        q.a aVar3 = (q.a) aVar;
        if (aVar2.cwr()) {
            iC = com.tencent.mm.model.bd.iC(bdVar.field_content);
        } else {
            iC = bdVar.field_content;
        }
        au.HU();
        bd.a GR = c.FT().GR(iC);
        if (GR.otZ == null || GR.otZ.length() <= 0) {
            x.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.uca = GR.otZ;
        this.ucb = "";
        if (!ai.oW(iC)) {
            Map z = bl.z(iC, "msg");
            if (z.containsKey(".msg.$wechatid")) {
                this.ucb = (String) z.get(".msg.$wechatid");
            }
        }
        com.tencent.mm.aa.c.J(this.uca, GR.tbD);
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
        String str2 = this.ucb;
        if (ai.oW(str2) || ab.XT(str2) || s.hd(str2)) {
            c = 1;
        } else {
            c = 0;
        }
        boolean gU = s.gU(GR.pOR);
        if (c != 0 || gU) {
            charSequence = "";
        } else {
            Object charSequence2 = str2;
        }
        if (ai.oW(charSequence2)) {
            aVar3.ubZ.setVisibility(8);
        } else {
            aVar3.ubZ.setVisibility(0);
            aVar3.ubZ.setText(charSequence2);
        }
        aVar3.eTm.setText(j.a(aVar2.tTq.getContext(), GR.nickname, (int) aVar3.eTm.getTextSize()));
        q.a(aVar2, this.uca, GR, aVar3);
        aVar3.hrH.setTag(new au(bdVar, aVar2.cwr(), i, str, 0));
        aVar3.hrH.setOnClickListener(d(aVar2));
        aVar3.hrH.setOnLongClickListener(c(aVar2));
        aVar3.hrH.setOnTouchListener(((g) aVar2.O(g.class)).ctw());
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        au.HU();
        bd.a GR = c.FT().GR(bdVar.field_content);
        if (GR.otZ == null || GR.otZ.length() <= 0) {
            x.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.uca = GR.otZ;
        if (s.gU(GR.pOR)) {
            contextMenu.add(i, 118, 0, view.getContext().getString(R.l.retransmit));
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
}
