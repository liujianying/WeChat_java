package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.sdk.platformtools.x;

class m$4 implements OnClickListener {
    final /* synthetic */ m jZZ;

    m$4(m mVar) {
        this.jZZ = mVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            d dVar = (d) view.getTag();
            if (this.jZZ.jZW.containsKey(dVar.field_appId)) {
                n nVar = (n) this.jZZ.jZW.get(dVar.field_appId);
                nVar.dC(this.jZZ.mContext);
                this.jZZ.jWA.jTR = dVar.jLt;
                this.jZZ.jWA.jNv = this.jZZ.jNv;
                this.jZZ.jWA.a(dVar, nVar);
                return;
            }
            x.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
            return;
        }
        x.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
    }
}
