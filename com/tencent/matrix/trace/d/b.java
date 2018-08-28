package com.tencent.matrix.trace.d;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import com.tencent.matrix.trace.core.MethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a implements com.tencent.matrix.trace.b.d, com.tencent.matrix.trace.c.a.a {
    final com.tencent.matrix.trace.a.a bsS;
    private final com.tencent.matrix.trace.b.c btI;
    private final com.tencent.matrix.trace.c.a btJ;
    private final HashMap<Integer, a> btK;
    private HandlerThread btL;
    private volatile boolean btM;
    private boolean btN = true;
    private long btO;
    private final LinkedList<d> btP = new LinkedList();
    private Handler mHandler;

    private static class a {
        long btQ;
        int index;

        /* synthetic */ a(long j, int i, byte b) {
            this(j, i);
        }

        private a(long j, int i) {
            this.btQ = j;
            this.index = i;
        }
    }

    private static final class b {
        g btR;
        com.tencent.matrix.trace.e.b.a btS;
        long btT;
        long btU;

        b(g gVar, com.tencent.matrix.trace.e.b.a aVar, long j, long j2) {
            this.btR = gVar;
            this.btS = aVar;
            this.btT = j;
            this.btU = j2;
        }
    }

    private final class c implements Runnable {
        private final long[] btV;
        private final b btW;

        /* synthetic */ c(b bVar, long[] jArr, b bVar2, byte b) {
            this(jArr, bVar2);
        }

        private c(long[] jArr, b bVar) {
            this.btV = jArr;
            this.btW = bVar;
        }

        public final void run() {
            long longValue;
            long[] jArr = this.btV;
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            for (long j : jArr) {
                if ((((j >> 63) & 1) == 1 ? 1 : null) != null) {
                    linkedList.push(Long.valueOf(j));
                } else {
                    int i = (int) ((j >> 43) & 1048575);
                    if (linkedList.isEmpty()) {
                        com.tencent.matrix.d.b.w("Matrix.EvilMethodTracer", "[analyse] method[%s] not found in! ", Integer.valueOf(i));
                    } else {
                        longValue = ((Long) linkedList.pop()).longValue();
                        while (((longValue >> 43) & 1048575) != ((long) i)) {
                            com.tencent.matrix.d.b.w("Matrix.EvilMethodTracer", "[analyse] method[%s] not match in! continue to find!", Integer.valueOf(i));
                            if (linkedList.isEmpty()) {
                                com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "[analyse] method[%s] not match in finally! ", Integer.valueOf(i));
                                longValue = 0;
                                break;
                            }
                            longValue = ((Long) linkedList.pop()).longValue();
                        }
                        d dVar = new d(i, (int) ((j & 8796093022207L) - (longValue & 8796093022207L)), linkedList.size());
                        d dVar2 = null;
                        if (!linkedList2.isEmpty()) {
                            dVar2 = (d) linkedList2.peek();
                        }
                        if (dVar2 == null || !dVar2.equals(dVar)) {
                            linkedList2.push(dVar);
                        } else {
                            dVar2.count++;
                            dVar2.btZ = (int) (((long) dVar.btZ) + ((long) dVar2.btZ));
                        }
                    }
                }
            }
            while (!linkedList.isEmpty()) {
                longValue = ((Long) linkedList.pop()).longValue();
                linkedList2.push(new d((int) ((longValue >> 43) & 1048575), (int) (this.btW.btU - (longValue & 8796093022207L)), linkedList.size()));
            }
            LinkedList linkedList3 = new LinkedList();
            b.this.a(b.a(linkedList2), linkedList3);
            b.a(b.this, linkedList3, this.btW);
            if (linkedList3.isEmpty()) {
                com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "type:%s [stack result is empty after trim, just ignore]", this.btW.btR.name());
                return;
            }
            ListIterator listIterator = linkedList3.listIterator();
            StringBuilder stringBuilder = new StringBuilder("\n");
            StringBuilder stringBuilder2 = new StringBuilder();
            StringBuilder stringBuilder3 = new StringBuilder();
            while (listIterator.hasNext()) {
                d dVar3 = (d) listIterator.next();
                stringBuilder.append(dVar3.print()).append(10);
                stringBuilder2.append(dVar3.toString()).append(10);
                if (this.btW.btR != g.FULL) {
                    b.a(b.this, stringBuilder3, dVar3, listIterator.hasNext(), this.btW.btT);
                }
            }
            com.tencent.matrix.d.b.i("Matrix.EvilMethodTracer", "[analyse result] %s", stringBuilder.toString());
            com.tencent.matrix.d.b.i("Matrix.EvilMethodTracer", "[analyse key] %s", stringBuilder3.toString());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("machine", b.this.bsS.aA(b.this.btG.application));
                jSONObject.put("detail", this.btW.btR.name());
                jSONObject.put("cost", this.btW.btT);
                if (this.btW.btR == g.ENTER) {
                    JSONObject jSONObject2 = new JSONObject();
                    com.tencent.matrix.trace.e.b.a aVar = this.btW.btS;
                    jSONObject2.put("viewDeep", aVar == null ? 0 : aVar.buS);
                    jSONObject2.put("viewCount", aVar == null ? 0 : aVar.buR);
                    jSONObject2.put("activity", aVar == null ? Integer.valueOf(0) : aVar.mActivityName);
                    jSONObject.put("viewInfo", jSONObject2);
                }
                jSONObject.put("stack", stringBuilder2.toString());
                jSONObject.put("stackKey", r1);
                b.this.b(jSONObject);
            } catch (JSONException e) {
                com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "[JSONException for stack %s, error: %s", stringBuilder2.toString(), e);
            }
        }
    }

    private static final class d {
        int axZ;
        int btY;
        int btZ;
        int count = 1;

        d(int i, int i2, int i3) {
            this.btY = i;
            this.btZ = i2;
            this.axZ = i3;
        }

        public final String toString() {
            return this.axZ + "," + this.btY + "," + this.count + "," + this.btZ;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (dVar.btY == this.btY && dVar.axZ == this.axZ) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public final String print() {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < this.axZ; i++) {
                stringBuffer.append('.');
            }
            return stringBuffer.toString() + this.btY + " " + this.count + " " + this.btZ;
        }
    }

    private class e implements Runnable {
        long bua = 0;
        String bub;

        e(String str, long j) {
            this.bua = j;
            this.bub = str;
        }

        public final void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("machine", b.this.bsS.aA(b.this.btG.application));
                jSONObject.put("cost", this.bua);
                jSONObject.put("scene", this.bub);
                a aVar = b.this;
                com.tencent.matrix.c.b bVar = new com.tencent.matrix.c.b();
                bVar.tag = "Trace_StartUp";
                bVar.brm = jSONObject;
                aVar.btG.a(bVar);
                com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "fuck", new Object[0]);
            } catch (JSONException e) {
                com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "[JSONException for StartUpReportTask error: %s", e);
            }
        }
    }

    private static final class f {
        d buc;
        f bud;
        LinkedList<f> bue = new LinkedList();

        static /* synthetic */ int a(f fVar) {
            return fVar.buc == null ? 0 : fVar.buc.axZ;
        }

        f(d dVar, f fVar) {
            this.buc = dVar;
            this.bud = fVar;
        }
    }

    private enum g {
        NORMAL,
        ENTER,
        ANR,
        FULL,
        STARTUP
    }

    static /* synthetic */ f a(LinkedList linkedList) {
        f fVar = null;
        f fVar2 = new f(null, null);
        ListIterator listIterator = linkedList.listIterator(0);
        while (listIterator.hasNext()) {
            f fVar3 = new f((d) listIterator.next(), fVar);
            if (fVar == null && f.a(fVar3) != 0) {
                com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "[stackToTree] begin error! why the frist node'depth is not 0!", new Object[0]);
                break;
            }
            int a = f.a(fVar3);
            if (a == 0) {
                fVar2.bue.push(fVar3);
            } else if (f.a(fVar) >= a) {
                f fVar4 = fVar;
                while (f.a(fVar4) > a) {
                    fVar4 = fVar4.bud;
                }
                if (fVar4.bud != null) {
                    fVar3.bud = fVar4.bud;
                    fVar4.bud.bue.push(fVar3);
                }
            } else if (f.a(fVar) < a) {
                fVar.bue.push(fVar3);
            }
            fVar = fVar3;
        }
        return fVar2;
    }

    static /* synthetic */ void a(b bVar, StringBuilder stringBuilder, d dVar, boolean z, long j) {
        if (!bVar.btP.isEmpty() || dVar.axZ == 0) {
            if (dVar.axZ == 0) {
                bVar.btP.push(dVar);
            } else if (!bVar.btP.isEmpty()) {
                if ((((float) dVar.btZ) * 1.0f) / ((float) ((d) bVar.btP.getLast()).btZ) >= 0.8f && (((float) dVar.btZ) * 1.0f) / ((float) j) >= 0.3f) {
                    bVar.btP.pop();
                    bVar.btP.push(dVar);
                }
            }
            if (!z) {
                if (bVar.btP.size() > 10) {
                    int size = bVar.btP.size() - 10;
                    Iterator listIterator = bVar.btP.listIterator();
                    while (true) {
                        int i = size;
                        if (!listIterator.hasNext()) {
                            size = i;
                            break;
                        }
                        if (((d) listIterator.next()).axZ == 0) {
                            listIterator.remove();
                            size = i - 1;
                        } else {
                            size = i;
                        }
                        if (size <= 10) {
                            break;
                        }
                    }
                    if (size > 0) {
                        bVar.btP.subList(0, 10);
                    }
                }
                Iterator it = bVar.btP.iterator();
                while (it.hasNext()) {
                    stringBuilder.append((d) it.next());
                    stringBuilder.append(10);
                }
                bVar.btP.clear();
            }
        }
    }

    public b(com.tencent.matrix.trace.a aVar, com.tencent.matrix.trace.a.a aVar2) {
        super(aVar);
        this.bsS = aVar2;
        this.btJ = new com.tencent.matrix.trace.c.a(com.tencent.matrix.d.a.tJ(), 5000);
        this.btI = new MethodBeat();
        this.btO = this.btI.getFirstTime();
        this.btK = new HashMap();
    }

    public final void onCreate() {
        super.onCreate();
        if (this.btI.isRealTrace()) {
            if (this.btL == null) {
                this.btL = com.tencent.matrix.d.a.cd("matrix_trace_analyse_thread");
                this.mHandler = new Handler(this.btL.getLooper());
            }
            if (this.btI != null) {
                this.btI.registerListener(this);
                this.btI.onCreate();
            }
            this.btJ.cancel();
            return;
        }
        com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "MethodBeat don't work, maybe it's wrong in trace Build!", new Object[0]);
        onDestroy();
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.btL != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.btL.quit();
            this.mHandler = null;
            this.btL = null;
        }
        this.btJ.cancel();
        if (this.btI != null) {
            this.btI.unregisterListener(this);
            this.btI.onDestroy();
        }
        this.btK.clear();
    }

    public final void h(long j, long j2) {
        if (this.btM) {
            this.btM = false;
            this.btN = false;
            this.btK.clear();
            tH();
            return;
        }
        int curIndex = this.btI.getCurIndex();
        if (j2 - j > this.bsS.btd) {
            com.tencent.matrix.d.b.e("Matrix.EvilMethodTracer", "[doFrame] dropped frame too much! lastIndex:%s index:%s", Integer.valueOf(0), Integer.valueOf(curIndex));
            a(g.NORMAL, curIndex - 1, this.btI.getBuffer(), (j2 - j) / 1000000);
        }
        tH();
        this.btJ.cancel();
        this.btJ.a(this, false);
    }

    private void tH() {
        if (!this.btN) {
            this.btI.reset();
        }
    }

    public final void tG() {
        long nanoTime = (System.nanoTime() / 1000000) - this.btI.getLastDiffTime();
        com.tencent.matrix.d.b.w("Matrix.EvilMethodTracer", "[onTimeExpire] maybe ANR!", new Object[0]);
        this.btM = true;
        this.btN = false;
        a(g.ANR, 0, this.btI.getCurIndex() - 1, this.btI.getBuffer(), null, 5000, nanoTime);
    }

    public final void b(long[] jArr) {
        long nanoTime = (System.nanoTime() / 1000000) - this.btI.getLastDiffTime();
        this.btM = true;
        a(g.FULL, 999999, jArr, (nanoTime - jArr[0]) & 8796093022207L);
        this.btJ.cancel();
    }

    public final void a(Activity activity, boolean z, int i, long[] jArr) {
        com.tencent.matrix.d.b.i("Matrix.EvilMethodTracer", "[onActivityEntered] activity:%s hashCode:%s isFocus:%s nowIndex:%s", activity.getClass().getSimpleName(), Integer.valueOf(activity.hashCode()), Boolean.valueOf(z), Integer.valueOf(i));
        if (z && this.btK.containsKey(Integer.valueOf(activity.hashCode()))) {
            Object obj;
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = (a) this.btK.get(Integer.valueOf(activity.hashCode()));
            long j = currentTimeMillis - aVar.btQ;
            com.tencent.matrix.d.b.i("Matrix.EvilMethodTracer", "[activity load time] activity name:%s cost:%sms", activity.getClass(), Long.valueOf(j));
            String simpleName = activity.getClass().getSimpleName();
            if (this.btO > 0) {
                long j2 = currentTimeMillis - this.btO;
                com.tencent.matrix.d.b.i("Matrix.EvilMethodTracer", "[handleStartUp] startUpTime:%sms activityName:%s", Long.valueOf(j2), simpleName);
                if (j2 >= this.bsS.btb) {
                    a(g.STARTUP, i, jArr, j2);
                }
                this.mHandler.post(new e(simpleName, j2));
                this.btO = -1;
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null && j >= this.bsS.btb) {
                View decorView = activity.getWindow().getDecorView();
                com.tencent.matrix.trace.e.b.a aVar2 = new com.tencent.matrix.trace.e.b.a();
                com.tencent.matrix.trace.e.b.a(aVar2, 0, decorView);
                aVar2.mActivityName = activity.getClass().getSimpleName();
                com.tencent.matrix.d.b.w("Matrix.EvilMethodTracer", "[onActivityEntered] type:%s cost:%sms index:[%s-%s] viewInfo:%s", aVar2.mActivityName, Long.valueOf(j), Integer.valueOf(aVar.index), Integer.valueOf(i), aVar2.toString());
                a(g.ENTER, aVar.index, i, jArr, aVar2, j, (System.nanoTime() / 1000000) - this.btI.getLastDiffTime());
            }
            this.btI.reset();
            this.btN = false;
        }
        this.btK.remove(Integer.valueOf(activity.hashCode()));
    }

    public final void onActivityCreated(Activity activity) {
        com.tencent.matrix.d.b.i("Matrix.EvilMethodTracer", "[onActivityCreated] activity:%s hashCode:%s", activity.getClass().getSimpleName(), Integer.valueOf(activity.hashCode()));
        super.onActivityCreated(activity);
        this.btN = true;
        this.btK.put(Integer.valueOf(activity.hashCode()), new a(System.currentTimeMillis(), Math.max(0, this.btI.getCurIndex() - 1), (byte) 0));
    }

    public final void onActivityPause(Activity activity) {
        super.onActivityPause(activity);
        this.btK.remove(Integer.valueOf(activity.hashCode()));
    }

    protected final String getTag() {
        return "Trace_EvilMethod";
    }

    public final void onBackground(Activity activity) {
        super.onBackground(activity);
        this.btJ.cancel();
    }

    private void a(g gVar, int i, long[] jArr, long j) {
        a(gVar, 0, i, jArr, null, j, (System.nanoTime() / 1000000) - this.btI.getLastDiffTime());
    }

    private void a(g gVar, int i, int i2, long[] jArr, com.tencent.matrix.trace.e.b.a aVar, long j, long j2) {
        int max = Math.max(0, i);
        int min = Math.min(jArr.length - 1, i2);
        if (max <= min) {
            Object obj = new long[((min - max) + 1)];
            System.arraycopy(jArr, max, obj, 0, (min - max) + 1);
            if (this.mHandler != null) {
                this.mHandler.post(new c(this, obj, new b(gVar, aVar, j, j2), (byte) 0));
            }
        }
    }

    private void a(f fVar, LinkedList<d> linkedList) {
        if (fVar != null && !fVar.bue.isEmpty()) {
            LinkedList linkedList2 = fVar.bue;
            while (!linkedList2.isEmpty()) {
                f fVar2 = (f) linkedList2.pop();
                linkedList.addLast(fVar2.buc);
                a(fVar2, linkedList);
            }
        }
    }
}
