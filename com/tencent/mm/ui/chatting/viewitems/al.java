package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;

public final class al extends b {
    private e ehD;
    private a tKy;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (i == -1879048190) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_voiceremind_remind);
        rVar.setTag(new ba().dM(rVar));
        return rVar;
    }

    public final String b(a aVar, bd bdVar) {
        return aVar.getTalkerUserName();
    }

    protected final boolean b(a aVar) {
        return false;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        String V;
        ba baVar = (ba) aVar;
        this.tKy = aVar2;
        g fI = ao.cbY().fI(bdVar.field_msgId);
        String str2 = bdVar.field_content;
        g.a aVar3 = null;
        if (!(fI == null || str2 == null)) {
            aVar3 = g.a.J(str2, bdVar.field_reserved);
        }
        com.tencent.mm.plugin.subapp.c.e Oj = com.tencent.mm.plugin.subapp.c.e.Oj(str2);
        if (!(Oj == null || Oj.orn == 0)) {
            try {
                V = h.V(aVar2.tTq.getContext(), Oj.orn);
                CharSequence charSequence = "";
                if (V != null && V.length() > 0) {
                    String[] split = V.split(";");
                    charSequence = charSequence + split[0].replace(" ", "");
                    if (split.length > 1) {
                        charSequence = charSequence + split[1];
                    }
                }
                if (!(aVar3 == null || aVar3.description == null)) {
                    charSequence = charSequence + " " + aVar3.description;
                }
                baVar.eCn.setText(charSequence);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", e, "", new Object[0]);
            }
        }
        x.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + bdVar.field_content);
        if (bi.oW(bdVar.field_imgPath) && Oj.ort > 0) {
            au.HU();
            bd I = c.FT().I(bdVar.field_talker, (long) Oj.ort);
            if (!bi.oW(I.field_imgPath)) {
                V = k.nJ(q.GF());
                if (j.q(com.tencent.mm.plugin.subapp.c.h.aY(I.field_imgPath, false), com.tencent.mm.plugin.subapp.c.h.aY(V, false), false)) {
                    bdVar.eq(V);
                    au.HU();
                    c.FT().a(bdVar.field_msgId, bdVar);
                }
            }
        }
        if (bi.oW(bdVar.field_imgPath) && Oj != null && Oj.bGP != null && Oj.bGP.length() > 0 && Oj.dwo > 0 && this.ehD == null) {
            str2 = k.nJ(q.GF());
            String aY = com.tencent.mm.plugin.subapp.c.h.aY(str2, false);
            if (bi.oW(bdVar.field_imgPath)) {
                bdVar.eq(str2);
                au.HU();
                c.FT().a(bdVar.field_msgId, bdVar);
                x.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + aVar3.bGP);
                b a = l.a(aY, bdVar.field_msgId, aVar3.sdkVer, aVar3.appId, aVar3.bGP, aVar3.dwo);
                x.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + a.field_mediaSvrId);
                if (a.field_mediaSvrId != null) {
                    o DF = au.DF();
                    1 1 = new 1(this);
                    this.ehD = 1;
                    DF.a(221, 1);
                    x.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
                    au.DF().a(new ac(a), 0);
                }
            }
        }
        baVar.ugA.setOnClickListener(new 2(this, bdVar, i));
        long j = bdVar.field_msgId;
        d cwl = ((ag) this.tKy.O(ag.class)).cwl();
        Object obj = (cwl.isPlaying() && cwl.tHf == j) ? 1 : null;
        if (obj != null) {
            baVar.ugA.setImageResource(R.g.music_pauseicon);
        } else {
            baVar.ugA.setImageResource(R.g.music_playicon);
        }
        baVar.hrH.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
        au.HU();
        if (c.isSDCardAvailable()) {
            baVar.hrH.setOnLongClickListener(c(aVar2));
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        int SY = l.SY(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
        g.a gp = g.a.gp(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
        if (gp.dwo <= 0 || (gp.dwo > 0 && SY >= 100)) {
            contextMenu.add(i, f$k.AppCompatTheme_switchStyle, 0, this.tKy.tTq.getMMResources().getString(R.l.retransmit));
        }
        if (!this.tKy.cws()) {
            contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = bdVar.field_content;
                g.a aVar2 = null;
                if (str != null) {
                    aVar2 = g.a.gp(str);
                }
                if (aVar2 != null) {
                    l.fJ(bdVar.field_msgId);
                }
                com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                break;
            case f$k.AppCompatTheme_switchStyle /*111*/:
                Intent intent = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", bdVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        return true;
    }
}
