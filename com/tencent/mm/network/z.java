package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.Task;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsMediaPlayer$TbsMediaPlayerListener;
import java.io.ByteArrayOutputStream;

public final class z {
    final a[] etg = new a[100];

    /* renamed from: com.tencent.mm.network.z$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int eth;
        final /* synthetic */ int eti;

        AnonymousClass1(int i, int i2) {
            this.eth = i;
            this.eti = i2;
        }

        public final void run() {
            MMLogic.reportCGIServerError(this.eth, this.eti);
        }
    }

    private static class a {
        r etk;
        l etl;
        c etm;
        long startTime;
        int taskId;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    protected final void finalize() {
        reset();
        super.finalize();
    }

    final boolean UN() {
        synchronized (this.etg) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.etg[i] != null && (TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START == this.etg[i].etk.getType() || TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_END == this.etg[i].etk.getType())) {
                        x.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i + " type=" + this.etg[i].etk.getType());
                        return true;
                    }
                } catch (Throwable e) {
                    this.etg[i] = null;
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[]{bi.i(e), Integer.valueOf(i)});
                }
                i++;
            }
            return false;
        }
    }

    final boolean UO() {
        synchronized (this.etg) {
            int i = 0;
            while (i < 100) {
                try {
                    if (this.etg[i] != null && 1000 == this.etg[i].etk.getType()) {
                        x.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i + " type=" + this.etg[i].etk.getType());
                        return true;
                    }
                } catch (Throwable e) {
                    this.etg[i] = null;
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[]{bi.i(e), Integer.valueOf(i)});
                }
                i++;
            }
            return false;
        }
    }

    final r ca(boolean z) {
        synchronized (this.etg) {
            int i = 0;
            r rVar = null;
            while (i < 100) {
                if (this.etg[i] != null) {
                    if (z) {
                        try {
                            if (this.etg[i].etk instanceof com.tencent.mm.network.r.a) {
                                continue;
                            }
                        } catch (Throwable e) {
                            x.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bi.i(e)});
                        }
                    }
                    if (z || (this.etg[i].etk instanceof com.tencent.mm.network.r.a)) {
                        if (TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START == this.etg[i].etk.getType() || TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_END == this.etg[i].etk.getType()) {
                            x.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i + " type=" + this.etg[i].etk.getType());
                            return null;
                        } else if (rVar == null) {
                            rVar = this.etg[i].etk;
                        } else {
                            continue;
                        }
                    }
                }
                i++;
            }
            return rVar;
        }
    }

    public final int UP() {
        int i = 0;
        for (int i2 = 0; i2 < 100; i2++) {
            try {
                if (this.etg[i2] != null) {
                    this.etg[i2].etk.getType();
                }
            } catch (Throwable e) {
                x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", new Object[]{bi.i(e), Integer.valueOf(i2)});
                i++;
                this.etg[i2] = null;
            }
        }
        return i;
    }

    public final int a(r rVar, l lVar, c cVar, int i) {
        if (rVar == null) {
            x.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
            return -1;
        }
        int i2;
        rVar.hashCode();
        Task task = new Task();
        synchronized (this.etg) {
            int i3 = 0;
            while (i3 < 100) {
                try {
                    if (this.etg[i3] == null) {
                        this.etg[i3] = new a();
                        this.etg[i3].etk = rVar;
                        this.etg[i3].etl = lVar;
                        this.etg[i3].etm = cVar;
                        this.etg[i3].startTime = bi.VF();
                        this.etg[i3].taskId = task.taskID;
                        task.cmdID = rVar.LC().getCmdId();
                        task.cgi = rVar.getUri();
                        int type = rVar.getType();
                        task.needAuthed = (rVar.KP() & 1) != 1;
                        if (type == 126 || type == TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START || type == TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_END) {
                            task.needAuthed = false;
                            if (type == TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START) {
                                task.retryCount = 1;
                            }
                        }
                        task.limitFlow = true;
                        if (type == 149 || type == 193 || type == 220 || type == 323 || type == 324 || type == 326 || type == 327) {
                            task.limitFlow = false;
                        }
                        task.channelStrategy = 0;
                        if (type == 233 || type == 835 || type == 238) {
                            task.channelStrategy = 1;
                        }
                        task.sendOnly = false;
                        if (type == 10 || type == 268369922) {
                            task.sendOnly = true;
                        }
                        if (rVar.LC().LB() && rVar.getUri() != null && rVar.getUri().length() > 0) {
                            task.channelSelect |= 1;
                        }
                        if (task.cmdID != 0) {
                            task.channelSelect |= 2;
                        }
                        task.reportArg = String.valueOf(type);
                        if (type == 522) {
                            task.totalTimeout = 300000;
                            task.priority = 0;
                        }
                        if (type == 710) {
                            task.totalTimeout = 15000;
                            task.serverProcessCost = 0;
                        }
                        x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", new Object[]{Integer.valueOf(i3), Integer.valueOf(task.taskID), Integer.valueOf(rVar.Lb()), Integer.valueOf(task.channelSelect), task.cgi, Boolean.valueOf(task.needAuthed)});
                        i2 = i3;
                    } else {
                        i3++;
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bi.i(e)});
                }
            }
            i2 = -1;
        }
        if (-1 != i2) {
            if (i == 1) {
                task.retryCount = 0;
            }
            StnLogic.startTask(task);
        } else {
            x.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        x.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=" + i2);
        return i2;
    }

    public final void reset() {
        int i = 0;
        x.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
        StnLogic.reset();
        synchronized (this.etg) {
            while (true) {
                int i2 = i;
                if (i2 < 100) {
                    if (this.etg[i2] != null) {
                        try {
                            x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.etg[i2].etk.getType()), Integer.valueOf(this.etg[i2].etk.Lb())});
                            this.etg[i2] = null;
                        } catch (Throwable e) {
                            x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bi.i(e)});
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public final void d(int i, int i2, String str) {
        x.i("MicroMsg.MMNativeNetTaskAdapter", "clearTaskAndCallback errType=" + i + ", errCode=" + i2 + ", errMsg=" + str);
        StnLogic.clearTask();
        StnLogic.reset();
        a[] aVarArr = new a[100];
        synchronized (this.etg) {
            for (int i3 = 0; i3 < 100; i3++) {
                aVarArr[i3] = this.etg[i3];
                this.etg[i3] = null;
            }
        }
        for (int i4 = 0; i4 < 100; i4++) {
            if (aVarArr[i4] != null) {
                try {
                    x.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi clearTaskAndCallback outQueue: netId:%d hash:%d type:%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(aVarArr[i4].etk.getType()), Integer.valueOf(aVarArr[i4].etk.Lb())});
                    aVarArr[i4].etl.a(i4, i, i2, str, aVarArr[i4].etk, null);
                } catch (Throwable e) {
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bi.i(e)});
                }
            }
        }
    }

    final int iM(int i) {
        int i2 = 0;
        synchronized (this.etg) {
            int iN = iN(i);
            if (-1 == iN) {
                x.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
            } else {
                try {
                    i2 = this.etg[iN].etk.LD().LH();
                } catch (Throwable e) {
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bi.i(e)});
                }
            }
        }
        return i2;
    }

    final boolean a(int i, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        synchronized (this.etg) {
            int iN = iN(i);
            if (-1 == iN) {
                return false;
            }
            boolean a;
            try {
                x.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s", new Object[]{Integer.valueOf(i2), Boolean.valueOf(this.etg[iN].etm.Lp()), bi.bE(this.etg[iN].etm.Lm())});
                this.etg[iN].etk.LC().J(this.etg[iN].etm.DE());
                this.etg[iN].etk.LC().eK(this.etg[iN].etm.Df());
                a = this.etg[iN].etk.LC().a(this.etg[iN].etk.getType(), this.etg[iN].etm.DE(), this.etg[iN].etm.Lm(), this.etg[iN].etm.Lo(), 0, this.etg[iN].etm.Lp());
                if (a) {
                    byteArrayOutputStream.write(this.etg[iN].etk.LC().Lv());
                } else {
                    iArr[0] = 0;
                    f.mDy.a(162, (long) iArr[0], 1, false);
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
                }
            } catch (Throwable e) {
                iArr[0] = 1;
                f.mDy.a(162, (long) iArr[0], 1, false);
                x.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", new Object[]{bi.i(e)});
                a = false;
            } catch (Throwable e2) {
                iArr[0] = 2;
                f.mDy.a(162, (long) iArr[0], 1, false);
                x.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", new Object[]{bi.i(e2)});
                a = false;
            } catch (Throwable e22) {
                iArr[0] = 3;
                f.mDy.a(162, (long) iArr[0], 1, false);
                x.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", new Object[]{bi.i(e22)});
                a = false;
            }
            x.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", new Object[]{Boolean.valueOf(a)});
            return a;
        }
    }

    final int a(int i, byte[] bArr, int[] iArr, int[] iArr2) {
        int iN;
        Throwable e;
        synchronized (this.etg) {
            iN = iN(i);
            if (-1 == iN) {
                iN = -1;
            } else {
                int i2 = StnLogic.RESP_FAIL_HANDLE_DEFAULT;
                try {
                    byte[] Lz = this.etg[iN].etk.LC().Lz();
                    h LD = this.etg[iN].etk.LD();
                    if (LD.a(this.etg[iN].etk.getType(), bArr, Lz)) {
                        iN = LD.LF();
                        iArr2[0] = 0;
                        if ((iN & 2) == 0) {
                            iArr2[0] = iArr2[0] | 2;
                            f.mDy.a(656, 0, 1, false);
                        }
                        if ((iN & 4) == 0) {
                            iArr2[0] = iArr2[0] | 4;
                            f.mDy.a(656, 1, 1, false);
                        }
                        if (!(LD.Lm() == null || -13 != LD.LH() || aa.UZ() == null)) {
                            aa.UZ().UD();
                        }
                        int i3;
                        if (-13 == LD.LH()) {
                            i3 = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                            try {
                                iArr[0] = LD.LH();
                                iN = i3;
                            } catch (RemoteException e2) {
                                e = e2;
                                i2 = i3;
                                f.mDy.a(162, 5, 1, false);
                                x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bi.i(e)});
                                iN = i2;
                                return iN;
                            } catch (Exception e3) {
                                e = e3;
                                i2 = i3;
                                f.mDy.a(162, 7, 1, false);
                                x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bi.i(e)});
                                iN = i2;
                                return iN;
                            }
                        } else if (-3002 == LD.LH() || -3003 == LD.LH()) {
                            i3 = StnLogic.RESP_FAIL_HANDLE_TASK_END;
                            iArr[0] = LD.LH();
                            iN = i3;
                        } else if (-3001 == LD.LH()) {
                            i3 = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                            iArr[0] = LD.LH();
                            iN = i3;
                        } else {
                            iN = StnLogic.RESP_FAIL_HANDLE_NORMAL;
                        }
                    } else {
                        f.mDy.a(162, 4, 1, false);
                        x.e("MicroMsg.MMNativeNetTaskAdapter", "buf to resp failed, change server and try again");
                        iN = i2;
                    }
                } catch (RemoteException e4) {
                    e = e4;
                    f.mDy.a(162, 5, 1, false);
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bi.i(e)});
                    iN = i2;
                    return iN;
                } catch (Exception e5) {
                    e = e5;
                    f.mDy.a(162, 7, 1, false);
                    x.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", new Object[]{bi.i(e)});
                    iN = i2;
                    return iN;
                }
            }
        }
        return iN;
    }

    final int iN(int i) {
        int i2 = 0;
        while (i2 < 100 && (this.etg[i2] == null || i != this.etg[i2].taskId)) {
            i2++;
        }
        if (100 <= i2) {
            return -1;
        }
        return i2;
    }
}
