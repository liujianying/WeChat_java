package com.tencent.mm.plugin.sight.draft.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;

class SightDraftUI$2 implements a {
    final /* synthetic */ SightDraftUI nfa;

    SightDraftUI$2(SightDraftUI sightDraftUI) {
        this.nfa = sightDraftUI;
    }

    public final void bwc() {
        this.nfa.addTextOptionMenu(SightDraftUI.a(this.nfa), this.nfa.getString(R.l.sight_draft_save), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SightDraftUI.b(SightDraftUI$2.this.nfa);
                return true;
            }
        });
    }

    public final void bwd() {
        this.nfa.removeOptionMenu(SightDraftUI.a(this.nfa));
    }
}
