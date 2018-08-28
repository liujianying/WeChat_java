package com.tencent.mm.plugin.backup.f;

import android.util.Pair;
import com.tencent.mm.ab.e;
import com.tencent.mm.bk.a;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.e.j;
import com.tencent.mm.plugin.backup.h.x;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;

public final class c extends b {
    private static String TAG = "MicroMsg.BackupDataPushScene";
    private e dKj;
    public x gXK = new x();
    private y gXL = new y();
    private int gXM = 0;
    private a gXN = null;
    private PByteArray gXz = new PByteArray();

    public interface b {
        void d(boolean z, String str, int i);
    }

    public static void a(b bVar, c cVar, String str, String str2, byte[] bArr) {
        int i;
        a aVar = new a(str2);
        if (aVar.dHI <= 0) {
            i = 1;
        } else {
            i = (int) (((long) aVar.dHI) / 524288);
            if (((long) aVar.dHI) % 524288 != 0) {
                i++;
            }
        }
        for (int i2 = 0; i2 < i; i2++) {
            cVar.a(new c(bVar, str, aVar, bArr));
        }
    }

    public static void a(b bVar, c cVar, String str, LinkedList<ey> linkedList, byte[] bArr) {
        cVar.a(new c(bVar, str, (LinkedList) linkedList, bArr));
    }

    private c(b bVar, String str, a aVar, byte[] bArr) {
        Pair pair;
        boolean z = true;
        this.gXK.hcI = str;
        this.gXK.hcJ = 2;
        this.dKj = new 1(this, bVar);
        this.gXN = aVar;
        a.b(aVar, this);
        a aVar2 = this.gXN;
        if (aVar2.dHI <= 0) {
            pair = new Pair(Integer.valueOf(0), new byte[0]);
        } else {
            int i = (int) (((long) (aVar2.dHI - aVar2.offset)) > 524288 ? 524288 : (long) (aVar2.dHI - aVar2.offset));
            Object obj = new byte[i];
            if (aVar2.gXR != null) {
                System.arraycopy(aVar2.gXR, aVar2.offset, obj, 0, i);
            } else {
                aVar2.b(obj, ((long) i) < 524288);
            }
            int i2 = aVar2.offset;
            aVar2.offset += i;
            pair = new Pair(Integer.valueOf(i2), obj);
        }
        if (pair.second == null || pair.first == null) {
            com.tencent.mm.sdk.platformtools.x.w(TAG, "BackupDataPushScene media backFileOp getNext error, file path:%s", new Object[]{this.gXN.filePath});
            this.gXK.hbs = null;
            return;
        }
        byte[] bArr2 = (byte[]) pair.second;
        this.gXK.hcK = this.gXN.dHI;
        this.gXK.hcL = ((Integer) pair.first).intValue();
        this.gXK.hcM = this.gXK.hcL + bArr2.length;
        x xVar = this.gXK;
        if (this.gXK.hcM != this.gXK.hcK) {
            z = false;
        }
        xVar.hbs = a(bArr2, z, bArr);
        asy();
    }

    private c(b bVar, String str, LinkedList<ey> linkedList, byte[] bArr) {
        byte[] toByteArray;
        this.gXK.hcI = str;
        this.gXK.hcJ = 1;
        this.dKj = new 2(this, bVar);
        try {
            ez ezVar = new ez();
            ezVar.hbG = linkedList;
            ezVar.hbF = linkedList.size();
            toByteArray = ezVar.toByteArray();
        } catch (Exception e) {
            Exception exception = e;
            String str2 = TAG;
            String str3 = "BackupDataPushScene text, BakChatMsgList to buf error, list size[%d], errMsg:%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
            objArr[1] = exception.getMessage();
            com.tencent.mm.sdk.platformtools.x.e(str2, str3, objArr);
            toByteArray = null;
        }
        if (toByteArray == null) {
            toByteArray = new byte[0];
        }
        this.gXK.hcL = 0;
        this.gXK.hcM = toByteArray.length;
        this.gXK.hcK = toByteArray.length;
        this.gXK.hbs = a(toByteArray, true, bArr);
        asy();
    }

    public final void mI(int i) {
        this.dKj.a(0, this.gXL.hcd, "", this);
    }

    private void asy() {
        this.gXM = asu();
        try {
            j.a(this.gXK.toByteArray(), this.gXM, (short) 6, this.gXz, b.gRy);
            int i = this.gXM;
            PByteArray pByteArray = this.gXz;
            this.gXz = new PByteArray();
            this.gXz.value = pByteArray.value;
            synchronized (b.gXA) {
                b.gXA.put(Integer.valueOf(i), this);
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(TAG, e, "PacketBackupDataPush to buf fail:%s", new Object[]{e.toString()});
        }
    }

    public final boolean ass() {
        byte[] bArr = this.gXz.value;
        int i = this.gXM;
        if (b.gXC != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BackupBaseScene", "doSceneSameThread ret[%d], sendSeq[%d], type[%d], buflen[%d]", new Object[]{Integer.valueOf(b.gXC.k(i, bArr)), Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(bArr.length)});
        }
        return true;
    }

    private static com.tencent.mm.bk.b a(byte[] bArr, boolean z, byte[] bArr2) {
        if (bi.bD(bArr2) <= 0 || bi.bD(bArr) <= 0) {
            return new com.tencent.mm.bk.b(bArr);
        }
        return new com.tencent.mm.bk.b(AesEcb.aesCryptEcb(bArr, bArr2, true, z));
    }

    public final int asz() {
        if (this.gXz.value == null) {
            return 0;
        }
        return this.gXz.value.length;
    }

    public final a asj() {
        return this.gXL;
    }

    public final a ask() {
        return this.gXK;
    }

    public final int getType() {
        return 6;
    }
}
