package com.tencent.mm.pluginsdk.g.a.a;

enum i$a {
    ENCRYPTION(1),
    COMPRESSION(2);
    
    final int bWA;

    private i$a(int i) {
        this.bWA = i;
    }

    static boolean BL(int i) {
        return (ENCRYPTION.bWA & i) > 0;
    }

    static boolean BM(int i) {
        return (COMPRESSION.bWA & i) > 0;
    }

    static int ccu() {
        return ENCRYPTION.bWA | 0;
    }

    static int BN(int i) {
        return COMPRESSION.bWA | i;
    }
}
