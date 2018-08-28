package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class AppBrandNumberKeyboardView$2 implements OnClickListener {
    final /* synthetic */ AppBrandNumberKeyboardView gIb;

    AppBrandNumberKeyboardView$2(AppBrandNumberKeyboardView appBrandNumberKeyboardView) {
        this.gIb = appBrandNumberKeyboardView;
    }

    public final void onClick(View view) {
        if (AppBrandNumberKeyboardView.a(this.gIb) != null) {
            CharSequence charSequence = null;
            if (view.getId() == AppBrandNumberKeyboardView.a(this.gIb, "tenpay_keyboard_x")) {
                switch (AppBrandNumberKeyboardView.b(this.gIb)) {
                    case 1:
                        charSequence = "X";
                        break;
                    case 2:
                        charSequence = ".";
                        break;
                    default:
                        return;
                }
            }
            int i = 0;
            while (i < AppBrandNumberKeyboardView.c(this.gIb).size()) {
                String valueOf;
                if (view.getId() == AppBrandNumberKeyboardView.b(this.gIb, (String) AppBrandNumberKeyboardView.c(this.gIb).valueAt(i))) {
                    valueOf = String.valueOf(AppBrandNumberKeyboardView.c(this.gIb).keyAt(i));
                } else {
                    CharSequence valueOf2 = charSequence;
                }
                i++;
                Object charSequence2 = valueOf2;
            }
            if (!TextUtils.isEmpty(charSequence2)) {
                AppBrandNumberKeyboardView.a(this.gIb).commitText(charSequence2, charSequence2.length());
            }
        }
    }
}
