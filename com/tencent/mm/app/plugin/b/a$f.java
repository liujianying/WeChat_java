package com.tencent.mm.app.plugin.b;

import com.tencent.mm.g.a.ff;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class a$f extends c<ff> {
    k bAY;
    al bAZ;
    boolean bBa;
    boolean bBb;
    boolean bBc;
    ff bBd;
    Runnable bBe;
    String fileName;

    public a$f() {
        this.fileName = "";
        this.sFo = ff.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = Downloads.DOWNLOAD_ERR_INTERRUPTED;
        ff ffVar = (ff) bVar;
        if (ffVar instanceof ff) {
            if (ffVar.bNp.op == 1) {
                if (this.bAY == null) {
                    this.bAY = new k();
                }
                this.bBe = ffVar.bNp.bBe;
                if (this.bAY.mStatus == 1) {
                    this.bAY.we();
                }
                ffVar.bNq.bJm = this.bAY.dc(ffVar.bNp.filePath);
                int i2 = ffVar.bNp.duration;
                if (i2 <= 0) {
                    x.e("MicroMsg.SubCoreExtAgent", "duration is invalid, less than 0");
                    i2 = 60;
                }
                if (i2 > Downloads.DOWNLOAD_ERR_INTERRUPTED) {
                    x.e("MicroMsg.SubCoreExtAgent", "duration is invalid, more than %d", new Object[]{Integer.valueOf(Downloads.DOWNLOAD_ERR_INTERRUPTED)});
                } else {
                    i = i2;
                }
                x.i("MicroMsg.SubCoreExtAgent", "MaxVoiceRecordTime (%d)s", new Object[]{Integer.valueOf(i)});
                long j = (long) (i * TbsLog.TBSLOG_CODE_SDK_BASE);
                if (this.bAZ == null) {
                    this.bAZ = new al(new 1(this), false);
                }
                if (this.bAZ.ciq()) {
                    this.bAZ.SO();
                }
                this.bBc = false;
                this.bAZ.J(j, j);
                this.bBa = false;
                x.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", new Object[]{Integer.valueOf(ffVar.bNp.op), Boolean.valueOf(ffVar.bNq.bJm)});
            } else if (ffVar.bNp.op == 2 && this.bAY != null) {
                if (!this.bBa) {
                    this.bAZ.SO();
                    x.i("MicroMsg.SubCoreExtAgent", "Voice record stop.");
                    stopRecord();
                }
                ffVar.bNq.bJm = this.bBb;
                x.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", new Object[]{Integer.valueOf(ffVar.bNp.op), this.fileName, Boolean.valueOf(ffVar.bNq.bJm)});
                this.fileName = "";
                this.bBb = false;
            }
            return true;
        }
        x.f("MicroMsg.SubCoreExtAgent", "mismatched event");
        return false;
    }

    final void stopRecord() {
        if (this.bAY != null) {
            this.bBb = this.bAY.we();
            if (this.bBe != null) {
                if (this.bBd != null) {
                    this.bBd.bNq.bNr = this.bAY.bDp.bEg;
                    this.bBd = null;
                }
                if (this.bBc) {
                    this.bBe.run();
                }
                this.bBe = null;
            }
            this.bBa = true;
        }
    }
}
