package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.a.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

final class d$b implements a {
    String elu;
    String fileName;
    private int ljU;
    private int ljV;
    d$a qqe;
    j qqf;
    String qqo;
    int qqp;
    VideoTransPara qqq;
    private boolean qqr;
    private int qqs;

    private d$b() {
        this.qqs = 0;
    }

    /* synthetic */ d$b(byte b) {
        this();
    }

    public final boolean Kr() {
        Object obj;
        synchronized (d.bZQ()) {
            obj = !d.bZR().containsKey(this.fileName) ? 1 : null;
        }
        if (obj == null) {
            obj = t.nW(this.fileName) == null ? 1 : null;
        }
        if (obj != null) {
            x.w("MicroMsg.NoteVideoCompress", "remuxing job has been removed, filename %s", new Object[]{this.fileName});
            return true;
        }
        if (this.qqq == null || this.qqq.isDefault) {
            int[] iArr = new int[2];
            d.d(this.elu, iArr);
            this.ljU = iArr[0];
            this.ljV = iArr[1];
        } else {
            this.ljU = this.qqq.width;
            this.ljV = this.qqq.height;
        }
        PString pString = new PString();
        PInt pInt = new PInt();
        au.HU();
        if (c.FY().a(this.elu, pString, pInt) && com.tencent.mm.sdk.platformtools.j.fN(pString.value, this.qqo)) {
            x.i("MicroMsg.NoteVideoCompress", "copy remuxing file success, do not remuxing again.");
            this.qqp = pInt.value;
            this.qqr = true;
            return true;
        }
        long VG = bi.VG();
        if (this.qqq != null) {
            x.i("MicroMsg.NoteVideoCompress", "remuxing new para %s", new Object[]{this.qqq});
            this.qqp = SightVideoJNI.remuxing(this.elu, this.qqo, this.ljU, this.ljV, this.qqq.videoBitrate, this.qqq.dQI, 8, this.qqq.dQH, 25.0f, (float) this.qqq.fps, null, 0, false);
        } else {
            x.w("MicroMsg.NoteVideoCompress", "remuxing but new para is null. %s", new Object[]{this.fileName});
            this.qqp = SightVideoJNI.remuxing(this.elu, this.qqo, this.ljU, this.ljV, b.nbW, b.nbV, 8, 2, 25.0f, b.nbX, null, 0, false);
        }
        this.qqs = (int) bi.bI(VG);
        x.i("MicroMsg.NoteVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{this.elu, this.qqo, Integer.valueOf(this.qqp), Integer.valueOf(this.ljU), Integer.valueOf(this.ljV)});
        this.qqr = this.qqp >= 0;
        PInt pInt2 = new PInt();
        if (t.a(this.qqo, pInt2, new PInt())) {
            this.qqp = pInt2.value;
        }
        if (this.qqr) {
            x.i("MicroMsg.NoteVideoCompress", "remuxing video sucess,insert to media duplication storage");
            try {
                String name = new File(this.qqo).getName();
                String str = this.qqo + ".tmp";
                if (d.b(this.qqo, str, new PInt(0))) {
                    boolean deleteFile = e.deleteFile(this.qqo);
                    File file = new File(str);
                    boolean i = e.i(file.getParent() + File.separator, file.getName(), name);
                    x.i("MicroMsg.NoteVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[]{Boolean.valueOf(deleteFile), Boolean.valueOf(i), file.getAbsolutePath(), this.qqo});
                } else {
                    x.i("MicroMsg.NoteVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[]{Integer.valueOf(new PInt(0).value), this.elu, this.qqo});
                }
                au.HU();
                c.FY().K(this.elu, this.qqo, this.qqp);
            } catch (Exception e) {
                x.e("MicroMsg.NoteVideoCompress", "fast start exception e[%s]", new Object[]{e.toString()});
            }
        } else {
            x.w("MicroMsg.NoteVideoCompress", "remuxing video error, copy source video to send.");
            e.deleteFile(this.qqo);
            com.tencent.mm.sdk.platformtools.j.q(this.elu, this.qqo, false);
        }
        return true;
    }

    public final boolean Ks() {
        synchronized (d.bZQ()) {
            d.bZR().remove(this.fileName);
        }
        if (this.qqe != null) {
            this.qqe.b(this.qqo, this.qqf);
        }
        return false;
    }
}
