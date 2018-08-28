package com.tencent.mm.plugin.exdevice.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.protocal.c.amx;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class g$1 implements Runnable {
    final /* synthetic */ g iuX;

    g$1(g gVar) {
        this.iuX = gVar;
    }

    public final void run() {
        Throwable e;
        int i;
        amx amx;
        String str;
        String str2;
        try {
            String str3 = e.dgk + String.format("%s%d.%s", new Object[]{SlookAirButtonRecentMediaAdapter.IMAGE_TYPE, Integer.valueOf(this.iuX.bSW.hashCode()), "jpg"});
            byte[] zX = g.zX(this.iuX.bSW);
            if (zX != null) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(zX, 0, zX.length);
                g gVar = this.iuX;
                BufferedOutputStream bufferedOutputStream;
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str3)));
                    try {
                        decodeByteArray.compress(CompressFormat.JPEG, 80, bufferedOutputStream);
                        bufferedOutputStream.flush();
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                        }
                    } catch (IOException e3) {
                        e2 = e3;
                        try {
                            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Exception in saveImageToFile !");
                            g.cx(gVar.iuU, gVar.iuB);
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable e22) {
                                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                }
                            }
                            this.iuX.iuy = str3;
                            if (this.iuX.iuy == null) {
                            }
                            i = -1;
                            amx = new amx();
                            str = this.iuX.iuy;
                            if (str != null) {
                            }
                            str = null;
                            str2 = null;
                            str3 = null;
                            amx.rxo = str;
                            amx.jPe = str2;
                            amx.hcy = i;
                            amx.rwk = str3;
                            this.iuX.iuS.rPF = amx;
                            this.iuX.iuS.rPC = 3;
                            au.DF().a(new n(this.iuX.iuS, this.iuX.iuT, this.iuX.iuU, this.iuX.iuV), 0);
                            return;
                        } catch (Throwable th) {
                            e22 = th;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable e4) {
                                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e4, "", new Object[0]);
                                }
                            }
                            throw e22;
                        }
                    }
                } catch (IOException e5) {
                    e22 = e5;
                    bufferedOutputStream = null;
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Exception in saveImageToFile !");
                    g.cx(gVar.iuU, gVar.iuB);
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e222) {
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
                        }
                    }
                    this.iuX.iuy = str3;
                    if (this.iuX.iuy == null) {
                    }
                    i = -1;
                    amx = new amx();
                    str = this.iuX.iuy;
                    if (str != null) {
                    }
                    str = null;
                    str2 = null;
                    str3 = null;
                    amx.rxo = str;
                    amx.jPe = str2;
                    amx.hcy = i;
                    amx.rwk = str3;
                    this.iuX.iuS.rPF = amx;
                    this.iuX.iuS.rPC = 3;
                    au.DF().a(new n(this.iuX.iuS, this.iuX.iuT, this.iuX.iuU, this.iuX.iuV), 0);
                    return;
                } catch (Throwable th2) {
                    e222 = th2;
                    bufferedOutputStream = null;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e42) {
                            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e42, "", new Object[0]);
                        }
                    }
                    throw e222;
                }
                this.iuX.iuy = str3;
                if (this.iuX.iuy == null || FileOp.cn(this.iuX.iuy)) {
                    i = -1;
                    amx = new amx();
                    str = this.iuX.iuy;
                    if (str != null || str.length() <= 0) {
                        str = null;
                        str2 = null;
                        str3 = null;
                    } else {
                        File file = new File(str);
                        str2 = file.getName();
                        i = (int) file.length();
                        String substring = str2.substring(str2.lastIndexOf(".") + 1, str2.length());
                        str3 = g.m(file);
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable filePath %s", new Object[]{str});
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileSize %s", new Object[]{Integer.valueOf(i)});
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileMd5 %s", new Object[]{str3});
                        str = substring;
                    }
                    amx.rxo = str;
                    amx.jPe = str2;
                    amx.hcy = i;
                    amx.rwk = str3;
                    this.iuX.iuS.rPF = amx;
                    this.iuX.iuS.rPC = 3;
                    au.DF().a(new n(this.iuX.iuS, this.iuX.iuT, this.iuX.iuU, this.iuX.iuV), 0);
                    return;
                }
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mSnsImagePath is null or file not exist!");
                g.cx(this.iuX.iuU, this.iuX.iuB);
                return;
            }
            x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get image error !");
            g.cx(this.iuX.iuU, this.iuX.iuB);
        } catch (Throwable e2222) {
            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222, "", new Object[0]);
        }
    }
}
