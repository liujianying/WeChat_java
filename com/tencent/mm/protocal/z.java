package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.aqd;
import com.tencent.mm.protocal.c.bsb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class z {
    public static byte[] g(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length <= 0) {
            x.d("MicroMsg.SyncKeyUtil", "empty old key, use new key");
            return bArr2;
        } else if (bArr2 == null || bArr2.length <= 0) {
            x.e("MicroMsg.SyncKeyUtil", "newKey is null");
            return null;
        } else {
            PByteArray pByteArray = new PByteArray();
            try {
                if (MMProtocalJni.mergeSyncKey(bArr, bArr2, pByteArray)) {
                    return pByteArray.value;
                }
                x.e("MicroMsg.SyncKeyUtil", "merge key failed");
                return null;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Crash", e, "NoSuchMethod MMProtocalJni.mergeSyncKey", new Object[0]);
                throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("NoSuchMethod MMProtocalJni.mergeSyncKey").initCause(e));
            }
        }
    }

    private static Map<Integer, Long> bo(byte[] bArr) {
        if (bi.bC(bArr)) {
            return null;
        }
        try {
            bsb bsb = (bsb) new bsb().aG(bArr);
            if (bsb == null) {
                return null;
            }
            x.d("MicroMsg.SyncKeyUtil", "dkpush : keyCount:" + bsb.slH);
            LinkedList linkedList = bsb.slI;
            if (linkedList.size() != bsb.slH) {
                return null;
            }
            Map<Integer, Long> hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bsb.slH) {
                    break;
                }
                hashMap.put(Integer.valueOf(((aqd) linkedList.get(i2)).mEb), Long.valueOf(4294967295L & ((long) ((aqd) linkedList.get(i2)).rSE)));
                i = i2 + 1;
            }
            if (hashMap.size() != bsb.slH) {
                return null;
            }
            return hashMap;
        } catch (Exception e) {
            return null;
        }
    }

    public static String bp(byte[] bArr) {
        if (bi.bC(bArr)) {
            return "";
        }
        Map bo = bo(bArr);
        if (bo == null || bo.size() <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" MsgKey:" + bo.get(Integer.valueOf(2)));
        stringBuffer.append(" profile:" + bo.get(Integer.valueOf(1)));
        stringBuffer.append(" contact:" + bo.get(Integer.valueOf(3)));
        stringBuffer.append(" chatroom:" + bo.get(Integer.valueOf(11)));
        stringBuffer.append(" Bottle:" + bo.get(Integer.valueOf(7)));
        stringBuffer.append(" QContact:" + bo.get(Integer.valueOf(5)));
        return stringBuffer.toString();
    }

    public static boolean h(byte[] bArr, byte[] bArr2) {
        Map bo = bo(bArr);
        if (bo == null) {
            x.d("MicroMsg.SyncKeyUtil", "dkpush local sync key failed");
            return true;
        }
        Map bo2 = bo(bArr2);
        if (bo2 == null) {
            x.e("MicroMsg.SyncKeyUtil", "dkpush svr sync key failed");
            return false;
        }
        for (Integer num : bo2.keySet()) {
            Long l = (Long) bo.get(num);
            Long l2 = (Long) bo2.get(num);
            if (l == null) {
                x.d("MicroMsg.SyncKeyUtil", "dkpush local key null :" + num);
                return true;
            }
            x.d("MicroMsg.SyncKeyUtil", "dkpush local key:" + num + " sv:" + l2 + " lv:" + l);
            if (l2.longValue() > l.longValue()) {
                return true;
            }
        }
        x.d("MicroMsg.SyncKeyUtil", "dkpush two sync key is the same");
        return false;
    }
}
