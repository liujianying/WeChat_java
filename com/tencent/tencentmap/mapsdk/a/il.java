package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.map.lib.d;
import com.tencent.map.lib.mapstructure.TrafficRequestItem;
import com.tencent.smtt.utils.TbsLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class il extends Thread {
    private hv a = null;
    private boolean b = false;
    private boolean c = false;
    private int d = 30000;
    private long e = -1;
    private List<Object> f;
    private jg g = null;
    private boolean h = true;

    private class a {
        public int a;
        public int b;

        private a() {
        }
    }

    public il(hv hvVar, jg jgVar) {
        this.a = hvVar;
        this.g = jgVar;
        this.f = new ArrayList();
    }

    public void run() {
        super.run();
        while (!this.c) {
            if (!this.b) {
                if (this.a != null) {
                    d();
                    this.a.x();
                } else {
                    return;
                }
            }
            try {
                synchronized (this) {
                    if (this.h) {
                        wait(500);
                        this.h = false;
                    } else {
                        wait(30000);
                    }
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void a() {
        this.b = true;
        synchronized (this) {
            notify();
        }
    }

    public void b() {
        this.b = false;
        synchronized (this) {
            notify();
        }
    }

    public void c() {
        this.c = true;
        synchronized (this) {
            notify();
        }
        interrupt();
    }

    private void d() {
        if (this.a != null) {
            d.a("link_traffic.txt", "\n\n触发刷新路况， 时间是 : " + i() + "=============================");
            f();
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.e;
            d.a("link_traffic.txt", "当前等待时间：" + elapsedRealtime + "   服务器返回刷新间隔: " + this.d);
            if (this.e < 0 || elapsedRealtime >= ((long) this.d)) {
                e();
            } else {
                d.a("link_traffic.txt", "无需刷新全国路况");
            }
        }
    }

    private void e() {
        try {
            String h = h();
            if (h != null && h.length() != 0) {
                d.a("link_traffic.txt", "发起全国路况请求  请求时间: " + i() + "  请求结构: " + h);
                byte[] a = a(h);
                if (a == null || a.length <= 0) {
                    d.a("link_traffic.txt", "全国路况返回, 但结果为空");
                    return;
                }
                d.a("link_traffic.txt", "全国路况返回, 大小是： " + a.length + " 返回时间： " + i());
                this.d = this.a.i().a(a, a.length, true, true);
                this.d *= TbsLog.TBSLOG_CODE_SDK_BASE;
                this.e = SystemClock.elapsedRealtime();
                d.a("link_traffic.txt", "全国路况刷新完成， 时间是:  " + i());
            }
        } catch (Exception e) {
        }
    }

    private void f() {
        String g = g();
        if (g == null || g.length() == 0) {
            d.a("link_traffic.txt", "无需刷新城市路况");
            return;
        }
        try {
            d.a("link_traffic.txt", "发起城市路况请求  请求时间: " + i() + "  请求结构: " + g);
            byte[] a = a(g);
            if (a == null || a.length <= 0) {
                d.a("link_traffic.txt", "城市路况返回, 但结果为空");
                return;
            }
            d.a("link_traffic.txt", "城市路况返回, 大小是： " + a.length + " 返回时间： " + i());
            this.a.i().a(a, a.length, true, false);
            d.a("link_traffic.txt", "城市路况刷新完成， 时间是:  " + i());
        } catch (Exception e) {
        }
    }

    private byte[] a(String str) {
        if (this.g == null) {
            return null;
        }
        return this.g.a(str);
    }

    private String g() {
        if (this.a == null) {
            return null;
        }
        int m = this.a.a().m();
        Rect y = this.a.a().y();
        double d = (double) (((float) y.right) / 1000000.0f);
        double d2 = (double) (((float) y.top) / 1000000.0f);
        a a = a((double) (((float) y.left) / 1000000.0f), (double) (((float) y.bottom) / 1000000.0f));
        a a2 = a(d, d2);
        this.a.i().a(m, Math.min(a.a, a2.a), Math.min(a.b, a2.b), Math.max(a2.a, a.a), Math.max(a2.b, a.b));
        TrafficRequestItem[] h = this.a.i().h();
        return h != null ? a(h) : null;
    }

    private String a(TrafficRequestItem[] trafficRequestItemArr) {
        if (trafficRequestItemArr == null || trafficRequestItemArr.length == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", "traffic");
            jSONObject.put("level", trafficRequestItemArr[0].level);
            JSONArray jSONArray = new JSONArray();
            for (TrafficRequestItem trafficRequestItem : trafficRequestItemArr) {
                if (trafficRequestItem != null) {
                    jSONArray.put(trafficRequestItem.minLat);
                    jSONArray.put(trafficRequestItem.minLon);
                    jSONArray.put(trafficRequestItem.maxLat);
                    jSONArray.put(trafficRequestItem.maxLon);
                }
            }
            jSONObject.put("boundArray", jSONArray);
            jSONObject.put("zip", 0);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    private String h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", "traffic");
            jSONObject.put("level", 4);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < 4; i++) {
                jSONArray.put(0);
            }
            jSONObject.put("boundArray", jSONArray);
            jSONObject.put("zip", 0);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    private a a(double d, double d2) {
        double d3 = ((180.0d + d) / 360.0d) * 2.68435456E8d;
        double sin = Math.sin((3.1415926d * d2) / 180.0d);
        sin = ((180.0d - ((Math.log((1.0d + sin) / (1.0d - sin)) * 180.0d) / 6.2831852d)) / 360.0d) * 2.68435456E8d;
        a aVar = new a();
        aVar.a = (int) (d3 + 0.5d);
        aVar.b = (int) (0.5d + sin);
        return aVar;
    }

    private String i() {
        return new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }
}
