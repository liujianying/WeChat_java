package com.tencent.mm.plugin.appbrand.widget.input.autofill;

class AutoFillListPopupWindowBase$f implements Runnable {
    final /* synthetic */ AutoFillListPopupWindowBase gKu;

    private AutoFillListPopupWindowBase$f(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
        this.gKu = autoFillListPopupWindowBase;
    }

    /* synthetic */ AutoFillListPopupWindowBase$f(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b) {
        this(autoFillListPopupWindowBase);
    }

    public final void run() {
        if (AutoFillListPopupWindowBase.a(this.gKu) != null && AutoFillListPopupWindowBase.a(this.gKu).getCount() > AutoFillListPopupWindowBase.a(this.gKu).getChildCount() && AutoFillListPopupWindowBase.a(this.gKu).getChildCount() <= this.gKu.PT) {
            AutoFillListPopupWindowBase.b(this.gKu).setInputMethodMode(2);
            this.gKu.show();
        }
    }
}
