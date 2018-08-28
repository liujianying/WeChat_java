package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;

public final class d {
    private static final Object mLock = new Object();
    private static d rg;
    private final Handler mHandler;
    private final Context rc;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> rd = new HashMap();
    private final HashMap<String, ArrayList<b>> re = new HashMap();
    private final ArrayList<a> rf = new ArrayList();

    public static d O(Context context) {
        d dVar;
        synchronized (mLock) {
            if (rg == null) {
                rg = new d(context.getApplicationContext());
            }
            dVar = rg;
        }
        return dVar;
    }

    private d(Context context) {
        this.rc = context;
        this.mHandler = new 1(this, context.getMainLooper());
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.rd) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.rd.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.rd.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < intentFilter.countActions()) {
                    String action = intentFilter.getAction(i2);
                    arrayList = (ArrayList) this.re.get(action);
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                        this.re.put(action, arrayList);
                    }
                    arrayList.add(bVar);
                    i = i2 + 1;
                }
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.rd) {
            ArrayList arrayList = (ArrayList) this.rd.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                IntentFilter intentFilter = (IntentFilter) arrayList.get(i);
                for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                    String action = intentFilter.getAction(i2);
                    ArrayList arrayList2 = (ArrayList) this.re.get(action);
                    if (arrayList2 != null) {
                        int i3 = 0;
                        while (i3 < arrayList2.size()) {
                            int i4;
                            if (((b) arrayList2.get(i3)).rj == broadcastReceiver) {
                                arrayList2.remove(i3);
                                i4 = i3 - 1;
                            } else {
                                i4 = i3;
                            }
                            i3 = i4 + 1;
                        }
                        if (arrayList2.size() <= 0) {
                            this.re.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Intent r16) {
        /*
        r15 = this;
        r13 = r15.rd;
        monitor-enter(r13);
        r2 = r16.getAction();	 Catch:{ all -> 0x00c4 }
        r1 = r15.rc;	 Catch:{ all -> 0x00c4 }
        r1 = r1.getContentResolver();	 Catch:{ all -> 0x00c4 }
        r0 = r16;
        r3 = r0.resolveTypeIfNeeded(r1);	 Catch:{ all -> 0x00c4 }
        r5 = r16.getData();	 Catch:{ all -> 0x00c4 }
        r4 = r16.getScheme();	 Catch:{ all -> 0x00c4 }
        r6 = r16.getCategories();	 Catch:{ all -> 0x00c4 }
        r1 = r16.getFlags();	 Catch:{ all -> 0x00c4 }
        r1 = r1 & 8;
        if (r1 == 0) goto L_0x0097;
    L_0x0027:
        r1 = 1;
        r12 = r1;
    L_0x0029:
        if (r12 == 0) goto L_0x004e;
    L_0x002b:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r7 = "Resolving type ";
        r1.<init>(r7);	 Catch:{ all -> 0x00c4 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x00c4 }
        r7 = " scheme ";
        r1 = r1.append(r7);	 Catch:{ all -> 0x00c4 }
        r1 = r1.append(r4);	 Catch:{ all -> 0x00c4 }
        r7 = " of intent ";
        r1 = r1.append(r7);	 Catch:{ all -> 0x00c4 }
        r0 = r16;
        r1.append(r0);	 Catch:{ all -> 0x00c4 }
    L_0x004e:
        r1 = r15.re;	 Catch:{ all -> 0x00c4 }
        r7 = r16.getAction();	 Catch:{ all -> 0x00c4 }
        r1 = r1.get(r7);	 Catch:{ all -> 0x00c4 }
        r0 = r1;
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x00c4 }
        r8 = r0;
        if (r8 == 0) goto L_0x00fc;
    L_0x005e:
        if (r12 == 0) goto L_0x006b;
    L_0x0060:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r7 = "Action list: ";
        r1.<init>(r7);	 Catch:{ all -> 0x00c4 }
        r1.append(r8);	 Catch:{ all -> 0x00c4 }
    L_0x006b:
        r10 = 0;
        r1 = 0;
        r11 = r1;
    L_0x006e:
        r1 = r8.size();	 Catch:{ all -> 0x00c4 }
        if (r11 >= r1) goto L_0x00c7;
    L_0x0074:
        r1 = r8.get(r11);	 Catch:{ all -> 0x00c4 }
        r0 = r1;
        r0 = (android.support.v4.content.d.b) r0;	 Catch:{ all -> 0x00c4 }
        r9 = r0;
        if (r12 == 0) goto L_0x008b;
    L_0x007e:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r7 = "Matching against filter ";
        r1.<init>(r7);	 Catch:{ all -> 0x00c4 }
        r7 = r9.filter;	 Catch:{ all -> 0x00c4 }
        r1.append(r7);	 Catch:{ all -> 0x00c4 }
    L_0x008b:
        r1 = r9.rk;	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x009a;
    L_0x008f:
        if (r12 == 0) goto L_0x0101;
    L_0x0091:
        r1 = r10;
    L_0x0092:
        r7 = r11 + 1;
        r11 = r7;
        r10 = r1;
        goto L_0x006e;
    L_0x0097:
        r1 = 0;
        r12 = r1;
        goto L_0x0029;
    L_0x009a:
        r1 = r9.filter;	 Catch:{ all -> 0x00c4 }
        r7 = "LocalBroadcastManager";
        r1 = r1.match(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x00c4 }
        if (r1 < 0) goto L_0x0101;
    L_0x00a5:
        if (r12 == 0) goto L_0x00b6;
    L_0x00a7:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r14 = "  Filter matched!  match=0x";
        r7.<init>(r14);	 Catch:{ all -> 0x00c4 }
        r1 = java.lang.Integer.toHexString(r1);	 Catch:{ all -> 0x00c4 }
        r7.append(r1);	 Catch:{ all -> 0x00c4 }
    L_0x00b6:
        if (r10 != 0) goto L_0x00ff;
    L_0x00b8:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00c4 }
        r1.<init>();	 Catch:{ all -> 0x00c4 }
    L_0x00bd:
        r1.add(r9);	 Catch:{ all -> 0x00c4 }
        r7 = 1;
        r9.rk = r7;	 Catch:{ all -> 0x00c4 }
        goto L_0x0092;
    L_0x00c4:
        r1 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x00c4 }
        throw r1;
    L_0x00c7:
        if (r10 == 0) goto L_0x00fc;
    L_0x00c9:
        r1 = 0;
        r2 = r1;
    L_0x00cb:
        r1 = r10.size();	 Catch:{ all -> 0x00c4 }
        if (r2 >= r1) goto L_0x00de;
    L_0x00d1:
        r1 = r10.get(r2);	 Catch:{ all -> 0x00c4 }
        r1 = (android.support.v4.content.d.b) r1;	 Catch:{ all -> 0x00c4 }
        r3 = 0;
        r1.rk = r3;	 Catch:{ all -> 0x00c4 }
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x00cb;
    L_0x00de:
        r1 = r15.rf;	 Catch:{ all -> 0x00c4 }
        r2 = new android.support.v4.content.d$a;	 Catch:{ all -> 0x00c4 }
        r0 = r16;
        r2.<init>(r0, r10);	 Catch:{ all -> 0x00c4 }
        r1.add(r2);	 Catch:{ all -> 0x00c4 }
        r1 = r15.mHandler;	 Catch:{ all -> 0x00c4 }
        r2 = 1;
        r1 = r1.hasMessages(r2);	 Catch:{ all -> 0x00c4 }
        if (r1 != 0) goto L_0x00f9;
    L_0x00f3:
        r1 = r15.mHandler;	 Catch:{ all -> 0x00c4 }
        r2 = 1;
        r1.sendEmptyMessage(r2);	 Catch:{ all -> 0x00c4 }
    L_0x00f9:
        r1 = 1;
        monitor-exit(r13);	 Catch:{ all -> 0x00c4 }
    L_0x00fb:
        return r1;
    L_0x00fc:
        monitor-exit(r13);	 Catch:{ all -> 0x00c4 }
        r1 = 0;
        goto L_0x00fb;
    L_0x00ff:
        r1 = r10;
        goto L_0x00bd;
    L_0x0101:
        r1 = r10;
        goto L_0x0092;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.d.a(android.content.Intent):boolean");
    }
}
