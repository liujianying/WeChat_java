package com.tencent.mm.plugin.voip.ui;

class e$9 implements Runnable {
    final /* synthetic */ e oSe;

    e$9(e eVar) {
        this.oSe = eVar;
    }

    public final void run() {
        if (this.oSe.getActivity() != null && !this.oSe.getActivity().isFinishing()) {
            e.g(this.oSe).setVisibility(8);
        }
    }
}
