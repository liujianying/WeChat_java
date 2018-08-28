package com.tencent.mm.plugin.account.friend.ui;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.a.o;
import com.tencent.mm.aa.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a.i;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.ui.d.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;

public final class e extends d {
    private final int GG;
    private final MMActivity bGc;
    private String eIs;
    private final a eMB;
    private final c eMC;
    private a eMD;
    boolean eME = false;
    private a eMF = new 1(this);

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ao aoVar = (ao) obj;
        if (aoVar == null) {
            aoVar = new ao();
        }
        aoVar.d(cursor);
        return aoVar;
    }

    public e(MMActivity mMActivity, int i) {
        super(mMActivity, new ao());
        this.bGc = mMActivity;
        this.GG = i;
        this.eME = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        this.eMB = new a(mMActivity, new 2(this));
        this.eMC = new c(mMActivity, new 3(this));
    }

    public final void a(a aVar) {
        this.eMD = aVar;
    }

    public final void pi(String str) {
        this.eIs = bi.oU(str.trim());
        aYc();
        WT();
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        aYc();
        if (bi.oW(this.eIs)) {
            setCursor(((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).z(this.GG, this.eME));
        } else {
            setCursor(((ap) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).c(this.GG, this.eIs, this.eME));
        }
        if (!(this.eMD == null || this.eIs == null)) {
            this.eMD.ja(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        Bitmap aY;
        ao aoVar = (ao) getItem(i);
        if (view == null) {
            view = View.inflate(this.bGc, com.tencent.mm.plugin.account.a.g.qq_friend_item, null);
            b bVar2 = new b(this, view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.eIy = i;
        bVar.eMI = aoVar.eLw;
        bVar.status = aoVar.eLx;
        bVar.eIz.setText(j.a(this.bGc, aoVar.getDisplayName(), bVar.eIz.getTextSize()));
        if (o.cx(aoVar.eLw) != 0) {
            aY = c.aY(aoVar.eLw);
        } else {
            aY = null;
        }
        if (aY == null) {
            bVar.eBM.setImageDrawable(com.tencent.mm.bp.a.f(this.bGc, i.default_avatar));
        } else {
            bVar.eBM.setImageBitmap(aY);
        }
        if (!this.eME) {
            switch (aoVar.eLx) {
                case 0:
                    if (aoVar.dHO != 2) {
                        bVar.eIA.setClickable(true);
                        bVar.eIA.setBackgroundResource(com.tencent.mm.plugin.account.a.e.btn_solid_green);
                        bVar.eBR.setText(com.tencent.mm.plugin.account.a.j.friend_invite);
                        bVar.eBR.setTextColor(this.bGc.getResources().getColor(com.tencent.mm.plugin.account.a.c.white));
                        break;
                    }
                    bVar.eIA.setClickable(false);
                    bVar.eIA.setBackgroundDrawable(null);
                    bVar.eBR.setText(com.tencent.mm.plugin.account.a.j.friend_invited);
                    bVar.eBR.setTextColor(this.bGc.getResources().getColor(com.tencent.mm.plugin.account.a.c.lightgrey));
                    break;
                case 1:
                case 2:
                    if (!((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yc(aoVar.getUsername()) && !q.GF().equals(aoVar.getUsername())) {
                        if (aoVar.dHO != 2) {
                            bVar.eIA.setClickable(true);
                            bVar.eIA.setBackgroundResource(com.tencent.mm.plugin.account.a.e.btn_solid_green);
                            bVar.eBR.setText(com.tencent.mm.plugin.account.a.j.friend_add);
                            bVar.eBR.setTextColor(this.bGc.getResources().getColor(com.tencent.mm.plugin.account.a.c.white));
                            break;
                        }
                        bVar.eIA.setClickable(false);
                        bVar.eIA.setBackgroundDrawable(null);
                        bVar.eBR.setText(com.tencent.mm.plugin.account.a.j.friend_waiting_ask);
                        bVar.eBR.setTextColor(this.bGc.getResources().getColor(com.tencent.mm.plugin.account.a.c.lightgrey));
                        break;
                    }
                    bVar.eIA.setClickable(false);
                    bVar.eIA.setBackgroundDrawable(null);
                    bVar.eBR.setText(com.tencent.mm.plugin.account.a.j.friend_added);
                    bVar.eBR.setTextColor(this.bGc.getResources().getColor(com.tencent.mm.plugin.account.a.c.lightgrey));
                    break;
                    break;
            }
            switch (aoVar.dHO) {
                case 0:
                case 2:
                    bVar.eBR.setVisibility(0);
                    bVar.eIB.setVisibility(4);
                    break;
                case 1:
                    bVar.eBR.setVisibility(4);
                    bVar.eIB.setVisibility(0);
                    break;
            }
        }
        bVar.eIA.setVisibility(8);
        return view;
    }

    public final void jX(String str) {
        notifyDataSetChanged();
    }
}
