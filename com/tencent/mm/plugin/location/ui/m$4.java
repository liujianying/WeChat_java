package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.model.q;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.protocal.c.bbe;
import com.tencent.mm.protocal.c.bxg;
import com.tencent.mm.sdk.platformtools.x;

class m$4 implements a {
    final /* synthetic */ m kHj;

    m$4(m mVar) {
        this.kHj = mVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        m mVar = this.kHj;
        double d4 = (double) f2;
        double d5 = (double) f;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[refreshMyLocation] ");
        stringBuffer.append(String.format("latitude = %f, longtitude = %f", new Object[]{Double.valueOf(d4), Double.valueOf(d5)}));
        if (mVar.kDI == null) {
            mVar.kDI = new bxg();
            mVar.kDI.stK = new bbe();
            mVar.kDI.rdS = q.GF();
            mVar.kDI.stK.rjj = d4;
            mVar.kDI.stK.rji = d5;
            if (mVar.kEI && mVar.kGU) {
                mVar.aZQ();
            }
        }
        mVar.kDI.stK.rjj = d4;
        mVar.kDI.stK.rji = d5;
        Object viewByItag = mVar.kEH.getViewByItag(mVar.kDI.rdS);
        if (viewByItag != null) {
            stringBuffer.append("[ view is not null hasCode: " + viewByItag.hashCode() + " ] ");
        } else {
            TrackPoint trackPoint = new TrackPoint(mVar.mContext, (ViewManager) mVar.kEH.getViewManager(), d.location_track_point_icon_myself);
            mVar.kEH.addView(trackPoint, 0.0d, 0.0d, mVar.kDI.rdS);
            trackPoint.o(d4, d5);
            if (mVar.kGZ) {
                trackPoint.setOnAvatarOnClickListener(null);
                trackPoint.setOnLocationOnClickListener(null);
                trackPoint.ban();
            } else {
                trackPoint.setOnAvatarOnClickListener(mVar.kHh);
                trackPoint.setOnLocationOnClickListener(mVar.kHg);
            }
            trackPoint.setAvatar(mVar.kDI.rdS);
            stringBuffer.append("[view is null new one: " + trackPoint.hashCode() + " ] ");
            mVar.kGT = new TrackPointAnimAvatar(mVar.mContext);
            TrackPoint viewByItag2 = trackPoint;
        }
        x.d("MicroMsg.TrackPointViewMgrImpl", stringBuffer.toString());
        if (viewByItag2 instanceof TrackPoint) {
            mVar.kGS = (TrackPoint) viewByItag2;
            x.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
            mVar.kGS.n(d4, d5);
        }
        if (mVar.kHb) {
            mVar.kEH.getIController().setCenter(mVar.kDI.stK.rjj, mVar.kDI.stK.rji);
        }
        return true;
    }
}
