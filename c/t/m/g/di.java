package c.t.m.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import c.t.m.g.dp.a;
import java.util.ArrayList;
import java.util.List;

final class di extends PhoneStateListener {
    volatile boolean a;
    byte[] b = new byte[0];
    ServiceState c = null;
    HandlerThread d;
    a e;
    Runnable f;
    Handler g;
    List<String> h;
    private final ct i;
    private final TelephonyManager j;
    private dp k = null;

    public di(ct ctVar) {
        this.i = ctVar;
        this.j = ctVar.e;
        this.f = new 1(this);
    }

    final void a(int i) {
        try {
            this.i.e.listen(this, i);
        } catch (Throwable th) {
            new StringBuilder("listenCellState: failed! flags=").append(i).append(th.toString());
        }
    }

    public final void onServiceStateChanged(ServiceState serviceState) {
        int i = 1;
        int i2 = 0;
        super.onServiceStateChanged(serviceState);
        if (serviceState != null) {
            try {
                ServiceState serviceState2 = this.c;
                if (serviceState2 == null || serviceState2.getState() != serviceState.getState()) {
                    this.c = serviceState;
                    if (this.a) {
                        int i3;
                        TelephonyManager telephonyManager;
                        boolean a;
                        Message message;
                        if (this.c != null) {
                            if (this.c.getState() == 0) {
                                i3 = 1;
                            } else if (this.c.getState() == 1) {
                                i3 = 0;
                            }
                            telephonyManager = this.i.e;
                            a = ec.a(this.i.a);
                            if (telephonyManager != null) {
                                i = 0;
                            } else if (telephonyManager.getSimState() != 5) {
                                i = 0;
                            }
                            if (!(a || i == 0)) {
                                i2 = i3;
                            }
                            message = new Message();
                            message.what = 12999;
                            message.arg1 = 12003;
                            message.arg2 = i2;
                            this.i.c(message);
                        }
                        i3 = -1;
                        telephonyManager = this.i.e;
                        a = ec.a(this.i.a);
                        if (telephonyManager != null) {
                            i = 0;
                        } else if (telephonyManager.getSimState() != 5) {
                            i = 0;
                        }
                        i2 = i3;
                        message = new Message();
                        message.what = 12999;
                        message.arg1 = 12003;
                        message.arg2 = i2;
                        this.i.c(message);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void onCellInfoChanged(List<CellInfo> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    List arrayList = new ArrayList();
                    for (CellInfo cellInfo : list) {
                        if (cellInfo.isRegistered()) {
                            dp a = dp.a(this.i, cellInfo);
                            if (a != null) {
                                Object obj;
                                int obj2;
                                if (a.a != a.c) {
                                    if (a.b < 0 || a.c < 0 || a.b == 535 || a.c == 535 || a.d < 0 || a.d == 65535 || a.d == 25840 || a.e == 65535 || a.e == 268435455 || a.e == Integer.MAX_VALUE || a.e == 50594049 || a.e == 8 || a.e == 10 || a.e == 33 || a.e <= 0) {
                                        obj2 = null;
                                    } else {
                                        obj2 = 1;
                                    }
                                } else if (a.b < 0 || a.c < 0 || a.b == 535 || a.c == 535 || a.d < 0 || a.d == 65535 || a.e == 65535 || a.e <= 0) {
                                    obj2 = null;
                                } else {
                                    obj2 = 1;
                                }
                                if (obj2 != null) {
                                    arrayList.add(a);
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        a(arrayList);
                        return;
                    }
                }
            } catch (Throwable th) {
                return;
            }
        }
        CellLocation b = ec.b(this.i);
        if (b != null) {
            List arrayList2 = new ArrayList();
            dp a2 = dp.a(this.i, b, null);
            if (a2 != null) {
                arrayList2.add(a2);
            }
            a(arrayList2);
        } else if (this.k != null) {
            List arrayList3 = new ArrayList();
            arrayList3.add(this.k);
            a(arrayList3);
        }
    }

    private void a(List<dp> list) {
        if (list.size() != 0) {
            dp dpVar = null;
            List arrayList = new ArrayList();
            for (dp dpVar2 : list) {
                dp dpVar22;
                arrayList.add(dpVar22.b());
                if (this.h == null || this.h.contains(dpVar22.b())) {
                    dpVar22 = dpVar;
                }
                dpVar = dpVar22;
            }
            this.h = arrayList;
            if (dpVar != null) {
                this.k = dpVar;
                if (this.a && this.k != null && this.i != null) {
                    synchronized (this.b) {
                        this.i.c(this.k);
                    }
                }
            }
        }
    }
}
