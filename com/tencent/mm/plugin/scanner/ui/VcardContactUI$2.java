package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.ui.base.h.c;

class VcardContactUI$2 implements c {
    final /* synthetic */ VcardContactUI mMs;
    final /* synthetic */ String mMt;

    VcardContactUI$2(VcardContactUI vcardContactUI, String str) {
        this.mMs = vcardContactUI;
        this.mMt = str;
    }

    public final void ju(int i) {
        Intent intent;
        switch (i) {
            case 0:
                intent = new Intent();
                String[] strArr = new String[]{this.mMt + " " + this.mMt};
                intent.putExtra("composeType", 4);
                intent.putExtra("toList", strArr);
                d.b(this.mMs, "qqmail", ".ui.ComposeUI", intent);
                return;
            case 1:
                intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{this.mMt});
                this.mMs.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
