package com.tencent.mm.plugin.sns.ui.b;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.b.b.35;

class b$35$1 implements OnCreateContextMenuListener {
    final /* synthetic */ 35 olm;

    b$35$1(35 35) {
        this.olm = 35;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        contextMenu.add(0, 0, 0, this.olm.olf.activity.getString(j.contact_info_op_sns_permission));
        contextMenu.add(1, 1, 0, this.olm.olf.activity.getString(j.sns_timeline_expose));
    }
}
