package android.support.v7.widget;

import android.text.Editable;
import android.text.TextWatcher;

class SearchView$4 implements TextWatcher {
    final /* synthetic */ SearchView UF;

    SearchView$4(SearchView searchView) {
        this.UF = searchView;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        SearchView.a(this.UF, charSequence);
    }

    public final void afterTextChanged(Editable editable) {
    }
}
