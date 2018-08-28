package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class ShowImageUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ShowImageUI uCd;

    ShowImageUI$2(ShowImageUI showImageUI) {
        this.uCd = showImageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        if (ShowImageUI.a(this.uCd) && d.QS("favorite")) {
            linkedList2.add(Integer.valueOf(0));
            linkedList.add(this.uCd.getString(R.l.retransmits));
            linkedList2.add(Integer.valueOf(1));
            linkedList.add(this.uCd.getString(R.l.plugin_favorite_opt));
            linkedList2.add(Integer.valueOf(2));
            linkedList.add(this.uCd.getString(R.l.save_to_local));
        } else {
            linkedList2.add(Integer.valueOf(0));
            linkedList.add(this.uCd.getString(R.l.retransmits));
            linkedList2.add(Integer.valueOf(2));
            linkedList.add(this.uCd.getString(R.l.save_to_local));
        }
        dj djVar = new dj();
        djVar.bLf.bJC = this.uCd.getIntent().getLongExtra("key_message_id", -1);
        a.sFg.m(djVar);
        if (djVar.bLg.bKE) {
            linkedList2.add(Integer.valueOf(3));
            linkedList.add(this.uCd.getString(R.l.chatting_long_click_menu_open));
        }
        h.a(this.uCd, "", linkedList, linkedList2, "", false, new 1(this));
        return true;
    }
}
