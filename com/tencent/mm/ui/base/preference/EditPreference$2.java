package com.tencent.mm.ui.base.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class EditPreference$2 implements OnClickListener {
    final /* synthetic */ EditPreference tBR;

    EditPreference$2(EditPreference editPreference) {
        this.tBR = editPreference;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (EditPreference.a(this.tBR) != null) {
            EditPreference.a(this.tBR).dismiss();
        }
    }
}
