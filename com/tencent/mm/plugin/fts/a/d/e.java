package com.tencent.mm.plugin.fts.a.d;

import android.view.View;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public interface e {

    public static class a {
        public int iPZ = 0;
        public g jrx = null;
        public int jta = Integer.MAX_VALUE;
        public boolean jtb = true;
        public int jtc = Integer.MAX_VALUE;
        public boolean jtd = false;
        public List<l> jte = null;
        public boolean jtf = true;
        public l jtg;
        public int jth = 0;

        public final String toString() {
            int i = 0;
            String str = "{%d, %b, %d, %b, %d, %d, %d}";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(this.jta);
            objArr[1] = Boolean.valueOf(this.jtb);
            objArr[2] = Integer.valueOf(this.jtc);
            objArr[3] = Boolean.valueOf(this.jtd);
            objArr[4] = Integer.valueOf(this.iPZ);
            if (this.jte != null) {
                i = this.jte.size();
            }
            objArr[5] = Integer.valueOf(i);
            objArr[6] = Integer.valueOf(this.jth);
            return String.format(str, objArr);
        }
    }

    void a(String str, ag agVar, HashSet<String> hashSet);

    boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z);

    void aQe();

    LinkedList<Integer> aQf();

    int aQg();

    void acV();

    int getType();

    int qg(int i);

    com.tencent.mm.plugin.fts.a.d.a.a qh(int i);
}
