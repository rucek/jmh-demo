package org.kunicki.jmh

import org.openjdk.jmh.annotations.{Benchmark, Scope, State}

@State(Scope.Thread)
class ConstantFolding {

  private var n = 42

  @Benchmark
  def folded1(): Double = Math.log(42)

  @Benchmark
  def folded2(): Double = 3.7376696182833684

  @Benchmark
  def unfolded(): Double = Math.log(n)
}

/*
[info] Benchmark                  Mode  Cnt          Score          Error  Units
[info] ConstantFolding.folded1   thrpt   25  465522457.377 ± 19444540.362  ops/s
[info] ConstantFolding.folded2   thrpt   25  476369005.909 ± 11844040.366  ops/s
[info] ConstantFolding.unfolded  thrpt   25   38623249.554 ±  1324174.801  ops/s
 */
