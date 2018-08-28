package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.protocal.c.api;
import com.tencent.mm.protocal.c.caf;
import com.tencent.mm.protocal.c.cak;
import com.tencent.mm.sdk.platformtools.x;

class t$1 implements Runnable {
    final /* synthetic */ cak oNL;
    final /* synthetic */ t oNM;

    t$1(t tVar, cak cak) {
        this.oNM = tVar;
        this.oNL = cak;
    }

    public final void run() {
        a.eU("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
        try {
            caf caf = (caf) new caf().aG(this.oNL.rfy.siK.toByteArray());
            if (!(caf.suK == null || caf.suK.rfy == null || caf.suK.rfy.siK == null)) {
                this.oNM.oNI.suK = caf.suK;
            }
            if (!(caf.suL.rfy == null || caf.suL.rfy.siK == null)) {
                this.oNM.oNI.suL = caf.suL;
            }
            if (caf.swb != 0) {
                this.oNM.oNI.swb = caf.swb;
            }
            if (!(caf.swc == null || caf.swc.suW == 0)) {
                this.oNM.oNI.swc = caf.swc;
            }
            if (!(caf.swd == null || caf.swd.suW == 0)) {
                this.oNM.oNI.swd = caf.swd;
            }
            if (caf.swf != 0) {
                this.oNM.oNI.swf = caf.swf;
            }
            if (caf.swg != 0) {
                this.oNM.oNI.swg = caf.swg;
            }
            if (caf.swk.suW != 0) {
                this.oNM.oNI.swk = caf.swk;
            }
            if (caf.swl > 0) {
                this.oNM.oNI.swl = caf.swl;
            } else {
                this.oNM.oNI.swl = 0;
                a.eU("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
            }
            if (caf.kpK > 0) {
                this.oNM.oNI.kpK = caf.kpK - 1;
                a.eU("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + this.oNM.oNI.kpK + "] from relaydata");
            } else {
                this.oNM.oNI.kpK = 1;
                a.eU("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
            }
            if (caf.swm > 0) {
                this.oNM.oNI.swm = caf.swm;
                this.oNM.oNI.swn = caf.swn;
                this.oNM.oNI.swo = caf.swo;
                this.oNM.oNI.swp = caf.swp;
                a.eU("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + caf.swm + ", ARQRttThreshold: " + caf.swn + ", ARQUsedRateThreshold: " + caf.swo + ", ARQRespRateThreshold: " + caf.swp);
            } else {
                a.eU("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
            }
            if (caf.swt > 0) {
                this.oNM.oNI.swt = caf.swt;
            } else {
                this.oNM.oNI.swt = 0;
                a.eU("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
            }
            this.oNM.oNI.sww = caf.sww;
            if (caf.swy != null) {
                this.oNM.oNI.swy = caf.swy;
            }
            int i = (this.oNM.oNI.suK == null || this.oNM.oNI.suK.rfy == null || this.oNM.oNI.suK.rfy.siK == null || this.oNM.oNI.swb == 0 || this.oNM.oNI.suL == null || this.oNM.oNI.suL.rfy == null || this.oNM.oNI.suL.rfy.siK == null || this.oNM.oNI.swc == null || this.oNM.oNI.swc.suW == 0 || this.oNM.oNI.swd == null || this.oNM.oNI.swd.suW == 0 || this.oNM.oNI.swk == null || this.oNM.oNI.swk.suW == 0) ? 0 : 1;
            if (i == 0) {
                a.eU("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                return;
            }
            a.eU("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + this.oNM.oNI.sww + " BothSideSwitchFlag = " + caf.swx);
            this.oNM.oHa.yA(this.oNM.oNI.swb);
            this.oNM.oHa.aQ(this.oNM.oNI.suK.rfy.siK.toByteArray());
            if (!(caf.swi == null || caf.swi.siK == null || caf.swu == null || caf.swu.siK == null)) {
                this.oNM.oHa.a(caf.swi.siK.toByteArray(), caf.swh, this.oNM.oNI.kpK, caf.swu.siK.toByteArray());
            }
            if (i.bJI().bKS() != 0) {
                this.oNM.oHa.aR(this.oNM.oNI.suL.rfy.siK.toByteArray());
            }
            this.oNM.oHa.a(this.oNM.oNI.swc, this.oNM.oNI.swd, this.oNM.oNI.swk);
            this.oNM.oHa.h(this.oNM.oNI.swl, this.oNM.oNI.swm, this.oNM.oNI.swn, this.oNM.oNI.swo, this.oNM.oNI.swp);
            this.oNM.oHa.yz(this.oNM.oNI.swt);
            j jVar = this.oNM.oHa;
            int i2 = this.oNM.oNI.swf;
            int i3 = this.oNM.oNI.swg;
            jVar.oJX.oOr = i2;
            jVar.oJX.oOs = i3;
            this.oNM.oHa.yy(this.oNM.oNI.sww);
            this.oNM.oHa.oJX.oPm = caf.swx;
            if (!(caf.swr == null || caf.swr.siK == null || caf.sws == null || caf.sws.siK == null)) {
                this.oNM.oHa.b(caf.swq, caf.swr.siK.toByteArray(), caf.sws.siK.toByteArray());
            }
            jVar = this.oNM.oHa;
            api api = this.oNM.oNI.swy;
            v2protocal v2protocal = jVar.oJX;
            a.eV("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + api.rRr + " Bitrate: " + api.rRs);
            v2protocal.field_jbmParamArraySize = 27;
            v2protocal.field_jbmBitratRsSvrParamArray = new int[v2protocal.field_jbmParamArraySize];
            v2protocal.field_jbmBitratRsSvrParamArray[0] = api.rRq;
            v2protocal.field_jbmBitratRsSvrParamArray[1] = api.rRr;
            v2protocal.field_jbmBitratRsSvrParamArray[2] = api.rRs;
            v2protocal.field_jbmBitratRsSvrParamArray[3] = api.rRt;
            v2protocal.field_jbmBitratRsSvrParamArray[4] = api.rRu;
            v2protocal.field_jbmBitratRsSvrParamArray[5] = api.rRv;
            v2protocal.field_jbmBitratRsSvrParamArray[6] = api.rRw;
            v2protocal.field_jbmBitratRsSvrParamArray[7] = api.rRz;
            v2protocal.field_jbmBitratRsSvrParamArray[8] = api.rRA;
            v2protocal.field_jbmBitratRsSvrParamArray[9] = api.rRD;
            v2protocal.field_jbmBitratRsSvrParamArray[10] = api.rRE;
            v2protocal.field_jbmBitratRsSvrParamArray[11] = api.rRH;
            v2protocal.field_jbmBitratRsSvrParamArray[12] = api.rRI;
            v2protocal.field_jbmBitratRsSvrParamArray[13] = api.rRL;
            v2protocal.field_jbmBitratRsSvrParamArray[14] = api.rRM;
            v2protocal.field_jbmBitratRsSvrParamArray[15] = api.rRP;
            v2protocal.field_jbmBitratRsSvrParamArray[16] = api.rRQ;
            v2protocal.field_jbmBitratRsSvrParamArray[17] = api.rRT;
            v2protocal.field_jbmBitratRsSvrParamArray[18] = api.rRU;
            v2protocal.field_jbmBitratRsSvrParamArray[19] = api.rRX;
            v2protocal.field_jbmBitratRsSvrParamArray[20] = api.rRY;
            v2protocal.field_jbmBitratRsSvrParamArray[21] = api.rSb;
            v2protocal.field_jbmBitratRsSvrParamArray[22] = api.rSc;
            v2protocal.field_jbmBitratRsSvrParamArray[23] = api.rSf;
            v2protocal.field_jbmBitratRsSvrParamArray[24] = api.rSg;
            v2protocal.field_jbmBitratRsSvrParamArray[25] = api.rSj;
            v2protocal.field_jbmBitratRsSvrParamArray[26] = api.rSk;
            v2protocal.field_jbmParamDoubleArraySize = 20;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray = new double[v2protocal.field_jbmParamDoubleArraySize];
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[0] = api.rRx;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[1] = api.rRy;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[2] = api.rRB;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[3] = api.rRC;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[4] = api.rRF;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[5] = api.rRG;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[6] = api.rRJ;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[7] = api.rRK;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[8] = api.rRN;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[9] = api.rRO;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[10] = api.rRR;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[11] = api.rRS;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[12] = api.rRV;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[13] = api.rRW;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[14] = api.rRZ;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[15] = api.rSa;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[16] = api.rSd;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[17] = api.rSe;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[18] = api.rSh;
            v2protocal.field_jbmBitratRsSvrParamDoubleArray[19] = api.rSi;
            this.oNM.oHa.bJZ();
            a.eU("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
        }
    }
}
