package com.tencent.mm.compatible.e;

import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public int dbA;
    public int dbB;
    public int dbC;
    public int dbD;
    public int dbE;
    public int dbF;
    public int dbG;
    public int dbH;
    public int dbI;
    public int dbJ;
    public int dbK;
    public int dbL;
    public int dbM;
    public int dbN;
    public int dbO;
    public int dbP;
    public int dbQ;
    public int dbR;
    public int dbS;
    public int dbT;
    public int dbU;
    public int dbV;
    public int dbW;
    public int dbX;
    public int dbY;
    public int dbZ;
    public boolean dby = false;
    public int dbz;
    public int dcA;
    public int dcB;
    public int dcC;
    public int dcD;
    public int dcE;
    public int dcF;
    public int dcG;
    public int dcH;
    public int dca;
    public int dcb;
    public int dcc;
    public boolean dcd;
    public int dce;
    public int dcf;
    public int dcg;
    public int dch;
    public int dci;
    public int dcj;
    public int dck;
    public int dcl;
    public int dcm;
    public int dcn;
    public int dco;
    public int dcp;
    public int dcq;
    public int dcr;
    public int dcs;
    public short[] dct = new short[15];
    public short[] dcu = new short[2];
    public boolean dcv;
    public int dcw;
    public boolean dcx = false;
    public int dcy;
    public int dcz;

    public b() {
        reset();
    }

    public final void reset() {
        this.dby = false;
        this.dbz = -1;
        this.dbA = -1;
        this.dbB = -1;
        this.dbC = -1;
        this.dbD = -1;
        this.dbE = -1;
        this.dbF = -1;
        this.dbH = -1;
        this.dbG = -1;
        this.dcl = -1;
        this.dbI = -1;
        this.dbJ = -1;
        this.dbK = -1;
        this.dbW = -1;
        this.dbX = -1;
        this.dbY = -1;
        this.dbZ = -1;
        this.dca = -1;
        this.dcb = -1;
        this.dcc = -1;
        this.dcd = false;
        this.dce = -1;
        this.dcf = -1;
        this.dch = -1;
        this.dcg = -1;
        this.dck = -1;
        this.dci = -1;
        this.dcj = -1;
        this.dcm = -1;
        this.dcn = -1;
        this.dco = -1;
        this.dcp = -1;
        this.dbL = -1;
        this.dbM = -1;
        this.dbN = -1;
        this.dbO = -1;
        this.dbR = -1;
        this.dbS = -1;
        this.dbT = -1;
        this.dbU = -1;
        this.dcq = 0;
        this.dcr = 0;
        this.dcs = -1;
        this.dbQ = -1;
        this.dbP = -1;
        this.dcv = false;
        this.dcu[0] = (short) -1;
        this.dcu[1] = (short) -1;
        this.dcw = -1;
        this.dcE = -1;
        this.dcF = -1;
        this.dcG = -1;
        this.dcH = -1;
        this.dbV = -1;
    }

    public final boolean yV() {
        if ((this.dbA < 0 || this.dbB >= 0) && ((this.dbA >= 0 || this.dbB < 0) && this.dbC <= 0)) {
            return false;
        }
        return true;
    }

    public final boolean yW() {
        return this.dbD >= 0;
    }

    public final boolean yX() {
        return this.dbE >= 0;
    }

    public final int yY() {
        if (!yW()) {
            return -1;
        }
        int i = (this.dbD & 224) >> 5;
        x.d("VoipAudioInfo", "getEnableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final boolean yZ() {
        if (!yW()) {
            return false;
        }
        boolean z;
        int i = this.dbD & 16;
        String str = "VoipAudioInfo";
        StringBuilder stringBuilder = new StringBuilder("enableSpeaker ");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        x.d(str, stringBuilder.append(z).toString());
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final int za() {
        if (!yW()) {
            return -1;
        }
        int i = (this.dbD & 14) >> 1;
        x.d("VoipAudioInfo", "getDisableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final boolean zb() {
        if (!yW()) {
            return false;
        }
        boolean z;
        int i = this.dbD & 1;
        String str = "VoipAudioInfo";
        StringBuilder stringBuilder = new StringBuilder("disableSpeaker ");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        x.d(str, stringBuilder.append(z).toString());
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final int zc() {
        if (!yX()) {
            return -1;
        }
        int i = (this.dbE & 224) >> 5;
        x.d("VoipAudioInfo", "getEnableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final int zd() {
        if (!yX()) {
            return -1;
        }
        int i = (this.dbE & 14) >> 1;
        x.d("VoipAudioInfo", "getDisableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final void dump() {
        x.d("VoipAudioInfo", "streamtype " + this.dbz);
        x.d("VoipAudioInfo", "smode " + this.dbA);
        x.d("VoipAudioInfo", "omode " + this.dbB);
        x.d("VoipAudioInfo", "ospeaker " + this.dbC);
        x.d("VoipAudioInfo", "operating" + this.dbD);
        x.d("VoipAudioInfo", "moperating" + this.dbE);
        x.d("VoipAudioInfo", "mstreamtype" + this.dbF);
        x.d("VoipAudioInfo", "mVoiceRecordMode" + this.dbG);
        x.d("VoipAudioInfo", "agcMode :" + this.dcl);
        x.d("VoipAudioInfo", "nsMode:" + this.dbJ);
        x.d("VoipAudioInfo", "aecMode:" + this.dbI);
        x.d("VoipAudioInfo", "volumMode:" + this.dbK);
        x.d("VoipAudioInfo", "micMode:" + this.dbW);
        x.d("VoipAudioInfo", "sourceMode:" + this.dbX);
        x.d("VoipAudioInfo", "speakerMode:" + this.dbY);
        x.d("VoipAudioInfo", "phoneMode:" + this.dbZ);
        x.d("VoipAudioInfo", "voipstreamType:" + this.dca);
        x.d("VoipAudioInfo", "speakerstreamtype:" + this.dcb);
        x.d("VoipAudioInfo", "phonestreamtype:" + this.dcc);
        x.d("VoipAudioInfo", "ringphonestream:" + this.dce);
        x.d("VoipAudioInfo", "ringphonemode:" + this.dcf);
        x.d("VoipAudioInfo", "ringspeakerstream:" + this.dcg);
        x.d("VoipAudioInfo", "ringspeakermode:" + this.dch);
        x.d("VoipAudioInfo", "agcModeNew :" + this.dck);
        x.d("VoipAudioInfo", "nsModeNew:" + this.dcj);
        x.d("VoipAudioInfo", "aecModeNew:" + this.dci);
        x.d("VoipAudioInfo", "agctargetdb:" + this.dcm);
        x.d("VoipAudioInfo", "agcgaindb:" + this.dcn);
        x.d("VoipAudioInfo", "agcflag:" + this.dco);
        x.d("VoipAudioInfo", "agclimiter:" + this.dcp);
        x.d("VoipAudioInfo", "inputVolumeScale:" + this.dbL);
        x.d("VoipAudioInfo", "outputVolumeScale:" + this.dbM);
        x.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.dbN);
        x.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.dbO);
        x.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.dbR);
        x.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.dbS);
        x.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.dbT);
        x.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.dbU);
        x.d("VoipAudioInfo", "enableRecTimer:" + this.dcq);
        x.d("VoipAudioInfo", "enablePlayTimer:" + this.dcr);
        x.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.dcs);
        x.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.dbP);
        x.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.dbQ);
        x.d("VoipAudioInfo", "noisegateon" + this.dcv);
        x.d("VoipAudioInfo", "noisegatestrength[0]" + this.dcu[0]);
        x.d("VoipAudioInfo", "noisegatestrength[1]" + this.dcu[1]);
        x.d("VoipAudioInfo", "spkecenable:" + this.dcw);
        x.d("VoipAudioInfo", "agcRxFlag:" + this.dcE);
        x.d("VoipAudioInfo", "agcRxTargetdb:" + this.dcF);
        x.d("VoipAudioInfo", "agcRxGaindb:" + this.dcG);
        x.d("VoipAudioInfo", "agcRxLimiter:" + this.dcH);
        x.d("VoipAudioInfo", "enableXnoiseSup:" + this.dbV);
    }
}
