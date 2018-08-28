package android.support.v7.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.d;
import android.support.v7.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.i;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;

public class ActivityChooserView extends ViewGroup {
    private final ImageView LA;
    private final int LB;
    d LC;
    private final DataSetObserver LD;
    private final OnGlobalLayoutListener LE;
    private ListPopupWindow LF;
    private OnDismissListener LG;
    private boolean LH;
    private int LI;
    private int LJ;
    private final a Lt;
    private final b Lu;
    private final LinearLayoutCompat Lv;
    private final Drawable Lw;
    private final FrameLayout Lx;
    private final ImageView Ly;
    private final FrameLayout Lz;
    private boolean eC;

    static /* synthetic */ void c(ActivityChooserView activityChooserView) {
        if (activityChooserView.Lt.getCount() > 0) {
            activityChooserView.Lx.setEnabled(true);
        } else {
            activityChooserView.Lx.setEnabled(false);
        }
        int eq = activityChooserView.Lt.LL.eq();
        int historySize = activityChooserView.Lt.LL.getHistorySize();
        if (eq == 1 || (eq > 1 && historySize > 0)) {
            activityChooserView.Lz.setVisibility(0);
            ResolveInfo er = activityChooserView.Lt.LL.er();
            PackageManager packageManager = activityChooserView.getContext().getPackageManager();
            activityChooserView.LA.setImageDrawable(er.loadIcon(packageManager));
            if (activityChooserView.LJ != 0) {
                CharSequence loadLabel = er.loadLabel(packageManager);
                activityChooserView.Lz.setContentDescription(activityChooserView.getContext().getString(activityChooserView.LJ, new Object[]{loadLabel}));
            }
        } else {
            activityChooserView.Lz.setVisibility(8);
        }
        if (activityChooserView.Lz.getVisibility() == 0) {
            activityChooserView.Lv.setBackgroundDrawable(activityChooserView.Lw);
        } else {
            activityChooserView.Lv.setBackgroundDrawable(null);
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.LD = new 1(this);
        this.LE = new 2(this);
        this.LI = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ActivityChooserView, i, 0);
        this.LI = obtainStyledAttributes.getInt(k.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(k.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(h.abc_activity_chooser_view, this, true);
        this.Lu = new b(this, (byte) 0);
        this.Lv = (LinearLayoutCompat) findViewById(f.activity_chooser_view_content);
        this.Lw = this.Lv.getBackground();
        this.Lz = (FrameLayout) findViewById(f.default_activity_button);
        this.Lz.setOnClickListener(this.Lu);
        this.Lz.setOnLongClickListener(this.Lu);
        this.LA = (ImageView) this.Lz.findViewById(f.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(f.expand_activities_button);
        frameLayout.setOnClickListener(this.Lu);
        frameLayout.setOnTouchListener(new 3(this, frameLayout));
        this.Lx = frameLayout;
        this.Ly = (ImageView) frameLayout.findViewById(f.image);
        this.Ly.setImageDrawable(drawable);
        this.Lt = new a(this, (byte) 0);
        this.Lt.registerDataSetObserver(new 4(this));
        Resources resources = context.getResources();
        this.LB = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
    }

    public void setActivityChooserModel(d dVar) {
        a aVar = this.Lt;
        d dVar2 = aVar.LK.Lt.LL;
        if (dVar2 != null && aVar.LK.isShown()) {
            dVar2.unregisterObserver(aVar.LK.LD);
        }
        aVar.LL = dVar;
        if (dVar != null && aVar.LK.isShown()) {
            dVar.registerObserver(aVar.LK.LD);
        }
        aVar.notifyDataSetChanged();
        if (getListPopupWindow().PK.isShowing()) {
            ez();
            ey();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.Ly.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.Ly.setContentDescription(getContext().getString(i));
    }

    public void setProvider(d dVar) {
        this.LC = dVar;
    }

    public final boolean ey() {
        if (getListPopupWindow().PK.isShowing() || !this.eC) {
            return false;
        }
        this.LH = false;
        aN(this.LI);
        return true;
    }

    private void aN(int i) {
        if (this.Lt.LL == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.LE);
        boolean z = this.Lz.getVisibility() == 0;
        int eq = this.Lt.LL.eq();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || eq <= i2 + i) {
            this.Lt.setShowFooterView(false);
            this.Lt.aO(i);
        } else {
            this.Lt.setShowFooterView(true);
            this.Lt.aO(i - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.PK.isShowing()) {
            if (this.LH || !z) {
                this.Lt.f(true, z);
            } else {
                this.Lt.f(false, false);
            }
            listPopupWindow.setContentWidth(Math.min(this.Lt.eB(), this.LB));
            listPopupWindow.show();
            if (this.LC != null) {
                this.LC.v(true);
            }
            listPopupWindow.PL.setContentDescription(getContext().getString(i.abc_activitychooserview_choose_application));
        }
    }

    public final boolean ez() {
        if (getListPopupWindow().PK.isShowing()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.LE);
            }
        }
        return true;
    }

    public final boolean eA() {
        return getListPopupWindow().PK.isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.Lt.LL;
        if (dVar != null) {
            dVar.registerObserver(this.LD);
        }
        this.eC = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.Lt.LL;
        if (dVar != null) {
            dVar.unregisterObserver(this.LD);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.LE);
        }
        if (eA()) {
            ez();
        }
        this.eC = false;
    }

    protected void onMeasure(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat = this.Lv;
        if (this.Lz.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(linearLayoutCompat, i, i2);
        setMeasuredDimension(linearLayoutCompat.getMeasuredWidth(), linearLayoutCompat.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.Lv.layout(0, 0, i3 - i, i4 - i2);
        if (!eA()) {
            ez();
        }
    }

    public d getDataModel() {
        return this.Lt.LL;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.LG = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.LI = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.LJ = i;
    }

    private ListPopupWindow getListPopupWindow() {
        if (this.LF == null) {
            this.LF = new ListPopupWindow(getContext());
            this.LF.setAdapter(this.Lt);
            this.LF.PW = this;
            this.LF.setModal(true);
            this.LF.PY = this.Lu;
            this.LF.setOnDismissListener(this.Lu);
        }
        return this.LF;
    }
}
