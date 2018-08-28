package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;

class MobileFriendUI$14 implements OnItemClickListener {
    final /* synthetic */ MobileFriendUI eIS;

    MobileFriendUI$14(MobileFriendUI mobileFriendUI) {
        this.eIS = mobileFriendUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= MobileFriendUI.f(this.eIS).getHeaderViewsCount()) {
            a aVar = (a) MobileFriendUI.d(this.eIS).getItem(i - MobileFriendUI.f(this.eIS).getHeaderViewsCount());
            if (aVar.status == 1 || aVar.status == 2) {
                this.eIS.b(aVar);
            }
            if (aVar.status == 0) {
                Intent intent = new Intent(this.eIS, InviteFriendUI.class);
                intent.putExtra("friend_type", 1);
                intent.putExtra("friend_user_name", aVar.getUsername());
                intent.putExtra("friend_num", aVar.Xp());
                intent.putExtra("friend_nick", aVar.Xj());
                intent.putExtra("friend_weixin_nick", aVar.Xm());
                intent.putExtra("friend_scene", 13);
                this.eIS.startActivity(intent);
            }
        }
    }
}
