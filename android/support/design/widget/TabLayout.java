package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.design.a.d;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.e.i.a;
import android.support.v4.e.i.b;
import android.support.v4.e.i.c;
import android.support.v4.view.ViewPager;
import android.support.v4.view.u;
import android.support.v4.view.z;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class TabLayout extends HorizontalScrollView {
    private static final a<d> hj = new c();
    private int hA;
    private int hB;
    private a hC;
    private u hD;
    private ViewPager hE;
    private u hF;
    private DataSetObserver hG;
    private e hH;
    private final a<f> hI;
    private final ArrayList<d> hk;
    private d hl;
    private final c hm;
    private int hn;
    private int ho;
    private int hp;
    private int hq;
    private int hr;
    private ColorStateList hs;
    private float ht;
    private float hu;
    private final int hv;
    private int hw;
    private final int hx;
    private final int hy;
    private final int hz;
    private int mMode;

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hk = new ArrayList();
        this.hw = Integer.MAX_VALUE;
        this.hI = new b(12);
        t.G(context);
        setHorizontalScrollBarEnabled(false);
        this.hm = new c(this, context);
        super.addView(this.hm, 0, new LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.TabLayout, i, h.Widget_Design_TabLayout);
        this.hm.M(obtainStyledAttributes.getDimensionPixelSize(i.TabLayout_tabIndicatorHeight, 0));
        this.hm.L(obtainStyledAttributes.getColor(i.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i.TabLayout_tabPadding, 0);
        this.hq = dimensionPixelSize;
        this.hp = dimensionPixelSize;
        this.ho = dimensionPixelSize;
        this.hn = dimensionPixelSize;
        this.hn = obtainStyledAttributes.getDimensionPixelSize(i.TabLayout_tabPaddingStart, this.hn);
        this.ho = obtainStyledAttributes.getDimensionPixelSize(i.TabLayout_tabPaddingTop, this.ho);
        this.hp = obtainStyledAttributes.getDimensionPixelSize(i.TabLayout_tabPaddingEnd, this.hp);
        this.hq = obtainStyledAttributes.getDimensionPixelSize(i.TabLayout_tabPaddingBottom, this.hq);
        this.hr = obtainStyledAttributes.getResourceId(i.TabLayout_tabTextAppearance, h.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.hr, i.TextAppearance);
        try {
            this.ht = (float) obtainStyledAttributes2.getDimensionPixelSize(i.TextAppearance_android_textSize, 0);
            this.hs = obtainStyledAttributes2.getColorStateList(i.TextAppearance_android_textColor);
            if (obtainStyledAttributes.hasValue(i.TabLayout_tabTextColor)) {
                this.hs = obtainStyledAttributes.getColorStateList(i.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(i.TabLayout_tabSelectedTextColor)) {
                dimensionPixelSize = obtainStyledAttributes.getColor(i.TabLayout_tabSelectedTextColor, 0);
                int defaultColor = this.hs.getDefaultColor();
                r3 = new int[2][];
                int[] iArr = new int[]{SELECTED_STATE_SET, dimensionPixelSize};
                r3[1] = EMPTY_STATE_SET;
                iArr[1] = defaultColor;
                this.hs = new ColorStateList(r3, iArr);
            }
            this.hx = obtainStyledAttributes.getDimensionPixelSize(i.TabLayout_tabMinWidth, -1);
            this.hy = obtainStyledAttributes.getDimensionPixelSize(i.TabLayout_tabMaxWidth, -1);
            this.hv = obtainStyledAttributes.getResourceId(i.TabLayout_tabBackground, 0);
            this.hA = obtainStyledAttributes.getDimensionPixelSize(i.TabLayout_tabContentStart, 0);
            this.mMode = obtainStyledAttributes.getInt(i.TabLayout_tabMode, 1);
            this.hB = obtainStyledAttributes.getInt(i.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.hu = (float) resources.getDimensionPixelSize(d.design_tab_text_size_2line);
            this.hz = resources.getDimensionPixelSize(d.design_tab_scrollable_min_width);
            aI();
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.hm.L(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.hm.M(i);
    }

    private void setScrollPosition$4867b5c2(int i) {
        a(i, 0.0f, true, true);
    }

    private void a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.hm.getChildCount()) {
            if (z2) {
                c cVar = this.hm;
                if (cVar.hQ != null && cVar.hQ.iO.isRunning()) {
                    cVar.hQ.iO.cancel();
                }
                cVar.hM = i;
                cVar.hN = f;
                cVar.aJ();
            }
            if (this.hD != null && this.hD.iO.isRunning()) {
                this.hD.iO.cancel();
            }
            scrollTo(b(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        c cVar = this.hm;
        return cVar.hN + ((float) cVar.hM);
    }

    private void a(d dVar, boolean z) {
        if (dVar.ia != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        f fVar = dVar.ib;
        c cVar = this.hm;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        cVar.addView(fVar, layoutParams);
        if (z) {
            fVar.setSelected(true);
        }
        a(dVar, this.hk.size());
        if (z) {
            dVar.select();
        }
    }

    public void setOnTabSelectedListener(a aVar) {
        this.hC = aVar;
    }

    private d aG() {
        d dVar;
        d dVar2 = (d) hj.bW();
        if (dVar2 == null) {
            dVar = new d((byte) 0);
        } else {
            dVar = dVar2;
        }
        dVar.ia = this;
        f fVar = this.hI != null ? (f) this.hI.bW() : null;
        if (fVar == null) {
            fVar = new f(this, getContext());
        }
        f.a(fVar, dVar);
        fVar.setFocusable(true);
        fVar.setMinimumWidth(getTabMinWidth());
        dVar.ib = fVar;
        return dVar;
    }

    public int getTabCount() {
        return this.hk.size();
    }

    public final d I(int i) {
        return (d) this.hk.get(i);
    }

    public int getSelectedTabPosition() {
        return this.hl != null ? this.hl.mPosition : -1;
    }

    private void removeAllTabs() {
        for (int childCount = this.hm.getChildCount() - 1; childCount >= 0; childCount--) {
            f fVar = (f) this.hm.getChildAt(childCount);
            this.hm.removeViewAt(childCount);
            if (fVar != null) {
                f.a(fVar);
                this.hI.j(fVar);
            }
            requestLayout();
        }
        Iterator it = this.hk.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            it.remove();
            dVar.ia = null;
            dVar.ib = null;
            dVar.hX = null;
            dVar.hh = null;
            dVar.mText = null;
            dVar.hY = null;
            dVar.mPosition = -1;
            dVar.hZ = null;
            hj.j(dVar);
        }
        this.hl = null;
    }

    public void setTabMode(int i) {
        if (i != this.mMode) {
            this.mMode = i;
            aI();
        }
    }

    public int getTabMode() {
        return this.mMode;
    }

    public void setTabGravity(int i) {
        if (this.hB != i) {
            this.hB = i;
            aI();
        }
    }

    public int getTabGravity() {
        return this.hB;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.hs != colorStateList) {
            this.hs = colorStateList;
            int size = this.hk.size();
            for (int i = 0; i < size; i++) {
                ((d) this.hk.get(i)).aL();
            }
        }
    }

    public ColorStateList getTabTextColors() {
        return this.hs;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        e eVar;
        if (!(this.hE == null || this.hH == null)) {
            ViewPager viewPager2 = this.hE;
            eVar = this.hH;
            if (viewPager2.wJ != null) {
                viewPager2.wJ.remove(eVar);
            }
        }
        if (viewPager != null) {
            u adapter = viewPager.getAdapter();
            if (adapter == null) {
                throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
            }
            this.hE = viewPager;
            if (this.hH == null) {
                this.hH = new e(this);
            }
            eVar = this.hH;
            eVar.if = 0;
            eVar.ie = 0;
            viewPager.a(this.hH);
            setOnTabSelectedListener(new g(viewPager));
            a(adapter, true);
            return;
        }
        this.hE = null;
        setOnTabSelectedListener(null);
        a(null, true);
    }

    @Deprecated
    public void setTabsFromPagerAdapter(u uVar) {
        a(uVar, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.hm.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void a(u uVar, boolean z) {
        if (!(this.hF == null || this.hG == null)) {
            this.hF.unregisterDataSetObserver(this.hG);
        }
        this.hF = uVar;
        if (z && uVar != null) {
            if (this.hG == null) {
                this.hG = new b(this, (byte) 0);
            }
            uVar.registerDataSetObserver(this.hG);
        }
        aH();
    }

    private void aH() {
        removeAllTabs();
        if (this.hF != null) {
            int i;
            int count = this.hF.getCount();
            for (i = 0; i < count; i++) {
                a(aG().a(this.hF.cb()), false);
            }
            if (this.hE != null && count > 0) {
                i = this.hE.getCurrentItem();
                if (i != getSelectedTabPosition() && i < getTabCount()) {
                    b(I(i), true);
                    return;
                }
                return;
            }
            return;
        }
        removeAllTabs();
    }

    private void a(d dVar, int i) {
        dVar.mPosition = i;
        this.hk.add(i, dVar);
        int size = this.hk.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((d) this.hk.get(i2)).mPosition = i2;
        }
    }

    public void addView(View view) {
        t(view);
    }

    public void addView(View view, int i) {
        t(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        t(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        t(view);
    }

    private void t(View view) {
        if (view instanceof TabItem) {
            TabItem tabItem = (TabItem) view;
            d aG = aG();
            if (tabItem.mText != null) {
                aG.a(tabItem.mText);
            }
            if (tabItem.hh != null) {
                aG.hh = tabItem.hh;
                aG.aL();
            }
            if (tabItem.hi != 0) {
                aG.hZ = LayoutInflater.from(aG.ib.getContext()).inflate(tabItem.hi, aG.ib, false);
                aG.aL();
            }
            a(aG, this.hk.isEmpty());
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.mMode == 1 && this.hB == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private int J(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        int J = (J(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(J, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(J, 1073741824);
                break;
        }
        J = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            if (this.hy > 0) {
                J = this.hy;
            } else {
                J -= J(56);
            }
            this.hw = J;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.mMode) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        J = 0;
                        break;
                    } else {
                        J = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i3 = 0;
                    }
                    J = i3;
                    break;
                default:
                    J = 0;
                    break;
            }
            if (J != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void K(int i) {
        Object obj = null;
        if (i != -1) {
            if (getWindowToken() != null && z.ai(this)) {
                int i2;
                c cVar = this.hm;
                int childCount = cVar.getChildCount();
                for (i2 = 0; i2 < childCount; i2++) {
                    if (cVar.getChildAt(i2).getWidth() <= 0) {
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    int scrollX = getScrollX();
                    i2 = b(i, 0.0f);
                    if (scrollX != i2) {
                        if (this.hD == null) {
                            this.hD = aa.aP();
                            this.hD.setInterpolator(a.bM);
                            this.hD.setDuration(300);
                            this.hD.a(new 1(this));
                        }
                        this.hD.i(scrollX, i2);
                        this.hD.iO.start();
                    }
                    this.hm.h(i, 300);
                    return;
                }
            }
            setScrollPosition$4867b5c2(i);
        }
    }

    private void setSelectedTabView(int i) {
        int childCount = this.hm.getChildCount();
        if (i < childCount && !this.hm.getChildAt(i).isSelected()) {
            for (int i2 = 0; i2 < childCount; i2++) {
                boolean z;
                View childAt = this.hm.getChildAt(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    final void b(d dVar, boolean z) {
        if (this.hl != dVar) {
            if (z) {
                int i = dVar != null ? dVar.mPosition : -1;
                if (i != -1) {
                    setSelectedTabView(i);
                }
                if ((this.hl == null || this.hl.mPosition == -1) && i != -1) {
                    setScrollPosition$4867b5c2(i);
                } else {
                    K(i);
                }
            }
            this.hl = dVar;
            if (this.hl != null && this.hC != null) {
                this.hC.a(this.hl);
            }
        } else if (this.hl != null) {
            K(dVar.mPosition);
        }
    }

    private int b(int i, float f) {
        int i2 = 0;
        if (this.mMode != 0) {
            return 0;
        }
        int width;
        View childAt = this.hm.getChildAt(i);
        View childAt2 = i + 1 < this.hm.getChildCount() ? this.hm.getChildAt(i + 1) : null;
        if (childAt != null) {
            width = childAt.getWidth();
        } else {
            width = 0;
        }
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private void aI() {
        int max;
        if (this.mMode == 0) {
            max = Math.max(0, this.hA - this.hn);
        } else {
            max = 0;
        }
        z.c(this.hm, max, 0, 0, 0);
        switch (this.mMode) {
            case 0:
                this.hm.setGravity(8388611);
                break;
            case 1:
                this.hm.setGravity(1);
                break;
        }
        r(true);
    }

    private void r(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hm.getChildCount()) {
                View childAt = this.hm.getChildAt(i2);
                childAt.setMinimumWidth(getTabMinWidth());
                a((LinearLayout.LayoutParams) childAt.getLayoutParams());
                if (z) {
                    childAt.requestLayout();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private int getDefaultHeight() {
        Object obj;
        int size = this.hk.size();
        for (int i = 0; i < size; i++) {
            d dVar = (d) this.hk.get(i);
            if (dVar != null && dVar.hh != null && !TextUtils.isEmpty(dVar.mText)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            return 72;
        }
        return 48;
    }

    private int getTabMinWidth() {
        if (this.hx != -1) {
            return this.hx;
        }
        return this.mMode == 0 ? this.hz : 0;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    private int getTabMaxWidth() {
        return this.hw;
    }
}
