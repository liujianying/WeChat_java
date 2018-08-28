package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static aqs JU() {
        try {
            g.Ek();
            String str = (String) g.Ei().DT().get(67591, null);
            if (str != null) {
                aqs aqs = new aqs();
                String[] split = str.split(",");
                aqs.ryV = Integer.valueOf(split[0]).intValue();
                aqs.ryY = Integer.valueOf(split[1]).intValue();
                aqs.rms = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                aqs.rmr = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                x.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[]{Float.valueOf(aqs.rms), Float.valueOf(aqs.rmr)});
                return aqs;
            }
            x.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            x.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
