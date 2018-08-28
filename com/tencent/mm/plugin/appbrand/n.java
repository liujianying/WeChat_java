package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public enum n {
    ;

    public static String qx(String str) {
        return String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=overseas#wechat_redirect", new Object[]{str});
    }

    public static String a(WxaExposedParams wxaExposedParams) {
        String str = "";
        if (wxaExposedParams == null || bi.oW(wxaExposedParams.appId)) {
            x.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl fail, null or nil appId");
            return str;
        }
        try {
            return String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{wxaExposedParams.appId, p.encode(bi.oV(wxaExposedParams.bVs), "UTF-8"), Integer.valueOf(wxaExposedParams.bJu), Integer.valueOf(bi.p(Integer.valueOf(wxaExposedParams.fih), -1)), Integer.valueOf(bi.p(Integer.valueOf(wxaExposedParams.fii), -1))});
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl encode fail, invalid arguments");
            return str;
        }
    }

    public static String qy(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.AppBrandUrlBuilders", "buildEntityUrl fail, null or nil appId");
            return "";
        }
        return String.format("https://mp.weixin.qq.com/mp/waverifyinfo?action=get&appid=%s#wechat_redirect", new Object[]{str});
    }

    public static String qz(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.AppBrandUrlBuilders", "buildLowVersionUrl fail, invalid arguments");
            return "";
        }
        return String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect", new Object[]{str, Integer.valueOf(3)});
    }
}
