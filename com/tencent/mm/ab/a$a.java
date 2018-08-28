package com.tencent.mm.ab;

import com.tencent.mm.protocal.c.bhp;

public class a$a<T extends bhp> {
    public String Yy;
    public l bKq;
    public T dIv;
    public a dIw;
    public int errCode;
    public int errType;

    public static <T extends bhp> a$a<T> a(int i, int i2, String str, T t, l lVar, a aVar) {
        a$a<T> a_a = new a$a();
        a_a.errType = i;
        a_a.errCode = i2;
        a_a.Yy = str;
        a_a.dIv = t;
        a_a.bKq = lVar;
        a_a.dIw = aVar;
        if (aVar != null) {
            aVar.a(i, i2, str, t, lVar);
        }
        return a_a;
    }
}
