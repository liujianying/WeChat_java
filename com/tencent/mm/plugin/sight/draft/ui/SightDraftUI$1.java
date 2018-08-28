package com.tencent.mm.plugin.sight.draft.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SightDraftUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SightDraftUI nfa;

    SightDraftUI$1(SightDraftUI sightDraftUI) {
        this.nfa = sightDraftUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nfa.finish();
        return false;
    }
}
