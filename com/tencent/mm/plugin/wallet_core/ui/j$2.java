package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.m.b;
import com.tencent.mm.plugin.wallet_core.ui.j.a;

class j$2 implements OnItemClickListener {
    final /* synthetic */ j pvv;

    j$2(j jVar) {
        this.pvv = jVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a b = j.b(this.pvv);
        m mVar = b.pvz;
        if (i < mVar.poq.size()) {
            int i2 = ((b) mVar.poq.get(i)).poz;
            int i3 = m.a.pov;
            switch (m$1.pot[i2 - 1]) {
                case 1:
                    mVar.dZ(i, m.a.pov);
                    break;
                case 2:
                    mVar.dZ(i, m.a.pow);
                    break;
            }
            mVar.bOP();
        }
        b.notifyDataSetChanged();
    }
}
