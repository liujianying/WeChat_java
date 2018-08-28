package com.tencent.mm.ui.base;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.mm.ui.base.HeaderGridView.a;
import java.util.ArrayList;
import java.util.Iterator;

class HeaderGridView$c implements Filterable, WrapperListAdapter {
    private final ListAdapter Do;
    public final DataSetObservable mDataSetObservable = new DataSetObservable();
    int mNumColumns = 1;
    ArrayList<a> tsu;
    boolean tsx;
    private final boolean tsy;

    public HeaderGridView$c(ArrayList<a> arrayList, ListAdapter listAdapter) {
        this.Do = listAdapter;
        this.tsy = listAdapter instanceof Filterable;
        if (arrayList == null) {
            throw new IllegalArgumentException("headerViewInfos cannot be null");
        }
        this.tsu = arrayList;
        this.tsx = af(this.tsu);
    }

    public final boolean isEmpty() {
        return (this.Do == null || this.Do.isEmpty()) && this.tsu.size() == 0;
    }

    private static boolean af(ArrayList<a> arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((a) it.next()).isSelectable) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int getCount() {
        if (this.Do != null) {
            return (this.tsu.size() * this.mNumColumns) + this.Do.getCount();
        }
        return this.tsu.size() * this.mNumColumns;
    }

    public final boolean areAllItemsEnabled() {
        if (this.Do == null) {
            return true;
        }
        if (this.tsx && this.Do.areAllItemsEnabled()) {
            return true;
        }
        return false;
    }

    public final boolean isEnabled(int i) {
        int size = this.tsu.size() * this.mNumColumns;
        if (i >= size) {
            size = i - size;
            return (this.Do == null || size >= this.Do.getCount()) ? false : this.Do.isEnabled(size);
        } else if (i % this.mNumColumns == 0 && ((a) this.tsu.get(i / this.mNumColumns)).isSelectable) {
            return true;
        } else {
            return false;
        }
    }

    public final Object getItem(int i) {
        int size = this.tsu.size() * this.mNumColumns;
        if (i >= size) {
            size = i - size;
            if (this.Do == null || size >= this.Do.getCount()) {
                return null;
            }
            return this.Do.getItem(size);
        } else if (i % this.mNumColumns == 0) {
            return ((a) this.tsu.get(i / this.mNumColumns)).data;
        } else {
            return null;
        }
    }

    public final long getItemId(int i) {
        int size = this.tsu.size() * this.mNumColumns;
        if (this.Do != null && i >= size) {
            size = i - size;
            if (size < this.Do.getCount()) {
                return this.Do.getItemId(size);
            }
        }
        return -1;
    }

    public final boolean hasStableIds() {
        if (this.Do != null) {
            return this.Do.hasStableIds();
        }
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int size = this.tsu.size() * this.mNumColumns;
        if (i < size) {
            View view2 = ((a) this.tsu.get(i / this.mNumColumns)).tsv;
            if (i % this.mNumColumns == 0) {
                return view2;
            }
            if (view == null) {
                view = new View(viewGroup.getContext());
            }
            view.setVisibility(4);
            view.setMinimumHeight(view2.getHeight());
            return view;
        }
        size = i - size;
        if (this.Do != null && size < this.Do.getCount()) {
            return this.Do.getView(size, view, viewGroup);
        }
        if (view == null) {
            view = new View(viewGroup.getContext());
        }
        view.setVisibility(4);
        return view;
    }

    public final int getItemViewType(int i) {
        int size = this.tsu.size() * this.mNumColumns;
        if (i < size && i % this.mNumColumns != 0) {
            return this.Do != null ? this.Do.getViewTypeCount() : 1;
        } else {
            if (this.Do != null && i >= size) {
                size = i - size;
                if (size < this.Do.getCount()) {
                    return this.Do.getItemViewType(size);
                }
            }
            return -2;
        }
    }

    public final int getViewTypeCount() {
        if (this.Do != null) {
            return this.Do.getViewTypeCount() + 1;
        }
        return 2;
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.registerObserver(dataSetObserver);
        if (this.Do != null) {
            this.Do.registerDataSetObserver(dataSetObserver);
        }
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.unregisterObserver(dataSetObserver);
        if (this.Do != null) {
            this.Do.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public final Filter getFilter() {
        if (this.tsy) {
            return ((Filterable) this.Do).getFilter();
        }
        return null;
    }

    public final ListAdapter getWrappedAdapter() {
        return this.Do;
    }
}
