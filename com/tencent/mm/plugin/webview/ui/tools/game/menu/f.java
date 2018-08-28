package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;

public final class f extends BaseAdapter {
    private static final String jLG = (b.bnE + "Game/HvMenu/");
    private Context mContext;
    l ofr;

    public final /* synthetic */ Object getItem(int i) {
        return (m) this.ofr.twb.get(i);
    }

    public f(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.ofr == null ? 0 : this.ofr.size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.game_menu_item_view, viewGroup, false);
        a aVar = new a(this, inflate);
        m mVar = (m) this.ofr.twb.get(i);
        if (!(mVar == null || mVar.getItemId() == -1)) {
            String charSequence = mVar.getTitle().toString();
            if (!bi.oW(charSequence)) {
                String[] split = charSequence.split("__", 2);
                if (split.length == 1) {
                    aVar.eGX.setText(split[0]);
                } else {
                    aVar.eGX.setText(split[0]);
                    charSequence = split[1];
                    if (charSequence.startsWith("http")) {
                        String str = jLG + g.u(charSequence.getBytes());
                        a aVar2 = new a();
                        aVar2.dXy = true;
                        aVar2.dXA = str;
                        com.tencent.mm.ak.a.a.Pq().a(charSequence, aVar.gwj, aVar2.Pt());
                    } else {
                        aVar.gwj.setImageResource(ad.getResources().getIdentifier(charSequence, "drawable", ad.getPackageName()));
                    }
                }
                inflate.setTag(mVar);
                return inflate;
            }
        }
        inflate.setTag(null);
        return inflate;
    }
}
