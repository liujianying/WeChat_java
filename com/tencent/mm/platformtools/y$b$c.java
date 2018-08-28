package com.tencent.mm.platformtools;

class y$b$c {
    boolean ewm;
    int ewn;
    int ewo;

    y$b$c() {
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fail[").append(this.ewm).append("],");
        stringBuilder.append("tryTimes[").append(this.ewn).append("],");
        stringBuilder.append("lastTS[").append(this.ewo).append("]");
        return stringBuilder.toString();
    }
}
