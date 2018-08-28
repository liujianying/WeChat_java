package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.plugin.appbrand.widget.input.b.a;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class AppBrandNumberKeyboardView extends MyKeyboardWindow {
    private int gHX = 0;
    private final SparseArray<String> gHY = new 1(this);
    InputConnection gHZ;
    a gIa;

    static /* synthetic */ boolean d(AppBrandNumberKeyboardView appBrandNumberKeyboardView) {
        if (appBrandNumberKeyboardView.gHZ == null) {
            return false;
        }
        if (!TextUtils.isEmpty(appBrandNumberKeyboardView.gHZ.getTextBeforeCursor(1, 0))) {
            appBrandNumberKeyboardView.gHZ.deleteSurroundingText(1, 0);
            return true;
        }
        appBrandNumberKeyboardView.gHZ.sendKeyEvent(new KeyEvent(0, 67));
        appBrandNumberKeyboardView.gHZ.sendKeyEvent(new KeyEvent(1, 67));
        return true;
    }

    AppBrandNumberKeyboardView(Context context) {
        super(context);
        init();
    }

    public AppBrandNumberKeyboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        2 2 = new 2(this);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gHY.size()) {
                findViewById(getId((String) this.gHY.valueAt(i2))).setOnClickListener(2);
                i = i2 + 1;
            } else {
                findViewById(getId("tenpay_keyboard_x")).setOnClickListener(2);
                findViewById(getId("tenpay_keyboard_d")).setOnClickListener(null);
                findViewById(getId("tenpay_keyboard_d")).setOnTouchListener(new 3(this));
                return;
            }
        }
    }

    public final void setXMode(int i) {
        super.setXMode(i);
        this.gHX = i;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setInputEditText(null);
    }
}
