package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.c;
import com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ContactSearchResultUI$b extends BaseAdapter {
    private Context mContext;
    final /* synthetic */ ContactSearchResultUI ots;

    public ContactSearchResultUI$b(ContactSearchResultUI contactSearchResultUI, Context context) {
        this.ots = contactSearchResultUI;
        this.mContext = context;
    }

    public final int getCount() {
        return ContactSearchResultUI.b(this.ots).size() + ContactSearchResultUI.c(this.ots).size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        int i2 = 8;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.search_or_recommend_biz_item, null);
            d dVar2 = new d();
            dVar2.eCl = (ImageView) view.findViewById(R.h.avatarIV);
            dVar2.eMf = (TextView) view.findViewById(R.h.nicknameTV);
            dVar2.hod = view.findViewById(R.h.verifyIV);
            dVar2.hoe = (TextView) view.findViewById(R.h.introduceTV);
            d.a(dVar2, view.findViewById(R.h.bizTrademarkProtectionIV));
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        if (i >= ContactSearchResultUI.b(this.ots).size()) {
            bjp bjp = (bjp) ContactSearchResultUI.c(this.ots).get(i - ContactSearchResultUI.b(this.ots).size());
            dVar.username = bjp.hbL;
            dVar.iconUrl = bjp.rra;
            dVar.eCl.setTag(dVar.username);
            b.a(dVar.eCl, dVar.username);
            dVar.hod.setVisibility(8);
            d.a(dVar).setVisibility(8);
            dVar.hoe.setText("");
            try {
                dVar.eMf.setText(j.a(this.mContext, bjp.hcS, dVar.eMf.getTextSize()));
            } catch (Exception e) {
                dVar.eMf.setText("");
            }
        } else {
            biy biy = (biy) ContactSearchResultUI.b(this.ots).get(i);
            if (biy == null) {
                x.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
            } else {
                dVar.username = biy.rvi.siM;
                dVar.iconUrl = biy.rra;
                dVar.eCl.setTag(dVar.username);
                b.a(dVar.eCl, dVar.username);
                String str = biy.rvi.siM;
                c cVar = (c) ContactSearchResultUI.d(this.ots).get(str);
                if (cVar == null) {
                    c cVar2 = new c((byte) 0);
                    ContactSearchResultUI.d(this.ots).put(str, cVar2);
                    qt qtVar = biy.rTl;
                    if (qtVar != null) {
                        com.tencent.mm.ac.d.b.d Mt;
                        com.tencent.mm.ac.d dVar3 = new com.tencent.mm.ac.d();
                        dVar3.field_username = str;
                        dVar3.field_brandFlag = qtVar.eJV;
                        dVar3.field_brandIconURL = qtVar.eJY;
                        dVar3.field_brandInfo = qtVar.eJX;
                        dVar3.field_extInfo = qtVar.eJW;
                        if (dVar3.bG(false) != null) {
                            Mt = dVar3.bG(false).Mt();
                        } else {
                            Mt = null;
                        }
                        if (Mt != null) {
                            boolean z = dVar3.bG(false).Mv() && !bi.oW(Mt.dLJ);
                            cVar2.hob = z;
                            cVar2.hoa = biy.rTe != 0;
                        }
                    }
                    cVar = cVar2;
                }
                dVar.hod.setVisibility(cVar.hoa ? 0 : 8);
                View a = d.a(dVar);
                if (cVar.hob) {
                    i2 = 0;
                }
                a.setVisibility(i2);
                x.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[]{Integer.valueOf(biy.rTe)});
                try {
                    dVar.hoe.setText(j.a(this.mContext, bi.oV(biy.eJK), dVar.hoe.getTextSize()));
                } catch (Exception e2) {
                    dVar.hoe.setText("");
                }
                try {
                    TextView textView = dVar.eMf;
                    Context context = this.mContext;
                    CharSequence oV = !bi.oW(biy.rQz.siM) ? biy.rQz.siM : !bi.oW(biy.eJM) ? biy.eJM : bi.oV(biy.rvi.siM);
                    textView.setText(j.a(context, oV, dVar.eMf.getTextSize()));
                } catch (Exception e3) {
                    dVar.eMf.setText("");
                }
            }
        }
        return view;
    }
}
