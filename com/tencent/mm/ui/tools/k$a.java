package com.tencent.mm.ui.tools;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

class k$a extends BaseAdapter {
    final /* synthetic */ k uAA;

    private k$a(k kVar) {
        this.uAA = kVar;
    }

    /* synthetic */ k$a(k kVar, byte b) {
        this(kVar);
    }

    public final int getCount() {
        return k.a(this.uAA).size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = k.b(this.uAA).inflate(h.mm_list_menu_item, viewGroup, false);
            a aVar2 = new a(this, (byte) 0);
            aVar2.eGX = (TextView) view.findViewById(g.title);
            aVar2.gwj = (ImageView) view.findViewById(g.icon);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        MenuItem item = k.a(this.uAA).getItem(i);
        aVar.eGX.setText(item.getTitle());
        Drawable icon = k.a(this.uAA).getItem(i).getIcon();
        if (icon != null) {
            aVar.gwj.setVisibility(0);
            aVar.gwj.setImageDrawable(icon);
        } else if (k.c(this.uAA) != null) {
            aVar.gwj.setVisibility(0);
            k.c(this.uAA).a(aVar.gwj, item);
        } else {
            aVar.gwj.setVisibility(8);
        }
        if (k.d(this.uAA) != null) {
            k.d(this.uAA).a(aVar.eGX, item);
        }
        return view;
    }
}
