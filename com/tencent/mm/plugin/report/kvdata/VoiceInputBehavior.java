package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;

public class VoiceInputBehavior extends a {
    public int cancel;
    public int clear;
    public int click;
    public int fail;
    public int fullScreenVoiceLongClick;
    public long fullScreenVoiceLongClickTime;
    public int longClick;
    public long longClickTime;
    public int send;
    public int smileIconClick;
    public int textChangeCount;
    public int textChangeReturn;
    public long textChangeTime;
    public int textClick;
    public int voiceIconClick;
    public long voiceInputTime;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.cancel);
            aVar.fT(2, this.send);
            aVar.fT(3, this.click);
            aVar.fT(4, this.longClick);
            aVar.T(5, this.longClickTime);
            aVar.fT(6, this.textClick);
            aVar.fT(7, this.textChangeCount);
            aVar.T(8, this.textChangeTime);
            aVar.fT(9, this.textChangeReturn);
            aVar.T(10, this.voiceInputTime);
            aVar.fT(11, this.fail);
            aVar.fT(12, this.clear);
            aVar.fT(13, this.smileIconClick);
            aVar.fT(14, this.voiceIconClick);
            aVar.fT(15, this.fullScreenVoiceLongClick);
            aVar.T(16, this.fullScreenVoiceLongClickTime);
            return 0;
        } else if (i == 1) {
            return (((((((((((((((f.a.a.a.fQ(1, this.cancel) + 0) + f.a.a.a.fQ(2, this.send)) + f.a.a.a.fQ(3, this.click)) + f.a.a.a.fQ(4, this.longClick)) + f.a.a.a.S(5, this.longClickTime)) + f.a.a.a.fQ(6, this.textClick)) + f.a.a.a.fQ(7, this.textChangeCount)) + f.a.a.a.S(8, this.textChangeTime)) + f.a.a.a.fQ(9, this.textChangeReturn)) + f.a.a.a.S(10, this.voiceInputTime)) + f.a.a.a.fQ(11, this.fail)) + f.a.a.a.fQ(12, this.clear)) + f.a.a.a.fQ(13, this.smileIconClick)) + f.a.a.a.fQ(14, this.voiceIconClick)) + f.a.a.a.fQ(15, this.fullScreenVoiceLongClick)) + f.a.a.a.S(16, this.fullScreenVoiceLongClickTime);
        } else {
            if (i == 2) {
                f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                VoiceInputBehavior voiceInputBehavior = (VoiceInputBehavior) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        voiceInputBehavior.cancel = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        voiceInputBehavior.send = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        voiceInputBehavior.click = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        voiceInputBehavior.longClick = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        voiceInputBehavior.longClickTime = aVar3.vHC.rZ();
                        return 0;
                    case 6:
                        voiceInputBehavior.textClick = aVar3.vHC.rY();
                        return 0;
                    case 7:
                        voiceInputBehavior.textChangeCount = aVar3.vHC.rY();
                        return 0;
                    case 8:
                        voiceInputBehavior.textChangeTime = aVar3.vHC.rZ();
                        return 0;
                    case 9:
                        voiceInputBehavior.textChangeReturn = aVar3.vHC.rY();
                        return 0;
                    case 10:
                        voiceInputBehavior.voiceInputTime = aVar3.vHC.rZ();
                        return 0;
                    case 11:
                        voiceInputBehavior.fail = aVar3.vHC.rY();
                        return 0;
                    case 12:
                        voiceInputBehavior.clear = aVar3.vHC.rY();
                        return 0;
                    case 13:
                        voiceInputBehavior.smileIconClick = aVar3.vHC.rY();
                        return 0;
                    case 14:
                        voiceInputBehavior.voiceIconClick = aVar3.vHC.rY();
                        return 0;
                    case 15:
                        voiceInputBehavior.fullScreenVoiceLongClick = aVar3.vHC.rY();
                        return 0;
                    case 16:
                        voiceInputBehavior.fullScreenVoiceLongClickTime = aVar3.vHC.rZ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
