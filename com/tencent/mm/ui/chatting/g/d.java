package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.b.a;
import com.tencent.mm.ui.chatting.a.b.e;

public final class d extends b {
    int gBh = -1;
    int tYk = 0;

    public d(Context context) {
        super(context);
    }

    public final int getType() {
        return 6;
    }

    public final void cwG() {
        x.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", new Object[]{Boolean.valueOf(true)});
        this.tXZ.cwK();
        g.Ek();
        g.Em().H(new 1(this));
    }

    public final String Wm() {
        return this.mContext.getString(R.l.all_history_file);
    }

    public final String cwJ() {
        return this.mContext.getString(R.l.all_history_file);
    }

    public final e cwH() {
        return new 2(this);
    }

    public final t m(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.file_list_item, viewGroup, false));
    }

    public final void a(a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) EZ(i);
        if (bi.oW(aVar2.desc)) {
            bVar.eCn.setVisibility(8);
        } else {
            bVar.eCn.setVisibility(0);
            bVar.eCn.setText(bi.aG(aVar2.desc, ""));
        }
        bVar.gmn.setImageResource(aVar2.iconRes);
    }
}
