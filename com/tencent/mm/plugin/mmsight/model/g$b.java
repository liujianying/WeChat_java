package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;

public class g$b {
    public Point lgn;
    public Point lgo;
    public Point lgp;
    public Point lgq;
    public Point lgr;
    public Point lgs;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.lgn != null) {
            stringBuffer.append(this.lgn.toString() + ",");
        }
        if (this.lgo != null) {
            stringBuffer.append(this.lgo.toString() + ",");
        }
        if (this.lgp != null) {
            stringBuffer.append(this.lgp.toString() + ",");
        }
        if (this.lgq != null) {
            stringBuffer.append(this.lgq.toString() + ",");
        }
        if (this.lgr != null) {
            stringBuffer.append(this.lgr.toString() + ",");
        }
        if (this.lgs != null) {
            stringBuffer.append(this.lgs.toString() + ",");
        }
        return stringBuffer.toString();
    }
}
