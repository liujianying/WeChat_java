package com.tencent.mm.ui.widget.sortlist;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;

class DragSortListView$a extends BaseAdapter {
    ListAdapter Do;
    final /* synthetic */ DragSortListView uOr;

    /* synthetic */ DragSortListView$a(DragSortListView dragSortListView, ListAdapter listAdapter, byte b) {
        this(dragSortListView, listAdapter);
    }

    private DragSortListView$a(final DragSortListView dragSortListView, ListAdapter listAdapter) {
        this.uOr = dragSortListView;
        this.Do = listAdapter;
        this.Do.registerDataSetObserver(new DataSetObserver() {
            public final void onChanged() {
                DragSortListView$a.this.notifyDataSetChanged();
            }

            public final void onInvalidated() {
                DragSortListView$a.this.notifyDataSetInvalidated();
            }
        });
    }

    public final long getItemId(int i) {
        return this.Do.getItemId(i);
    }

    public final Object getItem(int i) {
        return this.Do.getItem(i);
    }

    public final int getCount() {
        return this.Do.getCount();
    }

    public final boolean areAllItemsEnabled() {
        return this.Do.areAllItemsEnabled();
    }

    public final boolean isEnabled(int i) {
        return this.Do.isEnabled(i);
    }

    public final int getItemViewType(int i) {
        return this.Do.getItemViewType(i);
    }

    public final int getViewTypeCount() {
        return this.Do.getViewTypeCount();
    }

    public final boolean hasStableIds() {
        return this.Do.hasStableIds();
    }

    public final boolean isEmpty() {
        return this.Do.isEmpty();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        if (view == null || !(view instanceof b)) {
            b cVar;
            view2 = this.Do.getView(i, null, this.uOr);
            if (view2 instanceof Checkable) {
                cVar = new c(this.uOr.getContext());
            } else {
                cVar = new b(this.uOr.getContext());
            }
            cVar.setLayoutParams(new LayoutParams(-1, -2));
            cVar.addView(view2);
            view = cVar;
        } else {
            view = (b) view;
            View childAt = view.getChildAt(0);
            view2 = this.Do.getView(i, childAt, this.uOr);
            if (view2 != childAt) {
                if (childAt != null) {
                    view.removeViewAt(0);
                }
                view.addView(view2);
            }
        }
        DragSortListView.a(this.uOr, this.uOr.getHeaderViewsCount() + i, view);
        return view;
    }
}
