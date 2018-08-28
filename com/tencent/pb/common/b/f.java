package com.tencent.pb.common.b;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.u;
import com.tencent.pb.common.b.a.a.v;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.pb.talkroom.sdk.e;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.wecall.talkroom.model.h;
import java.util.Iterator;
import java.util.LinkedList;

public class f {
    private static f vcl = null;
    private int vcm;
    private LinkedList<a> vcn;
    public e vco;
    private boolean vcp;
    private boolean vcq;

    private f() {
        this.vcm = 0;
        this.vcn = null;
        this.vco = null;
        this.vcp = false;
        this.vcq = true;
        this.vcn = new LinkedList();
        this.vcq = true;
    }

    private static v bJ(byte[] bArr) {
        try {
            return (v) com.google.a.a.e.a(new v(), bArr, bArr.length);
        } catch (Exception e) {
            c.x("NETCMD", new Object[]{"Exception genReadPackageData" + e.getMessage()});
            return null;
        }
    }

    private int a(a aVar, c cVar, String str, int i, byte[] bArr, int i2) {
        byte[] bArr2;
        byte[] bArr3 = null;
        int cEp = cEp();
        try {
            u uVar;
            if (bArr.length < 200 || bArr == null || bArr.length >= bArr.length) {
                uVar = new u();
                uVar.nc = i;
                uVar.vdU = cEp;
                uVar.userName = a.cEG();
                uVar.vcN = i2;
            } else {
                uVar = new u();
                uVar.nc = i;
                uVar.vdU = cEp;
                uVar.userName = a.cEG();
                uVar.vcN = i2;
            }
            if (bArr == null) {
                c.x("NETCMD", new Object[]{"body null"});
            } else {
                v vVar = new v();
                vVar.vdW = uVar;
                vVar.body = bArr;
                bArr3 = com.google.a.a.e.b(vVar);
            }
            bArr2 = bArr3;
        } catch (Exception e) {
            c.x("NetError", new Object[]{"newTaskHelper addTask body null"});
            bArr2 = bArr3;
        }
        if (bArr2 == null) {
            c.x("NETCMD", new Object[]{"cmd:" + i + "|body is null"});
            return -1;
        } else if (bArr2.length > 61440) {
            c.x("NETCMD", new Object[]{"cmd:" + i + "|body too large"});
            return -1;
        } else {
            a aVar2 = new a(this, (byte) 0);
            aVar2.mTaskId = cEp;
            aVar2.vcs = aVar;
            aVar2.vct = cVar;
            aVar2.vcr = str;
            synchronized (this.vcn) {
                this.vcn.add(aVar2);
            }
            int i3 = 1933;
            switch (i) {
                case 139:
                    i3 = 1918;
                    break;
                case 141:
                    i3 = 1919;
                    break;
                case 143:
                    i3 = 1927;
                    break;
                case 145:
                    i3 = 1931;
                    break;
                case 147:
                    i3 = 1932;
                    break;
                case 181:
                    i3 = 1929;
                    break;
                case 183:
                    i3 = 1928;
                    break;
                case 189:
                    i3 = 1935;
                    break;
                case 211:
                    i3 = 1937;
                    break;
                case TbsListener$ErrorCode.INCRUPDATE_INSTALL_SUCCESS /*221*/:
                    i3 = 1938;
                    break;
                case TbsListener$ErrorCode.EXCEED_LZMA_RETRY_NUM /*223*/:
                    i3 = 1939;
                    break;
            }
            c.d("NETCMD", new Object[]{"CLTSEND|", Integer.valueOf(cEp), Integer.valueOf(i3), str, a.cEG()});
            if (this.vco != null) {
                this.vco.c(cEp, i3, bArr2);
            }
            return cEp;
        }
    }

    private int cEp() {
        int i;
        synchronized (this.vcn) {
            this.vcm++;
            i = this.vcm;
        }
        return i;
    }

