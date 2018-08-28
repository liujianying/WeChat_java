package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.c.b;
import com.tencent.mm.protocal.c.cdl;
import com.tencent.mm.protocal.c.xg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static int keY = 4;
    private static ByteOrder keZ = ByteOrder.BIG_ENDIAN;
    private volatile String cZG = "";
    private File fgV;
    volatile boolean fgX = false;
    private volatile int kfa;
    private volatile int kfb = 0;
    volatile cdl kfc = null;
    private volatile LinkedList<xg> kfd = null;
    private volatile String kfe = "";

    public d(File file) {
        boolean z = false;
        this.fgV = file;
        if (abX()) {
            z = true;
        }
        this.fgX = z;
    }

    public final m df(String str, String str2) {
        if (bi.cX(this.kfd) || this.kfb < keY || bi.oW(str)) {
            x.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
            return null;
        }
        Iterator it = this.kfd.iterator();
        while (it.hasNext()) {
            xg xgVar = (xg) it.next();
            if (bi.oV(xgVar.rDd).equals(str)) {
                String str3 = xgVar.rDf;
                Object obj = (bi.oW(str3) || !(str3.startsWith("video/") || str3.startsWith("audio/"))) ? null : 1;
                if (obj != null) {
                    x.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", new Object[]{str});
                    return null;
                } else if (((long) xgVar.hcy) <= 5242880) {
                    try {
                        x.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", new Object[]{str});
                        return new m(xgVar.rDf, str2, new b(this.fgV, ((long) this.kfb) + xgVar.rDe, (long) xgVar.hcy));
                    } catch (IOException e) {
                        x.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", new Object[]{str, Long.valueOf(xgVar.rDe), Integer.valueOf(xgVar.hcy), xgVar.rDf, e.getMessage()});
                    }
                } else {
                    x.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", new Object[]{Integer.valueOf(xgVar.hcy), Long.valueOf(5242880), str, Long.valueOf(xgVar.rDe), xgVar.rDf});
                }
            }
        }
        return null;
    }

    private boolean abX() {
        boolean z = false;
        FileChannel fileChannel = null;
        try {
            fileChannel = new RandomAccessFile(this.fgV, "r").getChannel();
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + e.getMessage());
        }
        if (fileChannel != null) {
            try {
                fileChannel.position(0);
                ByteBuffer allocate = ByteBuffer.allocate(keY);
                allocate.order(keZ);
                fileChannel.read(allocate);
                this.kfa = allocate.getInt(0);
                z = a(fileChannel);
            } catch (Exception e2) {
                x.e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + e2.getMessage());
            } finally {
                b(fileChannel);
            }
        }
        return z;
    }

    private boolean a(FileChannel fileChannel) {
        if (this.kfa <= 0) {
            return false;
        }
        try {
            fileChannel.position((long) keY);
            ByteBuffer allocate = ByteBuffer.allocate(this.kfa);
            allocate.order(keZ);
            fileChannel.read(allocate);
            byte[] array = allocate.array();
            if (array == null || array.length == 0) {
                return false;
            }
            this.kfc = new cdl();
            this.kfc.aG(array);
            this.kfd = this.kfc.syV;
            this.kfe = this.kfc.syW;
            this.cZG = this.kfc.jOS;
            this.kfb = keY + this.kfa;
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + e.getMessage());
            return false;
        }
    }

    private static void b(FileChannel fileChannel) {
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException e) {
            }
        }
    }
}
