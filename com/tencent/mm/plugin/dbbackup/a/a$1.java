package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.wcdb.repair.RepairKit.Callback;

class a$1 implements Callback {
    private int iaP = 0;
    private boolean iaQ = false;
    final /* synthetic */ int[] iaR;
    final /* synthetic */ a iaS;
    private int pF = 0;

    a$1(a aVar, int[] iArr) {
        this.iaS = aVar;
        this.iaR = iArr;
    }

    public final int onProgress(String str, int i, Cursor cursor) {
        if (this.iaP == 0) {
            if (str.equalsIgnoreCase("message")) {
                this.iaP = i;
            }
            return 0;
        } else if (this.iaP != i) {
            if (!this.iaQ) {
                this.iaQ = true;
                a.a(this.iaS, new Integer[]{Integer.valueOf(3)});
            }
            return 0;
        }
        int i2 = this.pF;
        this.pF = i2 + 1;
        if (i2 % 1000 == 0) {
            a.b(this.iaS, new Integer[]{Integer.valueOf(2), Integer.valueOf(this.pF - 1), Integer.valueOf(a.a(this.iaS))});
        }
        int[] iArr = this.iaR;
        iArr[0] = iArr[0] + 1;
        return 0;
    }
}
