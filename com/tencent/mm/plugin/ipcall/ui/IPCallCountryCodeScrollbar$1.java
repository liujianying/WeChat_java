package com.tencent.mm.plugin.ipcall.ui;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.bp.a;

class IPCallCountryCodeScrollbar$1 implements Runnable {
    final /* synthetic */ int kvd;
    final /* synthetic */ int kve;
    final /* synthetic */ IPCallCountryCodeScrollbar kvf;

    IPCallCountryCodeScrollbar$1(IPCallCountryCodeScrollbar iPCallCountryCodeScrollbar, int i, int i2) {
        this.kvf = iPCallCountryCodeScrollbar;
        this.kvd = i;
        this.kve = i2;
    }

    public final void run() {
        if (this.kvf.kuW.length > 0) {
            int measureText = ((int) IPCallCountryCodeScrollbar.a(this.kvf).measureText(this.kvf.kuW[this.kvf.kuW.length - 1])) + a.fromDPToPix(this.kvf.getContext(), 8);
            if (measureText > this.kvd) {
                LayoutParams layoutParams = this.kvf.getLayoutParams();
                layoutParams.width = measureText;
                layoutParams.height = this.kve;
                this.kvf.setLayoutParams(layoutParams);
            }
        }
    }
}
