package com.tencent.mm.ui;

import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mm.sdk.platformtools.bi;

class AddressView$1 extends a {
    final /* synthetic */ AddressView tgb;

    AddressView$1(AddressView addressView) {
        this.tgb = addressView;
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        Object contentDescription = this.tgb.getContentDescription();
        if (bi.oW((String) contentDescription)) {
            contentDescription = this.tgb.nickName;
        }
        accessibilityEvent.getText().add(contentDescription);
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        CharSequence contentDescription = this.tgb.getContentDescription();
        if (bi.oW((String) contentDescription)) {
            contentDescription = this.tgb.nickName;
        }
        bVar.setText(contentDescription);
    }
}
