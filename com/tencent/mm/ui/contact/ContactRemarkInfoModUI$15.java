package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.R;

class ContactRemarkInfoModUI$15 implements OnFocusChangeListener {
    final /* synthetic */ ContactRemarkInfoModUI ujh;

    ContactRemarkInfoModUI$15(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ujh = contactRemarkInfoModUI;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            ContactRemarkInfoModUI.i(this.ujh).setBackgroundResource(R.g.input_bar_bg_active);
        } else {
            ContactRemarkInfoModUI.i(this.ujh).setBackgroundResource(R.g.input_bar_bg_normal);
        }
    }
}
