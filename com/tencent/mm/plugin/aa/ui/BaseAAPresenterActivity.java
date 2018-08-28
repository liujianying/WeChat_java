package com.tencent.mm.plugin.aa.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ab.l;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;

public abstract class BaseAAPresenterActivity extends WalletBaseUI {
    private static final int eCE = a.fromDPToPix(ad.getContext(), 300);
    private c dtb = new c();
    protected View eCD;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dtb.A(getIntent(), this);
        this.uYS = true;
    }

    public void onResume() {
        super.onResume();
        this.dtb.GM(2);
    }

    public void onPause() {
        super.onPause();
        this.dtb.GM(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.dtb.onDestroy();
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T t(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return this.dtb.a(this, cls);
    }

    public final <T extends com.tencent.mm.vending.app.a> T w(Class<? extends com.tencent.mm.vending.app.a> cls) {
        return this.dtb.b(this, cls);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final void a(View view, int i, boolean z, boolean z2) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.tenpay_num_keyboard);
        this.kMk = findViewById(f.tenpay_keyboard_layout);
        View findViewById = findViewById(f.tenpay_push_down);
        final EditText editText = (EditText) view.findViewById(f.wallet_content);
        if (this.mKeyboard != null && editText != null && this.kMk != null) {
            this.kMk.setVisibility(8);
            e.setNoSystemInputOnEditText(editText);
            final boolean z3 = z;
            final boolean z4 = z2;
            final View view2 = view;
            final int i2 = i;
            editText.setOnFocusChangeListener(new OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    if (!view.isFocused() || z3) {
                        new ag().postDelayed(new 2(this), 200);
                        return;
                    }
                    ((InputMethodManager) BaseAAPresenterActivity.this.mController.tml.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new ag().postDelayed(new 1(this, view), 300);
                }
            });
            editText.setOnClickListener(new 2(this, z, editText, i));
            findViewById.setOnClickListener(new 3(this));
        }
    }

    public final void Wq() {
        super.Wq();
        if (this.eCD != null) {
            this.eCD.scrollTo(0, 0);
        }
    }
}
