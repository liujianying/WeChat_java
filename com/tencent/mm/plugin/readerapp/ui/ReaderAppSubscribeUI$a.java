package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.a.g;

class ReaderAppSubscribeUI$a extends BaseAdapter {
    private final Context context;
    final int[] mnH = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
    int mnI;
    private String[] mnJ = null;
    int mnK = 0;

    public final /* bridge */ /* synthetic */ Object getItem(int i) {
        return this.mnJ[i];
    }

    public ReaderAppSubscribeUI$a(Context context, int i) {
        this.context = context;
        this.mnI = i;
        this.mnJ = context.getString(g.readerapp_subscribe_category).split(";");
        this.mnK = ve(i);
    }

    public final int getCount() {
        return this.mnJ.length;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.context, e.readerapp_subscribe_item, null);
            aVar2.eCm = (TextView) view.findViewById(d.readerapp_subscribe_item_title_tv);
            aVar2.eCo = (CheckBox) view.findViewById(d.readerapp_subscribe_item_select_cb);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.eCm.setText(this.mnJ[i]);
        aVar.eCo.setChecked((this.mnI & this.mnH[i]) != 0);
        return view;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int ve(int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2;
            if (i3 >= this.mnH.length) {
                return i4;
            }
            if ((this.mnH[i3] & i) != 0) {
                i2 = i4 + 1;
            } else {
                i2 = i4;
            }
            i3++;
        }
    }
}
