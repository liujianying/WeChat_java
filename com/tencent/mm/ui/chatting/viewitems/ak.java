package com.tencent.mm.ui.chatting.viewitems;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;

public final class ak extends b {
    private e ehD;
    private ProgressDialog mQY;
    private a tKy;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (i == -1879048189) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_voiceremind_confirm);
        rVar.setTag(new aq().dL(rVar));
        return rVar;
    }

    protected final boolean cxM() {
        return false;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        g.a aVar3;
        String V;
        String aY;
        o DF;
        aq aqVar = (aq) aVar;
        this.tKy = aVar2;
        g fI = ao.cbY().fI(bdVar.field_msgId);
        String str2 = bdVar.field_content;
        if (fI == null || str2 == null) {
            aVar3 = null;
        } else {
            aVar3 = g.a.gp(str2);
        }
        boolean z = false;
        final com.tencent.mm.plugin.subapp.c.e Oj = com.tencent.mm.plugin.subapp.c.e.Oj(str2);
        if (!(Oj == null || Oj.orn == 0)) {
            try {
                V = h.V(this.tKy.tTq.getContext(), Oj.orn);
                if (!(aVar3 == null || aVar3.description == null)) {
                    int indexOf = aVar3.description.indexOf(124);
                    if (indexOf <= 0 || aVar3.description.length() <= indexOf + 1) {
                        aqVar.eCn.setText("");
                    } else {
                        aqVar.eCn.setText(aVar3.description.substring(indexOf + 1));
                    }
                }
                if (V != null && V.length() > 0) {
                    String[] split = V.split(";");
                    aqVar.ufj.setText(split[0]);
                    if (split.length > 1) {
                        aqVar.ufk.setText(split[1]);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", e, "", new Object[0]);
            }
            z = ai.iS(Oj.orn);
        }
        if (z) {
            aqVar.ufn.setVisibility(0);
            aqVar.eCn.setTextColor(this.tKy.tTq.getMMResources().getColor(R.e.voice_remind_grey_color));
            aqVar.ufk.setTextColor(this.tKy.tTq.getMMResources().getColor(R.e.voice_remind_grey_color));
            aqVar.ufj.setTextColor(this.tKy.tTq.getMMResources().getColor(R.e.voice_remind_grey_color));
        } else {
            aqVar.ufn.setVisibility(8);
            aqVar.eCn.setTextColor(this.tKy.tTq.getMMResources().getColor(R.e.voice_remind_date_color));
            aqVar.ufk.setTextColor(this.tKy.tTq.getMMResources().getColor(R.e.voice_remind_date_color));
            aqVar.ufj.setTextColor(this.tKy.tTq.getMMResources().getColor(R.e.voice_remind_date_color));
        }
        aqVar.ufl.setOnClickListener(new 1(this, bdVar, i));
        long j = bdVar.field_msgId;
        d cwl = ((ag) this.tKy.O(ag.class)).cwl();
        Object obj = (cwl != null && cwl.isPlaying() && cwl.tHf == j) ? 1 : null;
        if (obj != null) {
            aqVar.ufl.setBackgroundResource(R.g.voice_remind_pause_btn);
        } else {
            aqVar.ufl.setBackgroundResource(R.g.voice_remind_play_btn);
        }
        if (!(Oj == null || ai.oW(Oj.orp) || Oj.orq <= 0 || !ai.oW(bdVar.field_reserved) || aVar3 == null)) {
            V = k.nJ(q.GF());
            aY = com.tencent.mm.plugin.subapp.c.h.aY(V, false);
            bdVar.er(V);
            au.HU();
            c.FT().a(bdVar.field_msgId, bdVar);
            j = bdVar.field_msgId;
            int i2 = aVar3.sdkVer;
            String str3 = aVar3.appId;
            String str4 = Oj.orp;
            int i3 = Oj.orq;
            int i4 = aVar3.type;
            V = aVar3.dwK;
            V = l.a(aY, j, i2, str3, str4, i3, i4, aVar3.dws);
            if (V != null) {
                DF = au.DF();
                2 2 = new 2(this, bdVar, V, i);
                this.ehD = 2;
                DF.a(221, 2);
                ac acVar = new ac(V);
                acVar.cbT();
                au.DF().a(acVar, 0);
            }
        }
        if (ai.oW(bdVar.field_imgPath) && Oj.ort > 0) {
            au.HU();
            bd I = c.FT().I(bdVar.field_talker, (long) Oj.ort);
            if (!ai.oW(I.field_imgPath)) {
                aY = k.nJ(q.GF());
                if (j.q(com.tencent.mm.plugin.subapp.c.h.aY(I.field_imgPath, false), com.tencent.mm.plugin.subapp.c.h.aY(aY, false), false)) {
                    bdVar.eq(aY);
                    au.HU();
                    c.FT().a(bdVar.field_msgId, bdVar);
                }
            }
        }
        if (ai.oW(bdVar.field_imgPath) && Oj != null && !ai.oW(Oj.bGP) && Oj.dwo > 0 && this.ehD == null) {
            V = k.nJ(q.GF());
            aY = com.tencent.mm.plugin.subapp.c.h.aY(V, false);
            bdVar.eq(V);
            au.HU();
            c.FT().a(bdVar.field_msgId, bdVar);
            b a = l.a(aY, bdVar.field_msgId, aVar3.sdkVer, aVar3.appId, aVar3.bGP, aVar3.dwo);
            x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + a.field_mediaSvrId);
            if (a.field_mediaSvrId != null) {
                DF = au.DF();
                3 3 = new 3(this, a);
                this.ehD = 3;
                DF.a(221, 3);
                au.DF().a(new ac(a), 0);
            }
        }
        final bd bdVar2 = bdVar;
        aqVar.ufm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.ui.base.h.a(ak.this.tKy.tTq.getContext(), R.l.voice_reminder_dialog_del_message, R.l.voice_reminder_dialog_title, new 1(this), null);
            }
        });
        aqVar.hrH.setTag(new au(bdVar, this.tKy.cwr(), i, null, 0));
        au.HU();
        if (c.isSDCardAvailable()) {
            aqVar.hrH.setOnLongClickListener(c(this.tKy));
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        int SY = l.SY(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
        g.a gp = g.a.gp(com.tencent.mm.model.bd.b(this.tKy.cwr(), bdVar.field_content, bdVar.field_isSend));
        if (gp.dwo <= 0 || (gp.dwo > 0 && SY >= 100)) {
            contextMenu.add(i, 111, 0, this.tKy.tTq.getMMResources().getString(R.l.retransmit));
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
            case 111:
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
