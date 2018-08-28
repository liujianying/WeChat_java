package com.tencent.mm.modelvoiceaddr.a;

import android.content.SharedPreferences;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.util.Locale;

public class c {
    private static final String TAG = c.class.getSimpleName();
    public static SharedPreferences duR = ad.chZ();
    private boolean erb;
    private int erc;
    private boolean erd;
    private boolean ere;
    private long erf;
    private int erg;
    private boolean erh;
    private a eri;
    private com.qq.wx.voice.vad.a erj;
    public a erk;
    private short[] erl;
    private ag handler;

    public interface a {
        void Ub();

        void Uc();

        void b(short[] sArr, int i);

        void vU();
    }

    public static String Ug() {
        return String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[]{"sil_time", Integer.valueOf(duR.getInt("sil_time", TbsListener$ErrorCode.INFO_CODE_MINIQB)), "s_n_ration", Float.valueOf(duR.getFloat("s_n_ration", 2.5f)), "s_window", Integer.valueOf(duR.getInt("s_window", TbsListener$ErrorCode.INFO_CODE_MINIQB)), "s_length", Integer.valueOf(duR.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(duR.getInt("s_delay_time", 550))});
    }

    public c() {
        this(3500, duR.getInt("sil_time", TbsLog.TBSLOG_CODE_SDK_BASE), duR.getFloat("s_n_ration", 2.5f), duR.getInt("s_window", TbsListener$ErrorCode.INFO_CODE_MINIQB), duR.getInt("s_length", 350), duR.getInt("s_delay_time", 550), true, true);
    }

