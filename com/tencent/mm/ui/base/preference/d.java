package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.ui.y;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.util.HashMap;
import junit.framework.Assert;

final class d extends BaseAdapter {
    private final Context context;
    protected int lSy = -1;
    private final int style;
    protected CharSequence[] tBI;
    protected CharSequence[] tBJ;
    protected String value;
    protected final HashMap<CharSequence, c> values = new HashMap();

    public d(Context context) {
        this.context = context;
        this.style = 1;
    }

    protected final void csh() {
        boolean z;
        int i = 0;
        if (this.tBI == null) {
            this.tBI = new CharSequence[0];
        }
        if (this.tBJ == null) {
            this.tBJ = new CharSequence[0];
        }
        String str = "entries count different";
        if (this.tBI.length == this.tBJ.length) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        this.values.clear();
        while (i < this.tBJ.length) {
            this.values.put(this.tBJ[i], new c(this.tBI[i], 1048576 + i));
            i++;
        }
    }

    public final int getCount() {
        return this.tBJ.length;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = y.gq(this.context).inflate(h.mm_preference_dialog_item, null);
            a aVar = new a();
            aVar.lSz = (TextView) view.findViewById(g.text);
            aVar.lSA = (CheckBox) view.findViewById(g.check);
            aVar.lSB = (RadioButton) view.findViewById(g.radio);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.lSz.setText(this.tBI[i]);
        switch (this.style) {
            case 1:
                aVar2.lSA.setVisibility(8);
                aVar2.lSB.setVisibility(0);
                aVar2.lSB.setChecked(this.tBJ[i].equals(this.value));
                break;
            case 2:
                aVar2.lSA.setVisibility(0);
                aVar2.lSB.setVisibility(8);
                aVar2.lSA.setChecked(this.tBJ[i].equals(this.value));
                break;
            default:
                aVar2.lSA.setVisibility(8);
                aVar2.lSB.setVisibility(8);
                break;
        }
        return view;
    }
}
