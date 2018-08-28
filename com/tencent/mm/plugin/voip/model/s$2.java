package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.model.a.d;
import com.tencent.mm.sdk.platformtools.al.a;

class s$2 implements a {
    final /* synthetic */ s oNG;

    s$2(s sVar) {
        this.oNG = sVar;
    }

    public final boolean vD() {
        j jVar = this.oNG.oHa;
        jVar.oKf++;
        if (this.oNG.oHa.oJX.kpo == 0) {
            com.tencent.mm.plugin.voip.b.a.eT("MicroMsg.Voip.VoipServiceEx", g.Ac() + "double link switch roomId == 0 ");
            s.a(this.oNG).SO();
        } else {
            this.oNG.oHa.oJX.app2EngineDataEx(this.oNG.oHa.oJX.oPn, this.oNG.oHa.oJX.oPo, this.oNG.oHa.oJX.oPp, 0, 0);
            if (!this.oNG.oHa.oKe && 1 == this.oNG.oHa.oJX.field_mGetValidSample) {
                this.oNG.oHa.oKe = true;
                this.oNG.oHa.oKg = this.oNG.oHa.oKf;
            }
            if (1 == this.oNG.oHa.oJK) {
                this.oNG.oHa.oJK = 15;
            }
            if (true == this.oNG.oHa.oKe && this.oNG.oHa.oKf - this.oNG.oHa.oKg == this.oNG.oHa.oJK && (this.oNG.oHa.oJX.oPe & 1) == 0) {
                this.oNG.oHa.oKg = this.oNG.oHa.oKf;
                int isDCSameLan = this.oNG.oHa.oJX.isDCSameLan();
                int currentConnType = this.oNG.oHa.oJX.getCurrentConnType();
                if (1 == isDCSameLan && 1 == currentConnType) {
                    com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = " + isDCSameLan);
                    jVar = this.oNG.oHa;
                    jVar.oKf++;
                } else {
                    int i = this.oNG.oHa.oJX.getcurstrategy();
                    int isRelayConnReady = this.oNG.oHa.oJX.isRelayConnReady();
                    int isDCReady = this.oNG.oHa.oJX.isDCReady();
                    isDCSameLan = this.oNG.oHa.oJK - 3;
                    if (isDCSameLan > 15) {
                        isDCSameLan = 15;
                    }
                    this.oNG.oHa.oJX.app2EngineLinkQualityEx(isDCSameLan, s.b(this.oNG));
                    new d(this.oNG.oHa.oJX.kpo, this.oNG.oHa.oJX.kpp, this.oNG.oHa.oJX.kpw, currentConnType, isRelayConnReady, isDCReady, i, s.b(this.oNG), this.oNG.oHa.oJX.field_realLinkQualityInfoBuffLen).bLp();
                    v2protocal v2protocal = this.oNG.oHa.oJX;
                    v2protocal.oPg++;
                    com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + this.oNG.oHa.oJK + " isFirstValidSampleSet " + this.oNG.oHa.oKe + " mGetValidSample " + this.oNG.oHa.oJX.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + this.oNG.oHa.oJX.oPg + "mTimerCounter " + this.oNG.oHa.oKf + "mLastSwitchTimer " + this.oNG.oHa.oKg);
                }
            }
        }
        return true;
    }
}
