package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.d;
import android.support.v4.view.m;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class f implements android.support.v4.c.a.a {
    private static final int[] Id = new int[]{1, 4, 5, 3, 2, 0};
    private boolean Ie;
    private boolean If;
    public a Ig;
    private ArrayList<h> Ih;
    private boolean Ii;
    public ArrayList<h> Ij;
    private ArrayList<h> Ik;
    private boolean Il;
    public int Im = 1;
    private ContextMenuInfo In;
    CharSequence Io;
    Drawable Ip;
    View Iq;
    private boolean Ir = false;
    private boolean Is = false;
    boolean It = false;
    private boolean Iu = false;
    private ArrayList<h> Iv = new ArrayList();
    public CopyOnWriteArrayList<WeakReference<l>> Iw = new CopyOnWriteArrayList();
    h Ix;
    public boolean Iy;
    ArrayList<h> bA;
    public final Context mContext;
    private final Resources mResources;

    public interface a {
        boolean a(f fVar, MenuItem menuItem);

        void b(f fVar);
    }

    public interface b {
        boolean f(h hVar);
    }

    public f(Context context) {
        boolean z = true;
        this.mContext = context;
        this.mResources = context.getResources();
        this.bA = new ArrayList();
        this.Ih = new ArrayList();
        this.Ii = true;
        this.Ij = new ArrayList();
        this.Ik = new ArrayList();
        this.Il = true;
        if (this.mResources.getConfiguration().keyboard == 1 || !this.mResources.getBoolean(android.support.v7.a.a.b.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            z = false;
        }
        this.If = z;
    }

    public final void a(l lVar) {
        a(lVar, this.mContext);
    }

    public final void a(l lVar, Context context) {
        this.Iw.add(new WeakReference(lVar));
        lVar.a(context, this);
        this.Il = true;
    }

    public final void b(l lVar) {
        Iterator it = this.Iw.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar2 = (l) weakReference.get();
            if (lVar2 == null || lVar2 == lVar) {
                this.Iw.remove(weakReference);
            }
        }
    }

    public final void dispatchSaveInstanceState(Bundle bundle) {
        if (!this.Iw.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.Iw.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.Iw.remove(weakReference);
                } else {
                    int id = lVar.getId();
                    if (id > 0) {
                        Parcelable onSaveInstanceState = lVar.onSaveInstanceState();
                        if (onSaveInstanceState != null) {
                            sparseArray.put(id, onSaveInstanceState);
                        }
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    public final void c(Bundle bundle) {
        SparseArray sparseArray = null;
        int size = size();
        int i = 0;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = m.a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (m.d(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((p) item.getSubMenu()).c(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(dG(), sparseArray);
        }
    }

    public final void d(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(dG());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = m.a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((p) item.getSubMenu()).d(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    m.b(item);
                }
            }
        }
    }

    protected String dG() {
        return "android:menu:actionviewstates";
    }

    public void a(a aVar) {
        this.Ig = aVar;
    }

    public final MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = (-65536 & i3) >> 16;
        if (i4 < 0 || i4 >= Id.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i5 = (Id[i4] << 16) | (65535 & i3);
        MenuItem hVar = new h(this, i, i2, i3, i5, charSequence, this.Im);
        if (this.In != null) {
            hVar.IK = this.In;
        }
        this.bA.add(b(this.bA, i5), hVar);
        p(true);
        return hVar;
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return a(0, 0, 0, this.mResources.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.mResources.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        h hVar = (h) a(i, i2, i3, charSequence);
        SubMenu pVar = new p(this.mContext, this, hVar);
        hVar.b(pVar);
        return pVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.mResources.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        int i2;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((h) this.bA.get(i3)).getItemId() == i) {
                i2 = i3;
                break;
            }
        }
        i2 = -1;
        m(i2, true);
    }

    public void removeGroup(int i) {
        int i2;
        int size = size();
        for (i2 = 0; i2 < size; i2++) {
            if (((h) this.bA.get(i2)).getGroupId() == i) {
                size = i2;
                break;
            }
        }
        size = -1;
        if (size >= 0) {
            int size2 = this.bA.size() - size;
            int i3 = 0;
            while (true) {
                i2 = i3 + 1;
                if (i3 >= size2 || ((h) this.bA.get(size)).getGroupId() != i) {
                    p(true);
                } else {
                    m(size, false);
                    i3 = i2;
                }
            }
            p(true);
        }
    }

    private void m(int i, boolean z) {
        if (i >= 0 && i < this.bA.size()) {
            this.bA.remove(i);
            if (z) {
                p(true);
            }
        }
    }

    public void clear() {
        if (this.Ix != null) {
            h(this.Ix);
        }
        this.bA.clear();
        p(true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.bA.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.bA.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.K(z2);
                hVar.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.bA.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            h hVar = (h) this.bA.get(i2);
            if (hVar.getGroupId() == i && hVar.M(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            p(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.bA.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.bA.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.Iy) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((h) this.bA.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.bA.get(i2);
            if (hVar.getItemId() == i) {
                return hVar;
            }
            if (hVar.hasSubMenu()) {
                MenuItem findItem = hVar.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int size() {
        return this.bA.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.bA.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.Ie = z;
        p(false);
    }

    boolean dH() {
        return this.Ie;
    }

    public boolean dI() {
        return this.If;
    }

    boolean b(f fVar, MenuItem menuItem) {
        return this.Ig != null && this.Ig.a(fVar, menuItem);
    }

    private static int b(ArrayList<h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((h) arrayList.get(size)).Ho <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = a(a, null, i2);
        }
        if ((i2 & 2) != 0) {
            J(true);
        }
        return z;
    }

    private void a(List<h> list, int i, KeyEvent keyEvent) {
        boolean dH = dH();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.bA.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = (h) this.bA.get(i2);
                if (hVar.hasSubMenu()) {
                    ((f) hVar.getSubMenu()).a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = dH ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (dH && alphabeticShortcut == 8 && i == 67)) && hVar.isEnabled())) {
                    list.add(hVar);
                }
            }
        }
    }

    private h a(int i, KeyEvent keyEvent) {
        List list = this.Iv;
        list.clear();
        a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (h) list.get(0);
        }
        boolean dH = dH();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) list.get(i2);
            char alphabeticShortcut = dH ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return hVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return hVar;
            }
            if (dH && alphabeticShortcut == 8 && i == 67) {
                return hVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), null, i2);
    }

    public final boolean a(MenuItem menuItem, l lVar, int i) {
        boolean z = false;
        h hVar = (h) menuItem;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        boolean z2;
        boolean dR = hVar.dR();
        d dVar = hVar.IH;
        if (dVar == null || !dVar.hasSubMenu()) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean expandActionView;
        if (hVar.dY()) {
            expandActionView = hVar.expandActionView() | dR;
            if (!expandActionView) {
                return expandActionView;
            }
            J(true);
            return expandActionView;
        } else if (hVar.hasSubMenu() || z2) {
            J(false);
            if (!hVar.hasSubMenu()) {
                hVar.b(new p(this.mContext, this, hVar));
            }
            p pVar = (p) hVar.getSubMenu();
            if (z2) {
                dVar.onPrepareSubMenu(pVar);
            }
            if (!this.Iw.isEmpty()) {
                if (lVar != null) {
                    z = lVar.a(pVar);
                }
                Iterator it = this.Iw.iterator();
                boolean z3 = z;
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    l lVar2 = (l) weakReference.get();
                    if (lVar2 == null) {
                        this.Iw.remove(weakReference);
                    } else {
                        if (z3) {
                            z = z3;
                        } else {
                            z = lVar2.a(pVar);
                        }
                        z3 = z;
                    }
                }
                z = z3;
            }
            expandActionView = dR | r2;
            if (expandActionView) {
                return expandActionView;
            }
            J(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                J(true);
            }
            return dR;
        }
    }

    public final void J(boolean z) {
        if (!this.Iu) {
            this.Iu = true;
            Iterator it = this.Iw.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.Iw.remove(weakReference);
                } else {
                    lVar.a(this, z);
                }
            }
            this.Iu = false;
        }
    }

    public void close() {
        J(true);
    }

    public void p(boolean z) {
        if (this.Ir) {
            this.Is = true;
            return;
        }
        if (z) {
            this.Ii = true;
            this.Il = true;
        }
        if (!this.Iw.isEmpty()) {
            dJ();
            Iterator it = this.Iw.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.Iw.remove(weakReference);
                } else {
                    lVar.n(z);
                }
            }
            dK();
        }
    }

    public final void dJ() {
        if (!this.Ir) {
            this.Ir = true;
            this.Is = false;
        }
    }

    public final void dK() {
        this.Ir = false;
        if (this.Is) {
            this.Is = false;
            p(true);
        }
    }

    final void dL() {
        this.Ii = true;
        p(true);
    }

    final void dM() {
        this.Il = true;
        p(true);
    }

    public final ArrayList<h> dN() {
        if (!this.Ii) {
            return this.Ih;
        }
        this.Ih.clear();
        int size = this.bA.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) this.bA.get(i);
            if (hVar.isVisible()) {
                this.Ih.add(hVar);
            }
        }
        this.Ii = false;
        this.Il = true;
        return this.Ih;
    }

    public final void dO() {
        ArrayList dN = dN();
        if (this.Il) {
            Iterator it = this.Iw.iterator();
            int i = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.Iw.remove(weakReference);
                } else {
                    i = lVar.N() | i;
                }
            }
            if (i != 0) {
                this.Ij.clear();
                this.Ik.clear();
                i = dN.size();
                for (int i2 = 0; i2 < i; i2++) {
                    h hVar = (h) dN.get(i2);
                    if (hVar.dV()) {
                        this.Ij.add(hVar);
                    } else {
                        this.Ik.add(hVar);
                    }
                }
            } else {
                this.Ij.clear();
                this.Ik.clear();
                this.Ik.addAll(dN());
            }
            this.Il = false;
        }
    }

    public final ArrayList<h> dP() {
        dO();
        return this.Ik;
    }

    public void clearHeader() {
        this.Ip = null;
        this.Io = null;
        this.Iq = null;
        p(false);
    }

    final void a(CharSequence charSequence, Drawable drawable, View view) {
        if (view != null) {
            this.Iq = view;
            this.Io = null;
            this.Ip = null;
        } else {
            if (charSequence != null) {
                this.Io = charSequence;
            }
            if (drawable != null) {
                this.Ip = drawable;
            }
            this.Iq = null;
        }
        p(false);
    }

    protected final f g(CharSequence charSequence) {
        a(charSequence, null, null);
        return this;
    }

    protected final f k(Drawable drawable) {
        a(null, drawable, null);
        return this;
    }

    public f dQ() {
        return this;
    }

    public boolean g(h hVar) {
        boolean z = false;
        if (!this.Iw.isEmpty()) {
            dJ();
            Iterator it = this.Iw.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.Iw.remove(weakReference);
                } else {
                    z = lVar.b(hVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            dK();
            if (z) {
                this.Ix = hVar;
            }
        }
        return z;
    }

    public boolean h(h hVar) {
        boolean z = false;
        if (!this.Iw.isEmpty() && this.Ix == hVar) {
            dJ();
            Iterator it = this.Iw.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.Iw.remove(weakReference);
                } else {
                    z = lVar.c(hVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            dK();
            if (z) {
                this.Ix = null;
            }
        }
        return z;
    }
}
