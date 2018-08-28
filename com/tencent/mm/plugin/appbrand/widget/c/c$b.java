package com.tencent.mm.plugin.appbrand.widget.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s$i;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.protocal.c.bio;
import java.util.LinkedList;

final class c$b extends BaseAdapter {
    private LinkedList<bio> fyy;

    c$b(LinkedList<bio> linkedList) {
        this.fyy = linkedList;
    }

    public final int getCount() {
        return this.fyy == null ? 0 : this.fyy.size();
    }

    private bio kh(int i) {
        return (bio) this.fyy.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (this.fyy == null || this.fyy.size() <= 0) {
            return null;
        }
        a aVar;
        bio kh = kh(i);
        if (view == null) {
            a aVar2 = new a((byte) 0);
            view = View.inflate(viewGroup.getContext(), h.authorize_scope_item, null);
            aVar2.fyC = (ImageView) view.findViewById(g.app_auth_state);
            aVar2.fyD = (TextView) view.findViewById(g.app_auth_desc);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (kh.sjd == 1) {
            aVar.fyC.setImageResource(s$i.login_auth_state_not_selected);
        } else if (kh.sjd == 3) {
            aVar.fyC.setImageResource(s$i.login_auth_state_must_select);
        } else {
            aVar.fyC.setImageResource(s$i.login_auth_state_default_select);
        }
        aVar.fyD.setText(kh.jOS);
        aVar.fyC.setOnClickListener(new 1(this, kh, aVar.fyC));
        return view;
    }
}
