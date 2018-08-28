package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.a.a.d;
import android.support.v7.a.a.h;
import android.support.v7.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
import java.util.ArrayList;

public class k implements l, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int IW = h.abc_popup_menu_item_layout;
    private final LayoutInflater Bc;
    public boolean HW;
    public android.support.v7.view.menu.l.a IB;
    private final a IX;
    private final boolean IY;
    private final int IZ;
    private final int Ja;
    private final int Jb;
    public ListPopupWindow Jc;
    private ViewTreeObserver Jd;
    private ViewGroup Je;
    private boolean Jf;
    private int Jg;
    public int Jh = 8388613;
    private final f bq;
    public View eS;
    private final Context mContext;

    private class a extends BaseAdapter {
        private int Ib = -1;
        private f Ji;

        public a(f fVar) {
            this.Ji = fVar;
            dF();
        }

        public final int getCount() {
            ArrayList dP = k.this.IY ? this.Ji.dP() : this.Ji.dN();
            if (this.Ib < 0) {
                return dP.size();
            }
            return dP.size() - 1;
        }

        /* renamed from: aI */
        public final h getItem(int i) {
            ArrayList dP = k.this.IY ? this.Ji.dP() : this.Ji.dN();
            if (this.Ib >= 0 && i >= this.Ib) {
                i++;
            }
            return (h) dP.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = k.this.Bc.inflate(k.IW, viewGroup, false);
            } else {
                inflate = view;
            }
            android.support.v7.view.menu.m.a aVar = (android.support.v7.view.menu.m.a) inflate;
            if (k.this.HW) {
                ((ListMenuItemView) inflate).setForceShowIcon(true);
            }
            aVar.a(getItem(i));
            return inflate;
        }

        private void dF() {
            h hVar = k.this.bq.Ix;
            if (hVar != null) {
                ArrayList dP = k.this.bq.dP();
                int size = dP.size();
                for (int i = 0; i < size; i++) {
                    if (((h) dP.get(i)) == hVar) {
                        this.Ib = i;
                        return;
                    }
                }
            }
            this.Ib = -1;
        }

        public final void notifyDataSetChanged() {
            dF();
            super.notifyDataSetChanged();
        }
    }

    private k(Context context, f fVar, View view) {
        this(context, fVar, view, false, android.support.v7.a.a.a.popupMenuStyle);
    }

    public k(Context context, f fVar, View view, boolean z, int i) {
        this(context, fVar, view, z, i, (byte) 0);
    }

    private k(Context context, f fVar, View view, boolean z, int i, byte b) {
        this.Jh = 0;
        this.mContext = context;
        this.Bc = LayoutInflater.from(context);
        this.bq = fVar;
        this.IX = new a(this.bq);
        this.IY = z;
        this.Ja = i;
        this.Jb = 0;
        Resources resources = context.getResources();
        this.IZ = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.eS = view;
        fVar.a((l) this, context);
    }

    public final boolean dZ() {
        this.Jc = new ListPopupWindow(this.mContext, null, this.Ja, this.Jb);
        this.Jc.setOnDismissListener(this);
        this.Jc.PY = this;
        this.Jc.setAdapter(this.IX);
        this.Jc.setModal(true);
        View view = this.eS;
        if (view == null) {
            return false;
        }
        boolean z = this.Jd == null;
        this.Jd = view.getViewTreeObserver();
        if (z) {
            this.Jd.addOnGlobalLayoutListener(this);
        }
        this.Jc.PW = view;
        this.Jc.Jh = this.Jh;
        if (!this.Jf) {
            ListAdapter listAdapter = this.IX;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = listAdapter.getCount();
            int i = 0;
            int i2 = 0;
            View view2 = null;
            int i3 = 0;
            while (i < count) {
                int i4;
                int itemViewType = listAdapter.getItemViewType(i);
                if (itemViewType != i2) {
                    i4 = itemViewType;
                    view2 = null;
                } else {
                    i4 = i2;
                }
                if (this.Je == null) {
                    this.Je = new FrameLayout(this.mContext);
                }
                view2 = listAdapter.getView(i, view2, this.Je);
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                itemViewType = view2.getMeasuredWidth();
                if (itemViewType >= this.IZ) {
                    i3 = this.IZ;
                    break;
                }
                if (itemViewType <= i3) {
                    itemViewType = i3;
                }
                i++;
                i2 = i4;
                i3 = itemViewType;
            }
            this.Jg = i3;
            this.Jf = true;
        }
        this.Jc.setContentWidth(this.Jg);
        this.Jc.fo();
        this.Jc.show();
        this.Jc.PL.setOnKeyListener(this);
        return true;
    }

    public final void dismiss() {
        if (isShowing()) {
            this.Jc.dismiss();
        }
    }

    public void onDismiss() {
        this.Jc = null;
        this.bq.close();
        if (this.Jd != null) {
            if (!this.Jd.isAlive()) {
                this.Jd = this.eS.getViewTreeObserver();
            }
            this.Jd.removeGlobalOnLayoutListener(this);
            this.Jd = null;
        }
    }

    public final boolean isShowing() {
        return this.Jc != null && this.Jc.PK.isShowing();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar = this.IX;
        aVar.Ji.a(aVar.getItem(i), null, 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.eS;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing()) {
                this.Jc.show();
            }
        }
    }

    public final void a(Context context, f fVar) {
    }

    public final void n(boolean z) {
        this.Jf = false;
        if (this.IX != null) {
            this.IX.notifyDataSetChanged();
        }
    }

    public final boolean a(p pVar) {
        if (pVar.hasVisibleItems()) {
            boolean z;
            k kVar = new k(this.mContext, pVar, this.eS);
            kVar.IB = this.IB;
            int size = pVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = pVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            kVar.HW = z;
            if (kVar.dZ()) {
                if (this.IB == null) {
                    return true;
                }
                this.IB.d(pVar);
                return true;
            }
        }
        return false;
    }

    public final void a(f fVar, boolean z) {
        if (fVar == this.bq) {
            dismiss();
            if (this.IB != null) {
                this.IB.a(fVar, z);
            }
        }
    }

    public final boolean N() {
        return false;
    }

    public final boolean b(h hVar) {
        return false;
    }

    public final boolean c(h hVar) {
        return false;
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
