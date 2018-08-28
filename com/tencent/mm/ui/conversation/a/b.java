package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.ui.r;
import java.util.ArrayList;

public final class b extends r<c> {
    private ArrayList<c> eWc = new ArrayList();
    a urM = null;

    public final /* bridge */ /* synthetic */ Object a(Object obj, Cursor cursor) {
        return null;
    }

    public b(Context context) {
        super(context, null);
        WS();
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        this.eWc.clear();
        if (this.urM != null) {
            this.eWc.add(new c(this.urM));
            notifyDataSetChanged();
        }
    }

    public final int getCount() {
        return this.eWc.size();
    }

    /* renamed from: FV */
    public final c getItem(int i) {
        return (c) this.eWc.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        c cVar = (c) this.eWc.get(i);
        if (view == null) {
            view = View.inflate(this.context, R.i.adlist_item, null);
            d dVar2 = new d();
            dVar2.urO = view;
            dVar2.urP = (Button) view.findViewById(R.h.ad_close);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        if (cVar.a(dVar) != 0) {
            return null;
        }
        return view;
    }
}
