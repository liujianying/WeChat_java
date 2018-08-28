package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.a;

class FMessageConversationUI$5 extends BaseAdapter {
    final /* synthetic */ FMessageConversationUI ose;

    FMessageConversationUI$5(FMessageConversationUI fMessageConversationUI) {
        this.ose = fMessageConversationUI;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.ose.mController.tml).inflate(R.i.fmessage_conversation_empty_list_item, null);
            aVar = new a(this.ose, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.gwj.setImageResource(R.k.find_more_friend_mobile_icon);
            aVar.eGX.setText(R.l.find_friends_by_mobile);
        }
        return view;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final int getCount() {
        return 1;
    }
}
