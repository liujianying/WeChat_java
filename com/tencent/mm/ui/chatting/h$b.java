package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.j;

class h$b extends BaseAdapter {
    final /* synthetic */ h tIi;

    private h$b(h hVar) {
        this.tIi = hVar;
    }

    /* synthetic */ h$b(h hVar, byte b) {
        this(hVar);
    }

    public final int getCount() {
        return h.a(this.tIi);
    }

    private j EJ(int i) {
        return (j) h.b(this.tIi).dMj.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        if (view == null) {
            view2 = (TextView) h.c(this.tIi).inflate(R.i.popup_submenu_item, viewGroup, false);
        } else {
            view2 = (TextView) view;
        }
        j EJ = EJ(i);
        view2.setTag(EJ);
        view2.setText(com.tencent.mm.pluginsdk.ui.d.j.a(h.d(this.tIi), EJ.name));
        return view2;
    }
}
