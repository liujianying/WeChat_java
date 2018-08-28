package com.tencent.mm.bt.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a> extends SQLiteClosable {
    int mStartPos = 0;
    SparseArray<Object> tef = new SparseArray();
    int teg;
    HashMap<Object, T> teh = new HashMap();
    ArrayList<Object> tei;
    T tej;

    public abstract ArrayList<T> ae(ArrayList<Object> arrayList);

    public abstract T coc();

    final void b(Object obj, T t) {
        this.teh.put(obj, t);
    }

    public final boolean DA(int i) {
        return this.tef.indexOfKey(i) >= 0;
    }

    public final void eJ(int i, int i2) {
        if (i2 != 0) {
            x.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", Integer.valueOf(i2), Integer.valueOf(i));
            this.tef.remove(i);
        } else if (this.tej != null) {
            Object key = this.tej.getKey();
            b(key, this.tej);
            this.tef.put(i, key);
        }
    }

    public final void acV() {
        x.i("MicroMsg.CursorDataWindow", "clearData");
        this.tef.clear();
        this.teh.clear();
    }

    protected void onAllReferencesReleased() {
        acV();
    }

    final void t(Object[] objArr) {
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (int i2 = 0; i2 < this.tef.size(); i2++) {
            int keyAt = this.tef.keyAt(i2);
            Object valueAt = this.tef.valueAt(i2);
            Object obj = 1;
            for (Object equals : objArr) {
                if (equals.equals(valueAt)) {
                    i++;
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                sparseArray.put(keyAt - i, valueAt);
            } else {
                x.i("MicroMsg.CursorDataWindow", "newcursor delete index : " + i2 + " obj : " + valueAt);
            }
        }
        if (this.tef.size() != sparseArray.size()) {
            x.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.tef.size() + " newposistion Size : " + sparseArray.size());
        }
        this.tef = sparseArray;
    }

    public final boolean cm(Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1) {
                if (this.teh == null || !this.teh.containsKey(objArr[0])) {
                    return false;
                }
                return true;
            }
        }
        return this.teh != null && this.teh.containsKey(obj);
    }
}
