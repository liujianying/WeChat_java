package com.tencent.mm.e.a;

import android.content.Context;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.g.b;
import com.tencent.mm.ab.g.c;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.util.b$a;
import com.tencent.mm.e.b.g$b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.j;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class a implements g, com.tencent.mm.compatible.b.f.a {
    private static String bCR = null;
    private d bCG;
    private boolean bCH;
    private boolean bCI;
    private boolean bCJ;
    private int bCK;
    private boolean bCL;
    private boolean bCM;
    private boolean bCN;
    private c bCO;
    private g.d bCP;
    private String bCQ;
    private b$a bCS;
    public b bCT;
    public com.tencent.mm.ab.g.a bCU;
    private Context context;

    public a(Context context) {
        this(context, 0);
    }

    public a(Context context, int i) {
        this.bCG = null;
        this.context = null;
        this.bCH = false;
        this.bCI = false;
        this.bCJ = false;
        this.bCK = 0;
        this.bCL = false;
        this.bCM = false;
        this.bCN = true;
        this.bCQ = null;
        this.bCS = new 1(this);
        this.bCT = null;
        this.context = context;
        this.bCK = i;
        g$b g_b = new g$b();
    }

    public final boolean isPlaying() {
        if (this.bCG == null) {
            return false;
        }
        return this.bCG.isPlaying();
    }

    public final boolean a(String str, boolean z, boolean z2, int i) {
        x.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(this.bCK)});
        Assert.assertTrue(str.length() > 0);
        bCR = this.bCQ;
        this.bCQ = str;
        String str2;
        if (FileOp.cn(z2 ? str : q.getFullPath(str))) {
            if (i == -1) {
                i = o.d(str, this.bCK, z2);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.bCG = new s(this.context);
                } else {
                    this.bCG = new s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.bCG = new j(this.context);
                } else {
                    this.bCG = new j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.bCG = new i(this.context);
                } else {
                    this.bCG = new i();
                }
            }
            if (this.bCG != null) {
                this.bCG.b(this.bCS);
            }
            this.bCH = z;
            this.bCL = z;
            if (f.yz().yK() || f.yz().yE()) {
                x.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[]{Boolean.valueOf(f.yz().yK()), Boolean.valueOf(f.yz().yE())});
                this.bCH = false;
            }
            f.yz().e(this.bCH, false, false);
            wa();
            setError();
            str2 = null;
            if (z2) {
                str2 = str;
            } else if (this.bCK == 0) {
                str2 = q.getFullPath(str);
            }
            f.yz().a(this);
            if (!f.yz().yK()) {
                f.yz().yB();
                this.bCM = true;
            }
            if (this.bCG.M(str2, this.bCH)) {
                return true;
            }
            x.i("MicroMsg.SceneVoicePlayer", "start play error fileName[" + str + "], [" + z + "]");
            f.yz().yC();
            this.bCM = false;
            return false;
        }
        str2 = "MicroMsg.SceneVoicePlayer";
        String str3 = "start, file %s not exist!, fullPath: %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (!z2) {
            str = q.getFullPath(str);
        }
        objArr[1] = str;
        x.e(str2, str3, objArr);
        return false;
    }

    public final boolean a(String str, boolean z, int i, int i2) {
        x.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i), Integer.valueOf(this.bCK)});
        Assert.assertTrue(str.length() > 0);
        if (FileOp.cn(str)) {
            if (i == -1) {
                i = o.d(str, this.bCK, true);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.bCG = new s(this.context);
                } else {
                    this.bCG = new s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.bCG = new j(this.context);
                } else {
                    this.bCG = new j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.bCG = new i(this.context);
                } else {
                    this.bCG = new i();
                }
            }
            if (this.bCG != null) {
                this.bCG.b(this.bCS);
            }
            this.bCH = z;
            this.bCL = z;
            if (f.yz().yK() || f.yz().yE()) {
                x.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[]{Boolean.valueOf(f.yz().yK()), Boolean.valueOf(f.yz().yE())});
                this.bCH = false;
            }
            f.yz().e(this.bCH, false, false);
            wa();
            setError();
            f.yz().a(this);
            if (!f.yz().yK()) {
                f.yz().yB();
                this.bCM = true;
            }
            if (this.bCG.c(str, this.bCH, i2)) {
                return true;
            }
            x.i("MicroMsg.SceneVoicePlayer", "start play fileName[" + str + "], [" + z + "]");
            f.yz().yC();
            this.bCM = false;
            return false;
        }
        x.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[]{str, str});
        return false;
    }

    public final boolean pause() {
        return aI(true);
    }

    public final boolean aI(boolean z) {
        if (this.bCG == null) {
            return false;
        }
        boolean aI;
        x.i("MicroMsg.SceneVoicePlayer", "pause");
        if (this.bCG.isPlaying()) {
            aI = this.bCG.aI(z);
        } else {
            aI = false;
        }
        if (aI) {
            if (this.bCM) {
                f.yz().yC();
                this.bCM = false;
            }
            if (this.bCO != null) {
                this.bCO.bz(z);
            }
        }
        f.yz().setMode(0);
        return aI;
    }

    public final boolean vY() {
        if (this.bCG == null) {
            return false;
        }
        x.i("MicroMsg.SceneVoicePlayer", "resume");
        boolean vY = this.bCG.vY();
        if (vY) {
            f.yz().yB();
            this.bCM = true;
            if (f.yz().yE()) {
                this.bCH = false;
            }
            f.yz().e(this.bCH, false, false);
        }
        return vY;
    }

    public final boolean m(String str, boolean z) {
        return a(str, z, false, -1);
    }

    public final boolean vZ() {
        return this.bCI;
    }

    public final void stop() {
        aJ(false);
    }

    public final void aJ(boolean z) {
        if (this.bCG != null) {
            x.i("MicroMsg.SceneVoicePlayer", "stop, isRequestStartBluetooth: %b, player.isPlaying: %b, fromStart: %b", new Object[]{Boolean.valueOf(this.bCM), Boolean.valueOf(this.bCG.isPlaying()), Boolean.valueOf(z)});
            this.bCG.wk();
            f.yz().b(this);
            if (this.bCM && !z) {
                f.yz().yC();
                this.bCM = false;
            }
            if (!(z || this.bCP == null)) {
                this.bCP.onStop();
            }
            f.yz().setMode(0);
        }
    }

    public final void aK(boolean z) {
        if (this.bCH != z) {
            this.bCH = z;
            if (this.bCG != null && this.bCG.isPlaying()) {
                this.bCG.aK(z);
            }
            f.yz().e(z, false, false);
        }
    }

    public final void a(b bVar) {
        this.bCT = bVar;
    }

    public final void a(c cVar) {
        this.bCO = cVar;
    }

    public final void a(g.d dVar) {
        this.bCP = dVar;
    }

    private void setError() {
        2 2 = new 2(this);
        if (this.bCG != null) {
            this.bCG.a(2);
        }
    }

    public final void a(com.tencent.mm.ab.g.a aVar) {
        this.bCU = aVar;
    }

    private void wa() {
        3 3 = new 3(this);
        if (this.bCG != null) {
            this.bCG.a(3);
        }
    }

    public final double wb() {
        if (this.bCG == null) {
            return 0.0d;
        }
        return this.bCG.wb();
    }

    public final void aL(boolean z) {
        x.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", new Object[]{Boolean.valueOf(z)});
        this.bCJ = z;
    }

    public final boolean wc() {
        if (this.bCG != null && this.bCG.getStatus() == 2) {
            return true;
        }
        return false;
    }

    public final void ew(int i) {
        x.i("MicroMsg.SceneVoicePlayer", "onBluetoothHeadsetStateChange, status: %d, currentSpeaker: %b, bluetoothResumeSpeaker: %b, isRequestStartBluetooth: %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.bCH), Boolean.valueOf(this.bCL), Boolean.valueOf(this.bCM)});
        switch (i) {
            case 1:
                aK(false);
                return;
            case 2:
            case 4:
                aK(this.bCL);
                if (this.bCM) {
                    f.yz().yC();
                    this.bCM = false;
                    return;
                }
                return;
            case 6:
                aK(this.bCL);
                if (this.bCG != null && this.bCG.isPlaying()) {
                    f.yz().yB();
                    this.bCM = true;
                    return;
                }
                return;
            case 7:
                if (this.bCG != null && this.bCG.isPlaying()) {
                    f.yz().yB();
                    this.bCM = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
