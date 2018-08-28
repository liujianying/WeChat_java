package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a.e;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;

public final class a extends BaseAdapter {
    private LayoutInflater eMa;
    private String[] ePm;
    private Drawable ePn = null;
    private OnTouchListener ePo = new 1(this);

    public a(Context context, String[] strArr) {
        this.ePm = strArr;
        this.eMa = LayoutInflater.from(context);
        this.ePn = context.getResources().getDrawable(e.signup_chose_line);
        this.ePn.setBounds(0, 0, this.ePn.getIntrinsicWidth(), this.ePn.getIntrinsicHeight());
    }

    public final int getCount() {
        return this.ePm.length;
    }

    public final Object getItem(int i) {
        return this.ePm[i];
    }

    private boolean jk(int i) {
        if (i == this.ePm.length - 1) {
            return true;
        }
        return false;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 1;
        if (view == null) {
            view = this.eMa.inflate(g.alias_item, null);
        }
        TextView textView = (TextView) view.findViewById(f.alias_tv);
        view.setOnTouchListener(this.ePo);
        if ((i == 0 ? 1 : 0) == 0 || !jk(i)) {
            if (i != 0) {
                i2 = 0;
            }
            if (i2 != 0) {
                textView.setPadding(25, 0, 10, 10);
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(null, null, this.ePn, null);
            } else if (jk(i)) {
                textView.setPadding(0, 0, 25, 10);
                textView.setCompoundDrawablePadding(0);
                textView.setCompoundDrawables(null, null, null, null);
            } else {
                textView.setPadding(0, 0, 10, 10);
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(null, null, this.ePn, null);
            }
        } else {
            textView.setPadding(25, 0, 25, 10);
            textView.setCompoundDrawablePadding(0);
            textView.setCompoundDrawables(null, null, null, null);
        }
        textView.setText(this.ePm[i]);
        return view;
    }
}
