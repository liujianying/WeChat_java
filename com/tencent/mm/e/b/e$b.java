package com.tencent.mm.e.b;

final class e$b implements Runnable {
    final /* synthetic */ e bEC;

    e$b(e eVar) {
        this.bEC = eVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r11 = this;
        r2 = -1;
        r10 = 1;
        r9 = 2;
        r3 = 0;
        r0 = "MicroMsg.RecordModeAsyncRead";
        r1 = "RecordThread started. frameSize:%d";
        r4 = new java.lang.Object[r10];
        r5 = r11.bEC;
        r5 = r5.bEm;
        r5 = java.lang.Integer.valueOf(r5);
        r4[r3] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);
        r0 = -123456789; // 0xfffffffff8a432eb float:-2.6642794E34 double:NaN;
        r1 = r11.bEC;
        r1 = r1.bDQ;
        if (r0 == r1) goto L_0x0043;
    L_0x0022:
        r0 = "MicroMsg.RecordModeAsyncRead";
        r1 = new java.lang.StringBuilder;
        r4 = "set priority to ";
        r1.<init>(r4);
        r4 = r11.bEC;
        r4 = r4.bDQ;
        r1 = r1.append(r4);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r11.bEC;
        r0 = r0.bDQ;
        android.os.Process.setThreadPriority(r0);
    L_0x0043:
        r0 = r11.bEC;
        r1 = r0.bEv;
        monitor-enter(r1);
        r0 = r11.bEC;	 Catch:{ all -> 0x009f }
        r0 = r0.mStatus;	 Catch:{ all -> 0x009f }
        if (r10 == r0) goto L_0x006a;
    L_0x004e:
        r0 = "MicroMsg.RecordModeAsyncRead";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009f }
        r3 = "status is not inited, now status: ";
        r2.<init>(r3);	 Catch:{ all -> 0x009f }
        r3 = r11.bEC;	 Catch:{ all -> 0x009f }
        r3 = r3.mStatus;	 Catch:{ all -> 0x009f }
        r2 = r2.append(r3);	 Catch:{ all -> 0x009f }
        r2 = r2.toString();	 Catch:{ all -> 0x009f }
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);	 Catch:{ all -> 0x009f }
        monitor-exit(r1);	 Catch:{ all -> 0x009f }
    L_0x0069:
        return;
    L_0x006a:
        r0 = r11.bEC;	 Catch:{ all -> 0x009f }
        r4 = 2;
        r0.mStatus = r4;	 Catch:{ all -> 0x009f }
        monitor-exit(r1);	 Catch:{ all -> 0x009f }
        r0 = r11.bEC;
        r0 = r0.bEm;
        r0 = new byte[r0];
    L_0x0076:
        r1 = r11.bEC;
        r1 = r1.mStatus;
        if (r9 != r1) goto L_0x0095;
    L_0x007c:
        r1 = r11.bEC;
        r1 = r1.bEu;
        monitor-enter(r1);
        r4 = r11.bEC;	 Catch:{ all -> 0x00c1 }
        r4 = r4.mIsPause;	 Catch:{ all -> 0x00c1 }
        if (r4 == 0) goto L_0x00a2;
    L_0x0087:
        r4 = r11.bEC;	 Catch:{ InterruptedException -> 0x0245 }
        r4 = r4.bEu;	 Catch:{ InterruptedException -> 0x0245 }
        r4.wait();	 Catch:{ InterruptedException -> 0x0245 }
    L_0x008e:
        r4 = r11.bEC;	 Catch:{ all -> 0x00c1 }
        r4 = r4.mStatus;	 Catch:{ all -> 0x00c1 }
        if (r9 == r4) goto L_0x00a2;
    L_0x0094:
        monitor-exit(r1);	 Catch:{ all -> 0x00c1 }
    L_0x0095:
        r0 = "MicroMsg.RecordModeAsyncRead";
        r1 = "RecordThread exited.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0069;
    L_0x009f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x009f }
        throw r0;
    L_0x00a2:
        monitor-exit(r1);	 Catch:{ all -> 0x00c1 }
        r1 = r11.bEC;
        r1 = r1.bEa;
        if (r1 != 0) goto L_0x00c4;
    L_0x00a9:
        r0 = "MicroMsg.RecordModeAsyncRead";
        r1 = "mAudioRecord is null, so stop record.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r11.bEC;
        r1 = r0.bEv;
        monitor-enter(r1);
        r0 = r11.bEC;	 Catch:{ all -> 0x00be }
        r2 = 3;
        r0.mStatus = r2;	 Catch:{ all -> 0x00be }
        monitor-exit(r1);	 Catch:{ all -> 0x00be }
        goto L_0x0095;
    L_0x00be:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00be }
        throw r0;
    L_0x00c1:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00c1 }
        throw r0;
    L_0x00c4:
        r1 = r11.bEC;
        r1 = r1.bDM;
        if (r1 == 0) goto L_0x00d0;
    L_0x00ca:
        r0 = r11.bEC;
        r0 = r0.bEm;
        r0 = new byte[r0];
    L_0x00d0:
        r1 = r11.bEC;
        r4 = r11.bEC;
        r4 = r4.bED;
        r4 = r4 + 1;
        r1.bED = r4;
        r1 = new com.tencent.mm.compatible.util.g$a;
        r1.<init>();
        r1 = r11.bEC;
        r1 = r1.bEa;
        r4 = r11.bEC;
        r4 = r4.bEm;
        r1 = r1.read(r0, r3, r4);
        r4 = r11.bEC;
        r4 = r4.mStatus;
        if (r9 != r4) goto L_0x0095;
    L_0x00f1:
        r4 = r11.bEC;
        r4 = r4.bEi;
        if (r4 == 0) goto L_0x00fe;
    L_0x00f7:
        r4 = r11.bEC;
        r4 = r4.bEi;
        r4.d(r1, r0);
    L_0x00fe:
        r4 = r11.bEC;
        r4 = r4.bEm;
        if (r4 == r1) goto L_0x011a;
    L_0x0104:
        r4 = "MicroMsg.RecordModeAsyncRead";
        r5 = new java.lang.StringBuilder;
        r6 = "read len ";
        r5.<init>(r6);
        r5 = r5.append(r1);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);
    L_0x011a:
        r4 = r11.bEC;
        r4 = r4.bEm;
        if (r1 >= r4) goto L_0x012e;
    L_0x0120:
        r4 = "MicroMsg.RecordModeAsyncRead";
        r5 = "read too fast? sleep 10 ms";
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);
        r4 = 10;
        java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0242 }
    L_0x012e:
        r4 = r11.bEC;
        r4 = r4.bEs;
        if (r4 == 0) goto L_0x0076;
    L_0x0134:
        if (r1 <= 0) goto L_0x0076;
    L_0x0136:
        r4 = r0.length;
        if (r1 <= r4) goto L_0x013a;
    L_0x0139:
        r1 = r0.length;
    L_0x013a:
        r4 = r11.bEC;
        r4 = r4.bEr;
        if (r4 == 0) goto L_0x022a;
    L_0x0140:
        r4 = r11.bEC;
        r4 = r4.mIsMute;
        if (r4 == 0) goto L_0x0149;
    L_0x0146:
        java.util.Arrays.fill(r0, r3, r1, r3);
    L_0x0149:
        r4 = r11.bEC;
        r5 = r4.bEr;
        if (r1 <= 0) goto L_0x0162;
    L_0x014f:
        r4 = r5.daJ;
        if (r4 == 0) goto L_0x0158;
    L_0x0153:
        r4 = r5.daK;
        r4.lock();
    L_0x0158:
        r4 = r5.daH;
        r6 = r5.daI;
        if (r4 != r6) goto L_0x0186;
    L_0x015e:
        r4 = r5.daE;
    L_0x0160:
        if (r1 <= r4) goto L_0x01c0;
    L_0x0162:
        r1 = r2;
    L_0x0163:
        if (r1 == 0) goto L_0x0076;
    L_0x0165:
        r4 = "MicroMsg.RecordModeAsyncRead";
        r5 = "WriteToBuffer Failed, ret:%d AudioBuffer length: %d";
        r6 = new java.lang.Object[r9];
        r1 = java.lang.Integer.valueOf(r1);
        r6[r3] = r1;
        r1 = r11.bEC;
        r1 = r1.bEr;
        r1 = r1.yx();
        r1 = java.lang.Integer.valueOf(r1);
        r6[r10] = r1;
        com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);
        goto L_0x0076;
    L_0x0186:
        r4 = r5.daI;
        r4 = r4 + 1;
        r6 = r5.daE;
        r4 = r4 % r6;
        r6 = r5.daH;
        if (r4 != r6) goto L_0x0193;
    L_0x0191:
        r4 = r3;
        goto L_0x0160;
    L_0x0193:
        r4 = r5.daH;
        r6 = r5.daI;
        if (r4 >= r6) goto L_0x01af;
    L_0x0199:
        r4 = r5.daI;
        r6 = r5.daH;
        r4 = r4 - r6;
        r5.daF = r4;
    L_0x01a0:
        r4 = r5.daJ;
        if (r4 == 0) goto L_0x01a9;
    L_0x01a4:
        r4 = r5.daK;
        r4.unlock();
    L_0x01a9:
        r4 = r5.daE;
        r6 = r5.daF;
        r4 = r4 - r6;
        goto L_0x0160;
    L_0x01af:
        r4 = r5.daH;
        r6 = r5.daI;
        if (r4 <= r6) goto L_0x01a0;
    L_0x01b5:
        r4 = r5.daI;
        r6 = r5.daE;
        r4 = r4 + r6;
        r6 = r5.daH;
        r4 = r4 - r6;
        r5.daF = r4;
        goto L_0x01a0;
    L_0x01c0:
        r4 = r5.daI;
        r4 = r4 + r1;
        r6 = r5.daE;
        r4 = r4 % r6;
        r6 = r5.daH;
        if (r4 != r6) goto L_0x01cc;
    L_0x01ca:
        r1 = r2;
        goto L_0x0163;
    L_0x01cc:
        r4 = r5.daJ;
        if (r4 == 0) goto L_0x01d5;
    L_0x01d0:
        r4 = r5.daK;
        r4.lock();
    L_0x01d5:
        r4 = r5.daH;
        r6 = r5.daI;
        if (r4 >= r6) goto L_0x021a;
    L_0x01db:
        r4 = r5.daE;
        r6 = r5.daI;
        r4 = r4 - r6;
        if (r1 <= r4) goto L_0x021a;
    L_0x01e2:
        r4 = r5.daG;
        r6 = r5.daI;
        r7 = r5.daE;
        r8 = r5.daI;
        r7 = r7 - r8;
        java.lang.System.arraycopy(r0, r3, r4, r6, r7);
        r4 = r5.daE;
        r6 = r5.daI;
        r4 = r4 - r6;
        r6 = r5.daG;
        r7 = r5.daE;
        r8 = r5.daI;
        r7 = r7 - r8;
        r7 = r1 - r7;
        java.lang.System.arraycopy(r0, r4, r6, r3, r7);
        r4 = r5.daE;
        r6 = r5.daI;
        r4 = r4 - r6;
        r1 = r1 - r4;
        r5.daI = r1;
        r1 = r5.daI;
        r4 = r5.daE;
        r1 = r1 % r4;
        r5.daI = r1;
    L_0x020e:
        r1 = r5.daJ;
        if (r1 == 0) goto L_0x0217;
    L_0x0212:
        r1 = r5.daK;
        r1.unlock();
    L_0x0217:
        r1 = r3;
        goto L_0x0163;
    L_0x021a:
        r4 = r5.daG;
        r6 = r5.daI;
        java.lang.System.arraycopy(r0, r3, r4, r6, r1);
        r4 = r5.daI;
        r1 = r1 + r4;
        r4 = r5.daE;
        r1 = r1 % r4;
        r5.daI = r1;
        goto L_0x020e;
    L_0x022a:
        r4 = r11.bEC;
        r4 = r4.bEs;
        if (r4 == 0) goto L_0x0076;
    L_0x0230:
        r4 = r11.bEC;
        r4 = r4.mIsMute;
        if (r4 == 0) goto L_0x0239;
    L_0x0236:
        java.util.Arrays.fill(r0, r3, r1, r3);
    L_0x0239:
        r4 = r11.bEC;
        r4 = r4.bEs;
        r4.s(r0, r1);
        goto L_0x0076;
    L_0x0242:
        r4 = move-exception;
        goto L_0x012e;
    L_0x0245:
        r4 = move-exception;
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.e.b.e$b.run():void");
    }
}
