package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.ui.tools.g;

class ContactRemarkInfoModUI$b implements TextWatcher {
    private int mPQ;
    final /* synthetic */ ContactRemarkInfoModUI ujh;
    private String ujj;

    private ContactRemarkInfoModUI$b(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ujh = contactRemarkInfoModUI;
        this.mPQ = 800;
        this.ujj = "";
    }

    /* synthetic */ ContactRemarkInfoModUI$b(ContactRemarkInfoModUI contactRemarkInfoModUI, byte b) {
        this(contactRemarkInfoModUI);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        this.mPQ = g.be(800, editable.toString());
        if (this.mPQ < 0) {
            this.mPQ = 0;
        }
        if (ContactRemarkInfoModUI.a(this.ujh) != null) {
            ContactRemarkInfoModUI.a(this.ujh).setText(this.mPQ);
        }
        ContactRemarkInfoModUI.b(this.ujh);
    }
}
