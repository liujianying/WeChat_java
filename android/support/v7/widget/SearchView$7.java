package android.support.v7.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class SearchView$7 implements OnFocusChangeListener {
    final /* synthetic */ SearchView UF;

    SearchView$7(SearchView searchView) {
        this.UF = searchView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (SearchView.c(this.UF) != null) {
            SearchView.c(this.UF).onFocusChange(this.UF, z);
        }
    }
}
