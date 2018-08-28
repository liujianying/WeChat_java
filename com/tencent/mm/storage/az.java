package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.plugin.messenger.foundation.a.a.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface az extends g {

    public interface a {
        void a(ai aiVar, az azVar);
    }

    public interface b {
        String a(int i, String str, String str2, int i2, Context context);

        void a(bd bdVar, PString pString, PString pString2, PInt pInt, boolean z);
    }

    boolean Cp(String str);

    boolean GL(String str);

    Cursor YA(String str);

    Cursor YB(String str);

    int YC(String str);

    String YD(String str);

    ai YE(String str);

    int YF(String str);

    void YG(String str);

    void YH(String str);

    int YI(String str);

    void Yp(String str);

    ai Yq(String str);

    void Yr(String str);

    boolean Ys(String str);

    boolean Yt(String str);

    boolean Yu(String str);

    boolean Yv(String str);

    boolean Yw(String str);

    boolean Yx(String str);

    Cursor Yy(String str);

    Cursor Yz(String str);

    int a(ai aiVar, String str);

    int a(ai aiVar, String str, boolean z);

    Cursor a(String str, List<String> list, String str2, boolean z);

    Cursor a(String str, List<String> list, boolean z, String str2);

    Cursor a(ArrayList<String> arrayList, String str, List<String> list, String str2);

    com.tencent.mm.vending.b.b a(f fVar);

    void a(e eVar);

    void a(ai aiVar, int i, int i2);

    void a(a aVar);

    void a(a aVar, Looper looper);

    void a(b bVar);

    boolean a(String str, int i, boolean z, int i2);

    String aZ(int i, String str);

    void ak(bd bdVar);

    void as(LinkedList<String> linkedList);

    Cursor b(String str, List<String> list, String str2);

    void b(com.tencent.mm.plugin.messenger.foundation.a.a.f fVar, c cVar);

    void b(a aVar);

    void c(a aVar);

    HashMap<String, Long> clA();

    void clB();

    List<String> clD();

    List<String> clE();

    Cursor clF();

    int clH();

    String clI();

    Cursor clJ();

    ai clK();

    boolean cly();

    boolean clz();

    long d(ai aiVar);

    void d(String[] strArr, String str);

    boolean f(ai aiVar);

    Cursor fZ(String str, String str2);

    boolean g(ai aiVar);

    int hX(String str);

    Cursor k(List<String> list, int i);

    Cursor t(String str, List<String> list);

    b vu();
}
