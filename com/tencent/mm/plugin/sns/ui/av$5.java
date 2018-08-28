package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.a.a$c;

class av$5 implements OnClickListener {
    final /* synthetic */ av ocj;

    av$5(av avVar) {
        this.ocj = avVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof a$c) {
            a$c a_c = (a$c) view.getTag();
            if (a_c == null) {
                return;
            }
            if (this.ocj.nMs.containsKey(a_c.bKW) && ((Integer) this.ocj.nMs.get(a_c.bKW)).equals(Integer.valueOf(1))) {
                this.ocj.nMs.put(a_c.bKW, Integer.valueOf(2));
                this.ocj.obU.notifyDataSetChanged();
                return;
            }
            this.ocj.nMs.put(a_c.bKW, Integer.valueOf(1));
            if (a_c.jEz.getTop() < 0) {
                this.ocj.ntw.b(a_c.jEz, a_c.position, a_c.jEz.getTop(), a_c.oiK.getSpreadHeight());
            } else {
                this.ocj.obU.notifyDataSetChanged();
            }
        }
    }
}
