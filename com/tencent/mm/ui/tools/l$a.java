package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

class l$a extends BaseAdapter {
    final /* synthetic */ l uAD;

    private l$a(l lVar) {
        this.uAD = lVar;
    }

    /* synthetic */ l$a(l lVar, byte b) {
        this(lVar);
    }

    public final int getCount() {
        return l.a(this.uAD) ? l.b(this.uAD).size() + 1 : l.b(this.uAD).size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getItemViewType(int i) {
        return (l.a(this.uAD) && i == 0) ? 0 : 1;
    }

    public final int getViewTypeCount() {
        return l.a(this.uAD) ? 2 : 1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2;
        if (l.a(this.uAD) && i == 0) {
            if (view == null) {
                view = l.c(this.uAD).inflate(h.mm_submenu_title_item, viewGroup, false);
                aVar = new a(this, (byte) 0);
                aVar.eGX = (TextView) view.findViewById(g.title);
                aVar.gwj = (ImageView) view.findViewById(g.icon);
                view.setTag(aVar);
                aVar2 = aVar;
            } else {
                aVar2 = (a) view.getTag();
            }
            aVar2.eGX.setText(l.f(this.uAD));
        } else {
            if (l.a(this.uAD)) {
                i--;
            }
            if (view == null) {
                view = l.c(this.uAD).inflate(h.mm_submenu_item, viewGroup, false);
                aVar = new a(this, (byte) 0);
                aVar.eGX = (TextView) view.findViewById(g.title);
                aVar.gwj = (ImageView) view.findViewById(g.icon);
                aVar.nHH = view.findViewById(g.root);
                view.setTag(aVar);
                aVar2 = aVar;
            } else {
                aVar2 = (a) view.getTag();
            }
            MenuItem item = l.b(this.uAD).getItem(i);
            aVar2.eGX.setText(item.getTitle());
            if (item.getIcon() != null) {
                aVar2.gwj.setVisibility(0);
                aVar2.gwj.setImageDrawable(item.getIcon());
            } else if (l.d(this.uAD) != null) {
                aVar2.gwj.setVisibility(0);
                l.d(this.uAD).a(aVar2.gwj, item);
            } else {
                aVar2.gwj.setVisibility(8);
            }
            if (l.e(this.uAD) != null) {
                l.e(this.uAD).a(aVar2.eGX, item);
            }
            if (i == l.b(this.uAD).size() - 1) {
                aVar2.nHH.setBackgroundResource(f.submenu_item_selector_no_divider);
            } else {
                aVar2.nHH.setBackgroundResource(f.submenu_item_selector);
            }
        }
        return view;
    }
}
