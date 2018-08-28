package com.tencent.recovery.option;

import com.tencent.recovery.config.Express;

public class ProcessOptions {
    public int dkb;
    private Express vhF;

    public static final class Builder {
        private int dkb;
        public Express vhF;

        public final Builder cFa() {
            this.dkb = 10000;
            return this;
        }

        public final ProcessOptions cFb() {
            ProcessOptions processOptions = new ProcessOptions();
            processOptions.dkb = this.dkb;
            processOptions.vhF = this.vhF;
            return processOptions;
        }
    }
}
