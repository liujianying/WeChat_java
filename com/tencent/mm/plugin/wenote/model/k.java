package com.tencent.mm.plugin.wenote.model;

import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.e.b.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;

public final class k {
    private static k qoB = null;
    public long duration;
    public b epT = new b(ad.getContext());
    private final ag hnB = new ag() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            k.this.hnt = false;
        }
    };
    public long hng = -1;
    private Toast hnh;
    public boolean hnt;
    public boolean hnu;
    public final al hnz = new al(new a() {
        public final boolean vD() {
            if (k.this.hng == -1) {
                k.this.hng = bi.VG();
            }
            long bI = bi.bI(k.this.hng);
            if (bI >= 3590000 && bI <= 3600000) {
                if (k.this.hnh == null) {
                    k.this.hnh = Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.fav_rcd_time_limit, new Object[]{Integer.valueOf((int) ((3600000 - bI) / 1000))}), 0);
                } else {
                    k.this.hnh.setText(ad.getContext().getString(R.l.fav_rcd_time_limit, new Object[]{Integer.valueOf((int) ((3600000 - bI) / 1000))}));
                }
                k.this.hnh.show();
            }
            if (bI < 3600000) {
                return true;
            }
            x.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
            k.this.hnu = true;
            k.this.i();
            if (k.this.qoD != null) {
                k.this.qoD.bZj();
            }
            return false;
        }
    }, true);
    public long iZe;
    public j iZl;
    public TextView jaG;
    public String path = "";
    public String qoA = "";
    public int qoC = 0;
    public com.tencent.mm.plugin.wenote.model.b.a qoD;
    public com.tencent.mm.plugin.wenote.model.a.k qoE = null;
    public final ag qoF = new 4(this);
    public com.tencent.mm.modelvoice.k qoz;

    private k() {
    }

    public static k bZe() {
        if (qoB == null) {
            qoB = new k();
        }
        return qoB;
    }

    /* renamed from: aMn */
    public final void i() {
        if (this.hnt) {
            boolean z;
            this.qoF.removeMessages(Downloads.RECV_BUFFER_SIZE);
            if (this.qoA.equals("speex")) {
                this.qoz.we();
            } else {
                this.iZl.we();
            }
            if (this.epT != null) {
                this.epT.zY();
            }
            this.duration = getDuration();
            if (this.duration < 800) {
                z = true;
            } else {
                z = false;
            }
            this.hnz.SO();
            if (z) {
                File file = new File(this.path);
                if (file.exists()) {
                    file.delete();
                }
                this.hnB.sendEmptyMessageDelayed(0, 500);
            }
            this.hnt = false;
        }
    }

    private long getDuration() {
        if (this.iZe == 0) {
            return 0;
        }
        return bi.bI(this.iZe);
    }

    public static void destroy() {
        qoB = null;
    }

    public static k bZf() {
        return qoB;
    }
}
