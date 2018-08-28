package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public abstract class a {
    public static final int jvw = com.tencent.mm.bp.a.ad(ad.getContext(), c.NormalTextSize);
    public static final TextPaint jvx = new TextPaint();
    public static final int jvy = com.tencent.mm.bp.a.ad(ad.getContext(), c.HintTextSize);
    public static final TextPaint jvz = new TextPaint();
    public String bIY;
    public String bWm;
    public boolean djH;
    public ab guS;
    public final int hER;
    public boolean hoR;
    public g jrx;
    public int jtl;
    public int jtq;
    public int jtr;
    public final int position;
    public int scene;
    public boolean ujX;
    public boolean ujY;
    public boolean umn;
    boolean umo;
    public boolean ump;

    public abstract b Wg();

    public abstract a Wh();

    public abstract void ck(Context context);

    static {
        jvx.setTextSize((float) jvw);
        jvz.setTextSize((float) jvy);
    }

    public a(int i, int i2) {
        this.hER = i;
        this.position = i2;
        x.i("MicroMsg.BaseContactDataItem", "Create BaseContactDataItem viewType=%d | position=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void cF(int i, int i2) {
        this.jtq = i;
        this.jtr = i2;
    }

    public boolean aQi() {
        return false;
    }
}
