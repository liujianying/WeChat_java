package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class b$a {
    protected boolean adE = false;
    int edl;
    ag handler = new ag();
    private int min;
    private List<bd> tTO;
    int tTP;
    protected int tTQ;
    protected int tTR;
    protected int tTS;
    protected long tTT;
    private b tTU;
    public HashMap<Long, e> tTV = new HashMap();
    public HashMap<Long, e> tTW = new HashMap();
    private String talker;

    static /* synthetic */ void a(b$a b_a) {
        b_a.adE = true;
        b_a.edl = b_a.tTQ;
        b_a.min = b_a.tTR;
        b_a.tTP = b_a.tTS;
        x.i("MicroMsg.AutoList", "totalCount %s min %s start %s", new Object[]{Integer.valueOf(b_a.edl), Integer.valueOf(b_a.min), Integer.valueOf(b_a.tTP)});
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.AutoList", "min spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        currentTimeMillis = System.currentTimeMillis();
        b_a.v(b_a.tTT, true);
        x.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        currentTimeMillis = System.currentTimeMillis();
        b_a.v(b_a.tTT, false);
        x.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        b_a.tTU.notifyDataSetChanged();
        if (!b_a.tTU.tTy.isFinishing()) {
            b bVar = b_a.tTU;
            View view = (View) b_a.tTU.tzb.get(99999);
            MMViewPager mMViewPager = b_a.tTU.tTy.jDB;
            bVar.d(99999, view);
        }
    }

    static /* synthetic */ void a(b$a b_a, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.AutoList", "isBizChat = " + b.qIZ);
        if (b.qIZ) {
            au.HU();
            b_a.tTQ = c.FU().aw(b_a.talker, b.hpD);
        } else {
            au.HU();
            b_a.tTQ = c.FT().GW(b_a.talker);
        }
        x.i("MicroMsg.AutoList", "<init>, totalCount = " + b_a.tTQ);
        x.i("MicroMsg.AutoList", "totalCount spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        long currentTimeMillis2 = System.currentTimeMillis();
        if (b.qIZ) {
            au.HU();
            b_a.tTR = c.FU().v(b_a.talker, b.hpD, j);
        } else {
            au.HU();
            b_a.tTR = c.FT().T(b_a.talker, j);
        }
        x.i("MicroMsg.AutoList", "min spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        if (System.currentTimeMillis() - currentTimeMillis2 > 1000) {
            au.HU();
            String U = c.FT().U(b_a.talker, j);
            x.w("MicroMsg.AutoList", "explain : %s", new Object[]{U});
        }
        b_a.tTS = b_a.tTR;
        b_a.tTT = j;
    }

    public b$a(long j, String str, final b bVar, Boolean bool) {
        this.talker = str;
        this.tTO = new LinkedList();
        this.tTU = bVar;
        au.HU();
        bd dW = c.FT().dW(j);
        if (dW.field_msgId == 0) {
            Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + j + ", stack = " + bi.cjd(), false);
            return;
        }
        this.tTO.add(dW);
        au.Em().H(new 1(this, j, bool, bVar));
        bVar.tTy.tVY = new a() {
            public final void k(Boolean bool) {
                x.i("MicroMsg.AutoList", "isPlaying : " + bool);
                if (!bool.booleanValue()) {
                    b$a.a(b$a.this);
                    if (bVar.tTG != null) {
                        bVar.tTG.iy();
                    }
                }
            }
        };
    }

    private void dI(List<bd> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (b.bg((bd) list.get(i))) {
                arrayList.add(Long.valueOf(((bd) list.get(i)).field_msgSvrId));
                if (((bd) list.get(i)).field_isSend == 1) {
                    arrayList2.add(Long.valueOf(((bd) list.get(i)).field_msgId));
                }
            }
        }
        this.tTV.putAll(o.Pf().a((Long[]) arrayList.toArray(new Long[0])));
        this.tTW.putAll(o.Pf().b((Long[]) arrayList2.toArray(new Long[0])));
    }

    public final int Fw(int i) {
        return (i - 100000) + this.tTP;
    }

    public final bd Fx(int i) {
        int Fw = Fw(i);
        int size = (this.min + this.tTO.size()) - 1;
        if (Fw < this.min || Fw > size) {
            x.e("MicroMsg.AutoList", "get, invalid pos " + Fw + ", min = " + this.min + ", max = " + size);
            return null;
        }
        x.d("MicroMsg.AutoList", "get, pos = " + Fw);
        bd bdVar;
        if (Fw == this.min) {
            bdVar = (bd) this.tTO.get(0);
            if (!this.adE) {
                return bdVar;
            }
            v(bdVar.field_msgId, false);
            return bdVar;
        } else if (Fw != size || size >= this.edl - 1) {
            return (bd) this.tTO.get(Fw - this.min);
        } else {
            bdVar = (bd) this.tTO.get(this.tTO.size() - 1);
            if (!this.adE) {
                return bdVar;
            }
            v(bdVar.field_msgId, true);
            return bdVar;
        }
    }

    public final void cwL() {
        this.adE = false;
    }

    private void v(long j, boolean z) {
        List b;
        x.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + j + ", forward = " + z);
        if (b.qIZ) {
            au.HU();
            b = c.FU().b(this.talker, b.hpD, j, z);
        } else {
            au.HU();
            b = c.FT().d(this.talker, j, z);
        }
        if (b == null || b.size() == 0) {
            x.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = " + z);
            return;
        }
        x.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + b.size() + ", forward = " + z);
        long currentTimeMillis = System.currentTimeMillis();
        dI(b);
        x.i("MicroMsg.AutoList", "loadImgInfo spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (z) {
            this.tTO.addAll(b);
            return;
        }
        this.tTO.addAll(0, b);
        this.min -= b.size();
        if (this.min < 0) {
            x.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.min);
            return;
        }
        x.i("MicroMsg.AutoList", "min from " + (b.size() + this.min) + " to " + this.min);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AutoList, Size = " + this.tTO.size());
        stringBuilder.append("; Content = {");
        for (bd bdVar : this.tTO) {
            stringBuilder.append(bdVar.field_msgId);
            stringBuilder.append(",");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
