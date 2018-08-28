package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.a.su;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t$d;

public class an$h extends t$d {
    public an$h(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, bd bdVar) {
        au auVar = (au) view.getTag();
        String str = bdVar.field_content;
        su suVar = new su();
        suVar.cdE.bOh = 1;
        suVar.cdE.content = str;
        com.tencent.mm.sdk.b.a.sFg.m(suVar);
        st stVar;
        if (!(suVar.cdF.type == 2) && !bdVar.field_content.equals(bd.tby)) {
            boolean z;
            str = bdVar.field_content;
            suVar = new su();
            suVar.cdE.bOh = 1;
            suVar.cdE.content = str;
            com.tencent.mm.sdk.b.a.sFg.m(suVar);
            if (suVar.cdF.type == 3) {
                z = true;
            } else {
                z = false;
            }
            if ((z || bdVar.field_content.equals(bd.tbx)) && !com.tencent.mm.p.a.bw(this.tKy.tTq.getContext())) {
                stVar = new st();
                com.tencent.mm.sdk.b.a.sFg.m(stVar);
                if (auVar.bXQ.field_talker.equals(stVar.cdA.talker) || !(stVar.cdA.cdC || stVar.cdA.cdD)) {
                    auVar.bXQ.setStatus(6);
                    au.HU();
                    c.FT().a(auVar.bXQ.field_msgId, auVar.bXQ);
                    ((m) this.tKy.O(m.class)).cvf();
                    su suVar2 = new su();
                    suVar2.cdE.bOh = 5;
                    suVar2.cdE.talker = auVar.bXQ.field_talker;
                    suVar2.cdE.context = this.tKy.tTq.getContext();
                    suVar2.cdE.cdz = 4;
                    com.tencent.mm.sdk.b.a.sFg.m(suVar2);
                    h hVar = h.mEJ;
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Integer.valueOf(2);
                    int i = (auVar.bXQ.cqb == null || auVar.bXQ.cqb.length() <= 0) ? 1 : 3;
                    objArr[2] = Integer.valueOf(i);
                    hVar.h(11033, objArr);
                    return;
                }
                Toast.makeText(this.tKy.tTq.getContext(), stVar.cdA.cdB ? R.l.cannot_use_voip_bcz_video_talking : R.l.cannot_use_voip_bcz_voice_talking, 0).show();
                x.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
            }
        } else if (!com.tencent.mm.p.a.bw(this.tKy.tTq.getContext())) {
            stVar = new st();
            com.tencent.mm.sdk.b.a.sFg.m(stVar);
            if (auVar.bXQ.field_talker.equals(stVar.cdA.talker) || !(stVar.cdA.cdC || stVar.cdA.cdD)) {
                rn rnVar = new rn();
                rnVar.ccn.ccp = true;
                com.tencent.mm.sdk.b.a.sFg.m(rnVar);
                str = rnVar.cco.ccr;
                if (ai.oW(str)) {
                    a(auVar);
                    return;
                }
                x.v("MicroMsg.VoipClickListener", "Talkroom is on: " + str);
                com.tencent.mm.ui.base.h.a(this.tKy.tTq.getContext(), this.tKy.tTq.getContext().getString(R.l.talk_room_enter_voip_tip), "", this.tKy.tTq.getContext().getString(R.l.app_ok), this.tKy.tTq.getContext().getString(R.l.app_cancel), new 1(this, auVar), new 2(this));
                return;
            }
            Toast.makeText(this.tKy.tTq.getContext(), stVar.cdA.cdB ? R.l.cannot_use_voip_bcz_video_talking : R.l.cannot_use_voip_bcz_voice_talking, 0).show();
            x.i("MicroMsg.VoipClickListener", "voip is running, can't do this");
        }
    }

    private void a(au auVar) {
        int i;
        auVar.bXQ.setStatus(6);
        au.HU();
        c.FT().a(auVar.bXQ.field_msgId, auVar.bXQ);
        ((m) this.tKy.O(m.class)).cvf();
        su suVar = new su();
        suVar.cdE.bOh = 5;
        suVar.cdE.talker = auVar.bXQ.field_talker;
        suVar.cdE.context = this.tKy.tTq.getContext();
        suVar.cdE.cdz = 2;
        com.tencent.mm.sdk.b.a.sFg.m(suVar);
        h hVar = h.mEJ;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(3);
        objArr[1] = Integer.valueOf(1);
        if (auVar.bXQ.cqb == null || auVar.bXQ.cqb.length() <= 0) {
            i = 1;
        } else {
            i = 3;
        }
        objArr[2] = Integer.valueOf(i);
        hVar.h(11033, objArr);
    }
}
