package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

class h$12 implements OnClickListener {
    final /* synthetic */ h$b pzi;
    final /* synthetic */ MMEditText ttx;
    final /* synthetic */ Context val$context;

    h$12(h$b h_b, MMEditText mMEditText, Context context) {
        this.pzi = h_b;
        this.ttx = mMEditText;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean z = true;
        if (this.pzi != null) {
            z = this.pzi.p(this.ttx.getText().toString().trim());
        }
        if (z) {
            dialogInterface.dismiss();
            if (this.val$context instanceof MMActivity) {
                ah.A(new 1(this));
            }
        }
    }
}
