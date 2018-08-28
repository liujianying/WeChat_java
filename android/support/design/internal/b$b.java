package android.support.design.internal;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.internal.b.c;
import android.support.design.internal.b.d;
import android.support.design.internal.b.e;
import android.support.design.internal.b.f;
import android.support.design.internal.b.g;
import android.support.design.internal.b.j;
import android.support.v7.view.menu.h;
import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.util.SparseArray;
import android.view.SubMenu;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

class b$b extends RecyclerView$a<j> {
    final ArrayList<d> bA = new ArrayList();
    private h bB;
    private ColorDrawable bC;
    boolean bD;
    final /* synthetic */ b bz;

    public final /* synthetic */ void a(t tVar) {
        j jVar = (j) tVar;
        if (jVar instanceof g) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.SU;
            if (navigationMenuItemView.bk != null) {
                navigationMenuItemView.bk.removeAllViews();
            }
            navigationMenuItemView.bj.setCompoundDrawables(null, null, null, null);
        }
    }

    public b$b(b bVar) {
        this.bz = bVar;
        O();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemCount() {
        return this.bA.size();
    }

    public final int getItemViewType(int i) {
        d dVar = (d) this.bA.get(i);
        if (dVar instanceof e) {
            return 2;
        }
        if (dVar instanceof c) {
            return 3;
        }
        if (!(dVar instanceof f)) {
            throw new RuntimeException("Unknown item type.");
        } else if (((f) dVar).bG.hasSubMenu()) {
            return 1;
        } else {
            return 0;
        }
    }

    final void O() {
        if (!this.bD) {
            this.bD = true;
            this.bA.clear();
            this.bA.add(new c((byte) 0));
            int i = -1;
            int i2 = 0;
            Object obj = null;
            int size = this.bz.bq.dN().size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2;
                int i4;
                h hVar = (h) this.bz.bq.dN().get(i3);
                if (hVar.isChecked()) {
                    d(hVar);
                }
                if (hVar.isCheckable()) {
                    hVar.K(false);
                }
                int i5;
                if (hVar.hasSubMenu()) {
                    SubMenu subMenu = hVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i3 != 0) {
                            this.bA.add(new e(this.bz.by, 0));
                        }
                        this.bA.add(new f(hVar, (byte) 0));
                        Object obj3 = null;
                        int size2 = this.bA.size();
                        int size3 = subMenu.size();
                        for (i5 = 0; i5 < size3; i5++) {
                            h hVar2 = (h) subMenu.getItem(i5);
                            if (hVar2.isVisible()) {
                                if (obj3 == null && hVar2.getIcon() != null) {
                                    obj3 = 1;
                                }
                                if (hVar2.isCheckable()) {
                                    hVar2.K(false);
                                }
                                if (hVar.isChecked()) {
                                    d(hVar);
                                }
                                this.bA.add(new f(hVar2, (byte) 0));
                            }
                        }
                        if (obj3 != null) {
                            f(size2, this.bA.size());
                        }
                    }
                    obj2 = obj;
                    i4 = i2;
                } else {
                    Object obj4;
                    i5 = hVar.getGroupId();
                    if (i5 != i) {
                        i2 = this.bA.size();
                        obj = hVar.getIcon() != null ? 1 : null;
                        if (i3 != 0) {
                            i2++;
                            this.bA.add(new e(this.bz.by, this.bz.by));
                            obj4 = obj;
                            i4 = i2;
                        }
                        obj4 = obj;
                        i4 = i2;
                    } else {
                        if (obj == null && hVar.getIcon() != null) {
                            obj = 1;
                            f(i2, this.bA.size());
                        }
                        obj4 = obj;
                        i4 = i2;
                    }
                    if (obj4 != null && hVar.getIcon() == null) {
                        hVar.setIcon(17170445);
                    }
                    this.bA.add(new f(hVar, (byte) 0));
                    obj2 = obj4;
                    i = i5;
                }
                i3++;
                obj = obj2;
                i2 = i4;
            }
            this.bD = false;
        }
    }

    private void f(int i, int i2) {
        while (i < i2) {
            h hVar = ((f) this.bA.get(i)).bG;
            if (hVar.getIcon() == null) {
                if (this.bC == null) {
                    this.bC = new ColorDrawable(0);
                }
                hVar.setIcon(this.bC);
            }
            i++;
        }
    }

    public final void d(h hVar) {
        if (this.bB != hVar && hVar.isCheckable()) {
            if (this.bB != null) {
                this.bB.setChecked(false);
            }
            this.bB = hVar;
            hVar.setChecked(true);
        }
    }

    public final Bundle P() {
        Bundle bundle = new Bundle();
        if (this.bB != null) {
            bundle.putInt("android:menu:checked", this.bB.getItemId());
        }
        SparseArray sparseArray = new SparseArray();
        Iterator it = this.bA.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar instanceof f) {
                h hVar = ((f) dVar).bG;
                View actionView = hVar != null ? hVar.getActionView() : null;
                if (actionView != null) {
                    ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                    actionView.saveHierarchyState(parcelableSparseArray);
                    sparseArray.put(hVar.getItemId(), parcelableSparseArray);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
        return bundle;
    }
}
