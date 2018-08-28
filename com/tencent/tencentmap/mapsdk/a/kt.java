package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.util.StringUtil;

public class kt {
    private static boolean a = false;

    public static void a(Context context) {
        if (context != null) {
            String h = o.a(context).h();
            r a = r.a(context);
            if (a(a) || a) {
                p.b(context, h, "mapconfig.dat", "mapconfig.dat");
                p.b(context, h, "poi_icon_file.png", "poi_icon.png");
                p.b(context, h, "poi_icon_file_nav.png", "poi_icon_navi.png");
                p.b(context, h, "poi_icon_file_dark.png", "poi_icon_dark.png");
                p.b(context, h, "poi_icon_file_sat.png", "poi_icon_sat.png");
                p.b(context, h, "rtt_config.json", "rtt_config.json");
                p.b(context, h, "indoormap_config.dat", "indoormap_config.dat");
                p.b(context, h, "poi_icon_file_indoor.png", "indoor_icon.png");
                p.b(context, h, "style_normalmode.xml", "closedroadstyle_normalmode.xml");
                p.b(context, h, "style_trafficmode.xml", "closedroadstyle_trafficmode.xml");
                p.b(context, h, "blockicon.png", "blockicon.png");
                a.a("4.0.8.1");
                return;
            }
            p.a(context, h, "mapconfig.dat", "mapconfig.dat");
            p.a(context, h, "poi_icon_file.png", "poi_icon.png");
            p.a(context, h, "poi_icon_file_nav.png", "poi_icon_navi.png");
            p.a(context, h, "poi_icon_file_dark.png", "poi_icon_dark.png");
            p.a(context, h, "poi_icon_file_sat.png", "poi_icon_sat.png");
            p.a(context, h, "rtt_config.json", "rtt_config.json");
            p.a(context, h, "indoormap_config.dat", "indoormap_config.dat");
            p.a(context, h, "poi_icon_file_indoor.png", "indoor_icon.png");
            p.a(context, h, "style_normalmode.xml", "closedroadstyle_normalmode.xml");
            p.a(context, h, "style_trafficmode.xml", "closedroadstyle_trafficmode.xml");
            p.a(context, h, "blockicon.png", "blockicon.png");
        }
    }

    private static boolean a(r rVar) {
        String str = "4.0.8.1";
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        String e = rVar.e();
        if (StringUtil.isEmpty(e)) {
            return true;
        }
        if (str.compareToIgnoreCase(e) > 0) {
            return true;
        }
        return false;
    }
}
