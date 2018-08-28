package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.plugin.appbrand.wxawidget.b.d;
import com.tencent.mm.protocal.c.bio;
import java.util.LinkedList;

class b$b extends BaseAdapter {
    final /* synthetic */ b fyx;
    private LinkedList<bio> fyy;

    public b$b(b bVar, LinkedList<bio> linkedList) {
        this.fyx = bVar;
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
        final bio kh = kh(i);
        if (view == null) {
            a aVar2 = new a(this, (byte) 0);
            view = View.inflate(viewGroup.getContext(), c.authorize_scope_item, null);
            aVar2.fyC = (ImageView) view.findViewById(b.app_auth_state);
            aVar2.fyD = (TextView) view.findViewById(b.app_auth_desc);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (kh.sjd == 1) {
            aVar.fyC.setImageResource(d.login_auth_state_not_selected);
        } else if (kh.sjd == 3) {
            aVar.fyC.setImageResource(d.login_auth_state_must_select);
        } else {
            aVar.fyC.setImageResource(d.login_auth_state_default_select);
        }
        aVar.fyD.setText(kh.jOS);
        final ImageView imageView = aVar.fyC;
        aVar.fyC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (kh.sjd == 2) {
                    imageView.setImageResource(d.login_auth_state_not_selected);
                    kh.sjd = 1;
                } else if (kh.sjd == 1) {
                    imageView.setImageResource(d.login_auth_state_default_select);
                    kh.sjd = 2;
                }
            }
        });
        return view;
    }
}
