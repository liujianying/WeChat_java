package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.a.a.h;
import android.support.v7.app.b;
import android.support.v7.app.b.a.AnonymousClass1;
import android.support.v7.app.b.a.AnonymousClass2;
import android.support.v7.app.b.a.AnonymousClass3;
import android.support.v7.app.b.a.AnonymousClass4;
import android.support.v7.app.c;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import java.util.ArrayList;

public final class e implements l, OnItemClickListener {
    LayoutInflater Bc;
    int HI;
    ExpandedMenuView HX;
    private int HY;
    int HZ;
    a Ia;
    public android.support.v7.view.menu.l.a bp;
    f bq;
    Context mContext;
    private int mId;

    private class a extends BaseAdapter {
        private int Ib = -1;

        public a() {
            dF();
        }

        public final int getCount() {
            int size = e.this.bq.dP().size() - e.this.HY;
            return this.Ib < 0 ? size : size - 1;
        }

        /* renamed from: aI */
        public final h getItem(int i) {
            ArrayList dP = e.this.bq.dP();
            int a = e.this.HY + i;
            if (this.Ib >= 0 && a >= this.Ib) {
                a++;
            }
            return (h) dP.get(a);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = e.this.Bc.inflate(e.this.HI, viewGroup, false);
            } else {
                inflate = view;
            }
            ((android.support.v7.view.menu.m.a) inflate).a(getItem(i));
            return inflate;
        }

