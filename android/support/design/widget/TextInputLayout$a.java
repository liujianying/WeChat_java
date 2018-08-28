package android.support.design.widget;

import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class TextInputLayout$a extends a {
    final /* synthetic */ TextInputLayout iK;

    private TextInputLayout$a(TextInputLayout textInputLayout) {
        this.iK = textInputLayout;
    }

    /* synthetic */ TextInputLayout$a(TextInputLayout textInputLayout, byte b) {
        this(textInputLayout);
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        CharSequence charSequence = TextInputLayout.d(this.iK).mText;
        if (!TextUtils.isEmpty(charSequence)) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.setClassName(TextInputLayout.class.getSimpleName());
        CharSequence charSequence = TextInputLayout.d(this.iK).mText;
        if (!TextUtils.isEmpty(charSequence)) {
            bVar.setText(charSequence);
        }
        if (TextInputLayout.e(this.iK) != null) {
            b.xr.f(bVar.xs, TextInputLayout.e(this.iK));
        }
        charSequence = TextInputLayout.c(this.iK) != null ? TextInputLayout.c(this.iK).getText() : null;
        if (!TextUtils.isEmpty(charSequence)) {
            b.xr.H(bVar.xs);
            b.xr.a(bVar.xs, charSequence);
        }
    }
}
