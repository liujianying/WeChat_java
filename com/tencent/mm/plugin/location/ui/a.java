package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.map.a$e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.j;
import java.util.ArrayList;
import java.util.Iterator;

public final class a extends j {
    private int kEh = 8;
    private ArrayList<String> kEi = new ArrayList();

    class a {
        ImageView eKk;
        TextView kEj;

        a() {
        }
    }

    public final void B(ArrayList<String> arrayList) {
        boolean z;
        this.kEi.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.kEi.add((String) it.next());
        }
        String str = "MicroMsg.MMGridPaperAdapter";
        String str2 = "notifyDataSetChange, notifier is null ? %B";
        Object[] objArr = new Object[1];
        if (this.tvj == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.tvj != null) {
            this.tvj.avj();
        }
    }

    public final int getCount() {
        return this.kEi.size();
    }

    public final View d(int i, View view) {
        a aVar = new a();
        if (view == null) {
            view = View.inflate(ad.getContext(), f.avatar_dialog_item, null);
            aVar.eKk = (ImageView) view.findViewById(a$e.avatar_img);
            aVar.kEj = (TextView) view.findViewById(a$e.username);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        String str = (String) this.kEi.get(i);
        b.a(aVar.eKk, str);
        CharSequence gT = r.gT(str);
        if (gT.length() > this.kEh) {
            gT = gT.subSequence(0, this.kEh + 1) + "...";
        }
        aVar.kEj.setText(gT);
        return view;
    }

    public final Object getItem(int i) {
        return this.kEi.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