        private void dF() {
            h hVar = e.this.bq.Ix;
            if (hVar != null) {
                ArrayList dP = e.this.bq.dP();
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

    public e(Context context, int i) {
        this(i);
        this.mContext = context;
        this.Bc = LayoutInflater.from(this.mContext);
    }

    private e(int i) {
        this.HI = i;
        this.HZ = 0;
    }

    public final void a(Context context, f fVar) {
        if (this.HZ != 0) {
            this.mContext = new ContextThemeWrapper(context, this.HZ);
            this.Bc = LayoutInflater.from(this.mContext);
        } else if (this.mContext != null) {
            this.mContext = context;
            if (this.Bc == null) {
                this.Bc = LayoutInflater.from(this.mContext);
            }
        }
        this.bq = fVar;
        if (this.Ia != null) {
            this.Ia.notifyDataSetChanged();
        }
    }

    public final m e(ViewGroup viewGroup) {
        if (this.HX == null) {
            this.HX = (ExpandedMenuView) this.Bc.inflate(h.abc_expanded_menu_layout, viewGroup, false);
            if (this.Ia == null) {
                this.Ia = new a();
            }
            this.HX.setAdapter(this.Ia);
            this.HX.setOnItemClickListener(this);
        }
        return this.HX;
    }

    public final ListAdapter getAdapter() {
        if (this.Ia == null) {
            this.Ia = new a();
        }
        return this.Ia;
    }

    public final void n(boolean z) {
        if (this.Ia != null) {
            this.Ia.notifyDataSetChanged();
        }
    }

    public final boolean a(p pVar) {
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        int i;
        g gVar = new g(pVar);
        f fVar = gVar.bq;
        android.support.v7.app.c.a aVar = new android.support.v7.app.c.a(fVar.mContext);
        gVar.IA = new e(aVar.Ec.mContext, h.abc_list_menu_item_layout);
        gVar.IA.bp = gVar;
        gVar.bq.a(gVar.IA);
        aVar.Ec.Do = gVar.IA.getAdapter();
        aVar.Ec.DM = gVar;
        View view = fVar.Iq;
        if (view != null) {
            aVar.Ec.Dn = view;
        } else {
            aVar.Ec.hh = fVar.Ip;
            aVar.Ec.sn = fVar.Io;
        }
        aVar.Ec.DK = gVar;
        c cVar = new c(aVar.Ec.mContext, aVar.np);
        android.support.v7.app.b.a aVar2 = aVar.Ec;
        b a = cVar.Eb;
        if (aVar2.Dn != null) {
            a.Dn = aVar2.Dn;
        } else {
            if (aVar2.sn != null) {
                a.setTitle(aVar2.sn);
            }
            if (aVar2.hh != null) {
                Drawable drawable = aVar2.hh;
                a.hh = drawable;
                a.Dl = 0;
                if (a.ii != null) {
                    if (drawable != null) {
                        a.ii.setVisibility(0);
                        a.ii.setImageDrawable(drawable);
                    } else {
                        a.ii.setVisibility(8);
                    }
                }
            }
            if (aVar2.Dl != 0) {
                a.setIcon(aVar2.Dl);
            }
            if (aVar2.DB != 0) {
                i = aVar2.DB;
                TypedValue typedValue = new TypedValue();
                a.mContext.getTheme().resolveAttribute(i, typedValue, true);
                a.setIcon(typedValue.resourceId);
            }
        }
        if (aVar2.CT != null) {
            CharSequence charSequence = aVar2.CT;
            a.CT = charSequence;
            if (a.gH != null) {
                a.gH.setText(charSequence);
            }
        }
        if (aVar2.DC != null) {
            a.a(-1, aVar2.DC, aVar2.DD, null);
        }
        if (aVar2.DE != null) {
            a.a(-2, aVar2.DE, aVar2.DF, null);
        }
        if (aVar2.DG != null) {
            a.a(-3, aVar2.DG, aVar2.DH, null);
        }
        if (!(aVar2.DL == null && aVar2.yV == null && aVar2.Do == null)) {
            ListAdapter cVar2;
            ListView listView = (ListView) aVar2.Bc.inflate(a.Ds, null);
            Object cVar22;
            if (!aVar2.DO) {
                int i2 = aVar2.DP ? a.Du : a.Dv;
                if (aVar2.yV != null) {
                    cVar22 = new SimpleCursorAdapter(aVar2.mContext, i2, aVar2.yV, new String[]{aVar2.DR}, new int[]{16908308});
                } else {
                    cVar22 = aVar2.Do != null ? aVar2.Do : new c(aVar2.mContext, i2, aVar2.DL);
                }
            } else if (aVar2.yV == null) {
                cVar22 = new AnonymousClass1(aVar2.mContext, a.Dt, aVar2.DL, listView);
            } else {
                cVar22 = new AnonymousClass2(aVar2.mContext, aVar2.yV, listView, a);
            }
            a.Do = cVar22;
            a.Dp = aVar2.Dp;
            if (aVar2.DM != null) {
                listView.setOnItemClickListener(new AnonymousClass3(a));
            } else if (aVar2.DQ != null) {
                listView.setOnItemClickListener(new AnonymousClass4(listView, a));
            }
            if (aVar2.DT != null) {
                listView.setOnItemSelectedListener(aVar2.DT);
            }
            if (aVar2.DP) {
                listView.setChoiceMode(1);
            } else if (aVar2.DO) {
                listView.setChoiceMode(2);
            }
            a.CU = listView;
        }
        if (aVar2.mView != null) {
            if (aVar2.Da) {
                View view2 = aVar2.mView;
                int i3 = aVar2.CW;
                int i4 = aVar2.CX;
                int i5 = aVar2.CY;
                int i6 = aVar2.CZ;
                a.mView = view2;
                a.CV = 0;
                a.Da = true;
                a.CW = i3;
                a.CX = i4;
                a.CY = i5;
                a.CZ = i6;
            } else {
                a.mView = aVar2.mView;
                a.CV = 0;
                a.Da = false;
            }
        } else if (aVar2.CV != 0) {
            i = aVar2.CV;
            a.mView = null;
            a.CV = i;
            a.Da = false;
        }
        cVar.setCancelable(aVar.Ec.nq);
        if (aVar.Ec.nq) {
            cVar.setCanceledOnTouchOutside(true);
        }
        cVar.setOnCancelListener(aVar.Ec.DI);
        cVar.setOnDismissListener(aVar.Ec.DJ);
        if (aVar.Ec.DK != null) {
            cVar.setOnKeyListener(aVar.Ec.DK);
        }
        gVar.Iz = cVar;
        gVar.Iz.setOnDismissListener(gVar);
        LayoutParams attributes = gVar.Iz.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        gVar.Iz.show();
        if (this.bp != null) {
            this.bp.d(pVar);
        }
        return true;
    }

    public final void a(f fVar, boolean z) {
        if (this.bp != null) {
            this.bp.a(fVar, z);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.bq.a(this.Ia.getItem(i), (l) this, 0);
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
        return this.mId;
    }

    public final Parcelable onSaveInstanceState() {
        if (this.HX == null) {
            return null;
        }
        Parcelable bundle = new Bundle();
        SparseArray sparseArray = new SparseArray();
        if (this.HX != null) {
            this.HX.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.HX.restoreHierarchyState(sparseParcelableArray);
        }
    }
}
