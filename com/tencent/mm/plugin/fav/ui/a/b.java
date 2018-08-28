package com.tencent.mm.plugin.fav.ui.a;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.d.a;
import com.tencent.mm.plugin.fav.ui.d.d;
import com.tencent.mm.plugin.fav.ui.d.e;
import com.tencent.mm.plugin.fav.ui.d.f;
import com.tencent.mm.plugin.fav.ui.d.h;
import com.tencent.mm.plugin.fav.ui.d.i;
import com.tencent.mm.plugin.fav.ui.d.j;
import com.tencent.mm.plugin.fav.ui.d.l;
import com.tencent.mm.plugin.fav.ui.d.m;
import com.tencent.mm.plugin.fav.ui.d.n;
import com.tencent.mm.plugin.fav.ui.d.o;
import com.tencent.mm.plugin.fav.ui.d.p;
import com.tencent.mm.plugin.fav.ui.d.q;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class b extends a {
    public String bWm;
    private c fIu;
    public int iVT;
    private boolean jbD;
    public List<g> jbE;
    private List<g> jbF;
    private List<g> jbG;
    public List<Long> jbH;
    public boolean jbI;
    private Map<Long, g> jbJ;
    private List<Integer> jbK;
    private List<String> jbL;
    private List<String> jbM;
    private SparseArray<a> jbN;
    private boolean jbO;
    public a.c jbP;
    public boolean jbQ;
    public boolean jbR;
    public ListView jbS;
    public int scene;

    public b(k kVar, boolean z) {
        this.jbD = false;
        this.jbE = new ArrayList();
        this.jbF = new ArrayList();
        this.jbG = new LinkedList();
        this.jbH = new ArrayList();
        this.jbI = false;
        this.jbJ = new TreeMap();
        this.jbK = new ArrayList();
        this.jbL = new LinkedList();
        this.jbM = new LinkedList();
        this.jbN = new SparseArray();
        this.jbO = false;
        this.jbQ = false;
        this.jbR = false;
        this.bWm = "";
        this.fIu = new c<jt>() {
            {
                this.sFo = jt.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                jt jtVar = (jt) bVar;
                if (jtVar instanceof jt) {
                    switch (jtVar.bTE.action) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            b.this.notifyDataSetChanged();
                            break;
                    }
                }
                return false;
            }
        };
        this.type = -1;
        this.jbN.put(1, new m(kVar));
        this.jbN.put(2, new d(kVar));
        this.jbN.put(3, new q(kVar));
        this.jbN.put(4, new p(kVar));
        this.jbN.put(5, new o(kVar));
        this.jbN.put(6, new e(kVar));
        this.jbN.put(7, new com.tencent.mm.plugin.fav.ui.d.g(kVar));
        this.jbN.put(8, new com.tencent.mm.plugin.fav.ui.d.c(kVar));
        this.jbN.put(10, new i(kVar));
        this.jbN.put(12, new l(kVar));
        this.jbN.put(15, new l(kVar));
        this.jbN.put(11, new f(kVar));
        this.jbN.put(14, new j(kVar));
        this.jbN.put(16, new com.tencent.mm.plugin.fav.ui.d.k(kVar));
        this.jbN.put(17, new com.tencent.mm.plugin.fav.ui.d.b(kVar));
        this.jbN.put(18, new h(kVar));
        this.jbN.put(-2, new n(kVar));
        if (z != this.jbQ) {
            this.jbQ = z;
            if (z) {
                this.jbJ.clear();
            }
        }
        if (!this.jbQ) {
            aMD();
        }
        aME();
        notifyDataSetChanged();
        com.tencent.mm.sdk.b.a.sFg.c(this.fIu);
        com.tencent.mm.sdk.b.a.sFg.b(this.fIu);
    }

    public final void finish() {
        com.tencent.mm.sdk.b.a.sFg.c(this.fIu);
    }

    private void pP(int i) {
        int i2 = this.iVT;
        if (i == 0) {
            this.iVT = 0;
        } else if (i2 == 0) {
            this.iVT = i;
        } else if (i2 != i) {
            this.iVT = 4;
        }
    }

    public final void aMD() {
        if (aMF()) {
            x.v("MicroMsg.FavoriteAdapter", "searching, do not load more data");
        } else if (com.tencent.mm.plugin.fav.a.b.aKY()) {
            x.w("MicroMsg.FavoriteAdapter", "want to load more data, but now doing batchget");
        } else if (this.jbQ) {
            this.jbF = e(this.jbE, this.jbH);
            this.jbD = true;
        } else {
            try {
                this.lastUpdateTime = com.tencent.mm.plugin.fav.a.b.o(this.lastUpdateTime, this.type);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FavoriteAdapter", e, "", new Object[0]);
            }
        }
    }

    private static List<g> e(List<g> list, List<Long> list2) {
        int i = 0;
        List<g> arrayList = new ArrayList();
        if (list2 == null) {
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
            Long valueOf = Long.valueOf(((g) list.get(list.size() - 1)).field_localId);
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (valueOf.equals(list2.get(i2))) {
                    i = i2 + 1;
                    break;
                }
            }
        }
        int i3 = i;
        while (i3 < i + 20 && i3 < list2.size()) {
            g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(((Long) list2.get(i3)).longValue());
            if (dy != null) {
                arrayList.add(dy);
            }
            i3++;
        }
        return arrayList;
    }

    private boolean aMF() {
        return (this.jbL.isEmpty() && this.jbM.isEmpty() && this.jbK.isEmpty()) ? false : true;
    }

    public final void a(boolean z, g gVar) {
        if (z != this.jbI) {
            this.jbI = z;
            if (z) {
                this.jbJ.clear();
                if (gVar != null) {
                    g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(gVar.field_localId);
                    if (dy != null) {
                        this.jbJ.put(Long.valueOf(dy.field_localId), dy);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public final List<g> eU(boolean z) {
        List<g> linkedList = new LinkedList();
        for (g gVar : this.jbJ.values()) {
            if (gVar != null) {
                linkedList.add(gVar);
            }
        }
        if (z) {
            this.jbJ.clear();
        }
        return linkedList;
    }

    public final int aMG() {
        return this.jbJ.size();
    }

    public final long aMH() {
        long j = 0;
        Iterator it = this.jbJ.values().iterator();
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            g gVar = (g) it.next();
            if (gVar != null) {
                j = gVar.field_datatotalsize + j2;
            } else {
                j = j2;
            }
        }
    }

    public final void b(List<Integer> list, List<String> list2, List<String> list3) {
        pP(0);
        this.jbK.clear();
        if (list != null) {
            this.jbK.addAll(list);
            if (!list.isEmpty()) {
                pP(2);
            }
        }
        this.jbL.clear();
        if (list2 != null) {
            this.jbL.addAll(list2);
            if (!list2.isEmpty()) {
                pP(3);
            }
        }
        this.jbM.clear();
        if (list3 != null) {
            this.jbM.addAll(list3);
            if (!list3.isEmpty()) {
                pP(1);
            }
        }
        this.jbO = true;
        aME();
        this.jbO = false;
    }

    public final void aME() {
        x.v("MicroMsg.FavoriteAdapter", "reset data list beg");
        this.jbD = false;
        List list = this.jbF;
        if (list != null) {
            x.d("MicroMsg.FavoriteAdapter", "before do recycle, need recycle list size[%d]", new Object[]{Integer.valueOf(list.size())});
            x.d("MicroMsg.FavoriteAdapter", "after do recycle, current can reused list size[%d]", new Object[]{Integer.valueOf(this.jbG.size())});
            list.clear();
        }
        if (aMF()) {
            x.i("MicroMsg.FavoriteAdapter", "on reset data list, do search, searchStr:%s, tagStr:%s, searchTypes:%s", new Object[]{this.jbL, this.jbM, this.jbK});
            this.jbF = com.tencent.mm.plugin.fav.a.b.a(this.jbL, this.jbM, this.jbK, this.jbG, this.jbA, this.jbB);
            int size = this.jbF == null ? 0 : this.jbF.size();
            com.tencent.mm.plugin.report.service.h.mEJ.h(10649, new Object[]{Integer.valueOf(size)});
        } else {
            x.i("MicroMsg.FavoriteAdapter", "on reset data list, last update time is %d, type is %d", new Object[]{Long.valueOf(this.lastUpdateTime), Integer.valueOf(this.type)});
            if (this.jbQ) {
                pP(0);
                this.jbH = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().aLH();
                this.jbF = e(null, this.jbH);
            } else {
                this.jbF = com.tencent.mm.plugin.fav.a.b.a(this.lastUpdateTime, this.type, this.jbA, this.jbB);
                if (this.jbF != null && this.lastUpdateTime == 0 && this.jbF.size() > 0) {
                    this.lastUpdateTime = ((g) this.jbF.get(this.jbF.size() - 1)).field_updateTime;
                }
            }
        }
        if (this.jbF == null) {
            x.w("MicroMsg.FavoriteAdapter", "reset data list fail, get null list, new empty one");
            this.jbF = new ArrayList();
        }
        if (!(this.jbQ || aMF() || this.jbF.size() >= 20 || ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().r(this.lastUpdateTime, this.type))) {
            x.v("MicroMsg.FavoriteAdapter", "least than page count, loadMoreData");
            aMD();
        }
        this.jbD = true;
        x.v("MicroMsg.FavoriteAdapter", "reset data list end");
    }

    public final boolean isEmpty() {
        return this.jbE.isEmpty();
    }

    public final void notifyDataSetChanged() {
        x.v("MicroMsg.FavoriteAdapter", "on notify data set changed requset, can exchange tempList[%B]", new Object[]{Boolean.valueOf(this.jbD)});
        if (this.jbD) {
            if (this.jbQ && this.jbF != null && this.jbE != null && this.jbF.size() == this.jbE.size()) {
                this.jbR = true;
            }
            List list = this.jbE;
            this.jbE = this.jbF;
            this.jbF = list;
            this.jbD = false;
        }
        x.v("MicroMsg.FavoriteAdapter", "on notify data set changed end");
        super.notifyDataSetChanged();
    }

    public final int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        g pQ = getItem(i - 1);
        switch (pQ.field_type) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return pQ.field_type;
            default:
                x.w("MicroMsg.FavoriteAdapter", "get item view type unknown, %d", new Object[]{Integer.valueOf(pQ.field_type)});
                return -2;
        }
    }

    public final int getViewTypeCount() {
        return this.jbN.size() + 3;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (i == 0) {
            View view2 = new View(viewGroup.getContext());
            view2.setLayoutParams(new LayoutParams(0, 0));
            view2.setBackgroundResource(com.tencent.mm.plugin.fav.ui.m.b.fav_listitem_divider_bg);
            view2.setPadding(0, 0, 0, 0);
            view2.setEnabled(false);
            return view2;
        }
        g pQ = getItem(i - 1);
        a aVar = (a) this.jbN.get(pQ.field_type);
        if (aVar == null) {
            x.w("MicroMsg.FavoriteAdapter", "unknown type %d, use unknown item creator", new Object[]{Integer.valueOf(pQ.field_type)});
            aVar = (a) this.jbN.get(-2);
            aMC();
            return aVar.a(view, viewGroup, pQ);
        }
        aVar.jem.hoW = aMF();
        aVar.jem.lastUpdateTime = this.lastUpdateTime;
        aVar.jem.jbI = this.jbI;
        aVar.jem.jbJ = this.jbJ;
        aVar.jem.jeo = this.jbP;
        aVar.jem.jbQ = this.jbQ;
        return aVar.a(view, viewGroup, pQ);
    }

    /* renamed from: pQ */
    public final g getItem(int i) {
        if (i >= 0 && i < this.jbE.size()) {
            return (g) this.jbE.get(i);
        }
        x.e("MicroMsg.FavoriteAdapter", "get item, but position error");
        return new g();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getCount() {
        return this.jbE.size() + 1;
    }

    public final int dD(long j) {
        int i = 0;
        g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(j);
        if (dy == null) {
            return -1;
        }
        if (this.jbJ.size() >= 30) {
            x.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[]{Integer.valueOf(30)});
            com.tencent.mm.ui.base.h.bA(ad.getContext(), ad.getContext().getResources().getString(com.tencent.mm.plugin.fav.ui.m.i.favorite_max_selected_tips, new Object[]{Integer.valueOf(30)}));
            return -1;
        }
        this.jbJ.put(Long.valueOf(j), dy);
        if (dy.field_updateTime < this.lastUpdateTime) {
            this.lastUpdateTime = dy.field_updateTime;
            aME();
            for (g dy2 : this.jbF) {
                if (dy2.field_localId == j) {
                    notifyDataSetChanged();
                    return i;
                }
                i++;
            }
            notifyDataSetChanged();
        } else {
            for (g dy22 : this.jbE) {
                if (dy22.field_localId == j) {
                    notifyDataSetChanged();
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.tencent.mm.plugin.fav.ui.d.a.b bVar = (com.tencent.mm.plugin.fav.ui.d.a.b) view.getTag();
        if (bVar == null) {
            x.w("MicroMsg.FavoriteAdapter", "on item click, holder is null");
        } else if (bVar.iWQ == null) {
            x.w("MicroMsg.FavoriteAdapter", "on item click, info is null");
        } else if (!this.jbI && !this.jbQ) {
            a aVar = (a) this.jbN.get(bVar.iWQ.field_type);
            if (aVar != null) {
                StringBuilder stringBuilder = new StringBuilder();
                g gVar = bVar.iWQ;
                String str = gVar.field_id + "_" + (System.currentTimeMillis() / 1000);
                List<String> list = gVar.field_tagProto.rBX;
                if (!bi.cX(list)) {
                    for (String append : list) {
                        stringBuilder.append(append).append(";");
                    }
                }
                wn wnVar = new wn();
                wnVar.scene = this.scene;
                wnVar.iVT = this.iVT;
                if (this.jbS != null) {
                    wnVar.index = i - this.jbS.getHeaderViewsCount();
                } else {
                    wnVar.index = i;
                }
                wnVar.bWm = this.bWm;
                wnVar.bJK = str;
                wnVar.iVW = stringBuilder.toString();
                aVar.a(view, wnVar);
                x.d("MicroMsg.FavoriteAdapter", "item click type %s", new Object[]{Integer.valueOf(bVar.iWQ.field_type)});
            }
        } else if (bVar.eCo.isChecked() || this.jbJ.size() < 30) {
            bVar.eCo.setChecked(!bVar.eCo.isChecked());
        } else {
            x.w("MicroMsg.FavoriteAdapter", "call select item, match max select count %d", new Object[]{Integer.valueOf(30)});
            com.tencent.mm.ui.base.h.bA(ad.getContext(), ad.getContext().getResources().getString(com.tencent.mm.plugin.fav.ui.m.i.favorite_max_selected_tips, new Object[]{Integer.valueOf(30)}));
        }
    }
}
