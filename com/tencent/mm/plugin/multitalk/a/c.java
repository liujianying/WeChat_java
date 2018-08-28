package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.talkroom.sdk.b;
import com.tencent.pb.talkroom.sdk.d;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class c implements e {
    a bEs = new a() {
        public final void s(byte[] bArr, int i) {
            if (i <= 0) {
                x.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
            } else if (c.this.ltd != null) {
                c.this.ltd.V(bArr, i);
            }
        }

        public final void aN(int i, int i2) {
            x.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    };
    public d lta;
    b ltb;
    com.tencent.mm.e.b.c ltc;
    com.tencent.pb.talkroom.sdk.c ltd;
    b lte;
    com.tencent.mm.plugin.voip.model.a ltf = new 3(this);

    static /* synthetic */ void a(c cVar) {
        byte[] bArr = new byte[]{(byte) 0};
        byte[] bArr2 = new byte[2];
        if (q.deN.dci >= 0) {
            bArr2[0] = (byte) q.deN.dci;
            cVar.lta.setAppCmd(TbsListener$ErrorCode.INFO_MISS_SDKEXTENSION_JAR_OLD, bArr2, 1);
        } else if (q.deN.dci == -2) {
            cVar.lta.setAppCmd(TbsListener$ErrorCode.INFO_CAN_NOT_LOAD_X5, bArr, 1);
        }
        if (q.deN.dcl >= 0) {
            byte[] bArr3 = new byte[5];
            if (q.deN.dcm >= 0 && q.deN.dcn >= 0) {
                bArr3[0] = (byte) q.deN.dcm;
                bArr3[1] = (byte) q.deN.dcn;
                if (q.deN.dco >= 0) {
                    bArr3[2] = (byte) q.deN.dco;
                    bArr3[3] = (byte) q.deN.dcl;
                    bArr3[4] = (byte) q.deN.dcp;
                    cVar.lta.setAppCmd(TbsListener$ErrorCode.INFO_DISABLE_X5, bArr3, 5);
                } else {
                    cVar.lta.setAppCmd(TbsListener$ErrorCode.INFO_DISABLE_X5, bArr3, 2);
                }
            }
        } else if (q.deN.dcl == -2) {
            cVar.lta.setAppCmd(TbsListener$ErrorCode.INFO_CAN_NOT_LOAD_TBS, bArr, 1);
        }
        if (q.deN.dcj >= 0) {
            bArr2[0] = (byte) q.deN.dcj;
            cVar.lta.setAppCmd(TbsListener$ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH, bArr2, 1);
        } else if (q.deN.dcj == -2) {
            cVar.lta.setAppCmd(TbsListener$ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE, bArr, 1);
        }
        if (q.deN.dcu[0] > (short) 0 || q.deN.dcu[1] > (short) 0) {
            bArr2[0] = (byte) 0;
            bArr2[1] = (byte) 0;
            if (q.deN.dcu[0] > (short) 0 && q.deN.dcu[0] < (short) 10000) {
                bArr2[0] = (byte) q.deN.dcu[0];
            }
            if (q.deN.dcu[1] > (short) 0 && q.deN.dcu[1] < (short) 10000) {
                bArr2[1] = (byte) q.deN.dcu[1];
            }
            cVar.lta.setAppCmd(423, bArr2, 2);
        }
        if (q.deN.dbL >= 0 || q.deN.dbN >= 0) {
            bArr2[0] = (byte) -1;
            bArr2[1] = (byte) -1;
            if (q.deN.dbL >= 0) {
                bArr2[0] = (byte) q.deN.dbL;
            }
            if (q.deN.dbN >= 0) {
                bArr2[1] = (byte) q.deN.dbN;
            }
            cVar.lta.setAppCmd(TbsListener$ErrorCode.INFO_SDKINIT_IS_SYS_FORCED, bArr2, 2);
        }
        if (q.deN.dbM >= 0 || q.deN.dbO >= 0) {
            bArr2[0] = (byte) -1;
            bArr2[1] = (byte) -1;
            if (q.deN.dbM >= 0) {
                bArr2[0] = (byte) q.deN.dbM;
            }
            if (q.deN.dbO >= 0) {
                bArr2[1] = (byte) q.deN.dbO;
            }
            cVar.lta.setAppCmd(TbsListener$ErrorCode.INFO_INITX5_FALSE_DEFAULT, bArr2, 2);
        }
        if (q.deN.dbP >= 0 || q.deN.dbQ >= 0) {
            bArr2[0] = (byte) -1;
            bArr2[1] = (byte) -1;
            if (q.deN.dbP >= 0) {
                bArr2[0] = (byte) q.deN.dbP;
            }
            if (q.deN.dbQ >= 0) {
                bArr2[1] = (byte) q.deN.dbQ;
            }
            cVar.lta.setAppCmd(422, bArr2, 2);
        }
        if (q.deN.dbR >= 0) {
            bArr2[0] = (byte) q.deN.dbR;
            cVar.lta.setAppCmd(TbsListener$ErrorCode.INFO_USE_BACKUP_FILE_INSTALL_BY_SERVER, bArr2, 1);
        }
        if (q.deN.dbS >= 0 && q.deN.dbS != 5) {
            bArr2[0] = (byte) q.deN.dbS;
            cVar.lta.setAppCmd(TbsListener$ErrorCode.INFO_TEMP_CORE_EXIST_CONF_ERROR, bArr2, 1);
        }
        if (q.deN.dbT >= 0 && q.deN.dbT != 5) {
            bArr2[0] = (byte) q.deN.dbT;
            cVar.lta.setAppCmd(TbsListener$ErrorCode.INFO_CORE_EXIST_NOT_LOAD, bArr2, 1);
        }
        if (q.deN.dbU >= 0) {
            bArr2[0] = (byte) q.deN.dbU;
            cVar.lta.setAppCmd(419, bArr2, 1);
        }
        if (1 == q.deN.dcs) {
            byte[] bArr4 = new byte[30];
            for (int i = 0; i < 15; i++) {
                bArr4[i * 2] = (byte) (q.deN.dct[i] & 255);
                bArr4[(i * 2) + 1] = (byte) ((q.deN.dct[i] >> 8) & 255);
            }
            cVar.lta.setAppCmd(420, bArr4, 30);
        }
        if (q.deN.dcs == 0) {
            cVar.lta.setAppCmd(421, bArr, 1);
        }
        if (q.deN.dcw > 0) {
            bArr2[0] = (byte) q.deN.dcw;
            cVar.lta.setAppCmd(424, bArr2, 1);
        }
        if (q.deN.dbV > 0) {
            bArr2[0] = (byte) q.deN.dbV;
            cVar.lta.setAppCmd(431, bArr2, 4);
        }
        if (q.deN.dcE >= 0) {
            cVar.lta.setAppCmd(426, new byte[]{(byte) q.deN.dcE, (byte) q.deN.dcF, (byte) q.deN.dcG, (byte) q.deN.dcH}, 4);
        }
    }

    public c() {
        x.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
        Context context = ad.getContext();
        com.tencent.wecall.talkroom.model.e cHL = com.tencent.wecall.talkroom.model.e.cHL();
        com.tencent.wecall.talkroom.model.e.ig(context);
        this.lta = cHL;
        this.lta.cEI();
        this.ltb = new b();
        int f = bi.f((Integer) au.HS().get(1));
        this.lta.a(o.bgN(), new 1(this));
        this.lta.bg(f, com.tencent.mm.model.q.GF());
        au.DF().a(1918, this);
        au.DF().a(1919, this);
        au.DF().a(1927, this);
        au.DF().a(1928, this);
        au.DF().a(1929, this);
        au.DF().a(1931, this);
        au.DF().a(1932, this);
        au.DF().a(1933, this);
        au.DF().a(1935, this);
        au.DF().a(1937, this);
        au.DF().a(1938, this);
        au.DF().a(1939, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        n nVar = (n) lVar;
        x.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + i + " errCode " + i2 + " cmdid " + nVar.isz);
        this.lta.c(i2, nVar.isy, nVar.isz, nVar.cdy);
    }
}
