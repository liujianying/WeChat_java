package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;

class a$12 implements OnClickListener {
    final /* synthetic */ a lpk;

    a$12(a aVar) {
        this.lpk = aVar;
    }

    public final void onClick(View view) {
        this.lpk.bfk();
        if (!this.lpk.lpd && this.lpk.loU <= this.lpk.lfT.duration) {
            a aVar = this.lpk;
            this.lpk.loW = -1;
            aVar.loV = -1;
            this.lpk.lla.bft();
            this.lpk.loS = this.lpk.lla.lqM;
            this.lpk.loT = false;
        }
    }
}
