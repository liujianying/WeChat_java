package android.support.design.widget;

import android.support.v4.view.an;
import android.view.View;

class TextInputLayout$3 extends an {
    final /* synthetic */ TextInputLayout iK;
    final /* synthetic */ CharSequence iL;

    TextInputLayout$3(TextInputLayout textInputLayout, CharSequence charSequence) {
        this.iK = textInputLayout;
        this.iL = charSequence;
    }

    public final void q(View view) {
        TextInputLayout.c(this.iK).setText(this.iL);
        view.setVisibility(4);
    }
}
