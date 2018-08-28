package com.tencent.mm.pluginsdk.ui.preference;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.5;

class NormalUserHeaderPreference$5$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 5 qPq;

    NormalUserHeaderPreference$5$1(5 5) {
        this.qPq = 5;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(NormalUserHeaderPreference.a(this.qPq.qPp).getString(R.l.app_copy));
    }
}
