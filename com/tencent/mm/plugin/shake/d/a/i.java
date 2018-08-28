package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.bmo;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class i {
    public static String bvg() {
        if (au.HX()) {
            StringBuilder stringBuilder = new StringBuilder();
            au.HU();
            File file = new File(stringBuilder.append(c.Gq()).append("shakemusic/").toString());
            if (!(file.exists() && file.isDirectory())) {
                x.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[]{file.getAbsolutePath()});
                file.mkdir();
            }
            File file2 = new File(file, ".nomedia");
            if (!file2.exists()) {
                x.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[]{file.getAbsolutePath()});
                try {
                    file2.createNewFile();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
                }
            }
            if (file.exists()) {
                return file.getAbsolutePath() + "/";
            }
            x.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
            return null;
        }
        x.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
        return null;
    }

    public static avq c(byte[] bArr, long j) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            bmo bmo = (bmo) new bmo().aG(bArr);
            avq avq = new avq();
            avq.rYj = 4;
            avq.rsp = String.valueOf(bmo.skL);
            avq.rYk = bmo.rYk;
            avq.rYn = ab.b(bmo.rKj);
            avq.rYo = ab.b(bmo.rKk);
            avq.rYt = a.JC(avq.rYo);
            avq.rgC = bmo.rgC;
            avq.rYs = ab.b(bmo.rKi);
            avq.rYl = ab.b(bmo.skM);
            avq.rYm = ab.b(bmo.skN);
            avq.rYr = ab.b(bmo.skQ);
            avq.rYp = ab.b(bmo.skO);
            avq.rYq = ab.b(bmo.skP);
            avq.nlo = j;
            return avq;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
            x.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
            return null;
        }
    }
}
