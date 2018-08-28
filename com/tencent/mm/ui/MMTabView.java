package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;

public class MMTabView extends ViewGroup {
    private TextView eCm;
    private int index;
    private int padding;
    private TextView tlf;
    private ImageView tnY;
    public int total;

    public MMTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.total = 3;
        this.padding = 0;
        init();
    }

    public MMTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.total = 3;
        this.padding = 0;
        init();
    }

    private MMTabView(Context context) {
        super(context);
        this.total = 3;
        this.padding = 0;
        init();
    }

    public MMTabView(Context context, int i) {
        this(context);
        this.index = i;
        cqw();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cqw() {
        /*
        r10 = this;
        r9 = 2;
        r8 = 1;
        r1 = 0;
        r0 = "MicroMsg.MMTabView";
        r2 = "jacks build : %d desc, unread: %s";
        r3 = new java.lang.Object[r9];
        r4 = r10.index;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r1] = r4;
        r4 = r10.getUnread();
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.x.d(r0, r2, r3);
        r2 = com.tencent.mm.ui.a.a.a.cqX();
        r0 = r10.getText();
        r3 = r10.getUnread();
        r4 = r10.index;
        r5 = r2.cqW();
        if (r5 == 0) goto L_0x003c;
    L_0x0030:
        if (r10 == 0) goto L_0x003c;
    L_0x0032:
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r5 != 0) goto L_0x003c;
    L_0x0038:
        r5 = r2.rc;
        if (r5 != 0) goto L_0x003d;
    L_0x003c:
        return;
    L_0x003d:
        r5 = new com.tencent.mm.ui.a.b;
        r5.<init>();
        r5.ZU(r0);
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r0 != 0) goto L_0x0091;
    L_0x004b:
        r0 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r3, r0);	 Catch:{ Exception -> 0x0090 }
        if (r0 <= 0) goto L_0x0091;
    L_0x0052:
        if (r0 <= 0) goto L_0x006b;
    L_0x0054:
        r3 = r2.rc;
        r3 = r3.getResources();
        r6 = com.tencent.mm.w.a.i.tab_desc_unread;
        r7 = new java.lang.Object[r8];
        r0 = java.lang.Integer.valueOf(r0);
        r7[r1] = r0;
        r0 = r3.getQuantityString(r6, r8, r7);
        r5.ZU(r0);
    L_0x006b:
        r0 = r2.rc;
        r0 = r0.getResources();
        r2 = com.tencent.mm.w.a.i.tab_name_site_desc;
        r3 = 5;
        r6 = new java.lang.Object[r9];
        r7 = 3;
        r7 = java.lang.Integer.valueOf(r7);
        r6[r1] = r7;
        r1 = r4 + 1;
        r1 = java.lang.Integer.valueOf(r1);
        r6[r8] = r1;
        r0 = r0.getQuantityString(r2, r3, r6);
        r5.ZU(r0);
        r5.dl(r10);
        goto L_0x003c;
    L_0x0090:
        r0 = move-exception;
    L_0x0091:
        r0 = r1;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.MMTabView.cqw():void");
    }

    private void init() {
        int fe;
        this.padding = getResources().getDimensionPixelSize(e.SmallestPadding);
        String chP = w.chP();
        boolean chL = w.chL();
        boolean equalsIgnoreCase = chP.equalsIgnoreCase("en");
        if (chL) {
            fe = (int) (a.fe(getContext()) * ((float) a.fromDPToPix(getContext(), 2)));
        } else {
            fe = 0;
        }
        this.eCm = new TextView(getContext());
        this.eCm.setSingleLine();
        this.eCm.setEllipsize(TruncateAt.END);
        this.eCm.setTextColor(getResources().getColorStateList(d.wechat_green));
        this.eCm.setTextSize(0, (float) a.ad(getContext(), e.HintTextSize));
        this.eCm.setText("");
        if (chL) {
            this.eCm.setTextSize(0, ((float) fe) + this.eCm.getTextSize());
            this.eCm.setTypeface(null, 0);
        } else if (equalsIgnoreCase) {
            this.eCm.setTypeface(null, 1);
        }
        addView(this.eCm);
        this.tnY = new ImageView(getContext());
        this.tnY.setBackgroundResource(f.unread_dot_shape);
        this.tnY.setVisibility(4);
        addView(this.tnY);
        this.tlf = new TextView(getContext());
        this.tlf.setTextColor(getResources().getColor(d.white));
        this.tlf.setTextSize(1, 11.0f);
        this.tlf.setBackgroundResource(r.hd(getContext()));
        this.tlf.setTypeface(Typeface.DEFAULT_BOLD);
        this.tlf.setGravity(17);
        this.tlf.setVisibility(4);
        addView(this.tlf);
        setBackgroundResource(f.list_thicklinecell_bg);
    }

    public void setText(int i) {
        this.eCm.setText(i);
    }

    public void setText(String str) {
        this.eCm.setText(str);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.eCm.setTextColor(colorStateList);
    }

    public String getText() {
        return this.eCm.getText().toString();
    }

    public String getUnread() {
        return this.tlf.getText().toString();
    }

    public void setUnread(String str) {
        if (bi.oW(str)) {
            this.tlf.setVisibility(4);
            return;
        }
        this.tlf.setVisibility(0);
        this.tlf.post(new 1(this, str));
    }

    public final void lF(boolean z) {
        this.tnY.setVisibility(z ? 0 : 4);
    }

    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        this.eCm.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        this.tnY.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        this.tlf.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        setMeasuredDimension(size, size2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = (i5 - this.eCm.getMeasuredWidth()) / 2;
        int measuredWidth2 = this.eCm.getMeasuredWidth() + measuredWidth;
        int measuredHeight = (i6 - this.eCm.getMeasuredHeight()) / 2;
        this.eCm.layout(measuredWidth, measuredHeight, measuredWidth2, this.eCm.getMeasuredHeight() + measuredHeight);
        measuredHeight = this.padding + measuredWidth2;
        int measuredHeight2 = (i6 - this.tnY.getMeasuredHeight()) / 2;
        this.tnY.layout(measuredHeight, measuredHeight2, this.tnY.getMeasuredWidth() + measuredHeight, this.tnY.getMeasuredHeight() + measuredHeight2);
        if (measuredWidth - this.padding < this.tlf.getMeasuredWidth()) {
            i5 -= this.tlf.getMeasuredWidth();
            i6 = (i6 - this.tlf.getMeasuredHeight()) / 2;
            this.tlf.layout(i5, i6, this.tlf.getMeasuredWidth() + i5, this.tlf.getMeasuredHeight() + i6);
            return;
        }
        i5 = this.padding + measuredWidth2;
        i6 = (i6 - this.tlf.getMeasuredHeight()) / 2;
        this.tlf.layout(i5, i6, this.tlf.getMeasuredWidth() + i5, this.tlf.getMeasuredHeight() + i6);
    }
}
