package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.bio;
import java.util.LinkedList;

class l$b extends BaseAdapter {
    private LinkedList<bio> fyy;
    final /* synthetic */ l qlo;

    public l$b(l lVar, LinkedList<bio> linkedList) {
        this.qlo = lVar;
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
            a aVar2 = new a(this, (byte) 0);
            view = View.inflate(viewGroup.getContext(), R.i.authorize_scope_item, null);
            aVar2.fyC = (ImageView) view.findViewById(R.h.app_auth_state);
            aVar2.fyD = (TextView) view.findViewById(R.h.app_auth_desc);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (kh.sjd == 1) {
            aVar.fyC.setImageResource(R.k.login_auth_state_not_selected);
        } else if (kh.sjd == 3) {
            aVar.fyC.setImageResource(R.k.login_auth_state_must_select);
        } else {
            aVar.fyC.setImageResource(R.k.login_auth_state_default_select);
        }
        aVar.fyD.setText(kh.jOS);
        aVar.fyC.setOnClickListener(new 1(this, kh, aVar.fyC));
        return view;
    }
}
