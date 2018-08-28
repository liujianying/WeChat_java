package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsReaderView$ReaderCallback;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Set;

class a$a implements Runnable {
    private String ip;
    private Set<Integer> oDn;
    final /* synthetic */ a oDo;

    public a$a(a aVar, String str, Set<Integer> set) {
        this.oDo = aVar;
        this.ip = str;
        this.oDn = set;
    }

    public final void run() {
        Socket socket;
        Throwable e;
        this.oDo.a(this.ip, String.format("connect %s: ", new Object[]{this.ip}), Integer.valueOf(1));
        for (Integer num : this.oDn) {
            a aVar = this.oDo;
            String str = this.ip;
            int intValue = num.intValue();
            try {
                socket = new Socket();
                try {
                    socket.setSoTimeout(TbsReaderView$ReaderCallback.GET_BAR_ANIMATING);
                    long VF = bi.VF();
                    socket.connect(new InetSocketAddress(str, intValue));
                    long VF2 = bi.VF();
                    x.i("MicroMsg.MMTraceRoute", "connect success" + str + ":" + intValue);
                    aVar.a(str, String.format("port = %d, time = %dms ", new Object[]{Integer.valueOf(intValue), Long.valueOf(VF2 - VF)}), Integer.valueOf(1));
                    try {
                        socket.close();
                    } catch (Throwable e2) {
                        x.e("MicroMsg.MMTraceRoute", "close err: " + e2.getMessage());
                        x.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                    }
                } catch (UnknownHostException e3) {
                    e2 = e3;
                    try {
                        aVar.a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2.toString()}), Integer.valueOf(1));
                        x.e("MicroMsg.MMTraceRoute", "connect err: " + e2.getMessage());
                        x.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                        if (socket != null) {
                            try {
                                socket.close();
                            } catch (Throwable e22) {
                                x.e("MicroMsg.MMTraceRoute", "close err: " + e22.getMessage());
                                x.printErrStackTrace("MicroMsg.MMTraceRoute", e22, "", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        e22 = th;
                    }
                } catch (IOException e4) {
                    e22 = e4;
                    aVar.a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e22.toString()}), Integer.valueOf(1));
                    x.e("MicroMsg.MMTraceRoute", "connect err:" + e22.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e22, "", new Object[0]);
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (Throwable e222) {
                            x.e("MicroMsg.MMTraceRoute", "close err: " + e222.getMessage());
                            x.printErrStackTrace("MicroMsg.MMTraceRoute", e222, "", new Object[0]);
                        }
                    }
                } catch (Exception e5) {
                    e222 = e5;
                    aVar.a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e222.toString()}), Integer.valueOf(1));
                    x.e("MicroMsg.MMTraceRoute", "connect err:" + e222.toString());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e222, "", new Object[0]);
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (Throwable e2222) {
                            x.e("MicroMsg.MMTraceRoute", "close err: " + e2222.getMessage());
                            x.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                        }
                    }
                }
            } catch (UnknownHostException e6) {
                e2222 = e6;
                socket = null;
                aVar.a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                x.e("MicroMsg.MMTraceRoute", "connect err: " + e2222.getMessage());
                x.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Throwable e22222) {
                        x.e("MicroMsg.MMTraceRoute", "close err: " + e22222.getMessage());
                        x.printErrStackTrace("MicroMsg.MMTraceRoute", e22222, "", new Object[0]);
                    }
                }
            } catch (IOException e7) {
                e22222 = e7;
                socket = null;
                aVar.a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e22222.toString()}), Integer.valueOf(1));
                x.e("MicroMsg.MMTraceRoute", "connect err:" + e22222.getMessage());
                x.printErrStackTrace("MicroMsg.MMTraceRoute", e22222, "", new Object[0]);
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Throwable e222222) {
                        x.e("MicroMsg.MMTraceRoute", "close err: " + e222222.getMessage());
                        x.printErrStackTrace("MicroMsg.MMTraceRoute", e222222, "", new Object[0]);
                    }
                }
            } catch (Exception e8) {
                e222222 = e8;
                socket = null;
                aVar.a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e222222.toString()}), Integer.valueOf(1));
                x.e("MicroMsg.MMTraceRoute", "connect err:" + e222222.toString());
                x.printErrStackTrace("MicroMsg.MMTraceRoute", e222222, "", new Object[0]);
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Throwable e2222222) {
                        x.e("MicroMsg.MMTraceRoute", "close err: " + e2222222.getMessage());
                        x.printErrStackTrace("MicroMsg.MMTraceRoute", e2222222, "", new Object[0]);
                    }
                }
            } catch (Throwable th2) {
                e2222222 = th2;
                socket = null;
            }
        }
        this.oDo.a(this.ip, "\n", Integer.valueOf(1));
        return;
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable e9) {
                x.e("MicroMsg.MMTraceRoute", "close err: " + e9.getMessage());
                x.printErrStackTrace("MicroMsg.MMTraceRoute", e9, "", new Object[0]);
            }
        }
        throw e2222222;
        throw e2222222;
    }
}
