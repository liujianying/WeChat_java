package com.tencent.mm.ui.contact;

import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$9 implements Runnable {
    final /* synthetic */ a uhE;

    AddressUI$a$9(a aVar) {
        this.uhE = aVar;
    }

    public final void run() {
        a.a(this.uhE).cxY();
        if (a.e(this.uhE) != null) {
            a.e(this.uhE).reset();
            if (a.e(this.uhE).getOpenIMCount() <= 0) {
                a.e(this.uhE).setVisibility(8);
            } else {
                a.e(this.uhE).setVisibility(0);
            }
        }
    }
}
