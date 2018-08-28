package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a {
    public final int hER;
    public String info;
    public g jrx;
    public int jsZ;
    public boolean jti;
    public boolean jtj = true;
    public int jtk;
    public int jtl;
    public int jtm;
    public String jtn;
    public long jto;
    public boolean jtp;
    public int jtq;
    public int jtr;
    public boolean jts;
    public int pageType;
    public final int position;

    public abstract b BV();

    public abstract void a(Context context, a aVar, Object... objArr);

    public abstract a afD();

    public a(int i, int i2) {
        this.hER = i;
        this.position = i2;
        x.v("MicroMsg.FTS.FTSDataItem", "create data item | viewType=%d | position=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void cF(int i, int i2) {
        this.jtq = i;
        this.jtr = i2;
        this.jts = true;
    }

    public int afF() {
        return 0;
    }

    public String afE() {
        return "";
    }

    public int aQh() {
        return 0;
    }

    public boolean aQi() {
        return false;
    }

    public int aQj() {
        return 0;
    }
}
