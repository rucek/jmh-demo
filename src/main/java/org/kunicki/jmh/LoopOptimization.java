package org.kunicki.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class LoopOptimization {

    @Param({"10", "10000", "10000000"})
    private int n;

    @Benchmark
    public int loop() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum++;
        }
        return sum;
    }
}

/*
[info] Benchmark                   (n)   Mode  Cnt          Score          Error  Units
[info] LoopOptimization.loop        10  thrpt   25  444228023.723 ± 15100089.273  ops/s
[info] LoopOptimization.loop     10000  thrpt   25  425875878.680 ± 25189236.850  ops/s
[info] LoopOptimization.loop  10000000  thrpt   25  332413144.898 ± 27033380.915  ops/s
 */
