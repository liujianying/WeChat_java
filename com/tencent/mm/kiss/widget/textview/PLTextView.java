package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class PLTextView extends StaticTextView {
    private static long dtE = 0;
    private static int dtF = 0;
    private static long dtG = -2147483648L;
    private static long dtH = 0;
    private static int dtI = 0;
    private static long dtJ = -2147483648L;
    private static long dtK = 0;
    private static int dtL = 0;
    private static long dtM = -2147483648L;
    private static boolean dtN = false;

    public PLTextView(Context context) {
        super(context);
    }

    public PLTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PLTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence) {
        long j = 0;
        if (!bi.K(charSequence)) {
            long currentTimeMillis;
            boolean z;
            if (h.DEBUG) {
                currentTimeMillis = System.currentTimeMillis();
            } else {
                currentTimeMillis = 0;
            }
            if (getLayoutWrapper() != null && getLayoutWrapper().due) {
                c.dtC.a(getConfig(), getLayoutWrapper());
            }
            f a = c.dtC.a(getConfig(), charSequence);
            if (a != null) {
                o(charSequence);
                setTextLayout(a);
                z = true;
            } else {
                n(charSequence);
                z = false;
            }
            if (h.DEBUG) {
                j = System.currentTimeMillis();
                x.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", new Object[]{Double.valueOf(((double) (j - currentTimeMillis)) / 1000000.0d), Boolean.valueOf(z), Integer.valueOf(hashCode()), charSequence, Boolean.valueOf(z)});
            }
            if (dtN) {
                currentTimeMillis = j - currentTimeMillis;
                dtE += currentTimeMillis;
                dtF++;
                if (currentTimeMillis > dtG) {
                    dtG = currentTimeMillis;
                }
            }
        } else if (h.DEBUG) {
            x.d("MicroMsg.PLTextView", "set null text");
        }
    }

    public void onMeasure(int i, int i2) {
        long j = 0;
        if (dtN) {
            j = System.currentTimeMillis();
        }
        super.onMeasure(i, i2);
        if (dtN) {
            j = System.currentTimeMillis() - j;
            dtH += j;
            dtI++;
            if (j > dtJ) {
                dtJ = j;
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        long j = 0;
        if (dtN) {
            j = System.currentTimeMillis();
        }
        super.onDraw(canvas);
        if (dtN) {
            j = System.currentTimeMillis() - j;
            dtK += j;
            dtL++;
            if (j > dtM) {
                dtM = j;
            }
        }
    }

    public void n(CharSequence charSequence) {
        super.setText(charSequence, false);
    }

    public void o(CharSequence charSequence) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getLayoutWrapper() != null) {
            getLayoutWrapper().due = false;
        }
    }
}
