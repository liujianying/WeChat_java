package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.r.AnonymousClass4;
import android.support.v4.e.d;
import android.support.v4.e.g;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.wcdb.FileUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class e extends q implements Runnable {
    static final boolean mw = (VERSION.SDK_INT >= 21);
    int mA;
    int mB;
    int mC;
    int mD;
    int mE;
    int mF;
    int mG;
    boolean mH;
    boolean mI = true;
    int mIndex = -1;
    boolean mJ;
    int mK;
    CharSequence mL;
    int mM;
    CharSequence mN;
    String mName;
    ArrayList<String> mO;
    ArrayList<String> mP;
    final n mx;
    a my;
    a mz;

    static final class a {
        a na;
        a nb;
        int nc;
        Fragment nd;
        int ne;
        int nf;
        int ng;
        int nh;
        ArrayList<Fragment> ni;

        a() {
        }
    }

    public class b {
        public android.support.v4.e.a<String, String> nj = new android.support.v4.e.a();
        public ArrayList<View> nk = new ArrayList();
        public android.support.v4.app.r.a nl = new android.support.v4.app.r.a();
        public View nm;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mName != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mName);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public final void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mJ);
            if (this.mF != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mF));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.mG));
            }
            if (!(this.mB == 0 && this.mC == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mB));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mC));
            }
            if (!(this.mD == 0 && this.mE == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mD));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mE));
            }
            if (!(this.mK == 0 && this.mL == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mK));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mL);
            }
            if (!(this.mM == 0 && this.mN == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mM));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mN);
            }
        }
        if (this.my != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            a aVar = this.my;
            while (aVar != null) {
                String str3;
                switch (aVar.nc) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + aVar.nc;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(aVar.nd);
                if (z) {
                    if (!(aVar.ne == 0 && aVar.nf == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.ne));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.nf));
                    }
                    if (!(aVar.ng == 0 && aVar.nh == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.ng));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.nh));
                    }
                }
                if (aVar.ni != null && aVar.ni.size() > 0) {
                    for (int i2 = 0; i2 < aVar.ni.size(); i2++) {
                        printWriter.print(str2);
                        if (aVar.ni.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(aVar.ni.get(i2));
                    }
                }
                aVar = aVar.na;
                i++;
            }
        }
    }

    public e(n nVar) {
        this.mx = nVar;
    }

    final void a(a aVar) {
        if (this.my == null) {
            this.mz = aVar;
            this.my = aVar;
        } else {
            aVar.nb = this.mz;
            this.mz.na = aVar;
            this.mz = aVar;
        }
        aVar.ne = this.mB;
        aVar.nf = this.mC;
        aVar.ng = this.mD;
        aVar.nh = this.mE;
        this.mA++;
    }

    public final q a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public final q a(int i, Fragment fragment) {
        a(i, fragment, null, 1);
        return this;
    }

    public final q a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        fragment.mFragmentManager = this.mx;
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.mFragmentId == 0 || fragment.mFragmentId == i) {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
        }
        a aVar = new a();
        aVar.nc = i2;
        aVar.nd = fragment;
        a(aVar);
    }

    public final q b(int i, Fragment fragment) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, null, 2);
        return this;
    }

    public final q a(Fragment fragment) {
        a aVar = new a();
        aVar.nc = 3;
        aVar.nd = fragment;
        a(aVar);
        return this;
    }

    public final q b(Fragment fragment) {
        a aVar = new a();
        aVar.nc = 5;
        aVar.nd = fragment;
        a(aVar);
        return this;
    }

    public final q c(Fragment fragment) {
        a aVar = new a();
        aVar.nc = 6;
        aVar.nd = fragment;
        a(aVar);
        return this;
    }

    public final q d(Fragment fragment) {
        a aVar = new a();
        aVar.nc = 7;
        aVar.nd = fragment;
        a(aVar);
        return this;
    }

    public final q l(int i, int i2) {
        this.mB = i;
        this.mC = i2;
        this.mD = 0;
        this.mE = 0;
        return this;
    }

    public final q G(String str) {
        if (this.mI) {
            this.mH = true;
            this.mName = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    final void Q(int i) {
        if (this.mH) {
            if (n.DEBUG) {
                new StringBuilder("Bump nesting in ").append(this).append(" by ").append(i);
            }
            for (a aVar = this.my; aVar != null; aVar = aVar.na) {
                Fragment fragment;
                if (aVar.nd != null) {
                    fragment = aVar.nd;
                    fragment.mBackStackNesting += i;
                    if (n.DEBUG) {
                        new StringBuilder("Bump nesting of ").append(aVar.nd).append(" to ").append(aVar.nd.mBackStackNesting);
                    }
                }
                if (aVar.ni != null) {
                    for (int size = aVar.ni.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) aVar.ni.get(size);
                        fragment.mBackStackNesting += i;
                        if (n.DEBUG) {
                            new StringBuilder("Bump nesting of ").append(fragment).append(" to ").append(fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    public final int commit() {
        return t(false);
    }

    public final int commitAllowingStateLoss() {
        return t(true);
    }

    private int t(boolean z) {
        if (this.mJ) {
            throw new IllegalStateException("commit already called");
        }
        if (n.DEBUG) {
            new StringBuilder("Commit: ").append(this);
            a("  ", new PrintWriter(new d("FragmentManager")));
        }
        this.mJ = true;
        if (this.mH) {
            this.mIndex = this.mx.a(this);
        } else {
            this.mIndex = -1;
        }
        this.mx.a((Runnable) this, z);
        return this.mIndex;
    }

    public final void run() {
        if (n.DEBUG) {
            new StringBuilder("Run: ").append(this);
        }
        if (!this.mH || this.mIndex >= 0) {
            b a;
            Q(1);
            if (!mw || this.mx.nS <= 0) {
                Object a2 = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                a(sparseArray, sparseArray2);
                a2 = a(sparseArray, sparseArray2, false);
            }
            int i = a2 != null ? 0 : this.mG;
            int i2 = a2 != null ? 0 : this.mF;
            a aVar = this.my;
            while (aVar != null) {
                int i3 = a2 != null ? 0 : aVar.ne;
                int i4 = a2 != null ? 0 : aVar.nf;
                Fragment fragment;
                switch (aVar.nc) {
                    case 1:
                        fragment = aVar.nd;
                        fragment.mNextAnim = i3;
                        this.mx.a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = aVar.nd;
                        int i5 = fragment2.mContainerId;
                        if (this.mx.nL != null) {
                            int size = this.mx.nL.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.mx.nL.get(size);
                                if (n.DEBUG) {
                                    new StringBuilder("OP_REPLACE: adding=").append(fragment2).append(" old=").append(fragment);
                                }
                                if (fragment.mContainerId == i5) {
                                    if (fragment == fragment2) {
                                        aVar.nd = null;
                                        fragment = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (aVar.ni == null) {
                                            aVar.ni = new ArrayList();
                                        }
                                        aVar.ni.add(fragment);
                                        fragment.mNextAnim = i4;
                                        if (this.mH) {
                                            fragment.mBackStackNesting++;
                                            if (n.DEBUG) {
                                                new StringBuilder("Bump nesting of ").append(fragment).append(" to ").append(fragment.mBackStackNesting);
                                            }
                                        }
                                        this.mx.a(fragment, i2, i);
                                    }
                                }
                                fragment = fragment2;
                                size--;
                                fragment2 = fragment;
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.mNextAnim = i3;
                        this.mx.a(fragment2, false);
                        break;
                    case 3:
                        fragment = aVar.nd;
                        fragment.mNextAnim = i4;
                        this.mx.a(fragment, i2, i);
                        break;
                    case 4:
                        fragment = aVar.nd;
                        fragment.mNextAnim = i4;
                        this.mx.b(fragment, i2, i);
                        break;
                    case 5:
                        fragment = aVar.nd;
                        fragment.mNextAnim = i3;
                        this.mx.c(fragment, i2, i);
                        break;
                    case 6:
                        fragment = aVar.nd;
                        fragment.mNextAnim = i4;
                        this.mx.d(fragment, i2, i);
                        break;
                    case 7:
                        fragment = aVar.nd;
                        fragment.mNextAnim = i3;
                        this.mx.e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.nc);
                }
                aVar = aVar.na;
            }
            this.mx.a(this.mx.nS, i2, i, true);
            if (this.mH) {
                n nVar = this.mx;
                if (nVar.nN == null) {
                    nVar.nN = new ArrayList();
                }
                nVar.nN.add(this);
                nVar.bn();
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0 && !fragment.isHidden()) {
                if (fragment.isAdded() && fragment.getView() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, fragment);
                }
                if (sparseArray2.get(i) == fragment) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0) {
                if (!fragment.isAdded()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
            if (fragment.mState <= 0 && this.mx.nS > 0) {
                this.mx.h(fragment);
                this.mx.a(fragment, 1, 0, 0, false);
            }
        }
    }

    private void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.mx.nT.onHasView()) {
            for (a aVar = this.my; aVar != null; aVar = aVar.na) {
                switch (aVar.nc) {
                    case 1:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    case 2:
                        Fragment fragment = aVar.nd;
                        if (this.mx.nL != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 < this.mx.nL.size()) {
                                    Fragment fragment2 = (Fragment) this.mx.nL.get(i2);
                                    if (fragment == null || fragment2.mContainerId == fragment.mContainerId) {
                                        if (fragment2 == fragment) {
                                            fragment = null;
                                            sparseArray2.remove(fragment2.mContainerId);
                                        } else {
                                            a((SparseArray) sparseArray, (SparseArray) sparseArray2, fragment2);
                                        }
                                    }
                                    i = i2 + 1;
                                }
                            }
                        }
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    case 3:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    case 4:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    case 5:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    case 6:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    case 7:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.mx.nT.onHasView()) {
            for (a aVar = this.mz; aVar != null; aVar = aVar.nb) {
                switch (aVar.nc) {
                    case 1:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    case 2:
                        if (aVar.ni != null) {
                            for (int size = aVar.ni.size() - 1; size >= 0; size--) {
                                b((SparseArray) sparseArray, (SparseArray) sparseArray2, (Fragment) aVar.ni.get(size));
                            }
                        }
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    case 3:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    case 4:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    case 5:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    case 6:
                        b((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    case 7:
                        a((SparseArray) sparseArray, (SparseArray) sparseArray2, aVar.nd);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final b a(boolean z, b bVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        int i;
        if (n.DEBUG) {
            new StringBuilder("popFromBackStack: ").append(this);
            a("  ", new PrintWriter(new d("FragmentManager")));
        }
        if (mw && this.mx.nS > 0) {
            if (bVar == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    bVar = a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                a(bVar, this.mP, this.mO);
            }
        }
        Q(-1);
        int i2 = bVar != null ? 0 : this.mG;
        int i3 = bVar != null ? 0 : this.mF;
        a aVar = this.mz;
        while (aVar != null) {
            int i4 = bVar != null ? 0 : aVar.ng;
            i = bVar != null ? 0 : aVar.nh;
            Fragment fragment;
            Fragment fragment2;
            switch (aVar.nc) {
                case 1:
                    fragment = aVar.nd;
                    fragment.mNextAnim = i;
                    this.mx.a(fragment, n.U(i3), i2);
                    break;
                case 2:
                    fragment = aVar.nd;
                    if (fragment != null) {
                        fragment.mNextAnim = i;
                        this.mx.a(fragment, n.U(i3), i2);
                    }
                    if (aVar.ni == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < aVar.ni.size(); i5++) {
                        fragment2 = (Fragment) aVar.ni.get(i5);
                        fragment2.mNextAnim = i4;
                        this.mx.a(fragment2, false);
                    }
                    break;
                case 3:
                    fragment2 = aVar.nd;
                    fragment2.mNextAnim = i4;
                    this.mx.a(fragment2, false);
                    break;
                case 4:
                    fragment2 = aVar.nd;
                    fragment2.mNextAnim = i4;
                    this.mx.c(fragment2, n.U(i3), i2);
                    break;
                case 5:
                    fragment = aVar.nd;
                    fragment.mNextAnim = i;
                    this.mx.b(fragment, n.U(i3), i2);
                    break;
                case 6:
                    fragment2 = aVar.nd;
                    fragment2.mNextAnim = i4;
                    this.mx.e(fragment2, n.U(i3), i2);
                    break;
                case 7:
                    fragment2 = aVar.nd;
                    fragment2.mNextAnim = i4;
                    this.mx.d(fragment2, n.U(i3), i2);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.nc);
            }
            aVar = aVar.nb;
        }
        if (z) {
            this.mx.a(this.mx.nS, n.U(i3), i2, true);
            bVar = null;
        }
        if (this.mIndex >= 0) {
            n nVar = this.mx;
            i = this.mIndex;
            synchronized (nVar) {
                nVar.nP.set(i, null);
                if (nVar.nQ == null) {
                    nVar.nQ = new ArrayList();
                }
                boolean z2 = n.DEBUG;
                nVar.nQ.add(Integer.valueOf(i));
            }
            this.mIndex = -1;
        }
        return bVar;
    }

    private b a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i;
        int i2 = 0;
        b bVar = new b();
        bVar.nm = new View(this.mx.mHost.mContext);
        int i3 = 0;
        int i4 = 0;
        while (i3 < sparseArray.size()) {
            if (a(sparseArray.keyAt(i3), bVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i = 1;
            } else {
                i = i4;
            }
            i3++;
            i4 = i;
        }
        while (i2 < sparseArray2.size()) {
            i = sparseArray2.keyAt(i2);
            if (sparseArray.get(i) == null && a(i, bVar, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            }
            i2++;
        }
        if (i4 == 0) {
            return null;
        }
        return bVar;
    }

    private static Object a(Object obj, Fragment fragment, ArrayList<View> arrayList, android.support.v4.e.a<String, View> aVar, View view) {
        if (obj == null) {
            return obj;
        }
        View view2 = fragment.getView();
        if (obj == null) {
            return obj;
        }
        r.a((ArrayList) arrayList, view2);
        if (aVar != null) {
            arrayList.removeAll(aVar.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view);
        r.b((Transition) obj, arrayList);
        return obj;
    }

    private android.support.v4.e.a<String, View> a(b bVar, Fragment fragment, boolean z) {
        android.support.v4.e.a aVar = new android.support.v4.e.a();
        if (this.mO != null) {
            r.a((Map) aVar, fragment.getView());
            if (z) {
                g.a((Map) aVar, this.mP);
            } else {
                aVar = a(this.mO, this.mP, aVar);
            }
        }
        al alVar;
        if (z) {
            if (fragment.mEnterTransitionCallback != null) {
                alVar = fragment.mEnterTransitionCallback;
            }
            a(bVar, aVar, false);
        } else {
            if (fragment.mExitTransitionCallback != null) {
                alVar = fragment.mExitTransitionCallback;
            }
            b(bVar, aVar, false);
        }
        return aVar;
    }

    private boolean a(int i, b bVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        final View view = (ViewGroup) this.mx.nT.onFindViewById(i);
        if (view == null) {
            return false;
        }
        Object obj;
        Object obj2;
        Transition transition;
        Object obj3;
        android.support.v4.e.a aVar;
        Object obj4;
        final boolean z2;
        final Fragment fragment = (Fragment) sparseArray2.get(i);
        final Fragment fragment2 = (Fragment) sparseArray.get(i);
        if (fragment == null) {
            obj = null;
        } else {
            obj = r.f(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
        }
        if (fragment == null || fragment2 == null) {
            obj2 = null;
        } else {
            Object sharedElementReturnTransition = z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition();
            if (sharedElementReturnTransition == null) {
                obj2 = null;
            } else {
                transition = (Transition) sharedElementReturnTransition;
                if (transition == null) {
                    obj2 = null;
                } else {
                    obj2 = new TransitionSet();
                    obj2.addTransition(transition);
                }
            }
        }
        if (fragment2 == null) {
            obj3 = null;
        } else {
            obj3 = r.f(z ? fragment2.getReturnTransition() : fragment2.getExitTransition());
        }
        final ArrayList arrayList = new ArrayList();
        if (obj2 != null) {
            android.support.v4.e.a a = a(bVar, fragment2, z);
            if (a.isEmpty()) {
                aVar = null;
                obj4 = null;
            } else {
                if ((z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback) != null) {
                    ArrayList arrayList2 = new ArrayList(a.keySet());
                    arrayList2 = new ArrayList(a.values());
                }
                final b bVar2 = bVar;
                z2 = z;
                view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                    public final boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (obj2 != null) {
                            r.a(obj2, arrayList);
                            arrayList.clear();
                            android.support.v4.e.a a = e.a(e.this, bVar2, z2, fragment);
                            r.a(obj2, bVar2.nm, a, arrayList);
                            e.a(e.this, a, bVar2);
                            e.a(fragment, fragment2, z2, a);
                        }
                        return true;
                    }
                });
                aVar = a;
                obj4 = obj2;
            }
        } else {
            aVar = null;
            obj4 = obj2;
        }
        if (obj == null && obj4 == null && obj3 == null) {
            return false;
        }
        Object obj5;
        ArrayList arrayList3 = new ArrayList();
        obj2 = a(obj3, fragment2, arrayList3, aVar, bVar.nm);
        if (!(this.mP == null || aVar == null)) {
            View view2 = (View) aVar.get(this.mP.get(0));
            if (view2 != null) {
                if (obj2 != null) {
                    r.a(obj2, view2);
                }
                if (obj4 != null) {
                    r.a(obj4, view2);
                }
            }
        }
        android.support.v4.app.r.b anonymousClass1 = new android.support.v4.app.r.b() {
            public final View getView() {
                return fragment.getView();
            }
        };
        ArrayList arrayList4 = new ArrayList();
        Map aVar2 = new android.support.v4.e.a();
        if (fragment != null) {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        } else {
            z2 = true;
        }
        transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj4;
        if (transition == null || transition2 == null) {
            z2 = true;
        }
        if (z2) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 != null) {
                transitionSet.addTransition(transition3);
            }
            obj5 = transitionSet;
        } else {
            if (transition2 != null && transition != null) {
                transition = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
            } else if (transition2 != null) {
                transition = transition2;
            } else if (transition == null) {
                transition = null;
            }
            if (transition3 != null) {
                obj5 = new TransitionSet();
                if (transition != null) {
                    obj5.addTransition(transition);
                }
                obj5.addTransition(transition3);
            } else {
                transition2 = transition;
            }
        }
        if (obj5 != null) {
            View view3 = bVar.nm;
            android.support.v4.app.r.a aVar3 = bVar.nl;
            Map map = bVar.nj;
            if (!(obj == null && obj4 == null)) {
                Transition transition4 = (Transition) obj;
                if (transition4 != null) {
                    transition4.addTarget(view3);
                }
                if (obj4 != null) {
                    r.a(obj4, view3, aVar, arrayList);
                }
                view.getViewTreeObserver().addOnPreDrawListener(new android.support.v4.app.r.AnonymousClass2(view, transition4, view3, anonymousClass1, map, aVar2, arrayList4));
                if (transition4 != null) {
                    transition4.setEpicenterCallback(new android.support.v4.app.r.AnonymousClass3(aVar3));
                }
            }
            final View view4 = view;
            final b bVar3 = bVar;
            final int i2 = i;
            final Object obj6 = obj5;
            view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public final boolean onPreDraw() {
                    view4.getViewTreeObserver().removeOnPreDrawListener(this);
                    e.this.a(bVar3, i2, obj6);
                    return true;
                }
            });
            r.a(obj5, bVar.nm, true);
            a(bVar, i, obj5);
            TransitionManager.beginDelayedTransition(view, (Transition) obj5);
            View view5 = bVar.nm;
            ArrayList arrayList5 = bVar.nk;
            Transition transition5 = (Transition) obj;
            Transition transition6 = (Transition) obj2;
            Transition transition7 = (Transition) obj4;
            Transition transition8 = (Transition) obj5;
            if (transition8 != null) {
                view.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass4(view, transition5, arrayList4, transition6, arrayList3, transition7, arrayList, aVar2, arrayList5, transition8, view5));
            }
        }
        if (obj5 != null) {
            return true;
        }
        return false;
    }

    private static android.support.v4.e.a<String, View> a(ArrayList<String> arrayList, ArrayList<String> arrayList2, android.support.v4.e.a<String, View> aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        android.support.v4.e.a<String, View> aVar2 = new android.support.v4.e.a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) aVar.get(arrayList.get(i));
            if (view != null) {
                aVar2.put(arrayList2.get(i), view);
            }
        }
        return aVar2;
    }

    private void a(b bVar, int i, Object obj) {
        if (this.mx.nL != null) {
            for (int i2 = 0; i2 < this.mx.nL.size(); i2++) {
                Fragment fragment = (Fragment) this.mx.nL.get(i2);
                if (!(fragment.mView == null || fragment.mContainer == null || fragment.mContainerId != i)) {
                    if (!fragment.mHidden) {
                        r.a(obj, fragment.mView, false);
                        bVar.nk.remove(fragment.mView);
                    } else if (!bVar.nk.contains(fragment.mView)) {
                        r.a(obj, fragment.mView, true);
                        bVar.nk.add(fragment.mView);
                    }
                }
            }
        }
    }

    private static void a(android.support.v4.e.a<String, String> aVar, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < aVar.size(); i++) {
                if (str.equals(aVar.valueAt(i))) {
                    aVar.setValueAt(i, str2);
                    return;
                }
            }
            aVar.put(str, str2);
        }
    }

    private static void a(b bVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    a(bVar.nj, (String) arrayList.get(i2), (String) arrayList2.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(b bVar, android.support.v4.e.a<String, View> aVar, boolean z) {
        int size = this.mP == null ? 0 : this.mP.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.mO.get(i);
            View view = (View) aVar.get((String) this.mP.get(i));
            if (view != null) {
                String transitionName = view.getTransitionName();
                if (z) {
                    a(bVar.nj, str, transitionName);
                } else {
                    a(bVar.nj, transitionName, str);
                }
            }
        }
    }

    private static void b(b bVar, android.support.v4.e.a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) aVar.keyAt(i);
            String transitionName = ((View) aVar.valueAt(i)).getTransitionName();
            if (z) {
                a(bVar.nj, str, transitionName);
            } else {
                a(bVar.nj, transitionName, str);
            }
        }
    }
}
