package com.tencent.mm.ui.widget.b;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.bw.a.g;

class a$a extends BaseAdapter {
    final /* synthetic */ a uKZ;

    private a$a(a aVar) {
        this.uKZ = aVar;
    }

    /* synthetic */ a$a(a aVar, byte b) {
        this(aVar);
    }

    public final int getCount() {
        return a.a(this.uKZ).size();
    }

    private String jl(int i) {
        return (String) ((MenuItem) a.a(this.uKZ).twb.get(i)).getTitle();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = null;
        if (view == null) {
            view2 = (TextView) a.f(this.uKZ).inflate(g.popup_submenu_item, viewGroup, false);
        } else if (view instanceof TextView) {
            view2 = (TextView) view;
        }
        CharSequence jl = jl(i);
        if (view2 != null) {
            view2.setTag(jl);
            view2.setText(jl);
        }
        return view2;
    }
}
