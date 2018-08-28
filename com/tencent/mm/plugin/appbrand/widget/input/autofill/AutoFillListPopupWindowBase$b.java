package com.tencent.mm.plugin.appbrand.widget.input.autofill;

class AutoFillListPopupWindowBase$b implements Runnable {
    final /* synthetic */ AutoFillListPopupWindowBase gKu;

    private AutoFillListPopupWindowBase$b(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
        this.gKu = autoFillListPopupWindowBase;
    }

    /* synthetic */ AutoFillListPopupWindowBase$b(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b) {
        this(autoFillListPopupWindowBase);
    }

    public final void run() {
        this.gKu.clearListSelection();
    }
}
