package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.y.g;

public final class am extends b {
    private e ehD;
    private a tKy;
    private a ufa;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (i == -1879048191) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_voiceremind_sys);
        rVar.setTag(new bb().dN(rVar));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        bb bbVar = (bb) aVar;
        this.tKy = aVar2;
        g fI = ao.cbY().fI(bdVar.field_msgId);
        String str2 = bdVar.field_content;
        g.a aVar3 = null;
        if (!(fI == null || str2 == null)) {
            aVar3 = g.a.J(str2, bdVar.field_reserved);
        }
        if (aVar3 != null) {
            bbVar.eCn.setText(aVar3.description);
        }
        x.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + bdVar.field_content);
        com.tencent.mm.plugin.subapp.c.e Oj = com.tencent.mm.plugin.subapp.c.e.Oj(str2);
        if (Oj != null && Oj.orp != null && Oj.orp.length() > 0 && Oj.orq > 0 && this.ehD == null && aVar3 != null && bi.oW(bdVar.field_imgPath)) {
            str2 = k.nJ(q.GF());
            String aY = h.aY(str2, false);
            bdVar.eq(str2);
            au.HU();
            c.FT().a(bdVar.field_msgId, bdVar);
            long j = bdVar.field_msgId;
            int i2 = aVar3.sdkVer;
            String str3 = aVar3.appId;
            String str4 = Oj.orp;
            int i3 = Oj.orq;
            int i4 = aVar3.type;
            String str5 = aVar3.dwK;
            String a = l.a(aY, j, i2, str3, str4, i3, i4, aVar3.dws);
            if (a != null) {
                o DF = au.DF();
                1 1 = new 1(this, bdVar, a, i);
                this.ehD = 1;
                DF.a(221, 1);
                ac acVar = new ac(a);
                acVar.cbT();
                au.DF().a(acVar, 0);
            }
        }
        bbVar.eCn.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
        TextView textView = bbVar.eCn;
        if (this.ufa == null) {
            this.ufa = new a(this, this.tKy);
        }
        textView.setOnClickListener(this.ufa);
        au.HU();
        if (c.isSDCardAvailable()) {
            bbVar.eCn.setOnLongClickListener(c(aVar2));
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
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
        }
        return false;
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        return true;
    }
}
