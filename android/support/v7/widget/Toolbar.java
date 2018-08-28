package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.m;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.support.v7.view.c;
import android.support.v7.view.g;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.p;
import android.support.v7.widget.ActionMenuView.d;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    Context Jn;
    ActionMenuView Jo;
    private boolean Js;
    private boolean Jt;
    int KP;
    android.support.v7.view.menu.l.a KR;
    android.support.v7.view.menu.f.a KS;
    private final h Mb;
    private ImageView WA;
    private Drawable WB;
    private CharSequence WC;
    private ImageButton WD;
    View WE;
    int WF;
    int WG;
    private int WH;
    private int WI;
    private int WJ;
    private int WK;
    private int WL;
    private int WM;
    final ag WN;
    private CharSequence WO;
    private CharSequence WP;
    private int WQ;
    private int WR;
    private final ArrayList<View> WS;
    final ArrayList<View> WT;
    private final int[] WU;
    private b WV;
    private final d WW;
    private aq WX;
    ActionMenuPresenter WY;
    a WZ;
    TextView Wx;
    TextView Wy;
    private ImageButton Wz;
    private boolean Xa;
    private final Runnable Xb;
    private int rA;

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Xf;
        boolean Xg;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.Xf = parcel.readInt();
            this.Xg = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Xf);
            parcel.writeInt(this.Xg ? 1 : 0);
        }
    }

    public interface b {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        int Xe;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.Xe = 0;
        }

        public LayoutParams() {
            this.Xe = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.Xe = 0;
            this.Xe = layoutParams.Xe;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.Xe = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.Xe = 0;
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.Xe = 0;
        }
    }

    private class a implements l {
        h Xd;
        f bq;

        private a() {
        }

        /* synthetic */ a(Toolbar toolbar, byte b) {
            this();
        }

        public final void a(Context context, f fVar) {
            if (!(this.bq == null || this.Xd == null)) {
                this.bq.h(this.Xd);
            }
            this.bq = fVar;
        }

        public final void n(boolean z) {
            Object obj = null;
            if (this.Xd != null) {
                if (this.bq != null) {
                    int size = this.bq.size();
                    for (int i = 0; i < size; i++) {
                        if (this.bq.getItem(i) == this.Xd) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    c(this.Xd);
                }
            }
        }

        public final boolean a(p pVar) {
            return false;
        }

        public final void a(f fVar, boolean z) {
        }

        public final boolean N() {
            return false;
        }

        public final boolean b(h hVar) {
            Toolbar.b(Toolbar.this);
            if (Toolbar.this.WD.getParent() != Toolbar.this) {
                Toolbar.this.addView(Toolbar.this.WD);
            }
            Toolbar.this.WE = hVar.getActionView();
            this.Xd = hVar;
            if (Toolbar.this.WE.getParent() != Toolbar.this) {
                android.view.ViewGroup.LayoutParams he = Toolbar.he();
                he.gravity = 8388611 | (Toolbar.this.WH & 112);
                he.Xe = 2;
                Toolbar.this.WE.setLayoutParams(he);
                Toolbar.this.addView(Toolbar.this.WE);
            }
            Toolbar toolbar = Toolbar.this;
            for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = toolbar.getChildAt(childCount);
                if (!(((LayoutParams) childAt.getLayoutParams()).Xe == 2 || childAt == toolbar.Jo)) {
                    toolbar.removeViewAt(childCount);
                    toolbar.WT.add(childAt);
                }
            }
            Toolbar.this.requestLayout();
            hVar.O(true);
            if (Toolbar.this.WE instanceof c) {
                ((c) Toolbar.this.WE).onActionViewExpanded();
            }
            return true;
        }

        public final boolean c(h hVar) {
            if (Toolbar.this.WE instanceof c) {
                ((c) Toolbar.this.WE).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.WE);
            Toolbar.this.removeView(Toolbar.this.WD);
            Toolbar.this.WE = null;
            Toolbar toolbar = Toolbar.this;
            for (int size = toolbar.WT.size() - 1; size >= 0; size--) {
                toolbar.addView((View) toolbar.WT.get(size));
            }
            toolbar.WT.clear();
            this.Xd = null;
            Toolbar.this.requestLayout();
            hVar.O(false);
            return true;
        }

        public final int getId() {
            return 0;
        }

        public final Parcelable onSaveInstanceState() {
            return null;
        }

        public final void onRestoreInstanceState(Parcelable parcelable) {
        }
    }

    static /* synthetic */ void b(Toolbar toolbar) {
        if (toolbar.WD == null) {
            toolbar.WD = new ImageButton(toolbar.getContext(), null, android.support.v7.a.a.a.toolbarNavigationButtonStyle);
            toolbar.WD.setImageDrawable(toolbar.WB);
            toolbar.WD.setContentDescription(toolbar.WC);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388611 | (toolbar.WH & 112);
            layoutParams.Xe = 2;
            toolbar.WD.setLayoutParams(layoutParams);
            toolbar.WD.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.WN = new ag();
        this.rA = 8388627;
        this.WS = new ArrayList();
        this.WT = new ArrayList();
        this.WU = new int[2];
        this.WW = new d() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.WV != null) {
                    return Toolbar.this.WV.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.Xb = new Runnable() {
            public final void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        ap a = ap.a(getContext(), attributeSet, k.Toolbar, i);
        this.WF = a.getResourceId(k.Toolbar_titleTextAppearance, 0);
        this.WG = a.getResourceId(k.Toolbar_subtitleTextAppearance, 0);
        this.rA = a.Ww.getInteger(k.Toolbar_android_gravity, this.rA);
        this.WH = 48;
        int dimensionPixelOffset = a.getDimensionPixelOffset(k.Toolbar_titleMargins, 0);
        this.WM = dimensionPixelOffset;
        this.WL = dimensionPixelOffset;
        this.WK = dimensionPixelOffset;
        this.WJ = dimensionPixelOffset;
        dimensionPixelOffset = a.getDimensionPixelOffset(k.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset >= 0) {
            this.WJ = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(k.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset >= 0) {
            this.WK = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(k.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset >= 0) {
            this.WL = dimensionPixelOffset;
        }
        dimensionPixelOffset = a.getDimensionPixelOffset(k.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset >= 0) {
            this.WM = dimensionPixelOffset;
        }
        this.WI = a.getDimensionPixelSize(k.Toolbar_maxButtonHeight, -1);
        dimensionPixelOffset = a.getDimensionPixelOffset(k.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset2 = a.getDimensionPixelOffset(k.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = a.getDimensionPixelSize(k.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = a.getDimensionPixelSize(k.Toolbar_contentInsetRight, 0);
        ag agVar = this.WN;
        agVar.Tz = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            agVar.Tx = dimensionPixelSize;
            agVar.Tu = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            agVar.Ty = dimensionPixelSize2;
            agVar.Tv = dimensionPixelSize2;
        }
        if (!(dimensionPixelOffset == Integer.MIN_VALUE && dimensionPixelOffset2 == Integer.MIN_VALUE)) {
            this.WN.aj(dimensionPixelOffset, dimensionPixelOffset2);
        }
        this.WB = a.getDrawable(k.Toolbar_collapseIcon);
        this.WC = a.getText(k.Toolbar_collapseContentDescription);
        CharSequence text = a.getText(k.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        text = a.getText(k.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text)) {
            setSubtitle(text);
        }
        this.Jn = getContext();
        setPopupTheme(a.getResourceId(k.Toolbar_popupTheme, 0));
        Drawable drawable = a.getDrawable(k.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        text = a.getText(k.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text)) {
            setNavigationContentDescription(text);
        }
        drawable = a.getDrawable(k.Toolbar_logo);
        if (drawable != null) {
            setLogo(drawable);
        }
        text = a.getText(k.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text)) {
            setLogoDescription(text);
        }
        if (a.hasValue(k.Toolbar_titleTextColor)) {
            setTitleTextColor(a.bQ(k.Toolbar_titleTextColor));
        }
        if (a.hasValue(k.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.bQ(k.Toolbar_subtitleTextColor));
        }
        a.Ww.recycle();
        this.Mb = h.eJ();
    }

    public void setPopupTheme(int i) {
        if (this.KP != i) {
            this.KP = i;
            if (i == 0) {
                this.Jn = getContext();
            } else {
                this.Jn = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.KP;
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ag agVar = this.WN;
        if (i != 1) {
            z = false;
        }
        if (z != agVar.dx) {
            agVar.dx = z;
            if (!agVar.Tz) {
                agVar.Tu = agVar.Tx;
                agVar.Tv = agVar.Ty;
            } else if (z) {
                agVar.Tu = agVar.tK != Integer.MIN_VALUE ? agVar.tK : agVar.Tx;
                agVar.Tv = agVar.Tw != Integer.MIN_VALUE ? agVar.Tw : agVar.Ty;
            } else {
                agVar.Tu = agVar.Tw != Integer.MIN_VALUE ? agVar.Tw : agVar.Tx;
                agVar.Tv = agVar.tK != Integer.MIN_VALUE ? agVar.tK : agVar.Ty;
            }
        }
    }

    public void setLogo(int i) {
        setLogo(this.Mb.a(getContext(), i, false));
    }

    public final boolean isOverflowMenuShowing() {
        if (this.Jo != null) {
            ActionMenuView actionMenuView = this.Jo;
            boolean z = actionMenuView.KQ != null && actionMenuView.KQ.isOverflowMenuShowing();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean showOverflowMenu() {
        if (this.Jo != null) {
            ActionMenuView actionMenuView = this.Jo;
            boolean z = actionMenuView.KQ != null && actionMenuView.KQ.showOverflowMenu();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ha();
            if (!bu(this.WA)) {
                d(this.WA, true);
            }
        } else if (this.WA != null && bu(this.WA)) {
            removeView(this.WA);
            this.WT.remove(this.WA);
        }
        if (this.WA != null) {
            this.WA.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.WA != null ? this.WA.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ha();
        }
        if (this.WA != null) {
            this.WA.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.WA != null ? this.WA.getContentDescription() : null;
    }

    private void ha() {
        if (this.WA == null) {
            this.WA = new ImageView(getContext());
        }
    }

    public final void collapseActionView() {
        h hVar = this.WZ == null ? null : this.WZ.Xd;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.WO;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.Wx == null) {
                Context context = getContext();
                this.Wx = new TextView(context);
                this.Wx.setSingleLine();
                this.Wx.setEllipsize(TruncateAt.END);
                if (this.WF != 0) {
                    this.Wx.setTextAppearance(context, this.WF);
                }
                if (this.WQ != 0) {
                    this.Wx.setTextColor(this.WQ);
                }
            }
            if (!bu(this.Wx)) {
                d(this.Wx, true);
            }
        } else if (this.Wx != null && bu(this.Wx)) {
            removeView(this.Wx);
            this.WT.remove(this.Wx);
        }
        if (this.Wx != null) {
            this.Wx.setText(charSequence);
        }
        this.WO = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.WP;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.Wy == null) {
                Context context = getContext();
                this.Wy = new TextView(context);
                this.Wy.setSingleLine();
                this.Wy.setEllipsize(TruncateAt.END);
                if (this.WG != 0) {
                    this.Wy.setTextAppearance(context, this.WG);
                }
                if (this.WR != 0) {
                    this.Wy.setTextColor(this.WR);
                }
            }
            if (!bu(this.Wy)) {
                d(this.Wy, true);
            }
        } else if (this.Wy != null && bu(this.Wy)) {
            removeView(this.Wy);
            this.WT.remove(this.Wy);
        }
        if (this.Wy != null) {
            this.Wy.setText(charSequence);
        }
        this.WP = charSequence;
    }

    public void setTitleTextColor(int i) {
        this.WQ = i;
        if (this.Wx != null) {
            this.Wx.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.WR = i;
        if (this.Wy != null) {
            this.Wy.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        return this.Wz != null ? this.Wz.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            hd();
        }
        if (this.Wz != null) {
            this.Wz.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.Mb.a(getContext(), i, false));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            hd();
            if (!bu(this.Wz)) {
                d(this.Wz, true);
            }
        } else if (this.Wz != null && bu(this.Wz)) {
            removeView(this.Wz);
            this.WT.remove(this.Wz);
        }
        if (this.Wz != null) {
            this.Wz.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        return this.Wz != null ? this.Wz.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        hd();
        this.Wz.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        hb();
        return this.Jo.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        hb();
        this.Jo.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        hb();
        return this.Jo.getOverflowIcon();
    }

    private void hb() {
        hc();
        if (this.Jo.bq == null) {
            f fVar = (f) this.Jo.getMenu();
            if (this.WZ == null) {
                this.WZ = new a(this, (byte) 0);
            }
            this.Jo.setExpandedActionViewsExclusive(true);
            fVar.a(this.WZ, this.Jn);
        }
    }

    final void hc() {
        if (this.Jo == null) {
            this.Jo = new ActionMenuView(getContext());
            this.Jo.setPopupTheme(this.KP);
            this.Jo.setOnMenuItemClickListener(this.WW);
            this.Jo.a(this.KR, this.KS);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388613 | (this.WH & 112);
            this.Jo.setLayoutParams(layoutParams);
            d(this.Jo, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new g(getContext());
    }

    public void setOnMenuItemClickListener(b bVar) {
        this.WV = bVar;
    }

    public int getContentInsetStart() {
        ag agVar = this.WN;
        return agVar.dx ? agVar.Tv : agVar.Tu;
    }

    public int getContentInsetEnd() {
        ag agVar = this.WN;
        return agVar.dx ? agVar.Tu : agVar.Tv;
    }

    public int getContentInsetLeft() {
        return this.WN.Tu;
    }

    public int getContentInsetRight() {
        return this.WN.Tv;
    }

    private void hd() {
        if (this.Wz == null) {
            this.Wz = new ImageButton(getContext(), null, android.support.v7.a.a.a.toolbarNavigationButtonStyle);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.gravity = 8388611 | (this.WH & 112);
            this.Wz.setLayoutParams(layoutParams);
        }
    }

    private void d(View view, boolean z) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams();
        } else if (checkLayoutParams(layoutParams)) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        } else {
            layoutParams = f(layoutParams);
        }
        layoutParams.Xe = 1;
        if (!z || this.WE == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.WT.add(view);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.WZ == null || this.WZ.Xd == null)) {
            savedState.Xf = this.WZ.Xd.getItemId();
        }
        savedState.Xg = isOverflowMenuShowing();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            Menu menu = this.Jo != null ? this.Jo.bq : null;
            if (!(savedState.Xf == 0 || this.WZ == null || menu == null)) {
                MenuItem findItem = menu.findItem(savedState.Xf);
                if (findItem != null) {
                    m.b(findItem);
                }
            }
            if (savedState.Xg) {
                removeCallbacks(this.Xb);
                post(this.Xb);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Xb);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 0) {
            this.Js = false;
        }
        if (!this.Js) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (d == 0 && !onTouchEvent) {
                this.Js = true;
            }
        }
        if (d == 1 || d == 3) {
            this.Js = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 9) {
            this.Jt = false;
        }
        if (!this.Jt) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (d == 9 && !onHoverEvent) {
                this.Jt = true;
            }
        }
        if (d == 10 || d == 3) {
            this.Jt = false;
        }
        return true;
    }

    private void i(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + 0, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int combineMeasuredStates;
        int i5;
        Object obj;
        int[] iArr = this.WU;
        if (at.bv(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i6 = 0;
        if (br(this.Wz)) {
            i(this.Wz, i, 0, i2, this.WI);
            i6 = this.Wz.getMeasuredWidth() + bs(this.Wz);
            max = Math.max(0, this.Wz.getMeasuredHeight() + bt(this.Wz));
            combineMeasuredStates = at.combineMeasuredStates(0, z.M(this.Wz));
            i5 = max;
        } else {
            combineMeasuredStates = 0;
            i5 = 0;
        }
        if (br(this.WD)) {
            i(this.WD, i, 0, i2, this.WI);
            i6 = this.WD.getMeasuredWidth() + bs(this.WD);
            i5 = Math.max(i5, this.WD.getMeasuredHeight() + bt(this.WD));
            combineMeasuredStates = at.combineMeasuredStates(combineMeasuredStates, z.M(this.WD));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = Math.max(contentInsetStart, i6) + 0;
        iArr[i4] = Math.max(0, contentInsetStart - i6);
        i6 = 0;
        if (br(this.Jo)) {
            i(this.Jo, i, max2, i2, this.WI);
            i6 = this.Jo.getMeasuredWidth() + bs(this.Jo);
            i5 = Math.max(i5, this.Jo.getMeasuredHeight() + bt(this.Jo));
            combineMeasuredStates = at.combineMeasuredStates(combineMeasuredStates, z.M(this.Jo));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i6);
        iArr[i3] = Math.max(0, contentInsetStart - i6);
        if (br(this.WE)) {
            max2 += a(this.WE, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.WE.getMeasuredHeight() + bt(this.WE));
            combineMeasuredStates = at.combineMeasuredStates(combineMeasuredStates, z.M(this.WE));
        }
        if (br(this.WA)) {
            max2 += a(this.WA, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.WA.getMeasuredHeight() + bt(this.WA));
            combineMeasuredStates = at.combineMeasuredStates(combineMeasuredStates, z.M(this.WA));
        }
        i4 = getChildCount();
        i3 = 0;
        int i7 = combineMeasuredStates;
        int i8 = i5;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).Xe == 0 && br(childAt)) {
                max2 += a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + bt(childAt));
                i6 = at.combineMeasuredStates(i7, z.M(childAt));
                contentInsetStart = max;
            } else {
                i6 = i7;
                contentInsetStart = i8;
            }
            i3++;
            i7 = i6;
            i8 = contentInsetStart;
        }
        contentInsetStart = 0;
        i6 = 0;
        int i9 = this.WL + this.WM;
        max = this.WJ + this.WK;
        if (br(this.Wx)) {
            a(this.Wx, i, max2 + max, i2, i9, iArr);
            contentInsetStart = bs(this.Wx) + this.Wx.getMeasuredWidth();
            i6 = this.Wx.getMeasuredHeight() + bt(this.Wx);
            i7 = at.combineMeasuredStates(i7, z.M(this.Wx));
        }
        if (br(this.Wy)) {
            contentInsetStart = Math.max(contentInsetStart, a(this.Wy, i, max2 + max, i2, i9 + i6, iArr));
            i6 += this.Wy.getMeasuredHeight() + bt(this.Wy);
            i7 = at.combineMeasuredStates(i7, z.M(this.Wy));
        }
        contentInsetStart += max2;
        i6 = Math.max(i8, i6) + (getPaddingTop() + getPaddingBottom());
        int i10 = i;
        max = z.resolveSizeAndState(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i10, -16777216 & i7);
        i6 = z.resolveSizeAndState(Math.max(i6, getSuggestedMinimumHeight()), i2, i7 << 16);
        if (this.Xa) {
            max2 = getChildCount();
            for (contentInsetStart = 0; contentInsetStart < max2; contentInsetStart++) {
                View childAt2 = getChildAt(contentInsetStart);
                if (br(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i6 = 0;
        }
        setMeasuredDimension(max, i6);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int i6;
        int i7;
        LayoutParams layoutParams;
        int measuredHeight;
        int paddingTop;
        int measuredWidth;
        if (z.I(this) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.WU;
        iArr[1] = 0;
        iArr[0] = 0;
        int T = z.T(this);
        if (!br(this.Wz)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = b(this.Wz, i8, iArr, T);
            i5 = paddingLeft;
        } else {
            i5 = a(this.Wz, paddingLeft, iArr, T);
        }
        if (br(this.WD)) {
            if (obj != null) {
                i8 = b(this.WD, i8, iArr, T);
            } else {
                i5 = a(this.WD, i5, iArr, T);
            }
        }
        if (br(this.Jo)) {
            if (obj != null) {
                i5 = a(this.Jo, i5, iArr, T);
            } else {
                i8 = b(this.Jo, i8, iArr, T);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (br(this.WE)) {
            if (obj != null) {
                i8 = b(this.WE, i8, iArr, T);
            } else {
                i5 = a(this.WE, i5, iArr, T);
            }
        }
        if (!br(this.WA)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = b(this.WA, i8, iArr, T);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = a(this.WA, i5, iArr, T);
        }
        boolean br = br(this.Wx);
        boolean br2 = br(this.Wy);
        i5 = 0;
        if (br) {
            layoutParams = (LayoutParams) this.Wx.getLayoutParams();
            i5 = (layoutParams.bottomMargin + (layoutParams.topMargin + this.Wx.getMeasuredHeight())) + 0;
        }
        if (br2) {
            layoutParams = (LayoutParams) this.Wy.getLayoutParams();
            measuredHeight = (layoutParams.bottomMargin + (layoutParams.topMargin + this.Wy.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (br || br2) {
            layoutParams = (LayoutParams) (br ? this.Wx : this.Wy).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) (br2 ? this.Wy : this.Wx).getLayoutParams();
            Object obj2 = ((!br || this.Wx.getMeasuredWidth() <= 0) && (!br2 || this.Wy.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.rA & 112) {
                case 48:
                    paddingTop = (layoutParams.topMargin + getPaddingTop()) + this.WL;
                    break;
                case 80:
                    paddingTop = (((height - paddingBottom) - layoutParams2.bottomMargin) - this.WM) - measuredHeight;
                    break;
                default:
                    paddingTop = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop < layoutParams.topMargin + this.WL) {
                        i8 = layoutParams.topMargin + this.WL;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop) - paddingTop2;
                        if (measuredHeight < layoutParams.bottomMargin + this.WM) {
                            i8 = Math.max(0, paddingTop - ((layoutParams2.bottomMargin + this.WM) - measuredHeight));
                        } else {
                            i8 = paddingTop;
                        }
                    }
                    paddingTop = paddingTop2 + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.WJ : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (br) {
                    layoutParams = (LayoutParams) this.Wx.getLayoutParams();
                    measuredWidth = i5 - this.Wx.getMeasuredWidth();
                    i6 = this.Wx.getMeasuredHeight() + paddingTop;
                    this.Wx.layout(measuredWidth, paddingTop, i5, i6);
                    paddingTop = i6 + layoutParams.bottomMargin;
                    i6 = measuredWidth - this.WK;
                } else {
                    i6 = i5;
                }
                if (br2) {
                    layoutParams = (LayoutParams) this.Wy.getLayoutParams();
                    measuredWidth = layoutParams.topMargin + paddingTop;
                    this.Wy.layout(i5 - this.Wy.getMeasuredWidth(), measuredWidth, i5, this.Wy.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i5 - this.WK;
                    i8 = layoutParams.bottomMargin;
                    i8 = measuredWidth;
                } else {
                    i8 = i5;
                }
                if (obj2 != null) {
                    i8 = Math.min(i6, i8);
                } else {
                    i8 = i5;
                }
                i6 = i8;
            } else {
                i8 = (obj2 != null ? this.WJ : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (br) {
                    layoutParams = (LayoutParams) this.Wx.getLayoutParams();
                    i5 = this.Wx.getMeasuredWidth() + i7;
                    measuredWidth = this.Wx.getMeasuredHeight() + paddingTop;
                    this.Wx.layout(i7, paddingTop, i5, measuredWidth);
                    i8 = layoutParams.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.WK;
                    paddingTop = i8;
                } else {
                    measuredWidth = i7;
                }
                if (br2) {
                    layoutParams = (LayoutParams) this.Wy.getLayoutParams();
                    i5 = layoutParams.topMargin + paddingTop;
                    paddingTop = this.Wy.getMeasuredWidth() + i7;
                    this.Wy.layout(i7, i5, paddingTop, this.Wy.getMeasuredHeight() + i5);
                    i5 = this.WK + paddingTop;
                    i8 = layoutParams.bottomMargin;
                    i8 = i5;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        b(this.WS, 3);
        int size = this.WS.size();
        measuredWidth = i7;
        for (i5 = 0; i5 < size; i5++) {
            measuredWidth = a((View) this.WS.get(i5), measuredWidth, iArr, T);
        }
        b(this.WS, 5);
        i7 = this.WS.size();
        i5 = 0;
        measuredHeight = i6;
        while (i5 < i7) {
            i6 = b((View) this.WS.get(i5), measuredHeight, iArr, T);
            i5++;
            measuredHeight = i6;
        }
        b(this.WS, 1);
        List list = this.WS;
        size = iArr[0];
        paddingTop = iArr[1];
        paddingTop2 = list.size();
        i6 = 0;
        i7 = 0;
        while (i6 < paddingTop2) {
            View view = (View) list.get(i6);
            layoutParams = (LayoutParams) view.getLayoutParams();
            size = layoutParams.leftMargin - size;
            i8 = layoutParams.rightMargin - paddingTop;
            paddingBottom = Math.max(0, size);
            int max = Math.max(0, i8);
            size = Math.max(0, -size);
            paddingTop = Math.max(0, -i8);
            i6++;
            i7 += (view.getMeasuredWidth() + paddingBottom) + max;
        }
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (i7 / 2);
        i5 = i8 + i7;
        if (i8 < measuredWidth) {
            i8 = measuredWidth;
        } else if (i5 > measuredHeight) {
            i8 -= i5 - measuredHeight;
        }
        paddingLeft = this.WS.size();
        measuredWidth = 0;
        i5 = i8;
        while (measuredWidth < paddingLeft) {
            measuredWidth++;
            i5 = a((View) this.WS.get(measuredWidth), i5, iArr, T);
        }
        this.WS.clear();
    }

    private int a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = p(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    private int b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = p(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int p(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = layoutParams.gravity & 112;
        switch (i3) {
            case 16:
            case 48:
            case 80:
                break;
            default:
                i3 = this.rA & 112;
                break;
        }
        switch (i3) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int i4;
                i3 = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - i3) - paddingBottom) - measuredHeight) / 2;
                if (i2 < layoutParams.topMargin) {
                    i4 = layoutParams.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - i3;
                    i4 = measuredHeight < layoutParams.bottomMargin ? Math.max(0, i2 - (layoutParams.bottomMargin - measuredHeight)) : i2;
                }
                return i4 + i3;
        }
    }

    private void b(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (z.I(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(i, z.I(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.Xe == 0 && br(childAt) && bR(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.Xe == 0 && br(childAt2) && bR(layoutParams.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private int bR(int i) {
        int I = z.I(this);
        int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(i, I) & 7;
        switch (absoluteGravity) {
            case 1:
            case 3:
            case 5:
                return absoluteGravity;
            default:
                return I == 1 ? 5 : 3;
        }
    }

    private boolean br(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private static int bs(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return android.support.v4.view.l.b(marginLayoutParams) + android.support.v4.view.l.a(marginLayoutParams);
    }

    private static int bt(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private static LayoutParams f(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams) {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected static LayoutParams he() {
        return new LayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public u getWrapper() {
        if (this.WX == null) {
            this.WX = new aq(this, true);
        }
        return this.WX;
    }

    private boolean bu(View view) {
        return view.getParent() == this || this.WT.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.Xa = z;
        requestLayout();
    }
}
