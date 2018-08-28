package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.d;
import android.support.v4.view.ViewPager.e;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.lang.ref.WeakReference;

public class PagerTitleStrip extends ViewGroup implements android.support.v4.view.ViewPager.a {
    private static final int[] vA = new int[]{16842804, 16842901, 16842904, 16842927};
    private static final int[] vB = new int[]{16843660};
    private static final b vE;
    private int rA;
    private int vC;
    int vD;
    ViewPager vp;
    TextView vq;
    TextView vr;
    TextView vs;
    private int vt = -1;
    private float vu = -1.0f;
    private int vv;
    private boolean vw;
    private boolean vx;
    private final a vy = new a(this, (byte) 0);
    private WeakReference<u> vz;

    private class a extends DataSetObserver implements d, e {
        private int if;

        private a() {
        }

        /* synthetic */ a(PagerTitleStrip pagerTitleStrip, byte b) {
            this();
        }

        public final void a(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.a(i, f, false);
        }

        public final void O(int i) {
            float f = 0.0f;
            if (this.if == 0) {
                PagerTitleStrip.this.a(PagerTitleStrip.this.vp.getCurrentItem(), PagerTitleStrip.this.vp.getAdapter());
                if (PagerTitleStrip.this.vu >= 0.0f) {
                    f = PagerTitleStrip.this.vu;
                }
                PagerTitleStrip.this.a(PagerTitleStrip.this.vp.getCurrentItem(), f, true);
            }
        }

        public final void N(int i) {
            this.if = i;
        }

        public final void b(u uVar, u uVar2) {
            PagerTitleStrip.this.a(uVar, uVar2);
        }

