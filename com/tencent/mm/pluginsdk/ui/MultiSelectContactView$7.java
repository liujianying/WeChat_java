package com.tencent.mm.pluginsdk.ui;

class MultiSelectContactView$7 implements Runnable {
    final /* synthetic */ MultiSelectContactView qGe;

    MultiSelectContactView$7(MultiSelectContactView multiSelectContactView) {
        this.qGe = multiSelectContactView;
    }

    public final void run() {
        MultiSelectContactView.j(this.qGe).scrollTo(MultiSelectContactView.h(this.qGe).getMeasuredWidth(), 0);
    }
}
