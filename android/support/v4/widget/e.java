package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v4.widget.f.a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class e extends BaseAdapter implements a, Filterable {
    public Context mContext;
    protected boolean yT = false;
    protected boolean yU = true;
    public Cursor yV = null;
    protected int yW;
    protected a yX;
    protected DataSetObserver yY;
    protected f yZ;
    protected FilterQueryProvider za;

    public abstract void a(View view, Cursor cursor);

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public e(Context context) {
        this.mContext = context;
        this.yW = -1;
        this.yX = new a(this);
        this.yY = new b(this, (byte) 0);
    }

    public final Cursor getCursor() {
        return this.yV;
    }

    public int getCount() {
        if (!this.yT || this.yV == null) {
            return 0;
        }
        return this.yV.getCount();
    }

    public Object getItem(int i) {
        if (!this.yT || this.yV == null) {
            return null;
        }
        this.yV.moveToPosition(i);
        return this.yV;
    }

    public long getItemId(int i) {
        if (this.yT && this.yV != null && this.yV.moveToPosition(i)) {
            return this.yV.getLong(this.yW);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.yT) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.yV.moveToPosition(i)) {
            if (view == null) {
                view = newView(this.mContext, this.yV, viewGroup);
            }
            a(view, this.yV);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.yT) {
            return null;
        }
        this.yV.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.mContext, this.yV, viewGroup);
        }
        a(view, this.yV);
        return view;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public void changeCursor(Cursor cursor) {
        Cursor cursor2;
        if (cursor == this.yV) {
            cursor2 = null;
        } else {
            cursor2 = this.yV;
            if (cursor2 != null) {
                if (this.yX != null) {
                    cursor2.unregisterContentObserver(this.yX);
                }
                if (this.yY != null) {
                    cursor2.unregisterDataSetObserver(this.yY);
                }
            }
            this.yV = cursor;
            if (cursor != null) {
                if (this.yX != null) {
                    cursor.registerContentObserver(this.yX);
                }
                if (this.yY != null) {
                    cursor.registerDataSetObserver(this.yY);
                }
                this.yW = cursor.getColumnIndexOrThrow("_id");
                this.yT = true;
                notifyDataSetChanged();
            } else {
                this.yW = -1;
                this.yT = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        if (this.za != null) {
            return this.za.runQuery(charSequence);
        }
        return this.yV;
    }

    public Filter getFilter() {
        if (this.yZ == null) {
            this.yZ = new f(this);
        }
        return this.yZ;
    }

    protected final void onContentChanged() {
        if (this.yU && this.yV != null && !this.yV.isClosed()) {
            this.yT = this.yV.requery();
        }
    }
}
