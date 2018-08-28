package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bw.a.c;
import com.tencent.mm.bw.a.f;
import com.tencent.mm.bw.a.g;
import com.tencent.mm.ui.base.m;
import java.util.ArrayList;
import java.util.HashMap;

public class d$a extends BaseAdapter {
    private Context context;
    final /* synthetic */ d uLw;
    public HashMap<Integer, Boolean> uLx = new HashMap();
    private ArrayList<Integer> uLy;

    public d$a(d dVar, Context context) {
        this.uLw = dVar;
        this.context = context;
    }

    public final int getCount() {
        return this.uLw.ofr.size();
    }

    public final Object getItem(int i) {
        return this.uLw.ofr.twb.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        m mVar = (m) this.uLw.ofr.twb.get(i);
        LayoutInflater from = LayoutInflater.from(this.context);
        if (view == null) {
            view = from.inflate(g.multi_picker_item, null);
            a aVar2 = new a(this);
            aVar2.uKp = (LinearLayout) view.findViewById(f.item_ll);
            aVar2.jBR = (CheckBox) view.findViewById(f.item_check);
            aVar2.eCm = (TextView) view.findViewById(f.item_title);
            aVar2.eCn = (TextView) view.findViewById(f.item_desc);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.eCm.setText(mVar.getTitle());
        aVar.uKp.setOnClickListener(new 1(this, i, mVar));
        if (aVar.eCn != null) {
            if (mVar.jyi == null || mVar.jyi.length() <= 0) {
                aVar.eCn.setVisibility(8);
            } else {
                aVar.eCn.setVisibility(0);
                aVar.eCn.setText(mVar.jyi);
            }
        }
        if (mVar.spC) {
            aVar.eCm.setTextColor(this.uLw.mContext.getResources().getColor(c.bottom_sheet_text_color_disable));
            aVar.eCn.setTextColor(this.uLw.mContext.getResources().getColor(c.bottom_sheet_text_color_disable));
            aVar.jBR.setChecked(((Boolean) this.uLx.get(Integer.valueOf(i))).booleanValue());
            aVar.jBR.setEnabled(false);
        } else {
            aVar.eCm.setTextColor(this.uLw.mContext.getResources().getColor(c.bottom_sheet_text_color));
            aVar.eCn.setTextColor(this.uLw.mContext.getResources().getColor(c.bottom_sheet_text_desc_color));
            aVar.jBR.setChecked(((Boolean) this.uLx.get(Integer.valueOf(i))).booleanValue());
            aVar.jBR.setEnabled(true);
        }
        return view;
    }

    public final void cAQ() {
        if (this.uLw.uLt != null) {
            for (int i = 0; i < getCount(); i++) {
                if (this.uLw.uLt.contains(Integer.valueOf(i))) {
                    this.uLx.put(Integer.valueOf(i), Boolean.valueOf(true));
                } else {
                    this.uLx.put(Integer.valueOf(i), Boolean.valueOf(false));
                }
            }
        }
    }

    public final ArrayList<Integer> cAR() {
        if (this.uLx == null) {
            return null;
        }
        this.uLy = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getCount()) {
                return this.uLy;
            }
            if (((Boolean) this.uLx.get(Integer.valueOf(i2))).booleanValue()) {
                this.uLy.add(Integer.valueOf(i2));
            }
            i = i2 + 1;
        }
    }
}
