package com.tencent.mm.bt.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.mm.bt.a.f.a;
import com.tencent.wcdb.AbstractCursor;
import java.util.HashMap;

public final class e extends AbstractCursor implements d {
    private DataSetObserver mObserver = new 1(this);
    private d teq;
    public d[] ter;

    public e(d[] dVarArr) {
        int i = 0;
        this.ter = dVarArr;
        this.teq = dVarArr[0];
        while (i < this.ter.length) {
            if (this.ter[i] != null) {
                this.ter[i].registerDataSetObserver(this.mObserver);
            }
            i++;
        }
    }

    public final int getCount() {
        int length = this.ter.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.ter[i2] != null) {
                i += this.ter[i2].getCount();
            }
        }
        return i;
    }

    public final boolean onMove(int i, int i2) {
        this.teq = null;
        int length = this.ter.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.ter[i4] != null) {
                if (i2 < this.ter[i4].getCount() + i3) {
                    this.teq = this.ter[i4];
                    break;
                }
                i3 += this.ter[i4].getCount();
            }
        }
        if (this.teq != null) {
            return this.teq.moveToPosition(i2 - i3);
        }
        return false;
    }

    public final String getString(int i) {
        return this.teq.getString(i);
    }

    public final short getShort(int i) {
        return this.teq.getShort(i);
    }

    public final int getInt(int i) {
        return this.teq.getInt(i);
    }

    public final long getLong(int i) {
        return this.teq.getLong(i);
    }

    public final float getFloat(int i) {
        return this.teq.getFloat(i);
    }

    public final double getDouble(int i) {
        return this.teq.getDouble(i);
    }

    public final boolean isNull(int i) {
        return this.teq.isNull(i);
    }

    public final byte[] getBlob(int i) {
        return this.teq.getBlob(i);
    }

    public final String[] getColumnNames() {
        if (this.teq != null) {
            return this.teq.getColumnNames();
        }
        return new String[0];
    }

    public final void deactivate() {
        int length = this.ter.length;
        for (int i = 0; i < length; i++) {
            if (this.ter[i] != null) {
                this.ter[i].deactivate();
            }
        }
        super.deactivate();
    }

    public final void close() {
        int length = this.ter.length;
        for (int i = 0; i < length; i++) {
            if (this.ter[i] != null) {
                this.ter[i].close();
            }
        }
        super.close();
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
        int length = this.ter.length;
        for (int i = 0; i < length; i++) {
            if (this.ter[i] != null) {
                this.ter[i].registerContentObserver(contentObserver);
            }
        }
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
        int length = this.ter.length;
        for (int i = 0; i < length; i++) {
            if (this.ter[i] != null) {
                this.ter[i].unregisterContentObserver(contentObserver);
            }
        }
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.ter.length;
        for (int i = 0; i < length; i++) {
            if (this.ter[i] != null) {
                this.ter[i].registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.ter.length;
        for (int i = 0; i < length; i++) {
            if (this.ter[i] != null) {
                this.ter[i].unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public final boolean requery() {
        int length = this.ter.length;
        int i = 0;
        while (i < length) {
            if (this.ter[i] != null && !this.ter[i].requery()) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final void a(a aVar) {
        int length = this.ter.length;
        for (int i = 0; i < length; i++) {
            if (this.ter[i] != null) {
                this.ter[i].a(aVar);
            }
        }
    }

    public final void lo(boolean z) {
        int length = this.ter.length;
        for (int i = 0; i < length; i++) {
            if (this.ter[i] != null) {
                this.ter[i].lo(z);
            }
        }
    }

    public final boolean cnU() {
        int length = this.ter.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            if (!(this.ter[i] == null || this.ter[i].cnU())) {
                z = false;
            }
            i++;
        }
        return z;
    }

    public final a Dy(int i) {
        int length = this.ter.length;
        for (int i2 = 0; i2 < length; i2++) {
            int count = this.ter[i2].getCount();
            if (i < count) {
                return this.ter[i2].Dy(i);
            }
            i -= count;
        }
        return null;
    }

    public final boolean a(Object obj, a aVar) {
        int length = this.ter.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            if (this.ter[i] != null && this.ter[i].a(obj, aVar)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public final SparseArray<Object>[] cnS() {
        int length = this.ter.length;
        SparseArray<Object>[] sparseArrayArr = new SparseArray[length];
        for (int i = 0; i < length; i++) {
            SparseArray[] cnS = this.ter[i].cnS();
            sparseArrayArr[i] = cnS != null ? cnS[0] : null;
        }
        return sparseArrayArr;
    }

    public final HashMap cnT() {
        return null;
    }

    public final boolean Dx(int i) {
        int length = this.ter.length;
        boolean z = true;
        int i2 = 0;
        while (i2 < length) {
            if (!(this.ter[i2] == null || this.ter[i2].Dx(i))) {
                z = false;
            }
            i2++;
        }
        return z;
    }

    public final boolean cm(Object obj) {
        int length = this.ter.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            if (this.ter[i] != null && this.ter[i].cm(obj)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public final a cn(Object obj) {
        return this.teq.cn(obj);
    }

    public final void Dz(int i) {
        int length = this.ter.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.ter[i2] != null) {
                this.ter[i2].Dz(i);
            }
        }
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }
}
