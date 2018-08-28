package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.clean.c.b;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.HashSet;

public final class a extends BaseAdapter {
    HashSet<Integer> gUV = new HashSet();
    CleanChattingUI hTk;

    public a(CleanChattingUI cleanChattingUI) {
        this.hTk = cleanChattingUI;
    }

    public final int getCount() {
        ArrayList aBi = d.aBi();
        if (aBi != null) {
            return aBi.size();
        }
        return 0;
    }

    private static b oq(int i) {
        return (b) d.aBi().get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.hTk.getLayoutInflater().inflate(R.i.clean_chatting_item, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.eCl = (ImageView) view.findViewById(R.h.avatar_iv);
            aVar2.eCm = (TextView) view.findViewById(R.h.title_tv);
            aVar2.eCn = (TextView) view.findViewById(R.h.desc_tv);
            aVar2.eCo = (CheckBox) view.findViewById(R.h.select_cb);
            aVar2.gUY = (RelativeLayout) view.findViewById(R.h.select_cb_click_layout);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gUY.setOnClickListener(new 1(this, i));
        b oq = oq(i);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.eCl, oq.username);
        aVar.eCm.setText(bi.bF(oq.gTK));
        if (s.fq(oq.username)) {
            aVar.eCn.setText(j.a(this.hTk, r.getDisplayName(oq.username, oq.username), aVar.eCn.getTextSize()));
        } else {
            aVar.eCn.setText(j.a(this.hTk, r.gT(oq.username), aVar.eCn.getTextSize()));
        }
        if (this.gUV.contains(Integer.valueOf(i))) {
            aVar.eCo.setChecked(true);
        } else {
            aVar.eCo.setChecked(false);
        }
        return view;
    }

    public final void aBw() {
        this.gUV.clear();
        this.hTk.a(this.gUV);
    }
}
