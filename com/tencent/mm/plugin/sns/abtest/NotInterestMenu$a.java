package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.ui.y;

class NotInterestMenu$a extends BaseAdapter {
    final /* synthetic */ NotInterestMenu nhA;

    NotInterestMenu$a(NotInterestMenu notInterestMenu) {
        this.nhA = notInterestMenu;
    }

    public final int getCount() {
        return NotInterestMenu.bwF().length;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(NotInterestMenu.bwF()[i]);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = y.gq(NotInterestMenu.d(this.nhA)).inflate(g.not_interest_menu_item, viewGroup, false);
            a aVar = new a(this);
            aVar.nhB = (TextView) view.findViewById(f.not_interest_text);
            view.setTag(aVar);
        }
        ((a) view.getTag()).nhB.setText(NotInterestMenu.bwF()[i]);
        return view;
    }
}
