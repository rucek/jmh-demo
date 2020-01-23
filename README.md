# Java Microbenchmarking Harness demo

The repository contains a simple example benchmark configured with annotations (`BasicBenchmark`) plus three examples of pitfalls to avoid when writing your own benchmarks:
- `LoopOptimization` (in Java, so that the compiler actually optimizes the loop) - notice how the throughput is independent of the number of iterations
- `DeadCode` - notice how the method with unused result outperforms those where the result is actually used 
- `ConstantFolding` - notice how using constants inside the tested methods can produce misleading results (the computation may actually never happen)

## Running

```
sbt "jmh:run <ClassName>"
``` 
e.g.
```
sbt "jmh:run LoopOptimization"
```

## Disclaimer
Never forget about the following when looking at the benchmark results:
```
[info] REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
[info] why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
[info] experiments, perform baseline and negative tests that provide experimental control, make sure
[info] the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
[info] Do not assume the numbers tell you what you want them to tell.
```