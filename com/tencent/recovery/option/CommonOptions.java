package com.tencent.recovery.option;

public class CommonOptions {
    public String clientVersion;
    public String fMk;
    public String vhA;
    private boolean vhB;
    public long vhC;
    public long vhD;
    public String vhv;
    public String vhz;

    public static final class Builder {
        public String clientVersion;
        public String fMk;
        public String vhA;
        public boolean vhB;
        public long vhC;
        public long vhD;
        public String vhv;
        public String vhz;

        public final CommonOptions cEZ() {
            CommonOptions commonOptions = new CommonOptions();
            commonOptions.vhz = this.vhz;
            commonOptions.vhA = this.vhA;
            commonOptions.clientVersion = this.clientVersion;
            commonOptions.vhv = this.vhv;
            commonOptions.fMk = this.fMk;
            commonOptions.vhB = this.vhB;
            commonOptions.vhC = this.vhC;
            commonOptions.vhD = this.vhD;
            return commonOptions;
        }
    }

    /* synthetic */ CommonOptions(byte b) {
        this();
    }

    private CommonOptions() {
    }
}
