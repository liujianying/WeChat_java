package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.a;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;
import com.tencent.mm.ui.gridviewheaders.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class b extends BaseAdapter implements e {
    private static int hRT = 0;
    private boolean anx;
    HashSet<Integer> gUV;
    ArrayList<a> gvR;
    c hRU = new 2(this);
    private ag hRV = new 4(this);
    OnScrollListener hRW = new 5(this);
    private CleanChattingDetailUI hTm;
    OnItemClickListener hpE = new 3(this);

    class b {
        CheckBox eCo;
        TextView eMe;
        MMImageView hSb;
        ImageView hSc;
        View hSd;
        View hSe;

        b() {
        }
    }

    public b(CleanChattingDetailUI cleanChattingDetailUI, ArrayList<a> arrayList) {
        this.hTm = cleanChattingDetailUI;
        this.gvR = arrayList;
        this.gUV = new HashSet();
    }

    public final int getCount() {
        return this.gvR.size();
    }

    /* renamed from: or */
    public final a getItem(int i) {
        return (a) this.gvR.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.hTm.getLayoutInflater().inflate(R.i.clean_chatting_detail_item, viewGroup, false);
            b bVar2 = new b();
            bVar2.hSb = (MMImageView) view.findViewById(R.h.content_iv);
            bVar2.eCo = (CheckBox) view.findViewById(R.h.select_cb);
            bVar2.hSd = view.findViewById(R.h.select_cb_clickarea);
            bVar2.hSe = view.findViewById(R.h.selected_item_mask);
            bVar2.hSc = (ImageView) view.findViewById(R.h.play_iv);
            bVar2.eMe = (TextView) view.findViewById(R.h.name_tv);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        a or = getItem(i);
        bVar.hSb.setTag(or.filePath);
        bVar.hSd.setOnClickListener(new 1(this, i));
        if (this.gUV.contains(Integer.valueOf(i))) {
            bVar.eCo.setChecked(true);
            bVar.hSe.setVisibility(0);
        } else {
            bVar.eCo.setChecked(false);
            bVar.hSe.setVisibility(8);
        }
        if (or.type == 3) {
            bVar.hSc.setVisibility(0);
        } else {
            bVar.hSc.setVisibility(8);
        }
        if (or.type == 4) {
            bVar.hSb.setImageResource(o.SQ(com.tencent.mm.a.e.cp(or.filePath)));
            bVar.eMe.setText(new File(or.filePath).getName());
            bVar.eMe.setVisibility(0);
        } else {
            if (hRT == 0) {
                hRT = view.getMeasuredWidth();
            }
            com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
            aVar.dXD = 1;
            aVar.dXz = false;
            aVar.dXF = hRT;
            aVar.dXE = hRT;
            if (or.type == 1) {
                aVar.dXA = or.filePath;
                com.tencent.mm.ak.o.Pj().a(or.filePath, bVar.hSb, aVar.Pt());
            } else {
                aVar.dXA = or.bOX;
                com.tencent.mm.ak.o.Pj().a(or.bOX, bVar.hSb, aVar.Pt());
            }
            bVar.eMe.setVisibility(8);
        }
        x.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return view;
    }

    public final long oo(int i) {
        return ((a) this.gvR.get(i)).aAX();
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            x.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.hTm.getLayoutInflater().inflate(R.i.clean_chatting_detail_item_header, viewGroup, false);
            aVar = new a(this);
            aVar.hRY = (TextView) view.findViewById(R.h.header_tv);
            aVar.hRZ = (TextView) view.findViewById(R.h.header_select_tv);
            aVar.hSa = (CheckBox) view.findViewById(R.h.header_select_cb);
            view.setTag(aVar);
        } else {
            x.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            aVar = (a) view.getTag();
        }
        a or = getItem(i);
        aVar.position = i;
        aVar.hRY.setText(h.h(this.hTm.getString(R.l.fmt_year_month), or.enK / 1000));
        long aAX = or.aAX();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.gvR.size(); i2++) {
            if (((a) this.gvR.get(i2)).aAX() == aAX) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        Iterator it = hashSet.iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean z2;
            if (this.gUV.contains(Integer.valueOf(((Integer) it.next()).intValue()))) {
                z2 = z;
            } else {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            aVar.hSa.setChecked(true);
        } else {
            aVar.hSa.setChecked(false);
        }
        return view;
    }

    final void aBx() {
        boolean z;
        this.hTm.op(this.gUV.size());
        CleanChattingDetailUI cleanChattingDetailUI = this.hTm;
        if (this.gUV.size() == this.gvR.size()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            cleanChattingDetailUI.gVd.setChecked(true);
        } else {
            cleanChattingDetailUI.gVd.setChecked(false);
        }
        Iterator it = this.gUV.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = ((a) this.gvR.get(((Integer) it.next()).intValue())).size + j;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.hTm;
        if (j > 0) {
            cleanChattingDetailUI2.hSh.setText(cleanChattingDetailUI2.getString(R.l.delete_info, new Object[]{bi.bF(j)}));
            return;
        }
        cleanChattingDetailUI2.hSh.setText("");
    }

    public final void aBw() {
        this.gUV.clear();
        aBx();
    }
}
