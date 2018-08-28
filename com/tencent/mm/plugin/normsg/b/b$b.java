package com.tencent.mm.plugin.normsg.b;

import android.os.Handler.Callback;
import android.os.Message;
import java.lang.ref.WeakReference;

final class b$b implements Callback {
    final /* synthetic */ b lGB;
    private final WeakReference<Object> lGE;
    private final Callback lGF;

    b$b(b bVar, Object obj, Callback callback) {
        this.lGB = bVar;
        this.lGE = new WeakReference(obj);
        this.lGF = callback;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r10) {
        /*
        r9 = this;
        r4 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r9.lGE;
        r0 = r0.get();
        if (r0 != 0) goto L_0x0019;
    L_0x000b:
        r0 = "MicroMsg.AED";
        r1 = "lost viewRootImpl instance, give up intercepting.";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r9.q(r10);
    L_0x0018:
        return r0;
    L_0x0019:
        r1 = "getView";
        r5 = 0;
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x01ec }
        r0 = com.tencent.mm.plugin.normsg.b.h.b(r0, r1, r5, r6);	 Catch:{ Throwable -> 0x01ec }
        r0 = (android.view.View) r0;	 Catch:{ Throwable -> 0x01ec }
        if (r0 != 0) goto L_0x0036;
    L_0x0028:
        r0 = "MicroMsg.AED";
        r1 = "cannot find root view, give up intercepting.";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);	 Catch:{ Throwable -> 0x01ec }
        r0 = r9.q(r10);	 Catch:{ Throwable -> 0x01ec }
        goto L_0x0018;
    L_0x0036:
        r1 = r10.what;	 Catch:{ Throwable -> 0x01ec }
        switch(r1) {
            case 1: goto L_0x0058;
            case 2: goto L_0x0058;
            case 3: goto L_0x0058;
            case 4: goto L_0x0065;
            case 5: goto L_0x0058;
            case 6: goto L_0x0058;
            case 1020: goto L_0x0058;
            case 1021: goto L_0x0072;
            case 1022: goto L_0x0072;
            case 1023: goto L_0x0065;
            default: goto L_0x003b;
        };	 Catch:{ Throwable -> 0x01ec }
    L_0x003b:
        r6 = r4;
    L_0x003c:
        if (r6 != 0) goto L_0x0078;
    L_0x003e:
        r0 = "MicroMsg.AED";
        r1 = "callback is null, give up intercepting, op: %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x01ec }
        r3 = 0;
        r4 = r10.what;	 Catch:{ Throwable -> 0x01ec }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x01ec }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x01ec }
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);	 Catch:{ Throwable -> 0x01ec }
        r0 = r9.q(r10);	 Catch:{ Throwable -> 0x01ec }
        goto L_0x0018;
    L_0x0058:
        r1 = r10.obj;	 Catch:{ Throwable -> 0x01ec }
        r5 = "arg1";
        r1 = com.tencent.mm.plugin.normsg.b.h.g(r1, r5);	 Catch:{ Throwable -> 0x01ec }
        r1 = (android.os.IInterface) r1;	 Catch:{ Throwable -> 0x01ec }
        r6 = r1;
        goto L_0x003c;
    L_0x0065:
        r1 = r10.obj;	 Catch:{ Throwable -> 0x01ec }
        r5 = "arg2";
        r1 = com.tencent.mm.plugin.normsg.b.h.g(r1, r5);	 Catch:{ Throwable -> 0x01ec }
        r1 = (android.os.IInterface) r1;	 Catch:{ Throwable -> 0x01ec }
        r6 = r1;
        goto L_0x003c;
    L_0x0072:
        r1 = r10.obj;	 Catch:{ Throwable -> 0x01ec }
        r1 = (android.os.IInterface) r1;	 Catch:{ Throwable -> 0x01ec }
        r6 = r1;
        goto L_0x003c;
    L_0x0078:
        r1 = r6.getClass();	 Catch:{ Throwable -> 0x01ec }
        r1 = java.lang.reflect.Proxy.isProxyClass(r1);	 Catch:{ Throwable -> 0x01ec }
        if (r1 == 0) goto L_0x0098;
    L_0x0082:
        r1 = java.lang.reflect.Proxy.getInvocationHandler(r6);	 Catch:{ Throwable -> 0x01ec }
        r1 = r1 instanceof com.tencent.mm.plugin.normsg.b.b.e;	 Catch:{ Throwable -> 0x01ec }
        if (r1 == 0) goto L_0x0098;
    L_0x008a:
        r0 = "MicroMsg.AED";
        r1 = "reused callback, skip rest works.";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ Throwable -> 0x01ec }
        r0 = r9.q(r10);	 Catch:{ Throwable -> 0x01ec }
        goto L_0x0018;
    L_0x0098:
        r1 = r10.what;	 Catch:{ Throwable -> 0x01ec }
        switch(r1) {
            case 1: goto L_0x00e3;
            case 2: goto L_0x00e3;
            case 3: goto L_0x00e3;
            case 4: goto L_0x00e3;
            case 5: goto L_0x00e3;
            case 6: goto L_0x00e3;
            case 1020: goto L_0x00e3;
            case 1021: goto L_0x00e3;
            case 1022: goto L_0x00d3;
            case 1023: goto L_0x00e3;
            default: goto L_0x009d;
        };	 Catch:{ Throwable -> 0x01ec }
    L_0x009d:
        r5 = r4;
    L_0x009e:
        r0 = r10.what;	 Catch:{ Throwable -> 0x01ec }
        switch(r0) {
            case 1: goto L_0x0131;
            case 2: goto L_0x0131;
            case 3: goto L_0x0143;
            case 4: goto L_0x0131;
            case 5: goto L_0x0143;
            case 6: goto L_0x0131;
            case 1020: goto L_0x0131;
            case 1021: goto L_0x0155;
            case 1022: goto L_0x0155;
            case 1023: goto L_0x015a;
            default: goto L_0x00a3;
        };	 Catch:{ Throwable -> 0x01ec }
    L_0x00a3:
        r4 = r3;
    L_0x00a4:
        r0 = r9.lGB;	 Catch:{ Throwable -> 0x01ec }
        r0 = com.tencent.mm.plugin.normsg.b.b.c(r0);	 Catch:{ Throwable -> 0x01ec }
        r1 = r6.asBinder();	 Catch:{ Throwable -> 0x01ec }
        r0 = r0.remove(r1);	 Catch:{ Throwable -> 0x01ec }
        r0 = (java.lang.Integer) r0;	 Catch:{ Throwable -> 0x01ec }
        if (r0 != 0) goto L_0x016c;
    L_0x00b6:
        r0 = "MicroMsg.AED";
        r1 = "callback %s's binder is unmarked, give up intercept.";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x01ec }
        r3 = 0;
        r4 = r6.getClass();	 Catch:{ Throwable -> 0x01ec }
        r4 = r4.getName();	 Catch:{ Throwable -> 0x01ec }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x01ec }
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);	 Catch:{ Throwable -> 0x01ec }
        r0 = r9.q(r10);	 Catch:{ Throwable -> 0x01ec }
        goto L_0x0018;
    L_0x00d3:
        r1 = r10.what;	 Catch:{ Throwable -> 0x01ec }
        r4 = 1022; // 0x3fe float:1.432E-42 double:5.05E-321;
        if (r1 != r4) goto L_0x00e1;
    L_0x00d9:
        r1 = r10.arg1;	 Catch:{ Throwable -> 0x01ec }
    L_0x00db:
        r0 = r0.findViewById(r1);	 Catch:{ Throwable -> 0x01ec }
        r5 = r0;
        goto L_0x009e;
    L_0x00e1:
        r1 = r3;
        goto L_0x00db;
    L_0x00e3:
        r1 = r10.what;	 Catch:{ Throwable -> 0x01ec }
        switch(r1) {
            case 1: goto L_0x011b;
            case 2: goto L_0x010b;
            case 3: goto L_0x011b;
            case 4: goto L_0x010b;
            case 5: goto L_0x011e;
            case 6: goto L_0x011b;
            case 1020: goto L_0x010b;
            case 1021: goto L_0x012e;
            case 1023: goto L_0x010b;
            default: goto L_0x00e8;
        };	 Catch:{ Throwable -> 0x01ec }
    L_0x00e8:
        r1 = r3;
    L_0x00e9:
        r4 = com.tencent.mm.plugin.normsg.b.b.bjV();	 Catch:{ Throwable -> 0x01ec }
        r5 = 1;
        r5 = new java.lang.Class[r5];	 Catch:{ Throwable -> 0x01ec }
        r7 = 0;
        r8 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x01ec }
        r5[r7] = r8;	 Catch:{ Throwable -> 0x01ec }
        r5 = com.tencent.mm.plugin.normsg.b.h.b(r5);	 Catch:{ Throwable -> 0x01ec }
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x01ec }
        r8 = 0;
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x01ec }
        r7[r8] = r1;	 Catch:{ Throwable -> 0x01ec }
        r0 = com.tencent.mm.plugin.normsg.b.h.b(r0, r4, r5, r7);	 Catch:{ Throwable -> 0x01ec }
        r0 = (android.view.View) r0;	 Catch:{ Throwable -> 0x01ec }
        r5 = r0;
        goto L_0x009e;
    L_0x010b:
        r1 = r10.obj;	 Catch:{ Throwable -> 0x01ec }
        r4 = "argi1";
        r1 = com.tencent.mm.plugin.normsg.b.h.g(r1, r4);	 Catch:{ Throwable -> 0x01ec }
        r1 = (java.lang.Integer) r1;	 Catch:{ Throwable -> 0x01ec }
        r1 = r1.intValue();	 Catch:{ Throwable -> 0x01ec }
        goto L_0x00e9;
    L_0x011b:
        r1 = r10.arg2;	 Catch:{ Throwable -> 0x01ec }
        goto L_0x00e9;
    L_0x011e:
        r1 = r10.obj;	 Catch:{ Throwable -> 0x01ec }
        r4 = "argi2";
        r1 = com.tencent.mm.plugin.normsg.b.h.g(r1, r4);	 Catch:{ Throwable -> 0x01ec }
        r1 = (java.lang.Integer) r1;	 Catch:{ Throwable -> 0x01ec }
        r1 = r1.intValue();	 Catch:{ Throwable -> 0x01ec }
        goto L_0x00e9;
    L_0x012e:
        r1 = r10.arg1;	 Catch:{ Throwable -> 0x01ec }
        goto L_0x00e9;
    L_0x0131:
        r0 = r10.obj;	 Catch:{ Throwable -> 0x01ec }
        r1 = "argi3";
        r0 = com.tencent.mm.plugin.normsg.b.h.g(r0, r1);	 Catch:{ Throwable -> 0x01ec }
        r0 = (java.lang.Integer) r0;	 Catch:{ Throwable -> 0x01ec }
        r0 = r0.intValue();	 Catch:{ Throwable -> 0x01ec }
        r4 = r0;
        goto L_0x00a4;
    L_0x0143:
        r0 = r10.obj;	 Catch:{ Throwable -> 0x01ec }
        r1 = "argi1";
        r0 = com.tencent.mm.plugin.normsg.b.h.g(r0, r1);	 Catch:{ Throwable -> 0x01ec }
        r0 = (java.lang.Integer) r0;	 Catch:{ Throwable -> 0x01ec }
        r0 = r0.intValue();	 Catch:{ Throwable -> 0x01ec }
        r4 = r0;
        goto L_0x00a4;
    L_0x0155:
        r0 = r10.arg2;	 Catch:{ Throwable -> 0x01ec }
        r4 = r0;
        goto L_0x00a4;
    L_0x015a:
        r0 = r10.obj;	 Catch:{ Throwable -> 0x01ec }
        r1 = "argi2";
        r0 = com.tencent.mm.plugin.normsg.b.h.g(r0, r1);	 Catch:{ Throwable -> 0x01ec }
        r0 = (java.lang.Integer) r0;	 Catch:{ Throwable -> 0x01ec }
        r0 = r0.intValue();	 Catch:{ Throwable -> 0x01ec }
        r4 = r0;
        goto L_0x00a4;
    L_0x016c:
        r1 = r10.what;	 Catch:{ Throwable -> 0x01ec }
        switch(r1) {
            case 1: goto L_0x0177;
            case 2: goto L_0x01c6;
            case 3: goto L_0x01c6;
            case 4: goto L_0x01c6;
            case 5: goto L_0x01c6;
            case 6: goto L_0x01c6;
            case 1020: goto L_0x0177;
            case 1021: goto L_0x01c6;
            case 1022: goto L_0x01c6;
            case 1023: goto L_0x01c6;
            default: goto L_0x0171;
        };
    L_0x0171:
        r0 = r9.q(r10);
        goto L_0x0018;
    L_0x0177:
        r1 = r10.what;	 Catch:{ Throwable -> 0x01ec }
        switch(r1) {
            case 1: goto L_0x01b6;
            case 1020: goto L_0x01b6;
            default: goto L_0x017c;
        };	 Catch:{ Throwable -> 0x01ec }
    L_0x017c:
        r1 = r3;
    L_0x017d:
        r3 = r9.lGB;	 Catch:{ Throwable -> 0x01ec }
        r0 = r0.intValue();	 Catch:{ Throwable -> 0x01ec }
        r0 = com.tencent.mm.plugin.normsg.b.b.a(r3, r1, r0, r5);	 Catch:{ Throwable -> 0x01ec }
        if (r0 != 0) goto L_0x0171;
    L_0x0189:
        r0 = com.tencent.mm.plugin.normsg.b.b.bjW();	 Catch:{ Throwable -> 0x01ec }
        r1 = 2;
        r1 = new java.lang.Class[r1];	 Catch:{ Throwable -> 0x01ec }
        r3 = 0;
        r5 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x01ec }
        r1[r3] = r5;	 Catch:{ Throwable -> 0x01ec }
        r3 = 1;
        r5 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x01ec }
        r1[r3] = r5;	 Catch:{ Throwable -> 0x01ec }
        r1 = com.tencent.mm.plugin.normsg.b.h.b(r1);	 Catch:{ Throwable -> 0x01ec }
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x01ec }
        r5 = 0;
        r7 = 0;
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x01ec }
        r3[r5] = r7;	 Catch:{ Throwable -> 0x01ec }
        r5 = 1;
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x01ec }
        r3[r5] = r4;	 Catch:{ Throwable -> 0x01ec }
        com.tencent.mm.plugin.normsg.b.h.b(r6, r0, r1, r3);	 Catch:{ Throwable -> 0x01ec }
        r0 = r2;
        goto L_0x0018;
    L_0x01b6:
        r1 = r10.obj;	 Catch:{ Throwable -> 0x01ec }
        r3 = "argi2";
        r1 = com.tencent.mm.plugin.normsg.b.h.g(r1, r3);	 Catch:{ Throwable -> 0x01ec }
        r1 = (java.lang.Integer) r1;	 Catch:{ Throwable -> 0x01ec }
        r1 = r1.intValue();	 Catch:{ Throwable -> 0x01ec }
        goto L_0x017d;
    L_0x01c6:
        r1 = com.tencent.mm.plugin.normsg.b.b.bjP();	 Catch:{ Throwable -> 0x01ec }
        r2 = r6.getClass();	 Catch:{ Throwable -> 0x01ec }
        r2 = r2.getInterfaces();	 Catch:{ Throwable -> 0x01ec }
        r3 = new com.tencent.mm.plugin.normsg.b.b$b$1;	 Catch:{ Throwable -> 0x01ec }
        r3.<init>(r9, r6, r0, r5);	 Catch:{ Throwable -> 0x01ec }
        r0 = java.lang.reflect.Proxy.newProxyInstance(r1, r2, r3);	 Catch:{ Throwable -> 0x01ec }
        r0 = (android.os.IInterface) r0;	 Catch:{ Throwable -> 0x01ec }
        r1 = r10.what;	 Catch:{ Throwable -> 0x01ec }
        switch(r1) {
            case 1: goto L_0x01e3;
            case 2: goto L_0x01e3;
            case 3: goto L_0x01e3;
            case 4: goto L_0x01f4;
            case 5: goto L_0x01e3;
            case 6: goto L_0x01e3;
            case 1020: goto L_0x01e3;
            case 1021: goto L_0x01fe;
            case 1022: goto L_0x01fe;
            case 1023: goto L_0x01f4;
            default: goto L_0x01e2;
        };	 Catch:{ Throwable -> 0x01ec }
    L_0x01e2:
        goto L_0x0171;
    L_0x01e3:
        r1 = r10.obj;	 Catch:{ Throwable -> 0x01ec }
        r2 = "arg1";
        com.tencent.mm.plugin.normsg.b.h.a(r1, r2, r0);	 Catch:{ Throwable -> 0x01ec }
        goto L_0x0171;
    L_0x01ec:
        r0 = move-exception;
        r1 = r9.lGB;
        com.tencent.mm.plugin.normsg.b.b.a(r1, r0);
        goto L_0x0171;
    L_0x01f4:
        r1 = r10.obj;	 Catch:{ Throwable -> 0x01ec }
        r2 = "arg2";
        com.tencent.mm.plugin.normsg.b.h.a(r1, r2, r0);	 Catch:{ Throwable -> 0x01ec }
        goto L_0x0171;
    L_0x01fe:
        r10.obj = r0;	 Catch:{ Throwable -> 0x01ec }
        goto L_0x0171;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.normsg.b.b$b.handleMessage(android.os.Message):boolean");
    }

    private boolean q(Message message) {
        if (this.lGF != null) {
            return this.lGF.handleMessage(message);
        }
        return false;
    }
}
