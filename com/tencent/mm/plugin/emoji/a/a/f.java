package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.tj;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ao;

public final class f {
    public tj ieA;
    public int ieB;
    public String ieC;
    public boolean ieD;
    public boolean ieE = true;
    public boolean ieF = false;
    public int iey;
    public ts iez;
    public int mStatus;
    public int pF;

    public f(ts tsVar) {
        this.iez = tsVar;
        this.iey = a.ieG;
    }

    public f(tj tjVar) {
        this.ieA = tjVar;
        this.iey = a.ieH;
    }

    public final void setStatus(int i) {
        if (i == 7 && this.mStatus == 6 && this.ieE) {
            this.ieD = true;
        }
        this.mStatus = i;
    }

    public final void a(boolean z, ao aoVar, boolean z2) {
        ts tsVar = this.iez;
        if (tsVar != null) {
            if (z2) {
                setStatus(7);
                return;
            }
            boolean a = e.a(tsVar);
            boolean b = e.b(tsVar);
            boolean cs = tsVar == null ? false : e.cs(tsVar.rwV, 8);
            boolean isEmpty = TextUtils.isEmpty(tsVar.rwT);
            if (!cs || !b) {
                if (!a) {
                    if (!b && (z || !isEmpty)) {
                        this.ieB = 1;
                        if (z && aoVar != null) {
                            switch (aoVar.taW) {
                                case 11:
                                    setStatus(11);
                                    break;
                                case 12:
                                    setStatus(4);
                                    break;
                                default:
                                    if (!(aoVar.taU == 7 || aoVar.taU == 6 || aoVar.taU == 3)) {
                                        setStatus(10);
                                        break;
                                    }
                            }
                        } else if (z) {
                            setStatus(11);
                        } else {
                            setStatus(4);
                        }
                    } else {
                        setStatus(3);
                        this.ieB = 0;
                    }
                } else {
                    setStatus(3);
                    if (b || (!z && isEmpty)) {
                        this.ieB = 0;
                    } else {
                        this.ieB = 1;
                    }
                }
            } else {
                setStatus(8);
            }
            if (z && aoVar != null && !bi.oW(aoVar.taY)) {
                this.iez.rwT = aoVar.taY;
            }
        }
    }
}
