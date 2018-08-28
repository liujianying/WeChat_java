package com.tencent.mm.plugin.voip.ui;

class f$10 implements Runnable {
    final /* synthetic */ f oSK;

    f$10(f fVar) {
        this.oSK = fVar;
    }

    public final void run() {
        if (this.oSK.getActivity() != null && !this.oSK.getActivity().isFinishing()) {
            f.k(this.oSK).setVisibility(8);
        }
    }
}
