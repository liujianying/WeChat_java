package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashSet;
import java.util.List;

public final class a extends BaseAdapter {
    private List<c> dataList;
    HashSet<Integer> gUV = new HashSet();
    CleanChattingUI hRQ;

    class a {
        ImageView eCl;
        TextView eCm;
        TextView eCn;
        CheckBox eCo;
        RelativeLayout gUY;

        a() {
        }
    }

    public a(CleanChattingUI cleanChattingUI, List<c> list) {
        this.hRQ = cleanChattingUI;
        this.dataList = list;
    }

    public final int getCount() {
        return this.dataList.size();
    }

    /* renamed from: om */
    public final c getItem(int i) {
        return (c) this.dataList.get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.hRQ.getLayoutInflater().inflate(R.i.clean_chatting_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.eCl = (ImageView) view.findViewById(R.h.avatar_iv);
            aVar2.eCm = (TextView) view.findViewById(R.h.title_tv);
            aVar2.eCn = (TextView) view.findViewById(R.h.desc_tv);
            aVar2.eCo = (CheckBox) view.findViewById(R.h.select_cb);
            aVar2.gUY = (RelativeLayout) view.findViewById(R.h.select_cb_click_layout);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gUY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (a.this.gUV.contains(Integer.valueOf(i))) {
                    a.this.gUV.remove(Integer.valueOf(i));
                } else {
                    a.this.gUV.add(Integer.valueOf(i));
                }
                a.this.notifyDataSetChanged();
                a.this.hRQ.a(a.this.gUV);
            }
        });
        c om = getItem(i);
        b.a(aVar.eCl, om.username);
        aVar.eCm.setText(bi.bF(om.size));
        if (s.fq(om.username)) {
            aVar.eCn.setText(j.a(this.hRQ, r.getDisplayName(om.username, om.username), aVar.eCn.getTextSize()));
        } else {
            aVar.eCn.setText(j.a(this.hRQ, r.gT(om.username), aVar.eCn.getTextSize()));
        }
        if (this.gUV.contains(Integer.valueOf(i))) {
            aVar.eCo.setChecked(true);
        } else {
            aVar.eCo.setChecked(false);
        }
        return view;
    }

    public final void aBw() {
        this.gUV.clear();
        this.hRQ.a(this.gUV);
    }
}
