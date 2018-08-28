package com.tencent.mm.ui.base.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

class EditPreference$1 implements OnClickListener {
    final /* synthetic */ EditText tBQ;
    final /* synthetic */ EditPreference tBR;

    EditPreference$1(EditPreference editPreference, EditText editText) {
        this.tBR = editPreference;
        this.tBQ = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (EditPreference.a(this.tBR) != null) {
            EditPreference.a(this.tBR).dismiss();
        }
        this.tBR.value = this.tBQ.getText().toString();
        if (EditPreference.b(this.tBR) != null) {
            EditPreference.b(this.tBR).csi();
        }
        if (EditPreference.c(this.tBR) != null) {
            EditPreference.c(this.tBR).a(this.tBR, EditPreference.d(this.tBR));
        }
    }
}
