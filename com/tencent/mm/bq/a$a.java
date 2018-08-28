package com.tencent.mm.bq;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public class a$a<E> extends ArrayList<E> {
    public final boolean add(E e) {
        x.i("InterceptArrayList", "InterceptArrayList.add");
        return true;
    }

    public final void add(int i, E e) {
        x.i("InterceptArrayList", "InterceptArrayList.add index object");
    }
}
