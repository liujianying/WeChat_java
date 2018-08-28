package com.tencent.mm.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.ae.c;
import com.tencent.mm.ui.tools.r;

class ae$a extends BaseAdapter {
    final /* synthetic */ ae tpM;

    private ae$a(ae aeVar) {
        this.tpM = aeVar;
    }

    /* synthetic */ ae$a(ae aeVar, byte b) {
        this(aeVar);
    }

    public final int getCount() {
        return ae.a(this.tpM).size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar = (c) ae.a(this.tpM).get(i);
        View inflate = ae.b(this.tpM).inflate(R.i.mm_submenu_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.h.title);
        if (!bi.oW(cVar.tpQ.tpR)) {
            textView.setText(cVar.tpQ.tpR);
        }
        if (cVar.tpQ.textColor > 0) {
            textView.setTextColor(a.g(ad.getContext(), cVar.tpQ.textColor));
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.h.icon);
        if (cVar.tpQ.icon > 0) {
            imageView.setVisibility(0);
            imageView.setImageResource(((c) ae.a(this.tpM).get(i)).tpQ.icon);
        } else {
            imageView.setVisibility(8);
        }
        if (!bi.oW(cVar.tpQ.tpS)) {
            imageView.setContentDescription(cVar.tpQ.tpS);
        }
        View findViewById = inflate.findViewById(R.h.new_tips);
        textView = (TextView) inflate.findViewById(R.h.unread_count);
        textView.setBackgroundResource(r.hd(ae.c(this.tpM)));
        View findViewById2 = inflate.findViewById(R.h.new_dot);
        if (cVar.tpO) {
            findViewById.setVisibility(0);
        } else if (cVar.bGz > 0) {
            textView.setVisibility(0);
            if (cVar.bGz > 99) {
                textView.setText(R.l.unread_count_overt_100);
            } else {
                textView.setText(cVar.bGz);
            }
        } else if (cVar.tpP) {
            findViewById2.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
            textView.setVisibility(8);
            findViewById2.setVisibility(8);
        }
        if (i == getCount() - 1) {
            inflate.setBackgroundResource(R.g.submenu_item_selector_no_divider);
        } else {
            inflate.setBackgroundResource(R.g.submenu_item_selector);
        }
        return inflate;
    }
}
