package com.tencent.mm.plugin.game.ui.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.aq;
import com.tencent.mm.sdk.platformtools.bi;

public final class a extends BaseAdapter {
    private GameTabData kcR;
    private String kcS;
    private Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return (TabItem) this.kcR.aUC().get(i);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public final void a(GameTabData gameTabData, String str) {
        this.kcR = gameTabData;
        this.kcS = str;
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.kcR == null ? 0 : this.kcR.aUC().size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(f.game_tab_item_view, viewGroup, false);
        a aVar = new a(this, inflate);
        TabItem tabItem = (TabItem) this.kcR.aUC().get(i);
        if (tabItem != null) {
            aVar.eGX.setText(tabItem.title);
            String str;
            com.tencent.mm.ak.a.a.c.a aVar2;
            if (bi.oV(this.kcS).equalsIgnoreCase(tabItem.jOl)) {
                if (!bi.oW(tabItem.jOr)) {
                    str = aq.jOw + g.u(tabItem.jOr.getBytes());
                    aVar2 = new com.tencent.mm.ak.a.a.c.a();
                    aVar2.dXy = true;
                    aVar2.dXA = str;
                    com.tencent.mm.ak.a.a.Pq().a(tabItem.jOr, aVar.gwj, aVar2.Pt());
                }
            } else if (!bi.oW(tabItem.jOq)) {
                str = aq.jOw + g.u(tabItem.jOq.getBytes());
                aVar2 = new com.tencent.mm.ak.a.a.c.a();
                aVar2.dXy = true;
                aVar2.dXA = str;
                com.tencent.mm.ak.a.a.Pq().a(tabItem.jOq, aVar.gwj, aVar2.Pt());
            }
        }
        inflate.setTag(tabItem);
        return inflate;
    }
}
