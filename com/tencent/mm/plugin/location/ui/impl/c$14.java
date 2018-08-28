package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.sdk.platformtools.x;

class c$14 implements OnItemClickListener {
    final /* synthetic */ c kJf;

    c$14(c cVar) {
        this.kJf = cVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", new Object[]{Integer.valueOf(i)});
        if (!c.q(this.kJf)) {
            if (i >= c.o(this.kJf).getCount()) {
                x.i("MicroMsg.MMPoiMapUI", "wrong position");
                return;
            }
            f rU = c.o(this.kJf).rU(i);
            if (rU.type == 0) {
                View r = c.r(this.kJf);
                double d = rU.bhC;
                double d2 = rU.bhD;
                if (r.kES) {
                    r.kFl.updateLocaitonPinLayout(r, d, d2);
                } else {
                    r.kES = true;
                    r.kFl.addPinView(r, d, d2);
                }
                c.l(this.kJf).setBackgroundResource(d.location_my);
            } else {
                c.r(this.kJf).remove();
                c.l(this.kJf).setEnabled(true);
            }
            this.kJf.kFl.getIController().animateTo(rU.bhC, rU.bhD);
            c.o(this.kJf).kJp = i;
            c.o(this.kJf).notifyDataSetChanged();
        }
        c.n(this.kJf);
    }
}
