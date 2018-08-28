package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.l;

public abstract class p implements OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    private int IZ;
    private ViewTreeObserver Jd;
    private ViewGroup Je;
    private int dividerHeight;
    private View eS;
    private boolean gKt = false;
    private BaseAdapter hAv;
    protected Context mContext;
    private boolean qgI = false;
    private MMListPopupWindow tIc;
    private int tId = l.DropMenuAnimation;
    private OnCancelListener uCh;
    private OnDismissListener uCi;
    private boolean uCj = true;
    private View uCk;
    private int uCl;
    private int uCm = 0;
    private int uCn = 0;
    private int uCo = 0;
    private float uCp = 0.0f;
    private float uCq = 0.0f;

    public abstract BaseAdapter avF();

    public p(Context context) {
        this.mContext = context;
        Resources resources = context.getResources();
        this.IZ = Math.min((resources.getDisplayMetrics().widthPixels * 4) / 5, resources.getDimensionPixelSize(e.abc_config_prefDialogWidth));
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.eS = viewGroup.getChildAt(0);
            } else {
                this.eS = viewGroup;
            }
        }
        this.dividerHeight = b.b(this.mContext, 1.0f);
        this.uCm = resources.getDimensionPixelSize(e.NormalPadding) * 2;
        this.uCn = resources.getDimensionPixelSize(e.SmallListHeight);
        this.uCo = b.b(this.mContext, 36.0f);
        this.hAv = avF();
    }

    public final void mw(boolean z) {
        this.gKt = z;
        if (z) {
            this.tId = l.CenterMenuAnimation;
        } else {
            this.tId = l.DropMenuAnimation;
        }
    }

    public boolean dZ() {
        int height;
        boolean z;
        Rect rect = new Rect();
        if (this.mContext instanceof ActionBarActivity) {
            height = ((ActionBarActivity) this.mContext).getSupportActionBar().getHeight();
        } else {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            height = displayMetrics.widthPixels > displayMetrics.heightPixels ? b.b(this.mContext, 40.0f) : b.b(this.mContext, 49.0f);
        }
        int dimensionPixelSize = height - this.mContext.getResources().getDimensionPixelSize(e.NormalPadding);
        if (this.mContext instanceof Activity) {
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height2 = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) this.mContext).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (height2 - rect.height() < 0 || iArr[1] <= 200) {
                height = rect.top + dimensionPixelSize;
            } else {
                height = (height2 - rect.height()) + dimensionPixelSize;
            }
        } else {
            height = dimensionPixelSize;
        }
        this.qgI = bdK();
        if (this.tIc == null || true == this.uCj) {
            this.tIc = new MMListPopupWindow(this.mContext, null, 0);
        }
        this.tIc.setOnDismissListener(this);
        this.tIc.PY = this;
        this.tIc.setAdapter(this.hAv);
        this.tIc.crA();
        this.tIc.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.ofm_menu_bg));
        this.tIc.setAnimationStyle(this.tId);
        this.tIc.PN = 0;
        this.tIc.PW = this.eS;
        if (this.eS != null) {
            z = this.Jd == null;
            this.Jd = this.eS.getViewTreeObserver();
            x.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", new Object[]{Boolean.valueOf(z)});
            if (z) {
                this.Jd.addOnGlobalLayoutListener(this);
            }
        }
        this.tIc.setVerticalOffset(height);
        this.tIc.gKt = this.gKt;
        this.tIc.setContentWidth(Math.min(a(this.hAv), this.IZ));
        this.tIc.fo();
        if (!(this.uCp == 0.0f || this.uCq == 0.0f)) {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
            z = displayMetrics2.widthPixels > displayMetrics2.heightPixels;
            Rect rect2 = new Rect();
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            height = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            int height3 = height > rect2.height() ? rect2.height() : height;
            x.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", new Object[]{Float.valueOf(this.uCp), Float.valueOf(this.uCq), Integer.valueOf(rect2.height()), Integer.valueOf(height3), Integer.valueOf(z ? (int) (this.uCq * ((float) height3)) : (int) (this.uCp * ((float) height3)))});
            height = Math.round((float) (height / this.uCn));
            if (height <= 0 || this.hAv == null) {
                x.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
            } else {
                dimensionPixelSize = (this.uCn * height) + this.uCm;
                if (dimensionPixelSize == 0 || dimensionPixelSize >= this.hAv.getCount() * this.uCn) {
                    x.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", new Object[]{Integer.valueOf(dimensionPixelSize), Integer.valueOf(this.hAv.getCount() * this.uCn)});
                } else {
                    this.tIc.PM = (((height - 1) * this.uCn) + this.uCm) + this.uCo;
                }
            }
        }
        if (!(this.tIc == null || this.uCk == null)) {
            MMListPopupWindow mMListPopupWindow = this.tIc;
            View view = this.uCk;
            boolean isShowing = mMListPopupWindow.eZB.isShowing();
            if (isShowing) {
                mMListPopupWindow.aqa();
            }
            mMListPopupWindow.PU = view;
            if (isShowing) {
                mMListPopupWindow.show();
            }
            this.tIc.PV = this.uCl;
        }
        this.tIc.show();
        this.tIc.tvU.setOnKeyListener(this);
        this.tIc.tvU.setSelector(new ColorDrawable(this.mContext.getResources().getColor(d.transparent)));
        this.tIc.tvU.setDividerHeight(0);
        this.tIc.tvU.setVerticalScrollBarEnabled(true);
        this.tIc.tvU.setHorizontalScrollBarEnabled(false);
        return true;
    }

    private boolean bdK() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }

    public final void dismiss() {
        if (isShowing()) {
            this.tIc.dismiss();
        }
    }

    private int a(ListAdapter listAdapter) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view = null;
            } else {
                itemViewType = i2;
            }
            if (this.Je == null) {
                this.Je = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view, this.Je);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public void onDismiss() {
        this.tIc = null;
        if (this.Jd != null) {
            if (!this.Jd.isAlive()) {
                this.Jd = this.eS.getViewTreeObserver();
            }
            this.Jd.removeGlobalOnLayoutListener(this);
            this.Jd = null;
        }
        if (this.uCh != null) {
            this.uCh.onCancel(null);
        }
        if (this.uCi != null) {
            this.uCi.onDismiss();
        }
    }

    public final boolean isShowing() {
        return this.tIc != null && this.tIc.eZB.isShowing();
    }

    public void onGlobalLayout() {
        x.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", new Object[]{Boolean.valueOf(isShowing()), Boolean.valueOf(this.eS.isShown())});
        if (isShowing()) {
            View view = this.eS;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing() && this.qgI != bdK()) {
                this.tIc.dismiss();
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        x.v("MicroMsg.SubMenuHelperBase", "onKey");
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        dismiss();
    }
}
