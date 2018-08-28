package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.e.b.c;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    public static final String iOE = (h.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx");
    private static final String iOz = (o.aJX() + File.separator + "fdv_v_");
    c bDp;
    private com.tencent.mm.e.b.c.a bEb = new 2(this);
    com.tencent.mm.modelvoiceaddr.a.c eqF;
    private com.tencent.mm.modelvoiceaddr.a.c.a eqG = new com.tencent.mm.modelvoiceaddr.a.c.a() {
        public final void b(short[] sArr, int i) {
            x.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", new Object[]{sArr, Integer.valueOf(i)});
        }

        public final void Ub() {
            x.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
        }

        public final void Uc() {
            x.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
            if (a.this.iOA != null) {
                a.this.iOA.aKb();
            }
        }

        public final void vU() {
            x.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
            if (a.this.iOA != null) {
                a.this.iOA.onError(11);
            }
        }
    };
    private int eqt = 0;
    int equ = 0;
    com.tencent.mm.e.c.a eqz;
    boolean erb = true;
    b iOA = null;
    boolean iOB = false;
    String iOC = "";
    ArrayList<com.tencent.mm.e.b.c.a> iOD = new ArrayList(5);
    public com.tencent.mm.e.b.c.a iOF = new com.tencent.mm.e.b.c.a() {
        public final void s(byte[] bArr, int i) {
            if (a.this.iOD != null) {
                Iterator it = a.this.iOD.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.e.b.c.a aVar = (com.tencent.mm.e.b.c.a) it.next();
                    if (aVar != null) {
                        aVar.s(bArr, i);
                    }
                }
            }
        }

        public final void aN(int i, int i2) {
            if (a.this.iOD != null) {
                Iterator it = a.this.iOD.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.e.b.c.a aVar = (com.tencent.mm.e.b.c.a) it.next();
                    if (aVar != null) {
                        aVar.aN(i, i2);
                    }
                }
            }
        }
    };

    static /* synthetic */ void a(a aVar, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > aVar.eqt) {
                aVar.eqt = s;
            }
        }
    }

    public final void aKa() {
        e.deleteFile(this.iOC);
    }

    public final void a(com.tencent.mm.e.b.c.a aVar) {
        this.iOD.add(aVar);
    }
}