        public final void onChanged() {
            float f = 0.0f;
            PagerTitleStrip.this.a(PagerTitleStrip.this.vp.getCurrentItem(), PagerTitleStrip.this.vp.getAdapter());
            if (PagerTitleStrip.this.vu >= 0.0f) {
                f = PagerTitleStrip.this.vu;
            }
            PagerTitleStrip.this.a(PagerTitleStrip.this.vp.getCurrentItem(), f, true);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            vE = new d();
        } else {
            vE = new c();
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        vE.setSingleLineAllCaps(textView);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        View textView = new TextView(context);
        this.vq = textView;
        addView(textView);
        textView = new TextView(context);
        this.vr = textView;
        addView(textView);
        textView = new TextView(context);
        this.vs = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vA);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.vq.setTextAppearance(context, resourceId);
            this.vr.setTextAppearance(context, resourceId);
            this.vs.setTextAppearance(context, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f = (float) dimensionPixelSize;
            this.vq.setTextSize(0, f);
            this.vr.setTextSize(0, f);
            this.vs.setTextSize(0, f);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.vq.setTextColor(dimensionPixelSize);
            this.vr.setTextColor(dimensionPixelSize);
            this.vs.setTextColor(dimensionPixelSize);
        }
        this.rA = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.vD = this.vr.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.vq.setEllipsize(TruncateAt.END);
        this.vr.setEllipsize(TruncateAt.END);
        this.vs.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, vB);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.vq);
            setSingleLineAllCaps(this.vr);
            setSingleLineAllCaps(this.vs);
        } else {
            this.vq.setSingleLine();
            this.vr.setSingleLine();
            this.vs.setSingleLine();
        }
        this.vv = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.vv = i;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.vv;
    }

    public void setNonPrimaryAlpha(float f) {
        this.vC = ((int) (255.0f * f)) & 255;
        int i = (this.vC << 24) | (this.vD & 16777215);
        this.vq.setTextColor(i);
        this.vs.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.vD = i;
        this.vr.setTextColor(i);
        int i2 = (this.vC << 24) | (this.vD & 16777215);
        this.vq.setTextColor(i2);
        this.vs.setTextColor(i2);
    }

    public void setGravity(int i) {
        this.rA = i;
        requestLayout();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            u adapter = viewPager.getAdapter();
            viewPager.b(this.vy);
            viewPager.setOnAdapterChangeListener(this.vy);
            this.vp = viewPager;
            a(this.vz != null ? (u) this.vz.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.vp != null) {
            a(this.vp.getAdapter(), null);
            this.vp.b(null);
            this.vp.setOnAdapterChangeListener(null);
            this.vp = null;
        }
    }

    final void a(int i, u uVar) {
        CharSequence charSequence;
        CharSequence charSequence2 = null;
        int count = uVar != null ? uVar.getCount() : 0;
        this.vw = true;
        if (i <= 0 || uVar == null) {
            charSequence = null;
        } else {
            charSequence = uVar.cb();
        }
        this.vq.setText(charSequence);
        TextView textView = this.vr;
        if (uVar == null || i >= count) {
            charSequence = null;
        } else {
            charSequence = uVar.cb();
        }
        textView.setText(charSequence);
        if (i + 1 < count && uVar != null) {
            charSequence2 = uVar.cb();
        }
        this.vs.setText(charSequence2);
        count = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.vq.measure(count, makeMeasureSpec);
        this.vr.measure(count, makeMeasureSpec);
        this.vs.measure(count, makeMeasureSpec);
        this.vt = i;
        if (!this.vx) {
            a(i, this.vu, false);
        }
        this.vw = false;
    }

    public void requestLayout() {
        if (!this.vw) {
            super.requestLayout();
        }
    }

    final void a(u uVar, u uVar2) {
        if (uVar != null) {
            uVar.unregisterDataSetObserver(this.vy);
            this.vz = null;
        }
        if (uVar2 != null) {
            uVar2.registerDataSetObserver(this.vy);
            this.vz = new WeakReference(uVar2);
        }
        if (this.vp != null) {
            this.vt = -1;
            this.vu = -1.0f;
            a(this.vp.getCurrentItem(), uVar2);
            requestLayout();
        }
    }

    void a(int i, float f, boolean z) {
        if (i != this.vt) {
            a(i, this.vp.getAdapter());
        } else if (!z && f == this.vu) {
            return;
        }
        this.vx = true;
        int measuredWidth = this.vq.getMeasuredWidth();
        int measuredWidth2 = this.vr.getMeasuredWidth();
        int measuredWidth3 = this.vs.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        i3 = ((width - i3) - ((int) (f2 * ((float) i4)))) - i2;
        i4 = i3 + measuredWidth2;
        int baseline = this.vq.getBaseline();
        measuredWidth2 = this.vr.getBaseline();
        i2 = this.vs.getBaseline();
        int max = Math.max(Math.max(baseline, measuredWidth2), i2);
        baseline = max - baseline;
        measuredWidth2 = max - measuredWidth2;
        max -= i2;
        int measuredHeight = this.vs.getMeasuredHeight() + max;
        i2 = Math.max(Math.max(this.vq.getMeasuredHeight() + baseline, this.vr.getMeasuredHeight() + measuredWidth2), measuredHeight);
        switch (this.rA & TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW) {
            case 16:
                height = (((height - paddingTop) - paddingBottom) - i2) / 2;
                i2 = height + baseline;
                baseline = height + measuredWidth2;
                measuredWidth2 = height + max;
                break;
            case 80:
                height = (height - paddingBottom) - i2;
                i2 = height + baseline;
                baseline = height + measuredWidth2;
                measuredWidth2 = height + max;
                break;
            default:
                i2 = paddingTop + baseline;
                baseline = paddingTop + measuredWidth2;
                measuredWidth2 = paddingTop + max;
                break;
        }
        this.vr.layout(i3, baseline, i4, this.vr.getMeasuredHeight() + baseline);
        baseline = Math.min(paddingLeft, (i3 - this.vv) - measuredWidth);
        this.vq.layout(baseline, i2, measuredWidth + baseline, this.vq.getMeasuredHeight() + i2);
        baseline = Math.max((width - paddingRight) - measuredWidth3, this.vv + i4);
        this.vs.layout(baseline, measuredWidth2, baseline + measuredWidth3, this.vs.getMeasuredHeight() + measuredWidth2);
        this.vu = f;
        this.vx = false;
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
        this.vq.measure(childMeasureSpec2, childMeasureSpec);
        this.vr.measure(childMeasureSpec2, childMeasureSpec);
        this.vs.measure(childMeasureSpec2, childMeasureSpec);
        if (MeasureSpec.getMode(i2) == 1073741824) {
            paddingTop = MeasureSpec.getSize(i2);
        } else {
            paddingTop = Math.max(getMinHeight(), paddingTop + this.vr.getMeasuredHeight());
        }
        setMeasuredDimension(size, z.resolveSizeAndState(paddingTop, i2, z.M(this.vr) << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.vp != null) {
            if (this.vu >= 0.0f) {
                f = this.vu;
            }
            a(this.vt, f, true);
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }
}
