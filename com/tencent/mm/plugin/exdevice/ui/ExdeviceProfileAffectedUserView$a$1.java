package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileAffectedUserView.a;

class ExdeviceProfileAffectedUserView$a$1 implements Runnable {
    final /* synthetic */ a iDR;

    ExdeviceProfileAffectedUserView$a$1(a aVar) {
        this.iDR = aVar;
    }

    public final void run() {
        this.iDR.notifyDataSetChanged();
    }
}
