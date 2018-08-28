package com.tencent.tencentmap.mapsdk.a;

import android.util.SparseArray;

public final class cu<E> {
    public static SparseArray<E> a(SparseArray<E> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        SparseArray<E> sparseArray2 = new SparseArray(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            sparseArray2.append(keyAt, sparseArray.get(keyAt));
        }
        return sparseArray2;
    }
}
