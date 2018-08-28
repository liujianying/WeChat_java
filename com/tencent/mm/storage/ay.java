package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.g;
import java.util.List;

public interface ay extends g {

    public interface a {
        void a(ay ayVar, ab abVar);
    }

    String MD();

    void Q(ab abVar);

    boolean R(ab abVar);

    boolean S(ab abVar);

    boolean T(ab abVar);

    int U(ab abVar);

    ab Yb(String str);

    boolean Yc(String str);

    ab Yd(String str);

    ab Ye(String str);

    ab Yf(String str);

    ab Yg(String str);

    long Yh(String str);

    boolean Yi(String str);

    boolean Yj(String str);

    byte[] Yk(String str);

    int Yl(String str);

    int Ym(String str);

    String Yn(String str);

    int a(String str, ab abVar);

    Cursor a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2);

    Cursor a(List<String> list, String str, List<String> list2);

    Cursor a(String[] strArr, String str, String str2, List<String> list, List<String> list2);

    Cursor a(String[] strArr, String str, List<String> list);

    void a(a aVar);

    int b(String str, ab abVar);

    int b(String[] strArr, String... strArr2);

    Cursor b(String str, String str2, List<String> list);

    Cursor b(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2);

    void b(a aVar);

    int[] b(String str, String str2, String str3, List<String> list);

    int[] b(String str, String str2, String[] strArr, List<String> list);

    Cursor bdj();

    int c(String[] strArr, String... strArr2);

    Cursor c(String str, String str2, List<String> list);

    void c(String str, ab abVar);

    int[] c(String str, String str2, String str3, List<String> list);

    int[] c(String str, String str2, String[] strArr, List<String> list);

    List<String> cli();

    List<String> clj();

    Cursor clk();

    Cursor cll();

    Cursor clm();

    Cursor cln();

    int clo();

    Cursor clw();

    Cursor d(String str, String str2, List<String> list);

    Cursor df(List<String> list);

    Cursor dg(List<String> list);

    Cursor dh(List<String> list);

    Cursor di(List<String> list);

    Cursor dl(List<String> list);

    Cursor dm(List<String> list);

    Cursor dn(List<String> list);

    Cursor do(List<String> list);

    List<String> dp(List<String> list);

    int[] dq(List<String> list);

    int[] dr(List<String> list);

    String e(String str, String str2, List<String> list);

    ab gl(long j);

    Cursor h(List<String> list, boolean z);

    int x(String str, byte[] bArr);
}