    public final a Hh(int i) {
        a aVar;
        synchronized (this.vcn) {
            Iterator it = this.vcn.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.mTaskId == i) {
                    break;
                }
            }
            aVar = null;
        }
        return aVar;
    }

    public static f cEq() {
        if (vcl == null) {
            synchronized (f.class) {
                if (vcl == null) {
                    vcl = new f();
                }
            }
        }
        return vcl;
    }

    final int a(a aVar, c cVar, int i, String str, byte[] bArr, int i2) {
        if (!this.vcq) {
            c.x("NETCMD", new Object[]{"doSendTask mIsInitSucc is false"});
            return -1;
        } else if (this.vcp) {
            c.x("NETCMD", new Object[]{"doSendTask fail: isRefreshing, cmd=" + i + ", cmdTag=" + str});
            return -1;
        } else {
            try {
                return a(aVar, cVar, str, i, bArr, i2);
            } catch (Throwable th) {
                c.x("NETCMD", new Object[]{"Exception doSendTask", th});
                return -1;
            }
        }
    }

    public final int a(a aVar, String str, com.google.a.a.e eVar) {
        try {
            return a(aVar, null, 31, str, com.google.a.a.e.b(eVar), 0);
        } catch (Exception e) {
            c.x("NETCMD", new Object[]{"doSendTask exception:", e});
            return -1;
        }
    }

    public static int bK(byte[] bArr) {
        if (bArr == null) {
            c.x("NETCMD", new Object[]{"CLTNOT onNotify1 data == null ", Integer.valueOf(0)});
            h.It(-1601);
            if (TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.cHu().jTX) && TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.cHu().vxy)) {
                h.a(com.tencent.wecall.talkroom.model.a.cHu().kvL, com.tencent.wecall.talkroom.model.a.cHu().vxz, new String[]{"notify", "datanull"});
            } else {
                com.tencent.wecall.talkroom.model.a.cHu().vxH.Q(new String[]{"notify", "datanull"});
            }
            return -1;
        }
        c.d("NETCMD", new Object[]{"CLTNOT onNotify data len=", Integer.valueOf(bArr.length)});
        return com.tencent.wecall.talkroom.model.a.cHu().bT(bArr);
    }

    public final void a(a aVar, int i, byte[] bArr) {
        try {
            if (aVar.vct != null) {
                aVar.vct.r(i, bArr);
            }
            if (aVar.vcs != null) {
                aVar.vcs.dz(aVar.vcr, i);
            }
        } catch (Exception e) {
            c.x("NETCMD", new Object[]{"postRespData", e.getMessage()});
        }
        synchronized (this.vcn) {
            this.vcn.remove(aVar);
        }
    }

    public final int s(int i, byte[] bArr) {
        a Hh = Hh(i);
        if (Hh != null || -1000 == i) {
            v bJ = bJ(bArr);
            if (bJ == null || bJ.vdW == null) {
                String str;
                String str2 = "NETCMD";
                Object[] objArr = new Object[2];
                objArr[0] = " pack.head: ";
                if (bJ == null) {
                    str = " pack is null ";
                } else {
                    str = " head is " + bJ.vdW;
                }
                objArr[1] = str;
                c.x(str2, objArr);
                a(Hh, -3, null);
                return -1;
            }
            int i2 = bJ.vdW.ret;
            int i3 = bJ.vdW.vdV;
            String str3 = bJ.vdW.userName;
            if (com.tencent.pb.common.a.a.vbC) {
                Toast.makeText(d.oSX, "retCode: " + i2 + " debugCode: " + i3, 0).show();
            }
            if (i2 != 0 && Hh != null) {
                c.x("NETCMD", new Object[]{"CLTRCV", Integer.valueOf(i), Hh.vcr, Integer.valueOf(i2), str3, Integer.valueOf(i3)});
            } else if (Hh != null) {
                c.d("NETCMD", new Object[]{"CLTRCV", Integer.valueOf(i), Hh.vcr, Integer.valueOf(i2), str3, Integer.valueOf(i3)});
            }
            byte[] bArr2 = bJ.body;
            if (bArr2 != null) {
                a(Hh, i2, bArr2);
                return 0;
            }
            a(Hh, i2, null);
            return 0;
        }
        c.x("NETCMD", new Object[]{"buf2Resp fail: taskId:" + i + " not found"});
        com.tencent.pb.common.c.f.u(20007, 3, "-1202");
        return 1;
    }
}
