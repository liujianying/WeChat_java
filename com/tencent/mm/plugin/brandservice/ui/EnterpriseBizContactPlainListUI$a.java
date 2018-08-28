package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b$b;
import com.tencent.mm.ui.r;

class EnterpriseBizContactPlainListUI$a extends r<ix> implements b {
    com.tencent.mm.ui.applet.b eKg = new com.tencent.mm.ui.applet.b(new 1(this));
    private b$b eKh = null;
    final /* synthetic */ EnterpriseBizContactPlainListUI hpF;

    class a {
        TextView eIz;
        ImageView eKk;

        a() {
        }

        public final void clear() {
            if (this.eKk != null) {
                this.eKk.setImageDrawable(null);
                this.eKk.setVisibility(8);
            }
            if (this.eIz != null) {
                this.eIz.setText("");
                this.eIz.setVisibility(8);
            }
        }
    }

    public EnterpriseBizContactPlainListUI$a(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, Context context) {
        this.hpF = enterpriseBizContactPlainListUI;
        super(context, new ix());
        WT();
    }

    public final void a(String str, l lVar) {
        x.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
        ah.A(new 2(this));
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.eKh == null) {
            this.eKh = new 3(this);
        }
        if (this.eKg != null) {
            this.eKg.a(i, this.eKh);
        }
        if (view == null) {
            aVar = new a();
            view = View.inflate(this.context, e.enterprise_biz_list_item_normal, null);
            aVar.eKk = (ImageView) view.findViewById(d.nearby_friend_avatar_iv);
            aVar.eIz = (TextView) view.findViewById(d.nearby_friend_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        ix ixVar = (ix) getItem(i);
        if (ixVar == null) {
            aVar.clear();
        } else {
            aVar.clear();
            int paddingBottom = view.getPaddingBottom();
            int paddingTop = view.getPaddingTop();
            int paddingRight = view.getPaddingRight();
            int paddingLeft = view.getPaddingLeft();
            view.setBackgroundDrawable(com.tencent.mm.bp.a.f(this.context, c.comm_list_item_selector));
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            aVar.eIz.setText(j.a(this.context, bi.oV(ixVar.guS.BK()), aVar.eIz.getTextSize()));
            aVar.eIz.setVisibility(0);
            aVar.eKk.setVisibility(0);
            if (bi.oW(ixVar.guS.field_username)) {
                aVar.eKk.setImageDrawable(null);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar.eKk, ixVar.guS.field_username);
            }
        }
        return view;
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        Cursor cursor = null;
        if (g.Eg().Dx()) {
            aYc();
            switch (EnterpriseBizContactPlainListUI.b(this.hpF)) {
                case 1:
                    z.MY();
                    cursor = com.tencent.mm.ac.e.K(EnterpriseBizContactPlainListUI.c(this.hpF), 25);
                    break;
                case 2:
                    z.MY();
                    String c = EnterpriseBizContactPlainListUI.c(this.hpF);
                    StringBuilder stringBuilder = new StringBuilder();
                    com.tencent.mm.ac.e.b(stringBuilder);
                    com.tencent.mm.ac.e.c(stringBuilder);
                    com.tencent.mm.ac.e.a(stringBuilder, c);
                    com.tencent.mm.ac.e.b(stringBuilder, false);
                    com.tencent.mm.ac.e.a(stringBuilder, false);
                    stringBuilder.append(" order by ");
                    stringBuilder.append(com.tencent.mm.ac.e.ME());
                    x.i("MicroMsg.BizInfoStorage", "getEnterpriseDisableChild sql %s", new Object[]{stringBuilder.toString()});
                    cursor = g.Ei().dqq.b(c, null, 0);
                    break;
                case 3:
                    z.MY();
                    cursor = com.tencent.mm.ac.e.K(EnterpriseBizContactPlainListUI.c(this.hpF), 128);
                    break;
                case 4:
                    com.tencent.mm.ac.d kH = f.kH(EnterpriseBizContactPlainListUI.c(this.hpF));
                    if (!(kH == null || kH.field_enterpriseFather == null)) {
                        cursor = z.MY().kB(kH.field_enterpriseFather);
                        break;
                    }
                default:
                    z.MY();
                    cursor = com.tencent.mm.ac.e.C(EnterpriseBizContactPlainListUI.c(this.hpF), true);
                    break;
            }
            setCursor(cursor);
            return;
        }
        x.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
    }
}
