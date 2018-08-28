package android.support.v7.widget;

import android.support.v7.widget.SearchView.a;
import android.view.inputmethod.InputMethodManager;

class SearchView$1 implements Runnable {
    final /* synthetic */ SearchView UF;

    SearchView$1(SearchView searchView) {
        this.UF = searchView;
    }

    public final void run() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.UF.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            a aVar = SearchView.Uw;
            SearchView searchView = this.UF;
            if (aVar.UJ != null) {
                try {
                    aVar.UJ.invoke(inputMethodManager, new Object[]{Integer.valueOf(0), null});
                    return;
                } catch (Exception e) {
                }
            }
            inputMethodManager.showSoftInput(searchView, 0);
        }
    }
}