    public c(int i, int i2, float f, int i3, int i4, int i5, boolean z, boolean z2) {
        this.erb = true;
        this.erc = 3;
        this.erd = false;
        this.ere = false;
        this.erf = 0;
        this.erg = 3500;
        this.erh = false;
        this.handler = new 1(this, Looper.getMainLooper());
        this.eri = null;
        this.erj = null;
        this.erg = i;
        this.erj = new com.qq.wx.voice.vad.a();
        int i6 = 0;
        if (ad.cic()) {
            com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100235");
            if (fJ.isValid()) {
                i6 = bi.getInt((String) fJ.ckq().get("MMVoipVadOn"), 0);
            }
        }
        x.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", new Object[]{Integer.valueOf(i6)});
        if (i6 == 0) {
            com.qq.wx.voice.vad.a.ay(false);
        } else {
            com.qq.wx.voice.vad.a.ay(true);
        }
        com.qq.wx.voice.vad.a aVar = this.erj;
        if (com.qq.wx.voice.vad.a.bgy) {
            aVar.bgv = aVar.bgx.Init(16000, i2, f, i3, i4);
        } else {
            aVar.bgv = aVar.bgw.Init(16000, i2, f, i3, i4);
        }
        if (com.qq.wx.voice.vad.a.DEBUG) {
            System.out.println("EVad Init handle = " + aVar.bgv);
        }
        if ((aVar.bgv == 0 ? 1 : 0) != 1) {
            com.qq.wx.voice.vad.a aVar2 = this.erj;
            if (aVar2.bgv == 0) {
                i6 = 1;
            } else {
                if (com.qq.wx.voice.vad.a.DEBUG) {
                    System.out.println("EVad Reset handle = " + aVar2.bgv);
                }
                i6 = com.qq.wx.voice.vad.a.bgy ? aVar2.bgx.Reset(aVar2.bgv) : aVar2.bgw.Reset(aVar2.bgv);
            }
            if (i6 != 1) {
                this.eri = new a(i5 * 16);
                this.erl = new short[4000];
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) i);
                this.erd = z;
                this.ere = z2;
                return;
            }
        }
        throw new b("Init ERROR");
    }

    public final void d(short[] sArr, int i) {
        x.d(TAG, "input() called with: voice = [%s], length = [%s]", new Object[]{sArr, Integer.valueOf(i)});
        if (sArr != null && sArr.length != 0 && i > 0 && i <= sArr.length) {
            if (this.erh) {
                x.i(TAG, "VoiceSilentDetectAPI is released.");
                return;
            }
            int i2;
            int i3;
            int i4;
            com.qq.wx.voice.vad.a aVar = this.erj;
            if (aVar.bgv == 0) {
                i2 = 1;
            } else {
                if (com.qq.wx.voice.vad.a.DEBUG) {
                    System.out.println("EVad AddData handle = " + aVar.bgv);
                }
                i2 = com.qq.wx.voice.vad.a.bgy ? aVar.bgx.AddData(aVar.bgv, sArr, i) : aVar.bgw.AddData(aVar.bgv, sArr, i);
            }
            x.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.erc), Boolean.valueOf(this.erd), Boolean.valueOf(this.ere)});
            long currentTimeMillis;
            if (this.erd) {
                if (this.ere) {
                    currentTimeMillis = System.currentTimeMillis();
                    if (this.erk != null) {
                        this.erk.Uc();
                    }
                    this.erf = currentTimeMillis;
                    if (!this.erh) {
                        i3 = this.eri.eqZ;
                        int length = this.erl.length;
                        while (i3 > 0) {
                            if (length > i3) {
                                i4 = i3;
                            } else {
                                i4 = length;
                            }
                            this.eri.c(this.erl, i4);
                            i3 -= i4;
                            if (this.erk != null) {
                                this.erk.b(this.erl, i4);
                            }
                        }
                        this.ere = false;
                        this.handler.removeMessages(0);
                        this.handler.sendEmptyMessageDelayed(0, (long) this.erg);
                    } else {
                        return;
                    }
                }
                if (this.erc == 3 && i2 == 2) {
                    this.erd = false;
                }
                if (!(this.erc == 3 && i2 == 3)) {
                    this.handler.removeMessages(0);
                    this.handler.sendEmptyMessageDelayed(0, (long) this.erg);
                }
                this.erb = false;
                this.erc = i2;
            } else if (this.erc == 3 && i2 == 2) {
                this.erc = i2;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.erg);
                currentTimeMillis = System.currentTimeMillis();
                if (this.erk != null) {
                    this.erk.Uc();
                }
                this.erf = currentTimeMillis;
                if (!this.erh) {
                    i4 = this.eri.eqZ;
                    i3 = this.erl.length;
                    while (i4 > 0) {
                        if (i3 > i4) {
                            i2 = i4;
                        } else {
                            i2 = i3;
                        }
                        this.eri.c(this.erl, i2);
                        i4 -= i2;
                        if (this.erk != null) {
                            this.erk.b(this.erl, i2);
                        }
                    }
                    this.erb = false;
                } else {
                    return;
                }
            } else if (this.erc == 2 && i2 == 3) {
                this.erc = i2;
                this.erb = true;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.erg);
                currentTimeMillis = System.currentTimeMillis();
                if (this.erk != null) {
                    this.erk.Ub();
                }
                this.erf = currentTimeMillis;
                if (this.erh) {
                    return;
                }
            } else if (this.erc == 3 && i2 == 3) {
                this.erb = true;
            } else if (this.erc == 2 && i2 == 2) {
                this.erb = false;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.erg);
            }
            if (!this.erh) {
                a aVar2 = this.eri;
                if (sArr.length >= 0) {
                    i4 = i > sArr.length + 0 ? sArr.length + 0 : i;
                    if (i4 != 0) {
                        i2 = aVar2.era.length - aVar2.eqZ;
                        if (i4 > i2) {
                            i2 = i4 - i2;
                            if (i2 != 0) {
                                if (i2 >= aVar2.eqZ) {
                                    i2 = aVar2.eqZ;
                                }
                                if (i2 <= aVar2.era.length - aVar2.eqX) {
                                    aVar2.eqX += i2;
                                    if (aVar2.eqX >= aVar2.era.length) {
                                        aVar2.eqX = 0;
                                    }
                                } else {
                                    aVar2.eqX = i2 - (aVar2.era.length - aVar2.eqX);
                                }
                                aVar2.eqZ -= i2;
                            }
                        }
                        if (i4 > aVar2.era.length) {
                            i4 = (i4 - aVar2.era.length) + 0;
                            i2 = aVar2.era.length;
                            i3 = i4;
                        } else {
                            i2 = i4;
                            i3 = 0;
                        }
                        if (i2 <= aVar2.era.length - aVar2.eqY) {
                            System.arraycopy(sArr, i3, aVar2.era, aVar2.eqY, i2);
                            aVar2.eqY += i2;
                            if (aVar2.eqY >= aVar2.era.length) {
                                aVar2.eqY = 0;
                            }
                        } else {
                            i4 = aVar2.era.length - aVar2.eqY;
                            System.arraycopy(sArr, i3, aVar2.era, aVar2.eqY, i4);
                            int i5 = i2 - i4;
                            System.arraycopy(sArr, i4 + i3, aVar2.era, 0, i5);
                            aVar2.eqY = i5;
                        }
                        aVar2.eqZ = i2 + aVar2.eqZ;
                    }
                }
                x.d(TAG, "isSilent %s", new Object[]{Boolean.valueOf(this.erb)});
                if (!this.erb && this.erk != null) {
                    this.erk.b(sArr, i);
                }
            }
        }
    }

    public final void release() {
        x.d(TAG, "released");
        this.erh = true;
        this.erd = false;
        this.ere = false;
        if (this.erj != null) {
            int i;
            com.qq.wx.voice.vad.a aVar = this.erj;
            if (aVar.bgv == 0) {
                i = 1;
            } else {
                if (com.qq.wx.voice.vad.a.DEBUG) {
                    System.out.println("EVad Release handle = " + aVar.bgv);
                }
                i = com.qq.wx.voice.vad.a.bgy ? aVar.bgx.Release(aVar.bgv) : aVar.bgw.Release(aVar.bgv);
            }
            if (i == 1) {
                throw new b();
            }
            this.erj = null;
        }
        this.eri = null;
        this.erl = null;
        if (this.handler != null) {
            this.handler.removeMessages(0);
            this.handler = null;
        }
        this.erk = null;
    }
}
