package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataHolder implements SafeParcelable {
    public static final g CREATOR = new g();
    private static final a aMp = new 1(new String[0]);
    public final int aJC;
    final String[] aMh;
    Bundle aMi;
    final CursorWindow[] aMj;
    final Bundle aMk;
    int[] aMl;
    int aMm;
    Object aMn;
    private boolean aMo;
    boolean mClosed;
    final int mVersionCode;

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.aMo = true;
        this.mVersionCode = i;
        this.aMh = strArr;
        this.aMj = cursorWindowArr;
        this.aJC = i2;
        this.aMk = bundle;
    }

    private DataHolder(a aVar, int i) {
        this(aVar.aMh, a(aVar), i);
    }

    private DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i) {
        this.mClosed = false;
        this.aMo = true;
        this.mVersionCode = 1;
        this.aMh = (String[]) w.ah(strArr);
        this.aMj = (CursorWindow[]) w.ah(cursorWindowArr);
        this.aJC = i;
        this.aMk = null;
        oW();
    }

    private static CursorWindow[] a(a aVar) {
        int i = 0;
        if (aVar.aMh.length == 0) {
            return new CursorWindow[0];
        }
        List list = aVar.aMq;
        int size = list.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(aVar.aMh.length);
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            try {
                int i4;
                int i5;
                if (!cursorWindow.allocRow()) {
                    new StringBuilder("Allocating additional cursor window for large data set (row ").append(i2).append(")");
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i2);
                    cursorWindow.setNumColumns(aVar.aMh.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) list.get(i2);
                boolean z = true;
                for (int i6 = 0; i6 < aVar.aMh.length && z; i6++) {
                    String str = aVar.aMh[i6];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i2, i6);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i2, i6);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i2, i6);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i2, i6);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i2, i6);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i2, i6);
                    } else if (obj instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj).doubleValue(), i2, i6);
                    } else if (obj instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i2, i6);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (z) {
                    i4 = i2;
                    i5 = 0;
                } else if (i3 != 0) {
                    throw new b("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    new StringBuilder("Couldn't populate window data for row ").append(i2).append(" - allocating new window.");
                    cursorWindow.freeLastRow();
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i2);
                    cursorWindow.setNumColumns(aVar.aMh.length);
                    arrayList.add(cursorWindow);
                    i4 = i2 - 1;
                    i5 = 1;
                }
                i2 = i4 + 1;
                i3 = i5;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                i2 = arrayList.size();
                while (i < i2) {
                    ((CursorWindow) arrayList.get(i)).close();
                    i++;
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder dr(int i) {
        return new DataHolder(aMp, i);
    }

    private boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.aMj) {
                    close.close();
                }
            }
        }
    }

    public final String d(String str, int i, int i2) {
        m(str, i);
        return this.aMj[i2].getString(i, this.aMi.getInt(str));
    }

    public final int describeContents() {
        return 0;
    }

    public final int dq(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.aMm;
        w.at(z);
        while (i2 < this.aMl.length) {
            if (i < this.aMl[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.aMl.length ? i2 - 1 : i2;
    }

    protected final void finalize() {
        try {
            if (this.aMo && this.aMj.length > 0 && !isClosed()) {
                new StringBuilder("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (").append(this.aMn == null ? "internal object: " + toString() : this.aMn.toString()).append(")");
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    final void m(String str, int i) {
        if (this.aMi == null || !this.aMi.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.aMm) {
            throw new CursorIndexOutOfBoundsException(i, this.aMm);
        }
    }

    public final void oW() {
        int i;
        int i2 = 0;
        this.aMi = new Bundle();
        for (i = 0; i < this.aMh.length; i++) {
            this.aMi.putInt(this.aMh[i], i);
        }
        this.aMl = new int[this.aMj.length];
        i = 0;
        while (true) {
            int i3 = i2;
            if (i < this.aMj.length) {
                this.aMl[i] = i3;
                i3 += this.aMj[i].getNumRows() - (i3 - this.aMj[i].getStartPosition());
                i2 = i + 1;
            } else {
                this.aMm = i3;
                return;
            }
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel, i);
    }
}
