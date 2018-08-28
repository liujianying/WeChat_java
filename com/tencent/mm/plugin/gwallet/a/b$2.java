package com.tencent.mm.plugin.gwallet.a;

import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.List;

class b$2 implements Runnable {
    final /* synthetic */ ag hlG;
    final /* synthetic */ b kiV;
    final /* synthetic */ List kiW;
    final /* synthetic */ b kiX;

    public b$2(b bVar, List list, b bVar2, ag agVar) {
        this.kiV = bVar;
        this.kiW = list;
        this.kiX = bVar2;
        this.hlG = agVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r6 = this;
        r0 = 0;
        r1 = r6.kiW;
        r2 = r1.iterator();
        r1 = r0;
    L_0x0008:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x00b3;
    L_0x000e:
        r0 = r2.next();
        r0 = (java.lang.String) r0;
        r3 = r6.kiV;	 Catch:{ a -> 0x007e }
        r4 = "consume";
        r3.EC(r4);	 Catch:{ a -> 0x007e }
        if (r0 == 0) goto L_0x0027;
    L_0x001e:
        r4 = "";
        r4 = r0.equals(r4);	 Catch:{ RemoteException -> 0x0067 }
        if (r4 == 0) goto L_0x0041;
    L_0x0027:
        r4 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0067 }
        r5 = "Can't consume ";
        r4.<init>(r5);	 Catch:{ RemoteException -> 0x0067 }
        r4 = r4.append(r0);	 Catch:{ RemoteException -> 0x0067 }
        r5 = ". No token.";
        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0067 }
        r4 = r4.toString();	 Catch:{ RemoteException -> 0x0067 }
        com.tencent.mm.plugin.gwallet.a.b.ED(r4);	 Catch:{ RemoteException -> 0x0067 }
    L_0x0041:
        r4 = r3.kiO;	 Catch:{ RemoteException -> 0x0067 }
        r5 = 3;
        r3 = r3.mContext;	 Catch:{ RemoteException -> 0x0067 }
        r3 = r3.getPackageName();	 Catch:{ RemoteException -> 0x0067 }
        r3 = r4.c(r5, r3, r0);	 Catch:{ RemoteException -> 0x0067 }
        if (r3 != 0) goto L_0x0087;
    L_0x0050:
        r3 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0067 }
        r4 = "Successfully consumed token: ";
        r3.<init>(r4);	 Catch:{ RemoteException -> 0x0067 }
        r3 = r3.append(r0);	 Catch:{ RemoteException -> 0x0067 }
        r3 = r3.toString();	 Catch:{ RemoteException -> 0x0067 }
        r4 = "MicroMsg.IabHelper";
        com.tencent.mm.sdk.platformtools.x.d(r4, r3);	 Catch:{ RemoteException -> 0x0067 }
        goto L_0x0008;
    L_0x0067:
        r1 = move-exception;
        r3 = new com.tencent.mm.plugin.gwallet.a.a;	 Catch:{ a -> 0x007e }
        r4 = new java.lang.StringBuilder;	 Catch:{ a -> 0x007e }
        r5 = "Remote exception while consuming. token: ";
        r4.<init>(r5);	 Catch:{ a -> 0x007e }
        r0 = r4.append(r0);	 Catch:{ a -> 0x007e }
        r0 = r0.toString();	 Catch:{ a -> 0x007e }
        r3.<init>(r0, r1);	 Catch:{ a -> 0x007e }
        throw r3;	 Catch:{ a -> 0x007e }
    L_0x007e:
        r0 = move-exception;
        r0 = r0.kiN;
        r0 = r0.aVR();
        r1 = r0;
        goto L_0x0008;
    L_0x0087:
        r1 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0067 }
        r4 = "Error consuming consuming token ";
        r1.<init>(r4);	 Catch:{ RemoteException -> 0x0067 }
        r1 = r1.append(r0);	 Catch:{ RemoteException -> 0x0067 }
        r1 = r1.toString();	 Catch:{ RemoteException -> 0x0067 }
        r4 = "MicroMsg.IabHelper";
        com.tencent.mm.sdk.platformtools.x.d(r4, r1);	 Catch:{ RemoteException -> 0x0067 }
        r1 = new com.tencent.mm.plugin.gwallet.a.a;	 Catch:{ RemoteException -> 0x0067 }
        r4 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0067 }
        r5 = "Error consuming token ";
        r4.<init>(r5);	 Catch:{ RemoteException -> 0x0067 }
        r4 = r4.append(r0);	 Catch:{ RemoteException -> 0x0067 }
        r4 = r4.toString();	 Catch:{ RemoteException -> 0x0067 }
        r1.<init>(r3, r4);	 Catch:{ RemoteException -> 0x0067 }
        throw r1;	 Catch:{ RemoteException -> 0x0067 }
    L_0x00b3:
        r0 = r6.kiX;
        if (r0 == 0) goto L_0x00c9;
    L_0x00b7:
        r0 = new com.tencent.mm.plugin.gwallet.a.c;
        r2 = "";
        r0.<init>(r1, r2);
        r1 = r6.hlG;
        r2 = new com.tencent.mm.plugin.gwallet.a.b$2$1;
        r2.<init>(r6, r0);
        r1.post(r2);
    L_0x00c9:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gwallet.a.b$2.run():void");
    }
}
