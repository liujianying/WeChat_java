package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.bw.a.i;

class SearchBarUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SearchBarUI tpV;

    SearchBarUI$1(SearchBarUI searchBarUI) {
        this.tpV = searchBarUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SearchBarUI searchBarUI = this.tpV;
        if (!searchBarUI.tgz.isEmpty()) {
            searchBarUI.tgz.clear();
            searchBarUI.supportInvalidateOptionsMenu();
        }
        searchBarUI.tpU = new ag(searchBarUI);
        searchBarUI.tpU.setSearchViewListener(searchBarUI);
        searchBarUI.tpU.setHint(searchBarUI.getResources().getString(i.ui_search));
        searchBarUI.getSupportActionBar().setCustomView(searchBarUI.tpU);
        if (searchBarUI != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) searchBarUI.getSystemService("input_method");
            if (inputMethodManager != null) {
                View currentFocus = searchBarUI.getCurrentFocus();
                if (!(currentFocus == null || currentFocus.getWindowToken() == null)) {
                    inputMethodManager.toggleSoftInput(0, 2);
                }
            }
        }
        return false;
    }
}
