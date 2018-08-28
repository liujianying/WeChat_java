package com.tencent.mm.plugin.brandservice.ui.base;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.b.c.a;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.b.k;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrandServiceSortView extends BaseSortView implements OnCreateContextMenuListener, OnItemLongClickListener, a, BaseSortView.a {
    private boolean LP;
    private String gtX;
    private boolean hpb;
    private int hpr = 0;
    private int hps = 0;
    private HashMap<String, SpannableString> hqi = new HashMap();
    private c hqj = new c();
    private int hqk = 251658241;
    private com.tencent.mm.ui.widget.b.a hql;
    private boolean hqm = false;
    private ListView hqn;
    private a hqo;
    private String hqp;
    private View hqq;
    private TextView hqr;
    private n$d hqs = new 3(this);

    public BrandServiceSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setShowFooterView(false);
        refresh();
        c cVar = this.hqj;
        if (!(this == null || cVar.hnI.contains(this))) {
            x.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
            cVar.hnI.add(this);
        }
        this.hql = new com.tencent.mm.ui.widget.b.a(getContext());
        setDataSetObserver(this);
        setOnItemClickListener(new 1(this));
        setOnItemLongClickListener(this);
    }

    public void setReturnResult(boolean z) {
        this.hpb = z;
    }

    public final void refresh() {
        List list;
        List list2;
        this.hqj.init();
        c cVar = this.hqj;
        switch (this.hqk) {
            case 2:
                list = cVar.hnK;
                break;
            default:
                list = cVar.hnL;
                break;
        }
        if (list != null) {
            List arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    ix ixVar = (ix) list.get(i2);
                    if (!(ixVar == null || ixVar.guS == null)) {
                        d dVar = new d();
                        dVar.data = ixVar;
                        i = ixVar.guS.field_showHead;
                        if (i >= 97 && i <= 122) {
                            i -= 32;
                        }
                        if (i < 65 || i > 90) {
                            dVar.tDT = "#";
                        } else {
                            dVar.tDT = ((char) i);
                        }
                        arrayList.add(dVar);
                    }
                    i = i2 + 1;
                } else {
                    list2 = arrayList;
                }
            }
        } else {
            list2 = null;
        }
        dx(list2);
        super.refresh();
    }

    public final void release() {
        if (g.Eg().Dx()) {
            z.Ni().MS();
        }
        c cVar = this.hqj;
        if (this == null) {
            x.w("MicroMsg.BrandService.BrandServiceMgr", "removeListener:onChange is null");
            cVar.hnI.remove(null);
        }
        c cVar2 = this.hqj;
        g.DF().b(387, cVar2);
        if (cVar2.hnJ) {
            List arrayList = new ArrayList(cVar2.hnK.size() + cVar2.hnL.size());
            for (ix add : cVar2.hnK) {
                arrayList.add(add);
            }
            for (ix add2 : cVar2.hnL) {
                arrayList.add(add2);
            }
            g.DF().a(new k(arrayList), 0);
        }
    }

    public final boolean a(String str, d dVar) {
        if (!(bi.oW(str) || dVar == null)) {
            this.hqp = str;
            ix ixVar = (ix) dVar.data;
            if (ixVar == null || ixVar.guS == null) {
                x.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
                return false;
            }
            ab abVar = ixVar.guS;
            String BL = abVar.BL();
            String wP = abVar.wP();
            String wQ = abVar.wQ();
            String toUpperCase = str.toUpperCase();
            if (!(bi.oW(BL) || BL.toUpperCase().indexOf(toUpperCase) == -1) || (!(bi.oW(wP) || wP.toUpperCase().indexOf(toUpperCase) == -1) || (!bi.oW(wQ) && wQ.toUpperCase().startsWith(toUpperCase)))) {
                return true;
            }
        }
        return false;
    }

    public final View inflate() {
        return View.inflate(getContext(), e.brand_service_sortview, this);
    }

    public VerticalScrollBar getScrollBar() {
        return (VerticalScrollBar) findViewById(b.d.sidrbar);
    }

    public ListView getListView() {
        this.hqn = (ListView) findViewById(b.d.listview);
        if (this.hqq == null) {
            this.hqq = inflate(getContext(), e.count_view, null);
            if (!(this.hqn == null || this.hqq == null)) {
                this.hqr = (TextView) this.hqq.findViewById(b.d.count_tv);
                this.hqn.addFooterView(this.hqq, null, false);
            }
        }
        return this.hqn;
    }

    public View getNoResultView() {
        return findViewById(b.d.no_result);
    }

    public com.tencent.mm.ui.base.sortview.c.a getItemViewCreator() {
        return new 2(this);
    }

    public final void auM() {
        refresh();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.hpr = (int) motionEvent.getRawX();
            this.hps = (int) motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.hql.uKV = view;
        this.hql.a(adapterView, i, j, this, this.hqs, this.hpr, this.hps);
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (contextMenuInfo == null) {
            x.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
            return;
        }
        x.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        d dVar = (d) ((AdapterView) view).getItemAtPosition(adapterContextMenuInfo.position);
        if (dVar == null || dVar.data == null) {
            x.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", new Object[]{dVar});
            return;
        }
        ab abVar = ((ix) dVar.data).guS;
        if (abVar == null) {
            x.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
            return;
        }
        this.gtX = abVar.field_username;
        contextMenu.setHeaderTitle(j.a(getContext(), abVar.BL()));
        com.tencent.mm.ac.d kH = f.kH(abVar.field_username);
        if (kH != null && !kH.LX()) {
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, h.main_conversation_longclick_delete_biz_service);
        }
    }

    public final void av(List<d> list) {
        if (this.hqr != null && list != null) {
            this.hqr.setText(getContext().getString(h.brandservice_count, new Object[]{Integer.valueOf(list.size())}));
        }
    }

    public void setShowFooterView(boolean z) {
        this.LP = z;
        o(this.hqr, z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hqo != null) {
            this.hqo.auW();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public a getITransferToChildOnTouchListener() {
        return this.hqo;
    }

    public void setITransferToChildOnTouchListener(a aVar) {
        this.hqo = aVar;
    }
}
