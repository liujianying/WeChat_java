package android.support.design.widget;

import android.text.Editable;
import android.text.TextWatcher;

class TextInputLayout$1 implements TextWatcher {
    final /* synthetic */ TextInputLayout iK;

    TextInputLayout$1(TextInputLayout textInputLayout) {
        this.iK = textInputLayout;
    }

    public final void afterTextChanged(Editable editable) {
        TextInputLayout.a(this.iK);
        if (TextInputLayout.b(this.iK)) {
            TextInputLayout.a(this.iK, editable.length());
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
