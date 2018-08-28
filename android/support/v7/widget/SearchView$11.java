package android.support.v7.widget;

import android.support.v4.view.g;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class SearchView$11 implements OnKeyListener {
    final /* synthetic */ SearchView UF;

    SearchView$11(SearchView searchView) {
        this.UF = searchView;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (SearchView.o(this.UF) == null) {
            return false;
        }
        if (SearchView.m(this.UF).isPopupShowing() && SearchView.m(this.UF).getListSelection() != -1) {
            return SearchView.a(this.UF, i, keyEvent);
        }
        if (SearchView$SearchAutoComplete.a(SearchView.m(this.UF)) || !g.a(keyEvent) || keyEvent.getAction() != 1 || i != 66) {
            return false;
        }
        view.cancelLongPress();
        SearchView.a(this.UF, SearchView.m(this.UF).getText().toString());
        return true;
    }
}
