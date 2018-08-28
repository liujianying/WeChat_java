package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.plugin.v.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.bn;
import com.tencent.mm.ui.base.s;

public final class j {
    static int iNj;
    static double lgA;
    public static boolean lgw = true;
    private static boolean lgx = false;
    private static boolean lgy = false;
    public static o lgz;

    public static boolean f(Point point) {
        if (lgx) {
            String str;
            Context context = ad.getContext();
            Resources resources = ad.getResources();
            int i = a.i_want_you_know;
            Object[] objArr = new Object[1];
            if (lgz == null) {
                str = "";
            } else {
                str = Integer.valueOf(lgz.lgI);
            }
            objArr[0] = str;
            s.makeText(context, resources.getString(i, objArr), 1).show();
            return false;
        }
        x.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", new Object[]{Integer.valueOf(q.deT.dfb), Integer.valueOf(q.deT.dfi), Boolean.valueOf(lgy)});
        if (lgy) {
            return false;
        }
        if (q.deT.dfb != -1) {
            return true;
        }
        if (lgz != null && 1 == lgz.dfb) {
            return true;
        }
        if (point == null) {
            return false;
        }
        if (d.sL(point.x) && d.sL(point.y)) {
            return true;
        }
        if (lgz != null) {
            x.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[]{point.toString()});
            lgz.dfb = 1;
        }
        return false;
    }

    public static void a(Parameters parameters, boolean z) {
        if (lgx) {
            String str;
            Context context = ad.getContext();
            Resources resources = ad.getResources();
            int i = a.i_want_you_know;
            Object[] objArr = new Object[1];
            if (lgz == null) {
                str = "";
            } else {
                str = Integer.valueOf(lgz.lgI);
            }
            objArr[0] = str;
            s.makeText(context, resources.getString(i, objArr), 1).show();
            return;
        }
        x.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", new Object[]{Integer.valueOf(q.deT.dfi), Boolean.valueOf(lgy)});
        if (!lgy) {
            boolean z2;
            o oVar;
            Point bdF = d.bdF();
            int i2 = bi.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
            x.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(bi.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19)), Integer.valueOf(bi.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19))});
            if (q.deT.dfh == -1 || (q.deT.dfh & 1) != 0) {
                if (q.deT.dfh != -1 && (q.deT.dfh & 1) != 0) {
                    lgz.bea().lgK = true;
                    z2 = true;
                    if (q.deT.dfc != -1) {
                        lgz.lgJ = false;
                    } else {
                        lgz.lgJ = q.deT.dfc == 1;
                    }
                    if (q.deT.dfh == -1) {
                    }
                    oVar = lgz;
                    oVar.lgN = g.a(parameters, d.bdF(), 720, z);
                    if (oVar.lgN != null) {
                    }
                    z2 = false;
                    if (z2) {
                        lgz.bdY().lgK = true;
                    }
                    lgz.lgI = -1;
                    x.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[]{lgz.toString()});
                } else if (com.tencent.mm.compatible.util.d.fR(r3) && iNj >= 512 && lgA >= 1725.0d && Math.min(bdF.x, bdF.y) >= 1080) {
                    oVar = lgz;
                    oVar.lgN = g.a(parameters, d.bdF(), oVar.lem.width * 2, z);
                    if (oVar.lgN == null || oVar.lgN.lgn == null) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        lgz.bea().lgK = true;
                        z2 = true;
                        if (q.deT.dfc != -1) {
                            lgz.lgJ = q.deT.dfc == 1;
                        } else {
                            lgz.lgJ = false;
                        }
                        if (q.deT.dfh == -1 || (q.deT.dfh & 2) != 0) {
                            if (q.deT.dfh == -1 && (q.deT.dfh & 2) != 0) {
                                oVar = lgz.bdY();
                                oVar.lgK = false;
                                oVar.bdZ();
                            } else if (!z2 && com.tencent.mm.compatible.util.d.fR(r5) && iNj >= 512 && lgA >= 1725.0d && Math.min(bdF.x, bdF.y) >= 720) {
                                oVar = lgz;
                                oVar.lgN = g.a(parameters, d.bdF(), 720, z);
                                if (oVar.lgN != null || oVar.lgN.lgn == null) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    lgz.bdY().lgK = true;
                                }
                            }
                        }
                        lgz.lgI = -1;
                        x.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[]{lgz.toString()});
                    }
                }
            }
            z2 = false;
            if (q.deT.dfc != -1) {
                lgz.lgJ = q.deT.dfc == 1;
            } else {
                lgz.lgJ = false;
            }
            if (q.deT.dfh == -1) {
            }
            oVar = lgz;
            oVar.lgN = g.a(parameters, d.bdF(), 720, z);
            if (oVar.lgN != null) {
            }
            z2 = false;
            if (z2) {
                lgz.bdY().lgK = true;
            }
            lgz.lgI = -1;
            x.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[]{lgz.toString()});
        }
    }

    public static void c(VideoTransPara videoTransPara) {
        int i;
        int i2;
        boolean z = true;
        lgx = false;
        lgy = false;
        iNj = ((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass();
        lgA = (double) d.dP(ad.getContext());
        String cmZ = bn.cmZ();
        x.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", new Object[]{Integer.valueOf(bi.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19))});
        if (CaptureMMProxy.getInstance() != null) {
            q.fd(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        }
        x.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[]{Integer.valueOf(iNj), Double.valueOf(lgA), cmZ, q.deT});
        if (CaptureMMProxy.getInstance() != null) {
            i = CaptureMMProxy.getInstance().getInt(aa.a.sUE, -1);
            i2 = CaptureMMProxy.getInstance().getInt(aa.a.sUH, 1);
        } else {
            i2 = 1;
            i = -1;
        }
        o a = o.a(i, videoTransPara);
        lgz = a;
        int i3;
        if (a != null) {
            if (i2 == 1) {
                lgz.lgL = true;
            } else {
                lgz.lgL = false;
            }
            lgx = true;
            Context context = ad.getContext();
            Resources resources = ad.getResources();
            i3 = a.i_want_you_know;
            Object[] objArr = new Object[1];
            if (lgz == null) {
                cmZ = "";
            } else {
                cmZ = Integer.valueOf(lgz.lgI);
            }
            objArr[0] = cmZ;
            s.makeText(context, resources.getString(i3, objArr), 1).show();
            return;
        }
        i = q.deT.dfi;
        x.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", new Object[]{Integer.valueOf(i)});
        if (i != -1) {
            lgz = o.a(i, videoTransPara);
        }
        if (lgz != null) {
            if (i2 == 1) {
                lgz.lgL = true;
            } else {
                lgz.lgL = false;
            }
            lgy = true;
            return;
        }
        lgz = o.a(1, videoTransPara);
        if (i2 == 1) {
            lgz.lgL = true;
        } else {
            lgz.lgL = false;
        }
        if (q.deT.dfb != -1) {
            lgz.dfb = q.deT.dfb;
        } else if (com.tencent.mm.compatible.util.d.fR(i3)) {
            lgz.dfb = 2;
        } else {
            lgz.dfb = 1;
        }
        if (q.deT.dfe != -1) {
            boolean z2;
            if (q.deT.dfe == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            lgw = z2;
        }
        if (q.deT.dfc != -1) {
            o oVar = lgz;
            if (q.deT.dfc != 1) {
                z = false;
            }
            oVar.lgJ = z;
            return;
        }
        lgz.lgJ = false;
    }

    public static void a(b bVar) {
        if (bVar.lgn == null) {
            x.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[]{bVar.toString()});
            bVar.lgn = bVar.lgq;
            bVar.lgo = bVar.lgr;
            bVar.lgp = bVar.lgs;
            if (Math.min(bVar.lgo.y, bVar.lgo.x) >= lgz.lem.width + 16) {
                lgz.bdZ();
                lgz.lgK = false;
                lgz.lgJ = false;
                x.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[]{bVar.toString()});
            }
        }
    }

    public static void bdS() {
        x.i("MicroMsg.MMSightRecorderConfig", "initSimple");
        o oVar = new o();
        lgz = oVar;
        oVar.lgJ = false;
        lgz.lgK = false;
        if (com.tencent.mm.compatible.util.d.fR(19)) {
            lgz.dfb = 2;
        } else {
            lgz.dfb = 1;
        }
    }
}
