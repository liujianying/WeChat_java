package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class u {
    private final DataSetObservable uY = new DataSetObservable();
    private DataSetObserver uZ;

    public abstract boolean a(View view, Object obj);

    public abstract int getCount();

    public Object b(ViewGroup viewGroup, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void e(Object obj) {
    }

    public void bo() {
    }

    public Parcelable bp() {
        return null;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int k(Object obj) {
        return -1;
    }

    public void notifyDataSetChanged() {
        synchronized (this) {
            if (this.uZ != null) {
                this.uZ.onChanged();
            }
        }
        this.uY.notifyChanged();
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.uY.registerObserver(dataSetObserver);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.uY.unregisterObserver(dataSetObserver);
    }

    final void a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.uZ = dataSetObserver;
        }
    }

    public CharSequence cb() {
        return null;
    }

    public float ak(int i) {
        return 1.0f;
    }
}
