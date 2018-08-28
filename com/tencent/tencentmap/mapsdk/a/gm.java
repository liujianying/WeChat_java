package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class gm extends ar {
    protected String[] b = new String[]{"findObjectById", "findObjectById4All", "findObjectById4Any", "findObjectByIdInSameGroup", "findObjectByIdInSameSet", "findObjectByIdInSameStation"};
    protected String c = "GBK";

    public abstract void a(int i);

    public abstract void a(int i, ArrayList<fl> arrayList, ArrayList<fl> arrayList2);

    public abstract void a(ArrayList<fl> arrayList);

    public abstract void b(int i);

    public abstract void b(int i, ArrayList<fl> arrayList, ArrayList<fl> arrayList2);

    public abstract void c(int i);

    public abstract void c(int i, ArrayList<fl> arrayList, ArrayList<fl> arrayList2);

    public abstract void d(int i);

    public abstract void d(int i, ArrayList<fl> arrayList, ArrayList<fl> arrayList2);

    public abstract void e(int i);

    public abstract void e(int i, ArrayList<fl> arrayList, ArrayList<fl> arrayList2);

    public abstract void f(int i);

    public final int _onDispatch(String str, jp jpVar) {
        int binarySearch = Arrays.binarySearch(this.b, str);
        if (binarySearch < 0 || binarySearch >= 6) {
            return -1;
        }
        md mdVar;
        int a;
        ArrayList arrayList;
        ArrayList arrayList2;
        switch (binarySearch) {
            case 0:
                if (jpVar.e == 0) {
                    md mdVar2 = new md(jpVar.f);
                    mdVar2.a(this.c);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(new fl());
                    a((ArrayList) mdVar2.a(arrayList3, 0, true));
                    break;
                }
                a(jpVar.e);
                return jpVar.e;
            case 1:
                if (jpVar.e == 0) {
                    mdVar = new md(jpVar.f);
                    mdVar.a(this.c);
                    a = mdVar.a(0, 0, true);
                    arrayList = new ArrayList();
                    arrayList.add(new fl());
                    arrayList = (ArrayList) mdVar.a(arrayList, 2, true);
                    arrayList2 = new ArrayList();
                    arrayList2.add(new fl());
                    a(a, arrayList, (ArrayList) mdVar.a(arrayList2, 3, true));
                    break;
                }
                b(jpVar.e);
                return jpVar.e;
            case 2:
                if (jpVar.e == 0) {
                    mdVar = new md(jpVar.f);
                    mdVar.a(this.c);
                    a = mdVar.a(0, 0, true);
                    arrayList = new ArrayList();
                    arrayList.add(new fl());
                    arrayList = (ArrayList) mdVar.a(arrayList, 2, true);
                    arrayList2 = new ArrayList();
                    arrayList2.add(new fl());
                    e(a, arrayList, (ArrayList) mdVar.a(arrayList2, 3, true));
                    break;
                }
                f(jpVar.e);
                return jpVar.e;
            case 3:
                if (jpVar.e == 0) {
                    mdVar = new md(jpVar.f);
                    mdVar.a(this.c);
                    a = mdVar.a(0, 0, true);
                    arrayList = new ArrayList();
                    arrayList.add(new fl());
                    arrayList = (ArrayList) mdVar.a(arrayList, 2, true);
                    arrayList2 = new ArrayList();
                    arrayList2.add(new fl());
                    b(a, arrayList, (ArrayList) mdVar.a(arrayList2, 3, true));
                    break;
                }
                c(jpVar.e);
                return jpVar.e;
            case 4:
                if (jpVar.e == 0) {
                    mdVar = new md(jpVar.f);
                    mdVar.a(this.c);
                    a = mdVar.a(0, 0, true);
                    arrayList = new ArrayList();
                    arrayList.add(new fl());
                    arrayList = (ArrayList) mdVar.a(arrayList, 3, true);
                    arrayList2 = new ArrayList();
                    arrayList2.add(new fl());
                    d(a, arrayList, (ArrayList) mdVar.a(arrayList2, 4, true));
                    break;
                }
                e(jpVar.e);
                return jpVar.e;
            case 5:
                if (jpVar.e == 0) {
                    mdVar = new md(jpVar.f);
                    mdVar.a(this.c);
                    a = mdVar.a(0, 0, true);
                    arrayList = new ArrayList();
                    arrayList.add(new fl());
                    arrayList = (ArrayList) mdVar.a(arrayList, 3, true);
                    arrayList2 = new ArrayList();
                    arrayList2.add(new fl());
                    c(a, arrayList, (ArrayList) mdVar.a(arrayList2, 4, true));
                    break;
                }
                d(jpVar.e);
                return jpVar.e;
        }
        return 0;
    }
}
