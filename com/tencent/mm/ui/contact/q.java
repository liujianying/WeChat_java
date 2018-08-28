package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class q extends m {
    private String bWm;
    private int count = 0;
    private ag handler = new ag(Looper.getMainLooper());
    private g jrx;
    private a jsw;
    private List<l> juW = null;
    private List<l> laD = null;
    private int uhP = Integer.MAX_VALUE;
    private int uhQ = Integer.MAX_VALUE;
    protected com.tencent.mm.plugin.fts.a.l ukA = new 2(this);
    private List<String> uko;
    private int ukp = Integer.MAX_VALUE;
    private int ukq = Integer.MAX_VALUE;
    private int ukr = Integer.MAX_VALUE;
    private boolean uks = true;
    private int ukt = Integer.MAX_VALUE;
    private boolean uku = true;
    private int ukv = Integer.MAX_VALUE;
    private List<l> ukw = null;
    private List<l> ukx = null;
    private List<Integer> uky;
    private com.tencent.mm.plugin.fts.a.l ukz = new com.tencent.mm.plugin.fts.a.l() {
        public final void b(j jVar) {
            switch (jVar.bjW) {
                case -3:
                case -2:
                case -1:
                    if (jVar.joH.bWm.equals(q.this.bWm)) {
                        q.c(q.this);
                        return;
                    }
                    return;
                case 0:
                    if (q.this.jsw != null && q.this.jsw.equals(q.this.jsw)) {
                        q.this.cyy();
                        q.this.jrx = jVar.jrx;
                        q.a(q.this, jVar.jsx);
                        q.this.ukw = jVar.jsx;
                        d.bj(jVar.jsx);
                        q.this.h(jVar.joH.bWm, q.c(q.this), true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    public q(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, int i) {
        super(mMBaseSelectContactUI, z, i);
        this.uko = list;
        this.uky = new ArrayList();
        x.i("MicroMsg.MMSearchContactAdapter", "Create!");
        Wj();
    }

    public void bA(String str, boolean z) {
        if (this.ujV != null) {
            this.ujV.q(str, getCount(), z);
        }
    }

    public void a(String str, int[] iArr, boolean z) {
        clearTask();
        this.bWm = str;
        this.uky.clear();
        for (int valueOf : iArr) {
            this.uky.add(Integer.valueOf(valueOf));
        }
        HashSet hashSet = new HashSet();
        if (!z) {
            hashSet.add("filehelper");
        }
        x.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", new Object[]{this.bWm});
        i iVar = new i();
        iVar.bWm = str;
        iVar.jsq = iArr;
        iVar.jss = 3;
        iVar.jsv = this.ukz;
        iVar.handler = this.handler;
        iVar.scene = 1;
        iVar.jst = hashSet;
        this.jsw = ((n) com.tencent.mm.kernel.g.n(n.class)).search(1, iVar);
    }

    private void clearTask() {
        if (this.jsw != null) {
            ((n) com.tencent.mm.kernel.g.n(n.class)).cancelSearchTask(this.jsw);
            this.jsw = null;
        }
    }

    private void cyy() {
        this.ukq = Integer.MAX_VALUE;
        this.ukr = Integer.MAX_VALUE;
        this.uks = true;
        this.ukt = Integer.MAX_VALUE;
        this.uhP = Integer.MAX_VALUE;
        this.uku = true;
        this.ukv = Integer.MAX_VALUE;
        this.uhQ = Integer.MAX_VALUE;
        this.ukw = null;
        this.laD = null;
        this.juW = null;
        this.ukx = null;
        this.jrx = null;
        clearCache();
        notifyDataSetChanged();
    }

    private void Wj() {
        x.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.bWm = null;
        cyy();
        clearTask();
        clearCache();
    }

    public final void acV() {
        Wj();
    }

    private void h(String str, boolean z, boolean z2) {
        int dS = dS(this.ukw);
        int dS2 = dS(this.laD);
        int dS3 = dS(this.juW);
        int dS4 = dS(this.ukx);
        if (dS > 0) {
            this.ukq = 0;
            dS = (dS + 1) + 0;
        } else {
            this.ukq = Integer.MAX_VALUE;
            dS = 0;
        }
        if (dS2 > 0) {
            this.ukr = dS;
            if (dS2 <= 3 || (dS3 <= 0 && dS4 <= 0)) {
                this.ukt = Integer.MAX_VALUE;
                dS += dS2 + 1;
            } else if (this.uks) {
                dS += 4;
                this.ukt = dS;
                dS++;
            } else {
                dS += dS2 + 1;
                this.ukt = dS;
                dS++;
            }
        } else {
            this.ukr = Integer.MAX_VALUE;
        }
        if (this.jrx.jrX.length <= 1 || bwq()) {
            this.ukp = Integer.MAX_VALUE;
        } else {
            this.ukp = dS;
            dS++;
        }
        if (dS3 > 0) {
            this.uhP = dS;
            if (dS3 <= 3 || dS4 <= 0) {
                this.ukv = Integer.MAX_VALUE;
                dS += dS3 + 1;
            } else if (this.uku) {
                dS += 4;
                this.ukv = dS;
                dS++;
            } else {
                dS += dS3 + 1;
                this.ukv = dS;
                dS++;
            }
        } else {
            this.uhP = Integer.MAX_VALUE;
        }
        if (dS4 > 0) {
            this.uhQ = dS;
            dS += dS4 + 1;
        } else {
            this.uhQ = Integer.MAX_VALUE;
        }
        x.i("MicroMsg.MMSearchContactAdapter", "setCount %d", new Object[]{Integer.valueOf(dS)});
        this.count = dS;
        if (z2) {
            bA(str, z);
        }
        clearCache();
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.count;
    }

    private static int dS(List<? extends Object> list) {
        return list == null ? 0 : list.size();
    }

    public com.tencent.mm.ui.contact.a.a iW(int i) {
        com.tencent.mm.ui.contact.a.a fVar;
        int i2;
        com.tencent.mm.ui.contact.a.d dVar;
        c cVar;
        if (i == this.ukp) {
            fVar = new f(i);
            fVar.djH = true;
        } else if (i == this.ukq) {
            fVar = fa(h.fts_header_top_hits, i);
        } else if (i == this.ukr) {
            fVar = fa(h.fts_header_contact, i);
        } else if (i == this.uhP) {
            fVar = fa(h.fts_header_chatroom, i);
        } else if (i == this.uhQ) {
            fVar = fa(h.fts_header_biz, i);
        } else if (i == this.ukt) {
            fVar = u(h.fts_header_contact, i, this.uks);
        } else if (i == this.ukv) {
            fVar = u(h.fts_header_chatroom, i, this.uku);
        } else if (i > this.uhQ) {
            i2 = (i - this.uhQ) - 1;
            dVar = new com.tencent.mm.ui.contact.a.d(i);
            dVar.fyJ = (l) this.ukx.get(i2);
            dVar.ujX = bwq();
            dVar.djH = true;
            dVar.jtl = i2 + 1;
            dVar.cF(dVar.fyJ.type, dVar.fyJ.jru);
            fVar = dVar;
        } else if (i > this.uhP) {
            i2 = (i - this.uhP) - 1;
            cVar = new c(i);
            cVar.fyJ = (l) this.juW.get(i2);
            cVar.ujX = bwq();
            cVar.djH = true;
            cVar.jtl = i2 + 1;
            cVar.cF(cVar.fyJ.type, cVar.fyJ.jru);
            fVar = cVar;
        } else if (i > this.ukr) {
            i2 = (i - this.ukr) - 1;
            dVar = new com.tencent.mm.ui.contact.a.d(i);
            dVar.fyJ = (l) this.laD.get(i2);
            dVar.ujX = bwq();
            dVar.djH = true;
            dVar.jtl = i2 + 1;
            dVar.cF(dVar.fyJ.type, dVar.fyJ.jru);
            fVar = dVar;
        } else if (i > this.ukq) {
            i2 = (i - this.ukq) - 1;
            l lVar = (l) this.ukw.get(i2);
            if (lVar.type == 131072 || lVar.type == 131076) {
                dVar = new com.tencent.mm.ui.contact.a.d(i);
                dVar.fyJ = lVar;
                dVar.ujX = bwq();
                dVar.ump = true;
                dVar.djH = true;
                dVar.jtl = i2 + 1;
                dVar.cF(dVar.fyJ.type, dVar.fyJ.jru);
                fVar = dVar;
            } else if (lVar.type == 131075) {
                cVar = new c(i);
                cVar.fyJ = lVar;
                cVar.ujX = bwq();
                cVar.ump = true;
                cVar.djH = true;
                cVar.jtl = i2 + 1;
                cVar.cF(cVar.fyJ.type, cVar.fyJ.jru);
                fVar = cVar;
            } else {
                x.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", new Object[]{Integer.valueOf(lVar.type)});
                fVar = null;
            }
        } else {
            x.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", new Object[]{Integer.valueOf(i)});
            fVar = null;
        }
        if (fVar != null) {
            fVar.bWm = this.bWm;
            fVar.jrx = this.jrx;
            fVar.scene = this.scene;
        }
        return fVar;
    }

    private static com.tencent.mm.ui.contact.a.a u(int i, int i2, boolean z) {
        com.tencent.mm.ui.contact.a.i iVar = new com.tencent.mm.ui.contact.a.i(i2);
        iVar.jxE = i;
        iVar.jxF = z;
        return iVar;
    }

    private com.tencent.mm.ui.contact.a.a fa(int i, int i2) {
        com.tencent.mm.ui.contact.a.g gVar = new com.tencent.mm.ui.contact.a.g(i2);
        gVar.jyx = this.ujW.getActivity().getResources().getString(i);
        return gVar;
    }

    public void finish() {
        super.finish();
        x.i("MicroMsg.MMSearchContactAdapter", "finish!");
        Wj();
    }

    protected boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        int i = aVar.position + 1;
        int[] iArr = new int[]{this.ukq, this.ukr, this.uhP, this.uhQ};
        for (int i2 = 0; i2 < 4; i2++) {
            if (i == iArr[i2]) {
                return true;
            }
        }
        return false;
    }

    public final boolean FN(int i) {
        int headerViewsCount = i - this.ujW.getContentLV().getHeaderViewsCount();
        if (headerViewsCount == this.ukt) {
            if (this.uks) {
                headerViewsCount = this.ujW.getContentLV().getSelectedItemPosition();
                this.uks = false;
                h(this.bWm, true, false);
                this.ujW.getContentLV().setSelection(headerViewsCount);
                return true;
            }
            this.uks = true;
            h(this.bWm, true, false);
            this.ujW.getContentLV().setSelection(this.ukt);
            return true;
        } else if (headerViewsCount != this.ukv) {
            com.tencent.mm.ui.contact.a.a FM = FM(headerViewsCount);
            if (!(FM == null || !FM.djH || this.ukp == Integer.MAX_VALUE)) {
                if (FM.position == this.ukp) {
                    x.FO(1);
                    return false;
                }
                x.FO(0);
            }
            return false;
        } else if (this.uku) {
            headerViewsCount = this.ujW.getContentLV().getSelectedItemPosition();
            this.uku = false;
            h(this.bWm, true, false);
            this.ujW.getContentLV().setSelection(headerViewsCount);
            return true;
        } else {
            this.uku = true;
            h(this.bWm, true, false);
            this.ujW.getContentLV().setSelection(this.ukv);
            return true;
        }
    }
}
