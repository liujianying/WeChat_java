package com.tencent.mm.bt.a;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.bt.a.f.a;
import java.util.HashMap;

public interface d<T> extends Cursor {
    boolean Dx(int i);

    a Dy(int i);

    void Dz(int i);

    void a(a aVar);

    boolean a(Object obj, a aVar);

    boolean cm(Object obj);

    a cn(Object obj);

    SparseArray<T>[] cnS();

    HashMap<Object, T> cnT();

    boolean cnU();

    void lo(boolean z);
}
