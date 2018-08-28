package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.ScaleAnimation;
import android.widget.ListView;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.a.d;
import com.tencent.mm.plugin.sns.ui.a.e;
import com.tencent.mm.plugin.sns.ui.a.f;
import com.tencent.mm.plugin.sns.ui.a.g;
import com.tencent.mm.plugin.sns.ui.a.h;
import com.tencent.mm.plugin.sns.ui.a.i;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.b.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class av implements y {
    public MMActivity bGc;
    public k contextMenuHelper;
    private ListView eZb;
    c fIu;
    protected ag handler = new ag();
    public a hql;
    protected HashMap<String, Integer> nMs = new HashMap();
    public OnTouchListener nNj;
    protected ScaleAnimation nTV;
    protected ScaleAnimation nTW;
    boolean nTx = false;
    c nUA = new c<qo>() {
        {
            this.sFo = qo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qo qoVar = (qo) bVar;
            if (qoVar instanceof qo) {
                if (qoVar.cbe.type == 1) {
                    av.a(av.this, qoVar.cbe.id);
                } else if (qoVar.cbe.type == 2) {
                    av.b(av.this, qoVar.cbe.id);
                }
            }
            return false;
        }
    };
    c nUB = new 3(this);
    public ar nUc;
    private int nUf = 0;
    public k nUh;
    public bg nUk;
    c nUz = new 2(this);
    public com.tencent.mm.plugin.sns.ui.b.b ntw;
    protected x obU;
    public j obV;
    protected LinkedList<SnsCommentPreloadTextView> obW = new LinkedList();
    public HashMap<Integer, WeakReference<View>> obX = new HashMap();
    View obY;
    public int obZ = -1;
    int oca = 0;
    protected HashMap<Integer, View> ocb = new HashMap();
    public HashMap<String, String> occ = new HashMap();
    private HashMap<Integer, com.tencent.mm.plugin.sns.ui.a.a> ocd = new HashMap();
    private HashMap<Integer, com.tencent.mm.plugin.sns.ui.a.a.c> oce;
    public OnClickListener ocf;
    public OnClickListener ocg;
    public HashMap<String, Boolean> och;
    private c oci;
    protected int requestType = 0;

    static /* synthetic */ void b(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateStart, id: %s", new Object[]{str});
        ap.cb(str, 2);
        avVar.notifyDataSetChanged();
    }

    static /* synthetic */ void c(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateFinish, id: %s", new Object[]{str});
        ap.cb(str, 2);
        avVar.notifyDataSetChanged();
    }

    static /* synthetic */ void d(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateFinish, id: %s", new Object[]{str});
        ap.cb(str, 2);
        avVar.notifyDataSetChanged();
    }

    static /* synthetic */ void e(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslatePostDesc, id: %s", new Object[]{str});
        ap.cc(str, 2);
        avVar.notifyDataSetChanged();
    }

    static /* synthetic */ void f(av avVar, String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslateComment, id: %s", new Object[]{str});
        ap.cc(str, 2);
        avVar.notifyDataSetChanged();
    }

    public final void bDO() {
        this.nMs.clear();
    }

    public final u bDP() {
        if (this.bGc instanceof u) {
            return (u) this.bGc;
        }
        return null;
    }

    public final SnsCommentPreloadTextView bDQ() {
        if (this.obW.size() == 0) {
            return new SnsCommentPreloadTextView(this.bGc);
        }
        return (SnsCommentPreloadTextView) this.obW.removeFirst();
    }

    public final void a(SnsCommentPreloadTextView snsCommentPreloadTextView) {
        this.obW.add(snsCommentPreloadTextView);
    }

    public final boolean bDR() {
        if (this.obW != null) {
            this.obW.clear();
        }
        if (this.oce != null) {
            this.oce.clear();
        }
        if (this.ocd != null) {
            this.ocd.clear();
        }
        j.clearCache();
        com.tencent.mm.kiss.widget.textview.c.dtC.EZ();
        return true;
    }

    private static com.tencent.mm.plugin.sns.ui.a.a xz(int i) {
        switch (i) {
            case 0:
                return new d();
            case 1:
                return new e();
            case 2:
                return new f();
            case 3:
                return new f();
            case 4:
                return new f();
            case 5:
                return new f();
            case 6:
                return new g();
            case 7:
                return new e();
            case 8:
                return new e();
            case 9:
                return new i();
            case 10:
                return new e();
            case 11:
                return new com.tencent.mm.plugin.sns.ui.a.c();
            case 12:
                return new h();
            case 13:
                return new com.tencent.mm.plugin.sns.ui.a.b();
            default:
                return new e();
        }
    }

    public final void notifyDataSetChanged() {
        this.obU.notifyDataSetChanged();
    }

    public final void bDS() {
        this.obU.bCb();
    }

    public av(MMActivity mMActivity, ListView listView, com.tencent.mm.plugin.sns.ui.b.b bVar, j jVar, x xVar) {
        this.ocd.put(Integer.valueOf(6), new g());
        this.ocd.put(Integer.valueOf(2), new f());
        this.ocd.put(Integer.valueOf(3), new f());
        this.ocd.put(Integer.valueOf(4), new f());
        this.ocd.put(Integer.valueOf(5), new f());
        this.ocd.put(Integer.valueOf(0), new d());
        this.ocd.put(Integer.valueOf(1), new e());
        this.ocd.put(Integer.valueOf(7), new e());
        this.ocd.put(Integer.valueOf(8), new e());
        this.ocd.put(Integer.valueOf(9), new i());
        this.ocd.put(Integer.valueOf(11), new com.tencent.mm.plugin.sns.ui.a.c());
        this.ocd.put(Integer.valueOf(10), new e());
        this.oce = new HashMap();
        this.oce.put(Integer.valueOf(6), new g.a());
        this.oce.put(Integer.valueOf(2), new f.a());
        this.oce.put(Integer.valueOf(3), new f.a());
        this.oce.put(Integer.valueOf(4), new f.a());
        this.oce.put(Integer.valueOf(5), new f.a());
        this.oce.put(Integer.valueOf(0), new f.a());
        this.oce.put(Integer.valueOf(1), new f.a());
        this.oce.put(Integer.valueOf(7), new f.a());
        this.oce.put(Integer.valueOf(8), new f.a());
        this.oce.put(Integer.valueOf(9), new f.a());
        this.oce.put(Integer.valueOf(10), new f.a());
        this.oce.put(Integer.valueOf(12), new com.tencent.mm.plugin.sns.ui.a.a.c());
        this.ocf = new 4(this);
        this.ocg = new 5(this);
        this.nNj = bi.cjb();
        this.och = new HashMap();
        this.oci = new c();
        this.fIu = new 9(this);
        this.obU = xVar;
        this.obV = jVar;
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
        this.eZb = listView;
        af.byl();
        this.bGc = mMActivity;
        this.ntw = bVar;
        this.contextMenuHelper = new k(mMActivity);
        this.hql = new a(mMActivity);
        this.nUc = new ar(mMActivity, (byte) 0);
        this.nTV = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.nTV.setDuration(150);
        this.nTW = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.nTW.setDuration(150);
        this.nUh = new k(mMActivity, 0, jVar.nLK);
        this.requestType = 10;
        this.nUk = new bg(mMActivity, new 6(this, xVar), 0, jVar.nLK);
        com.tencent.mm.sdk.b.a.sFg.b(this.fIu);
    }

    public final void bDT() {
        int firstVisiblePosition = this.eZb.getFirstVisiblePosition() - this.eZb.getHeaderViewsCount();
        int lastVisiblePosition = this.eZb.getLastVisiblePosition() - this.eZb.getHeaderViewsCount();
        x.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + firstVisiblePosition + " " + lastVisiblePosition);
        int count = this.obU.getCount();
        int i = firstVisiblePosition;
        while (i <= lastVisiblePosition && i < count) {
            n xi = xi(i);
            View view = (View) this.ocb.get(Integer.valueOf(i));
            if (view == null || xi == null || view.getTag() == null) {
                x.e("MicroMsg.SnsTimeLineBaseAdapter", " passe " + i);
            } else {
                com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                x.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + cVar.position);
                cVar.ojP.a(cVar, i, xi);
            }
            i++;
        }
    }

    public final View h(int i, View view) {
        com.tencent.mm.plugin.sns.ui.a.a.c cVar;
        com.tencent.mm.plugin.sns.ui.a.a aVar;
        n xi = this.obU.xi(i);
        bsu bAJ = xi.bAJ();
        int a = a(bAJ, true);
        com.tencent.mm.plugin.sns.ui.a.a xz;
        f.a aVar2;
        if (view == null) {
            xz = xz(a);
            aVar2 = new f.a();
            aVar2.ojP = xz;
            aVar2.ojM = bAJ;
            view = xz.a(this.bGc, aVar2, a, this, xi);
            view.setTag(com.tencent.mm.plugin.sns.i.f.sns_item_root, Integer.valueOf(a));
            cVar = aVar2;
            aVar = xz;
        } else {
            Object tag = view.getTag(com.tencent.mm.plugin.sns.i.f.sns_item_root);
            if ((tag instanceof Integer ? ((Integer) tag).intValue() : -1) == a) {
                com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
                aVar = cVar2.ojP;
                cVar = cVar2;
            } else {
                xz = xz(a);
                aVar2 = new f.a();
                aVar2.ojP = xz;
                aVar2.ojM = bAJ;
                view = xz.a(this.bGc, aVar2, a, this, xi);
                view.setTag(com.tencent.mm.plugin.sns.i.f.sns_item_root, Integer.valueOf(a));
                cVar = aVar2;
                aVar = xz;
            }
        }
        aVar.setIsFromMainTimeline(this.nTx);
        String bAK = xi.bAK();
        ArrayList arrayList = new ArrayList();
        if (ap.byQ().size() > 0) {
            for (String str : ap.byQ().keySet()) {
                if (str.startsWith(bAK)) {
                    ap.b bVar = (ap.b) ap.byQ().get(str);
                    if (ap.c(bVar)) {
                        arrayList.add(bVar);
                    }
                }
            }
        }
        aVar.oiD = arrayList;
        aVar.a(cVar, i, xi, bAJ, a, this);
        if (ap.cd(xi.bAK(), 2)) {
            ap.b Mq = ap.Mq(xi.bAK());
            if (xi.field_snsId == 0) {
                Mq = new ap.b();
            }
            if (Mq.dDR) {
                if (Mq.dHC) {
                    com.tencent.mm.plugin.sns.ui.a.a.d(cVar);
                    ap.cc(Mq.id, 2);
                } else {
                    String str2 = Mq.result;
                    String str3 = Mq.dMB;
                    if (!(cVar == null || cVar.oiN == null)) {
                        cVar.oiN.a(Mq, 1, str2, str3, Mq.nrH);
                        cVar.oiN.setVisibility(0);
                    }
                }
            } else if (!(cVar == null || cVar.oiN == null)) {
                cVar.oiN.xD(1);
                cVar.oiN.setVisibility(0);
            }
        } else {
            com.tencent.mm.plugin.sns.ui.a.a.d(cVar);
        }
        this.ocb.put(Integer.valueOf(i), view);
        return view;
    }

    public final int getItemViewType(int i) {
        return a(this.obU.xi(i).bAJ(), true);
    }

    public final x bDU() {
        return this.obU;
    }

    protected static int a(bsu bsu, boolean z) {
        if (bsu.sqc.ruz != 1) {
            switch (bsu.sqc.ruz) {
                case 1:
                case 8:
                    return 3;
                case 2:
                    return 6;
                case 4:
                    return 0;
                case 5:
                    return 1;
                case 7:
                    return 2;
                case 14:
                    return 7;
                case 15:
                    if (z && bsu.sqj == 1) {
                        return 13;
                    }
                    return 9;
                case 21:
                    return 11;
                case 27:
                    return 12;
                default:
                    return 1;
            }
        } else if (z && bsu.csE == 1) {
            return 13;
        } else {
            int size = bsu.sqc.ruA.size();
            if (size <= 1) {
                return 2;
            }
            if (size <= 3) {
                return 3;
            }
            if (size <= 6) {
                return 4;
            }
            return 5;
        }
    }

    protected static int d(bsu bsu) {
        return a(bsu, true);
    }

    public static String Oa(String str) {
        if (bi.oW(str)) {
            return str;
        }
        int indexOf = str.indexOf("://");
        if (indexOf != -1) {
            str = str.substring(indexOf + 3);
        }
        indexOf = str.indexOf("/");
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    protected static String e(bsu bsu) {
        return com.tencent.mm.plugin.sns.c.a.ezo.B(bsu.sqc.jPK, "timeline");
    }

    public static String a(bsu bsu, Context context) {
        return com.tencent.mm.plugin.sns.c.a.ezo.h(context, bsu.sqb.ksA, "timeline");
    }

    public static String Ob(String str) {
        x.d("MicroMsg.SnsTimeLineBaseAdapter", "url:" + str);
        return com.tencent.mm.plugin.sns.c.a.ezo.B(str, "timeline");
    }

    public final void G(Runnable runnable) {
        this.obU.bCb();
        runnable.run();
    }

    public final void cL(View view) {
        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
            x.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
            if (this.obY != null && this.obY.getVisibility() == 0) {
                this.obY.startAnimation(this.nTW);
                this.nTW.setAnimationListener(new 8(this));
            }
        }
    }

    public final n xi(int i) {
        return this.obU.xi(i);
    }

    public final int getCount() {
        return this.obU.getCount();
    }

    public final boolean xj(int i) {
        if (i < this.eZb.getFirstVisiblePosition() - 1 || i > this.eZb.getLastVisiblePosition() - 1) {
            return false;
        }
        return true;
    }
}
