package com.tencent.mm.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.AllRemindMsgUI.c;
import com.tencent.mm.ui.widget.b.a;

class AllRemindMsgUI$c$3 implements OnLongClickListener {
    final /* synthetic */ AllRemindMsgUI tgj;
    final /* synthetic */ c tgk;

    AllRemindMsgUI$c$3(c cVar, AllRemindMsgUI allRemindMsgUI) {
        this.tgk = cVar;
        this.tgj = allRemindMsgUI;
    }

    public final boolean onLongClick(View view) {
        a aVar = new a(this.tgk.tgf.mController.tml);
        int[] iArr = new int[2];
        if (view.getTag(R.h.touch_loc) instanceof int[]) {
            iArr = (int[]) view.getTag(R.h.touch_loc);
        }
        aVar.a(view, new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                contextMenu.add(0, 0, 0, AllRemindMsgUI$c$3.this.tgk.tgf.mController.tml.getString(R.l.chatting_long_click_menu_delete_msg));
            }
        }, new 2(this, view), iArr[0], iArr[1]);
        return true;
    }
}
