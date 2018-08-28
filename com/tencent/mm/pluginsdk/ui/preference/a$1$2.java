package com.tencent.mm.pluginsdk.ui.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.pluginsdk.ui.preference.a.1;

class a$1$2 implements OnClickListener {
    final /* synthetic */ 1 qOw;
    final /* synthetic */ EditText qOx;

    a$1$2(1 1, EditText editText) {
        this.qOw = 1;
        this.qOx = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String trim = this.qOx.getText().toString().trim();
        if (trim != null && trim.length() > 0) {
            a.a(this.qOw.qOu, trim);
        }
    }
}
