package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ae;
import android.support.v7.a.a.g;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.k;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.p;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

final class ActionMenuPresenter extends android.support.v7.view.menu.b implements android.support.v4.view.d.a {
    private int KA;
    private final SparseBooleanArray KB = new SparseBooleanArray();
    private View KC;
    e KD;
    a KE;
    c KF;
    private b KG;
    final f KH = new f(this, (byte) 0);
    int KI;
    d Ko;
    Drawable Kp;
    boolean Kq;
    private boolean Kr;
    private boolean Ks;
    private int Kt;
    private int Ku;
    int Kv;
    boolean Kw;
    private boolean Kx;
    private boolean Ky;
    boolean Kz;

    private static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int KO;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.KO = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.KO);
        }
    }

    private class c implements Runnable {
        private e KK;

        public c(e eVar) {
            this.KK = eVar;
        }

        public final void run() {
            android.support.v7.view.menu.f fVar = ActionMenuPresenter.this.bq;
            if (fVar.Ig != null) {
                fVar.Ig.b(fVar);
            }
            View view = (View) ActionMenuPresenter.this.HJ;
            if (!(view == null || view.getWindowToken() == null || !this.KK.dZ())) {
                ActionMenuPresenter.this.KD = this.KK;
            }
            ActionMenuPresenter.this.KF = null;
        }
    }

    private class b extends android.support.v7.view.menu.ActionMenuItemView.b {
        private b() {
        }

        /* synthetic */ b(ActionMenuPresenter actionMenuPresenter, byte b) {
            this();
        }

        public final ListPopupWindow dB() {
            return ActionMenuPresenter.this.KE != null ? ActionMenuPresenter.this.KE.Jc : null;
        }
    }

    private class f implements android.support.v7.view.menu.l.a {
        private f() {
        }

        /* synthetic */ f(ActionMenuPresenter actionMenuPresenter, byte b) {
            this();
        }

        public final boolean d(android.support.v7.view.menu.f fVar) {
            if (fVar == null) {
                return false;
            }
            ActionMenuPresenter.this.KI = ((p) fVar).getItem().getItemId();
            android.support.v7.view.menu.l.a aVar = ActionMenuPresenter.this.bp;
            return aVar != null ? aVar.d(fVar) : false;
        }

        public final void a(android.support.v7.view.menu.f fVar, boolean z) {
            if (fVar instanceof p) {
                ((p) fVar).Jk.J(false);
            }
            android.support.v7.view.menu.l.a aVar = ActionMenuPresenter.this.bp;
            if (aVar != null) {
                aVar.a(fVar, z);
            }
        }
    }

    private class a extends k {
        private p IC;
        final /* synthetic */ ActionMenuPresenter KJ;

        public a(ActionMenuPresenter actionMenuPresenter, Context context, p pVar) {
            boolean z = false;
            this.KJ = actionMenuPresenter;
            super(context, pVar, null, false, android.support.v7.a.a.a.actionOverflowMenuStyle);
            this.IC = pVar;
            if (!((h) pVar.getItem()).dV()) {
                this.eS = actionMenuPresenter.Ko == null ? (View) actionMenuPresenter.HJ : actionMenuPresenter.Ko;
            }
            this.IB = actionMenuPresenter.KH;
            int size = pVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = pVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            this.HW = z;
        }

        public final void onDismiss() {
            super.onDismiss();
            this.KJ.KE = null;
            this.KJ.KI = 0;
        }
    }

    private class d extends AppCompatImageView implements android.support.v7.widget.ActionMenuView.a {
        private final float[] KL = new float[2];

        public d(Context context) {
            super(context, null, android.support.v7.a.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new android.support.v7.widget.ListPopupWindow.b(this, ActionMenuPresenter.this) {
                public final ListPopupWindow dB() {
                    if (ActionMenuPresenter.this.KD == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.KD.Jc;
                }

                public final boolean dC() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                public final boolean em() {
                    if (ActionMenuPresenter.this.KF != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.hideOverflowMenu();
                    return true;
                }
            });
        }

        public final boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.showOverflowMenu();
            }
            return true;
        }

        public final boolean dz() {
            return false;
        }

        public final boolean dA() {
            return false;
        }

        protected final boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.b.a.a.a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    private class e extends k {
        public e(Context context, android.support.v7.view.menu.f fVar, View view) {
            super(context, fVar, view, true, android.support.v7.a.a.a.actionOverflowMenuStyle);
            this.IB = ActionMenuPresenter.this.KH;
        }

        public final void onDismiss() {
            super.onDismiss();
            if (ActionMenuPresenter.this.bq != null) {
                ActionMenuPresenter.this.bq.close();
            }
            ActionMenuPresenter.this.KD = null;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, android.support.v7.a.a.h.abc_action_menu_layout, android.support.v7.a.a.h.abc_action_menu_item_layout);
    }

    public final void a(Context context, android.support.v7.view.menu.f fVar) {
        boolean z = true;
        super.a(context, fVar);
        Resources resources = context.getResources();
        android.support.v7.view.a R = android.support.v7.view.a.R(context);
        if (!this.Ks) {
            if (VERSION.SDK_INT < 19 && ae.b(ViewConfiguration.get(R.mContext))) {
                z = false;
            }
            this.Kr = z;
        }
        if (!this.Ky) {
            this.Kt = R.mContext.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.Kw) {
            this.Kv = R.mContext.getResources().getInteger(g.abc_max_action_buttons);
        }
        int i = this.Kt;
        if (this.Kr) {
            if (this.Ko == null) {
                this.Ko = new d(this.HF);
                if (this.Kq) {
                    this.Ko.setImageDrawable(this.Kp);
                    this.Kp = null;
                    this.Kq = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.Ko.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.Ko.getMeasuredWidth();
        } else {
            this.Ko = null;
        }
        this.Ku = i;
        this.KA = (int) (56.0f * resources.getDisplayMetrics().density);
        this.KC = null;
    }

    public final void ej() {
        this.Kr = true;
        this.Ks = true;
    }

    public final m e(ViewGroup viewGroup) {
        m e = super.e(viewGroup);
        ((ActionMenuView) e).setPresenter(this);
        return e;
    }

    public final View a(h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.dY()) {
            actionView = super.a(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.c(layoutParams));
        }
        return actionView;
    }

    public final void a(h hVar, android.support.v7.view.menu.m.a aVar) {
        aVar.a(hVar);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.HJ);
        if (this.KG == null) {
            this.KG = new b(this, (byte) 0);
        }
        actionMenuItemView.setPopupCallback(this.KG);
    }

    public final boolean e(h hVar) {
        return hVar.dV();
    }

    public final void n(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ((View) this.HJ).getParent();
        super.n(z);
        ((View) this.HJ).requestLayout();
        if (this.bq != null) {
            android.support.v7.view.menu.f fVar = this.bq;
            fVar.dO();
            ArrayList arrayList = fVar.Ij;
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                android.support.v4.view.d dVar = ((h) arrayList.get(i)).IH;
                if (dVar != null) {
                    dVar.ud = this;
                }
            }
        }
        ArrayList dP = this.bq != null ? this.bq.dP() : null;
        if (this.Kr && dP != null) {
            i = dP.size();
            if (i == 1) {
                int i4;
                if (((h) dP.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.Ko == null) {
                this.Ko = new d(this.HF);
            }
            ViewGroup viewGroup = (ViewGroup) this.Ko.getParent();
            if (viewGroup != this.HJ) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.Ko);
                }
                ((ActionMenuView) this.HJ).addView(this.Ko, ActionMenuView.eo());
            }
        } else if (this.Ko != null && this.Ko.getParent() == this.HJ) {
            ((ViewGroup) this.HJ).removeView(this.Ko);
        }
        ((ActionMenuView) this.HJ).setOverflowReserved(this.Kr);
    }

    public final boolean c(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.Ko) {
            return false;
        }
        return super.c(viewGroup, i);
    }

    public final boolean a(p pVar) {
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        View view;
        p pVar2 = pVar;
        while (pVar2.Jk != this.bq) {
            pVar2 = (p) pVar2.Jk;
        }
        h item = pVar2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.HJ;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof android.support.v7.view.menu.m.a) && ((android.support.v7.view.menu.m.a) childAt).getItemData() == item) {
                    view = childAt;
                    break;
                }
            }
        }
        view = null;
        if (view == null) {
            if (this.Ko == null) {
                return false;
            }
            view = this.Ko;
        }
        this.KI = pVar.getItem().getItemId();
        this.KE = new a(this, this.mContext, pVar);
        this.KE.eS = view;
        if (this.KE.dZ()) {
            super.a(pVar);
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public final boolean showOverflowMenu() {
        if (!this.Kr || isOverflowMenuShowing() || this.bq == null || this.HJ == null || this.KF != null || this.bq.dP().isEmpty()) {
            return false;
        }
        this.KF = new c(new e(this.mContext, this.bq, this.Ko));
        ((View) this.HJ).post(this.KF);
        super.a(null);
        return true;
    }

    public final boolean hideOverflowMenu() {
        if (this.KF == null || this.HJ == null) {
            k kVar = this.KD;
            if (kVar == null) {
                return false;
            }
            kVar.dismiss();
            return true;
        }
        ((View) this.HJ).removeCallbacks(this.KF);
        this.KF = null;
        return true;
    }

    public final boolean ek() {
        return hideOverflowMenu() | el();
    }

    public final boolean el() {
        if (this.KE == null) {
            return false;
        }
        this.KE.dismiss();
        return true;
    }

    public final boolean isOverflowMenuShowing() {
        return this.KD != null && this.KD.isShowing();
    }

    public final boolean N() {
        h hVar;
        int i;
        ArrayList dN = this.bq.dN();
        int size = dN.size();
        int i2 = this.Kv;
        int i3 = this.Ku;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.HJ;
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int i6 = 0;
        while (i6 < size) {
            hVar = (h) dN.get(i6);
            if (hVar.dX()) {
                i4++;
            } else if (hVar.dW()) {
                i5++;
            } else {
                obj = 1;
            }
            if (this.Kz && hVar.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i2;
            }
            i6++;
            i2 = i;
        }
        if (this.Kr && (obj != null || i4 + i5 > i2)) {
            i2--;
        }
        i6 = i2 - i4;
        SparseBooleanArray sparseBooleanArray = this.KB;
        sparseBooleanArray.clear();
        int i7 = 0;
        if (this.Kx) {
            i7 = i3 / this.KA;
            i5 = ((i3 % this.KA) / i7) + this.KA;
        } else {
            i5 = 0;
        }
        i2 = 0;
        int i8 = 0;
        i4 = i7;
        while (i8 < size) {
            h hVar2 = (h) dN.get(i8);
            View a;
            int i9;
            if (hVar2.dX()) {
                a = a(hVar2, this.KC, viewGroup);
                if (this.KC == null) {
                    this.KC = a;
                }
                if (this.Kx) {
                    i = i4 - ActionMenuView.d(a, i5, i4, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                    i = i4;
                }
                i4 = a.getMeasuredWidth();
                i9 = i3 - i4;
                if (i2 != 0) {
                    i4 = i2;
                }
                i2 = hVar2.getGroupId();
                if (i2 != 0) {
                    sparseBooleanArray.put(i2, true);
                }
                hVar2.N(true);
                i2 = i4;
                i7 = i;
                i3 = i9;
            } else if (hVar2.dW()) {
                boolean z;
                int groupId = hVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i6 > 0 || z2) && i3 > 0 && (!this.Kx || i4 > 0);
                if (z3) {
                    a = a(hVar2, this.KC, viewGroup);
                    if (this.KC == null) {
                        this.KC = a;
                    }
                    if (this.Kx) {
                        int d = ActionMenuView.d(a, i5, i4, makeMeasureSpec, 0);
                        i4 -= d;
                        if (d == 0) {
                            i = 0;
                        }
                    } else {
                        a.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    i9 = a.getMeasuredWidth();
                    i3 -= i9;
                    if (i2 == 0) {
                        i2 = i9;
                    }
                    if (this.Kx) {
                        z = i & (i3 >= 0 ? 1 : 0);
                        i9 = i4;
                    } else {
                        z = i & (i3 + i2 > 0 ? 1 : 0);
                        i9 = i4;
                    }
                } else {
                    z = z3;
                    i9 = i4;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i = i6;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i4 = i6;
                    for (int i10 = 0; i10 < i8; i10++) {
                        hVar = (h) dN.get(i10);
                        if (hVar.getGroupId() == groupId) {
                            if (hVar.dV()) {
                                i4++;
                            }
                            hVar.N(false);
                        }
                    }
                    i = i4;
                } else {
                    i = i6;
                }
                if (z) {
                    i--;
                }
                hVar2.N(z);
                i7 = i9;
                i6 = i;
            } else {
                hVar2.N(false);
                i7 = i4;
            }
            i8++;
            i4 = i7;
        }
        return true;
    }

    public final void a(android.support.v7.view.menu.f fVar, boolean z) {
        ek();
        super.a(fVar, z);
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState();
        savedState.KO = this.KI;
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.KO > 0) {
                MenuItem findItem = this.bq.findItem(savedState.KO);
                if (findItem != null) {
                    a((p) findItem.getSubMenu());
                }
            }
        }
    }

    public final void w(boolean z) {
        if (z) {
            super.a(null);
        } else {
            this.bq.J(false);
        }
    }

    public final void a(ActionMenuView actionMenuView) {
        this.HJ = actionMenuView;
        actionMenuView.bq = this.bq;
    }
}
