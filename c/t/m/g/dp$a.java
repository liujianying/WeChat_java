package c.t.m.g;

public enum dp$a {
    NONE,
    GSM,
    CDMA,
    WCDMA,
    LTE;

    static {
        NONE = new dp$a("NONE", 0);
        GSM = new dp$a("GSM", 1);
        CDMA = new dp$a("CDMA", 2);
        WCDMA = new dp$a("WCDMA", 3);
        LTE = new dp$a("LTE", 4);
        dp$a[] dp_aArr = new dp$a[]{NONE, GSM, CDMA, WCDMA, LTE};
    }
}
