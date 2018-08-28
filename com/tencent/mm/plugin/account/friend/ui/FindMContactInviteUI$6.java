package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.plugin.account.a.h;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.i.a;

class FindMContactInviteUI$6 implements a {
    final /* synthetic */ FindMContactInviteUI eLY;

    FindMContactInviteUI$6(FindMContactInviteUI findMContactInviteUI) {
        this.eLY = findMContactInviteUI;
    }

    public final void notifyDataSetChanged() {
        if (FindMContactInviteUI.d(this.eLY) == 2 || FindMContactInviteUI.d(this.eLY) != 1) {
            FindMContactInviteUI.e(this.eLY).setText(this.eLY.getString(j.find_mcontact_invite_all, new Object[]{Integer.valueOf(FindMContactInviteUI.b(this.eLY).getCount())}));
        } else {
            FindMContactInviteUI.e(this.eLY).setText(this.eLY.getString(j.find_mcontact_invite_all_continue));
        }
        if (FindMContactInviteUI.b(this.eLY).Xx()) {
            if (!(FindMContactInviteUI.d(this.eLY) == 1 || FindMContactInviteUI.e(this.eLY).getVisibility() != 0 || FindMContactInviteUI.f(this.eLY) == null)) {
                FindMContactInviteUI.e(this.eLY).setVisibility(8);
                FindMContactInviteUI.f(this.eLY).setVisibility(0);
            }
        } else if (!(FindMContactInviteUI.d(this.eLY) == 1 || FindMContactInviteUI.e(this.eLY).getVisibility() != 8 || FindMContactInviteUI.f(this.eLY) == null)) {
            FindMContactInviteUI.e(this.eLY).setVisibility(0);
            FindMContactInviteUI.f(this.eLY).setVisibility(8);
        }
        if (FindMContactInviteUI.b(this.eLY).getSelectCount() <= 0 || FindMContactInviteUI.d(this.eLY) == 1) {
            FindMContactInviteUI.g(this.eLY).setText(this.eLY.getResources().getQuantityString(h.find_mcontact_invite_friend_cnt, FindMContactInviteUI.b(this.eLY).getCount(), new Object[]{Integer.valueOf(FindMContactInviteUI.b(this.eLY).getCount())}));
            return;
        }
        FindMContactInviteUI.g(this.eLY).setText(this.eLY.getResources().getQuantityString(h.find_mcontact_already_invite_count, FindMContactInviteUI.b(this.eLY).getSelectCount(), new Object[]{Integer.valueOf(FindMContactInviteUI.b(this.eLY).getSelectCount())}));
    }
}
