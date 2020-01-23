package org.kunicki.jmh

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole

class DeadCode {

  @Benchmark
  def dead(): Unit = {
    val a = 1
    val b = 2
    a + b
  }

  @Benchmark
  def returnValue(): Int = {
    val a = 1
    val b = 2
    a + b
  }

  @Benchmark
  def consume(blackhole: Blackhole): Unit = {
    val a = 1
    val b = 2
    blackhole.consume(a + b)
  }
}

/*
[info] Benchmark              Mode  Cnt           Score           Error  Units
[info] DeadCode.consume      thrpt   25   449021574.287 ±  42226393.048  ops/s
[info] DeadCode.dead         thrpt   25  3153048352.712 ± 248418830.765  ops/s
[info] DeadCode.returnValue  thrpt   25   456299739.895 ±  16099165.432  ops/s
*/
