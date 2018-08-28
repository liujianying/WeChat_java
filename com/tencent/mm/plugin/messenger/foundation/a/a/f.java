package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.d;
import com.tencent.mm.storage.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public interface f extends com.tencent.mm.sdk.e.f {

    public interface a {
        void a(f fVar, c cVar);
    }

    public static class b {
        public long dTS;
        public a[] lct;
        public int lcu;
        public String name;

        private static class a {
            public long lcv;
            public long lcw;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public b(int i, String str, a[] aVarArr) {
            boolean z;
            boolean z2 = true;
            Assert.assertTrue(str.length() > 0);
            this.name = str;
            if (aVarArr.length == 2) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            Assert.assertTrue(aVarArr[0].lcw >= aVarArr[0].lcv);
            Assert.assertTrue(aVarArr[1].lcw >= aVarArr[1].lcv);
            if (aVarArr[1].lcv < aVarArr[0].lcw) {
                z2 = false;
            }
            Assert.assertTrue(z2);
            this.lct = aVarArr;
            this.lcu = i;
            this.dTS = aVarArr[0].lcv;
        }

        public final synchronized void bdn() {
            if (this.dTS == this.lct[0].lcw) {
                this.dTS = this.lct[1].lcv;
                com.tencent.mm.plugin.report.f.mDy.a(111, 251, 1, false);
            } else {
                this.dTS++;
            }
            if (!com.tencent.mm.sdk.a.b.chr()) {
                x.i("MicroMsg.MsgTable", "incMsgLocalId %d  ", Long.valueOf(this.dTS));
            }
        }

        public final boolean eb(long j) {
            for (a aVar : this.lct) {
                boolean z = j >= aVar.lcv && j <= aVar.lcw;
                if (z) {
                    return true;
                }
            }
            return false;
        }

        public static a[] a(long j, long j2, long j3, long j4) {
            a[] aVarArr = new a[2];
            a aVar = new a();
            aVar.lcv = j;
            aVar.lcw = j2;
            aVarArr[0] = aVar;
            aVar = new a();
            aVar.lcv = j3;
            aVar.lcw = j4;
            aVarArr[1] = aVar;
            return aVarArr;
        }
    }

    public static class c {
        public long hpD;
        public int lcA;
        public int lcB;
        public long lcC;
        public String lcx;
        public ArrayList<bd> lcy;
        public int lcz;
        public String talker;

        public c(String str, String str2, bd bdVar) {
            this(str, str2, bdVar, 0);
        }

        public c(String str, String str2, bd bdVar, int i) {
            long j = -1;
            this.lcy = new ArrayList();
            this.lcA = 0;
            this.lcB = 0;
            this.lcC = 0;
            this.hpD = -1;
            this.talker = str;
            this.lcx = str2;
            this.lcz = i;
            if (bdVar != null) {
                j = bdVar.field_bizChatId;
            }
            this.hpD = j;
            if (bdVar != null) {
                this.lcy.add(bdVar);
            }
        }

        public c(String str, String str2, bd bdVar, int i, byte b) {
            this(str, str2, bdVar, 0);
            this.lcB = i;
        }

        public static boolean W(bd bdVar) {
            return bdVar != null && bdVar.field_isSend == 0 && bdVar.field_status == 3;
        }
    }

    Cursor E(String str, String str2, int i);

    void E(ArrayList<Long> arrayList);

    void GA(String str);

    void GB(String str);

    Cursor GC(String str);

    bd GD(String str);

    bd GE(String str);

    bd GF(String str);

    bd GG(String str);

    List<bd> GH(String str);

    Cursor GI(String str);

    void GJ(String str);

    int GK(String str);

    boolean GL(String str);

    int GM(String str);

    Cursor GN(String str);

    Cursor GO(String str);

    com.tencent.mm.storage.bd.c GP(String str);

    d GQ(String str);

    com.tencent.mm.storage.bd.a GR(String str);

    com.tencent.mm.storage.bd.b GS(String str);

    int GT(String str);

    boolean GU(String str);

    int GV(String str);

    int GW(String str);

    String GX(String str);

    long GY(String str);

    long GZ(String str);

    void Gz(String str);

    void H(String str, long j);

    long Ha(String str);

    bd Hb(String str);

    int Hc(String str);

    List<bd> Hd(String str);

    long He(String str);

    Cursor Hf(String str);

    bd I(String str, long j);

    bd J(String str, long j);

    bd K(String str, long j);

    List<bd> L(String str, long j);

    List<bd> M(String str, long j);

    bd N(String str, long j);

    bd O(String str, long j);

    boolean P(String str, long j);

    long Q(String str, long j);

    int R(String str, long j);

    int S(bd bdVar);

    int S(String str, long j);

    int T(String str, long j);

    long T(bd bdVar);

    String U(String str, long j);

    void U(bd bdVar);

    int V(bd bdVar);

    bd V(String str, long j);

    bd W(String str, long j);

    long X(String str, long j);

    List<bd> X(String str, int i, int i2);

    long Y(String str, long j);

    Cursor Y(String str, int i, int i2);

    Cursor a(String str, long j, long j2, boolean z);

    void a(long j, bd bdVar);

    void a(h hVar, String str);

    void a(a aVar);

    void a(a aVar, Looper looper);

    void a(b bVar);

    void a(c cVar);

    void a(e eVar);

    long b(bd bdVar, boolean z);

    Cursor b(String str, long j, long j2, int i);

    void b(long j, bd bdVar);

    void b(String str, String str2, String[] strArr);

    Cursor bA(String str, int i);

    Cursor bB(String str, int i);

    int bC(String str, int i);

    Cursor bD(String str, int i);

    Cursor bE(String str, int i);

    int bF(String str, int i);

    Cursor bG(String str, int i);

    bd[] bH(String str, int i);

    Cursor bI(String str, int i);

    h bdc();

    void bdd();

    void bde();

    void bdf();

    ArrayList<bd> bdg();

    List<bd> bdh();

    Cursor bdi();

    Cursor bdj();

    String bdk();

    String bdl();

    List<bd> bdm();

    List<bd> by(String str, int i);

    List<bd> bz(String str, int i);

    int c(String str, long j, int i);

    Cursor d(String str, long j, int i);

    List<bd> d(String str, long j, boolean z);

    bd dG(String str, String str2);

    Cursor dH(String str, String str2);

    int dI(String str, String str2);

    LinkedList<bd> dJ(String str, String str2);

    bd dW(long j);

    int dX(long j);

    boolean dY(long j);

    boolean dZ(long j);

    void ea(long j);

    Cursor f(String str, int i, long j);

    Cursor g(String str, int i, long j);

    Cursor h(String str, int i, long j);

    Cursor n(String str, long j, long j2);

    int o(String str, long j, long j2);

    int p(String str, long j, long j2);

    Cursor q(String str, long j, long j2);

    int r(String str, long j, long j2);

    Cursor s(String str, long j, long j2);

    bd sx(int i);
}
