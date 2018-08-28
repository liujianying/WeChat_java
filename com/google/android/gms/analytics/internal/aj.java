package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.j;

public final class aj {
    public static a<Long> aHA = a.d("analytics.initial_local_dispatch_millis", 5000, 5000);
    public static a<Long> aHB = a.d("analytics.min_local_dispatch_millis", 120000, 120000);
    public static a<Long> aHC = a.d("analytics.max_local_dispatch_millis", 7200000, 7200000);
    public static a<Long> aHD = a.d("analytics.dispatch_alarm_millis", 7200000, 7200000);
    public static a<Long> aHE = a.d("analytics.max_dispatch_alarm_millis", 32400000, 32400000);
    public static a<Integer> aHF = a.c("analytics.max_hits_per_dispatch", 20, 20);
    public static a<Integer> aHG = a.c("analytics.max_hits_per_batch", 20, 20);
    public static a<String> aHH;
    public static a<String> aHI;
    public static a<String> aHJ;
    public static a<String> aHK;
    public static a<Integer> aHL = a.c("analytics.max_get_length", 2036, 2036);
    public static a<String> aHM = a.c("analytics.batching_strategy.k", x.aGV.name(), x.aGV.name());
    public static a<String> aHN;
    public static a<Integer> aHO = a.c("analytics.max_hits_per_request.k", 20, 20);
    public static a<Integer> aHP = a.c("analytics.max_hit_length.k", 8192, 8192);
    public static a<Integer> aHQ = a.c("analytics.max_post_length.k", 8192, 8192);
    public static a<Integer> aHR = a.c("analytics.max_batch_post_length", 8192, 8192);
    public static a<String> aHS;
    public static a<Integer> aHT = a.c("analytics.batch_retry_interval.seconds.k", 3600, 3600);
    public static a<Long> aHU = a.d("analytics.service_monitor_interval", 86400000, 86400000);
    public static a<Integer> aHV = a.c("analytics.http_connection.connect_timeout_millis", 60000, 60000);
    public static a<Integer> aHW = a.c("analytics.http_connection.read_timeout_millis", 61000, 61000);
    public static a<Long> aHX = a.d("analytics.campaigns.time_limit", 86400000, 86400000);
    public static a<String> aHY;
    public static a<Integer> aHZ = a.c("analytics.first_party_experiment_variant", 0, 0);
    public static a<Boolean> aHr = a.h("analytics.service_enabled", false);
    public static a<Boolean> aHs = a.h("analytics.service_client_enabled", true);
    public static a<String> aHt = a.c("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static a<Long> aHu = a.d("analytics.max_tokens", 60, 60);
    public static a<Float> aHv = new a(j.a("analytics.tokens_per_sec", Float.valueOf(0.5f)), Float.valueOf(0.5f));
    public static a<Integer> aHw = a.c("analytics.max_stored_hits", 2000, 20000);
    public static a<Integer> aHx = a.c("analytics.max_stored_hits_per_app", 2000, 2000);
    public static a<Integer> aHy = a.c("analytics.max_stored_properties_per_app", 100, 100);
    public static a<Long> aHz = a.d("analytics.local_dispatch_millis", 1800000, 120000);
    public static a<Boolean> aIa = a.h("analytics.test.disable_receiver", false);
    public static a<Long> aIb = a.d("analytics.service_client.idle_disconnect_millis", 10000, 10000);
    public static a<Long> aIc = a.d("analytics.service_client.connect_timeout_millis", 5000, 5000);
    public static a<Long> aId = a.d("analytics.service_client.second_connect_delay_millis", 5000, 5000);
    public static a<Long> aIe = a.d("analytics.service_client.unexpected_reconnect_millis", 60000, 60000);
    public static a<Long> aIf = a.d("analytics.service_client.reconnect_throttle_millis", 1800000, 1800000);
    public static a<Long> aIg = a.d("analytics.monitoring.sample_period_millis", 86400000, 86400000);
    public static a<Long> aIh = a.d("analytics.initialization_warning_threshold", 5000, 5000);

    static {
        String str = "http://www.google-analytics.com";
        aHH = a.c("analytics.insecure_host", str, str);
        str = "https://ssl.google-analytics.com";
        aHI = a.c("analytics.secure_host", str, str);
        str = "/collect";
        aHJ = a.c("analytics.simple_endpoint", str, str);
        str = "/batch";
        aHK = a.c("analytics.batching_endpoint", str, str);
        str = z.aHb.name();
        aHN = a.c("analytics.compression_strategy.k", str, str);
        str = "404,502";
        aHS = a.c("analytics.fallback_responses.k", str, str);
        str = "";
        aHY = a.c("analytics.first_party_experiment_id", str, str);
    }
}
