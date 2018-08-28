package com.tencent.mm.plugin.sns.ui;

class CollapsibleTextView$1 implements Runnable {
    final /* synthetic */ CollapsibleTextView nMu;

    CollapsibleTextView$1(CollapsibleTextView collapsibleTextView) {
        this.nMu = collapsibleTextView;
    }

    public final void run() {
        if (this.nMu.nMn != null && (this.nMu.nMn.getTag() instanceof as) && ((as) this.nMu.nMn.getTag()).bSZ.equals(CollapsibleTextView.a(this.nMu))) {
            this.nMu.nMn.setMaxLines(6);
            this.nMu.nMp.setVisibility(0);
            this.nMu.nMp.setText(CollapsibleTextView.b(this.nMu));
        }
    }
}
