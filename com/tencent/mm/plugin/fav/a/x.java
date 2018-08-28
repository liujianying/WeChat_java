package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public interface x extends f {
    public static final String[] diD = new String[]{i.a(g.dhO, "FavItemInfo")};

    g Bs(String str);

    ArrayList<g> a(List<Long> list, List<g> list2, Set<Integer> set, w wVar);

    List<g> a(int i, Set<Integer> set, w wVar);

    boolean a(g gVar, String... strArr);

    int aLA();

    List<g> aLB();

    List<g> aLC();

    List<g> aLD();

    List<g> aLE();

    List<g> aLF();

    List<g> aLG();

    List<Long> aLH();

    void aLI();

    List<Long> aLJ();

    e aLz();

    List<g> b(long j, int i, Set<Integer> set, w wVar);

    boolean b(g gVar, String... strArr);

    g dy(long j);

    g dz(long j);

    int getCount();

    int pL(int i);

    boolean r(long j, int i);

    long s(long j, int i);

    LinkedList<Integer> t(long j, int i);

    void t(int i, long j);

    long u(long j, int i);

    boolean y(g gVar);

    void z(g gVar);
}
