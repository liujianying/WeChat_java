package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
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
    ArrayList<i> gvR;
    private CleanChattingDetailUI hRS;
    c hRU = new 3(this);
    private ag hRV = new ag() {
        public final void handleMessage(Message message) {
            if (!b.this.anx) {
                b.this.notifyDataSetChanged();
            }
        }
    };
    OnScrollListener hRW = new 6(this);
    OnItemClickListener hpE = new 4(this);
    boolean isStop = false;
    private String username;

    static /* synthetic */ void c(b bVar) {
        if (!bVar.isStop) {
            ah.A(new 1(bVar));
        }
    }

    public b(CleanChattingDetailUI cleanChattingDetailUI, String str) {
        this.hRS = cleanChattingDetailUI;
        this.gUV = new HashSet();
        this.gvR = new ArrayList();
        this.username = str;
    }

    public final int getCount() {
        return this.gvR.size();
    }

    /* renamed from: on */
    public final i getItem(int i) {
        return (i) this.gvR.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        c cVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = this.hRS.getLayoutInflater().inflate(R.i.clean_chatting_detail_item, viewGroup, false);
            c cVar2 = new c(this);
            cVar2.hSb = (MMImageView) view.findViewById(R.h.content_iv);
            cVar2.eCo = (CheckBox) view.findViewById(R.h.select_cb);
            cVar2.hSd = view.findViewById(R.h.select_cb_clickarea);
            cVar2.hSe = view.findViewById(R.h.selected_item_mask);
            cVar2.hSc = (ImageView) view.findViewById(R.h.play_iv);
            cVar2.eMe = (TextView) view.findViewById(R.h.name_tv);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        i on = getItem(i);
        cVar.hSb.setTag(on.filePath);
        cVar.hSd.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, i);
                b.this.notifyDataSetChanged();
            }
        });
        if (this.gUV.contains(Integer.valueOf(i))) {
            cVar.eCo.setChecked(true);
            cVar.hSe.setVisibility(0);
        } else {
            cVar.eCo.setChecked(false);
            cVar.hSe.setVisibility(8);
        }
        if (on.type == 3) {
            cVar.hSc.setVisibility(0);
        } else {
            cVar.hSc.setVisibility(8);
        }
        if (on.type == 4) {
            cVar.hSb.setImageResource(o.SQ(com.tencent.mm.a.e.cp(on.filePath)));
            cVar.eMe.setText(new File(on.filePath).getName());
            cVar.eMe.setVisibility(0);
        } else {
            if (hRT == 0) {
                hRT = view.getMeasuredWidth();
            }
            a aVar = new a();
            aVar.dXD = 1;
            aVar.dXz = false;
            aVar.dXF = hRT;
            aVar.dXE = hRT;
            aVar.dXA = on.bOX;
            com.tencent.mm.ak.o.Pj().a(on.bOX, cVar.hSb, aVar.Pt());
            cVar.eMe.setVisibility(8);
        }
        x.d("MicroMsg.CleanChattingDetailAdapter", "getView time=%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return view;
    }

    public final long oo(int i) {
        return ((i) this.gvR.get(i)).aAX();
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            x.v("MicroMsg.CleanChattingDetailAdapter", "convertView is null");
            view = this.hRS.getLayoutInflater().inflate(R.i.clean_chatting_detail_item_header, viewGroup, false);
            aVar = new a(this);
            aVar.hRY = (TextView) view.findViewById(R.h.header_tv);
            aVar.hRZ = (TextView) view.findViewById(R.h.header_select_tv);
            aVar.hSa = (CheckBox) view.findViewById(R.h.header_select_cb);
            view.setTag(aVar);
        } else {
            x.v("MicroMsg.CleanChattingDetailAdapter", "convertView is not null");
            aVar = (a) view.getTag();
        }
        i on = getItem(i);
        aVar.position = i;
        aVar.hRY.setText(h.h(this.hRS.getString(R.l.fmt_year_month), on.enK / 1000));
        long aAX = on.aAX();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.gvR.size(); i2++) {
            if (((i) this.gvR.get(i2)).aAX() == aAX) {
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
        this.hRS.op(this.gUV.size());
        CleanChattingDetailUI cleanChattingDetailUI = this.hRS;
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
            j = ((i) this.gvR.get(((Integer) it.next()).intValue())).size + j;
        }
        CleanChattingDetailUI cleanChattingDetailUI2 = this.hRS;
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
