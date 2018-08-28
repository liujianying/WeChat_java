package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class p extends u {
    private ArrayList<Fragment> oA = new ArrayList();
    private final m ou;
    private q ov = null;
    private Fragment ow = null;
    private ArrayList<SavedState> oz = new ArrayList();

    public abstract Fragment V(int i);

    public p(m mVar) {
        this.ou = mVar;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.oA.size() > i) {
            Fragment fragment = (Fragment) this.oA.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.ov == null) {
            this.ov = this.ou.bk();
        }
        Fragment V = V(i);
        if (this.oz.size() > i) {
            SavedState savedState = (SavedState) this.oz.get(i);
            if (savedState != null) {
                V.setInitialSavedState(savedState);
            }
        }
        while (this.oA.size() <= i) {
            this.oA.add(null);
        }
        V.setMenuVisibility(false);
        V.setUserVisibleHint(false);
        this.oA.set(i, V);
        this.ov.a(viewGroup.getId(), V);
        return V;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.ov == null) {
            this.ov = this.ou.bk();
        }
        while (this.oz.size() <= i) {
            this.oz.add(null);
        }
        this.oz.set(i, fragment.isAdded() ? this.ou.e(fragment) : null);
        this.oA.set(i, null);
        this.ov.a(fragment);
    }

    public final void e(Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.ow) {
            if (this.ow != null) {
                this.ow.setMenuVisibility(false);
                this.ow.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.ow = fragment;
        }
    }

    public final void bo() {
        if (this.ov != null) {
            this.ov.commitAllowingStateLoss();
            this.ov = null;
            this.ou.executePendingTransactions();
        }
    }

    public final boolean a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public final Parcelable bp() {
        Bundle bundle = null;
        if (this.oz.size() > 0) {
            bundle = new Bundle();
            SavedState[] savedStateArr = new SavedState[this.oz.size()];
            this.oz.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.oA.size(); i++) {
            Fragment fragment = (Fragment) this.oA.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.ou.a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public final void a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.oz.clear();
            this.oA.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.oz.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment c = this.ou.c(bundle, str);
                    if (c != null) {
                        while (this.oA.size() <= parseInt) {
                            this.oA.add(null);
                        }
                        c.setMenuVisibility(false);
                        this.oA.set(parseInt, c);
                    }
                }
            }
        }
    }
}
