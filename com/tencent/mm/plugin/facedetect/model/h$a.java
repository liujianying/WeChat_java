package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class h$a {
    public String eYF;
    public long iNC;
    public long iND;
    public boolean iNE;
    public long iNF;
    public String iNG;
    public boolean iNH;
    public boolean iNI;
    public int type;

    public h$a(int i, String str) {
        this.type = i;
        this.iNG = str;
        switch (this.type) {
            case 0:
                this.iNC = 30;
                this.iND = 7000;
                this.eYF = ad.getContext().getString(h.soter_face_err_msg_ok);
                this.iNE = true;
                this.iNF = 2500;
                this.iNH = false;
                this.iNI = false;
                return;
            case 1:
                this.iNC = 30;
                this.iND = 7000;
                this.eYF = ad.getContext().getString(h.face_detect_hint_pose_left);
                this.iNE = false;
                this.iNF = -1;
                this.iNH = true;
                this.iNI = true;
                return;
            case 2:
                this.iNC = 30;
                this.iND = 7000;
                this.eYF = ad.getContext().getString(h.face_detect_hint_pose_right);
                this.iNE = false;
                this.iNF = -1;
                this.iNH = true;
                this.iNI = true;
                return;
            case 3:
                this.iNC = 30;
                this.iND = 7000;
                this.eYF = ad.getContext().getString(h.face_detect_hint_eye);
                this.iNE = true;
                this.iNF = -1;
                this.iNH = true;
                this.iNI = true;
                return;
            case 4:
                this.iNC = 30;
                this.iND = 7000;
                this.eYF = ad.getContext().getString(h.face_detect_hint_read_number);
                this.iNE = true;
                this.iNF = 1000;
                this.iNH = true;
                this.iNI = true;
                return;
            default:
                x.e("MicroMsg.FaceDetectProcessModel", "hy: unknown type");
                this.type = 100;
                return;
        }
    }

    public final String toString() {
        return "FaceProcessItem{type=" + this.type + ", frameTween=" + this.iNC + ", hintTween=" + this.iND + ", hintStr='" + this.eYF + '\'' + ", isCheckFace=" + this.iNE + ", minSuccTime=" + this.iNF + ", actionData='" + this.iNG + '\'' + '}';
    }
}
