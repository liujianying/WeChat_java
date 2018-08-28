package android.support.v7.widget;

import android.database.Observable;

class RecyclerView$b extends Observable<RecyclerView$c> {
    RecyclerView$b() {
    }

    public final boolean fY() {
        return !this.mObservers.isEmpty();
    }

    public final void notifyChanged() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$c) this.mObservers.get(size)).onChanged();
        }
    }

    public final void X(int i, int i2) {
        b(i, i2, null);
    }

    public final void b(int i, int i2, Object obj) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$c) this.mObservers.get(size)).c(i, i2, obj);
        }
    }

    public final void Z(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$c) this.mObservers.get(size)).ac(i, i2);
        }
    }

    public final void aa(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$c) this.mObservers.get(size)).ad(i, i2);
        }
    }

    public final void Y(int i, int i2) {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            ((RecyclerView$c) this.mObservers.get(size)).ae(i, i2);
        }
    }
}
