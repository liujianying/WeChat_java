package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.readerapp.a.b;
import com.tencent.mm.plugin.readerapp.a.c;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.ui.base.n$d;

class ReaderAppUI$c extends a<Long> {
    private Context context;
    private int edl = this.hFO;
    private int hFO = 3;
    private int hqG;
    final /* synthetic */ ReaderAppUI mnQ;
    private int mnV;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    public ReaderAppUI$c(ReaderAppUI readerAppUI, Context context, Long l) {
        this.mnQ = readerAppUI;
        super(context, l);
        this.context = context;
        this.mnV = context.getResources().getDimensionPixelSize(b.BasicPaddingSize);
        this.hqG = context.getResources().getDimensionPixelSize(b.SmallPadding);
    }

    protected final void WS() {
        WT();
    }

    public final boolean ayQ() {
        return this.hFO >= this.edl;
    }

    public final int bpU() {
        return this.hFO;
    }

    public final int ayR() {
        if (ayQ()) {
            return 0;
        }
        this.hFO += 3;
        if (this.hFO <= this.edl) {
            return 3;
        }
        this.hFO = this.edl;
        return this.edl % 3;
    }

    public final void WT() {
        this.edl = g.bpT().hg(ReaderAppUI.a(this.mnQ));
        setCursor(g.bpT().bb(this.hFO, ReaderAppUI.a(this.mnQ)));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(this.context, e.reader_app_root_item, null);
            aVar.moi = (ReaderItemListView) view.findViewById(d.reader_root_item_list);
            aVar.jWm = (TextView) view.findViewById(d.reader_app_item_time_tv);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jWm.setText(h.c(this.context, ((Long) getItem(i)).longValue(), false));
        ReaderItemListView readerItemListView = aVar.moi;
        long longValue = ((Long) getItem(i)).longValue();
        OnCreateContextMenuListener a = ReaderAppUI.a(this.mnQ, false);
        n$d g = ReaderAppUI.g(this.mnQ);
        readerItemListView.position = i;
        readerItemListView.mom = a;
        readerItemListView.hqV = g;
        readerItemListView.mok = g.bpT().c(longValue, readerItemListView.type);
        readerItemListView.mol.notifyDataSetChanged();
        if (ReaderAppUI.h(this.mnQ) != null) {
            aVar.jWm.setTextColor(ReaderAppUI.h(this.mnQ).qER);
            if (ReaderAppUI.h(this.mnQ).qES) {
                aVar.jWm.setShadowLayer(2.0f, 1.2f, 1.2f, ReaderAppUI.h(this.mnQ).qET);
            } else {
                aVar.jWm.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
            if (ReaderAppUI.h(this.mnQ).qEU) {
                aVar.jWm.setBackgroundResource(c.chat_tips_bg);
                aVar.jWm.setPadding(this.hqG, this.mnV, this.hqG, this.mnV);
            } else {
                aVar.jWm.setBackgroundColor(0);
            }
        }
        return view;
    }
}
