package org.onjava8.teninterface;

import java.util.Random;

public interface RandVals {
    Random random = new Random(23);
    int INT = random.nextInt(10);
}
