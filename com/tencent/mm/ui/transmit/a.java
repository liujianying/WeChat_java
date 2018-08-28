package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.a.i;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class a extends o {
    private int count = 0;
    HashSet<String> eCr;
    ag handler = new ag(Looper.getMainLooper());
    l lUA = new 1(this);
    List<String> uCX;
    List<com.tencent.mm.plugin.fts.a.a.a> uCY;
    List<a> uCZ;

    public a(com.tencent.mm.ui.contact.l lVar, List<String> list, int i) {
        super(lVar, null, true, true, i);
        this.uCX = list;
        this.uCZ = new ArrayList();
        this.eCr = new HashSet();
    }

    public final void finish() {
        super.finish();
        for (com.tencent.mm.plugin.fts.a.a.a cancelSearchTask : this.uCY) {
            ((n) g.n(n.class)).cancelSearchTask(cancelSearchTask);
        }
    }

    protected final com.tencent.mm.ui.contact.a.a iW(int i) {
        com.tencent.mm.ui.contact.a.a aVar = null;
        int size = this.uCZ.size() - 1;
        while (size >= 0) {
            com.tencent.mm.ui.contact.a.a gVar;
            a aVar2 = (a) this.uCZ.get(size);
            if (aVar2.jta == i) {
                gVar = new com.tencent.mm.ui.contact.a.g(i);
                gVar.jyx = this.ujW.getActivity().getString(R.l.select_create_chatroom_query, new Object[]{aVar2.bWm});
            } else if (aVar2.jtc == i) {
                gVar = new i(i);
                gVar.jxE = R.l.fts_header_contact;
                gVar.jxF = aVar2.jtf;
            } else if (i > aVar2.jta) {
                int i2 = (i - aVar2.jta) - 1;
                com.tencent.mm.plugin.fts.a.a.l lVar = (com.tencent.mm.plugin.fts.a.a.l) aVar2.jsx.get(i2);
                if (lVar.jrv.equals("no_result​")) {
                    gVar = new h(i);
                } else {
                    d dVar = new d(i);
                    dVar.fyJ = lVar;
                    dVar.jrx = aVar2.jrx;
                    dVar.djH = true;
                    dVar.jtl = i2 + 1;
                    dVar.cF(dVar.fyJ.type, dVar.fyJ.jru);
                    gVar = dVar;
                }
            } else {
                gVar = aVar;
            }
            if (gVar != null) {
                gVar.bWm = aVar2.bWm;
                gVar.scene = this.scene;
                gVar.ujX = true;
                return gVar;
            }
            size--;
            aVar = gVar;
        }
        return aVar;
    }

    /* renamed from: czZ */
    final void b() {
        int i = 0;
        Iterator it = this.uCZ.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.jsx.size() > 0) {
                    aVar.jta = i2;
                    i2++;
                    if (aVar.jsx.size() > 3) {
                        if (aVar.jtf) {
                            i2 += 3;
                        } else {
                            i2 += aVar.jsx.size();
                        }
                        aVar.jtc = i2;
                        i = i2 + 1;
                    } else {
                        i = aVar.jsx.size() + i2;
                    }
                } else {
                    i = i2;
                }
            } else {
                this.count = i2;
                clearCache();
                notifyDataSetChanged();
                return;
            }
        }
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean FN(int i) {
        return Gj(i);
    }

    private boolean Gj(int i) {
        int headerViewsCount = i - this.ujW.getContentLV().getHeaderViewsCount();
        int size = this.uCZ.size() - 1;
        while (size >= 0) {
            a aVar = (a) this.uCZ.get(size);
            if (aVar.jtc == headerViewsCount) {
                if (aVar.jtf) {
                    size = this.ujW.getContentLV().getSelectedItemPosition();
                    aVar.jtf = false;
                    b();
                    this.ujW.getContentLV().setSelection(size);
                } else {
                    Object obj;
                    aVar.jtf = true;
                    headerViewsCount = 0;
                    while (headerViewsCount < aVar.jsx.size()) {
                        obj = (com.tencent.mm.plugin.fts.a.a.l) aVar.jsx.get(headerViewsCount);
                        if (obj.jrv.equals(aVar.uDc) && headerViewsCount > 2) {
                            break;
                        }
                        headerViewsCount++;
                    }
                    obj = null;
                    headerViewsCount = 0;
                    if (obj != null) {
                        aVar.jsx.remove(headerViewsCount);
                        aVar.jsx.add(0, obj);
                    }
                    b();
                    this.ujW.getContentLV().setSelection(i);
                }
                notifyDataSetChanged();
                return true;
            } else if (headerViewsCount == aVar.jta) {
                return true;
            } else {
                if (i > aVar.jta) {
                    com.tencent.mm.plugin.fts.a.a.l lVar = (com.tencent.mm.plugin.fts.a.a.l) aVar.jsx.get((headerViewsCount - aVar.jta) - 1);
                    if (!lVar.jrv.equals("no_result​")) {
                        MMCreateChatroomUI mMCreateChatroomUI = (MMCreateChatroomUI) this.ujW;
                        if (ai.oW(aVar.uDc)) {
                            if (!this.eCr.contains(lVar.jrv)) {
                                mMCreateChatroomUI.lbw.bm(lVar.jrv, false);
                                aVar.uDc = lVar.jrv;
                                this.eCr.add(aVar.uDc);
                            }
                        } else if (aVar.uDc.equals(lVar.jrv)) {
                            mMCreateChatroomUI.lbw.Tz(aVar.uDc);
                            this.eCr.remove(aVar.uDc);
                            aVar.uDc = null;
                        } else if (!this.eCr.contains(lVar.jrv)) {
                            this.eCr.remove(aVar.uDc);
                            mMCreateChatroomUI.lbw.Tz(aVar.uDc);
                            aVar.uDc = lVar.jrv;
                            mMCreateChatroomUI.lbw.bm(aVar.uDc, false);
                            this.eCr.add(aVar.uDc);
                        }
                        mMCreateChatroomUI.Wp();
                        notifyDataSetChanged();
                        return true;
                    }
                    return true;
                }
                size--;
            }
        }
        return false;
    }

    public final List<String> cAa() {
        Collection hashSet = new HashSet();
        for (a aVar : this.uCZ) {
            if (!ai.oW(aVar.uDc)) {
                hashSet.add(aVar.uDc);
            }
        }
        List<String> arrayList = new ArrayList();
        arrayList.addAll(hashSet);
        return arrayList;
    }
}
