package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class f {
    public HashMap<Long, a> iyJ = new HashMap();

    public final boolean cL(long j) {
        if (cM(j) == 2) {
            return true;
        }
        return false;
    }

    public final int cM(long j) {
        if (this.iyJ.containsKey(Long.valueOf(j))) {
            return ((a) this.iyJ.get(Long.valueOf(j))).bLv;
        }
        return 0;
    }

    public final a cN(long j) {
        if (!this.iyJ.containsKey(Long.valueOf(j))) {
            cS(j);
        }
        return (a) this.iyJ.get(Long.valueOf(j));
    }

    public final a cO(long j) {
        if (this.iyJ.containsKey(Long.valueOf(j))) {
            return (a) this.iyJ.get(Long.valueOf(j));
        }
        a aVar = new a();
        aVar.iyK = j;
        aVar.iyM = null;
        aVar.bjP = null;
        aVar.iyL = null;
        aVar.bKC = null;
        aVar.mURL = null;
        aVar.bLv = 0;
        aVar.iyN = false;
        aVar.hgC = 0;
        this.iyJ.put(Long.valueOf(j), aVar);
        return aVar;
    }

    public final boolean cP(long j) {
        x.i("MicroMsg.exdevice.ExdeviceInfoManager", "setDeviceAuthFlag, device id = %d", new Object[]{Long.valueOf(j)});
        a cN = cN(j);
        if (cN == null) {
            x.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            return false;
        }
        cN.iyN = true;
        return true;
    }

    public final boolean cQ(long j) {
        x.i("MicroMsg.exdevice.ExdeviceInfoManager", "delDeviceAuthFlag, device id = %d", new Object[]{Long.valueOf(j)});
        a cN = cN(j);
        if (cN == null) {
            x.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
            return false;
        }
        cN.iyN = false;
        return true;
    }

    public final boolean cR(long j) {
        x.i("MicroMsg.exdevice.ExdeviceInfoManager", "isDeviceAuthed, device id = %d", new Object[]{Long.valueOf(j)});
        a cN = cN(j);
        if (cN != null) {
            return cN.iyN;
        }
        x.e("MicroMsg.exdevice.ExdeviceInfoManager", "getExDeviceInfo failed!!!");
        return false;
    }

    private void cS(long j) {
        b Ak = ad.aHe().Ak(String.valueOf(j));
        if (Ak == null) {
            x.e("MicroMsg.exdevice.ExdeviceInfoManager", "get harddevice info from db failed : %d", new Object[]{Long.valueOf(j)});
            return;
        }
        a aVar = new a();
        aVar.iyK = j;
        aVar.iyM = Ak.field_authBuf;
        aVar.bjP = Ak.field_sessionKey;
        aVar.iyL = Ak.field_sessionBuf;
        aVar.bKC = Ak.field_brandName;
        aVar.mURL = Ak.field_url;
        aVar.bLv = 0;
        aVar.iyN = false;
        this.iyJ.put(Long.valueOf(j), aVar);
        x.i("MicroMsg.exdevice.ExdeviceInfoManager", "not contains the device info, device id = %d, load from db", new Object[]{Long.valueOf(j)});
    }

    public final byte[] m(long j, int i) {
        if (j < 0) {
            x.e("MicroMsg.exdevice.ExdeviceInfoManager", "device is lower than 0");
            return null;
        }
        a aVar = (a) this.iyJ.get(Long.valueOf(j));
        if (aVar == null) {
            cS(j);
            aVar = (a) this.iyJ.get(Long.valueOf(j));
        }
        if (aVar == null) {
            return null;
        }
        byte[] bArr;
        switch (i) {
            case 1:
                bArr = aVar.iyM;
                break;
            case 2:
                bArr = aVar.bjP;
                break;
            case 3:
                bArr = aVar.iyL;
                break;
            default:
                bArr = null;
                break;
        }
        return bArr;
    }

    public final void b(long j, byte[] bArr, int i) {
        if (j < 0 || bArr == null || bArr.length == 0) {
            boolean z;
            int i2;
            String str = "MicroMsg.exdevice.ExdeviceInfoManager";
            String str2 = "device id low than 0 or authbuf is null, deviceid = %d, buffer == null : %b, buffer length = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(j);
            if (bArr == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            if (bArr == null) {
                i2 = -1;
            } else {
                i2 = bArr.length;
            }
            objArr[2] = Integer.valueOf(i2);
            x.e(str, str2, objArr);
            return;
        }
        a aVar = (a) this.iyJ.get(Long.valueOf(j));
        if (aVar == null) {
            aVar = new a();
            aVar.iyK = j;
        }
        switch (i) {
            case 1:
                aVar.iyM = bArr;
                break;
            case 2:
                aVar.bjP = bArr;
                break;
            case 3:
                aVar.iyL = bArr;
                break;
            default:
                x.e("MicroMsg.exdevice.ExdeviceInfoManager", "unkown buffer type : %d", new Object[]{Integer.valueOf(i)});
                break;
        }
        this.iyJ.put(Long.valueOf(j), aVar);
    }
}
