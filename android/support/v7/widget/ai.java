package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.d;
import android.support.v7.a.a.k;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public final class ai extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator TH = new DecelerateInterpolator();
    private int Jq;
    Runnable TA;
    private LinearLayoutCompat TB;
    private Spinner TC;
    private boolean TD;
    int TE;
    int TF;
    private int TG;

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(ai aiVar, byte b) {
            this();
        }

        public final int getCount() {
            return ai.this.TB.getChildCount();
        }

        public final Object getItem(int i) {
            return ((b) ai.this.TB.getChildAt(i)).TL;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ai.a(ai.this, (android.support.v7.app.ActionBar.a) getItem(i));
            }
            b bVar = (b) view;
            bVar.TL = (android.support.v7.app.ActionBar.a) getItem(i);
            bVar.update();
            return view;
        }
    }

    private class b extends LinearLayoutCompat implements OnLongClickListener {
        private final int[] TK = new int[]{16842964};
        android.support.v7.app.ActionBar.a TL;
        private View hZ;
        private TextView ih;
        private ImageView ii;

        public b(Context context, android.support.v7.app.ActionBar.a aVar) {
            super(context, null, android.support.v7.a.a.a.actionBarTabStyle);
            this.TL = aVar;
            ap a = ap.a(context, null, this.TK, android.support.v7.a.a.a.actionBarTabStyle);
            if (a.hasValue(0)) {
                setBackgroundDrawable(a.getDrawable(0));
            }
            a.Ww.recycle();
            setGravity(8388627);
            update();
        }

        public final void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(android.support.v7.app.ActionBar.a.class.getName());
            }
        }

        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ai.this.TE > 0 && getMeasuredWidth() > ai.this.TE) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(ai.this.TE, 1073741824), i2);
            }
        }

        public final void update() {
            android.support.v7.app.ActionBar.a aVar = this.TL;
            View customView = aVar.getCustomView();
            if (customView != null) {
                b parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(customView);
                    }
                    addView(customView);
                }
                this.hZ = customView;
                if (this.ih != null) {
                    this.ih.setVisibility(8);
                }
                if (this.ii != null) {
                    this.ii.setVisibility(8);
                    this.ii.setImageDrawable(null);
                    return;
                }
                return;
            }
            View imageView;
            LayoutParams layoutParams;
            boolean z;
            if (this.hZ != null) {
                removeView(this.hZ);
                this.hZ = null;
            }
            Drawable icon = aVar.getIcon();
            CharSequence text = aVar.getText();
            if (icon != null) {
                if (this.ii == null) {
                    imageView = new ImageView(getContext());
                    layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView, 0);
                    this.ii = imageView;
                }
                this.ii.setImageDrawable(icon);
                this.ii.setVisibility(0);
            } else if (this.ii != null) {
                this.ii.setVisibility(8);
                this.ii.setImageDrawable(null);
            }
            if (TextUtils.isEmpty(text)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.ih == null) {
                    imageView = new AppCompatTextView(getContext(), null, android.support.v7.a.a.a.actionBarTabTextStyle);
                    imageView.setEllipsize(TruncateAt.END);
                    layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView);
                    this.ih = imageView;
                }
                this.ih.setText(text);
                this.ih.setVisibility(0);
            } else if (this.ih != null) {
                this.ih.setVisibility(8);
                this.ih.setText(null);
            }
            if (this.ii != null) {
                this.ii.setContentDescription(aVar.getContentDescription());
            }
            if (z || TextUtils.isEmpty(aVar.getContentDescription())) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public final boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.TL.getContentDescription(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }
    }

    static /* synthetic */ b a(ai aiVar, android.support.v7.app.ActionBar.a aVar) {
        b bVar = new b(aiVar.getContext(), aVar);
        bVar.setBackgroundDrawable(null);
        bVar.setLayoutParams(new AbsListView.LayoutParams(-1, aiVar.Jq));
        return bVar;
    }

    public final void onMeasure(int i, int i2) {
        byte b = (byte) 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.TB.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.TE = -1;
        } else {
            if (childCount > 2) {
                this.TE = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.TE = MeasureSpec.getSize(i) / 2;
            }
            this.TE = Math.min(this.TE, this.TF);
        }
        mode = MeasureSpec.makeMeasureSpec(this.Jq, 1073741824);
        if (z || !this.TD) {
            b = (byte) 0;
        }
        if (b != (byte) 0) {
            this.TB.measure(0, mode);
            if (this.TB.getMeasuredWidth() <= MeasureSpec.getSize(i)) {
                gB();
            } else if (!gA()) {
                if (this.TC == null) {
                    Spinner appCompatSpinner = new AppCompatSpinner(getContext(), null, android.support.v7.a.a.a.actionDropDownStyle);
                    appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    appCompatSpinner.setOnItemSelectedListener(this);
                    this.TC = appCompatSpinner;
                }
                removeView(this.TB);
                addView(this.TC, new LayoutParams(-2, -1));
                if (this.TC.getAdapter() == null) {
                    this.TC.setAdapter(new a(this, (byte) 0));
                }
                if (this.TA != null) {
                    removeCallbacks(this.TA);
                    this.TA = null;
                }
                this.TC.setSelection(this.TG);
            }
        } else {
            gB();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            setTabSelected(this.TG);
        }
    }

    private boolean gA() {
        return this.TC != null && this.TC.getParent() == this;
    }

    public final void setAllowCollapse(boolean z) {
        this.TD = z;
    }

    private boolean gB() {
        if (gA()) {
            removeView(this.TC);
            addView(this.TB, new LayoutParams(-2, -1));
            setTabSelected(this.TC.getSelectedItemPosition());
        }
        return false;
    }

    public final void setTabSelected(int i) {
        this.TG = i;
        int childCount = this.TB.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.TB.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                final View childAt2 = this.TB.getChildAt(i);
                if (this.TA != null) {
                    removeCallbacks(this.TA);
                }
                this.TA = new Runnable() {
                    public final void run() {
                        ai.this.smoothScrollTo(childAt2.getLeft() - ((ai.this.getWidth() - childAt2.getWidth()) / 2), 0);
                        ai.this.TA = null;
                    }
                };
                post(this.TA);
            }
        }
        if (this.TC != null && i >= 0) {
            this.TC.setSelection(i);
        }
    }

    public final void setContentHeight(int i) {
        this.Jq = i;
        requestLayout();
    }

    protected final void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        android.support.v7.view.a R = android.support.v7.view.a.R(getContext());
        TypedArray obtainStyledAttributes = R.mContext.obtainStyledAttributes(null, k.ActionBar, android.support.v7.a.a.a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(k.ActionBar_height, 0);
        Resources resources = R.mContext.getResources();
        if (!R.dr()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        setContentHeight(layoutDimension);
        this.TF = R.mContext.getResources().getDimensionPixelSize(d.abc_action_bar_stacked_tab_max_width);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.TA != null) {
            post(this.TA);
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.TA != null) {
            removeCallbacks(this.TA);
        }
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
