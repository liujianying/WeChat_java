package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends BaseAdapter {
    private static boolean utR;
    private final Context mContext;
    int mCount;
    int mNumColumns = 1;
    final b utS;
    private GridHeadersGridView utT;
    private final List<View> utU = new ArrayList();
    private View[] utV;
    private DataSetObserver yY = new 1(this);

    public c(Context context, GridHeadersGridView gridHeadersGridView, b bVar) {
        this.mContext = context;
        this.utS = bVar;
        this.utT = gridHeadersGridView;
        bVar.registerDataSetObserver(this.yY);
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final int getCount() {
        int i = 0;
        this.mCount = 0;
        int czk = this.utS.czk();
        if (czk == 0) {
            return this.utS.getCount();
        }
        while (i < czk) {
            this.mCount += (this.utS.FW(i) + FY(i)) + this.mNumColumns;
            i++;
        }
        return this.mCount;
    }

    public final Object getItem(int i) {
        c FZ = FZ(i);
        if (FZ.mPosition == -1 || FZ.mPosition == -2) {
            return null;
        }
        return this.utS.getItem(FZ.mPosition);
    }

    public final long getItemId(int i) {
        c FZ = FZ(i);
        if (FZ.mPosition == -2) {
            return -1;
        }
        if (FZ.mPosition == -1) {
            return -2;
        }
        return this.utS.getItemId(FZ.mPosition);
    }

    public final int getItemViewType(int i) {
        c FZ = FZ(i);
        if (FZ.mPosition == -2) {
            return 1;
        }
        if (FZ.mPosition == -1) {
            return 0;
        }
        int itemViewType = this.utS.getItemViewType(FZ.mPosition);
        return itemViewType != -1 ? itemViewType + 2 : itemViewType;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View childAt;
        d dVar;
        View bVar;
        if (view instanceof d) {
            d dVar2 = (d) view;
            childAt = dVar2.getChildAt(0);
            dVar = dVar2;
        } else {
            dVar = null;
            childAt = view;
        }
        c FZ = FZ(i);
        if (FZ.mPosition == -2) {
            bVar = new b(this, this.mContext);
            bVar.setHeaderWidth(this.utT.getWidth());
            ((b) bVar).setHeaderId(FZ.utZ);
            bVar.setTag(this.utS.a(FZ.utZ, (View) bVar.getTag(), viewGroup));
        } else if (FZ.mPosition == -1) {
            a aVar = (a) childAt;
            if (aVar == null) {
                aVar = new a(this, this.mContext);
            }
            bVar = aVar;
        } else {
            bVar = this.utS.getView(FZ.mPosition, childAt, viewGroup);
        }
        if (dVar == null) {
            dVar = new d(this, this.mContext);
        }
        dVar.removeAllViews();
        dVar.addView(bVar);
        dVar.setPosition(i);
        dVar.setNumColumns(this.mNumColumns);
        this.utV[i % this.mNumColumns] = dVar;
        if (i % this.mNumColumns == 0) {
            utR = true;
            for (int i2 = 1; i2 < this.utV.length; i2++) {
                this.utV[i2] = getView(i + i2, null, viewGroup);
            }
            utR = false;
        }
        dVar.setRowSiblings(this.utV);
        if (!utR && (i % this.mNumColumns == this.mNumColumns - 1 || i == getCount() - 1)) {
            FX(this.mNumColumns);
        }
        return dVar;
    }

    public final int getViewTypeCount() {
        return this.utS.getViewTypeCount() + 2;
    }

    public final boolean hasStableIds() {
        return this.utS.hasStableIds();
    }

    public final boolean isEmpty() {
        return this.utS.isEmpty();
    }

    public final boolean isEnabled(int i) {
        c FZ = FZ(i);
        if (FZ.mPosition == -1 || FZ.mPosition == -2) {
            return false;
        }
        return this.utS.isEnabled(FZ.mPosition);
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.utS.registerDataSetObserver(dataSetObserver);
    }

    public final void setNumColumns(int i) {
        this.mNumColumns = i;
        FX(i);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.utS.unregisterDataSetObserver(dataSetObserver);
    }

    private void FX(int i) {
        this.utV = new View[i];
        Arrays.fill(this.utV, null);
    }

    private int FY(int i) {
        int FW = this.utS.FW(i) % this.mNumColumns;
        return FW == 0 ? 0 : this.mNumColumns - FW;
    }

    protected final long oo(int i) {
        return (long) FZ(i).utZ;
    }

    protected final View a(int i, View view, ViewGroup viewGroup) {
        if (this.utS.czk() == 0) {
            return null;
        }
        return this.utS.a(FZ(i).utZ, view, viewGroup);
    }

    protected final c FZ(int i) {
        int i2 = 0;
        int czk = this.utS.czk();
        if (czk != 0) {
            int i3 = i;
            int i4 = i;
            while (i2 < czk) {
                int FW = this.utS.FW(i2);
                if (i4 == 0) {
                    return new c(this, -2, i2);
                }
                i4 -= this.mNumColumns;
                if (i4 < 0) {
                    return new c(this, -1, i2);
                }
                i3 -= this.mNumColumns;
                if (i4 < FW) {
                    return new c(this, i3, i2);
                }
                int FY = FY(i2);
                i4 -= FW + FY;
                i2++;
                i3 -= FY;
            }
            return new c(this, -1, i2);
        } else if (i >= this.utS.getCount()) {
            return new c(this, -1, 0);
        } else {
            return new c(this, i, 0);
        }
    }
}
