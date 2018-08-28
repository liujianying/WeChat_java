package com.tencent.mm.plugin.fts.ui;

import android.text.TextPaint;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.fts.ui.n.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class b$c {
    public static final int jvA = a.ad(ad.getContext(), b.SmallerTextSize);
    public static final TextPaint jvB = new TextPaint();
    public static final int jvu = a.ad(ad.getContext(), b.BigTextSize);
    public static final TextPaint jvv = new TextPaint();
    public static final int jvw = a.ad(ad.getContext(), b.NormalTextSize);
    public static final TextPaint jvx = new TextPaint();
    public static final int jvy = a.ad(ad.getContext(), b.HintTextSize);
    public static final TextPaint jvz = new TextPaint();

    static {
        jvv.setTextSize((float) jvu);
        jvx.setTextSize((float) jvw);
        jvz.setTextSize((float) jvy);
        jvB.setTextSize((float) jvA);
    }
}
