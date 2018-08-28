package com.tencent.mm.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class r<T> extends BaseAdapter implements com.tencent.mm.sdk.e.j.a, b {
    public Context context;
    public int count;
    private ag msM = new ag(Looper.getMainLooper());
    private Cursor tdV = null;
    public T tlE;
    public Map<Integer, T> tlF = null;
    public a tlG;
    private int tlH = 0;
    private int tlI = 0;
    private int tlJ = 0;
    private Runnable tlK = new 1(this);

    public interface a {
        void Xa();

        void Xb();
    }

    public abstract void WS();

    public abstract void WT();

    public abstract T a(T t, Cursor cursor);

    static /* synthetic */ int b(r rVar) {
        int i = rVar.tlJ + 1;
        rVar.tlJ = i;
        return i;
    }

    public r(Context context, T t) {
        this.tlE = t;
        this.context = context;
        this.count = -1;
    }

    public final Cursor getCursor() {
        if (this.tdV == null || this.tdV.isClosed()) {
            WS();
            Assert.assertNotNull(this.tdV);
        }
        return this.tdV;
    }

    public final void setCursor(Cursor cursor) {
        this.tdV = cursor;
        this.count = -1;
    }

    public final void lB(boolean z) {
        if (z) {
            if (this.tlF == null) {
                this.tlF = new HashMap();
            }
        } else if (this.tlF != null) {
            this.tlF.clear();
            this.tlF = null;
        }
    }

    public void aYc() {
        if (this.tlF != null) {
            this.tlF.clear();
        }
        if (this.tdV != null) {
            this.tdV.close();
        }
        this.count = -1;
    }

    public int getCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count + aUZ();
    }

    public final int aFL() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        return this.count;
    }

    public long getItemId(int i) {
        return 0;
    }

    public void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.MListAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public void a(String str, l lVar) {
        cpY();
    }

    private void cpY() {
        x.v("MicroMsg.MListAdapter", "ashutest:: on UI, directly call resetCursor Job");
        if (this.tlG != null) {
            this.tlG.Xa();
        }
        aYc();
        WT();
        if (this.tlG != null) {
            this.tlG.Xb();
        }
    }

    public T getItem(int i) {
        if (qY(i)) {
            return aVa();
        }
        T t;
        if (this.tlF != null) {
            t = this.tlF.get(Integer.valueOf(i));
            if (t != null) {
                return t;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        if (this.tlF == null) {
            return a(this.tlE, getCursor());
        }
        t = a(null, getCursor());
        this.tlF.put(Integer.valueOf(i), t);
        return t;
    }

    public boolean qY(int i) {
        return i >= this.count && i < this.count + aUZ();
    }

    public int aUZ() {
        return 0;
    }

    public T aVa() {
        return this.tlE;
    }
}
