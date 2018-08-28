package com.tencent.mm.plugin.sns.ui.previewimageview;

import java.util.List;

class e$6 implements Runnable {
    final /* synthetic */ e olJ;
    final /* synthetic */ List olL;

    e$6(e eVar, List list) {
        this.olJ = eVar;
        this.olL = list;
    }

    public final void run() {
        this.olJ.xH(this.olL.size());
        this.olJ.oly.notifyDataSetChanged();
    }
}
