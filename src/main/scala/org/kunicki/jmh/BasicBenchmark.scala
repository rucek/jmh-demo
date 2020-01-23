package org.kunicki.jmh

import org.openjdk.jmh.annotations.{Benchmark, BenchmarkMode, Fork, Measurement, Mode, Scope, State, Warmup}
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.{Options, OptionsBuilder}

class BasicBenchmark {

  @Benchmark
  @BenchmarkMode(Array(Mode.AverageTime))
  @Warmup(iterations = 3, time = 2)
  @Fork(3)
  @Measurement(time = 5)
  def sum(): Int = {
    (1 to 1000).sum
  }
}

object BasicBenchmark extends App {
  private val options: Options = new OptionsBuilder().build()
  new Runner(options).run()
}
